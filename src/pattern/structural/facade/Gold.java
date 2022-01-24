package pattern.structural.facade;

public class Gold implements Credit {

    @Override
    public void showCredit() {
        System.out.println("La tarjeta Gold tiene un crédito de 5.000");
    }

}
