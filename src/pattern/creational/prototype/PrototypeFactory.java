package pattern.creational.prototype;

import static pattern.creational.prototype.PrototypeFactory.CartType.AMEX;
import static pattern.creational.prototype.PrototypeFactory.CartType.VISA;

import java.util.HashMap;
import java.util.Map;

public class PrototypeFactory {

   public static class CartType {
      public static final String VISA = "visa";
      public static final String AMEX = "amex";
   }

   private static final Map<String, ProtoTypeCard> prototypes = new HashMap<>();

   public static ProtoTypeCard getInstance(final String type) throws CloneNotSupportedException {
      return prototypes.get(type).clone();
   }

   //Cargar las tarjetas con la configuración que queremos... CLONAR es mucho más rápido y eficiente que CREAR
   public static void loadCard() {
      Visa visa = new Visa();
      Amex amex = new Amex();

      //Por lo general se tienen muchos atributos y la configuración del objeto es bastante compleja...
      visa.setName("Esta tarjeta es VISA con numero 0001");
      prototypes.put(VISA, visa);

      amex.setName("Esta tarjeta es AMEX con numero 0002");
      prototypes.put(AMEX, amex);
   }
}
