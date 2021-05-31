package TpArchivos.List;

public class OrderedDynamicList<T extends Comparable<T>> implements List<T> {
    private Node<T> head, window, sentinel;
    private int size;

    public OrderedDynamicList(){
        head = new Node<T>();
        sentinel = new Node<T>();
        head.next = sentinel;
        window = head;
        size = 0;
    }
    @Override
    public T getActual() {
        return window.value;
    }
    @Override
    public int getActualPosition() {
        int pos = 0;
        if (!isVoid()) {
            Node<T> aux = head;
            for (; aux.next != window; pos++) aux = aux.next;
        }
        return pos;
    }
    @Override
    public boolean isVoid() {
        return head.next == sentinel;
    }
    @Override
    public boolean listEnd() {
        return window.next == sentinel;
    }
    @Override
    public void insertPrev(T obj) {
        if (!isVoid()) {
            goBack();
        }
        insertNext(obj);
    }
    @Override
    public void insertNext(T obj) {
        window.next = new Node<>(obj, window.next);
        window = window.next;
        size++;
    }
    @Override
    public void goNext() {
        if(window.next == sentinel) throw new IndexOutOfBoundsException("Reached the end of this List");
        window = window.next;
    }
    @Override
    public void goPrev() {
        if(window == head.next) throw new IndexOutOfBoundsException("Reached the beginning of this List");
        goBack();
    }
    private void goBack(){
        Node<T> aux = head;
        while(window != aux.next){
            aux = aux.next;
        }
        window = aux;
    }
    @Override
    public void goTo(int index) {
        window = head.next;
        for(int i = 0; i < index; i++){
            window = window.next;
        }
    }
    @Override
    public void remove() {
        if(isVoid()) throw new NullPointerException("This List is empty");
        goBack();
        window.next = window.next.next;
        window = window.next;
        if(window == sentinel) goBack();
        size--;
    }
    public T search(T element) {
        int min = 0;
        int max = size-1;
        int middle = (min+max)/2;
        while(min <= max) {
            goTo(middle);
            if (element.compareTo(getActual()) == 0)
                return getActual();
            else if (element.compareTo(getActual()) < 0)
                max = middle-1;
            else
                min = middle +1;
                middle = (min+max)/2;
        }
        return null;
    }
    public boolean contains(T element){
        int min = 0;
        int max = size-1;
        int middle = (min+max)/2;
        while(min <= max) {
            goTo(middle);
            if (element.compareTo(getActual()) == 0)
                return true;
            else if (element.compareTo(getActual()) < 0)
                max = middle-1;
            else
                min = middle +1;
            middle = (min+max)/2;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    public void add(T t) {
        if (size() == 0 || t.compareTo(getActual()) == 0) {
            insertNext(t);
            return;
        }
        if(t.compareTo(getActual()) > 0){
            goForward(t);
        } else {
            goBackwards(t);
        }
    }

    private void goForward(T t){
        while(!listEnd()){
            goNext();
            if(t.compareTo(getActual()) < 0){
                insertPrev(t);
                return;
            }
        }
        insertNext(t);
    }
    private void goBackwards(T t){
        while(!(head.next == window)){
            goPrev();
            if(t.compareTo(getActual()) > 0){
                insertNext(t);
                return;
            }
        }
        insertPrev(t);
    }
}
