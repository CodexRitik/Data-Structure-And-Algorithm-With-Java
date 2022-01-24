import java.util.NoSuchElementException;
class Stack{
    ListNode top;
    int size;
    Stack()
    {
        top = null;
        size = 0;
    }
    public static class ListNode{
        ListNode next;
        int data;
        public ListNode(int data)
        {
            this.data = data;
        }
    }
    public boolean isEmpty()
    {
        return top == null;
    }
    public int size()
    {
        return size;
    }
    public void push(int data)
    {
        ListNode node = new ListNode(data);
        if(top==null)
        {
            top = node;
        }
        else{
            node.next = top;
            top = node;
        }
        size++;
    }
    public int peek()
    {
        if(isEmpty())
        {
            throw new NoSuchElementException();
        }
        return top.data;
    }
    public int pop()
    {
        if(isEmpty())
        {
            throw new NoSuchElementException();
        }
        ListNode temp = top;
        top = top.next;
        temp.next = null;
        size--;
        return temp.data;
    }
    public boolean search(int data)
    {
        if(isEmpty())return false;
        ListNode temp = top;
        while(temp!=null)
        {
            if(temp.data == data)return true;
            temp = temp.next;
        }
        return false;
    }
}
public class StackWithList {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(stack.search(30));
        System.out.println(stack.peek());
        System.out.println(stack.size());
        System.out.println(stack.pop());
    }
}
