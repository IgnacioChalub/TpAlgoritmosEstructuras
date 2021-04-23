package Metrovias;

import Metrovias.StackAndQueue.StackDynamic;
import Metrovias.StackAndQueue.IsEmptyException;

public class Simulation {
    Metrovia metrovia;
    Double atentionProbability;
    Integer time;
    int passengersIn30seconds;

    public Simulation(Metrovia metrovia, Double atentionProbability, int passengersIn30seconds) {
        this.metrovia = metrovia;
        this.atentionProbability = atentionProbability;
        time = 0;
        this.passengersIn30seconds = passengersIn30seconds;
    }
    public void run30seconds(){
        time += 30;
        Passenger[] newPassengers = new Passenger[passengersIn30seconds];
        for (int i = 0; i < passengersIn30seconds; i++) {
            newPassengers[i] = new Passenger(time);
        }
        assignPassengers(newPassengers);
        passengersUnqueue();
    }

    public void endSimulation(){
        //Imprime monto total y el tiempo medio de espera de cada ventanilla.
        Double[] averageTimeByWindow = metrovia.getWindowsAvgTime();
        System.out.println("Average wait time for each window (in seconds): ");
        for (int i = 0; i < metrovia.getWindowsNumber(); i++) {
            System.out.println("Window " + (i+1) + ": " + averageTimeByWindow[i]);
        }

        Double[] collectedByWindow = metrovia.getCollectedAmmount();
        System.out.println("Money collected by each window: ");
        for (int i = 0; i < metrovia.getWindowsNumber(); i++) {
            System.out.println("Window " + (i+1) + ": $" + collectedByWindow[i] );
        }


        //Muestra la pila de tickets de metrovia con mostrarPila()
        try {
            showStack(metrovia.getTickets());
        } catch (IsEmptyException e) {
            System.out.println(e.getMessage());
        }
    }

    private void showStack(StackDynamic<Ticket> s) throws IsEmptyException {
         // Prints the positions in a stack popping and then re-stacking each one.
        if(s.isEmpty()){
            return;
        }
        Ticket ticket = s.peek();
        s.pop();
        showStack(s);
        System.out.println(ticket.toString());
        s.stack(ticket);
    }

    public void assignPassengers(Passenger[] newPassengers){
        int amountOfWindows = metrovia.getWindowsNumber();
        for (int i = 0; i < newPassengers.length; i++) {
            int windowNumber = (int) (Math.random() * amountOfWindows);
            metrovia.assignPassengerToWindow(newPassengers[i], windowNumber);
        }
    }
    public void passengersUnqueue() {
        for (int i = 0; i < metrovia.getWindowsNumber(); i++) {
            if(generateNumber() < atentionProbability){
                metrovia.attendPassengers(time,i);
            }
        }
    }
    public double generateNumber(){
        return Math.random() * 100;
    }
}
