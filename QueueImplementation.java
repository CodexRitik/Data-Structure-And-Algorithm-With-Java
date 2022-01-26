class Queue
{
    ListNode front;
    ListNode rear;
    int length;

    public Queue()
    {
        front = null;
        rear = null;
        length =0 ;
    }

    public class ListNode
    {
        ListNode next;
        int data;
        ListNode(int data)
        {
            this.data = data;
        }
    }

    public boolean isEmpty()
    {
        return length == 0;
    }

    public int size()
    {
        return length;
    }
    public void enqueue(int data)
    {
        ListNode node = new ListNode(data);
        if(isEmpty())
        {
            front = node;
        }
        else{
            rear.next = node;
        }
        rear = node;
        length++;
    }

    public ListNode dequeue()
    {
        if(isEmpty())
        {
            return null;
        }
        ListNode temp = front;
        front = front.next;
        if(front == null)
        {
            rear = null;
        }
        length--;
        return temp;
    }
    public int first()
    {
        if(isEmpty()) return -1;
        return front.data;
    }
    public int last()
    {
        if(isEmpty()) return -1;
        return rear.data;
    }

    public void traverse()
    {
        if(isEmpty()) return;
        ListNode temp = front;
        while(temp!=null)
        {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }
}
public class QueueImplementation {

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.traverse();
        queue.dequeue();
        queue.traverse();
        System.out.println(queue.first());
        System.out.println(queue.last());
    }
}
