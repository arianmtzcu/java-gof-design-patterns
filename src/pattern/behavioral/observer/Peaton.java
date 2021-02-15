package pattern.behavioral.observer;

public class Peaton implements Observer {

   @Override
   public void update(Semaforo semaforo) {   //Método que se ejecuta al cambiar el semáforo!
      if(semaforo.getStatus().equals("ROJO_COCHE")) {       //ROJO_COCHE == VERDE_PEATON
         System.out.println("Semaforo Verde para Peaton -> Peaton SI puede pasar!");
      }
      else {
         System.out.println("Semaforo Rojo para Peaton -> Peaton NO puede pasar!");
      }
   }
}
