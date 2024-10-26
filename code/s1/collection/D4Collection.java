package s1.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class D4Collection {

    List<String> languages = new ArrayList<>();
    Collection<String> copiedLanguages = new ArrayList<>();
    List<String> immutableCopiedLanguages = new ArrayList<>();

    public void addingDataDemo() {
        System.out.println("\n1. Adding data to the list\n===================");
        languages.add("Java");
        languages.add("Python");
        languages.add("C#");
        languages.add("C++");
        languages.add("C");
        languages.add("JavaScript");
        languages.add("Go");
        languages.add("Perl");

        System.out.println("After adding : " + languages.toString());
    }

    public void removingDataDemo() {
        System.out.println("\n2. Removing data from the list\n=====================");
        languages.remove("Java");
        System.out.println("After removing by value : " + languages.toString());

        languages.remove(2);
        System.out.println("After removing by index : " + languages.toString());
    }

    public void countingElementsDemo()  {
        System.out.println("\n3. Counting elements in the list\n====================");
        int count = languages.size();
        System.out.println("Count of languages : " + count);
    }

    public void clearingCollectionDemo() {
        System.out.println("\n4. Clearing collection\n====================");
        copiedLanguages = new ArrayList<>(languages);
        immutableCopiedLanguages = List.copyOf(languages);
        languages.clear();
        System.out.println("After clearing collection : " + languages.toString());
    }

    public void checkContentDemo() {
        System.out.println("\n5. Checking collection\n====================");
        boolean containsJava = copiedLanguages.contains("Java");
        System.out.println("After checking languages contains java : " + containsJava);

        boolean containsPython = copiedLanguages.contains("Python");
        System.out.println("After checking languages contains python : " + containsPython);
    }

    public void removingWithConditionDemo() {
        System.out.println("\n6. Removing with condition\n=====================");
        System.out.println("Before removing with condition : " + immutableCopiedLanguages.toString());
        copiedLanguages.removeIf(language -> language.length() == 2);
        System.out.println("After removing with condition : " + copiedLanguages.toString());
    }

    public void iteratingDemo() {
        System.out.println("\n7. Iterating using iterator\n====================");

        System.out.println("7.1 Iterating using forEach\n---------------------");
        immutableCopiedLanguages.forEach(System.out::print);
        System.out.println();
        immutableCopiedLanguages.forEach(language -> System.out.print(language + " "));
        System.out.println();

        System.out.println("\n7.2 Iterating using iterator\n---------------------");
        Iterator<String> iterator = copiedLanguages.iterator();
        while(iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }

    public void determineEqualityDemo() {
        System.out.println("\n8. Determining equality\n====================");
        System.out.println("copiedLanguages : " + copiedLanguages.toString());
        System.out.println("immutableCopiedLanguages : " + immutableCopiedLanguages.toString());
        System.out.println("Is immutableCopiedLanguages equals copiedLanguages? " + immutableCopiedLanguages.equals(copiedLanguages));
        copiedLanguages.add("C#");
        copiedLanguages.add("Go");

        System.out.println("\ncopiedLanguages after adding missing values : " + copiedLanguages.toString());
        System.out.println("After adding missing values is immutableCopiedLanguages equals copiedLanguages? " + immutableCopiedLanguages.equals(copiedLanguages));

        List<String> lastCopyOfLanguages = List.copyOf(copiedLanguages);
        System.out.println("\nlastCopyOfLanguages : " + lastCopyOfLanguages.toString());
        System.out.println("Is lastCopyOfLanguages equals copiedLanguages? " + lastCopyOfLanguages.equals(copiedLanguages));

    }

    public static void main(String[] args) {
        D4Collection d4 = new D4Collection();
        d4.addingDataDemo();
        d4.removingDataDemo();
        d4.countingElementsDemo();
        d4.determineEqualityDemo();
        d4.clearingCollectionDemo();
        d4.removingWithConditionDemo();
        d4.checkContentDemo();
        d4.removingWithConditionDemo();
        d4.iteratingDemo();
        d4.determineEqualityDemo();
    }
}
