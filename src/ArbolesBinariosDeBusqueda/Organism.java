package ArbolesBinariosDeBusqueda;

public class Organism implements Comparable<Organism> {
    private String code;
    private String type;
    private String description;
    private Integer size;

    public Organism(String code, String type, String description, Integer size) {
        this.code = code;
        this.type = type;
        this.description = description;
        this.size = size;
    }

    public Organism(String code) {
        this.code = code;
    }

    @Override
    public int compareTo(Organism o) {
        return code.compareTo(o.code);
    }

    public void changeDescripion(String description) {
        this.description = description;
    }
    public String toString(){
        return code + " - " + type +  " - " + description +" - size: " + size;
    }
}
