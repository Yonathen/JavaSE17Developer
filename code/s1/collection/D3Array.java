package s1.collection;

import java.util.Arrays;

public class D3Array {
    public  void printNames() {
        System.out.println("\n1. Creating an array with reference type\n===================");
        String[] names;
        names = new String[3];
        names[0] = "John";
        names[1] = "Jane";
        names[2] = "Doe";

        for( String name : names ){
            System.out.print(name + " ");
        }
    }

    public void printNumbers() {
        System.out.println("\n\n2. Creating and initializing with shortcut syntax\n===================");
        int[] numbers = { 100, 200, 300, 400, 500, 600, 700, 800, 900 };

        for( int number : numbers ){
            System.out.print(number + " ");
        }
    }

    public void arrayCopyDemo() {
        System.out.println("\n\n3. Demo of copy array\n===================");
        String[] names = { "John", "Jane", "Doe" };
        String[] namesCopy = new String[7];
        System.arraycopy(names, 0, namesCopy, 3, 3);
        for( String name : namesCopy ){
            System.out.print(name + " ");
        }

        System.out.println("\n\n3.1 Demo of java.util.Arrays.copyOfRange\n------------");
        int[] numbers = { 100, 200, 300, 400 }, numbersCopy;
        numbersCopy = Arrays.copyOfRange(numbers, 0, 2);
        for( int number : numbersCopy ){
            System.out.print(number + " ");
        }

    }

    public void arraySortDemo() {
        System.out.println("\n\n4. Sorting array\n===================");
        int[] numbers = {100, 200, 30, 400, 500, 6, 700, 80, 900};
        System.out.println("Before sorting: " + Arrays.toString(numbers));
        Arrays.sort(numbers);
        System.out.println("After sorting: " + Arrays.toString(numbers));

        System.out.println("\n\n4.1 Sorting string\n------------");
        String[] strNums = {"100", "200", "30", "400", "500", "6", "700", "80", "900"};
        System.out.println("Before sorting: " + Arrays.toString(strNums));
        Arrays.sort(numbers);
        System.out.println("After sorting: " + Arrays.toString(strNums));
    }

    public void arraySearchDemo() {

        System.out.println("\n\n5. Searching array\n===================");
        int[] numbers = {100, 200, 30, 400, 500, 6, 700, 80, 900};
        Arrays.sort(numbers);
        System.out.println("Searching 400: " + Arrays.binarySearch(numbers, 400));
        System.out.println("Searching 300: " + Arrays.binarySearch(numbers, 300));
        System.out.println("Searching 600: " + Arrays.binarySearch(numbers, 600));
        System.out.println("Searching 6: " + Arrays.binarySearch(numbers, 6));
        System.out.println("Searching 5: " + Arrays.binarySearch(numbers, 5));

    }

    public void arrayCompareDemo() {
        System.out.println("\n\n6. Compare array\n===================");
        int[] numbers = {100, 200, 300, 400, 500, 6, 700, 80, 900};
        int[] numbersCopy = Arrays.copyOf(numbers, numbers.length);
        int[] numbersCopy1 = Arrays.copyOf(numbers, 5);
        System.out.println("Array numbers: " + Arrays.toString(numbers));
        System.out.println("Array numbersCopy: " + Arrays.toString(numbersCopy));
        System.out.println("Array numbersCopy1: " + Arrays.toString(numbersCopy1));

        System.out.println("\n\n6.1 Equal arrays\n------------");
        System.out.println("Comparing numbers and numbersCopy : " + Arrays.compare(numbers, numbersCopy));

        System.out.println("\n\n6.2 First array is larger than second array\n------------");
        System.out.println("Comparing numbers and numbersCopy1 : " + Arrays.compare(numbers, numbersCopy1));

        System.out.println("\n\n6.2 First array is larger than second array\n------------");
        System.out.println("Comparing numbersCopy1 and numbers : " + Arrays.compare(numbersCopy1, numbers));
    }

    public void arrayMismatchDemo() {
        System.out.println("\n\n7. Mismatch array\n==================");
        System.out.println(Arrays.mismatch(new int[]{1}, new int[]{1}));
        System.out.println(Arrays.mismatch(new int[]{1, 2}, new int[]{1}));
        System.out.println(Arrays.mismatch(new String[]{"a"}, new String[]{"A"}));
    }

    public void multiDimensionalDemo() {
        System.out.println("\n\n8. Multidimensional array\n===================");
        int[][] twoDimInt = {{3}, {6,7,8}, {9,2}};
        for(int[] ints : twoDimInt){
            for (int value : ints){
                System.out.print(value + " ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        D3Array d3 = new D3Array();
        d3.printNames();
        d3.printNumbers();
        d3.arrayCopyDemo();
        d3.arraySortDemo();
        d3.arraySearchDemo();
        d3.arrayCompareDemo();
        d3.arrayMismatchDemo();
        d3.multiDimensionalDemo();
    }
}
