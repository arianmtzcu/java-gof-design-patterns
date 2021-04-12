package pattern.structural.adapter;

public class CreditCard implements Payment {

   Adapter adapter;

   @Override
   public void pay(String type) {
      if (type.equals("classic")) { //classic --> tarjeta que no tenemos, tarjeta por defecto
         System.out.println("Tarjeta Classic: Pagando sin ningún tipo de Seguridad!");
      } else if (type.equals("gold")) {
         adapter = new Adapter("gold");
         adapter.pay("gold");
      } else if (type.equals("black")) {
         adapter = new Adapter("black");
         adapter.pay("black");
      } else {
         System.out.println("No se puede hacer el pago - No se reconoce ese tipo de tarjeta: " + type);
      }
   }
}
