package ArbolesBinariosDeBusqueda.Ejemplo;

import ArbolesBinariosDeBusqueda.ArBinApi;
import ArbolesBinariosDeBusqueda.BinarySearchTree;
import ArbolesBinariosDeBusqueda.Exceptions.EmptyTreeException;
import ArbolesBinariosDeBusqueda.Exceptions.RepeatedElementException;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Estudiante> a = new BinarySearchTree<Estudiante>();

        Estudiante e =new Estudiante("I004", "Gonzalez");
        try {
            a.insert(e);
            a.insert(new Estudiante("D022", "Lettera"));
            a.insert(new Estudiante("I014", "Alvarez"));
            a.insert(new Estudiante("E023", "Schmit"));
            a.insert(new Estudiante("O105", "Oberman"));
        }catch (RepeatedElementException exception){
            System.out.println(exception);
        }
        if (a.exists(new Estudiante("A023")))
            System.out.println("existe");
        else
            System.out.println("no existe");
        ArBinApi<Estudiante> api = new ArBinApi<Estudiante>();
        try {
            api.inorden(a);
        } catch (EmptyTreeException emptyTreeException) {
            System.out.println(emptyTreeException.getMessage());
        }
    }
}
