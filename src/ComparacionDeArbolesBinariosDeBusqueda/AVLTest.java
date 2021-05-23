package ComparacionDeArbolesBinariosDeBusqueda;

import ComparacionDeArbolesBinariosDeBusqueda.Exceptions.RepeatedElementException;

public class AVLTest {
    public static void main(String[] args) {
        AVLTree<Integer> avl = new AVLTree<>();
        try {
            avl.insert(2);
            avl.insert(4);
            avl.insert(6);
            avl.insert(1);
        } catch (RepeatedElementException e) {
            e.printStackTrace();
        }
    }
}
