package pattern.behavioral.chainofresponsibility;

public class Gold implements ApproveLoanChain {

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
      /**
       * Incluir aquí toda la lógica que se desea chequear para otorgar la tarjeta de crédito
       * - Solicitar nómina, antiguedad laboral, ...
       */
      if(totalLoan <= 10000) {
         //Algoritmo que concede el crédito...
         System.out.println("Esta solicitud de tarjeta de crédito la maneja la tarjeta Gold");
      }
      else {
         // Invocar al proximo elemento en la cadena de responsabilidad --> Platinium
         next.crediCardRequest(totalLoan);
      }
   }
}
