package MovimientoDeCaballo;

public class Game {
    StackDynamic<Position>[] movesRegisters;
    Horse horse;

    public Game(int moves, Horse horse) {
        this.movesRegisters = new StackDynamic[moves];
        this.horse = horse;
    }
    public void moveHorse(){

    }
}
