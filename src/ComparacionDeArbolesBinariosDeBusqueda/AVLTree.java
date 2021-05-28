package ComparacionDeArbolesBinariosDeBusqueda;

//AGREGARLE LAS EXCEPCIONES


import ComparacionDeArbolesBinariosDeBusqueda.Exceptions.ElementNotFoundInTree;
import ComparacionDeArbolesBinariosDeBusqueda.Exceptions.EmptyTreeException;
import ComparacionDeArbolesBinariosDeBusqueda.Exceptions.RepeatedElementException;
import ComparacionDeArbolesBinariosDeBusqueda.Stack.IsEmptyException;
import ComparacionDeArbolesBinariosDeBusqueda.Stack.StackDynamic;

public class AVLTree<T>{
    private DoubleNode<T> root;
    private StackDynamic<DoubleNode<T>> insertionStack;

    public AVLTree(){
        this.root = null;
        this.insertionStack = new StackDynamic<>();
    }

    // precondicion: elemento a insertar no pertenece al árbol
    public void insert(Comparable <T> x) throws RepeatedElementException {
        root = insert(root, x);
        try {
            balanceTree(x);
        } catch (EmptyTreeException e) {
            e.printStackTrace();
        } catch (IsEmptyException e) {
            e.printStackTrace();
        }
    }

    private void balanceTree(Comparable <T> x) throws EmptyTreeException, IsEmptyException {
        while(!insertionStack.isEmpty()){
            if(!isBalanced(insertionStack.peek())){
                DoubleNode<T> unbalanced = insertionStack.peek();
                DoubleNode<T> newRoot;
                if(x.compareTo(unbalanced.value) > 0 && x.compareTo(unbalanced.right.value) < 0) {//Chequeo condicion de rotacion doble a derecha
                    newRoot = doubleWithRightChild(unbalanced);
                }
                else if(x.compareTo(unbalanced.value) < 0 && x.compareTo(unbalanced.left.value) > 0) {//Chequeo condicion de rotacion doble a izquierda
                    newRoot = doubleWithLeftChild(unbalanced);
                }
                else if(x.compareTo(unbalanced.value) < 0){
                    newRoot = rotateWithLeftChild(unbalanced);
                }
                else{
                    newRoot = rotateWithRightChild(unbalanced);
                }
                insertionStack.pop();
                changeUnbalancedFathersChild(x, newRoot);
            } else {
                insertionStack.pop();
            }

        }
    }

    private void changeUnbalancedFathersChild(Comparable<T> x, DoubleNode<T> newRoot){
        if(!insertionStack.isEmpty()){
            if(x.compareTo(insertionStack.peek().value) > 0){
                insertionStack.peek().right = newRoot;
            }
            else{
                insertionStack.peek().left = newRoot;
            }
        } else {
            root = newRoot;
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
    public AVLTree<T> getLeft() throws EmptyTreeException {
        if(root == null){
            throw new EmptyTreeException();
        }
        AVLTree<T> t = new AVLTree<T>();
        t.root = root.left;
        return t;
    }

    // precondición: árbol distino de vacío
    public AVLTree<T> getRight() throws EmptyTreeException {
        if(root == null){
            throw new EmptyTreeException();
        }
        AVLTree<T> t = new AVLTree<T>();
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
            insertionStack.stack(t);
            t.left = insert(t.left, x);
        } else {
            insertionStack.stack(t);
            t.right = insert(t.right, x);
        }
        return t;
    }

    private boolean isBalanced(DoubleNode<T> n) throws EmptyTreeException {
        if(height(n.left) - height(n.right) >= 2 || height(n.left) - height(n.right) <= -2){
            return false;
        }
        return true;
    }

    public int treeHeight() {
        return height(root);
    }

    private int height(DoubleNode<T> n) {
        return heightAux(n);
    }

    private int heightAux(DoubleNode<T> n) {//returns the longest path in the tree
        if (n == null){
            return -1;
        }
        if (n.left == null && n.right == null) {
            return 0;
        }
        if (heightAux(n.left) > heightAux(n.right)){
            return 1 + heightAux(n.left);
        }
        return 1 + heightAux(n.right);
    }

    /**Rotate binary tree node with left child.
       // For AVL trees, this is a single rotation for case 1.
     */

    private static DoubleNode rotateWithLeftChild(DoubleNode y){
        DoubleNode x = y.left;
        y.left = x.right;
        x.right = y;
        return x;
    }
    /**
     * Rotate binary tree node with right child.
     * For AVL trees, this is a single rotation for case 4.
     */

    private static DoubleNode rotateWithRightChild( DoubleNode y) {
        DoubleNode x = y.right;
        y.right = x.left;
        x.left = y;
        return x;
    }

    /**
     * Double rotate binary tree node: first left child
     * with its right child; then node k3 with new left child.
     * For AVL trees, this is a double rotation for case 2.
     */
    private static DoubleNode doubleWithLeftChild( DoubleNode y) {
        y.left = rotateWithRightChild(y.left);
        return rotateWithLeftChild(y);
    }

    /**
     * Double rotate binary tree node: first right child
     * with its left child; then node k1 with new right child.
     * For AVL trees, this is a double rotation for case 3.
     */
    private static DoubleNode doubleWithRightChild(DoubleNode y) {
        y.right = rotateWithLeftChild(y.right);
        return rotateWithRightChild(y);
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
    public int searchCountingComparisons(Comparable<T> x) throws ElementNotFoundInTree {
        return searchCountingComparisons(root,x,1);
    }

    private int searchCountingComparisons(DoubleNode<T> t, Comparable<T> x, int count) throws ElementNotFoundInTree {
        count = count+1;
        if(t == null){
            throw new ElementNotFoundInTree();
        }
        if (x.compareTo(t.value)== 0)
            return count;
        else if (x.compareTo( t.value)< 0)
            return searchCountingComparisons(t.left,x,count);
        else
            return searchCountingComparisons(t.right,x,count);
    }
}
