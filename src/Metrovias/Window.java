package Metrovias;

import Metrovias.StackAndQueue.IsEmptyException;
import Metrovias.StackAndQueue.QueueDynamic;
import Metrovias.StackAndQueue.StackDynamic;

import java.util.Random;

public class Window {
    Double collectedAmount;
    QueueDynamic<Passenger> line;
    StackDynamic<Ticket> tickets;

    public Window(){
        collectedAmount = 0.0;
        this.line = new QueueDynamic<>();
        this.tickets = new StackDynamic<>();
    }
    public Ticket attendPassenger(int time) throws IsEmptyException {
        if(!line.isEmpty()) {
            Passenger passengerAttended = line.dequeue();
            Ticket ticket = new Ticket(ticketNumberGenerator(),time-passengerAttended.getEnterTime());
            tickets.stack(ticket);
            collectedAmount+=1; //Assuming ticket price is $1
            return ticket;
        }
        return null;
        //Se desencola un pasajero de la fila, se le genera un ticket y se suma el valor del ticket al monto recaudado
    }
    public void addToLine(Passenger passenger){
        line.enqueue(passenger);
    }
    private Integer ticketNumberGenerator() {
        Random r = new Random( System.currentTimeMillis() );
        return ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));
    }

    public QueueDynamic<Passenger> getLine() {
        return line;
    }
}
