package node;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SinglyNode<T> {
    private T data;
    private SinglyNode<T> next;

    public SinglyNode(T data, SinglyNode<T> next) {
        this.data = data;
        this.next = next;
    }
}
