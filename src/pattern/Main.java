package pattern;

import static pattern.creational.prototype.PrototypeFactory.CartType.AMEX;
import static pattern.creational.prototype.PrototypeFactory.CartType.VISA;

import pattern.behavioral.chainofresponsibility.Tarjeta;
import pattern.behavioral.command.CreditCard;
import pattern.behavioral.command.CreditCardActivateCommand;
import pattern.behavioral.command.CreditCardDesactivateCommand;
import pattern.behavioral.command.CreditCardInvoker;
import pattern.creational.abstractfactory.AbstractFactory;
import pattern.creational.abstractfactory.Card;
import pattern.creational.abstractfactory.FactoryProvider;
import pattern.creational.abstractfactory.PaymentMethod;
import pattern.creational.factorymethod.Payment;
import pattern.creational.factorymethod.PaymentFactory;
import pattern.creational.factorymethod.TypePayment;
import pattern.creational.prototype.ProtoTypeCard;
import pattern.creational.prototype.PrototypeFactory;
public class Main {

   public static void main(String[] args) {
      System.out.println(" --- PATRONES CREACIONALES ---");
      System.out.println("--------- Factory ----------");
      probarFactoryMethod();
      System.out.println("------------------------------");
      System.out.println("\n----- AbstractFactory ------");
      probarAbstractFactory();
      System.out.println("------------------------------");
      System.out.println("\n--------- Builder ----------");
      probarBuilder();
      System.out.println("------------------------------");
      System.out.println("\n-------- Prototype ---------");
      probarPrototype();
      System.out.println("-------------------------------");
      System.out.println("\n--------- Sigleton ----------");
      probarSingleton();
      System.out.println("-------------------------------\n\n");

      System.out.println("-- PATRONES DE COMPORTAMIENTO --");
      System.out.println("\n---- ChainOfResponsibility -----");
      probarChainOfResponsibility();
      System.out.println("--------------------------------");
      System.out.println("\n---------- Command -----------");
      probarCommand();
      System.out.println("---------------------------------\n\n");

      System.out.println("----- PATRONES ESTRUCTURALES -----");
      System.out.println("---------------------------------\n\n");
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

   private static void probarBuilder() {
      //Construyendo el objeto con la configuración que necesitamos...
      pattern.creational.builder.Card card = new pattern.creational.builder.Card.CardBuilder("VISA", "0000 1111 2222 3333")
            .name("Arián")
            .expires(2021)
            .build();
      System.out.println(card);

      pattern.creational.builder.Card card2 = new pattern.creational.builder.Card.CardBuilder("AMEX", "9999 9999 9999 9999").build();
      System.out.println(card2);
   }

   private static void probarPrototype() {
      PrototypeFactory.loadCard();
      try {
         ProtoTypeCard visa = PrototypeFactory.getInstance(VISA);
         visa.getCard();

         ProtoTypeCard amex = PrototypeFactory.getInstance(AMEX);
         amex.getCard();
      } catch (CloneNotSupportedException e) {
         e.printStackTrace();
      }
   }

   private static void probarSingleton() {
      pattern.creational.singleton.Card.getINSTANCE().setCardNumber("1234 1234 1234 1234");
      System.out.println(pattern.creational.singleton.Card.getINSTANCE().getCardNumber());
   }

   private static void probarChainOfResponsibility() {
      // Se puede convinar aquí con los patrones creacionales perfectamente, en este caso convinamos con el new clásico
      Tarjeta tarjeta = new Tarjeta();
      // Solicitar el monto de la tarjeta de crédito aquí, entre 0 y 1 000 000 ...
      tarjeta.crediCardRequest(100000); //Debería pasar por la Gold
   }

   private static void probarCommand() {
      CreditCard creditCardActivated = new CreditCard();
      CreditCard creditCardDesactivated = new CreditCard();

      CreditCardInvoker invoker = new CreditCardInvoker();

      invoker.setCommand(new CreditCardActivateCommand(creditCardActivated));
      invoker.run();
      System.out.println("-----------------------------------");
      invoker.setCommand(new CreditCardDesactivateCommand(creditCardDesactivated));
      invoker.run();
   }
}
