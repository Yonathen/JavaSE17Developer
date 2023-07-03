## Control flow statements
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
- Shortening code with pattern matching
  - Java 16 officially introduced pattern matching with if statements and instanceof operator
  - ***Pattern matching*** : is a technique of controlling program flow that only executes a section of code that meets certain criteria.
    - Be careful to to confuse it with Java Pattern class or regular expression (regex)
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
  - Flow Scoping
    - To be studied on **Page 108 - 110**

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

- ***switch Expression*** : compact form of switch statement, that is capable of returning a value (Introduced in Java 14)
  - with this we can assign the result of a switch expression to a variable result
  ```
  int result = switch( variableToTest ) {
    case constantExpression -> 5;

    case constantExpression2, constantExpression3 -> {
      yield 10;
    }

    default -> 20;
  }
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

