package MovimientoDeCaballo;

import org.hamcrest.core.Is;

public class Menu {
    public static void main(String[] args) {
        int initialRow = Scanner.getInt("row: ");
        int initialColumn = Scanner.getInt("column: ");
        int jumps = Scanner.getInt("jumps: ");
        int jumpsDone = 0;
        Game game = new Game(jumps, new Horse(new Position(initialRow,initialColumn)));
        while (true){
            printMenu();
            int input = Scanner.getInt("Choose Option ");
            switch (input){
                case 1:
                    game.fillNextStack();
                    jumpsDone++;
                    if(jumps == jumpsDone){
                        try {
                            game.showPossiblePaths();
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

}
