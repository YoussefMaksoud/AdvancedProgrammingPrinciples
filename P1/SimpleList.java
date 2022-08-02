//package com.ENSF;

//see file:///Users/youssef/Desktop/MyPrograms/src/com/ENSF/allclasses-index.html


/**
 *
 * Class used to create and manage a linked list.
 */
public class SimpleList{
    /**
     *
     * headM is the head node of the linked list. It contains no value.
     * headM points to null when list is empty, and points to the next
     * node element when there are elements in the list.
     *
     * sizeM is the number of elements in the list.
     */
    private Node headM;
    private int sizeM;

    /**
     *
     * Node elements of the linked list that contain an integer and a reference
     * to the next element in the list.
     *
     * itemM is the data stored in the node.
     *
     * next points to the next element in the array, and points to null.
     * if the current node is at the end if the list.
     */
    class Node{
        private int itemM;
        private Node next;

        /**
         *
         * Class default constructor set the value of itemM.
         */
        Node(){
            this.itemM = 0;
        }

        /**
         *
         * Overloaded class constructor that sets the value of itemM
         * @param value the value that will be inserted into itemM.
         */
        Node(int value){
            this.itemM = value;
        }
    }

    /**
     * Class constructor allocates memory for the headM node and sets
     * the reference to the next element to null.
     */
    SimpleList(){
        this.headM = new Node();
        this.headM.next = null;
        //this.headM.next = null;
    }

    /**
     *
     * Gets the number of element in the current list.
     * @return returns the number of elements in the list.
     */
    public int size(){
        return this.sizeM;
    }

    /**
     *
     * Creates a new node element at the tail of the linked list and increments sizeM.
     * @param val value that will be inserted into the newly allocated node.
     */
    public void pushBack(int val){
        if(this.sizeM > 0){
            Node newN = new Node(val);
            Node before = headM;
            Node after = before.next;
            for(int i = 0; after != null; i ++){
                before = after;
                after = after.next;
            }

            before.next = newN;
            newN.next = after;
            this.sizeM++;
        }
        else
            pushFront(val);
        

    }

    /**
     *
     * creates a new node element at the front of the list and increments sizeM.
     * @param val value of the item in the newly allocated node.
     */
    public void pushFront(int val){
        Node newN = new Node(val);
        newN.next = this.headM.next;
        this.headM.next = newN;
        this.sizeM ++;
    }

    /**
     *
     *removes the last node element of the list.
     */
    public void popBack(){
        Node before = headM.next;
        Node after = before.next;

        for(int i = 0; after.next != null; i ++){
            before = after;
            after = after.next;
        }

        before.next = null;
        this.sizeM --;
    }

    /**
     *
     * Gets the itemM of the element at the required position.
     * @param index Position of the desired element.
     * @return The value stored in the node of element at required index
     */
    public int get(int index){
        if(index < 0 || index >= this.sizeM){
            //System.out.println("Illegal access");
            
        }
        Node before = this.headM.next;
        Node after = before.next;
        for(int i = 0; i < index; i++){
            before = after;
            after = before.next;
        }

        return before.itemM;
        
    }

    /**
     *
     * Sets the value of a node at a certain position.
     * @param index Element of the linked to be accessed.
     * @param value New value of itemM of the node at desired position.
     */
    public void set(int index, int value){
        if(index < 0 || index >= this.sizeM){
            //System.out.println("Illegal access");
            return;
            
        }
        Node before = this.headM.next;
        Node after = before.next;
        for(int i = 0; i < index; i++){
            before = after;
            after = before.next;
        }
        before.itemM = value;
    }

    /**
     *
     * Allocates a new node, and inserts it into the desired position in the existing list.
     * @param value The value of itemM in the new node.
     * @param index The position at which the new node is to be inserted
     */
    public void insert(int value, int index){
        if(index < 0 || index > this.sizeM){
            //System.out.println("Illegal access");
            return;
        }
        if(index > 0){
            Node before = this.headM;
            Node after = before.next;
            Node newN = new Node(value);
        
            for(int i = 0; i < index && after != null; i++){
                before = after;
                after = after.next;
            }

            before.next = newN;
            newN.next = after;
            this.sizeM ++;
        }
        else
            this.pushFront(value);
    }

    /**
     *
     * Removes node at desired position of the list.
     * @param index Position of the node that will be removed.
     */
    public void remove(int index){
        if(index < 0 || index >= this.sizeM){
            //System.out.println("Illegal access");
            return;
            
        }
        Node before = this.headM;
        Node after = before.next;

        for(int i = 0; i < index && after.next != null; i++){
            before = after;
            after = after.next;
        }

        after = after.next;
        before.next = after;
        this.sizeM --;
    }

    /**
     *
     * Empties the list and sets headM.next to null.
     */
    public void clear(){
        this.headM.next = null;
        this.sizeM = 0;
    }

    /**
     *
     * Prints the data contents of the linked list.
     */
    public void print(){
        if(this.sizeM > 0){
            Node before = this.headM.next;
            Node after = before.next;
            if(this.sizeM > 1){
                if(before != null){
                    for(int i = 0; i < this.sizeM && after != null; i++){
                    System.out.print(before.itemM + " ");
                    before = after;
                    after = after.next;
                    }
                }
                System.out.print(before.itemM + " ");
            }
            else
            System.out.print(before.itemM + " ");
        }
    }

    /**
     *
     * Test the various instance methods of the SimpleList class.
      * @param args Accepts command line arguments and stores them in array args.
     */
    public static void main(String args[]){
        SimpleList list = new SimpleList();
    
        System.out.println("List just after creation -- is empty.");
        
        list.pushFront(50);
        System.out.println("After calling pushFront. list must have: 50");
        list.print();
        System.out.println("");

        list.pushBack(440);
        
        list.set(0,770);
        System.out.println("After calling pushBack and set function list must have: 770  440");
        list.print();
        System.out.println("");

        list.pushBack(330);
        list.pushBack(220);
        list.pushBack(110);
        
        System.out.println("After three more calls to pushBack, list must have: 770, 440, 330, 220, 110");
        list.print();
        System.out.println("");
        
        list.remove(0);
        list.remove(2);
        System.out.println("After removing two nodes. list must have: 440, 330, 110");
        list.print();
        System.out.println("");

        list.insert(40, 3); //insert node with the value of 40 at the 4th position
        list.insert(20, -1); // do nothing
        list.insert(30, 30000); // do nothing
        list.insert(10, 0); //insert node with the value of 10 at the 1st position
        list.insert(33, 2); // insert node with the value 33 at the 3rd position
        
        System.out.println("Two  more nodes inserted, must have: 10, 440, 33, 330, 110, 40");
        list.print();
        System.out.println("");
        
        list.remove(0);
        list.remove(1);
        list.remove(2);
        list.remove(3);
        list.remove(4);
        list.remove(5);
        System.out.println("After 6 removes, list must have: 440, 330, 40: ");
        list.print();
        System.out.println("");
        
        list.clear();
        System.out.println("After call to clear, list must be empty:");
        list.print();
        System.out.println("");
        
        list.pushBack(331);
        list.pushBack(221);
        list.pushBack(111);
        
        System.out.println("After three calls to pushBack, list must have: 331, 221, 111");
        list.print();
        System.out.println("");
    }
}