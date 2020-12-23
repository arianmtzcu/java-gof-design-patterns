package pattern.creational.abstractfactory;

/**
 * Created by arian on 23/12/2020.
 */
public class FactoryProvider {

   public static AbstractFactory getFactory(String chooseFactory) {
      if ("Card".equals(chooseFactory)) {
         return new CardFactory();
      } else if ("PaymentMehod".equals(chooseFactory)) {
         return new PaymentMethodFactory();
      }
      return null;
   }
}
