package pattern.behavioral.mediator;

/**
 * Created by arian on 15/01/2020.
 * Clase donde se define el comportamiento que debe adoptar cada objeto que interactua en la clase intermedia.
 * Comportamiento para comunicarse con el Mediator de una manera standar.
 */
public abstract class Colleage {

   protected Mediator mediator;

   public Colleage(Mediator mediator) {
      this.mediator = mediator;
   }

   public abstract void send(String message);

   public abstract void messageRecived(String message);

}
