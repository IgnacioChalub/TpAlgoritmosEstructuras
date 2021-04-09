package MovimientoDeCaballo;

public class InvalidColumnException extends Exception{
    public InvalidColumnException(){super("The column letter is out of bounds"); }
}
