package pattern.behavioral.command;

/**
 * Created by arian on 14/01/2020.
 */
public class CreditCardInvoker {

   private Command command;

   public CreditCardInvoker() {}

   public void setCommand(Command command) {
      this.command = command;
   }

   public void run() {
      command.execute();
   }
}
