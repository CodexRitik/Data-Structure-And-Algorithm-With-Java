class SinglyList{
    ListNode head;
    static class ListNode{
        int data;
        ListNode next;
        ListNode(int data)
        {
            this.data = data;
        }
    }
    public boolean isEmpty()
    {
        return head==null;
    }
    public void addLast(int data)
    {
        ListNode node = new ListNode(data);
        if(isEmpty())
        {
            head = node;
            return;
        }
        ListNode temp = head;
        while(temp.next != null)
        {
            temp = temp.next;
        }
        temp.next = node;
    }
    public void addFirst(int data)
    {
        ListNode node = new ListNode(data);
        if(isEmpty())
        {
            head = node;
            return;
        }
        node.next = head;
        head = node;
    }
    public void addAtPosition(int index,int data)
    {
        ListNode node = new ListNode(data);
        if(index==1)
        {
            node.next = head;
            head = node;
        }else
        {
            ListNode prev = head;
            int count = 1;
            while(count < index-1)
            {
                prev = prev.next;
                count++;
            }
            ListNode curr = prev.next;
            node.next = curr;
            prev.next = node;
        }
    }
    public ListNode deleteFirst()
    {
        if(isEmpty())
        {
            return null;
        }
        ListNode temp = head;
        head = head.next;
        temp.next = null;
        return temp;
    }
    public void deleteLast()
    {
        if(isEmpty())
        {
            return;
        }
        ListNode temp = head;
        while(temp.next.next!=null)
        {
            temp = temp.next;
        }
        temp.next = null;
    }
    public void deleteAtPosition(int index){
        if(isEmpty()){
            return;
        }
        else if(index == 1){
            head = null;
        }else{
            int count  = 1;
            ListNode curr = head;
            ListNode temp = null;
            while(count < index -1)
            {
                curr = curr.next;
                count++;
            }
            temp = curr.next.next;
            curr.next = temp;
        }
    }
    public ListNode middleNode()
    {
        if(isEmpty())return null;
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        while(fastPtr != null && fastPtr.next != null)
        {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        return slowPtr;
    }
    public boolean search(int key)
    {
        if(isEmpty())return false;
        ListNode temp = head;
        while(temp != null)
        {
            if(temp.data == key) return true;
            temp = temp.next;
        }
        return false;
    }
    public void reverse()
    {
        ListNode curr = head;
        ListNode nextNode = null;
        ListNode prev = null;
        while(curr!=null)
        {
            nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        head = prev;
    }
    public void traverse()
    {
        ListNode temp = head;
        while(temp!=null)
        {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }
    public ListNode nthNodeFromEnd(int index)
    {
        if(isEmpty())return null;
        ListNode mainPtr = head;
        ListNode refPtr = head;
        int count = 0;
        while(count < index)
        {
            refPtr = refPtr.next;
            count++;
        }
        while(refPtr!=null)
        {
            mainPtr = mainPtr.next;
            refPtr = refPtr.next;
        }
        return mainPtr;
    }
    public void removeDuplicates() // list must be sorted
    {
        ListNode curr = head;
        while(curr!=null && curr.next!=null)
        {
            if(curr.data == curr.next.data)
            {
                curr.next = curr.next.next;
            }else{
                curr = curr.next;
            }
        }
    }
    public void removeGivenKey(int key)
    {
        if(isEmpty())return;
        ListNode curr = head;
        ListNode prev = null;
        while(curr!=null && curr.data!=key)
        {
            prev = curr;
            curr = curr.next;
        }
        prev.next = curr.next;
    }
}
public class SinglyLinkedList {
    public static void main(String[] args) {
        SinglyList list = new SinglyList();
        
        //Some example of implemented methods
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addFirst(5);
        list.addAtPosition(3,40);
        list.traverse();
        list.removeGivenKey(40);
        list.traverse();
        System.out.println(list.middleNode().data);
        System.out.println(list.nthNodeFromEnd(2).data);


    }
}
