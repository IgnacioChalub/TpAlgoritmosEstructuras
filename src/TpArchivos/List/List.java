package TpArchivos.List;

public interface List<T> extends GeneralList<T> {
    void insertNext(T obj);
    void insertPrev(T obj);
}
