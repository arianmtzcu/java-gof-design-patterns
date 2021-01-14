package pattern.behavioral.command;

/**
 * Created by arian on 14/01/2020.
 */
public class CreditCardDesactivateCommand implements Command {

   CreditCard creditCard;

   public CreditCardDesactivateCommand(CreditCard creditCard) {
      this.creditCard = creditCard;
   }

   @Override
   public void execute() {
      //Comandos que se deben ejecutar para desactivar una tarjeta de credito
      creditCard.desactivate();
      creditCard.sendSMStoCustomerDesactivate();
   }
}
