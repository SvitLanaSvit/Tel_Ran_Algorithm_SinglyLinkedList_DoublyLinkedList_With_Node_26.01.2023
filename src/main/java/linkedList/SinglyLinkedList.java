package linkedList;

import node.SinglyNode;

public class SinglyLinkedList<T> {
    private SinglyNode<T> head;

    public SinglyLinkedList(SinglyNode<T> head) {
        this.head = head;
    }

    public void pushToHead(T data){
        SinglyNode<T> node = new SinglyNode<>(data, null);
        if (head != null) {
            node.setNext(head);
        }
        head = node;
    }

    public void pushToTail(T data){
        SinglyNode<T> node = new SinglyNode<>(data, null);

        SinglyNode<T> last = getLast();
        if(last != null){
            last.setNext(node);
        }
        else{
            pushToHead(data);
        }
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
        SinglyNode<T> preLast = head;
        if(head != null && head.getNext() != null){
            SinglyNode<T> last = getLast();

            while(preLast != null && preLast.getNext() != last)
                preLast = preLast.getNext();
            preLast.setNext(null);
        } else {
            head = null;
        }
    }

    private SinglyNode<T> getLast(){
        SinglyNode<T> last = head;
        while(last != null && last.getNext() != null){
            last = last.getNext();
        }
        return last;
    }

    public T getElement(int index){
        SinglyNode<T> node = head;
        if(getSize() > index && index >= 0) {
            int counter = 0;
            while(node != null && node.getNext() != null && counter != index){
                counter++;
                node = node.getNext();
            }
        }
        else{
            throw new IndexOutOfBoundsException();
            //return null;
        }
        return node.getData();
    }

    public int getSize(){
        SinglyNode<T> node = head;
        int counter;
        if(head == null) counter = 0;
        else counter = 1;

        while(node != null && node.getNext() != null){
            node = node.getNext();
            counter++;
        }
        return counter;
    }

    public void reverse(){
        SinglyNode<T> previous = null;
        SinglyNode<T> current = head;
        SinglyNode<T> next;
        while(current != null){
            next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }
        head = previous;
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
            SinglyNode<T> nodePrev = head;
            int counter = 0;
            while(nodePrev != null && nodePrev.getNext() != null && counter != index - 1){
                counter++;
                nodePrev = nodePrev.getNext();
            }
            SinglyNode<T> nextNode = nodePrev.getNext();
            nodePrev.setNext(new SinglyNode<>(data, nextNode));
            isPushed = true;
        }
        return isPushed;
    }

    public T removeByIndex(int index){
        if(getSize() - 1 == index){
            SinglyNode<T> last = getLast();
            removeFromTail();
            return last.getData();
        }
        else if(index == 0){
            SinglyNode<T> first = head;
            removeFromHead();
            return first.getData();
        }
        else if(index > 0 && index < getSize() - 1){
            SinglyNode<T> nodePrev = head;
            int counter = 0;
            while(nodePrev != null && nodePrev.getNext() != null && counter != index - 1){
                counter++;
                nodePrev = nodePrev.getNext();
            }
            SinglyNode<T> nodeRemove = nodePrev.getNext();
            SinglyNode<T> nodeNext = nodePrev.getNext().getNext();
            nodePrev.setNext(nodeNext);
            return  nodeRemove.getData();
        }
        else{
            throw new IndexOutOfBoundsException();
        }
    }

    public String print(){
        StringBuilder sb = new StringBuilder();
        SinglyNode<T> node = head;
        sb.append("[");
        while(node != null){
            sb.append(node.getData()).append(" ");
            node = node.getNext();
        }
        sb.append("]");
        return sb.toString();
    }
}