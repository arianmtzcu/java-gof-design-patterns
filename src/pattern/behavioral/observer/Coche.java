package pattern.behavioral.observer;

public class Coche implements Observer {

   @Override
   public void update(Semaforo semaforo) {
      if(semaforo.getStatus().equals("ROJO_COCHE")) {       //ROJO_COCHE == VERDE_PEATON
         System.out.println("Semaforo Rojo para Coche -> Coche NO puede pasar!");
      }
      else {
         System.out.println("Semaforo Verde para Coche -> Coche SI puede pasar!");
      }
   }
}
