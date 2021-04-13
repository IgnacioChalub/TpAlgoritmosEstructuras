package ArbolesBinarios;


public class QueueDynamic<T> implements QueueInterface<T> {
    private Node<T> front;
    private Node<T> back;
    private int size;

    public QueueDynamic() {
        front = null;
        back = null;
        size = 0;
    }
    public void enqueue(T o){
        Node<T> aux = new Node<T>(o, null);
        if(isEmpty()){
            front = aux;
        }
        else {
            back.next = aux;
        }
        back = aux;
        size++;
    }
    public T dequeue() throws IsEmptyException {
        if(isEmpty()){
            throw new IsEmptyException();
        }
        T valueToReturn = front.value;
        front = front.next;
        size--;
        return valueToReturn;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }
}
