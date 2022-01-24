package pattern.structural.decorator;

/**
 * Clase que va a añadir esas funcionalidades adicionales que queriamos para nuestro Credit
 */
public class SecureDecorator extends CreditDecorator {

    public SecureDecorator(Credit decoratedCredit) {
        super(decoratedCredit);
    }

    @Override
    public void showCredit() {
        super.showCredit();
        configSecure();
    }

    private void configSecure() {
        System.out.println("La tarjeta ha sido configurada con Seguridad Máxima");
    }

}
