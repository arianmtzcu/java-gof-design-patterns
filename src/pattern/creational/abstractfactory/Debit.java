package pattern.creational.abstractfactory;

public class Debit implements PaymentMethod {

   @Override
   public String doPayment() {
      return "Pago con débito";
   }
}
