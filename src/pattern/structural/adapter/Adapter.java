package pattern.structural.adapter;

//Permite adaptar la interfaz Payment y Secure!
public class Adapter implements Payment {

   Secure secureCreditCard;

   public Adapter(String type) {
      if(type.equals("black")) {
         this.secureCreditCard = new BlackCreditCard();
      } else {
         this.secureCreditCard = new GoldCreditCard();
      }
   }

   @Override
   public void pay(String type) {
      if(type.equals("black")) {
         secureCreditCard.payWithSecureLevelA();
      } else {
         secureCreditCard.payWithSecureLevelZ();
      }
   }
}
