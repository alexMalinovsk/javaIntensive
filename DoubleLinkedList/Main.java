package DoubleLinkedList;

public class Main {
    public static void main(String[] args) {
        DoubleLinkedList<String> list=new DoubleLinkedList<String>();
        list.addFront("da");
        list.addFront("df");
        list.addFront("va");
        list.addEnd("htd");
//        list.addEnd(10);
//        list.addEnd(15);
//        list.addEnd(14);
//        list.addFront(4);
//        list.addFront(8);
//        list.addFront(2);
        list.addAfter("da","hyt");
        list.addBefore("hyt","fes");
//        System.out.println(list.getIndex(list.getElenent(2)));

        for(int i=0;i<list.size();i++)
        {
            System.out.println(list.getElement(i));
        }
    }
}
