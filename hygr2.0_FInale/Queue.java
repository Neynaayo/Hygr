import java.util.LinkedList;
public class Queue {
    private LinkedList list;
    public Queue(){
        list=new LinkedList();
    }
    public boolean isEmpty(){
        return list.isEmpty();
    }
    public int size(){
        return list.size();
    }
    public void enqueue(Object e){
        list.addLast(e);
    }
    public Object dequeue(){return list.removeFirst();}
    public Object getFront(){
        return list.getFirst();
    }
}