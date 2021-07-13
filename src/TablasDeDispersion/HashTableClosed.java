package TablasDeDispersion;

import ComparacionDeArbolesBinariosDeBusqueda.BinarySearchTree;
import ComparacionDeArbolesBinariosDeBusqueda.Exceptions.RepeatedElementException;

public class HashTableClosed {

    private Object t[];
    private int capacity;

    public HashTableClosed(int M) {
        if (!Primo.esPrimo(M))
            M = Primo.proxPrimo(M);
        capacity = M;
        t = new Object[M];
    }

    public void insert(Object x) {
        int k = ((Hashable) x).hash(capacity);
        for (int i = 0; i < capacity-k; i++) {
            int w = k+i;
            if (t[w] == null){
                t[w] = (int) x;
                return;
            }
        }
    }

    public Object search(Object x) {
        int k = ((Hashable) x).hash(capacity);
        for (int i = 0; i < capacity-k; i++) {
            int w = k+i;
            if (t[w] == null){
                return x;
            }
            if (((Comparable) x).compareTo(t[w])== 0){
                return t[w];
            }
        }
        return x;
    }

    public BinarySearchTree getBinarySearchTree() {
        BinarySearchTree a = new BinarySearchTree<>();
        for (int i = 0; i < capacity; i++ ) {
            if (t[i] != null) {
                try {
                    a.insert((Comparable)t[i]);
                } catch (RepeatedElementException e) {
                    e.printStackTrace();
                }
            }
        }
        return a;
    }
}
