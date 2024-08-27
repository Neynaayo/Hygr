public class LinkedList
{
    private ListNode firstNode;
    private ListNode lastNode;
    private ListNode currNode; //use to traverse the list

    //constructor: constructor an empty List with s as the name 
    public LinkedList()
    {
        firstNode= lastNode = currNode = null;
    }
    //insert an Object at the end of the List
    //same object. Otherwise, lastNode's next instance variable
    //refers to new node
    public void addFirst(Object o){
        ListNode newNode = new ListNode(o);
        newNode.next = firstNode;
        firstNode=newNode;
        if(lastNode == null){
            lastNode=firstNode;
        }
    }

    public void insertAtBack(Object insertItem)
    {
        if(isEmpty())
            firstNode = lastNode = new ListNode(insertItem);
        else
            lastNode = lastNode.next = new ListNode(insertItem);
    }
    //remove the first node from the List
    //removeFirst
    public OrderInfo removeFirst(){
        OrderInfo remove = null;
        if(firstNode == null){
            return remove;
        }else if(firstNode == lastNode){
            remove = (OrderInfo)firstNode.data; //remove data yg first tu pegang
            firstNode = null;
            lastNode = null;
            return remove;
        }else{
            remove = (OrderInfo)firstNode.data;
            firstNode = firstNode.next;
            return remove;
        }
    }

    //remove the last node from the List
    public Object removeFromBack()throws EmptyListException
    {
        Object removeItem= null;
        if(isEmpty())
            throw new EmptyListException();
        removeItem = lastNode.data; //retrieve the data2
        //reset the firstNode and lastNode references
        if(firstNode.equals(lastNode))
            firstNode= lastNode = null;
        else
        {
            ListNode current = firstNode;
            while(current.next != lastNode) //not last node
                current = current.next; //move to next node
            lastNode = current;
            current.next = null;
        }
        return removeItem;
    }

    public OrderInfo removeLast(){
        ListNode current, previous;
        OrderInfo remove = null;

        if(firstNode == null){
            return remove;
        }else if(firstNode == lastNode){
            remove = (OrderInfo)firstNode.data; //remove data yg first tu pegang
            firstNode = null;
            lastNode = null;
            return remove;
        }else{
            current = firstNode;
            while(current.next != lastNode){
                current = current.next; //selagi next current bukan last, then it will loop till current tu dekat second last
            }
            remove =(OrderInfo) lastNode.data;
            current.next = null;
            lastNode = current;
            return remove;
            }
    }

    public Object removeFromSecond()
    {
        Object removeItem = null;
        if(isEmpty() || firstNode.next == null)
            removeItem=null;
        else
        {
            ListNode current = firstNode.next;
            removeItem = current.data;
            if(firstNode.next != lastNode)
            {
                firstNode.next =current.next;
                lastNode.next  = current.next;
                current.next = null;
            }
        }
        return removeItem;
    }

    public Object removeSecond1()
    {
        Object removeItem = null;
        if(firstNode != null){

            if(!(firstNode.equals(lastNode))){
                if(firstNode.next.next != null)
                {   removeItem = firstNode.next.data;
                    firstNode.next = firstNode.next.next;
                }
                else{
                    removeItem = firstNode.next.data;
                    firstNode.next = null;
                    lastNode = firstNode;
                }
            }
            else{
                removeItem = firstNode.data;//null
                firstNode = lastNode = null;
            }
        }
        return removeItem;
    }

    public boolean remove(OrderInfo data){
        if (firstNode == null) {
            //List is empty
            return false;
        }

        //Case: Data to be removed is in the first node
        if (firstNode.data.equals(data)) {
            removeFirst();
            return true;
        }

        ListNode current = firstNode;
        ListNode previous = null;

        // iii. provide traversal from the head until the last node in the list. (getHead() and getNext()). iv. determine the size of the list. 
        //Traverse the list to find the node with the specified data
        while (current != null && !current.data.equals(data)) {
            previous = current;
            current = current.next;
        }

        if (current == null) {
            //Data not found in the list
            return false;
        }

        //Case: Data to be removed is in the last node
        if (current == lastNode) {
            removeLast();
            return true;
        }

        //Case: Data to be removed is in a middle node
        previous.next = current.next;

        return true;
    }
    //return true if the List is empty
    public boolean isEmpty(){return firstNode == null;}
    //return first element
    public Object getFirst()
    {
        if(isEmpty())
            return null;
        else
        {
            currNode = firstNode;
            return currNode.data;
        }
    }
    //return the next element
    public Object getNext()
    {
        if(currNode != lastNode)
        {
            currNode = currNode.next;
            return currNode.data;
        }
        else

            return null;

    }

    public Object getLast()
    {
        if(currNode == lastNode)
        {
            return currNode.data;
        }
        else

            return null;
    }

    public void display() {

        ListNode temp = this.firstNode;
        while (temp != null) {
            System.out.println(temp.data + " ");
            temp = temp.next;
        }
    }

    public int length() {

        ListNode temp = this.firstNode;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

}
