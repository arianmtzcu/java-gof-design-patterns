package pattern.creational.abstractfactory;

/**
 * Created by arian on 23/12/2020.
 */
public interface AbstractFactory<T> {

   T create(String type);

}
