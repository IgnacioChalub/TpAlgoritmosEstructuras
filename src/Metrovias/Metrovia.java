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
    public void attendPassengers(int time, int windowNumber) {
        if(!windows[windowNumber].getLine().isEmpty()) {
            tickets.stack(windows[windowNumber].attendPassenger(time));
        }
    }
    public Double[] getCollectedAmmount(){
        Double[] collectedByWindow = new Double[windows.length];
        for (int i = 0; i < windows.length; i++) {
            collectedByWindow[i] = windows[i].getCollectedAmmount();
        }
        return collectedByWindow;
    }

    public Double[] getWindowsAvgTime() {
        Double[] averageTimeByWindow = new Double[windows.length];
        for (int i = 0; i < windows.length; i++) {
            averageTimeByWindow[i] = windows[i].getAverageTime();
        }
        return averageTimeByWindow;
    }

    public StackDynamic<Ticket> getTickets() {
        return tickets;
    }
}
