package ComparacionDeArbolesBinariosDeBusqueda;

//AGREGARLE LAS EXCEPCIONES


import ArbolesBinarios.BinaryTree;
import ComparacionDeArbolesBinariosDeBusqueda.Exceptions.ElementNotFoundInTree;
import ComparacionDeArbolesBinariosDeBusqueda.Exceptions.EmptyTreeException;
import ComparacionDeArbolesBinariosDeBusqueda.Exceptions.RepeatedElementException;
import ComparacionDeArbolesBinariosDeBusqueda.Stack.StackDynamic;

public class ArbolAVL <T>{
    // Implementacion de un arbol binario de busqueda no balanceado
    // Autor Alicia Gioia

    private DoubleNode<T> root;
    private StackDynamic<T> insertionStack;

    public ArbolAVL(){
        this.root = null;
        this.insertionStack = new StackDynamic<>();
    }

    // precondicion: elemento a insertar no pertenece al árbol
    public void insert(Comparable <T> x) throws RepeatedElementException {
        root = insert(root, x);
    }

    private void balanceTree(){
        while(!insertionStack.isEmpty()){

        }
    }

    // precondicion: elemento a eliminar pertenece al árbol
    public void delete(Comparable <T> x) throws ElementNotFoundInTree {
        root = delete(root, x);
    }

    // precondicion: árbol distinto de vacío
    public T getMin() throws EmptyTreeException {
        if(root == null){
            throw new EmptyTreeException();
        }
        return getMin(root).value;
    }

    // precondicion: árbol distinto de vacío
    public T getMax() throws EmptyTreeException {
        if(root == null){
            throw new EmptyTreeException();
        }
        return getMax(root).value;
    }

    // precondicion: elemnto a buscar pertenece al arbol
    public T search(Comparable<T> x)throws ElementNotFoundInTree{
        return search(root, x).value;
    }

    // precondicion: -
    public boolean exists(Comparable<T> x){
        return exists(root, x);
    }

    // precondicion: -
    public boolean isEmpty(){
        return (root == null);
    }

    // precondición: árbol distino de vacío
    public T getRoot() throws EmptyTreeException {
        if(root == null){
            throw new EmptyTreeException();
        }
        return root.value;
    }

    // precondición: árbol distino de vacío
    public ArbolAVL<T> getLeft() throws EmptyTreeException {
        if(root == null){
            throw new EmptyTreeException();
        }
        ArbolAVL<T> t = new ArbolAVL<T>();
        t.root = root.left;
        return t;
    }

    // precondición: árbol distino de vacío
    public ArbolAVL<T> getRight() throws EmptyTreeException {
        if(root == null){
            throw new EmptyTreeException();
        }
        ArbolAVL<T> t = new ArbolAVL<T>();
        t.root = root.right;
        return t;
    }


    // METODOS PRIVADOS
    private DoubleNode<T> getMax(DoubleNode <T> t){
        if (t.right == null)
            return t;
        else
            return getMax(t.right);
    }

    private DoubleNode <T> getMin(DoubleNode <T> t){
        if (t.left == null)
            return t;
        else
            return getMin(t.left);
    }

    private DoubleNode <T> search(DoubleNode <T> t, Comparable<T> x) throws ElementNotFoundInTree {
        if(t == null){
            throw new ElementNotFoundInTree();
        }
        if (x.compareTo(t.value)== 0)
            return t;
        else if (x.compareTo( t.value)< 0)
            return search(t.left, x);
        else
            return search(t.right, x);
    }

    private boolean exists(DoubleNode <T> t, Comparable<T> x) {
        if (t == null)
            return false;
        if (x.compareTo(t.value) == 0)
            return true;
        else if (x.compareTo( t.value)< 0)
            return exists(t.left, x);
        else
            return exists(t.right, x);
    }

    private DoubleNode<T> insert(DoubleNode <T> t, Comparable <T> x) throws RepeatedElementException {
        if (t == null){
            t = new DoubleNode<T>((T) x);
        } else if(x.compareTo(t.value) == 0){
            throw new RepeatedElementException();
        } else if (x.compareTo(t.value) < 0) {
            insertionStack.stack((T) t);
            t.left = insert(t.left, x);
        } else {
            insertionStack.stack((T) t);
            t.right = insert(t.right, x);
        }
        return t;
    }

    private boolean isBalanced() throws EmptyTreeException {
        if(height(getLeft()) - height(getRight()) > 2 || height(getLeft()) - height(getRight()) < -2){
            return false;
        }
        return true;
    }

    private int height(ArbolAVL<T> a) throws EmptyTreeException {
        return heightAux(a) - 1;
    }

    private int heightAux(ArbolAVL<T> a) throws EmptyTreeException {//returns the longest path in the tree
        if (a.isEmpty()) {
            return 0;
        }
        if (heightAux(a.getLeft()) > heightAux(a.getRight())) {
            return 1 + heightAux(a.getLeft());
        }
        return 1 + heightAux(a.getRight());
    }

    private DoubleNode<T> delete (DoubleNode<T> t, Comparable<T> x) throws ElementNotFoundInTree {
        if(t == null){
            throw new ElementNotFoundInTree();
        }
        if (x.compareTo(t.value) < 0)
            t.left = delete(t.left, x);
        else if (x.compareTo(t.value) > 0)
            t.right = delete(t.right, x);
        else
        if (t.left != null && t.right != null ) {
            t.value = getMin(t.right).value;
            t.right = deleteMin(t.right);
        }
        else if (t.left != null)
            t = t.left;
        else
            t =t.right;
        return t;
    }

    private DoubleNode<T> deleteMin(DoubleNode<T> t){
        if (t.left != null)
            t.left = deleteMin(t.left);
        else
            t = t.right;
        return t;
    }
}
