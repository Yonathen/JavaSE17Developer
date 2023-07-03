- API : Application Programming interface
  - refers to a group of classes or java interface definitions giving you access to a functionality

## String 
- A String : is a sequence of characters.
- The following two snippets creates a String
  ```
  String name = "Fluffy";
  String name = new String("Fluffy");
  ```

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
  - In this case we done have tow of the same `String` literal
  - Although x and z evaluate to the same value one is computed at runtime and the other at compile-time

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
        `int[] numbers = new int[3];`

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
        `int[] numbers = new int[]{41, 42, 43};`

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

- Creating an array with reference variables
  ```
  String[] bugs = { "cricket", "beetle", "ladybug" };
  String[] alias = bugs;
  System.out.println(bugs.equals(alias)); // true
  ```
    - We can call `equals()` because an array is an object
    - `equals()` returns `true` because reference equality
    - The array does not allocate space for the string objects, instead it allocates space for a reference to where the objects are really stored.
      - `bugs[0]` points -> "cricket"
      - `bugs[1]` points -> "beetle"
      - `bugs[2]` points -> "ladybug"
    
