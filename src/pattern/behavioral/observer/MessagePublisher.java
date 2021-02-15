package pattern.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class MessagePublisher implements Subject {

   private final List<Observer> observers = new ArrayList<>();

   @Override
   public void attach(Observer o) {
      observers.add(o);
   }

   @Override
   public void dettach(Observer o) {
      observers.remove(o);
   }

   @Override
   public void notifyUpdate(Semaforo semaforo) {
      for (Observer o : observers) {
         o.update(semaforo);           //notificarle a todos los observadores que cambió el semáforo
      }
   }
}
