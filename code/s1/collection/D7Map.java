package s1.collection;

import java.util.*;

public class D7Map {
    Map<String, Integer> usersAge;
    Map<String, ArrayList<String>> healthyFoods;
    Map<String, Integer> usersCopyOfAge;

    public void demoCreatingAMap() {
        System.out.println("\n1. demoCreatingAMap\n===================");
        usersAge = new HashMap<>(Map.of("Tom", 23, "Linda", 18, "John", 13));
        usersCopyOfAge = Map.copyOf(usersAge);
        healthyFoods = new HashMap<>(Map.ofEntries(
                Map.entry("Fruits", new ArrayList<>(Arrays.asList("apple", "banana", "orange"))),
                Map.entry("Vegetables", new ArrayList<>(Arrays.asList("carrot", "Potato")))
        ));
        System.out.println("Creating usersAge : " + usersAge);
        System.out.println("Creating healthyFoods : " + healthyFoods);
        System.out.println("Creating usersCopyOfAge : " + usersCopyOfAge);
    }

    public void demoAddingItemsToMap() {
        System.out.println("\n2. demoAddingItemsToMap\n===================");
        usersAge.put("Marko", 55);
        System.out.println("usersAge after put Marko : " + usersAge);
        usersAge.putIfAbsent("Linda", 68);
        System.out.println("usersAge after putIfAbsent Linda : " + usersAge);
        usersAge.putIfAbsent("Doe", 25);
        System.out.println("usersAge after putIfAbsent Doe : " + usersAge);
        usersAge.putAll(Map.of("Roberto", 17, "Abebe", 67, "Selam", 23));
        System.out.println("usersAge after putAll : " + usersAge);
    }

    public void demoChangingItemsInMap() {
        System.out.println("\n3. demoChangingItemsInMap\n===================");
        usersAge.replace("Linda", 68);
        System.out.println("usersAge after replace Linda : " + usersAge);
        usersAge.replace("Doe", 25, 30);
        System.out.println("usersAge after replace Doe : " + usersAge);
        usersAge.replace("Roberto", 23, 40);
        System.out.println("usersAge after rejected replace Roberto : " + usersAge);
        System.out.println();

        usersAge.compute("Tom", (key, value) -> value * 2);
        System.out.println("usersAge after compute : " + usersAge);
        usersAge.computeIfAbsent("Mark", k -> 45);
        System.out.println("usersAge after computeIfAbsent for Mark : " + usersAge);
        usersAge.computeIfAbsent("Mark", k -> 45 * 2);
        System.out.println("usersAge after computeIfAbsent for Mark : " + usersAge);
        usersAge.computeIfPresent("Tom", (k, v) -> v * 2);
        System.out.println("usersAge after computeIfAbsent for Tom : " + usersAge);
        usersAge.computeIfPresent("Tom", (k, v) -> v * 2);
        System.out.println("usersAge after computeIfAbsent for Tom : " + usersAge);
    }

    public void demoAccessingItemsInMap() {
        System.out.println("\n4. demoAccessingItemsInMap\n===================");
        Integer ageOfLinda = usersAge.get("Linda");
        System.out.println("Age of Linda : " + ageOfLinda);
        System.out.println("Age of Mark : " + usersAge.getOrDefault("Mark", 10));
    }

    public void demoRemovingItemsFromMap() {
        System.out.println("\n5. demoRemovingItemsFromMap\n===================");
        usersAge.remove("Linda");
        System.out.println("usersAge after remove Linda : " + usersAge);
        usersAge.remove("Doe", 30);
        System.out.println("usersAge after remove Doe : " + usersAge);
        usersAge.remove("Roberto", 23);
        System.out.println("usersAge after rejected replace Roberto : " + usersAge);
    }

    public void demoMergingDataInAMap() {
        System.out.println("\n6. demoMergingDataInAMap\n===================");
        healthyFoods.merge(
                "Fruits",
                new ArrayList<>(Arrays.asList(new String[]{ "Orange", "Mango", "Pineapple", "Papaya", "Watermelon" })),
                (ArrayList<String> currentValues, ArrayList<String> newValues) -> {
                    currentValues.addAll(newValues);
                    return currentValues;
                }
        );
        System.out.println("healthyFoods after merging Fruits : " + healthyFoods);
    }

    public static void main(String[] args) {
        D7Map map = new D7Map();
        map.demoCreatingAMap();
        map.demoAddingItemsToMap();
        map.demoChangingItemsInMap();
        map.demoAccessingItemsInMap();
        map.demoRemovingItemsFromMap();
        map.demoMergingDataInAMap();
    }
}
