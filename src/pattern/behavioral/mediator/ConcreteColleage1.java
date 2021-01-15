package pattern.behavioral.mediator;

/**
 * Created by arian on 15/01/2020.
 */
public class ConcreteColleage1 extends Colleage {

   public ConcreteColleage1(Mediator mediator) {
      super(mediator);
   }

   @Override
   public void send(String message) {
      mediator.send(message, this);
   }

   @Override
   public void messageRecived(String message) {
      System.out.println("User1 ha recibido el siguiente mensaje: " + message);
   }
}
