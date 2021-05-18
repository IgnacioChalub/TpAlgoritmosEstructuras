package ComparacionDeArbolesBinariosDeBusqueda;

public class DoubleNode<T>{
    T value;
    DoubleNode<T> left,right;

    public DoubleNode(T o) {
        value = o;
    }

    public DoubleNode(T o, DoubleNode<T> left, DoubleNode<T> right) {
        this.value = o;
        this.left = left;
        this.right = right;
    }
}
