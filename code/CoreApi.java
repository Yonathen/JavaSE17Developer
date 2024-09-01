import java.util.Map;
import java.util.Scanner;

public class CoreApi {
    public static void main(String[] args) {
        var name = "John Doe";
        int age = 30;
        String strValue = "1\\t2";
        System.out.println(strValue.translateEscapes()); // 1    2

        System.out.println("\n=====String====");
        System.out.println("---Concatenation---");
        System.out.println(1+2); // 3
        System.out.println("a" + "b"); // ab
        System.out.println(1 + 2 + "a" + "b"); // 3ab
        System.out.println("a" + "b" + 3); // ab3
        System.out.println("a" + "b" + 1 + 2); // ab12

        System.out.println("\n---String Length---");
        System.out.println("Length of String name: " + name.length());

        System.out.println("\n---Character At---");
        System.out.println("Character at index 6: " + name.charAt(6));
        System.out.println("Character at index 3: " + name.charAt(3));
        System.out.println("Character at index 1: " + name.charAt(0));

        System.out.println("\n---Index Of---");
        System.out.println(name.indexOf("a")); // 0
        System.out.println(name.indexOf("al")); // 4
        System.out.println(name.indexOf("a", 4)); // 4
        System.out.println(name.indexOf("al", 5)); // -1

        System.out.println("\n---Sub String---");
        System.out.println(name.substring(3)); // mals
        System.out.println(name.substring(3, 4)); // m
        System.out.println(name.substring(3, 7)); // mals
        System.out.println(name.substring(name.indexOf('D'))); // mal

        System.out.println("\n---Adjusting Case---");
        System.out.println("ABC123".toLowerCase()); // abc123
        System.out.println(name.toUpperCase()); // ANIMAL

        System.out.println("\n---Check for Equality---");
        System.out.println("abc".equals("ABC")); // false
        System.out.println("ABC".equals("ABC")); // true
        System.out.println("abc".equalsIgnoreCase("ABC")); // true

        System.out.println("\n---Search Substring---");
        System.out.println("abc".startsWith("a")); // true
        System.out.println("abc".startsWith("A")); // false
        System.out.println("abc".endsWith("c")); // true
        System.out.println("abc".endsWith("a")); // false
        System.out.println("abc".contains("bc")); // true

        System.out.println("\n---Replace a value---");
        System.out.println("abcabc".replace('a', 'A')); // AbcAbc
        System.out.println("abcabc".replace("a", "A")); // AbcAbc

        System.out.println("\n--Translating escapes---");
        System.out.println(strValue); // 1\t2
        System.out.println(strValue.translateEscapes()); // 1    2

        System.out.println("\n--Is Empty---");
        System.out.println(" ".isEmpty());  // false
        System.out.println("".isEmpty());  // true

        System.out.println("\n--Is Blank---");
        System.out.println(" ".isBlank()); // true
        System.out.println("".isBlank()); // true

        System.out.println("\n--Formatting Values---");
        System.out.println(String.format("Hello %s, Your order is %d", name, age));
        System.out.println("Hello %s, Your order is %d".formatted(name, age));


        System.out.println("\n=====System====");
        System.out.println("\n--System.in---");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String scannedName = scanner.nextLine();

        System.out.println("Hello, " + scannedName + "!");
        System.out.printf("Your age is: %d", 26);
        scanner.close();

        System.out.println("\n\n--System.err---");
        System.err.println("An error occurred: Invalid operations");

        System.out.println("\n--System Properties---");
        System.out.printf("System.getProperty : java.version = %s \n \n", System.getProperty("java.version"));
        System.setProperty("TestPropertyKey", "TestPropertyValue");
        System.out.printf("System.getProperty : TestPropertyKey = %s \n \n", System.getProperty("TestPropertyKey"));
        System.out.printf("System.getProperties : \n %s \n \n", System.getProperties());
        System.clearProperty("TestPropertyKey");
        System.out.printf("System.getProperties After Clear TestPropertyKey : \n %s \n \n", System.getProperties());
    
        System.out.println("\n--Environment Variables---");
        String path = System.getenv("PATH");
        System.out.println("System PATH: " + path);

        Map<String, String> envs = System.getenv();
        for (String envName : envs.keySet()) {
            System.out.format("%s=%s%n", envName, envs.get(envName));
        }


        System.out.println("\n--Time Measurement---");
        // Example: Measuring Execution Time
        long startTime = System.currentTimeMillis();

        // Simulate some operations
        performTimeConsumingTask();

        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println("Elapsed time in milliseconds: " + elapsedTime);

        // Example: High Precision Measurement
        long startNanoTime = System.nanoTime();

        // Execute a quick task
        quickTask();

        long endNanoTime = System.nanoTime();
        long elapsedNanoTime = endNanoTime - startNanoTime;
        System.out.println("Elapsed time in nanoseconds: " + elapsedNanoTime);
    }

    private static void performTimeConsumingTask() {
        try {
            Thread.sleep(2000); // Simulate a task that takes 2000 milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void quickTask() {
        for (int i = 0; i < 1000; i++) {
            int x = i * i; // Simple calculation
        }
    }
}