package ComparacionDeAlgoritmos.Tests;

public class Bus implements Comparable<Bus>{ //Objet for testing the comparable obj sort methods in ej2
    int line;
    int capacity;
    int number;

    public Bus(int line, int capacity, int number) {
        this.line = line;
        this.capacity = capacity;
        this.number = number;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public int compareTo(Bus x) {
        if (line != x.getLine()) {
            return line - x.getLine();
        }
        return number - x.getNumber();
    }
}
