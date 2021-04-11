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
    public void fillNextStack(){ //Fills the next stack with the possible moves from the actual horse position. Then moves the horse to the top position in the new stack.
        if(activeStackIndex < jumps-1 && horse.getPosition() != null) {
            activeStackIndex++;
            movesRegisters[activeStackIndex] = horse.getPossibleMoves();
            horse.move(movesRegisters[activeStackIndex].peek());
        }
    }
    public void showPossiblePaths() throws IsEmptyException { //Prints all paths when the n stacks are filled (are jumps are done)
        if (allStacksEmpty() || activeStackIndex == -1){ //Cut condition: if the first stack is empty it means that it showed all the possible paths so it returns.
            return;
        }
        int lastStackSize = movesRegisters[jumps-1].size(); //Stores the number of positions in the last stack.
        String previousPositionsInPath = "";
        for (int i = 0; i < movesRegisters.length-1; i++) { //Stores the first part of the path (without the last jump positions)
            previousPositionsInPath += movesRegisters[i].peek().toString() + " - ";
        }
        for (int i = 0; i < lastStackSize; i++) { //Prints the combination of the path with all the possible last jumps. After it is printed, that last position is popped from the stack.
            System.out.println(previousPositionsInPath + movesRegisters[jumps-1].peek().toString());
            movesRegisters[jumps-1].pop();
        }
        goBack(); // Calls Go back to remove the combinations that have already been printed and stand in another position.

        horse.move(movesRegisters[activeStackIndex].peek()); //Moves the horse to the next position to refill the stacks.

        for (int i = activeStackIndex; i < movesRegisters.length - 1; i++) { //Fills the stacks with the new possible paths, standing in a different position.
            fillNextStack();
        }
        showPossiblePaths(); //Calls itself to continue showing the possible paths.
    }
    private void goBack() throws IsEmptyException { //Method that does part of the backtracking.
        if(movesRegisters[activeStackIndex].isEmpty() && activeStackIndex > 0){ //If the stack is empty and it is not the first one in the array it goes to the previous one and pops the element in the top.
            activeStackIndex--;
            movesRegisters[activeStackIndex].pop();
            goBack(); //Then it calls itself to check if this stack is empty.
        }
    }
    public void showStackContents() throws IsEmptyException { //Prints the positions stored in each stack (before completing the n jumps)
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
    private boolean allStacksEmpty() {
        return movesRegisters[0].isEmpty();
    }
    private void printStackElements(StackDynamic<Position> s) throws IsEmptyException { // Prints the positions in a stack popping and then re-stacking each one.
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
