package Metrovias;

import java.util.Random;

public class Simulation {
    Metrovia metrovia;
    Double atentionProbability;
    Integer time;

    public Simulation(Metrovia metrovia, Double atentionProbability) {
        this.metrovia = metrovia;
        this.atentionProbability = atentionProbability;
        time = 0;
    }
    public void run30seconds(){
        time += 30;
        Passenger[] newPassengers = {new Passenger(time),new Passenger(time),new Passenger(time),new Passenger(time),new Passenger(time)};
        assignPassengers(newPassengers);
    }
    public void endSimulation(){
        //Imprime monto total y el tiempo medio de espera de cada ventanilla.
        //Muestra la pila de tickets de metrovia con mostrarPila()
    }
    public void assignPassengers(Passenger[] newPassengers){
        int amountOfWindows = metrovia.getWindowsNumber();
        for (int i = 0; i < 5; i++) {
            int windowNumber = (int) (Math.random() * amountOfWindows);
            metrovia.assignPassengerToWindow(newPassengers[i], windowNumber);
        }
    }
}
