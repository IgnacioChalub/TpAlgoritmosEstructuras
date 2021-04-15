package Metrovias;

import Metrovias.StackAndQueue.QueueDynamic;
import Metrovias.StackAndQueue.StackDynamic;

public class Metrovia {
    Window[] windows;
    StackDynamic<Ticket> tickets;

    public Metrovia(Window[] windows) {
        this.windows = windows;
        this.tickets = new StackDynamic<>();
    }
}
