package pattern.behavioral.iterator;

/**
 * Created by arian on 15/01/2020.
 */
public interface Iterator {

   boolean hasNext();

   Object next();

   // Por lo general se agregan más métodos, dependiendo de las necesidades del iterador
   Object currentItem();
}
