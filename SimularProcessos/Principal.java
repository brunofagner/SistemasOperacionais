import java.util.Random;

import processador.Processo;

public class Principal {
      public static void main(String[] args) {
            Processo processos[] = new Processo[10];
            int TNs[] = { 10000, 5000, 7000, 3000, 3000, 8000, 2000, 5000, 4000, 10000 };
            Random aleatorio = new Random();
            for (int i = 0; i < 10; i++) {
                  processos[i] = new Processo(i, TNs[i]);
            }
            for (int i = 0; i < TNs.length; i++) {
                  System.out.println(processos[i]);
            }
            int processoAtual = 0;
            while (true) {
                  if (processos[processoAtual].getTP() == processos[processoAtual].getTN()) {
                        if (processoAtual != 9)
                              processoAtual++;
                        else
                              processoAtual = 0;
                        continue;
                  } else if (processos[processoAtual].getEP() == "BLOQUEADO") {
                        int num = aleatorio.nextInt(100) + 1;
                        if (num < 31) {
                              System.out.println("BLOQUEADO >>> PRONTO");
                              processos[processoAtual].setEP("PRONTO");
                        }
                        continue;

                  } else if (processos[processoAtual].getEP() == "PRONTO") {
                        processos[processoAtual].setN_CPU();
                        processos[processoAtual].setEP("EXECUTANDO");
                        System.out.println("PRONTO >>> EXECUTANDO");
                        for (int i = 0; i < 1000; i++) {
                              if (processos[processoAtual].getTP() < processos[processoAtual].getTN()) {
                                    int num = aleatorio.nextInt(100) + 1;
                                    processos[processoAtual].setTP();
                                    processos[processoAtual].setCP();
                                    if (num < 6) {
                                          processos[processoAtual].setNES();
                                          processos[processoAtual].setEP("BLOQUEADO");
                                          System.out.println("PRONTO >>> BLOQUEADO");
                                          break;
                                    }

                              }
                        }
                        processos[processoAtual].setEP("PRONTO");
                        
                  }
                  System.out.println("O processo " + processos[processoAtual].getPID() + " completou seu ciclos");
                  System.out.println(processos[processoAtual]);
                  if (processoAtual != 9)
                        processoAtual++;
                  else
                        processoAtual = 0;

                  boolean geralFeito = true;
                  for (int i = 0; i < processos.length; i++) {
                        if (processos[i].getTP() < processos[i].getTN()) {
                              geralFeito = false;
                        }
                  }
                  if (geralFeito)
                        break;
            }
            for (int i = 0; i < processos.length; i++) {
                  System.out.println(processos[i]);
            }
      }
}
