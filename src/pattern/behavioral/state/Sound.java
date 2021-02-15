package pattern.behavioral.state;

public class Sound implements MobileAlertState {

   @Override
   public void alert(MobileAlertStateContext context) {
      System.out.println("Cell: Sound... Ring... Ring... ");
   }
}
