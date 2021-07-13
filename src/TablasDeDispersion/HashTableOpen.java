package TablasDeDispersion;
import ComparacionDeArbolesBinariosDeBusqueda.BinarySearchTree;
import ComparacionDeArbolesBinariosDeBusqueda.Exceptions.RepeatedElementException;

public class HashTableOpen {

    private DynamicList t[];
    private int capacity;

    public HashTableOpen(int M) {
        if (!Primo.esPrimo(M))
            M = Primo.proxPrimo(M);
        capacity = M;
        t = new DynamicList[M];
        for(int i = 0; i < M ; i++)
            t[i] = new DynamicList();
    }

    public void insert(Object x) {
        int k =((Hashable) x).hash(capacity);
        t[k].insertNext(x);
    }
    public Object search(Object x) {
        int k = ((Hashable) x).hash(capacity);
        t[k].goTo(0);
        int l = t[k].size();
        for (int i = 0 ; i < l ; i ++ )
            if (((Comparable) x).compareTo(t[k].getActual())== 0)
                return t[k].getActual();
        return x;
    }

    public BinarySearchTree getBinarySearchTree() {
        BinarySearchTree a = new BinarySearchTree<>();
        for (int i = 0; i < capacity; i++ ) {
            if (!t[i].isVoid()) {
                t[i].goTo(0);
                for (int j = 0; j < t[i].size() ; j++) {
                    try {
                        a.insert((Comparable) t[i].getActual());
                    } catch (RepeatedElementException e) {
                        e.printStackTrace();
                    }
                    t[i].goNext();
                    j++;
                }
            }
        }
        return a;
    }
}
