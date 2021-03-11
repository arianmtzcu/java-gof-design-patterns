package pattern.behavioral.visitor;

/**
 * Tarjeta Classic ofrece un descuento inferior a la Black (nivel superior en el banco)
 */
public class ClassicCreditCardVisitor implements CreditCardVisitor {

   @Override
   public void ofertaGasolina(OfertaGasolina ofertaGasolina) {
      System.out.println("Descuento del 3% en Gasolina con tú tarjeta clásica.");
   }

   @Override
   public void ofertaVuelo(OfertaVuelo ofertaVuelo) {
      System.out.println("Descuento del 5% en Boleto de Vuelo con tú tarjeta clásica.");
   }
}
