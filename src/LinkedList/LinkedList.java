package LinkedList;
/*
* Author: Jayesh Nayak
*
* */
class LinkedList
{
    ListNode head;

    class ListNode
    {
        int data;
        ListNode next;
        ListNode(int d) {
            data = d; next = null;
        }
    }

    //Inserts a node at beginning of list
    public void push(int new_data)
    {
        ListNode new_node = new ListNode(new_data);
        new_node.next = head;
        head = new_node;
    }

    //Inserts a node after a given node.
    public void insertAfter(ListNode prev_node, int new_data)
    {

        if (prev_node == null)
        {
            System.out.println("Previous node cannot be null");
            return;
        }

        ListNode new_node = new ListNode(new_data);
        new_node.next = prev_node.next;
        prev_node.next = new_node;
    }

    //Inserts a node at the end of the list
    public void add(int new_data)
    {

        ListNode new_node = new ListNode(new_data);

        if (head == null)
        {
            head = new ListNode(new_data);
            return;
        }

        new_node.next = null;

        ListNode last = head;
        //traversing till the last node
        while (last.next != null) {
            last = last.next;
        }

        last.next = new_node;
    }

    void deleteNode(int key)
    {

        ListNode temp = head, prev = null;

        if (head == null)
            return;

        // temp != null => empty list
        if (temp.data == key) {
            head = temp.next; // Changed head
            return;
        }

        while (temp != null && temp.data != key) {
            prev = temp;
            temp = temp.next;
        }
        //Control exits the loop => Either the list has ended (Key absent) OR Key is found
        //Key absent in the Linked List
        if (temp == null)
            return;

        prev.next = temp.next;
    }

    void deleteNodePosition(int position)
    {

        if (head == null)
            return;

        ListNode temp = head;

        if (position == 0) {
            head = temp.next;
            return;
        }

        //Traversing till the required node
        for (int i = 0; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }

        // Control exits loop when:
        //  i) Position > Length of the list
        // ii) Position-1 is reached
        if (temp == null || temp.next == null)
            return;

        // Node temp->next is the node to be deleted
        // Store pointer to the next of node to be deleted

        temp.next = temp.next.next;
    }

    public void deleteEnd(){
        //Traversing till the required node
        ListNode temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        }

        temp.next = null;
    }

    public void deleteHead(){
        head = head.next;
    }

    void deleteList()
    {
        head = null;
    }

    public int length()
    {
        ListNode temp = head;
        int count = 0;
        while (temp != null)
        {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public boolean search(int x)
    {
        ListNode current = head;    //Initialize current
        while (current != null)
        {
            if (current.data == x)
                return true;    //data found
            current = current.next;
        }
        return false;    //data not found
    }

    public int getElement(int index)
    {
        ListNode temp = head;
        int count = 0;
        while (temp != null)
        {
            if (count == index)
                return temp.data;
            count++;
            temp = temp.next;
        }

        return -1;
    }
    //Reverses the LinkedList
    public void reverse() {
        if(head == null || head.next == null){
            return;
        }

        ListNode temp = head;
        ListNode temp1= head.next, temp2= temp1.next;
        // 2   6   5   10  8   7   null
        //                 t  t1  t2
        while(temp2 != null){
            temp1.next = temp;
            temp = temp1;
            temp1 = temp2;
            temp2 = temp2.next;
        }
        head.next = null;
        temp1.next = temp;
        head = temp1;
        //return temp;
    }
    //Prints the LinkedList
    public void printList()
    {
        ListNode temp = head;
        while (temp != null)
        {
            System.out.print(temp.data+" ");

            if(temp.next != null){
                System.out.print("-> ");
            }

            temp = temp.next;
        }
    }

    public static void main(String[] args)
    {

        LinkedList list = new LinkedList();

        list.add(6);
        //6 -> null
        list.push(7);
        // 7 -> 6 -> NULL
        list.push(1);
        // 1 -> 7 -> 6 -> NULL
        list.add(4);
        // 1 -> 7 -> 6 -> 4 -> NULL
        list.insertAfter(list.head.next, 8);
        // 1 -> 7 -> 8 -> 6 -> 4 -> NULL
        list.deleteNode(7);
        //1 -> 8 -> 6 -> 4 -> NULL
        list.deleteNodePosition(2);
        //1 -> 8 -> 4 -> NULL
        list.deleteEnd();
        //1 -> 8 -> NULL
        list.deleteHead();
        //8 -> NULL
        list.add(7);
        list.push(10);
        list.push(5);
        list.push(6);
        list.push(2);
        //2 -> 6 -> 5 -> 10 -> 8 -> 7 -> NULL
        int index = 2, searchElement = 6;
        System.out.print("\nLinked list is: ");
        list.printList();
        System.out.println("\nLength of list is: " + list.length());
        System.out.println("Is element "+searchElement+" present?\n"+list.search(searchElement));

        System.out.println("Element at index "+index+" is: "+list.getElement(index));
        /*
        TODO:
        list.removeDuplicates();
        */
        System.out.print("\nReversed Linked list is: ");
        list.reverse();
        list.printList();
        list.deleteList();
    }
}


