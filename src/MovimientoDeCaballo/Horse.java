package MovimientoDeCaballo;

public class Horse {
    private Position position;

    public Horse(Position position) { //row and column are between 1 and 8.
        this.position = position;
    }
    public StackDynamic<Position> getPossibleMoves(){
        Position[] newPositions = new Position[8];
        StackDynamic<Position> possibleMoves = new StackDynamic<Position>();
        newPositions[0] = new Position(position.getRow() +1, position.getColumn() -2);
        newPositions[1] = new Position(position.getRow() +1, position.getColumn() +2);
        newPositions[2] = new Position(position.getRow() +2, position.getColumn() +1);
        newPositions[3] = new Position(position.getRow() +2, position.getColumn() -1);
        newPositions[4] = new Position(position.getRow() -1, position.getColumn() +2);
        newPositions[5] = new Position(position.getRow() -1, position.getColumn() -2);
        newPositions[6] = new Position(position.getRow() -2, position.getColumn() +1);
        newPositions[7] = new Position(position.getRow() -2, position.getColumn() -1);
        for (int i = 0; i < 8; i++) {
            if(newPositions[i].isValid()){
                possibleMoves.stack(newPositions[i]);
            }
        }
        return possibleMoves;
    }
    public void move(Position newPosition){
        position = newPosition;
    }
    public Position getPosition() {
        return position;
    }
}
