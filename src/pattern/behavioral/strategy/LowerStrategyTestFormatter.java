package pattern.behavioral.strategy;

public class LowerStrategyTestFormatter implements StrategyTextFormatter {

   @Override
   public void format(String text) {
      System.out.println("LowerStrategyTestFormatter: " + text.toLowerCase());
   }
}
