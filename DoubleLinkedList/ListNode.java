package DoubleLinkedList;

public class ListNode<NodeType> {
    protected NodeType data;

    protected ListNode<NodeType> prev;
    protected ListNode<NodeType> next;

    public ListNode()
    {

    }

    public ListNode(NodeType data)
    {
        this.data=data;
    }

    public ListNode(ListNode<NodeType> prev,NodeType data,ListNode<NodeType> next)
    {
        this.prev=prev;
        this.data=data;
        this.next=next;
    }
}
