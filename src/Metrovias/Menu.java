package Metrovias;


import Metrovias.StackAndQueue.Scanner;

public class Menu {
    public static void main(String[] args) {
        int windowsNumber;
        do {
            windowsNumber = Scanner.getInt("Insert Window Number");
        }
        while (windowsNumber >= 5 && windowsNumber <= 25);
    }
}
