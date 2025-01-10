public class People {
    public static String name = "John";

    public static void main(String[] args) {
        var p1 = new People();
        System.out.println(People.name); // Prints John
        System.out.println(p1.name); // Prints John
        p1 = null;
        System.out.println(p1.name); // Prints John
    }
}
