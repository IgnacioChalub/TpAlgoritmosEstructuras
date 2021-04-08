package MovimientoDeCaballo;

public class Position {
    private int row;
    private int column;

    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }
    public boolean isValid(){
        return (row >= 1 && row <= 8) && (column >= 1 && column <= 8);
    }
    public String toString(){
        String position = "";
        switch (column){
            case 1:
                position = "A";
                break;
            case 2:
                position = "B";
                break;
            case 3:
                position = "C";
                break;
            case 4:
                position = "D";
                break;
            case 5:
                position = "E";
                break;
            case 6:
                position = "F";
                break;
            case 7:
                position = "G";
                break;
            case 8:
                position = "H";
                break;
            default:
                break;
        }
        return position + row;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
