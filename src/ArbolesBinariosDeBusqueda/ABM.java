package ArbolesBinariosDeBusqueda;

import ArbolesBinariosDeBusqueda.Exceptions.ElementNotFoundInTree;
import ArbolesBinariosDeBusqueda.Exceptions.EmptyTreeException;
import ArbolesBinariosDeBusqueda.Exceptions.RepeatedElementException;

public class ABM{
    BinarySearchTree<Organism> data;

    public ABM() {
        data = new BinarySearchTree<>();
    }
    public void listToTree(Organism[] organisms) throws RepeatedElementException {
        for (int i = 0; i < organisms.length; i++) {
            data.insert(organisms[i]);
        }
    }
    public void alta(Organism x) throws RepeatedElementException {
        data.insert(x);
    }
    public void baja(String code) throws ElementNotFoundInTree {
        data.delete(new Organism(code));
    }
    public void modificarDescripcion(String code, String description) throws ElementNotFoundInTree {
        data.search(new Organism(code)).changeDescripion(description);
    }
    public void informe() throws EmptyTreeException {
        ArBinApi<Organism> api = new ArBinApi<>();
        api.inorden(data);
    }
}
