package DoubleLinkedList;

import java.util.List;

public class DoubleLinkedList<ListType> {
    private ListNode<ListType> front;
    private ListNode<ListType> back;

    private int size;

    public DoubleLinkedList()
    {
        this.front=null;
        this.back=null;
        size=0;
    }

    public void addFront(ListType data)
    {
        ListNode<ListType> node=new ListNode<>(data);
        if(size==0) {
            front = node;
            back = node;
        }
        else
        {
            front.prev=node;
            node.next=front;
            front=node;
        }
        size++;
    }

    public void addEnd(ListType data)
    {
        ListNode<ListType> node=new ListNode<>(data);
        if(size==0) {
            back = node;
            front = node;
        }
        else
        {
            back.next=node;
            node.prev=back;
            back=node;
        }
        size++;
    }

    public ListType getElenent(int index)
    {
        ListNode<ListType> buf;
        buf=front;

        if(index>=size)
            return null;
        for(int i=0;i<=index;i++)
        {
            if(i==index)
            {
                return buf.data;
            }
            buf=buf.next;
        }
        return null;
    }

    public void addAfter(ListType after,ListType data)
    {
        ListNode<ListType> buf=front;
        ListNode<ListType> newNode=new ListNode<>(data);


        for(int i=0;i<getIndex(after);i++)
        {
            buf=buf.next;
        }

        if(buf==back)
        {
            addEnd(data);
            return;
        }
        newNode.next=buf.next;
        newNode.prev=buf;
        buf.next=newNode;
        buf.next.next.prev=newNode;
        size++;
    }

    public void addBefore(ListType before,ListType data)
    {
        ListNode<ListType> buf=front;
        ListNode<ListType> newNode=new ListNode<>(data);


        for(int i=0;i<getIndex(before);i++)
        {
            buf=buf.next;
        }
        if(buf==front)
        {
            addFront(data);
            return;
        }
        newNode.next=buf;
        newNode.prev=buf.prev;
        buf.prev=newNode;
        buf.prev.prev.next=newNode;
        size++;
    }

    public int getIndex(ListType data)
    {
        int index=0;
        ListNode<ListType> buf=front;
        while(data!=buf.data)
        {
            buf=buf.next;
            index++;
            if(index==size)
                return 0;
        }

        return index;
    }

    public ListType getLast()
    {
        return back.data;
    }

    public ListType getFirst()
    {
        return front.data;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public int size()
    {
        return size;
    }

}
