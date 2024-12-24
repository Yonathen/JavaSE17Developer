package s1.collection;

import java.util.LinkedList;
import java.util.Queue;

public class D5Queue {
    Queue<Integer> evenNumbers = new LinkedList<>();
    Queue<Integer> oddNumbers = new LinkedList<>();
    Queue<Integer> emptyNumbers = new LinkedList<>();

    public void demoAddingToQueue() {
        System.out.println("\n1. demoAddingToQueue\n===================");
        evenNumbers.add(2);
        evenNumbers.add(4);
        evenNumbers.add(6);
        System.out.println("evenNumbers after adding : " + evenNumbers);
        oddNumbers.offer(1);
        oddNumbers.offer(3);
        oddNumbers.offer(5);
        System.out.println("oddNumbers after offer : " + oddNumbers);
    }

    public  void demoReadFromQueue() {
        try {
            System.out.println("\n2. demoReadFromQueue\n===================");
            System.out.println("Return head of evenNumbers using element : " + evenNumbers.element());
            System.out.println("Return head of oddNumbers using peek : " + oddNumbers.peek());
            System.out.println("Return null on emptyNumbers when using peek : " + emptyNumbers.peek());
            System.out.print("Throws exception for using element on emptyNumbers : ");
            System.out.println("Return head of emptyNumbers using peek : " + emptyNumbers.element());
        } catch (Exception e) {
            System.err.println(e);
        }

    }

    public void demoRemovingFromQueue() {
        try {
            System.out.println("\n3. demoRemovingFromQueue\n===================");
            System.out.println("Return and remove head of evenNumbers using remove : " + evenNumbers.remove());
            System.out.println("Return and remove head of oddNumbers using peek : " + oddNumbers.poll());
            System.out.println("Return null on emptyNumbers when using peek : " + emptyNumbers.poll());
            System.out.print("Throws exception for using remove on emptyNumbers : ");
            System.out.println("Return and remove head of emptyNumbers using remove : " + emptyNumbers.remove());
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void main(String[] args) {
        D5Queue d5Queue = new D5Queue();
        d5Queue.demoAddingToQueue();
        d5Queue.demoReadFromQueue();
        d5Queue.demoRemovingFromQueue();
    }
}
