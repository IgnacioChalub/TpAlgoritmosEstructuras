package ComparacionDeArbolesBinariosDeBusqueda.Exceptions;

public class ElementNotFoundInTree extends Exception {
    public ElementNotFoundInTree(){
        super("The element must be in the tree to delete or search it");
    }
}
