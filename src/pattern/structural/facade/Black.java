package pattern.structural.facade;

public class Black implements Credit {

    @Override
    public void showCredit() {
        System.out.println("La tarjeta Black tiene un crédito de 1.000.000");
    }

}
