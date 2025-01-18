import java.util.function.Function;
import java.util.function.Predicate;

public class Lamda {

    public static void main(String[] args) {
        Function<Integer, Integer> before = x -> x + 1;
        Function<Integer, Integer> after = x -> x * 2;

        Function<Integer, Integer> combined = after.andThen(before);
        Function<Integer, Integer> composed = after.compose(before);

        System.out.println("compose : " + composed.apply(10));
        System.out.println("andThen : " + combined.apply(10));

        Predicate<String> egg = s -> s.contains("egg");
        Predicate<String> brown = s -> s.contains("brown");

        Predicate<String> brownEgg = egg.and(brown);
        Predicate<String> otherEgg = egg.and(brown.negate());

        System.out.println("brown egg : " + brownEgg.test("brown egg"));
        System.out.println("egg brown : " + brownEgg.test("egg brown"));
        System.out.println("egg brown : " + otherEgg.test("egg brown"));
        System.out.println("egg red : " + otherEgg.test("egg red"));
        System.out.println("ball red : " + otherEgg.test("ball red"));
    }
}