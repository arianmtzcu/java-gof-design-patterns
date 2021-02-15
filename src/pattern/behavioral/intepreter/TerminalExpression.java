package pattern.behavioral.intepreter;

public class TerminalExpression implements Expression {

   private final String text;

   public TerminalExpression(String text) {
      this.text = text;
   }

   @Override
   public boolean interpret(String context) {
      return context.contains(text);
   }
}
