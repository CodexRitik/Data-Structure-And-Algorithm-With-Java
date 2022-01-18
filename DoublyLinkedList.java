import java.util.NoSuchElementException;

class DoublyList
{
    ListNode head;
    ListNode tail;
    DoublyList()
    {
        head = null;
        tail = null;
    }
    static class ListNode
    {
        int data;
        ListNode next;
        ListNode prev;
        ListNode(int data)
        {
            this.data = data;
        }
    }
    public boolean isEmpty()
    {
        return head==null;
    }
    public void addFirst(int data)
    {
        ListNode node = new ListNode(data);
        if(isEmpty())
        {
            head = node;
            tail = node;
        }
        else
        {
            node.next = head;
            head.prev = node;
            head = node;
        }
    }
    public void addLast(int data)
    {
        ListNode node = new ListNode(data);
        if(isEmpty())
        {
            head = node;
            tail = node;
        }else
        {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }
    public void addAtPosition(int index,int data)
    {
        ListNode node = new  ListNode(data);
        if(isEmpty())
        {
            head = node;
            tail = node;
        }else if(index == 1)
        {
            node.next = head;
            head.prev = node;
            head = node;
        }else
        {
            int c = 1;
            ListNode curr = head;
            while(c < index-1)
            {
                curr = curr.next;
                c++;
            }
            ListNode current = curr.next;
            curr.next = node;
            node.prev = curr;
            node.next = current;
            current.prev = node;
        }
    }
    public ListNode deleteFirst()
    {
        if(isEmpty())
        {
            throw new NoSuchElementException();
        }
        else if(head == tail)
        {
            ListNode temp = head;
            head = null;
            tail = null;
            return temp;
        }
        ListNode temp = head;
        head.next.prev = null;
        head = head.next;
        temp.next = null;
        return temp;
    }
    public ListNode deleteLast()
    {
        if(isEmpty())
        {
            throw new NoSuchElementException();
        }
        else if(head == tail)
        {
            ListNode temp = head;
            head = null;
            tail = null;
            return temp;
        }
        ListNode temp = tail;
        tail.prev.next = null;
        tail = tail.prev;
        temp.next = null;
        return temp;
    }
    public ListNode deleteAtPosition(int index)
    {
        if(isEmpty())
        {
            throw new NoSuchElementException();
        }else if(index == 1)
        {
            ListNode temp = head;
            head = head.next;
            head.prev = null;
            temp.next = null;
            return temp;
        }
        int c = 1;
        ListNode Prev = head;
        while(c <index-1)
        {
            Prev = Prev.next;
            c++;
        }
        ListNode curr = Prev.next;
        Prev.next = curr.next;
        curr.next.prev = Prev;
        return curr;
    }
    public void traverse()
    {
        ListNode temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public void reversePrint()
    {
        ListNode temp = tail;
        while(temp != null)
        {
            System.out.print(temp.data+" ");
            temp = temp.prev;
        }
        System.out.println();
    }
}

public class DoublyLinkedList {
    public static void main(String[] args) {
        DoublyList list = new DoublyList();
        list.addFirst(30);
        list.addLast(40);
        list.addFirst(20);
        list.addFirst(10);
        list.addLast(50);
        list.traverse();
        list.addAtPosition(3,100);
        list.traverse();
        list.deleteAtPosition(3);
        list.traverse();
        list.reversePrint();

    }
}
