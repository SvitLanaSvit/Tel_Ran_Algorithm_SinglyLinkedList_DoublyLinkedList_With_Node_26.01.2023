package main;

import linkedList.SinglyLinkedList;

public class MainSingly {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>(null);
        list.pushToTail(7);
        list.pushToHead(5);
        list.pushToHead(4);
        list.pushToHead(2);
        System.out.println(list.print());

        list.pushToTail(6);
        System.out.println(list.print());
//        System.out.println("remove: " + list.removeHead());
//        System.out.println("remove: " + list.removeHead());
//        System.out.println("remove: " + list.removeHead());
//        System.out.println("remove: " + list.removeHead());
//        System.out.println("remove: " + list.removeHead());
//        System.out.println(list.print());
//        list.removeTail();
//        System.out.println("----------------------");
//        System.out.println(list.print());
//        list.removeTail();
        System.out.println(list.getElement(4));
        System.out.println("Size of list: " + list.getSize());
        System.out.println(list.removeByIndex(4));
        System.out.println("Size of list: " + list.getSize());
        System.out.println("----------------------");
        System.out.println(list.print());
        System.out.println(list.removeByIndex(0));
        System.out.println("Size of list: " + list.getSize());
        System.out.println("----------------------");
        System.out.println(list.print());
        System.out.println(list.removeByIndex(1));
        System.out.println("Size of list: " + list.getSize());
        System.out.println("----------------------");
        System.out.println(list.print());
        list.reverse();
        System.out.println("----------------------");
        System.out.println(list.print());
        list.pushToIndex(0, 1);
        System.out.println("----------------------");
        System.out.println(list.print());
        list.pushToIndex(3, 11);
        System.out.println("----------------------");
        System.out.println(list.print());
        list.pushToIndex(1, -8);
        System.out.println("----------------------");
        System.out.println(list.print());
        list.pushToIndex(4, -80);
        System.out.println("----------------------");
        System.out.println(list.print());
        list.pushToIndex(0, 100);
        System.out.println("----------------------");
        System.out.println(list.print());
    }
}
