package ArbolesBinariosDeBusqueda;

import ArbolesBinariosDeBusqueda.Exceptions.ElementNotFoundInTree;
import ArbolesBinariosDeBusqueda.Exceptions.EmptyTreeException;
import ArbolesBinariosDeBusqueda.Exceptions.RepeatedElementException;

public class Main {
    public static void main(String[] args) {
        //test with a list of random organisms
        Organism a = new Organism("AAAA", "Virus", "Te mata", 12);
        Organism b = new Organism("AAAB", "Virus", "...", 15);
        Organism c = new Organism("ABAA", "Bacteria", "...", 14);
        Organism d = new Organism("BBBB", "Bacteria", "...", 22);
        Organism e = new Organism("CCCC", "Bacteria", "...", 20);
        Organism f = new Organism("AABB", "Mamifero", "...", 99);
        Organism g = new Organism("BAAA", "Planta", "...", 11);
        Organism h = new Organism("XAXF", "Planta", "...", 50);

        Organism[] organismsList = {d, h, c, a, e, g, f, b}; //Array is used to store the organisms and then pass them to the tree.
        ABM abm = new ABM();
        try {
            abm.listToTree(organismsList); // Convertion from list to tree
            abm.informe();
            System.out.println("Se agrega un organismo de codigo AADS, se da de baja BBBB, y se modifica la descripcion AABB");
            Organism newSpecie = new Organism("AADS", "Pez", "Nada", 41);
            abm.alta(newSpecie);
            abm.baja("BBBB");
            abm.modificarDescripcion("AABB","Otra descripcion");
            abm.informe();
            System.out.println("Eliminacion de todos los organismos");
            abm.baja("AAAA");
            abm.baja("AAAB");
            abm.baja("AABB");
            abm.baja("AADS");
            abm.baja("ABAA");
            abm.baja("BAAA");
            abm.baja("CCCC");
            abm.baja("XAXF");
            abm.informe();
            System.out.println("Se insertan 3 organismos nuevos");
            abm.alta(new Organism("ZZZA", "Pez", "Nada", 44));
            abm.alta(new Organism("SADA", "Pez", "Corre", 47));
            abm.alta(new Organism("OGHU", "Pez", "Vuela", 11));
            abm.informe();
        } catch (RepeatedElementException | ElementNotFoundInTree | EmptyTreeException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
