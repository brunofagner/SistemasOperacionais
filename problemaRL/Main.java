import java.util.Random;
import java.util.ArrayList;

public class Main {
      static ArrayList<String> buffer = new ArrayList<String>();
      static int full = 0, empty = 4, nprocess = 1, chance;
      static boolean mutex = true;
      static Random num = new Random();
      static Produtor produtor = new Produtor();
      static Consumidor consumidor = new Consumidor();

      public static void main(String[] args) {

            for (int i = 0; i < 10; i++) {
                  if (produtor.situacao == 'W') produtor.run();
                  else System.out.println("Produtor está a mimir.");

                  if (consumidor.situacao == 'W') consumidor.run();
                  else System.out.println("Consumidor está a mimir.");
                  try {
                        Thread.sleep(1000);
                  } catch (Exception e){ e.printStackTrace();}
            }
            produtor.situacao = 'S';
            while(empty < 4) consumidor.run();
      }

      static public class Produtor extends Thread {
            public char situacao = 'W';
            public char estado = 'S';

            @Override
            public void run() {
                  int chance = num.nextInt(100) + 1;
                  if(full == 3){
                        situacao = 'S';
                        System.out.println("Buffer Cheio, produtor ira dormir!");
                        consumidor.situacao = 'W';
                  }else if(chance > 50 && mutex) {
                        produzir();
                  }else if(chance <=50){
                        System.out.println("Nenhum processo foi chamado");
                  }else System.out.println("Produtor não pode usar, pois o Consumidor está usando");
            }

            public void produzir() {
                  estado = 'E';
                  empty--;
                  mutex = false;
                  buffer.add("P" + nprocess);
                  System.out.println("Processo P" + nprocess + " colocado no buffer");
                  nprocess++;
                  mutex = true;
                  consumidor.situacao = 'W';
                  full++;
                  estado = 'P';
            }

      }

      static public class Consumidor extends Thread {
            public char situacao = 'W';
            public char estado = 'S';

            @Override
            public void run() {
                  int chance = num.nextInt(100) + 1;
                  if(empty == 4){ 
                        situacao = 'S';
                        System.out.println("Buffer vazio, Consumidor ira mimir!"); 
                  }else if(chance > 50 && mutex) {
                        consumir();
                  }else if(chance <= 50)System.out.println("Nenhum processo foi consumido"); 
                   else System.out.println("Consumidor não pode usar, pois o Produtor está usando");
            }

            public void consumir() {
                  estado = 'E';
                  full--;
                  mutex = false;
                  System.out.println("Processo " + buffer.remove(full) + " retirado do buffer");
                  mutex = true;
                  empty++;
                  produtor.situacao = 'W';
                  estado = 'P';
            }
      }

}
