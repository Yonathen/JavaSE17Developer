# Chapter 3: Control flow statements
- Control flow statements break up the flow of execution using 
  - Decision-Making
  - Looping
  - and branching
- allows the app to selectively executes particular segments of code
## Decision-Making Statements
- The if Statement and The Switch Statement

### Applying if Statement
- Syntax
  ```
  if ( booleanExpression ) {
    // Statements
  } else if ( booleanExpression1 ) {
    // Statements
  } else {
    // Statements
  }
  ```
- `if` statements works only with boolean expression
### Shortening code with pattern matching
  - Java 16 officially introduced pattern matching with if statements and instanceof operator
  - ***Pattern matching*** : is a technique of controlling program flow that only executes a section of code that meets certain criteria.
    - Be careful not to confuse it with Java Pattern class or regular expression (regex)
      - While regex can be used for filtering in pattern matching, they are unrelated concepts.
  - Pattern matching is a created to reduce your ***boilerplate*** in your code
    - **Boilerplate code** is a code that tends to be duplicated throughout a section of code over and over again in a similar manner.
  - Consider the following
    ```
    void compareInteger( Number number ) {
      if ( number instanceof Integer ) {
        Integer data = (Integer) number;
        System.out.println(data.compareTo(5));
      }
    }
    ```
    - The cast is needed since the `compareTo()` method is defined on `Integer`
      - but not on a `Number`
    - Code that check if a variable is of a particular type
      - extremely commonly it will cast the variable after the check.
      - So java decided to implement a shorter syntax for you
      ```
      void compareIntegers(Number number) {
        if ( number instanceof Integer data ) {
          System.out.println(data.compareTo(5));
        }
      }
      ```
      - The variable data in the above example is is called **pattern variable**
      - Its possible to reassign **pattern variable**
        ```
        if ( number instanceof Integer data) {
          data = 10;
        }
        ```
        - But this is a bad practice to avoid such assignments use `final` like `if ( number instanceof final Integer data)`
  - Pattern variables and expressions 
    `if ( number instanceof Integer data && data.compareTo(5) > 0)`

#### Subtypes
- Understanding `instanceof`
  - Let's consider
    ```
    <Type1> value;
    value instanceof <Type2>
    ```
  - The declared type of value (Type1) must either:
    - Be the same as Type2.
    - Be a superclass or interface that Type2 implements.
    - Be a subclass or implement Type2.
  
- However, in the pattern matching
  - the variable must be a subtype of the variable on the left side of the expression
  ```java
  Integer value = 123;
  if (value instanceof Integer) {} // Correctly compiles
  if (value instanceof Integer data) {} // Does not compile
  ```
  - The last line does not compile
    - because `Integer` is not a strict subtype of `Integer`

#### Flow Scoping
- means the variable is only in scope when the compiler can definitively determine its type.
  - unlike any other scoping like instance, class or local
    - it is not strictly hierarchical
      - Rules
        - Rule 1: Scope Limited to Matching Block
        ```java
        Object obj = "Hello, World!";
        if (obj instanceof String s) {
          System.out.println(s.toUpperCase()); // `s` is in scope
        }
        // System.out.println(s); // Error: `s` is out of scope
        ```
        - Rule 2: Combined Conditions (&&, ||, !)
        ```java
        Object obj = "Hello, World!";
        if (obj instanceof String s && s.length() > 5) {
          System.out.println(s.toUpperCase()); // `s` is in scope
        }
        ```

- Special cases
  - Example 1
  ```java
  void printIntegersOrNumbers(Number number) {
    if (number instanceof Integer data || data.compareTo(5) > 0)
        System.out.println(data);
  }
  ```
  - If input does not inherit Integer
    - data variable is undefined
      - Since compiler can not guarantee that data is an instance of Integer
  

### Applying switch Statement
- Syntax
  ```
  switch(variableToTest) {
    case constantExpression1:
      // Branch for case1
      break;
    case constantExpression2, constantExpression3:
      // Branch for case2 and case3
      break;
    ...
    default:
      // Branch for default
  }
  ```
  - Starting with **Java 14** : combining cases like `case exp1, exp2`

  ```
  switch(animal) {
    case 1, 2: System.out.print("Lion");
    case 3: System.out.print("Tiger");
  }
  ```

- float, double, long and boolean including their wrapper classes are not supported in switch statement
  - supported types are
    - int, byte, short, char ( including their wrapper classes )
    - String
    - enum
    - var ( if the type resolves to one of the above preceding types)

- Determining acceptable `case` values
  - The values in each case statement must be compile-time constant values of the same data type as the switch value
    - This means you can use
      - literals,
      - enum constants
      - or final constant variables of the same data type
  ```java
  final int banana = 1;
  int apple = 2;
  int numOfAnimals = 3;
  final int cookies = getCookies();
  switch (numOfAnimals) {
    case bananas:
    case apples: // Does not compile
    case getCookies(): // Does not compile
    case cookies: // Does not compile
    case 3 * 5:
  }
  ```
  - The `banana` variable is marked `final`
    - its value is known at compile-time so its fine
  - `apple` does not compile because is not marked `final`
  - `getCookies()` and `cookies` does not compile because methods are evaluated at runtime

#### ***switch Expression*** :
- compact form of switch statement, that is capable of returning a value (Introduced in Java 14)
  - with this we can assign the result of a switch expression to a variable result
  ```
  int result = switch( variableToTest ) {
    case constantExpression -> 5; // Case expression : With arrow operator

    case constantExpression2, constantExpression3 -> { // For a case block curly braces are required
      yield 10; // Required for a case block if switch returns something
    }

    default -> 20;
  }; // Semicolen is required in here
  ```

  - Example
    ```
    public class DayOfWeek {
      public void printTheSeason(int month) {
        var result = switch(month) {
          case 1, 2, 3 -> "Winter";
          case 4, 5, 6 -> "Spring";
          case 7, 8, 9 -> "Summer";
          case 10, 11, 12 -> "Fall";
          default -> "Invalid value";
        };

        System.out.println(result);
      }

      public void printDayOfWeek(int day) {
        var result = switch(day) {
          case 0 -> "Sunday";
          case 1 -> "Monday";
          case 2 -> "Tuesday";
          case 3 -> "Wednesday";
          case 4 -> "Thursday";
          case 5 -> "Friday";
          case 6 -> "Saturday";
          default -> "Invalid value";
        };

        System.out.println(result);
      }

      public static void main(String[] args) {
        var dayOfWeek = new DayOfWeek();
        dayOfWeek.printDayOfWeek(0);
        dayOfWeek.printDayOfWeek(3);
        dayOfWeek.printDayOfWeek(5);
        dayOfWeek.printDayOfWeek(1);

        dayOfWeek.printTheSeason(1);
        dayOfWeek.printTheSeason(6);
      }
    }
    ```
- Rules for switch expression
  - All branches of a switch that does not throw exception must return consistent data type
    - doesn't necessarily mean the 2 datatype must be equal
    - example : `(short) value` can be assigned to `int` variable as it can be implicitly cast to `int`
  - If the switch expression returns a value, then every branch that isn't expression must `yield` a value
    - `yield` statement in here is equivalent to the return statement
      - used to avoid ambiguity whether you wanted to exit the block or the method
  - A default branch is required 
    - unless all cases are covered
    - no value is returned

## Looping
- Is a repetitive control structure that can execute a statement of code multiple times in succession.
- Some of the looping statements are 
  - The While Statement
  - The do...While Statement
  - The for Statement
  - The for each Statement

### The while statement
- Syntax
  ```
  while( booleanExpression ) {
    // Code block
  }
  ```

- Example : 
  ```
  int counter = 0;
  while( counter <= 10 ) {
    double newCounter = counter * 10;
    System.out.println(newCounter);
    counter++;
  }
  ```

### The do...while statement
- Syntax
  ```
  do {
    // Code Block
  } while( booleanExpression );
  ```
  - NB :  Semi colon is required

- Example
  ```
  int counter = 0;
  do {
    double newCounter = counter * 10;
    System.out.println(newCounter);
    counter++;
  }
  ```

### The for Statement
- Syntax
  ```
  for ( initializer; booleanExpression; updateStatement ) {
    // Code Block
  }
  ```

- Example
  ```
  for ( int i = 0; i <= 10; i++ ) {
    System.out.println("Value is : " + i);
  }
  ```

- Creating an infinite loop
  ```
  for( ; ; )
    System.out.println("Print Infinitely");
  ```

- Adding multiple terms to the for statement
  ```
  int x = 0;
  for ( long y = 0, z = 4; x < 5 && y < 10; x++, y++) {
    System.out.print(y + " ");
  }
  System.out.print(x + " ");
  ```

### The for-each loop
- Specialized structure designed to iterate over arrays and various connections framework classes.
  ```
  for ( datatype instance: collection ) {
    // Code Block
  }
  ```
  - The right side of the for-each loop must be one of the following
    - Built-in Java Array
    - An object whose type implements `java.lang.Iterable`

## Adding optional labels
- `if` statements, `switch` statements, and loops
  - can all have optional `labels`
- A `label` is an optional pointer to the head of a statement
  - That allows the application flow to jump to it or break from it
- It is single identifier (usually in snake_case for readability) followed by `:`
    ```java
        int[][] array = {{5, 2, 1, 3}, {3, 9, 8, 9}};
  
        OUTER_LOOP: for ( int[] subArray : array ) {
            INNER_LOOP: for ( int i = 0; i < subArray.length(); i++ ) {
                System.out.println(subArray[i]);
            } 
        } 
    ```

## Branching

#### `break` statement
- While working with loops there are sometimes desirable to skip some statements
- `break` statement in java terminates the loop immediately
    - And control of the program moves to the next statement

    ```
        optionalLabel: while ( booleanExpression ) {
            // Body
            break optionalLabel;
        }
    ```

#### `continue` statement
- Skips the current iteration of a loop
- After the `continue` statement, the program moves to the end of the loop.
    - And test expressing is evaluated

    ```
        optionalLabel: while ( booleanExpression ) {
            // Body
            continue optionalLabel;
        }
    ```