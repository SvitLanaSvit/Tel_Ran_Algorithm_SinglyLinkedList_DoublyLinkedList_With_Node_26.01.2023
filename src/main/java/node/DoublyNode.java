package node;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DoublyNode<T> {
    private T data;
    private DoublyNode<T> next;
    private DoublyNode<T> previous;

    public DoublyNode(T data, DoublyNode<T> previous, DoublyNode<T> next){
        this.data = data;
        this.previous = previous;
        this.next = next;
    }
}