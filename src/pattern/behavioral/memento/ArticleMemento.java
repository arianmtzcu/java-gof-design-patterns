package pattern.behavioral.memento;

/**
 * Created by arian on 18/01/2020.
 */
public class ArticleMemento {

   //Se declaran solamente las variables que se necesitan guardar... por lo general no se salvan valores constantes!
   private String autor;
   private String text;

   public ArticleMemento(String autor, String text) {
      this.autor = autor;
      this.text = text;
   }

   public String getAutor() {
      return autor;
   }

   public void setAutor(String autor) {
      this.autor = autor;
   }

   public String getText() {
      return text;
   }

   public void setText(String text) {
      this.text = text;
   }
}
