public class ListNode
{ 
    //package access data so class List can access it directly
    Object data;
    ListNode next;
    //Constructor: create a ListNode that refer to Object o 
    ListNode(Object o) { this(o, null);}
    //Constructor: create a ListNode that refers to Object o and
    //to the next ListNode in the List
    ListNode(Object o, ListNode nextNode)
    {
        data =o;
        next = nextNode;
    }

    //return a reference to the Object in this node Object getObject() { return data; }
    //return the next node
    ListNode getLink() { return next; }
    Object getObject(){return data;}
    
}