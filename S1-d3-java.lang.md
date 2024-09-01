> [!NOTE]
> API ( Application Programming Interface )
> Refers to the group of classes or java interface definitions giving you access to a functionality

# Creating and manipulating String
- A `String` is a sequence of characters
- The following two snippets creates a string
    ```java
    String name = "Fluffy";
    String name = new String("Fluffy");
    ```
## Common String Functions

- `charAt`, `indexOf`, `substring`
- `toLowerCase`, `toUpperCase`
- `equals`, `equalsIgnoreCase`
- `startsWith`, `endsWith`, `contains`, `replace`
- `isEmpty`, `isBlank`
- `String.format`, `formatted`


### Concatenating
- refers to placing one String before the other String and combining them is called string concatenation.
  - (+) operator is used
- Rules
  - If both operands are numeric, it will be addition
  - If either of the operands are String, it will be concatenation
  - the expression is evaluated from left to right

  ```java
  System.out.println(1+2); // 3
  System.out.println("a" + "b"); // ab
  System.out.println(1 + 2 + "a" + "b"); // 3ab
  System.out.println("a" + "b" + 3); // ab3
  System.out.println("a" + "b" + 1 + 2); // ab12
  ```

### Determining Length### Determining length
- `public int length()` returns length.
  ```java
  var name = "animals";
  system.out.println(name.length()); // 7
  ```

### Getting single character
- `public char charAt(int index)` returns character at index `index`
  ```java
  var name = "animals";
  System.out.println(name.charAt(6)); // s
  ```
### Finding an index
- `public int indexOf(int ch)` 
- `public int indexOf(int ch, int fromIndex)` 
- `public int indexOf(String str)`
- `public int indexOf(String str, int fromIndex)`
  - looks at the characters in the string and finds the first index that matches the desired value.
  - It can also start from the requested position

  ```java
  var name = "animals";
  System.out.println(name.indexOf('a')); // 0
  System.out.println(name.indexOf('al')); // 4
  System.out.println(name.indexOf('a', 4)); // 4
  System.out.println(name.indexOf('al', 5)); // -1
  ```
### Getting substring
- `public String substring(int beginIndex)`
- `public String substring(int beginIndex, int endIndex)`
  - looks for characters in a string 
  - returns part of a string from beginIndex to endIndex
  - if endIndex is not defined returns until the end of string

  ```java
  String name = "animals";
  System.out.println(name.substring(3)); // mal
  System.out.println(name.substring(3, 4)); // m
  System.out.println(name.substring(3, 7)); // mals
  System.out.println(name.substring(name.indexOf('m'))); // mal
  ```

### Adjusting case
- `public String toLowerCase()`
- `public String toUpperCase()`
  - These methods convert your string from upper case to lower case and vice versa

  ```java
  var name = "animal";
  System.out.println("ABC123".toLowerCase()); // abc123
  System.out.println(name.toUpperCase()); // ANIMAL
  ```

### Check for equality
- `public boolean equals(Object obj)`
- `public boolean equalsIgnoreCase(String str)`
  - The first one takes an object
    - that is because its the same for all objects
    - if you pass in something tha is not string, it simply returns false

  ```java
  System.out.println("abc".equals("ABC")); // false
  System.out.println("ABC".equals("ABC")); // true
  System.out.println("abc".equalsIgnoreCase("ABC")); // true
  ```

### Searching for Substrings
- `public boolean startsWith(String prefix)`
- `public boolean endsWith(String suffix)`
- `public boolean contains(CharSequence)`
  - `startWith` and `endsWith` looks at whether the provided value matches part of the String.
  - `contains` looks for matches anywhere in the String

  ```java
  System.out.println("abc".startsWith("a")); // true
  System.out.println("abc".startsWith("A")); // false
  System.out.println("abc".endsWith("c")); // true
  System.out.println("abc".endsWith("a")); // false
  System.out.println("abc".contains("b")); // true
  ```

### Replacing Values
- `public String replace(char oldChar, char newChar)`
- `public String replace(CharSequence target, CharSequence replacement)`
  ```java
  System.out.println("abcabc".replace('a', 'A')) // AbcAbc
  System.out.println("abcabc".replace("a", "A")) // AbcAbc
  ```

### Removing Whitespace
- `public String strip()`
- `public String stripTrailing()`
- `public String stripLeading()`
- `public String trim()`
  - Both `strip()` and `trim()` removes whitespace from the beginning and end of a String.
  - `strip()` does everything that `trim()` does but also supports Unicode

### Working with indentation
- `public String indent(int numberSpaces)`
- `public String stripIndent()`
  - `indent(n)`
    - where `n > 0` : Adds n spaces to beginning to each line
    - where `n == 0` : No change
    - where `n < 0` : Removes up to `n` spaces
    - Normalizes whitespace. Means
      - line break is added to the end of the string if not already there
      - converts line breaks to the `\n` format
  - `stripIndent()` : Removes all leading incidental white spaces


### Translating escapes
- `public String translateEscapes()`
  - when we escape characters, we use a single backslash
    - Ex : `\t` is a tab. 
      - If we don't want the tab behavior, we will add another backslash `\\t`
  - `translateEscapes()` takes these literals and turns them into equivalent escaped character

  ```java
  var str = "1\\t2";
  System.out.println(str); // 1\t2
  System.out.println(str.translateEscapes()); // 1    2
  ```
  - The first line prints the literal string \t
    - since the backlash is escaped
  - The second line prints the actual tab since its translated the escape

### Checking for Empty or Blank Strings
- `public boolean isEmpty()`
- `public boolean isBlank()`
  - Determines whether String has length of zero or contains only whitespace characters

  ```java
  System.out.println(" ".isEmpty());  // false
  System.out.println("".isEmpty());  // true
  System.out.println(" ".isBlank()); // true
  System.out.println("".isBlank()); // true
  ```

### Formatting values
- `public static String format(String format, Object args...)`
- `public static String format(Locale loc, String format, Object args...)`
- `public String formatted(Object args...)`
  - Formatting symbols 
    - %s : string value
    - %d : integer value like int and long
    - %f : float and double
    - %n : line break
  ```java
  var name = "Kate";
  var orderId = 5;
  System.out.println(String.format("Hello %s, Your order is %d", name, orderId));
  System.out.println("Hello %s, Your order is %d".formatted(name, orderId))
  ```

## Using the StringBuilder Class
- A small program can create a lot of String objects very quickly
- Consider the following
  ```java
  String alpha = "";
  for ( char current = "a"; current <= "z"; current++ )
    alpha += current;

  System.out.println(alpha);
  
  ```
  - `alpha` is instantiated with String and "a" is appended
  - However, String object is immutable
    - So a new String Object "a" is assigned to alpha and "" object has become eligible for garbage collection
    - next a new String object "ab" is assigned to alpha and "a" has become eligible for garbage collection
    - Like this at the end of the loop a total of 27 objects are instantiated, most of which immediately eligible for garbage collection.
      - **This is Very Inefficient**

- This where **StringBuilder** comes
  - `StringBuilder` is mutable

  ```java
  
  StringBuilder alpha = new StringBuilder("");
  for ( char current = "a"; current <= "z"; current++ )
    alpha.append(current);

  System.out.println(alpha);
  ```
  - The call to `append()` adds character to the `StringBuilder` object
  - Since `StringBuilder` is mutable, each time through the loop the value `current` is appended to the end of alpha
  - This code reuses the same `StringBuilder` without creating an interim String each time

- `StringBuffer` also works the same way, except that it supports threads.
  - It performs slower than `StringBuilder`

### Creating a `StringBuilder`
- There are three different ways of creating `StringBuilder`
  - `StringBuilder sb1 = new StringBuilder()`
    - Creates an empty sequence of characters
    - Assigns `sb1` to point to it

  - `StringBuilder sb2 = new StringBuilder("Animal")`
    - Creates `StringBuilder` with a value and 
    - Assign `sb2` to point to it

  - `StringBuilder sb3 = new StringBuilder(10)`
    - This tells java to manage the implementation details
    - It tells java to reserve the capacity or number of slots for a character

-  Common methods with String
  `var sb = new StringBuilder("animals");`
    - `sb.substring(0, 3)`
    - `sb.indexOf("al")`
    - `sb.charAt(6)`
    - `sb.length()`

- Other methods
  - `append`, `insert`, `delete`, `deleteCharAt`

### Appending values
- `public StringBuilder append(String str)`

### Inserting values
- `public StringBuilder insert(int offset, String str)`

### Deleting contents
- `public StringBuilder delete(int startIndex, int endIndex)`
  - if you specify on `endIndex`, above the length of the `StringBuilder` object
    - it will delete everything after the `startIndex`

- `public StringBuilder deleteCharAt(int index)`

## Understanding equality

```java
var one = new StringBuilder();
var two = new StringBuilder();

var three = one.append("a");

System.out.println(one == two); // false
System.out.println(three == one); // true
```
  - `one` and `two` are to different `StringBuilder` objects.
  - `one.append("a");` returns the current reference.
    - Hence, `one` and `three` both points to the same object.


```java
var x = "Hello World";
var y = "   Hello World";

var z = y.trim();

System.out.println(z.equals(x)); // True
```
  - This is true because the author of the `String` class implemented a standard method called `equals()`
    - To check the values inside the `String` rather than the string reference itself.
  - `StringBuilder` does not implement `equals()`
    - if you call `equals()` in here it will check reference equality only.

```java
var x = "Hello"
var y = new StringBuilder("Hello");

System.out.println(x == y); 
```
  - This **Does not compile**

### String Pool
- Since strings are everywhere in Java, they use up a lot of memory
  - Java solves this issue by reusing the same ones. Since many strings are repeated

- `String pool` or `Intern pool` is a location in JVM that collects all these strings
  - it contains literal values and constants that appear in your program
    - "name" is a literal
    - But `myObj.toString()` returns a string but it is not a literal

```java
var x  = "Hello World";
var y = "Hello World";

System.out.println(x == y); // True 
```
  - String is immutable and its literals are pooled
  - JVM created one literal in a memory
  - Both `x` and `y` variables both point to the same location in the memory
    - Therefore, it prints `true`

```java
var x = "Hello World";
var z = " Hello World".trim();
System.out.println(x == z); // false
```
  - In this case we done have two of the same `String` literal
  - Although `x` and `z` evaluate to the same value
    - one is computed at runtime and the other at compile-time

```java
var x = "hello world";
var concatX = "hello ";

concatX += "world";
System.out.println(x == concatX); // false
```
  - `+=` is the same as calling a method

## Understanding Arrays

# Calculating with Math API
- Java Comes with powerful `Math` class

> [!NOTE]
> Pay special attention to the return type in math questions
> They are excellent opportunity for trickery

- Common `Math` class methods
  - `min`, `max`, `round`, `ceil`, `floor`, `pow`, `random`

## Finding Minimum and Maximum
- Method signatures
  - min
    - `public static double min(double a, double b)`
    - `public static float min(double a, double b)`
    - `public static int min(int a, int b)`
    - `public static long min(long a, long b)`

  - max
    - `public static double max(double a, double b)`
    - `public static float max(float a, float b)`
    - `public static int max(int a, int b)`
    - `public static long max(long a, long b)`

## Rounding numbers
- Method signatures
  - `public static int round(float num);`
  - `public static long round(double num);`

> [!NOTE]
> This method get rid of the decimal portion of the value.
> Choosing the next higher number if appropriate
> If the fraction part is `.5` or above we round up

## Determining the Ceiling and Floor
- Method signature
  - `public static double ceil(double a)`
  - `public static double floor(double b)`

- `ceil()` returns 
  - same value if the is a whole number
  - the next whole number if it has fractional value

- `floor()` returns
  - a value by discarding any values after the decimal point

## Calculating exponent 
- Method signature
  - `public static double pow( double number, double exponent )`

## Generating random numbers
- Method signature
  - `public static double random()`

- Returns a value greater than or equal to 0 and less than 1


# System Utilities
- Provides essential facilities for interacting with java runtime environment
  - Standard input, output, error stream
  - Accessing environment variables
  - System properties
  - Support for various utility methods

## Standard Streams

- `System.out` :  standard output stream
  - commonly used to print messages
    - `System.out.println`
    - `System.out.print`
    - `System.out.printf`

  - It prints standard output usually on consol or terminal

  - Example
  ```java
  System.out.println("Hello, World");
  System.out.print("Hello again!");
  System.out.printf("Age: %d", 26);
  ```

- `System.in`: Standard input stream
  - This is used to read data from the keyboard or any other input device.

  - It is often wrapped by higher level readers such as `Scanner` or `BufferReader`

  ```java
  import java.util.Scanner;

  public class InputExample {
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      System.out.print("Enter your name: ");
      String name = scanner.nextLine();

      System.out.println("Hello, " + name + "!");
      scanner.close();
    }
  }
  
  ```

- `System.err` is similar to `System.out`
  - It is used to output error messages or diagnostics
  - Usually unbuffered and appears in a read text

  ```java
  System.err.println("An error occurred: Invalid operations");
  ```

  ## System Properties
  - System properties in java are key value pairs
    - That provide information about the environment in which java application is running
    - `java.lang.System` provides methods to access and modify these properties
      - Which can be used for retrieving
        - Configuration information
        - Environmental settings
        - System-Level Details

- has wide range of information about
  - Java environment
  - Operating System
  - User Account and more...

- Key methods
  - `System.getProperty(String key)`: retrieves the value of the specified system property
  - `System.setProperty(String key, String value)`: sets specified system property to the given value
  - `System.getProperties()`: returns property object that contains all system properties.
  - `System.clearProperty(String key)`: removes the system property specified by the key

- Common System Properties

  - `java.version`: Returns the Java Runtime Environment version.
  - `java.home`: Returns the installation directory of the Java Runtime Environment.
  - `os.name`: Returns the operating system name.
  - `os.version`: Returns the operating system version.
  - `user.name`: Returns the user account name of the current user.
  - `user.home`: Returns the home directory of the current user.
  - `user.dir`: Returns the current working directory of the Java application.

- Example 
  ```java
  String javaVersion = System.getProperty("java.version");
  String osName = System.getProperty("os.name");
  String userName = System.getProperty("user.name");

  System.out.println("Java Version: " + javaVersion);
  System.out.println("Operating System: " + osName);
  System.out.println("User Name: " + userName);
  
  ```

## Environment Variables
- These are A way to access settings and configurations external to the application
  - Typically set at the operating system level

- Accessing environment variables in java
  - `System.getenv(String name)` : Returns the value of the specified environment variable
  - `System.getenv()` : Returns an unmodifiable map of all environment variables

- Example :
  ```java
  String path = System.getenv("PATH");
  System.out.println("System PATH: " + path);

  Map<String, String> envs = System.getenv();
  for (String envName : envs.keySet()) {
      System.out.format("%s=%s%n", envName, envs.get(envName));
  }
  ```

## Time Measurement
- This useful particularly for
  - Performance monitoring
  - Profiling
  - Synchronization
  - Managing Timed Operations

- Key methods
  - `System.currentTimeMillis()` : Returns the current time in milliseconds since the Unix epoch (January 1, 1970, 00:00:00 GMT)
    - It's commonly used for measuring durations, logging, or as a timestamp for operations.

  - `System.nanoTime()` : Provides a high-resolution time source, returning the current value of the most precise available system timer, in nanoseconds.
    - unlike `System.currentTimeMillis()` it is not related to any real-world time or date.
    - Ideal for performance measurement where precise measurement is needed and for calculating time differences to assess the efficiency of code.

- Example
  ```java
  public class TimeExample {
    public static void main(String[] args) {
        // Example: Measuring Execution Time
        long startTime = System.currentTimeMillis();

        // Simulate some operations
        performTimeConsumingTask();

        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println("Elapsed time in milliseconds: " + elapsedTime);

        // Example: High Precision Measurement
        long startNanoTime = System.nanoTime();

        // Execute a quick task
        quickTask();

        long endNanoTime = System.nanoTime();
        long elapsedNanoTime = endNanoTime - startNanoTime;
        System.out.println("Elapsed time in nanoseconds: " + elapsedNanoTime);
    }

    private static void performTimeConsumingTask() {
        try {
            Thread.sleep(2000); // Simulate a task that takes 2000 milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void quickTask() {
        for (int i = 0; i < 1000; i++) {
            int x = i * i; // Simple calculation
        }
    }
  }
  ```
## Miscellaneous Utilities
- `System.arraycopy()`: A utility method for efficiently copying data from one array to another. 
  - This is particularly useful in
    - systems programming,
    - memory management, 
    - when dealing with bulk data manipulation.

- `System.exit(int status)`: Used to terminate the JVM.
  - The status code is conventionally 0 for normal termination.

- `System.gc()`: Suggests that the Java Virtual Machine expend effort toward recycling unused objects
  - in order to make the memory they currently occupy available for quick reuse.



# Object class
- `java.lang.Object` class is the root of class hierarchy in java
  - Every class in Java implicitly extends `java.lang.Object`
  - Methods defined in here are available in every object created in Java

- Key Methods
  - `getClass`, `toString`, `equals`, `notify`, `notifyAll`, `wait`, `hashCode`, `clone`, `finalize`

## Getting runtime class of object
- Method Signature
  - `public final native Class<?> getClass()`
  
- Returns the runtime class of the object.

- Used for reflection, enabling you to
  - inspect the class metadata
  - retrieve method information
  - create new instances dynamically

## Getting string representation of object
- Method Signature
  - `public String toString()`

- Returns the string representation of the object.
  - By default it returns 
    - Class name
    - the at-sign `@`
    - the objects hashCode

## Equality
- Method Signature
  - `public boolean equals(Object obj)`

- Checks the reference equality

- Overriding this method is common to provide equality check 
  - based on the content of the object rather than the reference address

## Notifying threads
- Method signature
  - `public final native void notify()`
  - `public final native void notifyAll()`

- These methods are used in synchronized context to notify threads that are waiting on this object's monitor
  - `notify()` wakes up a single thread
  - `notifyAll()` wakes up all threads

## Cause the current thread to wait
- Method signature
  - `public final native void wait(long timeout) throws InterruptedException:`

- Causes the current thread to wait until it's either
  - notified or
  - interrupted, or
  - a specified amount of time has passed.

- Must be used within a synchronized context.
  - This method is used for thread communication, by
    - letting a thread pause execution and relinquish the monitor until another thread notifies it.

## Get the hash code of an object
- Method Signature
  - `public int hashCode()`:

- Returns a hash code value for the object,
  - which is used by hashing-based collections like HashMap and HashSet. 
  - It's crucial that if two objects are equal according to the equals() method, 
    - they must return the same hash code.

- Overriding this method is essential when you override equals()
  - to maintain the general contract for the hashCode() method.

## Creating a shallow copy of object
- Method Signature
  - `protected Object clone() throws CloneNotSupportedException`

- Creates and returns a copy (a shallow copy, not a deep copy) of this object.
  - The method checks if the object's class implements Cloneable,
    - throwing CloneNotSupportedException if it does not.

- Overriding this method (and implementing the Cloneable interface) can be tricky and is generally discouraged
