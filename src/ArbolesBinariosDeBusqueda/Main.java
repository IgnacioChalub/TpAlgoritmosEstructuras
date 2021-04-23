package ArbolesBinariosDeBusqueda;

import ArbolesBinariosDeBusqueda.Exceptions.ElementNotFoundInTree;
import ArbolesBinariosDeBusqueda.Exceptions.EmptyTreeException;
import ArbolesBinariosDeBusqueda.Exceptions.RepeatedElementException;

public class Main {
    public static void main(String[] args) {
        Organism a = new Organism("AAAA", "Virus", "Te mata", 12);
        Organism b = new Organism("AAAB", "Virus", "...", 10);
        Organism c = new Organism("ABAA", "Bacteria", "...", 1);
        Organism d = new Organism("BBBB", "Bacteria", "...", 22);
        Organism e = new Organism("CCCC", "Bacteria", "...", 20);
        Organism f = new Organism("AABB", "Mamifero", "...", 99);
        Organism g = new Organism("BAAA", "Planta", "...", 10);
        Organism h = new Organism("XAXF", "Planta", "...", 50);

        Organism[] organismsList = {d, h, c, a, e, g, f, b};
        ABM abm = new ABM();
        try {
            abm.listToTree(organismsList);
            Organism newSpecie = new Organism("AADS", "Pez", "Nada", 40);
            abm.alta(newSpecie);
            abm.baja("BBBB");
            abm.modificarDescripcion("AABB","Otra descripcion");
            abm.informe();
        } catch (RepeatedElementException | ElementNotFoundInTree | EmptyTreeException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
