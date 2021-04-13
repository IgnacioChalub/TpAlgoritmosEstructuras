package ArbolesBinarios;

//Matias Coulougian 18/03/2021
public class Node<T> {
     T value;
     Node<T> next;

    public Node(T value) {
        this.value = value;
        this.next = null;
    }
    public Node(T value, Node<T> next) {
        this.value = value;
        this.next = next;
    }
}
