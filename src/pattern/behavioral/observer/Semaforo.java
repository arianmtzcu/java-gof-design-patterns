package pattern.behavioral.observer;

public class Semaforo {

   public String status;         //3 estados, R, V, A

   public Semaforo(String status) {
      this.status = status;
   }

   public String getStatus() {
      return status;
   }
}
