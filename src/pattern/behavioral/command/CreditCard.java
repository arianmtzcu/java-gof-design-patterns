package pattern.behavioral.command;

/**
 * Created by arian on 14/01/2020.
 */
public class CreditCard {

   public void sendPinNumberToCustomer() {
      System.out.println("El PIN number ha sido enviado al cliente.");
   }

   public void sendSMStoCustomerActivate() {
      System.out.println("Enviado SMS al cliente informando que su tarjeta ha sido activada.Ponte en contacto si no lo has recibido.");
   }

   public void activate() {
      System.out.println("La TARJETA ha sido ACTIVADA.");
   }

   public void desactivate() {
      System.out.println("La TARJETA ha sido DESACTIVADA.");
   }

   public void sendSMStoCustomerDesactivate() {
      System.out.println("Enviado SMS al cliente informando de que su tarjeta ha sido desactivada.");
   }
}
