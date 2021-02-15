package pattern.behavioral.state;

public class Vibration implements MobileAlertState {

   @Override
   public void alert(MobileAlertStateContext context) {
      //Implementar lo que debería hacer el cell para activar el modo Vibrando...
      System.out.println("Cell: Vibrando... Vibrando... Vibrando...");
   }
}
