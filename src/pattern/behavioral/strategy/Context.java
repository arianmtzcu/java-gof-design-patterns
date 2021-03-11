package pattern.behavioral.strategy;

public class Context {

   private final StrategyTextFormatter strategyTextFormatter;

   public Context(StrategyTextFormatter strategyTextFormatter) {
      this.strategyTextFormatter = strategyTextFormatter;
   }

   public void publishText(String text) {
      strategyTextFormatter.format(text);
   }
}
