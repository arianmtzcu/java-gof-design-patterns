package pattern.behavioral.chainofresponsibility;

/**
 * Clase que se va a encargar de organizar la cadena de responsabilidad
 * Para el cliente la clase Tarjeta será el punto de entrada
 */
public class Tarjeta implements ApproveLoanChain {

   private ApproveLoanChain next;

   @Override
   public ApproveLoanChain getNext() {
      return next;
   }

   @Override
   public void setNext(ApproveLoanChain loan) {
      next = loan;
   }

   @Override
   public void crediCardRequest(int totalLoan) {
      //Configurando aquí la cadena de responsabilidad
      Gold gold = new Gold();
      this.setNext(gold);

      Platinium platinium = new Platinium();
      gold.setNext(platinium);

      Black black = new Black();
      platinium.setNext(black);

      next.crediCardRequest(totalLoan);
   }
}
