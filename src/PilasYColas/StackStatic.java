package PilasYColas;

//Matias Coulougian 25/03/2021

public class StackStatic<T> implements StackInterface<T> {
    private T[] data; //Array that is initialized with size 10 that stores the elements in the stack
    private int tope;

    public StackStatic() {
        this.data = (T[]) new Object[10];
        this.tope = -1;
    }
    public void pop() throws IsEmptyException {
        if (tope<0) {
            throw new IsEmptyException();
        }
        tope--;
    }
    @Override
    public void stack(T element) {
        if(tope + 1 == data.length){
            increaseSize();
        }
        tope++;
        data[tope] = element;
    }

    public T peek(){
        if(isEmpty()){
            return null;
        }
        return data[tope];
    }

    public boolean isEmpty() {
        return tope == -1;
    }

    public int size(){
        return tope+1;
    }

    @Override
    public void empty() throws IsEmptyException {
        if(isEmpty()){
            throw new IsEmptyException();
        }
        tope = -1;
    }

    private void increaseSize() { //Duplicates the array size if stack is called and the array has no space
        T[] newData = (T[]) new Object[data.length*2];
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
}
