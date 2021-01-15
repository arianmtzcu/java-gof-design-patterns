package pattern.behavioral.mediator;

/**
 * Created by arian on 15/01/2020.
 * Clase que implementa la interfaz mediator, la cual define la comunicación entre objetos.
 * Además que los conoce y los mantiene.
 */
public class ConcreteMediator implements Mediator {

   private ConcreteColleage1 user1; //usuario1 del chat

   private ConcreteColleage2 user2; //usuario2 del chat

   public void setUser1(ConcreteColleage1 colleage1) {
      this.user1 = colleage1;
   }

   public void setUser2(ConcreteColleage2 colleage2) {
      this.user2 = colleage2;
   }

   @Override
   public void send(String message, Colleage colleage) {
      //Implementar lógica de envío de mensaje...
      if (colleage.equals(user1)) {
         user1.messageRecived(message);
      } else if (colleage.equals(user2)) {
         user2.messageRecived(message);
      }
   }
}
