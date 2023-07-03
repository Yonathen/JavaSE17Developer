## Executing Instance Initializer Blocks

- The code between two braces is called code block
- Sometimes code blocks are inside a method
  - These are executed when the function is called
- Other times code blocks are defined outside the method
  - These are called instance initializers.
```
public class Bird {
  public static void main(String[] args) {
    { System.out.println("Feathers"); }
  }

  { System.out.println("Snowy"); }
}
```

- The order of the execution is as follows
  - Fields and instance initializer blocks are run in the order in which they appear in the file.
  - Constructor runs after all fields and instance initializer blocks have run.

```
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
```

## Data Types
- There are two types of data types
  - Primitive Data Types
  - Reference Data Types

### Primitive Data Types
- Java has 8 built-in data types called primitive data types
  - These are the building blocks of Java Objects
    - Because all java objects are a complex collection of this data types
  - But A primitive is not a java object nor does it represent an object
  - They are simply a single value in memory such as number or character

```
+-------------------------------------------------------------+
| Keyword     Type            Min           Max               |
+-------------------------------------------------------------+
| boolean     true/false      N/A           N/A               |
| byte        8-bit integer   -128          127               |
| short       16-bit integer  -32768        32767             |
| int         32-bit integer  -2147483648   2147483647        |
| long        64-bit integer  -2^63         2^63-1            |
| float       32-bit decimal  N/A           N/A               |
| double      64-bit decimal  N/A           N/A               |
| char        16-bit Unicode  0             65535             |
+-------------------------------------------------------------+
```

- `String` is not primitive. It is an object.

- Literals
  - When a number is present in the code, it is called a literal
  - Any literal by default is an `int` value
    - `long max = 3123456789;` does not compile
      - Add 'L' or 'l'
        - because the number is bigger than what fits in an `int` java complains that the number is out of range.
        - In order, to fix this add the later 'L' or 'l' preferably 'L' at the end of the number like 
        `long max = 3123456789L;`
      - Alternatively, you can change the base
        - Octal : use 0 as number prefix. Ex : `017`
        - Hexadecimal : use '0x' or '0X' as a prefix
          - Hexadecimal is case insensitive
          - Ex: `0xFF`, `0xFf`, `0xff`
        - Binary : use '0b' or '0B' as a prefix. Ex: `0B10`, `0b11`

### Reference Data Types
- Refers to an object.
- Unlike primitive types 
  - Do not hold their values in the memory
  - Rather they hold the reference point to the an object by storing the memory address where the object is located
    - A concept referred to as a `pointer`
- Unlike other languages java does not allow you to learn what the physical memory address is
  - You can only use the reference to refer to the object.
- There are two ways to assign value to a reference
  - can be assigned to another object with same or compatible type
  - can be assigned to a new object using the new keyword
  Example
  ```
  String greetings;
  greetings = new String();
  ```

### Primitive Vs Reference
- Reference types can be used to call methods assuming that the value is not null
  - Whereas primitives do not have methods declared on them
  Example
  ```
  String reference = "Hello";
  int len = reference.length();
  int bad = len.length(); // DOES NOT COMPILE
  ```
- Reference types can be assigned null (i.e. they are not referring to anything at the moment)
  - while attempting to assign null to primitive types will cause compilation error
  Example
  ```
  int value = null; // DOES NOT COMPILE
  String name = null; 
  ```

## Wrapper class
- Each primitive type has a wrapper class, which is an object type that corresponds to the primitive.
```
Boolean bw = Boolean.valueOf("True");
boolean bv = bw.booleanValue();
boolean bv1 = Boolean.parseBoolean(false);

int primitiveInt = Integer.parseInt("123");
Integer wrapperInt = Integer.valueOf("123");

... = Byte.valueOf((byte) 1);

... = Short.valueOf((short) 1);

... = Long.valueOf(1);

... = Float.valueOf((float) 1.0);

... = Double.valueOf(1.0);

... = Character.valueOf('c');

```

- All oof the Number classes comes with some useful helper methods:
  `byteValue()`, `shortValue()`, `intValue()`, `longValue()`, `floatValue()`, `doubleValue()`

  ```
  Double apple = Double.valueOf("200.99");
  System.out.println(apple.byteValue()); // -56
  System.out.println(apple.shortValue()); // 200
  System.out.println(apple.intValue()); // 200
  System.out.println(apple.longValue()); // 200
  System.out.println(apple.floatValue()); // 200.99
  System.out.println(apple.doubleValue()); // 200.99
  ```

## Type Inference of var
- This instruct the compiler to determine the type for you.
- Compiler looks the line of the declaration and determine the type for you.
  ```
  public void reassignment() {
    var number = 7;
    number = 4;
    number = "Five"; // Does not compile
    int a, var b = 3; // Does not compile
    var n = null; // Does not compile
  }
  ```
  - `number = "Five"` does not compile because 
    - The compiler has determined the type of number as int and on this step we are trying to assign string to an int variable
  - `int a, var b = 3;` does not compile because
    - Does not compile even if you replaced it with a real type.
    - All types declared on the same line must have the same type and share the same declaration.
  - `var n = null;` does not compile because
    - The compiler is being asked to infer the type of null
      - this could be any reference type
      - The only chide the compiler can assign is Object
      - That almost certainly what the author of the code intends to do.
      - So designers of java decided not to allow initialization of var with null


  ```
  public void doesThisCompile(boolean check) {
    var question; // Does not compile
    question = 1;
    var answer; // Does not compile
    if (check) {
      answer = 2;
    } else {
      answer = 3;
    }

    System.out.println(answer);
  }
  ```
  - compiler determines the type of declaration only on declaration. 
  - In this case `question` and `answer` are not initialized at the moment of declaration and the compiler can not assign the type.

  ```
  public int addValues(var a, var b) {
    return a + b;
  }
  ```
  - The above code does not compile because
    - method parameters are not local variables.
    - `var` is can only be used in local variable type inference

- In Real World Scenario
  - When you start seeing a code like the following, may be its time to start using `var` for the code readability.
    ```
    PileOfPapersToFileInFileCabinet pileOfPaperToFile =
      new PileOfPapersToFileCabinet();
    ```
    - After Replacing the above code with var it looks like:
    ```
    var pileOfPaperToFile = new PileOfPapersToFileCabinet();
    ```

## Class Variable Vs Instance Variable Vs Local Variable
- **Instance Variables** are variables that are specific instance of a class.
  - Can only accessed by the associated object.
- **Class Variables** are variables that are shared by all objects of a class.
  - All objects of a class can access a class variable
- **Local Variables** are variables declared inside constructors, methods, and initializer blocks.

### Variable Scope
- The scope of
  - Local Variables : is from declaration to the end of the block
  - Method Parameters : for the duration of the method
  - Instance Variables : is from declaration until the object is eligible for garbage collection
  - Class Variables : from declaration of until the program ends.

## Garbage Collection
- Refers to the process of automatically freeing memory on the heap by deleting objects that are no longer reachable in your program.
- There are many different algorithms for garbage collection
- Eligible for garbage collection refers to an object's state of no longer being accessible in a program and therefore able to garbage collected.
- Garbage-Collection eligibility is like shipping a package.
  - Take an item seal it in a box and put it in your mailbox
    - this is an analogy for making an item ready for garbage collection
  - When the mail carrier comes to pick up is not in your control.
    - It can be postal holiday, or sever weather, In this case you can call them but there is no guarantee when and if this will happen.
    - Hopefully they will come before the mailbox is full
  - Java also includes a built in method to help you support garbage collection where you can suggest that garbage collection run by running
    - `System.gc();`
    - just like post office, Java is free to ignore you.
    - This method is not guaranteed to do anything.

- An object will remain on the heap until it is no longer reachable.
  - An object is no longer reachable when one of the two situations occurs
    - The object no longer has any references pointing to it
    - All references to the object have gone out of scope

### Object Vs References
- Reference is a variable that has a name and can be used to access the contents of an object
  - Can be assigned to 
    - Another reference
    - Passed to a method
    - Returned from a method
- An object sits on the heap and does not have a name
  - No way to access an object except through a reference
  - come in all different shapes and sizes and consume varying amount of memory.
  - An object can not be assigned to another object
  - can not be passed to a method, or returned from a method
- It is the object that is garbage collected, NOT ITS REFERENCE
```
public class Scope {
  public static void main(String[] args) {
    String one, two;
    one = new String("a");
    two = new String("b");

    one = two;
    String there = one;
    one = null;
  }
}
```
- In the above code
  - "a" will be eligible for garbage collection when we execute `one = two` that will remove the only reference to "a"
  - "b" doesn't go out of scope until the end of the method.

