package ArbolesBinariosDeBusqueda.Ejemplo;

import ArbolesBinariosDeBusqueda.BinarySearchTree;

public class ArBinApi<T> {
    public void inorden (BinarySearchTree<T> a){
        if (!a.isEmpty()){
            inorden(a.getLeft());
            System.out.println(((Estudiante) a.getRoot()).getMatricula() +
                    " " +((Estudiante) a.getRoot()).getApellido());
            inorden(a.getRight());
        }
    }
}
