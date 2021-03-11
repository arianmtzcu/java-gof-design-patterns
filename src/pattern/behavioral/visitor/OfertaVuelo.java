package pattern.behavioral.visitor;

public class OfertaVuelo implements OfertaElement {

   @Override
   public void accept(CreditCardVisitor visitor) {
      visitor.ofertaVuelo(this);
   }
}
