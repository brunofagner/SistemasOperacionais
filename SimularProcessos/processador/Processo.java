package processador;

public class Processo {
      int PID = 0;
      int TP = 0;
      int TN = 0;
      int CP = 1;
      String EP = "PRONTO";
      int NES = 0;
      int N_CPU = 0;

      public Processo(int PID, int TP, int CP, String EP, int NES, int N_CPU){
            this.PID = PID;
            this.TP = TP;
            this.CP = CP;
            this.EP = EP;
            this.NES = NES;
            this.N_CPU = N_CPU;
      }
      public Processo(int PID, int TN){
            this.PID = PID;
            this.TN = TN;
      }
      public void setPID(int pID) {
            PID = pID;
      }
      public int getPID() {
            return PID;
      }
      public void setTP() {
            TP++;
      }
      public int getTP() {
            return TP;
      }
      public int getTN() {
            return TN;
      }
      public void setCP() {
            CP++;
      }
      public int getCP() {
            return CP;
      }
      public void setEP(String eP) {
            EP = eP;
      }
      public String getEP() {
            return EP;
      }
      public void setNES() {
            this.NES++;
      }
      public int getNES() {
            return NES;
      }
      public void setN_CPU() {
            N_CPU++;
      }
      public int getN_CPU() {
            return N_CPU;
      }

      @Override
      public String toString() {
            return "|"+this.PID  +
                   "|"+this.TP   +
                   "|"+this.CP   +
                   "|"+this.EP   +
                   "|"+this.NES  +
                   "|"+this.N_CPU+
                   "|";
      }
}
