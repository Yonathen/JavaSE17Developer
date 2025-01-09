# Chapter 4 : Core API
- API : Application Programming interface
  - refers to a group of classes or java interface definitions giving you access to a functionality

## String 
- A String : is a sequence of characters.
  - The following two snippets creates a String and the last one with a text block
    ```java
    String name = "Fluffy";
    String name = new String("Fluffy");
    String name = """
            Fluffy
          """;
    ```

- It implements `CharSequence` interface
  - It's a general way of representing several classes including
    - `String`
    - `StringBuilder`

### Concatenating
- refers to placing one String before the other String and combining them is called string concatenation.
  - (+) operator is used
- Rules
  - If both operands are numeric, it will be addition
  - If either of the operands are String, it will be concatenation
  - the expression is evaluated from left to right

  ```
  System.out.println(1+2); // 3
  System.out.println("a" + "b"); // ab
  System.out.println(1 + 2 + "a" + "b"); // 3ab
  System.out.println("a" + "b" + 3); // ab3
  System.out.println("a" + "b" + 1 + 2); // ab12
  ```
  
### Important String Methods

| Method Signature                                      | Description                                                                                     |
|-------------------------------------------------------|-------------------------------------------------------------------------------------------------|
| public int length()                                   | Returns the length of a string                                                                  |
| public char charAt(int index)                         | Returns the the character at `index`                                                            |
| public int indexOf(int ch, [int fromIndex])           | Returns the index of character `ch`                                                             |
| public int indexOf(String str, [int fromIndex])       | Returns the index of string `str`                                                               |
| public String substring(int bI, [int eI])             | Returns substring from `bI` to `eI`                                                             |
| public String toLowerCase()                           | Converts the string to lowercase                                                                |
| public String toUpperCase()                           | Converts the string to uppercase                                                                |
| public boolean equals(Object)                         | Checks for the equality of objects                                                              |
| public boolean equalsIgnoreCase(String str)           | Checks equality of strings                                                                      |
| public boolean startsWith(String prefix)              | Checks whether a string starts with prefix                                                      |
| public boolean beginsWith(String prefix)              | Checks whether a string ends with prefix                                                        |
| public boolean contains(CharSequence charSeq)         | Checks whether the string is contained in the large string                                      |
| public String replace(char oldChar, newChar)          | Does simple search and replaces that value                                                      |
| public String replace(CharSequence t, CharSequence r) | Does simple search for `t` and replaces it with `r                                              |
| public String trim()                                  | Removes white space from beginning and end of a string                                          |
| public String strip()                                 | Same as `trim` but also supports unicode                                                        |
| public String stripLeading()                          |                                                                                                 |
| public String stripTrailing()                         |                                                                                                 |
| public String indent(int numSpace)                    | Adds or remove space depending on value of `numSpace` > 0 or < 0                                |
| public String stripIndent()                           | Removes all incidental whitespaces                                                              |
| public String translateEscape()                       | It takes escaped characters like `\\t` and translate them to their equivalent escape characters |
| public boolean isEmpty()                              | Determines whether as string has length zero or not                                             |
| public boolean isBlank()                              | Determines whether a string contains only whitespace character                                  |
| public String format(String format, Object args...)   | `String.format("Hello %s", name)`                                                               |
| public string formatted(Object args...)               | `"Hello %s".formatted(name)`                                                                    |

### Determining length
- `public int length()` returns length.
  ```
  var name = "animals";
  system.out.println(name.length()); // 7
  ```

### Getting single character
- `public char charAt(int index)` returns character at index `index`
  ```
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

  ```
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

  ```
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

  ```
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

  ```
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

  ```
  System.out.println("abc".startsWith("a")); // true
  System.out.println("abc".startsWith("A")); // false
  System.out.println("abc".endsWith("c")); // true
  System.out.println("abc".endsWith("a")); // false
  System.out.println("abc".contains("b")); // true
  ```

### Replacing Values
- `public String replace(char oldChar, char newChar)`
- `public String replace(CharSequence target, CharSequence replacement)`
  ```
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

  ```
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

  ```
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
  ```
  var name = "Kate";
  var orderId = 5;
  System.out.println(String.format("Hello %s, Your order is %d", name, orderId));
  System.out.println("Hello %s, Your order is %d".formatted(name, orderId))
  ```


### Method chaining
```
String result = "AniMAl   ".trim().toLowerCase().replace('a', 'A');
System.out.println(result); // AnimAl
```

## StringBuilder
- A small program can create a lot of String objects very quickly
```
String alpha = "";
for ( char current = 'a'; current <= 'z'; current++ ) {
  alpha += current;
}
System.out.println(alpha);
```
  - `alpha` is instantiated with empty String and "a" is appended
  - However, String object is immutable
    - so a new String Object "a" is assigned to alpha and "" object has become eligible for garbage collection
    - next new String Object "ab" is assigned to alpha and "a" object has become eligible for garbage collection
    - Like this at the end of the loop a total of 27 objects are instantiated, most which immediately eligible for garbage collection immediately
    - ***This is very inefficient***

- This where **StringBuilder** comes
  - `StringBuilder` is mutable

  ```
  StringBuilder alpha = new StringBuilder();
  for ( char current = 'a'; current <= 'a'; current++)
    alpha.append(current);
  System.out.println(alpha);
  ```
  - The call to `append()` adds character to the StringBuilder object
  - each time through the loop the value `current` is appended to the end of alpha
  - This code reuses the same StingBuilder without creating an interim String each time

- `StringBuffer` also works the same way, except that it supports threads.
  - It performs slower than `StringBuilder`

### Creating a StringBuilder
- There are three different ways to create `StringBuilder`
  - `StringBuilder sb1 = new StringBuilder()`
    - Creates an empty sequence of characters
    - Assigns sb1 to point to it
  - `StringBuilder sb2 = new StringBuilder("Animal")`
    - Creates `StringBuilder` with a value and 
    - Assigns sb2 to point to it
  - `StringBuilder sb3 = new StringBuilder(10)`
    - The above two tell Java to manage the implementation details
    - This will tell java to reserve certain capacity or number of slots for a character

### Common methods with String
`var sb = new StringBuilder("animals");`
- `sb.substring(0, 3)`
- `sb.indexOf("al")`
- `sb.charAt(6)`
- `sb.length()`

### Methods only on StringBuilder

| Method                                                      | Description                                        |
|-------------------------------------------------------------|----------------------------------------------------|
| public StringBuilder append(String str)                     | Appends a string to stringBuilder                  |
| public StringBuilder insert(int offset, String str)         | Inserts the string at specified offset             |
| public StringBuilder delete(int startIndex, int endIndex)   | Deletes characters from `startIndex` to `endIndex` |
| public StringBuilder deleteCharAt(int index)                | Deletes character at index `index`                 |
| public StringBuilder replace(int sI, int eI, String newStr) | Replaces the string from `sI` to `eI` by `newStr` |
| public String toString()                                    |                                                   |

### Appending Values
- `public StringBuilder append(String str)`

### Inserting Data
- `public StringBuilder insert(int offset, String str)`

### Deleting Contents
- `public StringBuilder delete(int startIndex, int endIndex)`
  - If you specify on `endIndex` above the length of the `StringBuilder`, it will delete startIndex and everything after the startIndex
- `public StringBuilder deleteCharAt(int index)`

### Replacing Portion
- `public StringBuilder replace(int startIndex, int endIndex, String newString)`

### Reversing
- `public StringBuilder reverse()`

### Working with toString
```
var sb = new StringBuilder("Animals");
String str = sb.toString();
```

## Understanding equality

### equals() and ==
```
var one = new StringBuilder();
var two = new StringBuilder();
var three = one.append("a");
System.out.println(one == two); // false
System.out.println(three == one); // true
```
  - `one` and `two` are to different `StringBuilder` objects.
  - `one.append("a");` returns the current reference.
    - Hence, `one` and `three` both points to the same object.

```
var x = "Hello World";
var y = "   Hello World";
var z = y.trim();
System.out.println(z.equals(x)); // True
```
  - This is true because the author of the `String` class implemented a standard method called `equals()`
    - To check the values inside the `String` rather than the string reference itself.
  - `StringBuilder` does not implement `equals()`
    - if you call `equals()` in here it will check reference equality only.

```
var x = "Hello"
var y = new StringBuilder("Hello");
System.out.println(x == y); // Does Not Compile
```
  - The Compiler is smart enough to know the two references cant possibly point to same object
    - when they are completely different types


### String Pool
- Since strings are everywhere in Java, they use up a lot of memory.
  - Java solves this issue by reusing the same ones. Since many strings are repeated.
- `String pool` or `Intern pool` is a location in JVM that collects all these strings
  - it contains literal values and constants that appear in your program.
    - "name" is a literal
    - But `myObject.toString()` returns a string but ont a literal.

```
var x = "Hello World";
var y = "Hello World";
System.out.println(x == y); // True
```
  - String is immutable and literals are pooled
  - JVM created one literal in memory
  - x and y variables both point to the same location in the memory
    - Therefore, it prints `true`

```
var x = "Hello World";
var z = " Hello World".trim();
System.out.println(x == z); // false
```
  - Although x and z evaluate to the same value
    - one is computed at runtime
    - the other at compile-time

```
var x = "hello world";
var concatX = "hello ";
concatX += "world";
System.out.println(x == concatX); // false
```
  - `+=` is the same as calling a method

```
var x = "Hello World";
var y = new String("Hello World");
System.out.println(x == y); // false
```
  - The first one says to use the normal string pool
  - The second one says "No JVM, No String Pool, Please create new object"

```
var x = "Hello World";
var y = new String("Hello World").intern();
System.out.println(x == y); // true
```
  - `var y = new String("Hello World").intern();` tells java to create new object but to `intern` it
    - That is to use the string pool

## Understanding Arrays
- An array is memory on the heap with space for a designated number of elements.
  - A `String` is implemented as an array
    - where some methods are defined to deal with characters specifically
  - A `StringBuilder` is implemented as an array
    - where the array object is replaced with a new bigger array object when it runs out of space to store all the characters.
  - an array can be any type
    - Syntax
      `<type_of_array>[] <identifier> = new <type_of_array>[<size>]`
      - Example
        ```java
        int[] numbers = new int[3];
        ```
        - This would create in the memory as follows
        ```
                +---+---+---+
          Index | 0 | 1 | 2 |
                |---|---|---|
        Element | 0 | 0 | 0 |
                +---+---+---+
        ```
    - Syntax
      `<type_of_array>[] <identifier> = new <type_of_array>[]{ <Value_1>, <Value_2>, ...}`
      - Example
        ```java
        int[] numbers = new int[]{41, 42, 43};
        ```
        - This would create in the memory as follows
        ```
                +-----+-----+-----+
          Index |  0  |  1  |  2  |
                |-----|-----|-----|
        Element |  41 | 42  | 43  |
                +-----+-----+-----+
        ```
    - Syntax
      `<type_of_array>[] <identifier> = { <Value_1>, <Value_2>, ...}`
      - Example
        `int[] numbers = {41, 42, 43};`

  - `int[] i, k;` Vs `int i[], k;`
    - `int[] i, k;` creates two variables of type `int[]`
    - `int i[], k;` creates one variable of `int[]` and second one of `int`

### Creating an array with reference variables
  ```java
  String[] bugs = { "cricket", "beetle", "ladybug" };
  String[] alias = bugs;
  System.out.println(bugs.equals(alias)); // true
  ```
- We can call `equals()` because an array is an object
  - `equals()` returns `true` because reference equality
  - `equlas()` in array does not look at the elements of the array
- The array does not allocate space for the string objects, instead it allocates space for a reference to where the objects are really stored.
  - `bugs[0]` points -> "cricket"
  - `bugs[1]` points -> "beetle"
  - `bugs[2]` points -> "ladybug"

### Declaring a variable to refer an array
- Syntax
  ```
  <type>[] <identifier>;
  <type> [] <identifier>;
  <type> []<identifier>;
  <type> <identifier>[];
  <type> <identifier> [];
  ```
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

- Multiple Array Declarations
  - `int[] ids, types;` creates two variables of `int[]`
  - `int ids[], types;` creates `ids of type int[]` and `types of type int`

### Creating, Initializing and Accessing an Array
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
    
### Common Array Methods
| Method                                                                               | Description                                                       |
|--------------------------------------------------------------------------------------|-------------------------------------------------------------------|
| public static void arraycopy(Object copyFrom, int srcPos, Object copyTo, int length) | System.arraycopy(copyFrom, 2, copyTo, 0, 7)                       |
| public static Object copyOfRange(Object copyFrom, int from, int to)                  | String[] copyTo = java.util.Arrays.copyOfRange(copyFrom, 2, 9)    |
| java.util.Arrays.sort(Object arrayToSort)                                            | java.util.Arrays.sort(numbers);                                   |
| java.util.Arrays.binarySearch                                                        | java.util.Arrays.binarySearch(numbers, 5);                        |
| java.util.Arrays.compare                                                             | java.util.Arrays.compare(new int[] {1}, new int[] {2})            |
| java.util.Arrays.mismatch                                                            | java.util.Arrays.mismatch(new String[] {"a"}, new String[] {"b"}) |

### Array copying
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

### Array Sorting
- Using `Arrays.sort`
  ```java
  int[] numbers = { 100, 50, 800, 300, 400};
  System.out.println("Before sorting: " + java.util.Arrays.toString(numbers));
  java.util.Arrays.sort(numbers);
  System.out.println("After sorting: " + java.util.Arrays.toString(numbers));
  ```

### Array Searching
- Using `Arrays.binarySearch`
  - This can be used if the array is already sorted
  ```java
    int[] numbers = { 100, 50, 800, 300, 400};
    java.util.Arrays.sort(numbers);
    System.out.println(java.util.Arrays.binarySearch(numbers, 50))
    System.out.println(java.util.Arrays.binarySearch(numbers, 200))
  ```

### Array Comparing
- Using `Arrays.compare()`
  - Return values
    - Negative : the first array is smaller than the second
      - If all elements are the same and the second one has extra elements at the end
      - If the first element that differs is smaller in the first array
    - Zero : the two arrays are equal
      - If arrays are in equal size and have the same values in each spot in the same order
    - Positive : the first array is greater than the second
      - If all elements are the same and the first one has extra elements at the end
      - If the first element that differs is larger in the first array
  - Example
    ```java
      System.out.println(Arrays.compare(new int[] {1}, new int[] {2}));
    ```
  - Rules
    - What does smaller means
      - null is smaller than any other value
      - For Numbers : Normal numeric order applies
      - For Strings
        - One is smaller if it is the prefix of another
        - Numbers are smaller than letters
        - Uppercase is smaller than lowercase

### Array Mismatch
- If the array is equal, `mismatch()`
  - returns -1
  - Otherwise, it returns the first index where it differs

### Using methods with Varargs
- When an array is passed to your method
```java
public static void main(String[] args);
public static void main(String args[]);
public static void main(String... args);
```

## Creating Multidimensional Array
- Declaration
  - `int[][] vars1`
  - `int vars2 [][]`
  - `int[] vars3[]`
  - `int[] vars4[], space [][]`
    - `space` is a 3D array
    - The rest all of them are 2D
- Declaration and initialization
  ```java
    int[][] diffSizes = {{1,4}, {3}, {9,8,7}};
  ```
  - In this example the sizes of each array is different
    - This is called Asymmetric Multidimensional Array
  - Another of way of creating this is by assigning the first dimension only
  ```java
    int [][] diffSizes = new int[4][];
    diffSizes[0] = new int[5];
    diffSizes[1] = new int[3];
  ```

## Calculating with Math API

### Common methods of maths APT

| Method                                         | Description                                                 |
|------------------------------------------------|-------------------------------------------------------------|
| public static double min(double a, double b)   | Returns the min of the two numbers                          |
| public static float min(float a, float b)      |                                                             |
| public static long min(long a, long b)         |                                                             |
| public static int min(int a, int b)            |                                                             |
| public static double max(double a, double b)   | Returns the max of the two numbers                          |
| public static float max(float a, float b)      |                                                             |
| public static long max(long a, long b)         |                                                             |
| public static int max(int a, int b)            |                                                             |
| public static long round(double b)             | Discards digits after decimal point and rounds if its >= .5 |
| public static int round(float b)               |                                                             |
| public static lon ceil(double b)               | Rounds to the next whole number                             |
| public static long floor(float b)              | Discards any digit after decimal point                      |
| public static double pow(double b, double exp) | Handles exponents                                           |
| public static double random()                  | Returns X where 0 <= X < 1                                  |

## Working with Date and Time
- Package
  - `java.util.Date` : Older version
  - `java.time.*` : Newer version
- Based on how you want to be specific on the date we have four choice
  - `LocalDate` : contains just date
    - No `Time` and `TimeZone`
  - `LocalTime` : contains just time
    - No `Date` and `TimeZone`
  - `LocalDateTime` : Contains date and time
    - No `TimeZone`
- Each of the date classes have a static method called `now()`

## Time Zone
- GMT : Greenwich Meridian Time
  - is a time zone in Europe
  - New York is 4 time zones away from GMT
- UTC : Coordinated Universal Time
  - Comprised of english and french names
  - Uses the same zone zero as GMT

## Creating Specific Date and Time

| `of` Methods                                                                                 |     |
|----------------------------------------------------------------------------------------------|-----|
| LocalDate.of(int yr, int mth, int d)                                                         |     |
| LocalDate.of(int yr, Month mth, int d)                                                       |     |
| LocalTime.of(int hr, int min, [int sec, int nanos])                                          |     |
| LocalDateTime.of(int yr, Month mth, int d, int hr, int min, [int sec, int nanos])            |     |
| LocalDateTime.of(LocalDate localDate, LocalTime localTime)                                   |     |
| ZoneId.of("US/Eastern")                                                                      |     |
| ZonedDateTime.of(int yr, Month mth, int d, int hr, int min, int sec, int nanos, ZoneId zone) |     |
| ZonedDateTime.of(LocalDate localDate, LocalTime localTime, ZoneId zone)                      |     |
| ZonedDateTime.of(LocalDateTime localDateTime, ZoneId zone)                                   |     |

```java
import java.time.*;

var date1 = LocalDate.of(2022, Month.JANUARY, 20);
var date2 = LocalDate.of(2022, 1, 20);

var time1 = LocalTime.of(3, 12, 45);

var dateTime1 = LocalDateTime.of(2022, 1, 20, 3, 12, 45);
var dateTime2 = LocalDateTime.of(date1, time1);

var zone = ZoneId.of("US/Eastern");
var zonedDateTime1 = ZonedDateTime.of(2022, 1, 20, 3, 12, 45, 0, zone);
var zonedDateTime2 = ZonedDateTime.of(dateTime1, zone);
var zonedDateTime3 = ZonedDateTime.of(date1, time1, zone);

```

## Manipulating Date and Time

### Plus methods

| Methods     | Applied on                              |
|-------------|-----------------------------------------|
| plusYears   | ZonedDateTime, LocalDateTime, LocalDate |
| plusMonths  | ZonedDateTime, LocalDateTime, LocalDate |
| plusWeeks   | ZonedDateTime, LocalDateTime, LocalDate |
| plusDays    | ZonedDateTime, LocalDateTime, LocalDate |
| plusHours   | ZonedDateTime, LocalDateTime, LocalTime |
| plusMinutes | ZonedDateTime, LocalDateTime, LocalTime |
| plusSeconds | ZonedDateTime, LocalDateTime, LocalTime |
| plusNanos   | ZonedDateTime, LocalDateTime, LocalTime |

```java

import java.time.LocalDate;

var date = LocalDate.of(2022, Month.JANUARY, 20);
date = date.plusDays(1);
date = date.plusWeeks(2)
```

### Minus methods

| Methods     | Applied on                              |
|-------------|-----------------------------------------|
| minusYears   | ZonedDateTime, LocalDateTime, LocalDate |
| minusMonths  | ZonedDateTime, LocalDateTime, LocalDate |
| minusWeeks   | ZonedDateTime, LocalDateTime, LocalDate |
| minusDays    | ZonedDateTime, LocalDateTime, LocalDate |
| minusHours   | ZonedDateTime, LocalDateTime, LocalTime |
| minusMinutes | ZonedDateTime, LocalDateTime, LocalTime |
| minusSeconds | ZonedDateTime, LocalDateTime, LocalTime |
| minusNanos   | ZonedDateTime, LocalDateTime, LocalTime |

### Working with Periods
- Used for adding arbitrary period

| Methods                           |     |
|-----------------------------------|-----|
| Period.ofYears(int num)           |     |
| Period.ofMonths(int num)          |     |
| Period.ofWeeks(int num)           |     |
| Period.ofDays(int num)            |     |
| Period.of(int yr, int mth, int d) |     |

- Example
  ```java
    import java.time.LocalDate;import java.time.Period;
    var date = LocalDate.of(2022, 1, 1);
    var annually = Period.ofYears(1);
    var quarterly = Period.ofMonths(3);
    var every3Weeks = Period.ofWeeks(3);
    var everyYearAndWeek = Period.of(1, 0, 1);
    date.plus(eveyYearAndWeek);
  
    var startDate = java.time.LocalDate.now();
    var p = java.time.Period.ofMonths(1);
    startDate.plus(p); // Promotes reusability
  ```
  - The above promotes reusability compare to
  ```java
    var startDate = java.time.LocalDate.now();
    startDate.plusMonths(1);
  ```
- Method chaining in here is not possible
  ```java
    var wrong = Period.ofYears(1).ofWeeks();
    // The above is translated as
    var wrong = Period.ofYears(1);
    wrong = Period.ofWeeks(1);
  ```
  - Clearly, the above doesnt make sense

### Working with Duration
- Is for smaller unit of time
- Used for adding arbitrary period

| Without `ChronoUnit`        | Using `ChronoUnit`                       |
|-----------------------------|------------------------------------------|
| Duration.ofDays(int num)    | Duration.of(int num, ChronoUnit.DAYS)    |
| Duration.ofHours(int num)   | Duration.of(int num, ChronoUnit.HOURS)   |
| Duration.ofMinutes(int num) | Duration.of(int num, ChronoUnit.MINUTES) |
| Duration.ofSeconds(int num) | Duration.of(int num, ChronoUnit.SECONDS) |
| Duration.ofMillis(int num)  | Duration.of(int num, ChronoUnit.MILLIS)  |
| Duration.ofNanos(int num)   | Duration.of(int num, ChronoUnit.NANOS)   |

- Other `Duration` methods
  - `Duration.between`
  - `durationObj.toMillis()`

- `ChronoUnit` has other convenient methods such as
  - `ChronoUnit.HALF_DAYS` : That is 12 hrs
  - `ChronoUnit.HOURS.between(startTime, endTime)` : Returns how far the times are
  - `trancateTo`
    ```java
    LocalTime time = LocalTime.of(3, 12, 45);
    System.out.println(time); // 3:12:45
    LocalTime truncated = time.trancatedTo(ChronoUnit.MINUTES); 
    System.out.println(truncated); // 3:12
    ```
    
# Working with Instants
- Point in time
- Consider the following
  ```java
    import java.time.Duration;import java.time.Instant;
    var now = Instant.now();
    // Do Something
    // Do Some more things
    var later = Instant.now();
    var duration = Duration.between(now, later);
    System.out.println(duration.toMillis());
  ```
  
- `zonedDateTime.toInstant()` : returns the time in GMT by getting rid of the time zonezz