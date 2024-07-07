# Record Class
- These are special kind of classes 
    - that help to model plain data aggregates with less ceremony than the normal class

- Specifies in a header a description of its contents
    - Then appropriate
        - accessors
        - constructors
        - equals
        - hashCode
        - toString
            - methods are created automatically.

- A record fields are final because the class is intended to serve as a simple "Data Carrier"

    ```java
    record Rectangle(double length, double width) {}
    ```

    - Are Equivalent with 

        ```java
        public final class Rectangle {
            private final double length;
            private final double width;

            public Rectangle(double length, double width) {
                this.length = length;
                this.width = width;
            }

            double length() { return this.length; }
            double width()  { return this.width; }

            // Implementation of equals() and hashCode(), which specify
            // that two record objects are equal if they
            // are of the same type and contain equal field values.
            public boolean equals...
            public int hashCode...

            // An implementation of toString() that returns a string
            // representation of all the record class's fields,
            // including their names.
            public String toString() {...}
        }
        ```
        - For each component in the header
            - A private field
            - A public accessor
                - These methods are
                    - `Rectangle::width()`
                    - `Rectangle::length()`
        - A canonical constructor : this refers to a constructor that initializes all final fields of a class
            - Its signature is the same as the header
        - Implementation of the equals and hashCode method
            - equals returns true if they are of the same type and contains equal component values
            - hashCode is a method provided by the `Object` class, which is used to return an integere hash code value for the object

        - Implementation of the `toString` method that includes the string representation of all the record class's components, with their names.

## The Canonical Constructor of a Record Class
- To declare the canonical constructor for the Rectangle record class.
    ```java
    record Rectangle ( double length, double width ) {
        public Rectangle( double length, double width ) {
            if ( length <= 0 || width <= 0 ) {
                throw new java.lang.IllegalArgumentException(
                    String.format(
                        "Invalid dimensions: %f %f",
                        length, width
                    )
                )
            }
        }
    }
    ```
    - To avoid this you can declare a compact constructor whose signature is implicit
        ```java
        record Rectangle( double length, double width ) {
            public Rectangle {
                if ( length <= 0 || width <= 0 )
                ....
            }
        }
        
        ```
## Explicit Declaration of Record Class Members
- You can explicitly declare any of the members derived from the header such as 
    - public accessors
    - constructor
    - equals
    - hashCode 
    - or toString
- You can also declare static fields, static initializers. and static methods in a record class
    - And they behave as they would in a normal class

    ```java
    record Rectangle ( double length, double width ) {

        // Static field
        static double goldenRatio;

        // Static initializer
        static {
            goldenRatio = (1 + Math.sqrt(5)) / 2
        }

        // Static method
        public static Rectangle createGoldenRatio(double width) {
            return new Rectangle(width, width * goldenRatio);
        }
    }
    ```
- You can not declare instance variables (non-static fields) or instance initializers in a record class
    ```java
    record Rectangle( double length, double width ) {

        BiFunction<Double, Double, Double> diagonal;

        {
            diagonal = (x, y) -> Math.sqrt(x*x + y*y);
        }
    }
    ```
    > [!CAUTION]
    > This will not compile as it contains non-static fields

- However you can declare instance methods in a record class, independent of whether you implement your own accessor methods.
    - You can also declare nested classes and interfaces in a record class including nested record classes which are implicitly static

    ```java
    record Rectangle ( double length, double width ) {

        // Nested record class
        record Rotation Angle ( double angle ) {
            angle = Math.toRadians(angle);
        }

        // Public instance method
        public Rectangle getRotatedRectangleBoundingBox(double angle) {
            RotationAngle ra = new RotationAngle(angle);
            double x = Math.abs(length * Math.cos(ra.angle())) +
                    Math.abs(width * Math.sin(ra.angle()));
            double y = Math.abs(length * Math.sin(ra.angle())) +
                    Math.abs(width * Math.cos(ra.angle()));
            return new Rectangle(x, y);
        }
    }
    ```

## Features of Record Classes
- A record class is implicitly final
- You cannot explicitly extend a record class
- Beyond these restrictions, record classes behaves like a normal class
    - Creating Generic Record class
        ```java
        record Triangle<C extends Coordinate>( C top, C left, C right ) {}
        ```
    - Declare a record that implements one or more interfaces
        ```java
        record Customer(...) implements Billable {}
        ```
    - Annotate a record class and its individual components
        ```java
        import java.lang.annotation.*;
        @Retention(RetentionPolicy.RUNTIME)
        @Target(ElementType.FIELD)
        public @interface GreaterThanZero {
            String message () default " The value must be > 0";

            class<?>[] groups() default {}

            class<? extends Payload>[] payload() default {}
        }


        class GreaterThanZeroValidator implements ConstraintValidator<GreaterThanZero, Number> {
            @Override
            public void initialize(GreaterThanZero constraintAnnotation) {
            }

            @Override
            public boolean isValid(Number value, ConstraintValidatorContext context) {
                if (value == null) {
                    return true; // Consider whether null should be considered valid or not
                }
                return value.doubleValue() > 0;
            }
        }

        ```
        - Then you can use the above annotation with record as follows
            ```java
            record Rectangle(
                @GreaterThanZero double length,
                @GreaterThanZero double width
            ) { }
            ```

## Local Record Classes
- A local record class is similar to a local class
    - It is a record defined in the body of a method

        ```java
        record Merchant(String name) { }

        record Sale( Merchant merchant, LocalDate date, double value ) {}

        public class MerchantExample {

            List<Merchant> findTopMerchants(
                List<Sale> sales,
                List<Merchant> merchants,
                int year,
                Month month
            ) {
                
                record MerchantSales(Merchant merchant, double sales) {}

                return merchants.stream()
                    .map(merchant -> new MerchantSales(
                        merchant,
                        this.computeSales(sales, merchant, year, month)
                    ))
                    .sorted((m1, m2) -> Double.compare(m2.sales(), m1.sales()))
                    .map(MerchantSales::merchant)
                    .collect(Collectors.toList())
            }

            ....
        }
        ```
        - Merchant and Sale are top-level record classes
        - Aggregation of a merchant and their total monthly sales is modeled with a local record class called MonthlySales
            - which is declared inside the findTopMerchants method
        
## Record Serialization
- You can serialize or deserialize instances of record classes
    - but you cant customize the process by providing 
        - writeObject
        - readObject
        - readObjectNoData,
        - writeExternal
        - or readExternal
- The components of a record class govern serialization
    - While canonical constructor of a record class governs the deserialization

    ```java
    import java.io.*;

    public class SerializationExample {

        public record User(String name, int age) implements Serializable {}

        public static void main(String[] args) {
            User user = new User("John Doe", 30);

            // Serialize the record
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("user.dat"))) {
                out.writeObject(user);
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Deserialize the record
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("user.dat"))) {
                User deserializedUser = (User) in.readObject();
                System.out.println(deserializedUser);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
    ```

