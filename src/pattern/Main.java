package pattern;

import pattern.creational.abstractfactory.AbstractFactory;
import pattern.creational.abstractfactory.Card;
import pattern.creational.abstractfactory.FactoryProvider;
import pattern.creational.abstractfactory.PaymentMethod;
import pattern.creational.factorymethod.Payment;
import pattern.creational.factorymethod.PaymentFactory;
import pattern.creational.factorymethod.TypePayment;

public class Main {

   public static void main(String[] args) {
      probarFactoryMethod();
      System.out.println("-----------------");
      probarAbstractFactory();
      System.out.println("-----------------");
   }

   private static void probarFactoryMethod() {
      Payment payment = PaymentFactory.buildPayment(TypePayment.CARD);
      payment.doPayment();
   }

   private static void probarAbstractFactory() {
      AbstractFactory abstractFactory = FactoryProvider.getFactory("Card");
      Card tarjeta = (Card) abstractFactory.create("VISA");

      AbstractFactory abstractFactory1 = FactoryProvider.getFactory("PaymentMehod");
      PaymentMethod paymentMethod = (PaymentMethod) abstractFactory1.create("DEBIT");

      System.out.println("Una tajeta de tipo: " + tarjeta.getCardType() + " con el metodo de pago: " + paymentMethod.doPayment());
   }
}
