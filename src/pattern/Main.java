package pattern;

import static pattern.creational.prototype.PrototypeFactory.CartType.AMEX;
import static pattern.creational.prototype.PrototypeFactory.CartType.VISA;

import pattern.behavioral.chainofresponsibility.Tarjeta;
import pattern.behavioral.command.CreditCard;
import pattern.behavioral.command.CreditCardActivateCommand;
import pattern.behavioral.command.CreditCardDesactivateCommand;
import pattern.behavioral.command.CreditCardInvoker;
import pattern.behavioral.intepreter.AndExpression;
import pattern.behavioral.intepreter.Expression;
import pattern.behavioral.intepreter.OrExpression;
import pattern.behavioral.intepreter.TerminalExpression;
import pattern.behavioral.iterator.CardList;
import pattern.behavioral.iterator.Iterator;
import pattern.behavioral.iterator.List;
import pattern.behavioral.mediator.ConcreteColleage1;
import pattern.behavioral.mediator.ConcreteColleage2;
import pattern.behavioral.mediator.ConcreteMediator;
import pattern.behavioral.memento.Article;
import pattern.behavioral.memento.ArticleMemento;
import pattern.behavioral.memento.Carataker;
import pattern.behavioral.observer.Coche;
import pattern.behavioral.observer.MessagePublisher;
import pattern.behavioral.observer.Peaton;
import pattern.behavioral.observer.Semaforo;
import pattern.behavioral.state.MobileAlertStateContext;
import pattern.behavioral.state.Silent;
import pattern.behavioral.state.Vibration;
import pattern.behavioral.strategy.CapitalStrategyTestFormatter;
import pattern.behavioral.strategy.Context;
import pattern.behavioral.strategy.LowerStrategyTestFormatter;
import pattern.behavioral.templatemethod.Paypal;
import pattern.behavioral.templatemethod.Visa;
import pattern.behavioral.visitor.BlackCreditCardVisitor;
import pattern.behavioral.visitor.ClassicCreditCardVisitor;
import pattern.behavioral.visitor.OfertaElement;
import pattern.behavioral.visitor.OfertaGasolina;
import pattern.behavioral.visitor.OfertaVuelo;
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
      System.out.println("---------------------------------");
      System.out.println("\n---------- Iterator -----------");
      probarIterator();
      System.out.println("---------------------------------");
      System.out.println("\n---------- Mediator -----------");
      probarMediator();
      System.out.println("---------------------------------");
      System.out.println("\n---------- Memento -----------");
      probarMemento();
      System.out.println("---------------------------------");
      System.out.println("\n---------- Observer -----------");
      probarObserver();
      System.out.println("---------------------------------");
      System.out.println("\n---------- State -----------");
      probarState();
      System.out.println("---------------------------------");
      System.out.println("\n---------- Intepreter -----------");
      probarInterpreter();
      System.out.println("---------------------------------");
      System.out.println("\n---------- Strategy -----------");
      probarStrategy();
      System.out.println("---------------------------------");
      System.out.println("\n------- Template Method --------");
      probarTemplateMethod();
      System.out.println("---------------------------------");
      System.out.println("\n----------- Visitor ------------");
      probarVisitor();
      System.out.println("---------------------------------");
      System.out.println("\n----------- Adapter ------------");
      probarAdapter();
      System.out.println("---------------------------------");
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

   private static void probarIterator() {
      pattern.behavioral.iterator.Card[] cards = new pattern.behavioral.iterator.Card[5];
      cards[0] = new pattern.behavioral.iterator.Card("VISA");
      cards[1] = new pattern.behavioral.iterator.Card("AMEX");
      cards[2] = new pattern.behavioral.iterator.Card("MASTER CARD");
      cards[3] = new pattern.behavioral.iterator.Card("GOOGLE CARD");
      cards[4] = new pattern.behavioral.iterator.Card("APPLE CARD");

      List lista = new CardList(cards);
      Iterator iterator = lista.iterator();

      while (iterator.hasNext()) {
         pattern.behavioral.iterator.Card tarjeta = (pattern.behavioral.iterator.Card) iterator.next();
         System.out.println(tarjeta.getType());
      }
   }

   private static void probarMediator() {
      ConcreteMediator mediator = new ConcreteMediator();
      ConcreteColleage1 user1 = new ConcreteColleage1(mediator);
      ConcreteColleage2 user2 = new ConcreteColleage2(mediator);

      mediator.setUser1(user1);
      mediator.setUser2(user2);

      user1.send("Hola soy user1!");
      user2.send("Hola user1, soy user2!");
   }

   private static void probarMemento() {
      Carataker carataker = new Carataker();

      //Creando artículo original
      Article article = new Article("Arian", "Memento es una película");
      article.setText(article.getText() + "de Nolan");
      System.out.println(article.getText());
      //Creando estado 1
      carataker.addMemento(article.crearMemento());

      article.setText(article.getText() + " protagonizada por Guy Pearcy");
      System.out.println(article.getText());
      //Creando estado 2
      carataker.addMemento(article.crearMemento());

      article.setText(article.getText() + " y Leonardo DiCaprio");
      System.out.println(article.getText());

      ArticleMemento memento1 = carataker.getMemento(0);
      ArticleMemento memento2 = carataker.getMemento(1);

      //Recuperando estado 1
      article.restoreMemento(memento1);
      System.out.println(article.getText());

      //Recuperando estado 2
      article.restoreMemento(memento2);
      System.out.println(article.getText());

      article.setText(article.getText() + " en el año 2021?");
      System.out.println(article.getText());
   }

   private static void probarObserver() {
      Coche coche = new Coche();
      Peaton peaton = new Peaton();
      MessagePublisher messagePublisher = new MessagePublisher();

      messagePublisher.attach(coche);
      messagePublisher.attach(peaton);
      final String ROJO_COCHE = "ROJO_COCHE";
      messagePublisher.notifyUpdate(new Semaforo(ROJO_COCHE));

      try { //Simulando la espera de 2segudndo para hacer el cambio de luces de ROJO a Verde
         System.out.println(">>>>>> ESPERANDO 2S PARA EL CAMBIO DE LUZ >>>>>>");
         Thread.sleep(2000);
      } catch (InterruptedException e) {
         e.printStackTrace();
      }

      final String VERDE_COCHE = "VERDE_COCHE";
      messagePublisher.notifyUpdate(new Semaforo(VERDE_COCHE));
   }

   private static void probarState() {
      //El context maneja una instancia del estado actual
      MobileAlertStateContext context = new MobileAlertStateContext();
      context.alert();
      context.alert();
      //Brindar opción al usuario para cambiar el estado de Vibración
      context.setCurrentState(new Vibration());
      context.alert();
      context.alert();
      //Brindar opción al usuario para cambiar el estado de Silencio
      context.setCurrentState(new Silent());
      context.alert();
      context.alert();
   }

   private static void probarInterpreter() {
      Expression cero = new TerminalExpression("0");
      Expression uno = new TerminalExpression("1");

      Expression containBoolean = new OrExpression(cero, uno);
      Expression containOnceAndCero = new AndExpression(cero, uno);

      System.out.println(containBoolean.interpret("cero"));       //false: Debe devolver falso, porque en "cero" ---> debería contener 0 o 1
      System.out.println(containBoolean.interpret("0"));          //true
      System.out.println(containOnceAndCero.interpret("0"));      //false
      System.out.println(containOnceAndCero.interpret("0, 1"));   //true
      //Se pudieran añadir más reglas; para eso habría que construir más clases...
   }

   private static void probarStrategy() {
      Context context1 = new Context(new CapitalStrategyTestFormatter());
      context1.publishText("Este texto sera convertido a mayuscula a traves del algoritmo definido como estrategia!");

      Context context2 = new Context(new LowerStrategyTestFormatter());
      context2.publishText("Este texto sera convertido a minusculas a traves del algoritmo definido como estrategia!");
   }

   private static void probarTemplateMethod() {
      pattern.behavioral.templatemethod.Payment payment = new Visa();
      payment.makePayment();

      payment = new Paypal();
      payment.makePayment();
   }

   private static void probarVisitor() {
      OfertaElement ofertaElement = new OfertaGasolina();
      ofertaElement.accept(new BlackCreditCardVisitor());

      ofertaElement = new OfertaVuelo();
      ofertaElement.accept(new ClassicCreditCardVisitor());
   }

   private static void probarAdapter() {
      pattern.behavioral.adapter.CreditCard creditCard = new pattern.behavioral.adapter.CreditCard();
      creditCard.pay("classic");
      creditCard.pay("gold");
      creditCard.pay("black");
      creditCard.pay("silver");
   }
}
