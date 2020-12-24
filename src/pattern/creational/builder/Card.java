package pattern.creational.builder;

/**
 * Created by arian on 24/12/2020.
 */
public class Card {

   private final String cardType;

   private final String number;

   private final String name;

   private final int expires;

   private final boolean credit;

   // OJO: Constructor privado para no tener acceso...
   private Card(CardBuilder builder) {
      this.cardType = builder.cardType;
      this.number = builder.number;
      this.name = builder.name;
      this.expires = builder.expires;
      this.credit = builder.credit;
   }

   //Se implementan solo los Getter para prover inmutabilidad al objeto...
   public String getCardType() {
      return cardType;
   }

   public String getNumber() {
      return number;
   }

   public String getName() {
      return name;
   }

   public int getExpires() {
      return expires;
   }

   public boolean isCredit() {
      return credit;
   }

   @Override
   public String toString() {
      return "Card{" + "cardType='" + cardType + '\'' + ", number='" + number + '\'' + ", name='" + name + '\'' + ", expires=" + expires + ", credit="
            + credit + '}';
   }

   public static class CardBuilder {

      private final String cardType;

      private final String number;

      private String name;

      private int expires;

      private boolean credit;

      public CardBuilder(String cardType, String number) {
         this.cardType = cardType;
         this.number = number;
         //Los restantes atributos son opcionales...
      }

      public CardBuilder name(String name) {
         this.name = name;
         return this;
      }

      public CardBuilder expires(int expires) {
         this.expires = expires;
         return this;
      }

      public CardBuilder credit(boolean credit) {
         this.credit = credit;
         return this;
      }

      public Card build() {
         return new Card(this);
      }
   }
}
