package Metrovias;

import Metrovias.StackAndQueue.QueueDynamic;
import Metrovias.StackAndQueue.StackDynamic;

public class Metrovia {
    private Window[] windows;
    private StackDynamic<Ticket> tickets;

    public Metrovia(Window[] windows) {
        this.windows = windows;
        this.tickets = new StackDynamic<>();
    }

    public int getWindowsNumber() {
        return windows.length;
    }
    public void assignPassengerToWindow(Passenger passenger, int windowNumber){
        windows[windowNumber].addToLine(passenger);
    }
}
