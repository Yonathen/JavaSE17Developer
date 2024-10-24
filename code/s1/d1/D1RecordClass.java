package s1.d1;

import java.time.LocalDate;
import java.util.List;

record Merchant(String name) {}

record Sales(LocalDate date, double value) {}

record Rectangle(double length, double width) {
  // 2. Canonical constructor of a class
  public Rectangle(double length, double width) {
    if ( length <= 0 ) {
      throw new IllegalArgumentException("Length can not be less than 0");
    } else if (width <= 0 ) {
      throw new IllegalArgumentException("Width can not be less than 0");
    }

    this.length = length;
    this.width = width;
  }

  // 3. Explicit declaration of Record class Members
  static double goldenRatio;

  // Static Initializers
  static {
    goldenRatio = (1 + Math.sqrt(5)) / 2;
  }

  public static Rectangle createGoldenRatioRectangle(double length) {
    return new Rectangle(length, length * goldenRatio);
  }

  // 4. Nesting a Record class
  record RotationAngle(double angle) {
    public RotationAngle {
      angle = Math.toRadians(angle);
    }
  }

  public Rectangle getRotatedRectangle(double angle) {
    RotationAngle ra = new RotationAngle(angle);
    double x = Math.abs(length * Math.cos(ra.angle())) + Math.abs(width * Math.sin(ra.angle()));
    double y = Math.abs(width * Math.cos(ra.angle())) + Math.abs(length * Math.sin(ra.angle()));

    return new Rectangle(x, y);
  }
}

public class D1RecordClass {
  public static void printRectangle(String label, Rectangle rec) {
    System.out.printf("%s : Length = %s, Width = %s \n", label, rec.length(), rec.width());
  }

  public static void performRectangleActions() {
    // 1. Creating a Rectangel
    Rectangle r1 = new Rectangle(225, 225);

    // 1.1 Check the methods of Rectangle Record
    printRectangle("R1", r1);
    System.out.printf("R1 : Hash Code = %s, ToString = %s \n", r1.hashCode(), r1.toString());

    // 2.1 Test width and length with illegal arguments
    // Rectangle r2 = new Rectangle(-12, 23);
    // Rectangle r3 = new Rectangle(12, -23);
    Rectangle r4 = new Rectangle(12, 23);
    printRectangle("R4", r4);

    // 3.1 Creating a rectangle with golden ratio rule
    Rectangle r5 = Rectangle.createGoldenRatioRectangle(45);
    printRectangle("R5", r5);

    // 4.1 Get rotated rectangle
    Rectangle r6 = new Rectangle(100, 100);
    Rectangle r7 = r6.getRotatedRectangle(30);
    printRectangle("R6", r6);
    printRectangle("R7", r7);
  }

  public static void performLocalRecord() {
    // 5. Using local record 
    record User(String name, int age) {}

    List<User> users = List.of(
      new User("Tom", 20),
      new User("Jhon", 28),
      new User("Mark", 30),
      new User("Linda", 24)
    );

    users.forEach(user -> System.out.printf("%s is %d \n", user.name(), user.age()));
  }

  public static void main(String[] args) {
    System.err.println("\n Rectangle \n =================");
    performRectangleActions();
    System.err.println("\n Users age list \n =================");
    performLocalRecord();
  }
}
