# Chapter 7 : Beyond Classes

## Interfaces
- Defined by `interface` keyword
- Interface variables are refered to as constants
    - As they are public, static and final
    - assigned with constant value when they are declared

- Implicit Modifier : A modifier that the compiler intserts into the code
    - An interface is always considered to be an abstract

- Syntax : Declaring an interface
    ```java
        public abstract interface CanBurrow {

            public abstract Float getSpeed(int age);

            public static final int MIN_DEPTH = 2;
        }
    ```
    - `public abstract interface CanBurrow`
        - `public` : can also be a package access
        - `abstract` : here its an implicit modififier
        - `CanBurrow` : is the interface name
    - `public abstract Float getSpeed(int age)`
        - `public abstract` : implicit modifiers
    - `public static final int MIN_DEPTH = 2`
        - `public static final` : Implicit modifiers

- Syntax : for using an Interface
    ```java
        public abstract interface CanBurrow {

            public abstract Float getSpeed(int age);

            public static final int MIN_DEPTH = 2;
        }
        public interface Climb {
            Number getSpeed(int age);
        }
        public class FieldMouse implements Climb, CanBurrow {
            public Float getSpeed(int age) { return 11; }
        }
    ```
    - `public class FieldMouse implements CanBurrow`
        - `implements` : is a keyword
            - that the class will need to implement the listed interfaces
        - `CanBurrow` : is the interface
    - `public Float getSpeed(int age)`
        - `public` : required
        - `Float` : should be covariant
            - In this case Yes, because Float can implicitly cast to Number
        - `getSpeed(int age)` : the method signature is correct
            - As the name is the same and also the parameter list
    - NB: A class can implement multiple interfaces

- Extending an interface
    ```java
        public interface Nocturnal {}
        public interface Animal {}

        public interface HasBigEyes extends Nocturnal, Animal {}

    ```
    - Unilke classes an interface can extend multiple interfaces

- Inheriting an interface
    ```java
        public abstract interface HasTail {
            public Integer getTailLength();
        }
        public interface HasWings {
            public Integer getWings();
        }
        public abstract class Animal implements HasTail, HasWings {}
        public class CommonSeal extends Animal {} // Does not compile
    ```
    - `Animal` does compile as its an abstract method and does not need to implement
    - `CommonSeal` hover needs to implement all the methods Animal is implementing

- Implicit Modifiers
    - Interface is implicitly `abstract`
    - Interface varaibles are implicitly `public`, `static`, and `final`
    - Interface methods without a body are implicitly `abstract`
    - Interface methods without `private` modifire they are implicitly `public`

    ```java
        public interface CanBurrow {
            static final int MIN_DEPTH = 2;
            public abstract Float getSpeed(int age);
            void fly(int speed);
            abstract void takeoff();
            public abstract double five();
        }
    ```
    - The above code is interpreted by compiler as
        ```java
            public abstract interface CanBurrow {
                public static final int MIN_DEPTH = 2;
                public abstract Float getSpeed(int age);
                public abstract void fly(int speed);
                public abstract void takeoff();
                public abstract double five();
            }
        ```

- All interface memebers
    - Constant variable
    - Abstract method
    - Static method
    - Private method
    - Private static method
    - Default method

### Declaring `default` methods
- defined with `default` keyword
- it has method body
- It may be optionally be overriden by a class implementing it
- One usage of default method is
    - backward compatibility

- Rules of default method
    - Declared only with in an interface
    - Implicitly its public
    - Can not be marked
        - abstract
        - static
        - or final

    - If a class inherites 2 or more default methods
        - with the same method signature
            - then the class must override the default method
    
- Calling a hidden default method
    ```java
        public interface Walk {
            public default int getSpeed() { retun 20; }
        }

        public interface Run {
            public default int getSpeed() { retrun 30; }
        }

        public class Cat implements Walk, Run {
            public int getSpeed() { return 30; } // Override is a must

            public int getWalkSpeed() { return Walk.super.getSpeed(); }
        }
    ```
    - Override is a must in here
        - because the class is inheriting
            - multiple default methods with the same signature
    - But to refer to one of the hidden default methods of the interface
        - Use `super` keyword like `Walk.super.getSpeed()`

### Declare the `static` methods
- Defnition rules
    - must be marked with `static` keyword
        - and method body must be set
    - static method without access modifier is `public`
    - static method can not be marked as `abstract` or `final`
    - static method is not inherited

### Declaring `private` and `private static` methods
- if its a private it can only be accessed inside the interface
- it must have body
- only `private` method may only be called by
    - default method
    - `private` and non-static method
- `private static` method may be called by 
    - any method in the interface

```java
    public interface Schedule {
        default void wakeUp() { checktime(7); }
        private void haveBreakfast() { checktime(8); }
        static void workout() { checktime(18); }

        private static void checkTime(int hour) {
            if (hour > 17) {
                System.out.println("You are late!");
            } else {
                System.out.println("You have " + (17 - hour) + " hours left.");
            }
        }
    }
```

### Rules summary
- Treat abstract, default, and non-static private methods
    - as methods of the interface instance
- Treat static methods and variables 
    - as members of the interface class object
- All private method types are accessible
    - only inside the interface


## Enums
- Fixed set of constants
    ```java
        public enum Season {
            WINTER, SPRING, SUMMER, FALL;
        }
    ```
    - the public access modifire can be changed to be package as well
    - `enum` keyword for creating enums
    - `Season` is the name of the enum
    - `WINTER, SPRING, SUMMER, FALL` are values of the enum
        - semi-colon at the end can be optional for simple enums like this one

- Enums can not be inherited

- Calling `value()`, `name()`, and `ordinal()` Methods
    ```java
        for ( var seasson : Season.values()) {
            System.out.println(season.name() + " - " + season.ordinal());
        }

        /*
            Prints
            -----
            WINTER - 0
            SPRING - 1
            SUMMER - 2
            FALL - 3
        */
    ```

- Using `enums` in a switch statments
    ```java
        Seasson summer = Season.SUMMER;
        switch(summer) {
            case WINTER:
                System.out.println("Get out of the sled!");
                break;
            case SPRING:
                System.out.println("Time for the pool");
            default:
                System.out.println("Do noting");
        }
    ```
    - We can not use `case Season.WINTER`
        - The comiler knows by default 
    
### Adding Constructor, Fields and Methods to an enum
```java
public enum Season {
    WINTER('Low'). SPRING('Medium'), SUMMER('High'), FALL('Medium');

    pulic static final String expectedVisitors;

    private Season(Sting expectedVisitors) {
        this.expectedVisitors = expectedVisitors;
    }
}
```
- Important things to note in here
    - List of enums ends with `;` : that is mandatory
    - consturactors are `private` implicitly
        - It's compilation error to define `public` or `protected` constructors
    - The bracket in here `WINTER('Low')` is a constructor call without the `new` keyword

```java
public enum Season {
    WINTER {
        public String getHours() { return "11am - 5pm"; }
    },
    SPRING {
        public String getHours() { return "9am - 5pm"; }
    },
    SUMMER {
        public String getHours() { return "8am - 8pm"; }
    },
    FALL {
        public String getHours() { return "9am - 5pm"; }
    };
    public abstract String getHours();
}
```
- Whats happening here?
    - Its like an abstract class an bunch of tiny subclasses
    - If enum has  `abstract` class it must be implemented by all values

```java
public enum Season {
    WINTER {
        public String getHours() { return "11am - 5pm"; }
    },
    SUMMER {
        public String getHours() { return "8am - 8pm"; }
    },
    SPRING, FALL;
    public String getHours() { return "9am - 5pm"; };
}
```

- Enums also can implement interfaces as shown bellow
    ```java
        public interface Weather { int getAverageTemp() }

        public enum Season implements Weather {
            WINTER {
                public String getHours() { return "11am - 5pm"; }
            },
            SUMMER {
                public String getHours() { return "8am - 8pm"; }
            },
            SPRING, FALL;
            public String getHours() { return "9am - 5pm"; };
            public int getAverageTemprature() { return 30; }
        }
    ```

## Sealed Classes
- Is a class that restricts with other classes may inherit it
- Declaring a sealed class
    ```java
        public sealed class Bear permits Kodiak, Panda {}

        public final class Kodiak extends Bear {}

        public non-sealed class Panda extends Bear {}
    ```
    - `sealed` : indicates that a class or interface
        - may only be extended / implemented
            - by named classes or interfaces
    - `non-sealed` : Applied to class or interface
        - that extends a sealed class
            - to indicate that it can be extended by unspecified classes

    - `permit` : Used with `sealed` keyword
        - to list the classes and interfaces allowed

- Rules
    - A sealed class needs to be declared and compiled
        - as in the same package as its direct subclasses
    - Every class that directly extends a sealed class
        - MUST specify one one of the following modifiers
            - final
            - sealed
            - non-sealed

- About Omitting the `permits` clause
    - Imagin that you have two top-level class defined in the same file as follows
        - then the `permits` clause is optional
        ```java
        public sealed class Snake {}
        final class Cobra extends Snake {}
        ```

    - However, if the class is nested, then you have to specify explicitly as follows
        ```java
        public sealed class Snake permits Snake.Cobra {
            final class Cobra extends Snake {}
        }
        ```

### Sealing an interface 
- All the rules of the sealed class also applies here
    - With one more additon
        - `permits` list can apply to 
            - a class that implements the interface or 
            - an interface that extends it

    ```java
        public sealed interface Swims permits Duck, Swan, Floats {}

        public final class Duck implements Swims {}
        public final class Swan implements Swims {}

        public non-sealed interface Floats extends Swim {}
    ```

- All sealed class rules
    - they are declared with `sealed` and `permits` modifier
    - They must be declared on the same `package` or named `module`
    - Sub classes of sealed classes must be marked either of the following
        - `final`
        - `sealed`
        - `non-sealed`

## Records
- Encapsulation is a way to protect class members by 
    - restricting access to them.
    - This is done by declaring every members private

- Consider the following encapsulated and immutable class
    ```java
        public final class Crane {
            private final int numberOfEggs;

            private final String name;

            public Crane(int numberOfEggs, String name) {
                if (numberOfEggs > 0) this.numberOfEggs = numberOfEggs;
                else throw IllegalArgumentException();

                this.name = name;
            }

            private int getNumberOfEggs() {
                return numberOfEggs;
            }

            private String getName() {
                return name;
            }
        }
    ```

    - Here to make our class immutable
        - Marked the class and its instance variables `final`
        - Dont have any mutattor methods and setters

- The above task can be done in a single line with `Record`
    ```java
        public record Crane(int numberOfEggs, String name) {}
    ```
    - Record is a special type of data-oriented class in
        - which compiler intserts a lot of boilerplate code
        - It also inserts 
            `equals()`, `hashCode()`, and `toString()`
    
    - Members that are added automatically
        - Constructor : With parameter in the same order as the record declaration
        - Access method : One accessor for each field 
        - `equals()` : that compares two elements and return true if 
            - each field is equal interms of `equals()`
        - `hashCode()` : A consistent `hashCode` method using all of the Fields
        - `toString()` : A method to print each value in a convineient and easy to read format.

    ```java

        var father = new Crane(0, "Craig");
        var copy = new Crane(0, "Craig");

        System.out.println(copy);
        System.out.println(father.equals(copy));
        System.out.println(father.hashCode() + ", " + copy.hashCode());
    ```

- Record is immutable
    - Every field is inherently `final` and can not be modified.
        - After it has be wrriten in the constructor.

    - They themselves are also `final` class

        - Like Enums you can extend or inherite Records.

- Declaring your own constructor in Records
    - If you define one consturctor the compiler will not define one
    - Since each field is `final` the constructor must set all Fields
    ```java
        public record Crane(int numberOfEggs, String name) {

            public Crane(int numberOfEggs, String name) {
                if (numberOfEggs < 0) throw IllegalArgumentException();
                this.numberOfEggs = numberOfEggs;
                this.name = name;
            }

        }
    ```
    - But consider if you have 20 fields inside the Record
        - One it will be long and will introduce the boilerplate we wanted to avoid
        - Record a solution for this 
            - Compact Constructor
                ```java
                    public record Crane(int numberOfEggs, String name) {

                        public Crane {
                            if (numberOfEggs < 0) throw IllegalArgumentException();

                            name = name.toUppercase();
                        }

                    }
                ```
                - A special type of constructor
                - used for records to process validation
                - transformations succinctly
                - takes no parameters and sets all fields.
                - Java will execute full constructor after the compact constructor
                - `name = name.toUppercase();`
                    - The assignment is to the input parameter
                    - rather than to the instance memeber
                - While compact constructor can update the constructor parameter
                    - They can not update the fields in the record

    - You can also overload the constructors of a record

        ```java
            public record Crane(int numberOfEggs, String name) {

                public Crane(String firstName, String lastName) {
                    this(0, firstName + " " + lastName)
                }

            }
        ```

- Customizing Records can include
    - Overloaded and compact constructors
    - Override any prodvided methods including 
        - `hashCode`, `toString`, `equals`
    - Nested classes, interfaces, annotations, enum, and records

        ```java
            public record Crane(int numberOfEggs, String name) {

                public Crane {
                    if (numberOfEggs < 0) throw IllegalArgumentException();

                    name = name.toUppercase();
                }

                @Override
                public public int numberOfEggs() { return 10; }

                @Override
                public public String toString() { return name; }

            }
        ```

        - You can add static methods, static fields, and other data types
            - But you can not add instance fields that are outside the record declaration
                - Doing so will distroy the immutablity of the record

                ```java
                    public record Crane(int numberOfEggs, String name) {
                        private static int type = 10;
                        public int size; // Does not compile
                        private boolean friendly; // Does not compile
                    }
                ```
        
        - They DOES NOT SUPPORT instance initializers


## Nested Classes
- Is a class defined with in another class
- Can come in one of the four flavours
    - **Inner Class**: A non-static type defined at the member level of a class
    - **Static nested class**: A static type defined at the member level of a class
    - **Local class**: A class defined within a method body
    - **Anonymous class**: A special case of a local class that does not have a name

- Benefits of using nested classes
    - Can define helper classes and restrict them to the containing class
        - thereby improving Encapsulation
    
### Inner class
- non-static type defined at the member level of a class.
- Have the following properties
    - Can be declared `public`, `protected`, `package`, or `private`
    - Can extend a class and implement interface
    - Can be marked `abstract`, and `final`
    - Can access members of outside class even if they are `private`

    ```java

        public class Home {
            private String greeting = "Hi!";


            public static class Room {
                public int repeat = 3;

                public void enter() {
                    for (int i; i <= repeat; i++) greet(greeting)
                }

                public static void greet(String msg) {
                    System.out.println(msg);
                }
            }

            public void enterRoom() {
                var room = new Room();
                room.enter();
            }

            public static void main(String[] args) {
                var home = new Home();
                home.enterRoom();
            }

        }
    ```

- Since an inner class is not a static
    - It has to be called using an instance of the outer class
        - We can't just call `new Room()`
        - that means you have to create two objects
            - `var home = new Home();` creates the outer object
            - `var room = new Room();` will create the inner `Room` object
    - There is also another way of instanciating the `Room` class
        ```java
            public static void main(String[] args) {
                var home = new Home();

                Room room = home.new Room();
                room.enter();
            }
        ```
        - We can shorten the above object creation by `Room room = home.new Room();`
        - even more by `new Home().new Room().enter()`

- Referencing members of an inner class
    ```java

        public class A {
            private int x = 10;

            class B {
                private int x = 20;

                class C {
                    private int x = 30;

                    public void allXs() {
                        System.out.println(x); // Prints : 30
                        System.out.println(this.x); // Prints : 30
                        System.out.println(B.this.x); // Prints : 20
                        System.out.println(A.this.x); // Prints : 10
                    }
                }
            }

            public static void main(String[] args) {
                A a = new A();
                A.B b = a.new B();
                A.B.C c = b.new C();
                c.allXs();
            }
        }
    ```

### Static nested class
- is a static type defined at member level
- can be instantiated without an instance of the enclosing class
- Can not access instance variables or methods declared in the outer class
- It is like a top-level class except for the following
    - The nesting creates a namespace because the enclosing class name
        - must be used to refer to it
    - Can additionally be marked `private` or `protected`
    - Enclosing class can refer to the fields and methods of the static nested class

    ```java
        public class Park {

            static class Ride {
                private int price = 6;
            }

            public static void main(String[] args) {
                var ride = new Ride();
                System.out.println(ride.price);
            }
        }
    ```

### Writing a local class
- is a nested class defined in a method
- local class declaration does not exist until the method is called
- Goes out of the scope when the method returns
- Have the following properties
    - do not have an access modifier
    - can be declared `final` or `abstract`
    - have access to all `fields` and `methods` of the enclosing class
    - can access `final` and `effectively final` local variables

    ```java
        public class PrintNumbers {
            private int length = 5;

            public void calculate() {
                final int width = 20;

                class Calculator {
                    public void multiply() {
                        System.out.print(length * width)
                    }
                }

                var calculator = new Calculator();
                calculator.multiply();
            }

            public static void main(String[] args) {
                var printer = new PrintNumbers();
                printer.calculate();
            }
        }
    ```

- How about this
    ```java
    public void processData() {
        final int length = 5;
        int width = 10;
        int height = 2;

        class VolumeCalculator {
            public int multiply() {
                return length * width * height; // Does Not Compile
            }
        }
        width = 2;
    }

    ```
    - `length` and `height` variables are final and effectively final
    - However, `width` is reassigned during the method, so it cannot be called effectively final

### Anonymous class
- is a specialized form of a local class
    - that does not hava a name.
- It is declared and instantiated on one statement
    - using new keyword
    - type name 
    - set of braces `{}`
- They are useful 
    - when you want short implementation that will not be used anywhere else

- An anonymous class must extend an `abstract` class or implement an `interface`
    - Extending abstract class
        ```java
            public class Zoo {
                abstract class SaleTodayOnly {
                    abstract int dollarsOff();
                }

                public int admission(int price) {
                    SaleTodayOnly sale = new SaleTodayOnly() {
                        int dollarsOff() { return 3; }
                    };

                    return price - sale.dollarsOff();
                }
            }
        ```
        - `abstract class SaleTodayOnly` here abstract class is declared
        - `SaleTodayOnly sale = new SaleTodayOnly() {` here a concrete anonymous class is created
            - And immediately used

    - Implementing an interface
        ```java
            public class Zoo {
                interface SalesTodayOnly {
                    int dollarsOff();
                }

                public int admission(int price) {
                    SalesTodayOnly sale = new SalesTodayOnly() {
                        public int dollarsOff() { return 3; }
                    };

                    return price - sale.dollarsOff();
                }
            }
        ```
        - Here we declared an `interface` instead of an `abstract`

- Real World application of Anonymous classes and Lambda Expressions
    ```java
        var redButton = new Button();

        redButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                System.out.println("Red button pressed");
            }
        });
    ```
    - The above shows the usage of an anonymous class used for EventHandler in a JavaFX application

    - the above code can be replaced by
        ```java
            Button redButton = new Button();
            redButton.setOnAction(e -> System.out.println("Red button is pressed!"));
        ```

## Understanding Polymorphism
- Is the property of an object to take on many different forms
- Java object may be accessed using
    - `reference` with the same type as the object
    - `reference` that is a superclass of the object
    - `reference` that defines an interface the objects implements or inherites

    ```java

        public class Primate{
            public boolean hasHair() {
                return true;
            }
        }

        public interface HasTail {
            public abstract boolean isTailStriped();
        }

        public class Lemur extends Primate implements HasTail {
            public boolean isTailStriped() {
                return false;
            }

            public int age = 10;

            public static void main(String[] args) {
                Lemur lemur = new Lemur();
                System.out.println(lemur.age);

                HasTail hasTail = lemur;
                System.out.println(hasTail.isTailStriped());

                Primate primate = lemur;
                System.out.println(primate.hasHair());
            }
            
        }
    ```
- Most IMPORTANT thing to note in here is that
    - Only one object is created. that is `Lemur`
    - **Polymorphism** : enables an instance of `Lemur` to be
        - reassigned or passed to a method using one of its supertimes 
            - Such as `Primate` or `HasTail`

        - Once the object has been assigned to a new reference type
            - Only the methods and variables available to that reference type
                - are callable with the object without explicit cast

        ```java
            System.out.println(hasTail.age); // Does not compile
            System.out.println(primate.isTailStriped()); // Does not compile
        ```


- Object Vs References
    - Objects are accessed by reference
    - As a developer you do not have a direct access to objects
        - rather through the references
    - In this code `Lemur lemur = new Lemur();`
        - if you change the type `Lemur` with `Object`
            - the object itself has not changed
            - what has change is our ability to access the methods of `Lemur`
        - Without an explicit cast we no longer have access to `Lemur` properties of the object
    - To Summarize
        - Type of the object determines
            - properties exist with in the object memory
        - Type of the reference to the object determines
            - which methods and variables are accessible to the the java program.

    - Real World
        - when working with a group of objects that implement a common interface
            - It is considered a good coding practice to use an interface as reference type

        - this is especially common in collections

            ```java
                public void sortAnimals(List<String> animals) {
                    Collections.sort(animals);
                    for (String a : animals) System.out.println(a);
                }
            ```

### Casting Objects
- As shown previously once we changed type we lose those specific members
    - we can reclaim that by casting back to the specific subclass.

    ```java
    Lemur lemur = new Lemur();

    Primate primate = lemur;            // Implicit cast to supertype
    Lemur lemur2 = (Lemur) primate;     // Explicit Cast to subtype

    Lemur lemur3 = primate;             // Does not compile : b/c missing cast
    ```

- Summarize
    - Casting a reference from a subtype to a supertype
        - Does not require explicit casting
    - Casting a reference from supertype to subtype
        - Requires an explicit cast
    - At Runtime
        - An invalid cast of a reference to incompatible type results
            - `ClassCastException` being thrown
    - Compiler disallows casts to unrelated types


- In Interface casting
    - It is not pssible to cast from an interface reference to an object reference
        - If the object type cannot possibly implement the interface, such as if the class is marked final

    - Read on 396

### `instanceof` Operator
- Can be used to check whether an object belongs to a particular class or interface
    - in order to prevent `ClassCastException` at Runtime

    ```java
        class Rodent {}

        public class Capybara extends Rodent {
            public static void main(String[] args) {
                Rodent rodent = new Rodent();
                var capybara = (Capybara) rodent; // Runtime : ClassCastException
            }
        }
    ```
    - To avoid this exception
        ```java
        if (rodent instanceof Cpybara c) {
            // Do stuff
        }
        ```


- Please read on 397 - 401

