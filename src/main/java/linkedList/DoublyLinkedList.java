package linkedList;

import node.DoublyNode;

public class DoublyLinkedList<T> {
    private DoublyNode<T> head;
    private DoublyNode<T> tail;

    public DoublyLinkedList(DoublyNode<T> head, DoublyNode<T> tail){
        this.head = head;
        this.tail = tail;
    }

    public void pushToHead(T data){
        DoublyNode<T> node = new DoublyNode<>(data, null, null);
        if (head == null) {
            head = tail = node;
        }
        else{
            node.setNext(head);
            head.setPrevious(node);
            head = node;
        }
    }

    public void pushToTail(T data){
        DoublyNode<T> node = new DoublyNode<>(data, null, null);
        if(head == null){
            head = tail = node;
        }
        else{
            node.setPrevious(tail);
            tail.setNext(node);
            tail = node;
        }
    }

    public boolean pushToIndex(int index, T data){
        boolean isPushed = false;
        if(index == 0){
            pushToHead(data);
            isPushed = true;
        }
        else if(index == getSize()){
            pushToTail(data);
            isPushed = true;
        }
        else if(index > 0 && index < getSize()){
            DoublyNode<T> nodePrev = head;
            int counter = 0;
            while(nodePrev != null && nodePrev.getNext() != null && counter != index - 1){
                counter++;
                nodePrev = nodePrev.getNext();
            }

            DoublyNode<T> nodeNext = nodePrev.getNext();
            DoublyNode<T> newNode = new DoublyNode<>(data, nodePrev, nodeNext);
            nodePrev.setNext(newNode);
            nodeNext.setPrevious(newNode);
            isPushed = true;
        }
         return isPushed;
    }

    public T removeFromHead(){
        T data = null;
        if(head != null){
            data = head.getData();
            head = head.getNext();
        }
        return data;
    }

    public void removeFromTail(){
        if(getSize() == 1){
            head = tail = null;
        }
        else if(getSize() > 1) {
        tail = tail.getPrevious();
        tail.setNext(null);
        }
    }

    public T removeByIndex(int index){
        if(index == 0){
            DoublyNode<T> node = head;
            removeFromHead();
            return node.getData();
        }
        else if(index == getSize() - 1){
            DoublyNode<T> node = tail;
            removeFromTail();
            return node.getData();
        }
        else if(index > 0 && index < getSize() - 1){
            DoublyNode<T> nodePrev = head;
            int counter = 0;
            while(nodePrev != null && nodePrev.getNext() != null && counter != index - 1){
                counter++;
                nodePrev = nodePrev.getNext();
            }
            DoublyNode<T> nodeRemove = nodePrev.getNext();
            DoublyNode<T> nodeNext = nodePrev.getNext().getNext();
            nodePrev.setNext(nodeNext);
            nodeNext.setPrevious(nodePrev);
            return nodeRemove.getData();
        }
        else{
            throw new IndexOutOfBoundsException();
        }
    }

    public int getSize(){
        DoublyNode<T> node = head;
        int counter;
        if(head == null) counter = 0;
        else counter = 1;

        while(node != null && node.getNext() != null){
            node = node.getNext();
            counter++;
        }
        return counter;
    }

    public T getElement(int index){
        if(index == 0){
            return head.getData();
        }
        else if(index == getSize() - 1){
            return tail.getData();
        }
        else if(index > 0 && index < getSize() - 1){
            DoublyNode<T> node = head;
            int counter = 0;
            while(node != null && node.getNext() != null && counter != index){
                counter++;
                node = node.getNext();
            }
            return node.getData();
        }
        else{
            throw new IndexOutOfBoundsException();
        }
    }

    public void reverse(){
        DoublyNode<T> previous = null;
        DoublyNode<T> current = head;
        DoublyNode<T> next;
        while(current != null){
            next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }
        head = previous;
    }

    public String print(){
        StringBuilder sb = new StringBuilder();
        DoublyNode<T> node = head;
        sb.append("[");
        while(node != null){
            sb.append(node.getData()).append(" ");
            node = node.getNext();
        }
        sb.append("]");
        return sb.toString();
    }
}