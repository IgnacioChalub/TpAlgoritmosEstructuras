package ComparacionDeArbolesBinariosDeBusqueda;

import ComparacionDeArbolesBinariosDeBusqueda.Exceptions.RepeatedElementException;

public class AVLTest {
    public static void main(String[] args) {
        ArbolAVL<Integer> avl = new ArbolAVL<>();
        try {
            avl.insert(2);
            avl.insert(4);
            avl.insert(1);
            avl.insert(8);
        } catch (RepeatedElementException e) {
            e.printStackTrace();
        }
    }
}
