# Introduction
- is a standard package of Java SDK
- This package is useful as it provides
  - Collections like ArrayList, HashMap, Set
  - StinTokenizer for string operations
  - Utility classes for event model handling
  - Date and time operations
  - Enumerations
  - more

# Collections Framework
- Provides various interfaces that includes several methods
  - to perform different operations on collections
![Collection framework](./assets/Screenshot%20from%202024-09-03%2002-36-34.png)

## Collection Interface
- Root interface of the collection framework hierarchy
- Java does not provide implementation of Collection interface
  - but provides implelentations of its subinterfaces like
    - `List`, `Set`, and `Queue`
## List Interface
- An orderd collections that allows us to added and remove elements like an array

- Since list List is an interface we can not create an object from it
  - in order to use its functionality we can use the following classes that implements it
    - `ArrayList`
    - `LinkedList`
    - `Vector`
    - `Stack`

- Methods of `List`
  - `add()` : Adds an element to a list
  - `addAll()` : adds all elements of one list to another
  - `get()` : helps to randomly access elements from a list
  - `iterator()` : returns iterator object that can be used to sequentially access elements of a list
  - `set()` : changes elements of list
  - `remove()` : removes an element from a list
  - `removeAll()` : removes all elements from a list
  - `clear()` : removes all elementes from list (more efficient)
  - `size()` : returns the length of a list
  - `toArray()` : converts a list into an array
  - `contains()` : returns `true` if a list contains specific element

### ArrayList
- Used to implement resizable-arrays
- `ArrayList` Vs `Array`
  - Unlike `Array`, `ArrayList` can automically adjust its size
  - in `ArrayList` no need of setting its size before use

- Creating an `ArrayList`
  - Syntax
    ```java
    ArrayList<data_type> arrayList = new ArrayList<>();
    ```
  - Example
    ```java
    ArrayList<Integer> arrayList = new ArrayList<>();
    ArrayList<String> arrayList = new ArrayList<>();
    ```
#### Adding elements to an array list
  ```java
  import java.util.ArrayList;

  class Main {
    public static void main(String[] args){

      // create ArrayList
      ArrayList<String> languages = new ArrayList<>();

      // Add elements to ArrayList
      languages.add("Java");
      languages.add("Python");
      languages.add("Swift");
      System.out.println("ArrayList: " + languages);
    }
  }
  ```

#### Accessing elements of an array list
- to access an element form an array list use `get()` method
  ```java
  String str = languages.get(1);
  System.out.println("Elements at index 1: " + str);
  ```

#### Changing Array List Element
  ```java
  languages.set(2, "JS");
  System.out.println("ArrayList: " + languages);
  ```

#### Removing array list elements
  ```java
  languages.remove(2);
  System.out.println("ArrayList: " + languages);
  ```

#### Return the size of list
  ```java
  int size = languages.size();
  System.out.println("Size of languages: " + size);
  ```

#### Sorting array list
  ```java
  import java.util.Comparator;

  ...
  languages.sort(Comparator.naturalOrder());
  System.out.println("ArrayList: " + languages);

  languages.sort(Comparator.reverseOrder());
  System.out.println("ArrayList: " + languages);
  ...
  ```

#### Search the array list
  ```java
  boolean pythonExists = languages.contain("Python");
  System.out.println("Contains Python: " + pythonExists);
  ```

#### Specify the the total element of array list can contain
  ```java
  ArrayList<String> languages = new ArrayList<>();
  languages.ensureCapacity(10);

  languages.add("Java");
  ...
  ```

#### Check if the list is empty
  ```java
  boolean emptyLanguage = languages.isEmpty();
  System.out.println("Is Language Empty: " + emptyLanguage);
  ```

#### Search and return the index of an element
  ```java
  int indexOfJava = languages.indexOf("Java");
  System.out.println("Index of java is: " + indexOfJava);
  ```

#### Converting list to an array
  ```java
  ...
  // Convert ArrayList into an array
  languages.toArray(arr);

  // print all elements of the array
  System.out.print("Array: ");
  for(String item:arr) {
    System.out.print(item+", ");
  }
  ...
  ```

### LinkedList
- provides the functionality of the linked list data structure ( doubly linkedlist)
  ![Linked list](./assets/Screenshot%20from%202024-09-26%2020-20-11.png)

- Each element in a linked list is known as a node
  - Each node is consists of 
    - Prev - Stores an address of the previous element in the list
    - Next - stores an address of the next element in the list
    - Data - Stores the actual data

#### Creating LinkedList in a Java
  ```java
  import java.util.LinkedList;

  class Main {
    public static void main(String[] args) {
      LinkedList<String> animals = new LinkedList<>();

      animals.add("Dog");
      animals.add("Cat");

      System.out.println("Linked List : " + animals);
    }
  }
  ```

#### Access LinkedList elements
- `get()` method is used to access elements as follows
  ```java
  ...
  String animal = animals.get(1);
  System.out.println("Animal at index 1 : " + animal);
  ```

#### Change element of a LinkedList
- `set()` method is used to set an element in the specified index
  ```java
  ...
  animals.set(1, "Lion");
  System.out.println("Updated Linked list" + animals);
  ```

#### Remove elements from a LinkedList
- `remove()` method is used for removing an item from an element from a LinkedList
  ```java
  ...
  String removedAnimal = animals.remove(1);
  System.out.println("Removed Animal : " + removedAnimal);
  ```

#### Return the last index of the last occurance of the element
  ```java
  ...
  int lastIndex = animals.lastIndexOf("Lion");
  System.out.println("Last index of Lion is : " + lastIndex);
  ```

#### Returns an iterator to iterate over a LinkedList
  ```java
  ...
  import java.util.Iterator;

  ...
  Iterator<String> iterator = animals.iterator();
  while(iterator.hasNext()) {
    System.out.println(iterator.next());
  }
  ...
  ```

#### Other Methods
- contains()
- indexOf()
- clear()

### LinkedList as Deque and Queue
- `LinkedList` class also implements
  - `Queue` interface
  - `Deque` interface

- `Queue` Vs `Deque`
  ![Differences](./assets/Screenshot%20from%202024-09-26%2021-06-36.png)

### LinkedList as Deque
  ```java
  Deque<String> animals = new LinkedList<>();
  ```
#### Add specific element at the begining of the linked list
  ```java
  animals.addFirst("Elephant");
  System.out.println("Updated List : " + animals);
  ```

#### Adds specific element at the end of the linked list
  ```java
  animals.addLast("Deer");
  System.out.println("Updated List : " + animals);
  ```

#### Returns the first element
  ```java
  String firstAnimal = animals.getFirst();
  System.out.println("First Animal : " + firstAnimal);
  ```

#### Returns the last element
  ```java
  String lastAnimal = animals.getLast();
  System.out.println("Last Animal : " + lastAnimal);
  ```

#### Remove the first element
  ```java
  Sting removedFirstElt = animals.removeFirst();
  System.out.println("Removed Element : " + removedFirstElt);
  System.out.println("Updated List : " + animals);
  ```

#### Remove the last element
  ```java
  String removedLastElt = animals.removeLast();
  System.out.println("Removed Element : " + removedLastElt);
  System.out.println("Updated List : " + animals);
  ```

### LinkedList as Queue
  ```java
  Queue<String> animals = new LinkedList<>();
  ```
#### Access first element(head) of the linked list
  ```java
  String firstElement = animals.peek();
  System.out.println("First Element" + firstElement);
  ```

#### Access and remove the first element
  ```java
  Sting removedFirstElt = animals.poll();
  System.out.println("Removed Element : " + removedFirstElt);
  System.out.println("Updated List After Poll : " + animals);
  ```
#### Adds the specified element at the end of the linked list
  ```java
  animals.offer("Elephant");
  System.out.println("LinkedList after offer() : " + animals);
  ```

### Stack
- Here elements are stored and accessed in Last in First Out manner

#### Creating a stack
  ```java
  Stack<String> cars = new Stack<>();
  ```

#### Adding elements to a stack
  ```java
  ...
  cars.push("Audi")
  cars.push("Toyota")
  cars.push("Mazeda")
  System.out.println("Cars after push : " + cars)
  ```

#### Removing element from a stack
  ```java
  ...
  String lastInCar = cars.pop();
  System.out.println("Poped elt from stack" + lastInCar);
  ```

#### Access element from top
  ```java
  ...
  String elt = cars.peek();
  System.out.println("Top elt from stack" + elt);
  ```

#### Search element from stack
  ```java
  ...
  int position = cars.search("Audi");
  System.out.println("Position of Audi" + position);
  ```

#### Check if stack is empty
  ```java
  boolean result = animals.empty();
  System.out.println("Is the stack empty? " + result);
  ```

> [!NOTE]
> Use ArrayDeque Instead of Stack
>
> The Stack class provides the direct implementation of the stack data structure.
>
> However, it is recommended not to use it.
>
> Instead, use the ArrayDeque class (implements the Deque interface) to implement the stack data structure in Java.

## Set Interface 
- Allows us to store elements in different sets similar to set in maths
  - Can not have duplicate elements
- Classes that implement `set` interface are
  - `HashSet`
  - `LinkedHashSet`
  - `EnumSet`
  - `TreeSet`

- Interfaces that extend Set 
  - `SortedSet`
  - `NavigableSet`

- Methods of Set
  - `add()`
  - `addAll()`
  - `iterator()`
  - `remove()`
  - `removeAll()`
  - `retainAll()` : retains all elements in the set that are also present in another specified set
  - `clear()`
  - `clone()`
  - `size()`
  - `toArray()`
  - `contain()`
  - `containsAll()` : Returns true if the set contains all the elements of the specified collection
  - `hashCode()` : returns a has code value (address of the the element in the set)

- Set Operation
  - x UNION y : `x.addAll(y)`
  - x INTERSECTION y : `x.retainAll(y)`
  - x is a SUBSET y : `y.containsAll(x)`

### HashSet
- Provides the functionality of hash table

#### Creating a HashSet
```java
import java.util.Set;
import java.util.HashSet;

class Main {
  public static void main(String[] args) {
    // Creating a set using the HashSet class
    Set<Integer> set1 = new HashSet<>();

    // Add elements to the set1
    set1.add(2);
    set1.add(3);
    System.out.println("Set1: " + set1);

    // Creating another set using the HashSet class
    Set<Integer> set2 = new HashSet<>();

    // Add elements
    set2.add(1);
    set2.add(2);
    System.out.println("Set2: " + set2);

    // Union of two sets
    set2.addAll(set1);
    System.out.println("Union is: " + set2);
  }
}
```
- You can specify **capacity** and **loadFactor** as constructor parameter as follows
  ```HashSet<Integer> numbers = new HashSet<>(8, 0.75);```
  - **capacity** : it specifies the amount of elements it can store
    - By default it will be 16
  - **loadFactor** : The load factor of this hash set is 0.6. This means whenever our hash set is filled by 60% the elements are moved to a new hash table
    - By default it will be 0.7

#### Adding elements to HashSet
```java
...

    // Add elements
    set2.add(1);
    set2.add(2);
    System.out.println("Set2: " + set2);

    // Union of two sets
    set2.addAll(set1);
    System.out.println("Union is: " + set2);
...
```

#### Access HashSet
- We can use `iterator()` method from `java.util.Iterator`
```java
...
import java.util.Iterator;

...
  Iterator<Integer> iterator = set2.iterator();
  while(iterator.hasNext()) {
    System.out.println(iterator.next());
  }

```

#### Remove elements
```java
....
  boolean flag1 = set2.remove(5);
  System.out.println("Is 5 removed?" + flag1)

  boolean flag2 = set2.remove(set2);
  System.out.println("Are all elements removed" + flag2)
```

#### Union of two sets
```java
import java.utl.HashSet;

class Main {
  public class void main(String[] args) {
    HashSet<Integer> evenNumbers = new HashSet<>();
    evenNumbers.add(2);
    evenNumbers.add(4);
    evenNumbers.add(6);

    HashSet<Integer> oddNumbers = new HashSet<>();
    oddNumbers.add(1);
    oddNumbers.add(3);
    oddNumbers.add(5);

    // Union of two sets
    evenNumbers.addAll(oddNumbers);
    System.out.println("Unioin is : " + numbers);
  }
}
```

#### Intersection
```java
HashSet<Integer> primeNumbers = new HashSet<>();

primeNumbers.add(2);
primeNumbers.add(3);

...

evenNumbers.retainAll(primeNumbers);
System.out.println("Intersection is : " + evenNumbers);

```

#### Difference of set
```java
...
primeNumbers.removeAll(oddNumbers);
System.out.println("Difference is : " + primeNumbers);
```

#### Why HashSet?
- If we want to access elements randomly.
  - Becaue elements in a hash table are accessed using hash code

- Hash code of an element is a unique identity to identify element in a hash table

- `HashSet` can not contain duplicate elements
  - Hence each elment has a unicue hashcode

### LinkedHashSet
- Provides functionalities of both hashtable and linked list data structure
- Implements a set interface
- The linked list defines the order in which elements are inserted in a hash table

- Methods
  - `add()`
  - `addAll()`
  - `iterator()`
  - `remove()`
  - `removeAll()`
  - `retainAll()`
  - `clear()`
  - `clone()`
  - `size()`
  - `toArray()`
  - `contain()`
  - `containsAll()`
  - `hashCode()`

#### HashSet Vs LinkedHashSet
- `LinkedHashSet` - use linked list internaly
  - Hence it maintains the insetion order of its elements

- `LinkedHashSet` requires more storage

- `LinkedHashSet` is slower

### EnumSet
- Java `enums`
  - Short for enumerations
  - has fixed set of constants

  - Declaration 
    ```java
    enum Size {
      SMALL, MEDIUM, LARGE, EXTRALARGE
    }

    class Main {
      public static void main(String[] args) {
          System.out.println(Size.SMALL);
          System.out.println(Size.MEDIUM);
      }
    }
    ```
    - it shuld print
    ```
    SMALL
    MEDIUM
    ```
  
  - Java enums are a special kind of a class they can include fields and methods like any other class
  ```java
  enum Size{
    SMALL, MEDIUM, LARGE, EXTRALARGE;

    public String getSize() {

      // this will refer to the object SMALL
      switch(this) {
        case SMALL:
          return "small";

        case MEDIUM:
          return "medium";

        case LARGE:
          return "large";

        case EXTRALARGE:
          return "extra large";

        default:
          return null;
        }
    }

    public static void main(String[] args) {

      // call getSize()
      // using the object SMALL
      System.out.println("The size of the pizza is " + Size.SMALL.getSize());
    }
  }
  ```
#### Creating EnumSet
- In order to create an enum set
  - must import `java.util.EnumSet`
- Unlike other set implementation they dont have public constoructors
  - Instead we must use pre-defined methods to create an enum set

##### Using allOf(<EnumType.class>)
- Creates an EnumSet that contains all of the values of the specified enum type
  ```java
  import java.util.EnumSet;

  class Main {
      // an enum named Size
      enum Size {
          SMALL, MEDIUM, LARGE, EXTRALARGE
      }
      
      public static void main(String[] args) {

          // Creating an EnumSet using allOf()
          EnumSet<Size> sizes = EnumSet.allOf(Size.class);

          System.out.println("EnumSet: " + sizes);
      }

  }
  ```
##### Using noneOf(<EnumType.class>)
- Creates an empty EnumSet

  ```java
  ...
  EnumSet<Size> sizes = EnumSet.noneOf(Size.class);
  System.out.println("Empty EnumSet : " + sizes);
  ...
  ```

##### Using range(e1, e2) Method
- creates an enum set containing all values of an enum between e1 and e2

  ```java
  ...
  EnumSet<Size> sizes = EnumSet.range(Size.MEDIUM, Size.EXTRALARGE);
  System.out.println("Empty EnumSet : " + sizes);
  ...
  ```

##### Using of() Method
- creates an enum set containing the specified elements
  ```java
  ...
  // Using of() with a single parameter
  EnumSet<Size> sizes1 = EnumSet.of(Size.MEDIUM);
  System.out.println("EnumSet1: " + sizes1);

  EnumSet<Size> sizes2 = EnumSet.of(Size.SMALL, Size.LARGE);
  System.out.println("EnumSet2: " + sizes2);
  ...
  ```

#### Methods
  - `add()`
  - `addAll()`
  - `iterator()`
  - `remove()`
  - `removeAll()`
  - `retainAll()`
  - `clear()`
  - `clone()`
  - `size()`
  - `toArray()`
  - `contain()`
  - `containsAll()`
  - `hashCode()`

#### Clonable and Serializable Interfaces
- `EnumSet` is both Cloneable and Serializable
  - **Cloneable** allows `EnumSet` to make a copy of instances of the class
  - **Serializable**
    - Java Objects need to be transmitted over a network
      - And Objects need to be converted into bits or bytes since they can not be transmitted over a network

    - `Serializable` Interface allows classes to be serialized
      - This means objects of class implementing `Serializable` can be converted into bits or bytes

#### Why EnumSet?
- `EnumSet` provides an efficient way to store enum values than other set implementations like `HashSet`, `TreeSet`

- An enum set only stores enum vales of a specific enum

### TreeSet
- Provides a functionality of tree data structure

#### Creating a TreeSet
```java
import java.util.TreeSet;

class Main {
    public static void main(String[] args) {

        TreeSet<Integer> evenNumbers = new TreeSet<>();

        // Using the add() method
        evenNumbers.add(2);
        evenNumbers.add(4);
        evenNumbers.add(6);
        System.out.println("TreeSet: " + evenNumbers);
    }
}
```

#### Method for navigation
- Since the `TreeSet` class implements `NavigableSet`
  - it provides various methods to navigate over elements of the tree set
1. **first() and last() Methods**
```java
// Using the first() method
int first = numbers.first();
System.out.println("First Number: " + first);

// Using the last() method
int last = numbers.last();
System.out.println("Last Number: " + last);
```

2. **ceiling(), floor(), higher() and lower() Methods**
- **higher(element)** Returns the lowest element among those elements
  - that are greater than the specified `element`
- **lower(element)** Returns the greatest element among those elements
  - that are less than the specified `element`
- **ceiling(element)** Returns the lowest element among those elements that are greater than the specified `element`
  - if the `element` exists it returns the element passed as an argument
- **floor(element)** Returns the greatest element among those elements that are less than the specified `element`
  - if the `element` exists it returns the element passed as an argument
```java
import java.util.TreeSet;

class Main {
  public static void main(String[] args) {
    TreeSet<Integer> numbers = new TreeSet<>();
    numbers.add(2);
    numbers.add(5);
    numbers.add(4);
    numbers.add(6);
    System.out.println("TreeSet: " + numbers);

    // Using higher()
    System.out.println("Using higher: " + numbers.higher(4));

    // Using lower()
    System.out.println("Using lower: " + numbers.lower(4));

    // Using ceiling()
    System.out.println("Using ceiling: " + numbers.ceiling(4));

    // Using floor()
    System.out.println("Using floor: " + numbers.floor(3));

  }
}
```
4. **headSet(), tailSet() and subSet() Methods**
- **headSet(element, booleanValue)**
  - All elements of a tree set before specified element
  - By default `booleanValue` is `false`
    - if `true` is passed as `booleanValue`
      - it will include the specified element

- **tailSet(element, booleanValue)**
  - All elements of a tree set after the specified element
  - By default `booleanValue` is `false`
    - if `true` is passed as `booleanValue`
      - it will include the specified element

- **subSet(element1, booleanValue1, element2, booleanValue2)**
  - Returns all elements between e1 and e2, including e1
    - By default bv1 is true and bv2 is false
```java
import java.util.TreeSet;

class Main {
  public static void main(String[] args) {
    TreeSet<Integer> numbers = new TreeSet<>();
    numbers.add(2);
    numbers.add(5);
    numbers.add(4);
    numbers.add(6);
    System.out.println("TreeSet: " + numbers);

    //////////////////////////////////////////////////////

    // Using headSet() with default boolean value
    System.out.println("Using headSet without boolean value: " + numbers.headSet(5));

    // Using headSet() with specified boolean value
    System.out.println("Using headSet with boolean value: " + numbers.headSet(5, true));

    /////////////////////////////////////////////////////////
    
    // Using tailSet() with default boolean value
    System.out.println("Using tailSet without boolean value: " + numbers.tailSet(4));

    // Using tailSet() with specified boolean value
    System.out.println("Using tailSet with boolean value: " + numbers.tailSet(4, false));

    //////////////////////////////////////////////////////
    
    // Using subSet() with default boolean value
    System.out.println("Using subSet without boolean value: " + numbers.subSet(4, 6));

    // Using subSet() with specified boolean value
    System.out.println("Using subSet with boolean value: " + numbers.subSet(4, false, 6, true));
  }
}

```

#### Methods
  - `add()`
  - `addAll()`
  - `iterator()`
  - `remove()`
  - `removeAll()`
  - `retainAll()`
  - `clear()`
  - `clone()`
  - `size()`
  - `toArray()`
  - `contain()`
  - `containsAll()`
  - `hashCode()`

## Queue Interface
- Used when we want to store and access elements in FIFO manner
- Classes that implement `Queue` interface are
  - `ArrayDeque`
  - `LinkedList`
  - `PriorityQueue`

```java
// LinkedList implementation of Queue
Queue<String> animals1 = new LinkedList<>();

// Array Implementation of Queue
Quoue<String> animals2 = new ArrayDeque<>();

// Priority Queue implementation of Queue
Queue<String> animals3 = new PriorityQueue<>();
```

### Methods of Queue
- The Queue interface includes all the methods of the Collection interface.
- It is because Collection is the super interface of Queue.

- Some of the commonly used methods of the Queue interface are:

  - `add()` - Inserts the specified element into the queue. 
    - If the task is successful, `add()` returns `true`, if not it `throws` an `exception`.
  - `offer()` - Inserts the specified element into the queue.
    - If the task is successful, `offer()` returns `true`, if not it returns `false`.
  - `element()` - Returns the head of the queue. `Throws` an exception if the queue is `empty`.
  - `peek()` - Returns the head of the queue. Returns `null` if the queue is `empty`.
  - `remove()` - Returns and removes the head of the queue. Throws an exception if the queue is empty.
  - `poll()` - Returns and removes the head of the queue. Returns `null` if the queue is `empty`.

### PriorityQueue
- Unlike a normal queues, Priority Queue are retrived in sorted queue
- We want to retrive elements in ascending order
  - Head of priority queue will be the smallest element
  - Once this element is retrived, the next smallest element will be the head of the queue

#### Methods
  - `add()`
  - `addAll()`
  - `iterator()`
  - `remove()`
  - `removeAll()`
  - `retainAll()`
  - `clear()`
  - `clone()`
  - `size()`
  - `toArray()`
  - `contain()`
  - `containsAll()`
  - `hashCode()`

#### PriorityQueue Comparator
- By default priority queue elements are retrived based on a natuaral order
- However we can customize this using our own comparator class that implements `Comparator` interface
```java
import java.util.PriorityQueue;
import java.util.Comparator;
class Main {
    public static void main(String[] args) {

        // Creating a priority queue
        PriorityQueue<Integer> numbers = new PriorityQueue<>(new CustomComparator());
        numbers.add(4);
        numbers.add(2);
        numbers.add(1);
        numbers.add(3);
        System.out.print("PriorityQueue: " + numbers);
    }
}

class CustomComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer number1, Integer number2) {
        int value =  number1.compareTo(number2);
        // elements are sorted in reverse order
        if (value > 0) {
            return -1;
        }
        else if (value < 0) {
            return 1;
        }
        else {
            return 0;
        }
    }
}
```

### Deque Interface
```java
// Array Implementation of Deques
Deque<String> animal1 = new ArrayDeque<>();

// LinkedList Implementation of Deque
Deque<String> animal2 = new LinkedList<>();
```

- Besides methods available in the Queue interface, the Deque interface also includes the following methods:

  - `addFirst()` - Adds the specified element at the beginning of the deque. Throws an `exception` if the deque is full.
  - `addLast()` - Adds the specified element at the end of the deque. Throws an `exception` if the deque is full.
  - `offerFirst()` - Adds the specified element at the beginning of the deque. Returns `false` if the deque is full.
  - `offerLast()` - Adds the specified element at the end of the deque. Returns `false` if the deque is full.
  - `getFirst()` - Returns the first element of the deque. Throws an `exception` if the deque is empty.
  - `getLast()` - Returns the last element of the deque. Throws an `exception` if the deque is empty.
  - `peekFirst()` - Returns the first element of the deque. Returns `null` if the deque is empty.
  - `peekLast()` - Returns the last element of the deque. Returns `null` if the deque is empty.
  - `removeFirst()` - Returns and removes the first element of the deque. Throws an `exception` if the deque is empty.
  - `removeLast()` - Returns and removes the last element of the deque. Throws an `exception` if the deque is empty.
  - `pollFirst()` - Returns and removes the first element of the deque. Returns `null` if the deque is empty.
  - `pollLast()` - Returns and removes the last element of the deque. Returns `null` if the deque is empty.

#### Deque as Stack Data Structure
- Here are the methods the Deque interface provides to implement stack:

  - `push()` - adds an element at the beginning of deque
  - `pop()` - removes an element from the beginning of deque
  - `peek()` - returns an element from the beginning of deque

### LinkedList
- Each element in a linked list is known as `node`
- A `node` consists of
  - **prev** : stores an address of previous element. `null` for the first element
  - **next** : stores an address of the next element in the list. `null` for the last element
  - **data** : stores the actual data

#### Creating a java linked list
```java
import java.util.LinkedList;

class Main {
  public static void main(String[] args){

    // create linkedlist
    LinkedList<String> animals = new LinkedList<>();

    // Add elements to LinkedList
    animals.add("Dog");
    animals.add("Cat");
    animals.add("Cow");
    System.out.println("LinkedList: " + animals);
  }
}
```

### ArrayDeque
- This implements queue and deque data structures using array
- It implements two interfaces
  - **Queue Interface**
  - **Deque Interface**

#### Creating ArrayDeque
```java
// Creating String type ArrayDeque
ArrayDeque<String> animals = new ArrayDeque<>();

// Creating Integer type ArrayDeque
ArrayDeque<Integer> age = new ArrayDeque<>();
```

#### Inserting elements
1. **Using add, addFirst, and addLast**
  - If the array deque is full these methods throws `IllegalStateException`
  - `add()` : inserts element at the end of the array deque
  - `addFirst()` : inserts element at the beginning of the array deque
  - `addLast()` : inserts element at the end of the array(Equivalent to the `add()`)

2. **Using offer(), offerFirst() and offerLast()**
  - These methods has the same functionality to the above add function except in this case they will return `false` if the deque is full.

```java
import java.util.ArrayDeque;

class Main {
  public static void main(String[] args) {
    ArrayDeque<String> animals= new ArrayDeque<>();

    // Using add()
    animals.add("Dog");

    // Using addFirst()
    animals.addFirst("Cat");

    // Using addLast()
    animals.addLast("Horse");
    System.out.println("ArrayDeque: " + animals);

    //////////////////////////////////////////////

    ArrayDeque<String> animals1 = new ArrayDeque<>();
    // Using offer()
    animals1.offer("Dog");

    // Using offerFirst()
    animals1.offerFirst("Cat");

    // Using offerLast()
    animals1.offerLast("Horse");
    System.out.println("ArrayDeque: " + animals);
  }
}
```

#### Accessing elements
1. **Using getFirst() and getLast()**
- If the array deque is empty they throws `NoSuchElementException` is thrown
- `getFirst()` : returns the first element of the array deque
- `getLast()` : returns the last element of the array deque

2. **Using peek(), peakFirs(), and peakLast()**
- The same as the above get functions
```java
import java.util.ArrayDeque;

class Main {
  public static void main(String[] args) {
    ArrayDeque<String> animals= new ArrayDeque<>();
    animals.add("Dog");
    animals.add("Cat");
    animals.add("Horse");
    System.out.println("ArrayDeque: " + animals);

    // Get the first element
    String firstElement = animals.getFirst();
    System.out.println("First Element: " + firstElement);

    // Get the last element
    String lastElement = animals.getLast();
    System.out.println("Last Element: " + lastElement);

    /////////////////////////////////////////////////

    ArrayDeque<String> animals= new ArrayDeque<>();
    animals.add("Dog");
    animals.add("Cat");
    animals.add("Horse");
    System.out.println("ArrayDeque: " + animals);

    // Using peek()
    String element = animals.peek();
    System.out.println("Head Element: " + element);

    // Using peekFirst()
    String firstElement = animals.peekFirst();
    System.out.println("First Element: " + firstElement);

    // Using peekLast
    String lastElement = animals.peekLast();
    System.out.println("Last Element: " + lastElement);
  }
}
```

#### Remove ArrayDeque elements
1. **Using remove(), removeFirst(), and removeLast()**
- `remove()` : returns and removes the first element
  - throws `Exception` if the array is empty
- `remove(element)` : returns and removes the specified element
  - throws `Exception` if the element is not found
- `removeFirst()` : returns and removes the first element from the array
  - throws `Exception` if the array is empty
- `removeLast()` : returns and removes last element from the array
  - throws `Exception` if the array is empty

2. **Using poll(), pollFirst(), and pollLast()**
- returns null if the element is not found
- `poll()` : reutrns and removes the first element
- `pollFirst()`: returns and removes the first element
  - Equivalent with `poll()`
- `pollLast()` : returns and removes the last element of the array

3. **Using clear()**
- Removes all elements
```java
import java.util.ArrayDeque;

class Main {
  public static void main(String[] args) {
    ArrayDeque<String> animals= new ArrayDeque<>();
    animals.add("Dog");
    animals.add("Cat");
    animals.add("Cow");
    animals.add("Horse");
    System.out.println("ArrayDeque: " + animals);

    // Using remove()
    String element = animals.remove();
    System.out.println("Removed Element: " + element);

    System.out.println("New ArrayDeque: " + animals);

    // Using removeFirst()
    String firstElement = animals.removeFirst();
    System.out.println("Removed First Element: " + firstElement);

    // Using removeLast()
    String lastElement = animals.removeLast();
    System.out.println("Removed Last Element: " + lastElement);

    //////////////////////////////////////////////
    ArrayDeque<String> animals1= new ArrayDeque<>();
    animals1.add("Dog");
    animals1.add("Cat");
    animals1.add("Cow");
    animals1.add("Horse");
    System.out.println("ArrayDeque: " + animals1);

    // Using poll()
    String element = animals1.poll();
    System.out.println("Removed Element: " + element);
    System.out.println("New ArrayDeque: " + animals1);

    // Using pollFirst()
    String firstElement = animals1.pollFirst();
    System.out.println("Removed First Element: " + firstElement);

    // Using pollLast()
    String lastElement = animals1.pollLast();
    System.out.println("Removed Last Element: " + lastElement);

    ///////////////////////////////////////////
    ArrayDeque<String> animals2= new ArrayDeque<>();
    animals2.add("Dog");
    animals2.add("Cat");
    animals2.add("Horse");
    System.out.println("ArrayDeque: " + animals2);

    // Using clear()
    animals.clear();

    System.out.println("New ArrayDeque: " + animals2);
  }
}
```

#### Iterating the ArrayDeque
- `iterator()` : returns iterator that can be used to iterate through deque
- `descendingIterator()` : returns an iterator that can be used to iterate over array deque in reverse order
```java
import java.util.ArrayDeque;
import java.util.Iterator;

class Main {
  public static void main(String[] args) {
    ArrayDeque<String> animals= new ArrayDeque<>();
    animals.add("Dog");
    animals.add("Cat");
    animals.add("Horse");

    System.out.print("ArrayDeque: ");

    // Using iterator()
    Iterator<String> iterate = animals.iterator();
    while(iterate.hasNext()) {
      System.out.print(iterate.next());
      System.out.print(", ");
    }

    System.out.print("\nArrayDeque in reverse order: ");
    // Using descendingIterator()
    Iterator<String> desIterate = animals.descendingIterator();
    while(desIterate.hasNext()) {
      System.out.print(desIterate.next());
      System.out.print(", ");
    }
  }
}
```

#### ArrayDeque as a Stack
- Recommended to implement a stack datastructure
- Faster than `Stack` class
- has the following methods
  - `push()` - add element to the top of the stack
  - `pop()` - returns and removes the element from the top of the stack
  - `peek()` - retruns an element from the top of the stack
```java
import java.util.ArrayDeque;

class Main {
  public static void main(String[] args) {
    ArrayDeque<String> stack = new ArrayDeque<>();

    // Add elements to stack
    stack.push("Dog");
    stack.push("Cat");
    stack.push("Horse");
    System.out.println("Stack: " + stack);

    // Access element from top of stack
    String element = stack.peek();
    System.out.println("Accessed Element: " + element);

    // Remove elements from top of stack
    String remElement = stack.pop();
    System.out.println("Removed element: " + remElement);
  }
}
```

#### ArrayDeque Vs. LinkedList Class
- Both implement Deque interface
- `LinkedLsit` supporst `null` elements
  - `ArrayDeque` does not

- `LinkedList` requires more storage
  - since each node links to other nodes

- For implementing queue or deque
  - `ArrayDeque` is faster

## Map Interface
- Allows elements to be stored in key/Value pairs
- Keys are unique namest that can be used to access a particular element in map
  - Value is associated with each key

- Extends the following interfaces
  - `SortedMap`
  - `NavigableMap`
  - `ConcurrentMap`

- Classes that implelement Map
  - `HashMap`
  - `EnumMap`
  - `LinkedHashMap`
  - `WeakHashMap`
  - `TreeMap`

- How to use Map?
  ```java
  Map<key, value> numbers = new HashMap<>();
  ```
  - `key` : is a unique identifier
  - `value` : elements associated by keys in a map

- Methods of Map
  - `put(k, v)` : Insers the association of a key `k` and a value `v` into the map
  - `putAll()` : Insterts all entries from the specified map to this map
  - `putIfAbsent(k, v)` : Inserts the association if the key is not already associated with the value v
  - `get(k)` : Returns the value associated with the specified key `k`. 
    - If the key is not found it returns `null`
  - `getOrDefault(k, defaultVal)` : Returns the value associated with the specified `k`
    - If the key is not found it returns `defaultVal`
  - `containsKey(k)` : Checks if the specified key `k` exists on the map or not
  - `replace(k, v)` : Replace the value of the key `k` with the new specified value `v`
  - `replace(K, oldValue, newValue)` : Replace the value of the key `k` with the new value 
    - If and only if the key `k` is associated with the value `oldValue`
  - `remove(k)` : Removes the entry from the map represented by the key `k`
  - `remove(k, v)` : Removes the entry from the map that has key `k` associated with the value `v`
  - `keySet()` : Returns a set of all the keys present on the map
  - `values()` : Returns a set of all the values present on the map
  - `entrySet()` : Returns a set of all key/value mapping present on the map

```java
import java.util.Map;
import java.util.HashMap;

class Main {
  public static void main(String[] args) {
    // Creating a map using the HashMap
    Map<String, Integer> numbers = new HashMap<>();

    // Insert elements to the map
    numbers.put("One", 1);
    numbers.put("Two", 2);
    System.out.println("Map: " + numbers);

    // Access keys of the map
    System.out.println("Keys: " + numbers.keySet());

    // Access values of the map
    System.out.println("Values: " + numbers.values());

    // Access entries of the map
    System.out.println("Entries: " + numbers.entrySet());

    // Remove Elements from the map
    int value = numbers.remove("Two");
    System.out.println("Removed Value: " + value);
  }
}
```

### Hash Map
- Provides the functionality of hash table data structure

#### Creating a HashMap
- First import `java.util.HashMap`
```java
import java.util.HashMap;

class Main {
  public static void main(String[] args) {

    // create a hashmap
    HashMap<String, Integer> languages = new HashMap<>();

    // add elements to hashmap
    languages.put("Java", 8);
    languages.put("JavaScript", 1);
    languages.put("Python", 3);
    System.out.println("HashMap: " + languages);
  }
}
```

#### Adding elements to a HashMap
```java
...
languages.put("C", 12);
languages.put("C++", 21);
...
```
- You can also use
  - `putAll()` : Insterts all entries from the specified map to this map
  - `putIfAbsent(k, v)` : Inserts the association if the key is not already associated with the value v

#### Accessing HashMap
```java
...
languages.get("C");
languages.getOrDefault("GO", 26);
...
```
- You can also use
  - `keySet()` : Returns a set of all the keys present on the map
  - `values()` : Returns a set of all the values present on the map
  - `entrySet()` : Returns a set of all key/value mapping present on the map

#### Changing HashPap value
- We can use `replace()` as follows
```java
languages.replace("C", 67)
languages.replace("C++", 45)
languages.replace("Python", 3, 5)
```
- You can also use `replaceAll()`

#### Remove HashMap element
```java
languages.remove("C")
languages.remove("C", 21)
```

#### Compute a new value for a specified key
- Syntax
  ```java
  hashMap.compute(k key, BiFunction rempappingFunction)
  ```
  - `key` : with which the computed value is to be associated
  - `remappingFunction` - computes the new value for specified key
  - returns the new value associated with the key
    - returns `null` if no value associated with the key
```java
import java.util.HashMap;

class Main {
  public static void main(String[] args) {
    // create an HashMap
    HashMap<String, Integer> prices = new HashMap<>();

    // insert entries to the HashMap
    prices.put("Shoes", 200);
    prices.put("Bag", 300);
    prices.put("Pant", 150);
    System.out.println("HashMap: " + prices);

    // recompute the value of Shoes with 10% discount
    int newPrice = prices.compute("Shoes", (key, value) -> value - value * 10/100);
    System.out.println("Discounted Price of Shoes: " + newPrice);

    // print updated HashMap
    System.out.println("Updated HashMap: " + prices);
  }
}
```
- You can also use
  - `computeIfAbsent()`	computes value if a mapping for the key is not present
  - `computeIfPresent()`	computes a value for mapping if the key is present

#### Other methods
  - `merge()`	merges the specified mapping to the HashMap
  - `clone()`	makes the copy of the HashMap
  - `containsKey()`	checks if the specified key is present in Hashmap
  - `containsValue()`	checks if Hashmap contains the specified value
  - `size()`	returns the number of items in HashMap
  - `isEmpty()`	checks if the Hashmap is empty

#### Iterating through a HashMap
- Iterating through keys only
  ```java
  for ( Integer key : languages.keySet() ) {
    System.out.println(key);
  }
  ```
- Iterating through values only
  ```java
  for ( Integer key : languages.values() ) {
    System.out.println(key);
  }
  ```
- Iterating through key/value entries
  ```java
  ....
  import java.util.Map.Entry;
  ...
  for (Entry<Integer, String> entry : languages.entrySet()) {
    System.out.println(entry);
  }
  ```

### LinkedHashMap
- Provides hash table and linked list implementation of the Map iterface

#### Creating LinkedHashMap
```java
import java.util.LinkedHashMap;

class Main {
  public static void main(String[] args) {
    // Creating a LinkedHashMap of even numbers
    LinkedHashMap<String, Integer> evenNumbers = new LinkedHashMap<>();
    evenNumbers.put("Two", 2);
    evenNumbers.put("Four", 4);
    System.out.println("LinkedHashMap1: " + evenNumbers);

    // Creating a LinkedHashMap from other LinkedHashMap
    LinkedHashMap<String, Integer> numbers = new LinkedHashMap<>(evenNumbers);
    numbers.put("Three", 3);
    System.out.println("LinkedHashMap2: " + numbers);
  }
}
```

- Methods are similar to the HashMap

#### LinkedHashMap Vs. HashMap
- Both implements `Map` interface
- `LinkedHashMap` preserves a doubly-linked list internally.
  - So it maintains the insertion order of its elements
- `LinkedHasMap` requires more storage
- `LinkedHashMap` has slower performance

### WeakHashMap
- provides a hash table data structure

#### Creating a WeakHashMap
- Syntax
  ```java
  // WeakHashMap with default capacity and load factor
  WeakHashMap<Key, Value> numbers1 = new WeakHashMap<>();
  ```
  - Default 
    - Capacity = 16
    - load factor = 0.75

#### HashMap Vs. WeakHashMap
- Consider the following
  ```java
  import java.util.WeakHashMap;

  class Main {
    public static void main(String[] args) {
      // Creating WeakHashMap of numbers
      WeakHashMap<String, Integer> numbers = new WeakHashMap<>();

      String two = new String("Two");
      Integer twoValue = 2;
      String four = new String("Four");
      Integer fourValue = 4;

      // Inserting elements
      numbers.put(two, twoValue);
      numbers.put(four, fourValue);
      System.out.println("WeakHashMap: " + numbers);

      // Make the reference null
      two = null;

      // Perform garbage collection
      System.gc();

      System.out.println("WeakHashMap after garbage collection: " + numbers);
    }
  }
  ```
  - the out put will be
    ```
    WeakHashMap: {Four=4, Two=2}
    WeakHashMap after garbage collection: {Four=4}
    ```
  - As shown in the result
    - when key two of `WeakHashMap` is set to null
    - And gabage collection is performed
      - Then the key is removed
  
  - This is because unlike hash maps
    - Keys of `WeakHashMap` are removed by garbase collectory if that entry is no longer used.
    - useful to save resoruces

  - Where as in `HashMap` keys are of **strong reference**
    - i.e : the entry of the map is not removed by garbage collector, even though the key to that entry is no longer used

> [!NOTE]
> All functionalities of hashmaps and weak hashmaps are similar
>
> Except keys of a weak hashmap are of weak reference,
>
> Whereas keys of a hashmap are of strong reference.

### EnumMap
- Provides a map implementation for elements of an enum

#### Creating an EnumMap
- First import `java.util.EnumMap`
- Create the enum
- then create enum map based on the enum
  ```java
  import java.util.EnumMap;

  class Main {

    enum Size {
      SMALL, MEDIUM, LARGE, EXTRALARGE
    }
    public static void main(String[] args) {
      // Creating an EnumMap of the Size enum
      EnumMap<Size, Integer> sizes1 = new EnumMap<>(Size.class);

      // Using the put() Method
      sizes1.put(Size.SMALL, 28);
      sizes1.put(Size.MEDIUM, 32);
      System.out.println("EnumMap1: " + sizes1);

      EnumMap<Size, Integer> sizes2 = new EnumMap<>(Size.class);

      // Using the putAll() Method
      sizes2.putAll(sizes1);
      sizes2.put(Size.LARGE, 36);
      System.out.println("EnumMap2: " + sizes2);
    }
  }
  ```

#### EnumMap Vs. EnumSet
- Both provides data strucutes to store enum values
- `EnumSet` is represented internally as a sequense of bits
  - `EnumMap` is represented internaly as arrays
- `EnumSet` is created using its predifined methods like `allOf()`, `noneOf()`, `of()`
  - `EnumMap` is created using its constructor

> [!NOTE]
> Methods are similar to the `HashMap`
>
> `EnumMap` class also implements `Clonable` and `Serializable` interfaces

### TreeMap
- Provides Tree data structure implementation
- Implemants the following interfaces
  - `SortedMap`
  - `NavigableMap`
  - Both extends `Map` interface

#### Creating a TreeMap
- First import `java.util.TreeMap`
- Then use the constructor to create the `TreeMap`
- Syntax
  ```java
  TreeMap<key, value> numbers = new TreeMap<>();
  ```


```java
import java.util.TreeMap;

class Main {
  public static void main(String[] args) {
    // Creating TreeMap of even numbers
    TreeMap<String, Integer> evenNumbers = new TreeMap<>();

    // Using put()
    evenNumbers.put("Two", 2);
    evenNumbers.put("Four", 4);

    // Using putIfAbsent()
    evenNumbers.putIfAbsent("Six", 6);
    System.out.println("TreeMap of even numbers: " + evenNumbers);

    //Creating TreeMap of numbers
    TreeMap<String, Integer> numbers = new TreeMap<>();
    numbers.put("First", 1);
    numbers.put("Second", 2);
    numbers.put("Third", 3);
    numbers.put("Fourth", 4);

    // Using putAll()
    numbers.putAll(evenNumbers);
    System.out.println("TreeMap of numbers: " + numbers);
  }
}
```

> [!NOTE]
> Inserting, Accessing, Removing, Changing Methods are Similar to `HashMap`


#### Methods of Navigation
- `TreeMap` implements `NavigableMap`
  - And `NavigableMap` provides various methods for
    - navigating over the elements of a tree map

##### First and Last element
- `firstKey()` - returns the first key of the map
- `firstEntry()` - returns the key/value mapping of the first key of the map
- `lastKey()` - returns the last key of the map
- `lastEntry()` - returns the key/value mapping of the last key of the map
  ```java
  // Using the firstKey() method
  String firstKey = numbers.firstKey();
  System.out.println("First Key: " + firstKey);

  // Using the lastKey() method
  String lastKey = numbers.lastKey();
  System.out.println("Last Key: " + lastKey);

  // Using firstEntry() method
  System.out.println("First Entry: " + numbers.firstEntry());

  // Using the lastEntry() method
  System.out.println("Last Entry: " + numbers.lastEntry());
  ```
  - Outputs
    ```
    TreeMap: {First=1, Second=2, Third=3}
    First Key: First
    Last Key: Third
    First Entry: First=1
    Last Entry: Third=3
    ```

##### Ceiling, Floor, Higher and Lower
- `higherKey()` - Returns the lowest key among
  - those keys that are greater than the specified key
- `higherEntry()` - Returns an entry associated with a key that is lowest among 
  - all those keys greater than the specified key.
- `lowerKey()` - Returns the greatest key among
  - all those keys that are less than the specified key.
- `lowerEntry()` - Returns an entry associated with a key that is greatest among
  - all those keys that are less than the specified key.
- `ceilingKey()` - Returns the lowest key among
  - those keys that are greater than the specified key.
  - If the key passed as an argument is present in the map, it returns that key.
- `ceilingEntry()` - Returns an entry associated with a key that is lowest among
  - those keys that are greater than the specified key.
  - It an entry associated with the key passed an argument is present in the map, it returns the entry associated with that key.
- `floorKey()` - Returns the greatest key among
  - those keys that are less than the specified key.
  - If the key passed as an argument is present, it returns that key.
- `floorEntry()` - Returns an entry associated with a key that is greatest among
  - those keys that are less than the specified key.
  - If the key passed as argument is present, it returns that key.

  ```java
  import java.util.TreeMap;

  class Main {
    public static void main(String[] args) {
      TreeMap<String, Integer> numbers = new TreeMap<>();
      numbers.put("First", 1);
      numbers.put("Second", 5);
      numbers.put("Third", 4);
      numbers.put("Fourth", 6);
      System.out.println("TreeMap: " + numbers);

      // Using higher()
      System.out.println("Using higherKey(): " + numbers.higherKey("Fourth"));
      System.out.println("Using higherEntry(): " + numbers.higherEntry("Fourth"));

      // Using lower()
      System.out.println("\nUsing lowerKey(): " + numbers.lowerKey("Fourth"));
      System.out.println("Using lowerEntry(): " + numbers.lowerEntry("Fourth"));

      // Using ceiling()
      System.out.println("\nUsing ceilingKey(): " + numbers.ceilingKey("Fourth"));
      System.out.println("Using ceilingEntry(): " + numbers.ceilingEntry("Fourth"));

      // Using floor()
      System.out.println("\nUsing floorKey(): " + numbers.floorKey("Fourth"));
      System.out.println("Using floorEntry(): " + numbers.floorEntry("Fourth"));
    }
  }

  ```
  - The Output
    ```
    TreeMap: {First=1, Fourth=6, Second=5, Third=4}
    Using higherKey(): Second
    Using higherEntry(): Second=5

    Using lowerKey(): First
    Using lowerEntry(): First=1

    Using ceilingKey(): Fourth
    Using ceilingEntry(): Fourth=6

    Using floorkey(): Fourth
    Using floorEntry(): Fourth=6
    ```

##### pollFirstEntry() and pollLastEntry() Methods
- `pollFirstEntry()` - returns and removes the entry associated with the first key of the map
- `pollLastEntry()` - returns and removes the entry associated with the last key of the map
  ```java
  System.out.println("Using pollFirstEntry(): " + numbers.pollFirstEntry());

  System.out.println("Using pollLastEntry(): " + numbers.pollLastEntry());

  System.out.println("Updated TreeMap: " + numbers);
  
  ```

##### headMap(), tailMap(), and subMap() Methods
1. `headMap(key, booleanValue)`
  - returns all the key/value pairs before the specified `key`
  - If `booleanValue` is set to `true`
    - it will include the key/value pair of the `key` passed
    - default is `false`

  ```java
  System.out.println("Without boolean value: " + numbers.headMap("Fourth"));

  System.out.println("With boolean value: " + numbers.headMap("Fourth", true));
  ```

2. `tailMap(key, booleanValue)`
  - returns all the key/value pairs after the specified `key`
  - If `booleanValue` is set to `true`
    - it will include the key/value pair of the `key` passed
    - default is `false`

  ```java
  // Using tailMap() with default booleanValue
  System.out.println("Without boolean value: " + numbers.tailMap("Second"));

  // Using tailMap() with specified booleanValue
  System.out.println("With boolean value: " + numbers.tailMap("Second", false));
  ```

3. `subMap(k1, bV1, k2, bV2)`
  - returns all the entries associated with keys
    - between `k1` and `k2` including the entry of `k1`.

  - The `bV1` and `bV2` are optional boolean parameters. 
    - The default value of `bV1` is `true` and
    - The default value of `bV2` is `false`.

  ```java
  System.out.println("Without boolean value: " + numbers.subMap("Fourth", "Third"));

  System.out.println("With boolean value: " + numbers.subMap("Fourth", false, "Third", true));
  ```

#### TreeMap Comparator
- In this case the elements in `TreeMap` are sorted naturally in ascending order
- To customize this sorting behaviour use `Comparator` interface

  ```java
  import java.util.TreeMap;
  import java.util.Comparator;

  class Main {
    public static void main(String[] args) {

      // Creating a treemap with a customized comparator
      TreeMap<String, Integer> numbers = new TreeMap<>(new CustomComparator());

      numbers.put("First", 1);
      numbers.put("Second", 2);
      numbers.put("Third", 3);
      numbers.put("Fourth", 4);
      System.out.println("TreeMap: " + numbers);
    }

    // Creating a comparator class
    public static class CustomComparator implements Comparator<String> {

      @Override
      public int compare(String number1, String number2) {
        int value =  number1.compareTo(number2);

        // elements are sorted in reverse order
        if (value > 0) {
            return -1;
        }
        else if (value < 0) {
            return 1;
        }
        else {
            return 0;
        }
      }
    }
  }
  ```
  - The output will be
    ```
    TreeMap: {Third=3, Second=2, Fourth=4, First=1}
    ```

#### Methods of SortedMap
- Syntax
  ```java
  // SortedMap implementation by TreeMap class
  SortedMap<Key, Value> numbers = new TreeMap<>();
  ```

- Here are the methods specific to `SortedMap`
  - `comparator()` - returns a comparator that can be used to order keys in a map
  - `firstKey()` - returns the first key of the sorted map
  - `lastKey()` - returns the last key of the sorted map
  - `headMap(key)` - returns all the entries of a map whose keys are less than the specified key
  - `tailMap(key)` - returns all the entries of a map whose keys are greater than or equal to the specified key
  - `subMap(key1, key2)` - returns all the entries of a map whose keys lies in between key1 and key2 including key1

  ```java
  import java.util.SortedMap;
  import java.util.TreeMap;

  class Main {

    public static void main(String[] args) {
      // Creating SortedMap using TreeMap
      SortedMap<String, Integer> numbers = new TreeMap<>();

      // Insert elements to map
      numbers.put("Two", 2);
      numbers.put("One", 1);
      System.out.println("SortedMap: " + numbers);


      // Access the first key of the map
      System.out.println("First Key: " + numbers.firstKey());

      // Access the last key of the map
      System.out.println("Last Key: " + numbers.lastKey());

      // Remove elements from the map
      int value = numbers.remove("One");
      System.out.println("Removed Value: " + value);
    }
  }
  ```

### ConcurrentMap Interface and ConcurrentHashMap
- The ConcurrentMap interface of the Java collections framework provides a thread-safe map.
- That is, multiple threads can access the map at once without affecting the consistency of entries in a map.
- `ConcurrentMap` is known as a synchronized map.
```java
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentHashMap;

class Main {

    public static void main(String[] args) {
        // Creating ConcurrentMap using ConcurrentHashMap
        ConcurrentMap<String, Integer> numbers = new ConcurrentHashMap<>();

        // Insert elements to map
        numbers.put("Two", 2);
        numbers.put("One", 1);
        numbers.put("Three", 3);
        System.out.println("ConcurrentMap: " + numbers);

        // Access the value of specified key
        int value = numbers.get("One");
        System.out.println("Accessed Value: " + value);

        // Remove the value of specified key
        int removedValue = numbers.remove("Two");
        System.out.println("Removed Value: " + removedValue);
    }
}
```
#### Bulk ConcurrentHashMap Operations
1. `forEach(`) Method
  - The `forEach()` method iterates over our entries and executes the specified function.

  - It includes two parameters.
    - `parallelismThreshold` - It specifies that after how many elements operations in a map are executed in parallel.
    - `transformer` - This will transform the data before the data is passed to the specified function.

  ```java
  numbers.forEach(4, (k, v) -> System.out.println("key: " + k + " value: " + v));

  // forEach() with transformer function
  System.out.print("Values are ");
  numbers.forEach(4, (k, v) -> v, (v) -> System.out.print(v + ", "));
  ```
  - In the above program, we have used parallel `threshold` 4. This means if the map contains 4 entries, the operation will be executed in parallel.

  - Variation of forEach() Method
    - `forEachEntry()` - executes the specified function for each entry
    - `forEachKey()` - executes the specified function for each key
    - `forEachValue()` - executes the specified function for each value

2. `search()` Method
  - The `search()` method searches the map based on the specified function and returns the matched entry.
    ```java
    String key = numbers.search(4, (k, v) -> {return v == 3 ? k: null;});
    System.out.println("Searched value: " + key);
    ```
  - Variants of `search()` Method

    - `searchEntries()` - search function is applied to key/value mappings
    - `searchKeys()` - search function is only applied to the keys
    - `searchValues()` - search function is only applied to the values

3. `reduce()` Method
  - The `reduce()` method accumulates (gather together) each entry in a map.
  - This can be used when we need all the entries to perform a common task, like adding all the values of a map.

  - It includes two parameters.

    - `parallelismThreshold` - It specifies that after how many elements, operations in a map are executed in parallel.
    - `transformer` - This will transform the data before the data is passed to the specified function.

    ```java
    int sum = numbers.reduce(4, (k, v) -> v, (v1, v2) -> v1 + v2);
    System.out.println("Sum of all values: " + sum);
    ```

  - Variants of `reduce()` Method
    - `reduceEntries()` - returns the result of gathering all the entries using the specified reducer function
    - `reduceKeys()` - returns the result of gathering all the keys using the specified reducer function
    - `reduceValues()` - returns the result of gathering all the values using the specified reducer function

#### ConcurrentHashMap vs HashMap
- `ConcurrentHashMap` is a thread-safe collection.
  - That is, multiple threads can access and modify it at the same time.
- `ConcurrentHashMap` provides methods for bulk operations like
  - `forEach()`, `search()` and `reduce()`.

#### Why ConcurrentHashMap?
- The `ConcurrentHashMap` class allows multiple threads to access its entries concurrently.
  - By default, the concurrent hashmap is divided into 16 segments.
    - This is the reason why 16 threads are allowed to concurrently modify the map at the same time.
    - However, any number of threads can access the map at a time.
- The `putIfAbsent()` method will not override the entry in the map
  - if the specified key already exists.
- It provides its own synchronization.

## Iterator Interface
- Provides methods that can be used to access elements of collections
- All the Java collections include an iterator() method.
- This method returns an instance of iterator used to iterate over elements of collections.

### Methods of Iterator
- The Iterator interface provides 4 methods that can be used to perform various operations on elements of collections.

- `hasNext()` - returns true if there exists an element in the collection
- `next()` - returns the next element of the collection
- `remove()` - removes the last element returned by the `next()`
- `forEachRemaining()` - performs the specified action for each remaining element of the collection

```java
import java.util.ArrayList;
import java.util.Iterator;

class Main {
  public static void main(String[] args) {
    // Creating an ArrayList
    ArrayList<Integer> numbers = new ArrayList<>();
    numbers.add(1);
    numbers.add(3);
    numbers.add(2);
    System.out.println("ArrayList: " + numbers);

    // Creating an instance of Iterator
    Iterator<Integer> iterate = numbers.iterator();

    // Using the next() method
    int number = iterate.next();
    System.out.println("Accessed Element: " + number);

    // Using the remove() method
    iterate.remove();
    System.out.println("Removed Element: " + number);

    System.out.print("Updated ArrayList: ");

    // Using the hasNext() method
    while(iterate.hasNext()) {
      // Using the forEachRemaining() method
      iterate.forEachRemaining((value) -> System.out.print(value + ", "));
    }
  }
}
```