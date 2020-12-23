package pattern.creational.factorymethod;

/**
 * Created by arian on 23/12/2020.
 */
public class PaymentFactory {

   public static Payment buildPayment(TypePayment typePayment) {
      switch (typePayment) {
         case GOOGLEPAYMENT:
            return new GooglePayment();
         case CARD:
            return new CardPayment();
         default: return new CardPayment();
      }
   }
}
