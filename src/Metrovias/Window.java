package Metrovias;
//Authors: Ignacio Chalub, Mateo Valle and Matias Coulougian.
import Metrovias.StackAndQueue.IsEmptyException;
import Metrovias.StackAndQueue.QueueDynamic;
import Metrovias.StackAndQueue.StackDynamic;


public class Window {
    Double collectedAmount;
    QueueDynamic<Passenger> line;
    StackDynamic<Ticket> tickets;
    int ticketNumber;

    public Window(){
        collectedAmount = 0.0;
        this.line = new QueueDynamic<>();
        this.tickets = new StackDynamic<>();
        this.ticketNumber = 11110;
    }
    public Ticket attendPassenger(int time) {
        try {
                Passenger passengerAttended = line.dequeue();
                Ticket ticket = new Ticket(ticketNumberGenerator(),time-passengerAttended.getEnterTime());
                tickets.stack(ticket);
                collectedAmount+=1; //Assuming ticket price is $1
                return ticket;
            } catch (IsEmptyException e) {
                return null;
            }
        //Se desencola un pasajero de la fila, se le genera un ticket y se suma el valor del ticket al monto recaudado
    }

    public void addToLine(Passenger passenger){
        line.enqueue(passenger);
    }

    private Integer ticketNumberGenerator() {
        ticketNumber++;
        return ticketNumber;
    }

    public QueueDynamic<Passenger> getLine() {
        return line;
    }

    public Double getCollectedAmmount() {
        return collectedAmount;
    }

    public Double getAverageTime() {
        if(tickets.size() == 0){
            return 0.0;
        }
        int totalTime = 0;
        int ticketAmmount = tickets.size();
        while (!tickets.isEmpty()){
            Ticket aTicket = tickets.peek();
            totalTime = totalTime + aTicket.getAttentionTime();
            try {
                tickets.pop();
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        Double avgTime = ((double)totalTime/ticketAmmount);
        return avgTime;
    }
}
