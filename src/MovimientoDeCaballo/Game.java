package MovimientoDeCaballo;

import java.util.Queue;

public class Game {
    StackDynamic<Position>[] movesRegisters;
    Horse horse;
    int jumps;
    int activeStackIndex;

    public Game(int jumps, Horse horse) {
        this.jumps = jumps;
        this.movesRegisters = new StackDynamic[jumps];
        this.horse = horse;
        activeStackIndex = -1;
    }
    public void fillNextStack(){
        if(activeStackIndex < jumps-1) {
            activeStackIndex++;
            movesRegisters[activeStackIndex] = horse.getPossibleMoves();
            horse.move(movesRegisters[activeStackIndex].peek());
        }
    }
    public void showPossiblePaths() throws IsEmptyException {
        if (allStacksEmpty() || activeStackIndex == -1){ //Cut condition: if the first stack is empty it means that it showed all the possible paths so it returns.
            return;
        }
        int lastStackSize = movesRegisters[jumps-1].size(); //Stores the number of position in the last jump stack
        String previousPositionsInPath = "";
        for (int i = 0; i < movesRegisters.length-1; i++) { //Stores the first part of the path (without the last jump)
            previousPositionsInPath += movesRegisters[i].peek().toString() + " - ";
        }
        for (int i = 0; i < lastStackSize; i++) { //Prints the paths changing the last jump position. After it is printed, that last position is popped from the stack.
            System.out.println(previousPositionsInPath + movesRegisters[jumps-1].peek().toString());
            movesRegisters[jumps-1].pop();
        }
        goBack(); // Calls Go back to delete the positions that have no more possible paths to be shown.

        horse.move(movesRegisters[activeStackIndex].peek()); //Moves the horse to the next position to refill the stacks.

        for (int i = activeStackIndex; i < movesRegisters.length - 1; i++) { //Fills the stacks with the new possible paths, standing in a different position.
            fillNextStack();
        }
        showPossiblePaths(); //Calls itself to continue showing the possible paths.
    }
    public void goBack() throws IsEmptyException {
        if(movesRegisters[activeStackIndex].isEmpty()){
            activeStackIndex--;
            movesRegisters[activeStackIndex].pop();
            goBack();
        }
    }
    public void showStackContents() throws IsEmptyException {
        if(activeStackIndex == -1){
            System.out.println("Stacks are empty.");
        }
        else {
            for (int i = 0; i < activeStackIndex + 1; i++) {
                System.out.println("Stack " + (i + 1) + ":");
                printStackElements(movesRegisters[i]);
            }
        }
    }
    public boolean allStacksEmpty() {
        return movesRegisters[0].isEmpty();
    }
    public void printStackElements(StackDynamic<Position> s) throws IsEmptyException {
        if(s.isEmpty()){
            return;
        }
        Position p = s.peek();
        s.pop();
        printStackElements(s);
        System.out.println(p);
        s.stack(p);
    }
}
