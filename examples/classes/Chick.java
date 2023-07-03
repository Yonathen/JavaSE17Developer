public class Chick {
  private String name = "Fluffy";
  { System.out.println("Setting Field"); }

  public Chick() {
    name = "Tiny";
    System.out.println("Setting Constructor");
  }

  public static void main(String[] args) {
    Chick c1 = new Chick();
    System.out.println(c1.name);
    { System.out.println("Method Code Block"); }
  }

}
