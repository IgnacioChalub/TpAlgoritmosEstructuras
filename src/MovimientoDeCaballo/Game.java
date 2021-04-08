package MovimientoDeCaballo;

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
            movesRegisters[activeStackIndex+1] = horse.getPossibleMoves();
            horse.move(movesRegisters[activeStackIndex+1].peek());
            activeStackIndex++;
        }
    }
    public void showPossiblePaths() throws IsEmptyException {
        if (allStacksEmpty()){
            return;
        }
        int lastStackSize = movesRegisters[jumps-1].size();
        String previousPositionsInPath = "";
        for (int i = 0; i < movesRegisters.length-1; i++) {
            previousPositionsInPath += movesRegisters[i].peek().toString() + " - ";
        }
        for (int i = 0; i < lastStackSize; i++) {
            System.out.println(previousPositionsInPath + movesRegisters[jumps-1].peek().toString());
            movesRegisters[jumps-1].pop();
        }
        goBack();
        horse.move(movesRegisters[activeStackIndex].peek());
        for (int i = activeStackIndex; i < movesRegisters.length-1; i++) {
            fillNextStack();
        }
        showPossiblePaths();
    }
    public void goBack() throws IsEmptyException {
        if(movesRegisters[activeStackIndex].isEmpty()){
            activeStackIndex--;
            movesRegisters[activeStackIndex].pop();
            goBack();
        }
    }
    public void showStackContents() throws IsEmptyException {
        for (int i = 0; i < activeStackIndex+1; i++) {
            System.out.println("Stack " + (i+1) + ":");
            StackDynamic<Position> printingStack = new StackDynamic<>();
            printingStack = movesRegisters[i];
            while(printingStack.size() > 0){
                System.out.println(printingStack.peek().toString());
                printingStack.pop();
            }
        }
    }
    public boolean allStacksEmpty() {
        return movesRegisters[0].isEmpty();
    }
}
