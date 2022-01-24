import java.util.NoSuchElementException;

class DoublyCircular{
    ListNode head;
    ListNode tail;

    DoublyCircular()
    {
        head = null;
        tail = null;
    }
    public static class ListNode{
        ListNode next;
        ListNode prev;
        int data;
        ListNode(int data)
        {
            this.data = data;
        }
    }
    public boolean isEmpty()
    {
        return head == null;
    }
    public void addFirst(int data)
    {
        ListNode node = new ListNode(data);
        if(isEmpty())
        {
            head  = node;
            tail = node;
        }
        else
        {
            head.prev = node;
            node.next = head;
            head = node;
        }
        head.prev = tail;
        tail.next = head;
    }
    public void addLast(int data)
    {
        ListNode node = new ListNode(data);
        if(isEmpty())
        {
            head = node;
            tail = node;
        }
        else
        {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        tail.next = head;
        head.prev = tail;
    }

    public ListNode deleteFirst()
    {
        if(isEmpty())
        {
            return null;
        }
        ListNode temp = head;
        head = head.next;
        head.prev = tail;
        tail.next = head;
        return temp;
    }
    public ListNode deleteLast()
    {
        if(isEmpty())return null;
        ListNode temp = tail;
        tail = tail.prev;
        tail.next = head;
        head.prev = tail;
        return temp;
    }

    public void traverse()
    {
        if (isEmpty())
        {
            throw new NoSuchElementException();
        }
        ListNode temp = head;
        while(temp.next != head)
        {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.print(temp.data);
        System.out.println();
    }
    public void reversePrint()
    {
        ListNode temp = tail;
        while(temp.prev != tail)
        {
            System.out.print(temp.data+" ");
            temp = temp.prev;
        }
        System.out.print(temp.data);
        System.out.println();
    }
}
public class DoublyCircularList {
    public static void main(String[] args) {
        DoublyCircular list = new DoublyCircular();
        list.addLast(20);
        list.addFirst(10);
        list.addLast(30);
        list.addLast(40);
        list.addFirst(5);
        list.traverse();
        list.deleteFirst();
        list.reversePrint();
        list.deleteLast();
    }
}

