package pattern.behavioral.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arian on 18/01/2020.
 */
public class Carataker {

   //Lista de articulos salvados para poder recuperar el que se necesite
   List<ArticleMemento> estados = new ArrayList<>();

   public void addMemento(ArticleMemento memento) {
      estados.add(memento);
   }

   public ArticleMemento getMemento (int index) {
      return estados.get(index);
   }
}
