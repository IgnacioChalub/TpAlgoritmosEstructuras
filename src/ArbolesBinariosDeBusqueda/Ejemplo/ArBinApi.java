package ArbolesBinariosDeBusqueda.Ejemplo;

import ArbolesBinariosDeBusqueda.BinarySearchTree;
import ArbolesBinariosDeBusqueda.Exceptions.EmptyTreeException;

public class ArBinApi<T> {
    public void inorden (BinarySearchTree<T> a) throws EmptyTreeException {
        if (!a.isEmpty()){
            inorden(a.getLeft());
            System.out.println(a.getRoot().toString());
            inorden(a.getRight());
        }
    }
}
