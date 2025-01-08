## Chapter 2 : Java operator
- refers to a special symbol
  - that can be applied to a set of variables, values or literals and that returns results.
- Operand :  is the value or variable the operator is being applied on.

### Types of operators
- Java supports three flavours of operators
  - Unary
  - Binary
  - Ternary

### Operator Precedence
- Java the mathematics rules of precedence (BODMAS) 
- Java guarantees left-to-right evaluation for most operators that have the same level of precedence.
  - Check out Page 68 -> Table 2.1

### Unary operators
- requires only one operand to function

  | Operator |  Example |  Description |
  | --- | --- | --- |
  | Logical Complement | !a | Inverts boolean logical value  |
  | Bitwise complement | ~b | Inverts all 0s and 1s in a number |
  | Plus | +c | Indicates the number is positive |
  | Negation or minus | -d    | Indicates a literal number is negative or negates an expression |
  | Increment | ++e or f++ | Increments a value by 1 |
  | Decrement | --g or h-- | Decrements a value by 1 |
  | Cast | (String)i | Casts a value to a specific type |


- Complement
  ```java
  int value = 3;            // Stored as 0011
  int complement = ~value;  // Stored as 1100
  System.out.println(value); // Prints 3
  System.out.println(complement); // Prints -4
  ```

- Increment and decrement
  - Pre-Increment : ++w : Increase by one and returns the new value;
  - Pre-Decrement : --x : Decrease the value one and returns the new value
  - Post-Increment : y++ : Increase the value by one and return the original value
  - Post-decrement : z-- : Decrease the value by one and return the original value
  ```java
  int parkAttendance = 0;
  System.out.println(parkAttendance); // prints 0
  System.out.println(++parkAttendance); // prints 1
  System.out.println(parkAttendance); // prints 1
  System.out.println(parkAttendance--); // Prints 1
  System.out.println(parkAttendance); // Prints 0
  ```

### Binary Operators
- requires two operands
- Used for mathematical operations, create logic operations and perform basic assignment
- Arithmetic operators
  - "+" : Addition, "-" : Subtraction, "*" : Multiplication, "/" : Division, "%" : Modulus

- Numeric Promotion rules
  - If two values have different data types
    - Java will automatically promote one value to the larger
  - If one of the value is integral and the other is floating-point
    - Java will automatically promote the integral to floating-point
  - smaller data-types namely `byte`, `short` and `char` 
    - are first promoted to int any time they'are used with java binary arithmetic operations
      - Even if neither of the operands are `int`
  - After all promotion has occurred and the operands have the same data type
    - the resulting value have the same data type as its promoted operand

### Assignment Operator
- A binary operator that modifies or assigns the variable on the left side of the operator
  - with the result of the value on the right side of the equation
- Assignment operator is evaluated from Left-to-Right
```java
int a = 50;
```

- Casting values
  - is a unary operator
  - one data type is explicitly interpreted as another data type
  - Used for converting smaller or narrowing to a larger data type
    - The reverse operation is optional / unnecessary

  ```java
  int fur = (int) 5;
  int hair = (short) 2;
  String type = (String) "Bird"
  ```
  
  - Reviewing primitive assignments
    ```java
      int fish = 1.0; // Does not compile : because we are trying to assign double to int
      short bird = 1921222; // Does not compile : literal value is out of range
      int mammal = 9f; // Does not compile : because here you are trying to assign float to int 
      int reptile = 192_301_398_193_810_323; // Does not compile : Because the literal is interpreted as int and notice that the value is out of range
    ```
    - this can be fixed by casting except to the last one
      ```java
        int fish = (int) 1.0;
        short bird = (short) 1921222; // Stored as 20678
        int mammal = (int) 9f;
      ```
      - `int reptile = (long) 192_301_398_193_810_323;` Does not compile
        - because the literal is interpreted as an int by the compiler and that is outside the range
### Compound Assignment Operators
- Java supports the following compound assignments

  - Addition Assignment         a += 5
  - Subtraction Assignment      b -= 0.3
  - Multiplication Assignment   c *= 100
  - Division Assignment         d /= 4

```java
long goat = 10;
int sheep = 5;
sheep = sheep * 5; // Does not compile
```
  - This does not compile because Java automatically promoted the result to long and the assignment operator is trying to fit it into an int
  - If we replace the last line with `sheep *= goat` it will compile because
    - compound operator will 
      - first cast sheep to a long,
      - then apply multiplication of two long values and then cast the result to an int.

### Return value of Assignment Operator
- The result of an assignment is
  - an expression in and of itself equal to the value of the assignment.

```java
long wolf = 5;
long coyote = (wolf=3);
System.out.println(wolf); // Prints 3
System.out.println(coyote); // Prints 3
```
  - `long coyote = (wolf=3);` in this statement
    - `(wolf=3)` will assign `wolf` 3 and returns 3
    - the returned value is assigned to `coyote`

```java
boolean healthy = false;
if ( healthy = true )
  System.out.print("Good");
```
  - `if ( healthy = true )` in this statement
    - it assigns `healthy` a value of true
    - the result of the assignment is the value of the assignment which is true
    - therefore this snippet prints "Good"

### Comparison operators
  - Equality Operators
    - Equality (==)
    - Inequality (!=)
  - Relational Operators
    - Less than (<)
    - Less than or equal (<=)
    - Greater than or equal (>=)
    - Type Comparison (instanceof)

- When applying equality operators you can not mix types
- Equality operators can be applied to 
  - Objects
  - boolean
  - numeric

- instanceof Operator
  - determines what class or interface an object is.
    ```java
    public class TestInstanceOf {
      public static void openZoo(Object time) {
        if ( time instanceof Integer ) {
          System.out.println((Integer) time + " O'clock");
        } else
          System.out.println(time);
      }

      public static void main(String[] args) {
        Integer zooTime = Integer.valueOf(9);

        Number num = zooTime;
        Object obj = zooTime;

        openZoo(zooTime);
        openZoo(num);
        openZoo(obj);
      }
    }
    ```
    - Integer inherits both Number and Object
      - so you can call instanceof on any of these references and true will return true for each
      - consequently printing "9 O'clock" three times.

      - But if you change to `time instanceof String` will not print "9 O'clock" only one time
        - Since Number and Integer are incompatible with String.
        - If the data type of "time" was Number, it wouldn't compile in the first place
          - Number can not possibly hold the value of a String
  - instanceof on the null literal or a null reference always returns false
    ```java
    System.out.println(null instanceof Object); // false
    Object noRef = null;
    System.out.println(noRef instanceof Object); // false
    System.out.println(null instanceof null); // does not compile
    ```

### Conditional operators
| Operator | Example  | Description |
| --- |----------| --- |
| Conditional AND | a && b   | Valid to true if both values are true. if the left side is false then the rithgt side will not be evaluated |
| Conditional OR | a \|\| b | Valid is true if at least one value is true. if the left side is evaluated to true then the right side will not be evaluated |
- They are often called short-circuit operators
  - nearly identical to the logical operators `&` and `|`
    - except the right side of the expression may not be evaluated
      - if the final result can be determined by the left side

- Avoiding null pointer exception
  ```java
  if ( duck != null & duck.getAge() < 5 ) {
    // This will throw a NullPointerException
    // Do Something
  }
  ```
  - Fix the above by short short-circuit operator
  ```java
  if ( duck != null && duck.getAge() < 5 ) {
    // Do Something
  }
  ```

- Ternary Operator
  - Conditional operator (? :)
  ```
  int food = owl < 2 ? 3 : 4;
  ```



