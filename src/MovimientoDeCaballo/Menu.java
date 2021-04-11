package MovimientoDeCaballo;

import org.hamcrest.core.Is;

import java.util.Stack;

public class Menu {
    public static void main(String[] args) {
        int initialColumn;
        int initialRow;
        do{
            String initialColumnStr = Scanner.getString("column: ");
            initialColumnStr = initialColumnStr.toUpperCase();
            initialColumn = columnToInt(initialColumnStr);
        }
        while (initialColumn>8 || initialColumn<1);
        do{
            initialRow = Scanner.getInt("row: ");
        }
        while (initialRow>8 || initialRow<1);
        int jumps = Scanner.getInt("jumps: ");
        int jumpsDone = 0;
        Game game = new Game(jumps, new Horse(new Position(initialRow,initialColumn)));
        while (true){
            printMenu();
            System.out.println("--------------------------------------");
            int input = Scanner.getInt("Choose Option ");
            System.out.println("--------------------------------------");
            switch (input){
                case 1:
                    game.fillNextStack();
                    jumpsDone++;
                    if(jumps == jumpsDone){
                        try {
                            game.showPossiblePaths();
                            System.exit(0);
                        } catch (IsEmptyException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case 2:
                    try {
                        game.showStackContents();
                    }catch (IsEmptyException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Choose a valid option");
                    break;
            }
        }
    }
    public static void printMenu(){
        System.out.println("1. Next Jump");
        System.out.println("2. Show Stacks Content");
        System.out.println("3. Exit");
    }
    private static int columnToInt(String columnString){
        int columnNumber = 0;
        switch(columnString){
            case "A":
                columnNumber = 1;
                break;
            case "B":
                columnNumber = 2;
                break;
            case "C":
                columnNumber = 3;
                break;
            case "D":
                columnNumber = 4;
                break;
            case "E":
                columnNumber = 5;
                break;
            case "F":
                columnNumber = 6;
                break;
            case "G":
                columnNumber = 7;
                break;
            case "H":
                columnNumber = 8;
                break;
            default:
                break;
        }
        return columnNumber;
    }
}
