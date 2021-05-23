package ComparacionDeArbolesBinariosDeBusqueda.tests;

import ComparacionDeArbolesBinariosDeBusqueda.RedBlackTree;
import org.junit.jupiter.api.Test;

class RedBlackTreeTest {

    @Test
    void preorder() {
        RedBlackTree<Integer> h = new RedBlackTree<>();
        h.insert(10);
        h.insert(20);
        h.insert(5);
        h.insert(9);
        h.insert(4);
        h.insert(30);
        h.insert(55);
        h.insert(54);
        h.preorder();
    }
}
