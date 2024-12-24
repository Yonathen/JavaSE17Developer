package s1.collection;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingDeque;

class DequeAsStack {
    static Deque<Integer> stackOfNumbers = new ArrayDeque<>();

    public static void demoPushOnTopOfStack() {
        System.out.println("\n4. demoPushOnTopOfStack\n===================");
        stackOfNumbers.push(4);
        stackOfNumbers.push(5);
        stackOfNumbers.push(6);
        stackOfNumbers.push(7);
        stackOfNumbers.push(8);
        stackOfNumbers.push(9);
        System.out.println("stackOfNumbers after push : " + stackOfNumbers);
    }

    public static void demoPopFromFromTomOfStack() {
        System.out.println("\n5. demoPopFromFromTomOfStack\n===================");
        Integer removedValue = stackOfNumbers.pop();
        System.out.println("stackOfNumbers after pop : " + stackOfNumbers + " Removed Value : " + removedValue);
        Integer removedValue0 = stackOfNumbers.pop();
        System.out.println("stackOfNumbers after pop : " + stackOfNumbers + " Removed Value : " + removedValue0);
        Integer removedValue1 = stackOfNumbers.pop();
        System.out.println("stackOfNumbers after pop : " + stackOfNumbers + " Removed Value : " + removedValue1);
        Integer removedValue2 = stackOfNumbers.pop();
        System.out.println("stackOfNumbers after pop : " + stackOfNumbers + " Removed Value : " + removedValue2);
    }

    public static void demoReadValueFromTopOfStack() {
        System.out.println("\n6. demoReadValueFromTopOfStack\n===================");
        System.out.println("Accessing top of the stack using : " + stackOfNumbers.peek());
    }
}

public class D6Deque {
    Deque<Integer> evenNumbers = new LinkedList<>();
    Deque<Integer> oddNumbers = new ArrayDeque<>();
    Deque<Integer> emptyNumbers = new ArrayDeque<>();
    Deque<Integer> blockingDeque = new LinkedBlockingDeque<>(1);

    public void demoAddingToDeque() {
        try {
            System.out.println("\n1. demoAddingToDeque\n===================");
            evenNumbers.addLast(2);
            evenNumbers.add(4);
            evenNumbers.addFirst(6);
            System.out.println("evenNumbers after adding : " + evenNumbers);
            oddNumbers.offerLast(1);
            oddNumbers.offer(3);
            oddNumbers.offerFirst(5);
            System.out.println("oddNumbers after offer : " + oddNumbers);

            blockingDeque.offerFirst(23);
            System.out.println("offerFirst Returns false for unsuccessful addition : "  + blockingDeque.offerFirst(88));
            System.out.print("Throws exception for using element on emptyNumbers : ");
            blockingDeque.addFirst(8);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public  void demoReadFromDeque() {
        try {
            System.out.println("\n2. demoReadFromDeque\n===================");
            System.out.println("Return head of evenNumbers using getFirst : " + evenNumbers.getFirst());
            System.out.println("Return head of evenNumbers using getLast : " + evenNumbers.getLast());
            System.out.println("Return head of oddNumbers using peekFirst : " + oddNumbers.peekFirst());
            System.out.println("Return head of oddNumbers using peekLast : " + oddNumbers.peekLast());
            System.out.println("Return null of emptyNumbers using peekLast : " + emptyNumbers.peekLast() + " or peakFirst : " + emptyNumbers.peekFirst());
            System.out.print("Throws exception for using getFirst / getLast on emptyNumbers : ");
            System.out.println(emptyNumbers.getFirst());
        } catch (Exception e) {
            System.err.println(e);
        }

    }

    public void demoRemovingFromDeque() {
        try {
            System.out.println("\n3. demoRemovingFromDeque\n===================");
            System.out.println("Return and remove head of evenNumbers using removeFirst : " + evenNumbers.removeFirst());
            System.out.println("Return and remove head of evenNumbers using removeLast : " + evenNumbers.removeLast());
            System.out.println("Return and remove head of oddNumbers using peekFirst : " + oddNumbers.peekFirst());
            System.out.println("Return and remove head of oddNumbers using peekLast : " + oddNumbers.peekLast());
            System.out.println("Return null on emptyNumbers when using peekLast : " + emptyNumbers.peekLast() + "or when using peekFirst : " + emptyNumbers.peekFirst());
            System.out.print("Throws exception for using removeFirst/removeLast on emptyNumbers : ");
            System.out.println(emptyNumbers.removeLast());
        } catch (Exception e) {
            System.err.println(e);
        }
    }


    public static void main(String[] args) {
        D6Deque d6 = new D6Deque();
        d6.demoAddingToDeque();
        d6.demoReadFromDeque();
        d6.demoRemovingFromDeque();

        System.out.println("\nUSING DEQUE TO CREATE AND MANIPULATE STACK");
        DequeAsStack.demoPushOnTopOfStack();
        DequeAsStack.demoReadValueFromTopOfStack();
        DequeAsStack.demoPopFromFromTomOfStack();
    }
}
