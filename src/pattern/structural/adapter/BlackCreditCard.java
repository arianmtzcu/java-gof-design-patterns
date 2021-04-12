package pattern.structural.adapter;

public class BlackCreditCard implements Secure {

   @Override
   public void payWithSecureLevelA() {
      System.out.println("Tarjeta Black: Pagando con Seguridad ALTA, Nivel-A");
   }

   @Override
   public void payWithSecureLevelZ() {
      //No implementar
   }
}
