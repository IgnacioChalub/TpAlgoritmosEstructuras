package ComparacionDeArbolesBinariosDeBusqueda.Stack;

import Metrovias.StackAndQueue.IsEmptyException;

public interface StackInterface<T> {
    
    boolean isEmpty();
    T peek();
    void pop() throws Metrovias.StackAndQueue.IsEmptyException, ComparacionDeArbolesBinariosDeBusqueda.Stack.IsEmptyException;
    void stack(T element);
    int size();
    void empty() throws IsEmptyException, ComparacionDeArbolesBinariosDeBusqueda.Stack.IsEmptyException;

}
