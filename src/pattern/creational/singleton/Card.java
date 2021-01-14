package pattern.creational.singleton;

import java.util.Objects;

/**
 * Created by arian on 14/01/2020.
 */
public class Card {

   private static Card INSTANCE;

   private String cardNumber;

   private Card() {

   }

   //synchronized: Nos evita que si tenemos dos hilos que se entre dos veces a la vez y se nos creen
   //dos instancias... [Asegura que solo se cree una instancia]
   public synchronized static Card getINSTANCE() {
      if(Objects.isNull(INSTANCE)) {
         INSTANCE = new Card();
      }
      return INSTANCE;
   }

   public String getCardNumber() {
      return cardNumber;
   }

   public void setCardNumber(String cardNumber) {
      this.cardNumber = cardNumber;
   }
}
