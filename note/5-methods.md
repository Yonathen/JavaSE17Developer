# Chapter 5: Methods
## Designing methods
```java
    public final static void nap(int minutes) throws InterruptedException {} 
```
- Access Modifier : `public`
- Optional Specifier : `final` and `static`
- Return type : `void`
- Method name : `nap`
- Parameter List : `(int minutes)`
- Method Signature : `nap(int minutes)`
- Exception List : `throws InterruptedException`

### Access Modifiers
- Determines what classes a method can be accessed from
- There are four choices
  - Private: A method can be called only from with in the same class
    - Syntax: `private <return_type> <method_name>()`
  - Package Access : A method can be called from the same package
    - sometimes referred to us as package-private or default access
    - This modifier does not have keyword. You just simply omit the access specifier
  - Protected Access : A method can be called from the same package or subclass
  - Public Access : A method can be called from any class

```java
public class ParkTrip {
    public void skip1() {}
    default void skip2() {} // Does not compile : Is not a vallid access modifier
    void public skip3() {} // Does not compile : B/C of the order
    void skip4() {}
}
```

### Optional Specifier
- There are different kinds of specifiers
  - You can place them in any order with access modifier also
  - But they have to be always before the return type

| Modifier     | Description                                                                                                 |
|--------------|-------------------------------------------------------------------------------------------------------------|
| static       | Indicates the method is a member of the shared class object                                                 |
| abstract     | Used in an abstract class or interface when the method body is excluded                                     |
| final        | Specifies that the method may not be overridden in sub-class                                                |
| default      | Used in an interface to provide default implementation of a method for a class that implement the interface |
| synchronized | Used with multithreaded code                                                                                |
| native       | Used when interacting with code written in another language such as C++                                     |
| strictfp     | Used for making floating-point calculations are portable                                                    |

```java
public class Exercise {
    public void bike1() {}
    public final void break2() {}
    public final static void break3() {}
    public static void break4() {}
}
```


### Return type
- Must appear after any access modifier and specifier
- The return statement must include void, primitive type or object

```java
public class Hike {
    public void hike1() {}
    public String hike2() {}
    public int hike3() {}
    public Integer hike4() {}
}
```

### Method name
- Follows the same rule as variable name
- By conventions method starts with small letter
```java
public class BreachTrip {
    public void jog1() {}
    public void 2jog() {} // Does not compile
    public void Jok_$() {} 
    public _() {} // Does not compile
    public _jog() {}
}
```

### Parameter List
- Although Parameter list is required it does not have to contain any parameter

### Method Signature
- Composed of method name and parameter list
- Java uses it to uniquely determine which method you are trying to call
    - This uniqueness is determined by
      - Method name
      - Parameter list content and their order
```java
public class Trip {
    public void visitZoo(String name, int waitTime) {}
    public void visitZoo(String attraction, int rainfall) {} // Does not compile
    public void visitZoo(int rainfall, String attraction) {}
}
```

### Exception List
- Indicates that if something went wrong it will throw an exception
- This is optional but in some cases depending on what's going on inside the method 
  - compiler might require you to list the exceptions

```java
public class Trip {
    public void visitZoo(String name, int waitTime) throws IllegalArgumentException, InterruptedException {}
}
```

## Declaring Local and Instance variables
- Local Variables are those created inside the method block
- Instance Variables are those that are defined as a member of the class

```java
public class Shape {
    String type;
    int width;
    int height;

    public Shape(int width, int height, String type) {
        this.type = type;
        this.height = height;
        this.width = width;
    }

    public Shape(int width) {
        this.type = "square";
        this.width = width;
    }
    
    public int calculateArea() {
        int result = width * height;
        
        if (type == 'square')
            result = width * width;
        
        return result;
    }
}
```
- Local Variables : `result`
- Instance variables are : `width`, `height`, `type`

### Local Variable Modifiers
- there is only one modifier that can be applied to the local variables that is final
    
    ```java
        public void zoo(boolean isWeekend) {
            final int rest;
            if (isWeekend) rest = 5; else rest = 20;
            System.out.println(rest);
  
            rest = 10; // Does not compile : B/c you can not reinitialize a constant
            final int work;
            if(!isWeekend) work = 10;
            System.out.println(work); // Does not compile : B/c work may never have been initialized
            
        }
    ```
- Might not seem obvious 
  - but making local variables `final` is a good practice
    - as it can be used as a guard
    - you may have a complex method where a variable is referenced dozens of times

### Effectively Final Variables
- is the that is not modified after its assigned
- Regardless of the value is not assigned as `final` it has not been changed
  - This will make it `Effectively Final` variable
- This concept will become important in `Lambdas and Functional Interfeases` 
  - Since local classes and lambda expressions declared with in a method can only reference
    - local variables that are
      - final OR
      - effectively final

### Instance Variable Modifiers
- Like Methods Instance Variables also can use access modifiers
  - `public`
  - package : omit access specifier 
  - `protected`
  - `public`
- Optional specifiers for instance variables
  - `final`: Specifies that eht instance variable must be initialized with each instance of the class exactly once
  - `volatile` : Instructs JVM that value in this variable may be modified by other threads
  - `transient` : Indicate the instance variable should not be serialized with the class

```java
public class PolarBear {
    final int age = 10;
    final int fishEaten;
    final String name;

    { fishEaten = 10; } 
    
    public PolarBear() {
        name = "Robert";
    }
}
```


## Working with Varargs
- Method use varargs parameter (variable argument)
  - as if it is an array

### Creating method with varargs
- We have some rules in creating a method with varargs
  - A method can hat at most one varargs
  - If a method contains a varargs parameter it must be the last parameter

```java
public class Visit {
    public void walk(int... steps) {}
    public void walk1(int start, int... steps) {}
    public void walk2(int... steps, int start) {} // Does not compile
    public void walk3(int... start, int... steps) {} // Does not compile
}
````

### Calling Methods with Varargs and Using Varargs
- for calling a method with varargs you have two options
  - pass an array of elements
  - or list the elements as arguments

- Accessing a varargs is just like access values of arrays with their index

```java
public class Visit {
    public void walk(int... steps) {
        System.out.println(steps[0] + steps.length);
    }
    public void walk1(int start, int... steps) {
        System.out.println(start, steps[0], steps.length);
    }
    
    public static void main() {
        int[] steps = new int[] { 1, 2, 3, 4};
        
        walk(steps); // Prints : 14
        walk(5, 6, 7, 8); // Prints : 54
        
        walk1(8, steps); // Prints : 814
        walk1(7, null); // Does not compile : Triggers NullPointerException 
    }
}
````

## Applying Access Modifiers
- There are four choices
    - Private: A method can be called only from with in the same class
      - Syntax: `private <return_type> <method_name>()`
    - Package Access : A method can be called from the same package
      - sometimes referred to us as package-private or default access
      - This modifier does not have keyword. You just simply omit the access specifier
      - Syntax: `<return_type> <method_name>()`
    - Protected Access : A method can be called from the same package or subclass
      - Syntax: `protected <return_type> <method_name>()`
    - Public Access : A method can be called from any class
      - Syntax: `public <return_type> <method_name>()`

### Private Access
```java
package pond.duck;

public class FatherDuck {
    private String noise = "quake";
    
    private void quack() {
        System.out.println(noise); // Private Access is ok
    }
    
    public final static void main() {
        var fatherDuck = new FatherDuck();
        fatherDuck.quack();
    }
}
```
- Consider the following as it tries to access private method of `FatherDuck`
```java
package pond.duck;

public class BadDucking {
    public void makeNoise() {
        var fatherDuck = new FatherDuck();
        fatherDuck.quack(); // Does not compile as the method is private
    }
}
```

### Package Access
```java
package pond.duck;

public class FatherDuck {
    private String noise = "quake";
    private String fly = "High";

    private void quack() {
        System.out.println(noise); // Private Access is ok
    }

    void testFly() {
        System.out.println(fly);
    }

    public final static void main() {
        var fatherDuck = new FatherDuck();
        fatherDuck.quack();
    }
}
```
- Consider the following as it tries to access package access method of `FatherDuck` from the same package
```java
package pond.duck;

public class BadDucking {
    public void makeFlight() {
        var fatherDuck = new FatherDuck();
        fatherDuck.testFly(); // Correctly Compiles as the method is package
    }
}
```

### Protected Access
```java
package pond.duck;

public class Bird {
    protected String text = "Floating";
    
    protected void floatInWater() {
        System.out.println(text); // protected Access is ok
    }
}
```
- Consider the following as it tries to access package access method of `FatherDuck` from the same package
```java
package pond.goose;

public class BadDucking {
    public void makeFlight() {
        var fatherDuck = new FatherDuck();
        fatherDuck.floatInWater(); // Does not compile as it is not the same package and not a subclass as well
    }
}
```

## Accessing static Data
- When a `static` keyword is applied on variable, method or class
  - it means it belongs to the class rather than the instance of the class

### Designing and Accessing static Methods and Variables
- Methods and variables declared static 
  - Does not require an instance the class
  - They are shared among all users of the class
- Usage
  - For Utility or Helper methods.
    - They don't require any object state
    - Having the instance method will avoid the caller creating objects
  - For state that is shared by all instances of a class like a counter
    ```java
        public class Koala {
            public static int count = 0;
            
            public Koala() {
                count++;
            }
            public static void main(String[] args) {
                System.out.println(count);
            }   
        }
    ```
    
- Examples
    ```java
    public class People {
        public static String name;
        
        public static void main(String[] args) {
            var p1 = new People();
            p1.name = "Jhon";
            var p2 = new People();
            p2.name = "Mark";
            
            System.out.println(p1.name); // Prints Mark
        }
    }
    ```
- Accessing a static Variable and Method
  - You just put the class name before the method or variable and you are done
    ```java
    public class People {
        public static String name = "John";
        
        public static void main(String[] args) {
            var p1 = new People();
            System.out.println(People.name); // Prints John
            System.out.println(p1.name); // Prints John
            p1 = null;
            System.out.println(p1.name); // Prints John
        }
    }
    ```

### static Variable Modifiers
- Static variables can declared with the same modifiers as instance variables wit
  - final, transient, or volatile
- While some `static` variables changes some are there never to change
  - Inorder to declare `static` variables that are constant use `final` keyword as follows
  ```java
    public class Zoo {
        private static final int NUM_BUCKETS = 45;
        private static final String[] treats = new String[10];
  
        public static void main(String[] args) {
            NUM_BUCKETS = 5; // Does not compile : as NUM_BUCKETS is a static constant variable
            treats[0] = "popcorn"; // Correctly Compiles : As this threat is reference variable and we are not changing the reference rather the content of the object
        } 
    }
  ```
  
- 
### static Initializers
- Initializers are unnamed code blocks
  - They run on every instance according to their order of appearance
- When you declare initializers `static` then
  - They should run only when the class is firs loaded

```java
public class MgmtTime {
    private static final int NUM_SECONDS_PER_MIN;
    private static final int NUM_MIN_PER_HOUR;
    private static final int NUM_SECONDS_PER_HOUR;
    
    static {
        NUM_SECONDS_PER_MIN = 60;
        NUM_MIN_PER_HOUR = 60;
    }
    
    static {
        NUM_SECONDS_PER_HOUR =
                NUM_MIN_PER_HOUR * NUM_SECONDS_PER_MIN;
    }
}
```

### static Imports
- You can import the `static` members (Variables or Methods) of a class
  - using `import static`
```java
import java.util.List;
import static java.util.Arrays.asList; // static import

public class Zoo {
    public  static void main(String[] args) {
        List<String> list = asList("one", "two");
    }
}
```

## Passing Data among Methods
- Java is a "pass-by-value" language
  - i.e. a copy of the variable is made and the method recieves that copy
    - Assigments made inside the method does not affect the caller
  ```java
    public class Zoo {
        public static void newNumber(int num) {
            num = 8;
        }
        public static void main(String[] args) {
            int num = 4;
            newNumber(num);
            System.out.println(num); // Will still prints 4
        }
    }
  ```


### Passing Object
- How about if we pass reference type and use its inner function as follows
  ```java
    public class Zoo {
        public static void reassignName(String name) {
            name = "Georette";
        }
    
        public static void appendName(StringBuilder sb) {
            sb.append(" Jason");
        }
        public static void main(String[] args) {
            String name = "Webby";
            reassignName(name);
            System.out.println(name); // This will still be "Webby"
    
            // How about the following?
            StringBuilder sb = new StringBuilder("Web");
            appendName(sb);
            System.out.println(sb.toString()); // This will print "Web Jason"
        }
  }
  ```

### Returning Object
- A copy is made of the primitive or reverence
  - Returned from the method
  - If the returned value is not used the result is ignored

### Autoboxing and Unboxing
- Autoboxing : is the precess of converting primitive into its equivalent wrapper class
- Unboxing : is the process of converting wrapper class to its equivalent primitive type
  ```java
  int quack = 5;
  Integer quackquack = Integer.valueOf(quack);
  // By Autoboxing this can be simplified as
  Integer quackAutoboxing = quack; // Autoboxing
  
  /////////////////////////////////////
  int quackquackquack = quackquack.intValue();
  // By Using unboxing the above can be simplified as
  int quackUnboxing = quackquack; // Unboxing
  
  ```


## Overloading Methods
- This is creating methods in the same class with the same name but different method signature
  ```java
    public class Falcon {
        public fly(int numMiles) {}
        public fly(short numFeet) {}
        public fly(int numMiles, short numFeet) {}
        public fly() {}
    }
  ```


