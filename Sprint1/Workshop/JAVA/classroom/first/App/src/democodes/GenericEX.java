class DisplayInt {
    Integer num;

      public DisplayInt(Integer num) {
              this.num = num;
      }

      public void display() {
              System.out.println("The number is: " + num);
      }
  }
class DisplayDouble {
      Double num;

      public DisplayDouble(Double num) {
              this.num = num;
      }

      public void display() {
              System.out.println("The number is: " + num);
      }
}
public class basics{
      public static void main(String[] args) {
              DisplayInt i = new DisplayInt(10);
              i.display();
              DisplayDouble d = new DisplayDouble(10.5);
              d.display();
      }
}

public class GenericEx{

    public static void main(String[] args) {
        // Generic Class
        // Generic class is a class that can work with other objects.
        DisplayInteger i1 = new DisplayInteger(1);
        i1.display
    }
}