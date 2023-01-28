package main;

import linkedList.DoublyLinkedList;
import node.DoublyNode;

public class MainDoubly {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>(null, null);
        list.pushToHead(1);
        list.pushToHead(2);
        list.pushToHead(3);
        list.pushToHead(4);
        list.pushToHead(5);

        System.out.println(list.print());
        list.pushToTail(6);
        list.pushToTail(7);
        System.out.println(list.print());
        System.out.println(list.removeFromHead());
        System.out.println(list.print());
        System.out.println(list.removeFromHead());
        System.out.println(list.print());
        list.removeFromTail();
        System.out.println(list.print());
        list.removeFromTail();
        System.out.println(list.print());
        list.pushToIndex(0, -11);
        System.out.println(list.print());
        list.pushToIndex(4, -11);
        System.out.println(list.print());
        list.pushToIndex(2, 100);
        System.out.println(list.print());
        list.pushToIndex(5, -100);
        System.out.println(list.print());
        System.out.println("Remove by index 0: " + list.removeByIndex(0));
        System.out.println(list.print());
        System.out.println(list.getSize());
        System.out.println("Remove by index 5: " + (list.removeByIndex(list.getSize() - 1)));
        System.out.println(list.print());
        System.out.println("Remove by index 3: " + list.removeByIndex(3));
        System.out.println(list.print());
        System.out.println(list.getElement(0));
        System.out.println(list.getElement(list.getSize() - 1));
        System.out.println(list.getElement(2));
        list.reverse();
        System.out.println(list.print());
        list.pushToIndex(3, 88);
        System.out.println(list.print());
    }
}