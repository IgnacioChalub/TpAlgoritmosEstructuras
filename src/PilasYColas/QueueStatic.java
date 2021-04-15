package PilasYColas;

//Matias Coulougian 25/03/2021

public class QueueStatic<T> implements QueueInterface<T> {
    private T[] data =(T[]) new Object[10]; //Array with initial size 10 that stores the elements in the queue
    int front;
    int back;
    private int size;

    public QueueStatic(){
        this.front = 0;
        this.back = -1;
        this.size = 0;
    }
    public void enqueue(T x){
        increaseArraySize();
        back = manageIndex(back);
        data[back] = x;
        size++;
    }
    public T dequeue() throws IsEmptyException {
        if(isEmpty()){
            throw new IsEmptyException();
        }
        int f = front;
        front = manageIndex(front);
        size--;
        return data[f];
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    private void increaseArraySize(){ //Checks if the array needs more size to store elements and duplicates the size in this case
        if((back == front-1 && !(isEmpty()))|| (back == data.length-1 && front == 0 && !(isEmpty()))){
            T[] newData = (T[]) new Object[data.length * 2];
            for (int i = 0; i < data.length; i++) {
                newData[i] = data[front];
                front = manageIndex(front);
            }
            back = data.length ;
            front = 0;
            data = newData;
        }
    }
    private int manageIndex(int index){ //Moves front or back index through the array when enqueue and dequeue are used
        if(index == data.length-1){
            index = 0;
        }
        else{
            index++;
        }
        return index;
    }
}
