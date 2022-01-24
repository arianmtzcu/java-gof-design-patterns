package pattern.structural.decorator;

/**
 * Clase que va a añadir esas funcionalidades adicionales que queriamos para nuestro Credit
 */
public class InternationalPaymentDecorator extends CreditDecorator {

    public InternationalPaymentDecorator(Credit decoratedCredit) {
        super(decoratedCredit);
    }

    @Override
    public void showCredit() {
        super.showCredit();
        configInternationalPayment();
    }

    private void configInternationalPayment() {
        System.out.println("La tarjeta ha sido configurada para hacer pagos internacionales...");
    }
}
