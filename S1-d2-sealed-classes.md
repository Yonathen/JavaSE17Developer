# Sealed Classes
- Restrict which other classes or interfaces may extend or implement them
- Primary purpose of inheritance is code reuse
    - When you want to create a new class and there is already a class that includes some of the code you want
        - You can derive your new class from the existing class
    - In doing this you can reuse the fields and methods of the existing class without having to write them yourself

- However you might not be interested in allowing any arbitrary class to extend your class
    - By sealing a class, you can specify which classes are permitted to extend it and prevent any other arbitrary class from doing so.

## Declaring Sealed Classes
- To seal a class, add a sealed modifier to its declaration. 
    - And after any extends and implements clauses add permits clause
    - this clause specifies the classes that may extend sealed class

    ```java
    public sealed class Shape permits Circle, Square {

    }

    public final class Circle extends Shape {
        public float radius;
    }

    public non-sealed class Square extends Shape {
        public double side;
    }

    public sealed class Rectangle extends Shape permits FilledRectangle {
        public double length, width;
    }

    public class FilledRectangle extends Rectangle {
        int red, green, blue;
    }
    ```

## Constraints on Permitted Subclasses
- They must be accessible by the sealed class at compile time

- They must directly extend the sealed class

- They must have exactly one of the following modifiers to describe how it continues the sealing initiated by its superclass
    - `final` : Cannot be extended further
    - `sealed` : Can only be extended by its permitted subclasses
    - `non-sealed` : Can be extended by unknown subclasses;
        - A sealed class cannot prevent its permitted classes from doing this

- They must be in the same module as the sealed class or in the same package
    ```java
    package com.example.graphics;

    public sealed class Shape 
        permits com.example.polar.Circle,
                com.example.quad.Rectangle,
                com.example.quad.simple.Square { }
    ```
## Declaring Sealed Interface
- To declare sealed interface, add sealed modifier to its declaration and after extends clause add permits clause

    - Syntax
        ```java
        sealed interface Expr permits ConstExpr, PlusExpr, TimesExpr, NegExpr {
            public int eval();
        }

        final class ConstantExpr implements Expr {
            int i;
            ConstantExpr(int i) { this.i = i; }
            public int eval() { return i; }
        }

        final class PlusExpr implements Expr {
            Expr a, b;
            PlusExpr(Expr a, Expr b) { this.a = a; this.b = b; }
            public int eval() { return a.eval() + b.eval(); }
        }

        final class TimesExpr implements Expr {
            Expr a, b;
            TimesExpr(Expr a, Expr b) { this.a = a; this.b = b; }
            public int eval() { return a.eval() * b.eval(); }
        }

        final class NegExpr implements Expr {
            Expr e;
            NegExpr(Expr e) { this.e = e; }
            public int eval() { return -e.eval(); }
        }
        ```

## Record Classes as Permitted Subclasses
- You can name a record class in the `permits` clause of a sealed class or interface
    - Record classes are implicitly `final`

    ```java
    ...
    sealed interface Expr
        permits ConstantExpr, PlusExpr, TimesExpr, NegExpr {
        public int eval();
    }

    record ConstantExpr(int i) implements Expr {
        public int eval() { return i(); }
    }

    record PlusExpr(Expr a, Expr b) implements Expr {
        public int eval() { return a.eval() + b.eval(); }
    }

    record TimesExpr(Expr a, Expr b) implements Expr {
        public int eval() { return a.eval() * b.eval(); }
    }

    record NegExpr(Expr e) implements Expr {
        public int eval() { return -e.eval(); }
    }
    ```