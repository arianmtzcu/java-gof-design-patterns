package pattern.behavioral.state;

public class MobileAlertStateContext {

   private MobileAlertState currentState;  //Estado actual [modo sonido, modo vibración, modo silencio, modo avion, ...]

   public MobileAlertStateContext() {
      this.currentState = new Sound();    //Estableciendo el estado por defecto de Sonido!, aunque pudise configurarse como Vibración o Silencio
   }

   public void setCurrentState(MobileAlertState state) {
      this.currentState = state;
   }

   public void alert() {
      currentState.alert(this);
   }
}
