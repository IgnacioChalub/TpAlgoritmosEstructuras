package Metrovias;

import Metrovias.StackAndQueue.IsEmptyException;
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
    public void attendPassengers(int time, int windowNumber) throws IsEmptyException {
        if(!windows[windowNumber].getLine().isEmpty()) {
            tickets.stack(windows[windowNumber].attendPassenger(time));
        }
    }
}
