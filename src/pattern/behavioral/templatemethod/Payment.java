package pattern.behavioral.templatemethod;

public abstract class Payment {

   abstract void initialize();

   abstract void startPayment();

   abstract void endPayment(); //Sirve para notificar la realizacion del pago

   // Este metodo debe ser final puesto que nadie debería implementarlo ni cambiar el orden de los pasos.
   public final void makePayment() {
      initialize();
      startPayment();
      endPayment();
   }
}
