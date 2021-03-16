package ComparacionDeAlgoritmos.Tests;

import ComparacionDeAlgoritmos.Ej2;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Ej2Test {
    int n1 = 3;
    int n2 = 100;
    int n3 = 100000;
//Integer Sorts

    @Test
    public void selectionSort(){
        int[] array = {5,3,1,2,7,6,4};
        Ej2.selectionSort(array);
        int[] sortedArray = {1,2,3,4,5,6,7};
        for (int i = 0; i < array.length; i++) {
            assertEquals(sortedArray[i],array[i]);
        }
    }
    @Test
    public void insertionSort(){
        int[] array = {5,3,1,2,7,6,4};
        Ej2.insertionSort(array);
        int[] sortedArray = {1,2,3,4,5,6,7};
        for (int i = 0; i < array.length; i++) {
            assertEquals(sortedArray[i],array[i]);
        }
    }
    @Test
    public void bubbleSort(){
        int[] array = {5,3,1,2,7,6,4};
        Ej2.bubbleSort(array);
        int[] sortedArray = {1,2,3,4,5,6,7};
        for (int i = 0; i < array.length; i++) {
            assertEquals(sortedArray[i],array[i]);
        }
    }
    //String Sorts
    @Test
    public void bubbleSortString(){
        String[] array = {"df", "lm", "abc", "ghi", "jk","AA"};
        Ej2.bubbleSort(array);
        String[] sortedArray = {"AA", "abc", "df", "ghi", "jk", "lm"};
        for (int i = 0; i < array.length; i++) {
            assertEquals(sortedArray[i],array[i]);
        }
    }
    @Test
    public void insertionSortString(){
        String[] array = {"df", "lm", "abc", "ghi", "jk","aa"};
        Ej2.insertionSort(array);
        String[] sortedArray = {"aa", "abc", "df", "ghi", "jk", "lm"};
        for (int i = 0; i < array.length; i++) {
            assertEquals(sortedArray[i],array[i]);
        }
    }
    @Test
    public void selectionSortString(){
        String[] array = {"df", "lm", "abc", "ghi", "jk","aa"};
        Ej2.selectionSort(array);
        String[] sortedArray = {"aa", "abc", "df", "ghi", "jk", "lm"};
        for (int i = 0; i < array.length; i++) {
            assertEquals(sortedArray[i],array[i]);
        }
    }
    //Comparable Object Sort
    @Test
    public void selectionSortComparable(){
        Bus bus1 = new Bus(11,123,120);
        Bus bus2 = new Bus(11,123,130);
        Bus bus3 = new Bus(13,123,120);
        Bus bus4 = new Bus(9,123,120);
        Bus[] array = {bus2,bus4,bus3,bus1};
        Bus[] sortedArray = {bus4,bus1,bus2,bus3};
        Ej2.selectionSort(array);
        for (int i = 0; i < array.length; i++) {
            assertEquals(sortedArray[i],array[i]);
        }
    }
    @Test
    public void insertionSortComparable(){
        Bus bus1 = new Bus(11,123,120);
        Bus bus2 = new Bus(11,123,130);
        Bus bus3 = new Bus(13,123,120);
        Bus bus4 = new Bus(9,123,120);
        Bus[] array = {bus2,bus4,bus3,bus1};
        Bus[] sortedArray = {bus4,bus1,bus2,bus3};
        Ej2.insertionSort(array);
        for (int i = 0; i < array.length; i++) {
            assertEquals(sortedArray[i],array[i]);
        }
    }
    @Test
    public void bubbleSortComparable(){
        Bus bus1 = new Bus(11,123,120);
        Bus bus2 = new Bus(11,123,130);
        Bus bus3 = new Bus(13,123,120);
        Bus bus4 = new Bus(9,123,120);
        Bus[] array = {bus2,bus4,bus3,bus1};
        Bus[] sortedArray = {bus4,bus1,bus2,bus3};
        Ej2.bubbleSort(array);
        for (int i = 0; i < array.length; i++) {
            assertEquals(sortedArray[i],array[i]);
        }
    }
    @Test
    public void recursiveSelectionSort(){
        Bus bus1 = new Bus(11,123,120);
        Bus bus2 = new Bus(11,123,130);
        Bus bus3 = new Bus(13,123,120);
        Bus bus4 = new Bus(9,123,120);
        Bus bus5 = new Bus(1,123,120);
        Bus[] array = {bus2,bus4,bus3,bus1, bus5};
        Bus[] sortedArray = {bus5, bus4,bus1,bus2,bus3};
        Ej2.recursiveSelectionSort(array);
        for (int i = 0; i < array.length; i++) {
            assertEquals(sortedArray[i],array[i]);
        }
    }

}
