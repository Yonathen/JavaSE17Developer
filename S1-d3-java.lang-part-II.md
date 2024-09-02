# Variables
- A variable is location in memory to hold data
- To indicate the storage area each variable should be given a unique name
    - i.e identifier

## Creating a Variable
- Syntax
    ```java
    <data_type> <identifier> = <value>;

    OR

    <data_type> <identfier> = <value>;
    <identifier> = <value>;
    ```
- Ex: `int speedLimit = 80`
- All variables must be declared before they are used

## Rules for Naming Variables in Java
1. Java is case sensitive
2. Variables must start with either **letter** or **underscore** or **dollar sign ($)**
3. Variable name can not start with number
4. Variable name can use whitespace

## Variable Types

### Instance variables
- Objects store their individual states in "non-static fields"
  - That is fields declared without `static` keyword
  - These non-static fields are called instance variables because their values are unique to each instance of a class.

### Class variables
- These are fields that declared with `static` keyword
- This tells the compiler that there is exactly one copy of this variable 
  - regardless of how many times a class has been instantiated
  - Ex: `static int numGears = 6;`

### Local Variables
- A method will often stores its temporary state in local variables
- If a variable is declared between the opening and closing braces of a method then it is a local variable.

### Parameters
- This are the arguments accepted by a method.
- Parameters are always classified as **variables** but not **fields**

## Variable Scope
- The scope of
  - Local Variables : is from declaration to the end of the block
  - Method Parameters : for the duration of the method
  - Instance Variables : is from declaration until the object is eligible for garbage collection
  - Class Variables : from declaration of the class until the program ends.


# Literals
- Are data used for representing fixed values
  ```
  int a = 1
  float b = 2.5;
  char c = 'F';
  ```
  - Here `1`, `2.5` and `'F'` are literals

### Boolean Literals
- boolean literals are used to initialize boolean data types
- They can store two values `true` and `false`
  ```
  boolean flag1 = false;
  boolean flag2 = true;
  ```

### Integer Literals
- An integer literal is a numeric value without any fraction or exponential part

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

```java
int binary = 0b1001;
int decimal = 24;
int octal = 027;
int hexadecimal = 0x24;

System.out.format("Binary : %d \nDecimal : %d \nOctal : %d \nHexadecimal : %d", binary, decimal, octal, hexadecimal);
```
- Output
```
Binary : 9 
Decimal : 24 
Octal : 23 
Hexadecimal : 36
```

### Floating-point Literals
- Floating-point literal is a numerical literal that has either a fractional form or an exponential form

```java
double doubleLiteral = 3.4;
float floatLiteral = 3.4F;

// 3.445 * 10^2
double expDoubleLiteral = 3.445e2;

System.out.printf("Double : %f - Float : %f - Exponential : %f", doubleLiteral, floatLiteral, expDoubleLiteral);
```
  - Output
  ```
  Double : 3.400000 - Float : 3.400000 - Exponential : 344.500000
  ```

### Character Literals
- Are unicode character enclosed inside a single quotes
- They include also escape sequences like
  - `\b` (Backspace)
  - `\t` (Tab)
  - `\n` (New line) 

- Ex :- `char letter = 'a';`

### String Literals
- A sequence of characters enclosed inside a double-quotes
```
String str1 = "Java Programming"
```

# Data Type
- There are two types of data types
  - Primitive Data Types
  - Reference Data Types

## Primitive Data Types
- Java has 8 built-in data types called primitive data types
  - These are the building blocks of Java Objects
    - Because all java objects are a complex collection of this data types
  - But A primitive is not a java object nor does it represent an object
  - They are simply a single value in memory such as number or character

| Keyword    | Type           | Min         |  Max               |
| ---------- | -------------- | ----------- | ------------------ |
| boolean    | true/false     | N/A         |  N/A               |
| byte       | 8-bit integer  | -128        |  127               |
| short      | 16-bit integer | -32768      |  32767             |
| int        | 32-bit integer | -2147483648 |  2147483647        |
| long       | 64-bit integer | -2^63       |  2^63-1            |
| float      | 32-bit decimal | N/A         |  N/A               |
| double     | 64-bit decimal | N/A         |  N/A               |
| char       | 16-bit Unicode | 0           |  65535             |

## Primitive data types
- There are 8 primitive data types
  - boolean, byte, short, char, int, long, float, double

### boolean type
`boolean flag = true;`
- has two possible values either `true` or `false`
- default value is `false`

### byte type
`byte byteVar = 124;`
- Can have a value from -128 to 127 (8-bit signed two's complement)
- Default value : 0

### short type
`short shortVar = -200;`
- Can have a value from -32768 to 32767 ( 16-bit signed two's complement)
- Default value : 0

### int type
- Can have a value from -2^31 to (2l^31)-1 (32-bit signed two's complement)
- Default value : 0

### long type
`long longVar = -42332200000L;`
- Can have a value from -2^63 to (2l^63)-1 (32-bit signed two's complement)
- Above Java 8 You can use an unsigned 64-bit integer 
  - Min 0 & max (2^64)-1
- Default Value : 0

### float type
`float number = -42.3f;`
- single-precision 32-bit floating point
- default value : 0.0f

### double type 
`double number = -42.3;`
- double-precision 64-bit floating point
- default value : 0.0 (0.0d)

[Single Precision Vs Double Precision]: http://stackoverflow.com/questions/801117/whats-the-difference-between-a-single-precision-and-double-precision-floating-p

## Reference Data Types
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
  ```java
  String greetings;
  greetings = new String();
  ```

## Primitive Vs Reference
- Reference types can be used to call methods assuming that the value is not null
  - Whereas primitives do not have methods declared on them
  Example
  ```java
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
      - The only kind the compiler can assign is Object
      - That almost certainly what the author of the code intends to do.
      - So designers of java decided not to allow initialization of var with null

```java
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

```java
public int addValues(var a, var b) {
  return a + b;
}
```
  - The above code does not compile because
    - method parameters are not local variables.
    - `var` is can only be used in local variable type inference

- In Real World Scenario
  - When you start seeing a code like the following, may be its time to start using `var` for the code readability.
    ```java
    PileOfPapersToFileInFileCabinet pileOfPaperToFile =
      new PileOfPapersToFileCabinet();
    ```
    - After Replacing the above code with var it looks like:
    ```java
    var pileOfPaperToFile = new PileOfPapersToFileCabinet();
    ```

## Wrapper class
- Each primitive type has a wrapper class, which is an object type that corresponds to the primitive.

```java
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

  ```java
  Double apple = Double.valueOf("200.99");
  System.out.println(apple.byteValue()); // -56
  System.out.println(apple.shortValue()); // 200
  System.out.println(apple.intValue()); // 200
  System.out.println(apple.longValue()); // 200
  System.out.println(apple.floatValue()); // 200.99
  System.out.println(apple.doubleValue()); // 200.99
  ```

# Arrays
- An array is a container object that holds a fixed number of values of a single type
- Length of array is defined at its creating
  - After that its always fixed

## Declaring a variable to refer an array
- Syntax
  `<type>[] <identifier>;`
  - where
    - type is the data type of the contained elements
    - the brackets are indicating that this variable holds an array
- Example
  ```java
  byte[] anArrayOfBytes;
  short[] anArrayOfShorts;
  long[] anArrayOfLongs;
  float[] anArrayOfFloats;
  double[] anArrayOfDoubles;
  boolean[] anArrayOfBooleans;
  char[] anArrayOfChars;
  String[] anArrayOfStrings;
  ```

## Creating, Intializing and Accessing an Array
- Syntax for creating an array using new operator
  `<identifier> = new <type>[<size>];`
  - Example
    ```java
    int[] anArray;
    anArray = new int[10];
    ```
  - Initializing elements
    ```java
    anArray[0] = 100; // initialize first element
    anArray[1] = 200; // initialize second element
    anArray[2] = 300; // and so forth
    ```

- Alternatively, you can use the follwing shortcut syntax to create and initialize an array
  `<type>[] <identifier> = { value1, value2, ... }`
  - Example
    ```java
    int[] anArray = { 
      100, 200, 300,
      400, 500, 600,
      700, 800, 900, 1000
    };
    ```

## Array copying 
- Using `System.arraycopy`
  - Signature
    `public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length)`
  
  - Example
    ```java
    class ArrayCopyDemo {
      public static void main(String[] args) {
        String[] copyFrom = {
          "Affogato", "Americano", "Cappuccino", "Corretto", "Cortado",   
          "Doppio", "Espresso", "Frappucino", "Freddo", "Lungo", "Macchiato",      
          "Marocchino", "Ristretto" };
        
        String[] copyTo = new String[7];
        System.arraycopy(copyFrom, 2, copyTo, 0, 7);
        for (String coffee : copyTo) {
          System.out.print(coffee + " ");           
        }
      }
    }
    ```
- Using `java.util.Arrays`
  ```java
  class ArrayCopyOfDemo {
    public static void main(String[] args) {
        String[] copyFrom = {
            "Affogato", "Americano", "Cappuccino", "Corretto", "Cortado",
            "Doppio", "Espresso", "Frappucino", "Freddo", "Lungo", "Macchiato",
            "Marocchino", "Ristretto" };
        
        String[] copyTo = java.util.Arrays.copyOfRange(copyFrom, 2, 9);
        for (String coffee : copyTo) {
            System.out.print(coffee + " ");
        }
    }
  }
  ```

# Garbage Collection
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
```java
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

# Instance Initializer Blocks

- The code between two braces is called code block
- Sometimes code blocks are inside a method
  - These are executed when the function is called
- Other times code blocks are defined outside the method
  - These are called instance initializers.
```java
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

```java
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