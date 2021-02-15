package pattern.behavioral.observer;

public interface Subject {

   void attach(Observer o);      //Adjuntar nuevo observer

   void dettach(Observer o);

   void notifyUpdate(Semaforo semaforo);

}
