package pattern.behavioral.visitor;

/**
 * Cada tarjeta de crédito tiene una oferta en gasolina y una en vuelos
 */
public interface CreditCardVisitor {

   void ofertaGasolina(OfertaGasolina ofertaGasolina);

   void ofertaVuelo(OfertaVuelo ofertaVuelo);
}
