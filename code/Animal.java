public class Animal {
    static { System.out.print("A"); }
    { System.out.print("B"); }

    public Animal(String name) {
        this(1);
        System.out.print("C");
    }

    public Animal() {
        System.out.print("D");
    }

    public Animal(int num) {
        System.out.print("E");
    }
}

class Dog extends Animal {
    static { System.out.print("F"); }

    public Dog(int num) {
        super("Sugar");
        System.out.print("G");
    }
    { System.out.print("H"); }

    public static void main(String[] args) {
        new Dog(1);
        System.out.println();
        new Dog(2);
    }
}
