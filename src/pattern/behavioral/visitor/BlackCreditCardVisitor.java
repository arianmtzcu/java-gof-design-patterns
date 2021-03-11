package pattern.behavioral.visitor;

/**
 * Tarjeta Black ofrece el superior descuento en el banco
 */
public class BlackCreditCardVisitor implements CreditCardVisitor {

   @Override
   public void ofertaGasolina(OfertaGasolina ofertaGasolina) {
      System.out.println("Descuento del 10% en Gasolina con tú tarjeta black.");
   }

   @Override
   public void ofertaVuelo(OfertaVuelo ofertaVuelo) {
      System.out.println("Descuento del 25% en Boleto de Vuelo con tú tarjeta black.");
   }
}
