package s1.collection;

import java.util.*;

public class D3List {

    List<Integer> evenNumbers;
    List<Integer> oddNumbers;
    List<Integer> numbers;

    public void demoCreatingListWithFactoryMethod() {
        System.out.println("\n1. demoCreatingListWithFactoryMethod\n===================");
        String[] array = new String[] { "a", "b", "c", "d", "e", "f" };
        List<String> asList = Arrays.asList(array);
        List<String> of = List.of("a", "b", "c", "d", "e", "f");
        List<String> ofArray = List.of(array);
        List<String> copyOf = List.copyOf(asList);
        System.out.println("Arrays.asList : " + asList.toString());
        System.out.println("List.of by varargs: " + of.toString());
        System.out.println("List.of by Array : " + ofArray.toString());
        System.out.println("List.copyOf: " + copyOf.toString());

        System.out.println("\n1.2. Add / delete to asList, of, copyOf generates java.lang.UnsupportedOperationException\n-------------------");
        // asList.add("g"); // Should not compile
        // asList.remove("f"); // Should not compile
        // of.add("g"); // Should not compile
        // of.remove("f"); // Should not compile
        // copyOf.add("g"); // Should not compile
        // copyOf.remove("f"); // Should not compile

        System.out.println("\n1.2. replaceAll / set to asList\n-------------------");
        asList.replaceAll(item -> item + " - " + item);
        System.out.println("After asList.replaceAll : " + asList.toString());
        asList.set(2, "g");
        System.out.println("After asList.set : " + asList.toString());

        System.out.println("\n1.3. replaceAll / set to to of, copyOf generates java.lang.UnsupportedOperationException\n-------------------");
        // of.replaceAll(item -> item + " - " + item);
        // of.set(2, "g");
        // copyOf.replaceAll(item -> item + " - " + item);
        // copyOf.set(2, "g");
    }

    public void demoCreatingListWithConstructor() {
        System.out.println("\n2. demoCreatingListWithConstructor\n====================");
        Integer[] num = new Integer[] {1, 2, 3, 4, 5};
        evenNumbers = new ArrayList<>(10);
        oddNumbers = new LinkedList<>();
        numbers = new ArrayList<>(Arrays.asList(num));
        numbers.add(6);
        System.out.println("evenNumbers after creating with constructors : " + evenNumbers.toString());
        System.out.println("oddNumbers after creating with constructors : " + oddNumbers.toString());
        System.out.println("numbers after creating with constructors : " + numbers);

        System.out.println("\n2.1. Working with var\n-------------------");
        var l1 = new ArrayList<String>();
        l1.add("a");
        l1.add("b");
        for ( String s : l1 ) System.out.print(s + " - ");
        System.out.println();

        var l2 = new ArrayList<>();
        l2.add("c");
        l2.add("d");
        l2.add("e");

        System.out.println("2.1.1 This does not compile with error \"error: incompatible types: Object cannot be converted to String\" ");
        // for ( String s : l2 ) System.out.print(s + " - ");
        System.out.println();
        System.out.println("2.1.2 Can be fixed by changing the type from String to Object\" ");
        for ( Object s : l2 ) System.out.print(s + " - ");
        System.out.println();


    }

    public void demoAddingListItems() {
        System.out.println("\n3. demoAddingListItems\n====================");
        evenNumbers.add(2);
        evenNumbers.add(4);
        evenNumbers.add(6);
        System.out.println("evenNumbers after adding list items : " + evenNumbers.toString());
        oddNumbers.add(1);
        oddNumbers.add(3);
        oddNumbers.add(5);
        System.out.println("oddNumbers after adding list items : " + oddNumbers.toString());
        oddNumbers.add(3, 9);
        System.out.println("oddNumbers after adding on specific index of list items : " + oddNumbers.toString());

        System.out.println("\n3.1. Generates \"main\" java.lang.IndexOutOfBoundsException: Index: 5, Size: 4\n-------------------");
        // oddNumbers.add(5, 13);
        System.out.println();

        System.out.println("\n3.2. addAll elments of another collection\n-------------------");
        oddNumbers.addAll(evenNumbers);
        System.out.println("oddNumbers after add all list items : " + oddNumbers.toString());
    }

    public void demoAccessingListItems() {
        System.out.println("\n4. demoAccessingListItems\n====================");
        System.out.println("Accessing element of oddNumbers at index 3 : " + oddNumbers.get(3));

        System.out.println("\n4.1. Using iterator\n-------------------");
        Iterator<Integer> iterator = oddNumbers.iterator();
        while (iterator.hasNext()) System.out.print(iterator.next() + ", ");
        System.out.println();

        System.out.println("\n4.1. Using for each\n-------------------");
        oddNumbers.forEach(item -> System.out.print(item + ", "));
        System.out.println();
    }

    public void demoChangeListItems() {
        System.out.println("\n5. demoChangeListItems\n====================");
        oddNumbers.set(4, 11);
        System.out.println("oddNumbers after change list items : " + oddNumbers.toString());
        oddNumbers.replaceAll(item -> 2 * oddNumbers.indexOf(item) + 1);
        System.out.println("oddNumbers after replaceAll : " + oddNumbers.toString());
    }

    public void demoSortingListItems() {
        System.out.println("\n6. demoSortingListItems\n====================");
        oddNumbers.addAll(evenNumbers);
        oddNumbers.addAll(numbers);
        System.out.println("oddNumbers before sorting list items : " + oddNumbers.toString());

        System.out.println("\n6.1 Sorting in reverse order\n-------------------");
        oddNumbers.sort(Comparator.reverseOrder());
        System.out.println("oddNumbers after sorting list items in reverse order : " + oddNumbers.toString());

        System.out.println("\n6.2 Sorting by natural order\n-------------------");
        oddNumbers.sort(Comparator.naturalOrder());
        System.out.println("oddNumbers after sorting list items in natural order : " + oddNumbers.toString());
    }

    public void demoConvertingListToArray() {
        System.out.println("\n7. demoConvertingListToArray\n====================");

        System.out.println("\n7.1. by defaulting to Object\n-------------------");
        Object[] oddArray = oddNumbers.toArray();
        for ( Object val : oddArray ) System.out.print(val + ", ");
        System.out.println();

        System.out.println("\n7.2. by assigning type\n-------------------");
        Integer[] oddArray1 = oddNumbers.toArray(new Integer[0]);
        for ( Integer val1 : oddArray1 ) System.out.print(val1 + ", ");
        System.out.println();

    }

    public void demoRemovingListItems() {
        System.out.println("\n8. demoRemovingListItems\n====================");
        oddNumbers.remove(1);
        System.out.println("oddNumbers after removing item at index 1 : " + oddNumbers.toString());
        oddNumbers.removeIf(item -> item > 10);
        System.out.println("oddNumbers after removing items greater than 10 : " + oddNumbers.toString());
        oddNumbers.removeAll(List.of(5, 7));
        System.out.println("oddNumbers after removing selected Items : " + oddNumbers.toString());
        oddNumbers.removeAll(oddNumbers);
        System.out.println("oddNumbers after removing all Items : " + oddNumbers.toString());
    }

    public static void main(String[] args) {
        D3List d4 = new D3List();
        d4.demoCreatingListWithFactoryMethod();
        d4.demoCreatingListWithConstructor();
        d4.demoAddingListItems();
        d4.demoAccessingListItems();
        d4.demoChangeListItems();
        d4.demoSortingListItems();
        d4.demoConvertingListToArray();
        d4.demoRemovingListItems();
    }
}
