package pattern.behavioral.iterator;

public class CardIterator implements Iterator {

   private final Card[] cards;

   private int position;

   public CardIterator(Card[] cards) {
      this.cards = cards;
      this.position = 0;
   }

   @Override
   public boolean hasNext() {
      return position < cards.length;
   }

   @Override
   public Object next() {
      return cards[position++];
   }

   @Override
   public Object currentItem() {
      return cards[position];
   }
}
