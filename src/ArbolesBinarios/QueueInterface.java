package ArbolesBinarios;


public interface QueueInterface<T> {

    void enqueue(T element);
    T dequeue() throws IsEmptyException;
    boolean isEmpty();
    int size();

}
