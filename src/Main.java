import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
//@author Ansari Mohammed Faisal - 000812671
/*
o Do you notice any significant performance difference between the SortedLinkedList<T> and the ArrayList<T> classes when adding items?
-> yes, there is significant difference in timming when adding item.
-> Linked list is fasten array list when adding elements
o Do you notice any significant performance difference between these two collections when removing items?
-> yes, there is difference when removing elements from list
-> Linked list is faster than ArrayList when removing elements
o When would you choose to use a SortedLinkedList over an ArrayList based on the results of this assignment?
-> i would use SortedLinkedList where deletion and insertion of elements are frequent
-> I would also use SortedLinkedList when order of elements (ascending-descending) matters in an Program
 */
public class Main {

    public static void main(String[] args) {
        final int NUMBER_OF_NAMES = 18756;
        final String filename = "resources/bnames.txt";
        final String[] names = new String[NUMBER_OF_NAMES];

        // May be useful for selecting random words to remove
        Random random = new Random();

        // Read in all of the names
        try {
            Scanner fin = new Scanner(new File(filename));
            for (int i=0; i<NUMBER_OF_NAMES; i++)
                names[i] = fin.next();
            fin.close();
        } catch (FileNotFoundException e) {
            System.out.println("Exception caught: " + e.getMessage());
            System.exit(-1);
        }

        // Use the system to build the linked List

        System.out.println("Adding elements in Linked List:");
        // 1. Create the linkedList and add all items in Array
        SortedLinkedList<String> linkedList_String = new SortedLinkedList<>();
        long start = System.nanoTime();
        for (int i=0; i<NUMBER_OF_NAMES;i++)
            linkedList_String.add(names[i]);
        long timeTaken = (System.nanoTime() - start) / 1000;
        System.out.printf("The time required to add %d elements to a Linked List = %d us\n", NUMBER_OF_NAMES, timeTaken);
        System.out.println(linkedList_String);

        System.out.println("Removing elements in Linked List:");
        // 2. Remove half the items and time the code.
        start = System.nanoTime();
        for (int i=0; i<NUMBER_OF_NAMES/2;i++)
            linkedList_String.remove(names[i]);
        timeTaken = (System.nanoTime() - start) / 1000;
        System.out.printf("The time required to remove %d elements from a Linked List = %d us\n", NUMBER_OF_NAMES/2, timeTaken);
        System.out.println(linkedList_String);

        System.out.println("Adding elements in Linked List (Integers):");
        // 3. Create a SortedLinkedList of another data type and demonstrate
        SortedLinkedList<Integer> linkedList_Integer = new SortedLinkedList<>();
        start = System.nanoTime();
        for (int i=0; i<NUMBER_OF_NAMES;i++)
            linkedList_Integer.add(random.nextInt(NUMBER_OF_NAMES));
        timeTaken = (System.nanoTime() - start) / 1000;
        System.out.printf("The time required to add %d elements to a Linked List = %d us\n", NUMBER_OF_NAMES, timeTaken);
        System.out.println(linkedList_Integer);

        // 4. Build a standard ArrayList of String - Remember to sort list after each element is added
        //    Time this code.
        //    Use this timing data to compare add against SortedLinkedList in discussion
        //    Remove the half the elements and time again.
        //    Use this timing data to compare remove against SortedLinkedList in discussion

        System.out.println("Adding elements in Array List:");
        ArrayList<String> arrayList_String = new ArrayList<>();
        start = System.nanoTime();
        for (int i=0; i<NUMBER_OF_NAMES;i++) {
            arrayList_String.add(names[i]);
            Collections.sort(arrayList_String);
        }
        timeTaken = (System.nanoTime() - start) / 1000;
        System.out.printf("The time required to add %d elements to a Array List = %d us\n", NUMBER_OF_NAMES, timeTaken);
        System.out.println(arrayList_String);

        System.out.println("Removing elements in Array List:");
        start = System.nanoTime();
        for (int i=0; i<NUMBER_OF_NAMES/2;i++) {
            arrayList_String.remove(names[i]);
        }
        timeTaken = (System.nanoTime() - start) / 1000;
        System.out.printf("The time required to remove %d elements from a Array List = %d us\n", NUMBER_OF_NAMES/2, timeTaken);
        System.out.println(arrayList_String);
    }
}
