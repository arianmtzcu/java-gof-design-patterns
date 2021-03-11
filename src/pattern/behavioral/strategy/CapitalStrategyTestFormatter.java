package pattern.behavioral.strategy;

public class CapitalStrategyTestFormatter implements StrategyTextFormatter {

   @Override
   public void format(String text) {
      System.out.println("CapitalStrategyTestFormatter: " + text.toUpperCase());
   }
}
