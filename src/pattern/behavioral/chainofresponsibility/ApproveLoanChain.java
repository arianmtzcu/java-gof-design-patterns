package pattern.behavioral.chainofresponsibility;

/**
 * Created by arian on 14/01/2020.
 * <p>
 * Cadena para aprobar nuestra tarjeta de crédito...
 */
public interface ApproveLoanChain {

   ApproveLoanChain getNext();

   void setNext(ApproveLoanChain loan);

   //Método donde se analiza si se puede dar la tarjeta de crédito o no a partir del total de crédito solicitado?
   void crediCardRequest(int totalLoan);
}
