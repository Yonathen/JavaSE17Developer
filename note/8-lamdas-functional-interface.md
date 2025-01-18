# Lambdas and Functional Interface
- Functional Programming : is a way of writing a code more declaratively
    - You specify what you want to do rather than dealing with the state of objects

    - Uses lambda expressions to write the code

    - Lambda Expression is a block of code that gets passed around.
        - Its like unnamed method existing inside an anonymous class
        - It has parameters and a body like a method but it does not have a method name

## Simple lambdas
- Lambdas is the short version of "Lambda Expression"
- Consider the following
    ```java
        public record Animal(String species, boolean canHop, boolean canSwim) {}

        public interface CheckTrait {
            boolean test(Animal a);
        }

        public class CheckIfHopper implements CheckTrait {
            public boolean test(Animal a) {
                return a.canHop();
            }
        }

        public class TraditionalSearch {
            public static void main(String[] args) {
                var animals = new ArrayList<Animal>();

                animals.add(new Animal("Fish", false, true));
                animals.add(new Animal("Kangaroo", true, false));
                animals.add(new Animal("Rabit", true, false));
                animals.add(new Animal("Turtle", false, true));

                print(animal, new CheckIfHopper());
            }

            public static void print(List<Animal> animals, CheckTrait checker) {
                for (Animal animal : animals) {
                    if (checker.test(animal)) {
                        System.out.print(animal + " ");
                    }
                }
                System.out.println();
            }
        }
    ```
    - `print(animal, new CheckIfHopper());` 
        - This is good but what happens if we want to print also Animals that can swim
            - then another `CheckIfSwim` on another file.
            - then add a new line `print(animal, new CheckIfSwim());`

        - This is where `lambdas` come
            - With lambdas we can just placce the logic right there as follows
                ```java
                    print(animals, a -> a.canHop())
                    print(animals, a -> a.canSwim())
                    print(animals, a -> !a.canSwim())
                    print(animals, a -> !a.canHop())
                ```

### Learning Lambda Syntax
- Syntax
    ```java
        a -> a.canHop();
        (Animal a) -> a.canHop();
        (Animal a) -> { return a.canHop(); }
    ```
    - the parenthesis around the paremeters can be omitted if and only if
        - the number of parameters is one
        - type is not specified explicitly
    - `;` and `return` statement omitted when you dont have braces

### Coding functional interfaces
- Lambdas have special relationship with such interfaces
- `Functional Interface`
    - is an interface that contains a single abstract method (SAM)
    - `@FunctionalInterface` annotation tells the compiler 
        - that you intend to use the code as functional interface.
        - If the interface does not follow the rules of SAM its a compilation error
        - Means the author of the interface promise it will be safe to use in a lambda in the future

    - Consider the following
        ```java
            @FunctionalInterface
            public interface Sprint {
                public void sprint(int speed);
            }
        ```

    - The following is also a valid functional interface
        ```java
            public interface Dash extends Sprint {}
        ```
    
    - The following is not a valid functional interface 
        - as they have multiple multiple abstract method
        ```java
            public interface Skip extends Spring {
                void skip();
            }
            public interface Sleep {
                private void snore() {}
                default int getZzzz() { return 1; }
            }
        ```
    - However, there is one exception to the SAM rule
        - That is implementing methods inherited from the Superclass `Object`
            - `public String toString()`
            - `public boolean equals(Object)`
            - `public int hashCode()`
        
        - The following are normal functional interfaces
            ```java
                public interface Dive {
                    String toString();
                    int hashCode();
                    boolean equals(Object o);
                    public void drive();
                }


                public interface Dive1 {
                    int hashCode();
                    public void drive();
                }
            ```
            - But the following are not a functional interface
                ```java

                    public interface Soar {
                        String toString();
                    }
                    public interface Soar1 {
                        boolean equals(Hibernate o);
                        public void drive();
                    }
                ```
                - `Soar` as it is part of the `Object` superclass
                    - it is not counted as a single abstract method (SAM)

                - `Soar1` has two abstract methods as the parameter for `equals`
                    - is `Hibernate` when it should have been `Object`

## Method References
- Another way of making the conde easier to read
    - by just simply metioning the name of the method

- Syntax
    ```java
        public interface LearnToSpeak {
            void speak(String sound);
        }
        public class DuckHelper {
            public static void teacher(String name, LearnToSpeak trainer) {
                trainer.speak(name);
            }
        }
        
        // ...
        LearnToSpeak learner = System.out::println;
        DuckHelper.teacher("QuackQuack", learner); // Prints : QuackQuack
    ```
    - `::` tels java to call the `println()` method
    - With lambda expression it should be like the following
        ```java
            LearnToSpeak learner = s -> System.out.println(s);
            DuckHelper.teacher("QuackQuack", learner);
        ```
        - There is a bit of redundancy
            - Declares one parameter named `s`
            - It's doing nothing except being passed as parameter to another method
            - As you seen above a method reference help us to remove this

- Method reference has four formats
    - static methods
    - Instance method on a particular object
    - Instance methods on a parameter to be determined at a runtime
    - Constructors

### Calling `static` Methods
- Consider the following
    ```java
        interface Converter {
            long round
        }

        Converter methodRef = Math::round;
        Converter lambda = s -> Math.round(x);

        System.out.println(methodRef.round(100.1)); // Prints : 100
    ```
    - `methodRef.round(100.1)`
        - Here we referenced a method with one parameter
        - Java knows that this is like lambda with one parameter

### Calling Instance Methods on a Particular Object
- Consider the following
    ```java
        interface StringStart {
            boolean beginningCheck(String prefix);
        }

        var str = "Zoo";
        StringStart methodRef = str::startsWith;
        StringStart lambda = s -> str.startsWith(s);

        System.out.println(methodRef.beginningCheck(s));
    ```
    - Here, we have used `str` string object to refer to `startWith`

- How about with no parameters?
    ```java
        interface StringChecker {
            boolean check();
        }

        var str = "";
        StringChecker methodRef = str::isEmpty;
        StringChecker lambda = () -> str.isEmpty();

        System.out.println(methodRef.check());
    ```

### Calling instance methods on a parameter
- Consider the following
    ```java
        interface StringParameterChecker {
            boolean check(String text);
        }

        StringParameterChecker methodRef = String::isEmpty;
        StringParameterChecker lambda = s -> s.isEmpty();

        System.out.println(methodRef.check("Zoo")); // Prints : false
    ```
    - `StringParameterChecker methodRef = String::isEmpty;`
        - Says the method that we want to call is declared in `String`
            - it looks like a static method but its not
            - Java knows that `isEmpty()` is instance method
                - that does not have any parameters
                - Therefore, java uses the parameter supplied at runtime as
                    - instance on which method is called
            
- You can even combine two types of instance method references
    - But here pay attention to the parameter order 
    ```java
        interface StringTwoParamChecker {
            boolean check(String text, String prefix);
        }

        StringTwoParamChecker methodRef = String::startsWith;
        StringTwoParamChecker lambda = (s, p) -> s.startsWith(p);

        System.out.println(methodRef.check("Zoo", "A")); // Prints : false
    ```
    - Here, java has to figure out what they represent also.
        - First, one will always be the instance of the object for instance methods
        - Any others are to be method parameters

### Calling Constructors
- Constructor reference is a special type of method reference
    - that uses a `new` keyword 
    - instead of a method and instantiates an object

- Consider the following
    ```java
        interface EmptyStringCreator {
            String create();
        }

        EmptyStringCreator methodRef = String::new;
        EmptyStringCreator lambda = () -> new String();

        var myString = methodRef.create();
        System.out.println(myString.equals("Zoo")); // False
    ```
    - `EmptyStringCreator methodRef = String::new`
        - Expands like method references

- Another Example
    ```java
        interface StringCopier {
            String copy(String value);
        }

        StringCopier methodRef = String::new;
        StringCopier lambda = s -> new String(s);

        var myString = methodRef.copy("Zoo");
        System.out.println(myString.equals("Zoo")); // Prints: True
    ```

## Working with Built-in Functional interfaces
- It would be inconvenient to write your own functional interface
    - any time you want to write a lambda.
- To solve this we have defined
    - general-purpose functional interfaces

### Implementing `Supplier`
- used to generate or supply values 
    - without taking any input

    ```java
        @FunctionalInterface
        public interface Supplier<T> {
            T get();
        }

        Supplier<LocalDate> s1 = LocalDate::now;
        Supplier<LocalDate> s2 = () -> LocalDate.now();

        LocalDate d1 = s1.get();
        LocalDate d2 = s2.get();

        System.out.println(d1);
        System.out.println(d2);

        Supplier<StringBuilder> s1 = StringBuilder::new;
        Supplier<StringBuilder> s2 = () -> new StringBuilder();

        System.out.println(s1.get()); // Empty string
        System.out.println(s2.get()); // Empty string
    ```


### Implementing `Consumer` and `BiConsumer`
- Use `Consumer` when you want to do something with a parameter
    - but not return anything

    - `BiConsumer` does the same thing except that it takes two parameters

    ```java
        @FunctionalInterface
        public interface Consumer<T> {
            void accept(T t);
        }

        @FunctionalInterface
        public interface BiConsumer<T, U> {
            void accept(T t, U u);
        }


        Consumer<String> c1 = System.out::println;
        Consumer<String> c2 = x -> System.out.println(x);

        c1.accept("Annie"); // Prints : Annie
        c2.accept("Annie"); // Prints : Annie

        var map = new HashMap<String, Integer>();
        BiConsumer<String, Integer> b1 = map::put;

        b1.accept("Chicken", 7);

        System.out.println(map);
    ```

- Convenience methods
    - `andThen()` : Method parameter is another `Consumer`

    ```java
        Consumer<String> c1 = x -> System.out.println("1: " + x);
        Consumer<String> c2 = x -> System.out.println(", 2: " + x);

        Consumer<String> combined = c1.andThen(c2)
        combined.accept("Annie"); // Prints : 1: Annie, 2: Annie
    ```

### Implementing `Predicate` and `BiPredicate`
- `Predicate` is often used when filtering or matching
- `BiPredicate` will take two argument
    ```java
        @FunctionalInterface
        public interface Predicate<T> {
            boolean test(T t);
        }

        @FunctionalInterface
        public interface BiPredicate<T, U> {
            boolean test(T t, U u);
        }

        Predicate<String> p1 = String::isEmpty;
        Predicate<String> p2 = x -> x.isEmpty();

        System.out.println(p1.test("")); // True
    ```

- Convenience methods
    - `and()`, `negate()`, and `or()`

        ```java

            Predicate<String> egg = s -> s.contains("egg");
            Predicate<String> brown = s -> s.contains("brown");

            Predicate<String> brownEgg = egg.and(brown);
            Predicate<String> otherEgg = egg.and(brown.negate());

            System.out.println("brown egg : " + brownEgg.test("brown egg")); // Prints : "brown egg : true"
            System.out.println("egg brown : " + brownEgg.test("egg brown")); // Prints : "egg brown : true"
            System.out.println("egg brown : " + otherEgg.test("egg brown")); // Prints : "egg brown : false"
            System.out.println("egg red : " + otherEgg.test("egg red")); // Prints : "egg red : true"
            System.out.println("ball red : " + otherEgg.test("ball red")); // Prints : "ball red : false"

        ```

### Implementing `Function` and `BiFunction`
- this is responsible for turning the parameter into
    - a value potentially different type and returning it

    ```java
        @FunctionalInterface
        public interface Function<T, R> {
            R apply(T t);
        }
        @FunctionalInterface
        public interface Function<T, U, R> {
            R apply(T t, U u);
        }

        Function<String, Integer> f1 = String::length;
        Function<String, Intefer> f2 = s -> s.length();

        System.out.println(f1.apply("Zoo"))

        BiFunction<String, String, String> b1 = String::concat;
        BiFunction<String, String, String> b2 = (s, t) -> s.concat(t);

        System.out.println(b1.apply("Tesing", " BiFunction")) // Prints : Testing BiFunction
    ```

- Convenience methods
    - `andThen` : Method parameter is another `Function`
    - `compose` : Chains the functional interface.
        - it passes the output of one to the input of the other
        ```java
            Function<Integer, Integer> before = x -> x + 1;
            Function<Integer, Integer> after = x -> x * 2;


            Function<Integer, Integer> composed = after.compose(before);
            System.out.println("compose : " + composed.apply(10)); // compose : 22

            Function<Integer, Integer> combined = after.andThen(before);
            System.out.println("andThen : " + combined.apply(10)); // andThen : 21
        ```


### Implementing `UnaryOperator` and `BinaryOperator`
- `UnaryOperator` and `BinaryOperator`
    - are special case of a Function
    - They require all type of parameters to be the same type.
    - It transforms to one of the same type and returns it

    ```java
        @FunctionalInterface
        public interface UnaryOperator<T> extends Function<T, T> {}

        @FunctionalInterface
        public interface BiFunction<T> extends Function<T, T, T> {}

        UnaryOperator<String> u1 = String::toUpperCase;
        System.out.println(u1.apply("Zoo"));

        BinaryOperator<String, String> b2 = String::concat;
        System.out.println(b2.apply("Binary", " Operator"));
    ```

## Functional Interfaces for Primitives
- Most of them are for `double`, `int` and `long` types

    | FunctionalInterface | SAM |
    | :---: | :---: |
    | **Supplier** |
    | BooleanSupplier | boolean getAsBoolean() |
    | DoubleSupplier | double getAsDouble() |
    | IntSupplier | int getAsInt() |
    | LongSupplier | long getAsLong() |
    | **Consumer** |
    | DoubleConsumer | void accept(double) |
    | IntConsumer | void accept(int) |
    | LongConsumer | void accept(long) |
    | **Predicate** |
    | DoublePredicate | boolean test(double) |
    | IntPredicate | boolean test(int) |
    | LongPredicate | boolean test(long) |
    | **Function** |
    | DoubleFunction | R apply(double) |
    | IntFunction | R apply(int) |
    | LongFunction | R apply(long) |
    | **UnaryOperator** |
    | DoubleUnaryOperator | double applyAsDouble(double) |
    | IntUnaryOperator | int applyAsInt(int) |
    | LongUnaryOperator | long applyAsLong(long) |
    | **BinaryOperator** |
    | DoubleBinaryOperator | double applyAsDouble(double, double) |
    | IntBinaryOperator | int applyAsInt(int, int) |
    | LongBinaryOperator | long applyAsLong(long, long) |

- Primitive specific functional interfaces

    | FunctionalInterface | SAM |
    | :---: | :---: |
    | **To_Function** |
    | ToDoubleFunction<T> | double applyAsDouble(T t) |
    | ToIntFunction<T> | int applyAsInt(T t) |
    | ToLongFunction<T> | long applyAsLong(T t) |
    | **To_BiFunction** |
    | ToDoubleBiFunction<T, U> | double applyAsDouble(T t, U u) |
    | ToIntBiFunction<T, U> | int applyAsInt(T t, U u) |
    | ToLongBiFunction<T, U> | long applyAsLong(T t, U u) |
    | **_To_Function** |
    | DoubleToIntFunction | int applyAsInt(double) |
    | DoubleToLongFunction | long applyAsLong(double) |
    | IntToDoubleFunction | double applyAsDouble(int) |
    | IntToLongFunction | long applyAsLong(int) |
    | LongToDoubleFunction | double applyAsDouble(long) |
    | LongToIntFunction | int applyAsInt(long) |
    | **Obj_Consumer** |
    | ObjDoubleConsumer | void accept(T t, double) |
    | ObjIntConsumer | void accept(T t, int) |
    | ObjLongConsumer | void accept(T t, long) |

## Working with variables
- Variables with lambdas
    - As parameter list
    - As local variables declared inside the lambda body
    - As variables referenced from lambda body

### Listing parameters
- specifying type of paramets is optional
- var can be used in place of specific type
- Compiler requires all parameters to use the same format
    ```java
        Predicate<String> p = x -> true;
        Predicate<String> p = (var x) -> true;
        Predicate<String> p = (String x) -> true;
    ```

### Referencing from lamda body
- it is legal to define a block
- The only thing lambda cannot access are variables that are not final or effectively final.
    - Otherwise, it can access instancece variable or method parameters
    - Instance Variable > Allowed
    - Static Variable > Allowed
    - Local Variables > Allowed if final or effectively final
    - Method parameter > Allowed if final or effectively final
    - Lambda parameter > Allowed