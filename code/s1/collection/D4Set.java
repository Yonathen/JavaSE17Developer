package s1.collection;

import java.util.HashSet;
import java.util.Set;

public class D4Set {
    Set<Integer> evenNumbers;
    Set<Integer> oddNumbers;
    Set<Integer> allNumbers;

    public void demoUnionOfTwoSets() {
        System.out.println("\n1. demoUnionOfTwoSets\n===================");
        evenNumbers = new HashSet<>(Set.of(2, 4, 6, 8, 10, 12, 14, 16));
        oddNumbers = new HashSet<>(Set.of(1, 3, 5, 7, 9, 11, 13, 15, 17, 19));
        allNumbers = new HashSet<>(Set.of(1, 2, 3, 4, 5, 6));
        allNumbers.addAll(evenNumbers);
        System.out.println("allNumbers after UNION with evenNumbers: " + allNumbers.toString());
        allNumbers.addAll(oddNumbers);
        System.out.println("allNumbers after UNION with oddNumbers: " + allNumbers.toString());

    }

    public void demoIntersectionOfTwoSets() {
        System.out.println("\n2. demoIntersectionOfTwoSets\n====================");
        allNumbers.retainAll(evenNumbers);
        System.out.println("allNumbers after INTERSECTION with evenNumbers: " + allNumbers.toString());
        allNumbers.retainAll(oddNumbers);
        System.out.println("allNumbers after INTERSECTION with oddNumbers: " + allNumbers.toString());
    }

    public void demoSubsetOfTwoSets() {
        System.out.println("\n3. demoSubsetOfTwoSets\n===================");
        allNumbers.addAll(evenNumbers);
        allNumbers.addAll(oddNumbers);
        System.out.println("All numbers : " + allNumbers.toString());
        System.out.println("evenNumbers is SUBSET of allNumbers : " + allNumbers.containsAll(evenNumbers));
        System.out.println("oddNumbers is SUBSET of allNumbers : " + allNumbers.containsAll(oddNumbers));

        allNumbers.removeAll(evenNumbers);
        System.out.println("After removing event numbers allNumbers : " + allNumbers.toString());
        System.out.println("After removing evenNumbers is evenNumbers : " + allNumbers.containsAll(evenNumbers));
    }

    public void demoDifferenceOfTwoSets() {
        System.out.println("\n4. demoDifferenceOfTwoSets\n====================");
        allNumbers.addAll(evenNumbers);
        allNumbers.addAll(oddNumbers);
        System.out.println("All numbers : " + allNumbers.toString());
        allNumbers.removeAll(oddNumbers);
        System.out.println("After the difference of oddNumbers and allNumbers : " + allNumbers.toString());
    }

    public static void main(String[] args) {
        D4Set set = new D4Set();
        set.demoUnionOfTwoSets();
        set.demoIntersectionOfTwoSets();
        set.demoSubsetOfTwoSets();
        set.demoDifferenceOfTwoSets();
    }
}
