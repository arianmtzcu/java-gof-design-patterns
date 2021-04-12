package pattern.structural.bridge;

public class UnsecureCreditCard implements ICreditCard {

   @Override
   public void realizarPago() {
      System.out.println("Pago realizado SIN SEGURIDAD!");
   }
}
