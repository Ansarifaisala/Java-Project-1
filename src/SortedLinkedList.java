
/**
 * Generic Linked List class that always keeps the elements in order 
 * @author mark.yendt
 */
public class SortedLinkedList<T extends Comparable>
{
    /**
     * The Node class stores a list element and a reference to the next node.
     */
    private final class Node<T extends Comparable>
    {
        T value;
        Node next;

        /**
         * Constructor.
         * @param val The element to store in the node.
         * @param n The reference to the successor node.
         */
        Node(T val, Node n)
        {
            value = val;
            next = n;
        }

        /**
         * Constructor.
         *
         * @param val The element to store in the node.
         */
        Node(T val)
        {
            // Call the other (sister) constructor.
            this(val, null);
        }
    }
    private Node first;  // list head

    /**
     * Constructor.
     */
    public SortedLinkedList()
    {
        first = null;
    }

    /**
     * The isEmpty method checks to see if the list is empty.
     *
     * @return true if list is empty, false otherwise.
     */
    public boolean isEmpty()
    {
        return first == null;
    }

    /**
     * The size method returns the length of the list.
     * @return The number of elements in the list.
     */
    public int size()
    {
        int count = 0;
        Node p = first;
        while (p != null) {
            // There is an element at p
            count++;
            p = p.next;
        }
        return count;
    }

    /**
     * The add method adds an element at a position.
     * @param element The element to add to the list in sorted order.
     */
    public void add(T element)
    {
        Node newNode = new Node(element);
        Node current = first;
        Node previous = null;

        while(current != null && element.compareTo(current.value)>=0){
            previous = current;
            current = current.next;
        }
        // insertion at beginning of the list
        if(previous == null){
            first = newNode;
        }else{
            previous.next = newNode;
        }
        newNode.next = current;

    }

    /**
     * The toString method computes the string representation of the list.
     * @return The string form of the list.
     */
    public String toString()
    {
        String listOfItems = "";

        Node current = first;
        while(current != null){
            listOfItems += current.value+", ";
            current = current.next;
        }

        return listOfItems;
    }

    /**
     * The remove method removes an element.
     * @param element The element to remove.
     * @return true if the remove succeeded, false otherwise.
     */
    public boolean remove(T element)
    {
        Node temp = first, prev = null;

        // If head node itself holds the element to be deleted
        if (temp != null && temp.value == element) {
            first = temp.next; // Changed head
            return true;
        }
        // Search for the element to be deleted, keep track of
        // the previous node as we need to change temp.next
        while (temp != null && temp.value != element) {
            prev = temp;
            temp = temp.next;
        }

        if (temp == null)
            return false;

        prev.next = temp.next;
        return true;
        }
    }