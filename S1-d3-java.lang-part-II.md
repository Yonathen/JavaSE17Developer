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
