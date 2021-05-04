package Metrovias;
import Metrovias.StackAndQueue.Scanner;
//Authors: Ignacio Chalub, Mateo Valle and Matias Coulougian.

public class Menu {
    public static void main(String[] args) {
        int windowsNumber;
        do {
            windowsNumber = Scanner.getInt("Insert Window Number: ");
        } while (windowsNumber > 25 || windowsNumber < 5);
        Window[] windows = new Window[windowsNumber];
        for (int i = 0; i < windowsNumber; i++) {
            windows[i] = new Window();
        }
        Metrovia metrovia = new Metrovia(windows);
        Simulation simulation = new Simulation(metrovia, 50.0, 5);
        while(true){
            int action = Scanner.getInt("Press 1 to run 30 seconds or 2 to end the simulation: ");
            if(action == 1){
                simulation.run30seconds();
            }else if(action == 2){
                System.out.println("Time simulated: " + simulation.time + " seconds ( " + (float)(simulation.time)/60  + " minutes | " + (float)(simulation.time)/3600 + " hours)");
                simulation.endSimulation();
                System.exit(0);
            }
        }
    }
}
