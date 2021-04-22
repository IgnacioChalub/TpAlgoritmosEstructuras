package Metrovias;

import Metrovias.StackAndQueue.QueueDynamic;
import Metrovias.StackAndQueue.StackDynamic;

public class Window {
    Double collectedAmount;
    QueueDynamic<Passenger> line;
    StackDynamic<Ticket> tickets;

    public Window(){
        collectedAmount = 0.0;
        this.line = new QueueDynamic<>();
        this.tickets = new StackDynamic<>();
    }
    public void attendPassenger(){
        //Se desencola un pasajero de la fila, se le genera un ticket y se suma el valor del ticket al monto recaudado
    }
    public void addToLine(Passenger passenger){
        line.enqueue(passenger);
    }
}
