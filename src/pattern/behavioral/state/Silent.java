package pattern.behavioral.state;

public class Silent implements MobileAlertState {

   @Override
   public void alert(MobileAlertStateContext context) {
      //Quitar el sonido y la vibracion, permitiendo solo el encendido de la pantalla
      System.out.println("Cell: Silent... Pantalla Iluminada... ZZZzzz... ");
   }
}
