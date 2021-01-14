package pattern.behavioral.command;

/**
 * Created by arian on 14/01/2020.
 */
public class CreditCardActivateCommand implements Command {

   CreditCard creditCard;

   public CreditCardActivateCommand(CreditCard creditCard) {
      this.creditCard = creditCard;
   }

   @Override
   public void execute() {
      creditCard.sendPinNumberToCustomer();
      creditCard.activate();
      creditCard.sendSMStoCustomerActivate();
   }
}
