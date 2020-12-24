package pattern.creational.prototype;

public class Visa implements ProtoTypeCard {

   private String name;
   //... debería tener más atributos para que sean objetos complejos ...
   //... Objetos pesados, que por lo general tarda un poco su creación ...
   //... Objetos que demandan mucha memoria ...

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   @Override
   public void getCard() {
      System.out.println("Esto es una tarjeta VISA");
   }

   @Override
   public ProtoTypeCard clone() throws CloneNotSupportedException {
      System.out.println("Clonando tarjeta VISA ...");
      return (Visa) super.clone();
   }
}
