# Chapter 6 : Class Design

## Understanding Inheritance
- This is the process by which a subclass includes 
  - certain members(instance variables, methods, objects or primitives) of parent class
- Subclass or child class : any class that inherits from another class
- Superclass or parent class : a class that the child inherits
- Syntax:
  ```java
    public final class ClassName extends ParentClassName {}
  ```
  - Access Modifier : `public`
  - Class Modifier : `final` : indicates this class can not be inherited by another class
  - `ClassName` : Name of the subclass
  - `ParentClassName` : Name of the superclass

    ```java
    public class BigCat {
        protected double size;
    }
    
    public class Jaguar extends BigCat {
        public Jaguar() {
            size = 20;
        }
        
        public void printDetails() {
            System.out.println(size);
        }
    }
    ```

### Class Modifiers
- Like methods and variables class also have modifiers

| Modifier   | Description                                                                        |
|------------|------------------------------------------------------------------------------------|
| final      | The class may not be extended                                                      |
| abstract   | May contain only abstract methods, and requires a concrete subclass to instantiate |
| sealed     | The class may only be extended by specific list of classes                         |
| non-sealed | A subclass of sealed class permits potentially unnamed subclasses                  |
| static     | Used for a static nested classes defined with in a class                           |


### Single Vs Multiple Inheritance
- Single Inheritance : A class may inherit from only one direct parent class
    - Supported by Java
- Multiple Inheritance : A condition where a class inherits from multiple parent classes
  - Not Supported by java

### Inheriting Object class
- In java all classes inherit from a single class called `Object or java.lang.Object` 
- `Object` class is the only class that does not have class
- If there is any class that you did not specifically `extended` to a parent class
  - Then the compiler will insert a code for your class to inherit `Object` class as follows
  ```java
    public class Zoo {}
  
    // Compiler will update it as follows
    public class Zoo extends java.lang.Object {}
  ```
- As a result all of our classes will gain access to any accessible methods in the Object class
  - Like 
    - `toString()`
    - `equals()`

## Creating a Class

### Applying Calls Access Modifiers
- Like variables and methods you can apply access modifier to classes
- top-level class is a class that is not defined inside any class 
  - Trying to declare top-level classes protected or private will lead to compilation error
- If you don't define any access modifier the class will have `package` access
- If a class is defined under another class you can assign any access modifier

```java
// Bird.java
class Bird {}
class Bear {}

// ClownFish.java
protected class ClownFish {} // Does not compile

```

### Accessing the `this` Reference
- `this` Reference refers to the current insitance of the class
  - used to access any member of the class including inherited ones
  - it can not be used when there is no implicit instance of a class
    - such as `static` method and `static` initializers

    ```java
        public class Ball {
            public String color;
    
            public void setColor(String color) {
                color = color;
            }
        }
    ```
    - In the above code `color = color` will just reset itself
      - The instance member `color` is not affected and will stay as `null`
    - To resolve this issue use `this` reference as follows
        ```java
            public void setColor(String color) {
                this.color = color;
            }
        ```

### Calling the `super` Reference
- In java the same variable or method can be defined in both parent class and child class
  - This means the object keeps both copies
- If you want to refer the copy found on the parent use `super` reference as follows

    ```java
        public class Ball {
            public String color = "White";
    
            public void setColor(String color) {
                this.color = color;
            }
        }
  
        public class BasketBall extends Ball {
            public String color = 'Orange';
  
            public String getChildColor() {
                return color;
            }
  
            public String getParentColor() {
                return super.color;
            }
        
            public static final void main(String[] args) {
                System.out.println(getChildColor()); // Prints : Orange
                System.out.println(getParentColor()); // Prints : White
            } 
        }
    ```

## Declaring Constructors
- A Constructor is a special method that
  - matches the name of the class
  - has no return value

### Creating a Constructor
- Constructor parameters can be
  - valid class, array, primitive type, including generics, varargs
  - But not `var`
- Constructor overloading is like methods overloading
  - declaring multiple constructors with different signature
    ```java
    public class Turtle {
        private String name;
        
        public Turtle() {}
        public Turtle(String name) {}
        public Turtle(String name, int age) {}
        public Turtle(String name, String... favouriteFoods) {}
    }
    ```
- when java sees the new keyword
  - it allocates memory for the new object
  - It then looks for a constructor matching its signature

- Default Constructor
  - Every class in java has a default construct whether you define for it or not
    - If you don't define (Only if your don't define any) java will create one without any parameters
        - This constructor the java creates is called `Default Constructor`
        - It has empty parameter and empty body
    ```java
    public class Turtle {
    }
    public class Turtle1 {
        public Turtle1() {}
    }
    public class Turtle2 {
        public Turtle2(String name) {}
    }
    public class Turtle3 {
        private Turtle3() {}
    }
    public class AccessTurtle {
        public static void main(String[] args) {
            var t1 = new Turtle();
            var t2 = new Turtle1();
            var t3 = new Turtle2("Turtle");
            var t4 = new Turtle3(); // Does not compile : Because the constructor defined is private and can not be accessed outside of its class
        }
    }
    ```
    - Having only **private constructors** in a class tells the compiler
      - not to provide a default no-argument constructor
        - effectively preventing other classes from instantiating the class
          - This is useful when a class has only static methods
          - Or developer wants to have a full control of all calls to create new instances of the class

### Calling Overloaded Constructors with `this()`
- Consider the following
    ```java
    public class Turtle {
        private int weight;
        private String color;
        
        public Turtle(String color, int weight) {  // First constructor
            this.weight = weight;
            this.color = color;
        }
  
        public Turtle(int weight) { // Second constructor
            this.weight = weight;
            this.color = "Brown";
        }
    }
    ```
    - Let's say we wanted to prove the second constructor, and we wanted to reuse the first constructor
      - `Turtle(weight, "Brown")` : Does not compile
        - As constructors are not like any other methods
        - And they can not be directly called.
      - `new Turtle(weight, "Brown")` : Will compile
        - but its nasty and doesn't do what we want
        - here we will end up with two objects and one of which will be discarded after creation
      - `this(weight, "Brown")` : This will solve our problem

- `this()` : will call another constructor with in the same instance of the class
  - If we use it, Then it has to be the first statement in the constructor body
  - `this` Vs `this()`
    - `this` is a reference to an instance of a class
    - `this()` is a constructor call with in a class

- Cyclic constructor calls
  ```java
    public class Turtle1 {
        public Turtle1(String name) {
            this("Turtle"); // Does not compile
        }
    }
    public class Turtle2 {
        public Turtle2() {
            this("Turtle"); // Does not compile
        }
  
        public Turtle2(String name) {
            this(); // Does not compile
        }
    }
  ```
  - In both cases we created a cyclic infinite constructor calls and the compiler is smart enough to know it

### Calling Parent Constructors with `super()`
- `super()` is used to call the parent constructor
- The first statement of every constructor is a
  - a call to parent constructor using `super()`
  - or a call to another class on the same class using `this()`
    ```java
        public class Ball {
            public String color;
            
            public Ball() {
                color = "White";
            }
        }
  
        public class BasketBall extends Ball {
            public String color = 'Orange';
            
            public BasketBall() {
                super();
            }
        }
    ```
- When you didn't explicitly call `this()` or `super()` as the first line 
  - the Compiler will automatically insert `super()` with no argument
- Consider the following
  ```java
      public class Ball {
          public String color;
            
          public Ball(String color) {
              this.color = color;
          }
      }
    
      public class AirBall extends Ball {} // Does not compile
  
      public class BasketBall extends Ball {
          public BasketBall() {} // Does not compile
      }
  ```
  - since Ball defines a constructor 
    - it does not have a `Default constructor`
    - Then the `super()` that was inserted automatically in `AirBall` and `BasketBall` by the compiler will attempt to call non-existing constructor
      - this can be fixed as follows
        ```java
        public class AirBall extends Ball {
            public AirBall() {
                super("White");
            }
        }
  
        public class BasketBall extends Ball {
            public BasketBall() {
                super("Orange");
            }
        }
        ```
    
### Rules to Remember for constructors
- A class can contain as many overloaded constructors 
  - provided the signature for each is distinct
- Compiler inserts default constructor
  - if no constructors are declared
- If the constructor calls `this()`
  - Then it must be the first statement
- Java does not allow cyclic constructor calls
- The first line of every constructor is 
  - A call to parent constructor using `super()` or and overloaded constructor using `this()`
- If a constructor does not contain `this()` or `super()`
  - The compiler will automatically inserts `super()`
- If a constructor calls `super()`, 
  - Then it must be the first line

## Initializing Objects
- Order of initialization
  - Refers to
    - How members of a class are assigned a value
      - default values like for int `0`
      - Or explicit values for final variables

### Initializing Classes
- This involves
  - Invoking all static members of in the class hierarchy
  - Starting with the highest superclass and working downwards
  - This is referred to us `loading the class`

- JVM controls when the class is initialized. That may be
  - When the program starts
  - When the static member of the class is referenced
  - Shortly before an instance of the class is created

- It only happens once for each class
  - It might not be even load if it's not used in the program

- Initializing a class X
  - If there is a superclass Y of X, then initialize class Y first
  - Process all static variable declarations in the order in which they appear in the class
  - Process all static initializers in the order in which they appear

```java
    public class Animal {
        static { System.out.println("A"); }
    }

    public class Dog extends Animal {

      public static void main(String[] args) {
          System.out.println("C");
          var a = new Animal();
          var b = new Animal();
          var c = new Animal();
      }
      static { System.out.println("B"); }
    }
```
- The above code prints `ABC`
  

### Initializing final Fields
- For instance variables if they are not initialized they will have
  - default values for `int` : 0, for `double` : 0.0, for `string` : null
  - But this instance variables are `non-final`

- If an instance variable is final it has to be assigned once only in either of the following steps
  - On the same line of the declaration
  - In initializer block
  - In a constructor body

- However, for local final variables they don't need to be initialized unless they are used

```java
    public class Animal {
        public final String color = "Brown";
        static { System.out.println("A"); }
    }

    public class Dog extends Animal {
    
        public final int age;

        { age = 10; }
    }
    
    public class Cat extends Animal {
    
      public final int age;
    
      public Cat() {
          age = 10;
      }
    }
```

### Initializing Instances
- First start at the lowest-level constructor where the new keyword is used.
  - Remember the first line of every constructor is `this()` or `super()`
  - Then progress upward and note the order of constructors
  - Finally, initialize each class starting with the super class, processing of each instance initializer and constructor in the reverse order in which it was called

- Initializing Instance X
  - Initialize class X. If it has not been previously initialized
  - If there is a superclass Y of X then initialize the instance of Y first
  - Process all instance variable declarations in the order in which they appear in the class
  - Process all instance initializers in the order in which they appear int the class.
  - Initialize the constructor, including ay overloaded constructors referenced with this()

```java
    public class Animal {
        static { System.out.println("A"); }
        { System.out.println("B"); }
  
        public Animal(String name) {
            this(1);
            System.out.println("C");
        }
        
        public Animal() {
            System.out.println("D");
        }
        
        public Animal(int num) {
            System.out.println("E");
        }
    }

    public class Dog extends Animal {
      static { System.out.println("F"); }

      public Dog(int num) {
          super("Sugar");
          System.out.print("G");
      }
      { System.out.println("H"); }
      
      public static void main(String[] args) {
          new Dog(1);
          System.out.println();
          new Dog(2);
      }
    }
```
- The above prints
  ``` 
    AFBECHG
    BECHG
  ```
  - Starts initializing the `Dog` class
    - O!! wait it has super class `Animal`
      - So Before `Dog` lets initialize `Animal`
    - So first the static initializer of Animal prints `A` then static initializer of Dog prints `F`
      - yields `AF`
  - After the classes are initialized
    - execute `main()` method
      - First line of main triggers instance initialization
    - will call `public Dog(int num)`
      - that intern will trigger Animal instance initialization through `super("Sugar")`
    - Before execution of constructor `public Animal(String name)`
      - execute all initializer blocks according to their order
      - This will print `B`
        - Yields `AFB`
      - `this(1)` first line of `public Animal(String name)` 
        - triggers `public Animal(int num)` printing `E`
          - Yields `AFBE`
        - then final line of the constructor prints `C`
          - Yields `AFBEC`
    - Finally, when return to our constructor `public Dog(int num)`
      - Before we are tempted to finalize it we need to consider the initializer blocks in the class
      - The initalizer block in `Dog` class will print `H`
        - Which yields `AFBECH`
      - At the end the last line of Dog constructor prints `G`
        - That yields `AFBCHG`
    - when we return to our main we `newline` to be printed
    - Then a call to initialize `new Dog(2)`
      - this follows the same route
        - except class initialization that should be done only once
          - This will disregard `AF` and prints `BECHG`
  - Then the whole thing Yields
    ```
      AFBECHG
      BECHG
    ```

### Rules for Initializing Classes, final Fields, and Instances
- One of the most important rule with class initialization is it happens only once for each class

- Initializing a class X
  - If there is a superclass Y of X, then initialize class Y first
  - Process all static variable declarations in the order in which they appear in the class
  - Process all static initializers in the order in which they appear

- If an instance variable is final it has to be assigned once only in either of the following steps
  - On the same line of the declaration
  - In initializer block
  - In a constructor body

- A class is initialized at most once by JVM before it is referenced or used
- All static final variables must be assigned a value exactly once,
  - either when they are declared or in a static initializer
- All final fields must be assigned a value exactly once,
  - either when they are declared, in an instance initializer or in a constructor
- Non-final static and instance variables defined without a value are assigned a default value based on their type
- Order of initialization is as follows
  - Variable declaration
  - initializers
  - constructors

## Inheriting Members
- Java's biggest strengths is leveraging its inheritance model to simplify code
- You have 5 classes and each extends `Animal` class
  - each class defines `eat()` method
  - in this scenario you would think it's better to define `eat()` once in `Animal`
    - This would open a chance for a collusion of methods with the child classes
  - Here is where **_Overriding_** comes

### Overriding a Method
- Overriding a method occurs
  - When a subclass declares a new implementation for an inherited method
    - With the same
      - signature
      - return type

- Consider the following
  ```java
  import java.io.FileNotFoundException;
  import java.io.IOException;
  
  public class Animal {
    public Animal() {
      System.out.println("D");
    }
  
    public String getColor() {
      return "Black Brown or White";
    }
  
    protected void sleep() throws FileNotFoundException {
    }
  
    protected String drinks() {
      System.out.println("Water & Milk");
    }
  
    public String eat() {
      System.out.println("Meat & Grass");
    }
  }
  
  public class Dog extends Animal {
  
    public CharSequence getColor() {  // Does not compile
      return "Grey";
    }
  
    public void sleep() throws IOException { // Does not compile
    }
  
    private String drinks() { // Doesn't compile
      System.out.println("Water & Milk");
    }
  
    public String eat() { // Overrides the eat method in the parent class
      System.out.println("Meat");
    }
  
    public static void main(String[] args) {
      new Dog(1);
    }
  }
  ```
  - On the above code consider the following rules
    - RULE 1: Method Signatures
      - For the method to be overriding instead overloading
        - Has to be the same name and signature
    - RULE 2 : Access Modifier
      - The access modifier of the subclass
        - has to have the same accessablity or more  accessiblity than the parent class
      - The reason ` private String drinks()` this does not compile is that
        - its defined `protected` in `Animal` and `Private` in `Dog`
        - if we change the `private` with `public` or `protected` in `Dog` it will work
    - RULE 3 : Checked Exception
      - The overriding method can not declare new checked exceptions or checked exception broader than the inherited method
      - The reason `public void sleep() throws IOException` does not compile is that
        - `IOException` is broader than `FileNotFoundException`
    - RULE 4 : Covariant Return types
      - The return type of the overriding method should be the same or subtype the parent method
      - The reason `public CharSequence getColor()`
        - here `CharSequence` is not the subtype of `String` rather the reverse is true
          - if we exchange the type for the parent method and child method it should be fine
      - The simple test is that
        - Let type A be inherited return type
        - Let type B be overriding return type
        - Can you assign instance of B to a reference value for A?

### Redeclaring a private methods
- What happens if you override a private method?
  - In java you can not override private method
    - they are not inherited by the child class

### Hiding static methods
- A `static` method can not be overriden because object s do not inherite each others static memebers
  - But it can be hidden if you define a `static` method with the same roles of method overriding

  ```java
      public class Animal {
          public final String color = "Brown";
          public static void eat() {
            System.out.println("Bear is eating");
          }
      }

      public class Dog extends Animal {
          public static void eat() {
            System.out.println("Dog is eating");
          }
      }
  ```
  - `Dog is eating` will be printed instead of `Bear is eating`

### Hiding variables
- Occures when a child class defines a variable with the same name as in inherited variable
  ```java
    public class Animal {
      protected boolean hasWings = false;
    }

    public class Bird extends Animal {
      protected boolean hasWings = true;

      public static void main(String[] args) {
        var b = new Bird();
        System.out.println(b.hasWings); // Prints : true
        Animal a = b;
        System.out.println(a.hasWings); // Prints : false
      }
    }

  ```

## Creating an Abstract Class
- An Abstract class is a class declared with `abstract` modifier 
  - that can not be instantiated driectly
    - rather they are rather they are instatiated by its sub classes

- Consider the following
  ```java
    public abstract class Animal {
      public abstract String  getSound();
      public void bark() { System.out.println(getSound()) };
    }

    public class Dog extends Animal {
      public String getSound() {
        return "Wooof!Woof!";
      }
    }

    public class Cat extends Animal {
      public String getSound() {
        return "MiaweMiawe";
      }
    }
  ```

- Rules
  - only instance method can be marked abstract with in a class
  - an abstract method can only be declared in abstract class
  - non-abstract class that extends abstract class must implment inherited abstract method
  - Overriding an abstract method follows the existing rules for overrriding normal methods
  - it is not possible to define an abstract method that has a body or default implementation
  - Java does not permit for a class to be an `abstract` and `final`
  - A method can not be declared an `abstract` and `private`
  - A method can not be declared an `abstract` and `static`

### Constructors in Abstract Class
- The `Animal` class bellow can only be initialized though a subclass
  - Since it is an abstract class
  - Therefore there is always an implementation of `getSound()`
    - At the time of the constructor is called

  ```java
    public abstract class Animal {
      public abstract String  getSound();

      public Animal() {
        System.out.println(getSound()); // Does this line Compiles? : Yes : Prints : "Wooof!Woof!"
      }
      public void bark() { System.out.println(getSound()); };
    }

    public class Dog extends Animal {
      public String getSound() {
        return "Wooof!Woof!";
      }

      public static void main(Sring[] args) {
        new Dog();
      }
    }
  ```

## Creating Immutable Objects
- Immutable Objects Pattern is an Object-Oriented design pattern
  - which an object cannot be modified after it is created
- Follow the following steps to create immutable class like `String`
  - Mark the class as `final` or make all of the constructors `private`
  - Mark all instance of a variable `private` and `final`
  - Don't define any setter methods
  - Don't allow referenced mutable objects to be modified
  - Use a constructor to set all properties of the object,
    - Making a copy if needed
- Checkout pages from 323 - 326