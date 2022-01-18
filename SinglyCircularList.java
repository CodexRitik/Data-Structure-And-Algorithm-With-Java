import java.util.NoSuchElementException;

class CircularList
{
    ListNode tail;
    CircularList()
    {
        tail = null;
    }
    public static class ListNode
    {
        int data;
        ListNode next;
        ListNode(int data)
        {
            this.data = data;
        }
    }
    public boolean isEmpty()
    {
        return tail == null;
    }
    public void addFirst(int data)
    {
        ListNode node = new ListNode(data);
        if(isEmpty())
        {
            tail = node;
            tail.next = tail;
            return;
        }
        node.next = tail.next;
        tail.next = node;
    }
    public void addLast(int data)
    {
        ListNode node = new ListNode(data);
        if(isEmpty())
        {
            tail = node;
            tail.next = tail;
        }else{
            node.next = tail.next;
            tail.next = node;
            tail = node;
        }
    }
    public ListNode deleteFirst()
    {
        if(isEmpty())throw new NoSuchElementException();
        if(tail.next == tail)
        {
            tail = null;
            return null;
        }
        ListNode temp = tail.next;
        tail.next = temp.next;
        temp.next = null;
        return temp;
    }
    public ListNode deleteLast()
    {
        if(isEmpty()) throw new NoSuchElementException();
        if(tail.next ==tail){
            tail = null;
            return null;
        }
        ListNode temp = tail.next;
        while(temp.next!=tail)
        {
            temp = temp.next;
        }
        ListNode node = temp.next;
        temp.next = tail.next;
        tail = temp;
        node.next = null;
        return node;
    }
    public void traverse()
    {
        if(isEmpty())
        {
            System.out.println("Empty List !");
            return;
        }
        ListNode temp = tail.next;
        while(temp != tail)
        {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.print(temp.data);
    }
}
public class SinglyCircularList {
    public static void main(String[] args) {
        CircularList list = new CircularList();
        list.addFirst(10);
        list.addLast(20);
        list.addLast(30);
        list.deleteLast();
        list.traverse();
    }
}
