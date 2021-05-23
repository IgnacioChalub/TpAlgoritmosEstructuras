package ComparacionDeArbolesBinariosDeBusqueda.tests;

import ComparacionDeArbolesBinariosDeBusqueda.AVLTree;
import ComparacionDeArbolesBinariosDeBusqueda.Exceptions.RepeatedElementException;

public class AVLTest {
    public static void main(String[] args) {
        AVLTree<Integer> avl = new AVLTree<>();
        try {
            avl.insert(2);
            avl.insert(4);
            avl.insert(6);
            avl.insert(8);
            avl.insert(0);
            avl.insert(1);
            System.out.println("Hola mundo!");
        } catch (RepeatedElementException e) {
            e.printStackTrace();
        }
    }
}
