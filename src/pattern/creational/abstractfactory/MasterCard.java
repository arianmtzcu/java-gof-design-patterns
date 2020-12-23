package pattern.creational.abstractfactory;

public class MasterCard implements Card {

   @Override
   public String getCardNumber() {
      return "0000 0000 0000 MASTERCARD";
   }

   @Override
   public String getCardType() {
      return "MASTERCARD";
   }
}
