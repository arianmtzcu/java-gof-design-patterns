package pattern.creational.prototype;

/**
 * Created by arian on 24/12/2020.
 */
public interface ProtoTypeCard extends Cloneable {

   void getCard();

   // Si una clase no implementa la interfaz Cloneable y quiere hacer una copia a trevez del método clone -> se lanzará CloneNotSupportedException...
   ProtoTypeCard clone() throws CloneNotSupportedException;

}
