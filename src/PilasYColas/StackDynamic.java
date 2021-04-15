package PilasYColas;

//Matias Coulougian 25/03/2021

public class StackDynamic<T> implements StackInterface<T> {
    private Node<T> tope;
    private int size;

    public StackDynamic() {
        this.tope = null;
        size = 0;
    }

    public void pop() throws IsEmptyException {
        if(size == 0) {
            throw new IsEmptyException();
        }
        tope = tope.next;
        size--;
    }

    @Override
    public void stack(T element) {
        Node<T> aux = new Node<T>(element,tope);
        tope = aux;
        size++;
    }

    public T peek(){
        if (isEmpty()) {
            return null;
        }
        return tope.value;
    }

    public boolean isEmpty() {
        return tope == null;
    }

    public int size(){
        return size;
    }

    @Override
    public void empty() throws IsEmptyException {
        if(isEmpty()){
            throw new IsEmptyException();
        }
        tope = null;
        size = 0;
    }
}
