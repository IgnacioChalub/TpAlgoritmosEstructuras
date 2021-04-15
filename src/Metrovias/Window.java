package Metrovias;

import Metrovias.StackAndQueue.QueueDynamic;
import Metrovias.StackAndQueue.StackDynamic;

public class Window {
    Double collectedAmount;
    QueueDynamic<Passenger> line;
    StackDynamic<Ticket> tickets;

    public Window() {
        collectedAmount = 0.0;
        this.line = new QueueDynamic<>();
        this.tickets = new StackDynamic<>();
    }

}
