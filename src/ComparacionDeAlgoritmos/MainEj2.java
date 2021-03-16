package ComparacionDeAlgoritmos;

public class MainEj2 {
    public static void main(String[] args) {
        //Parte c)
        //Vamos a testear para n =10, 100, 1000.
        int n1 = 3;
        int n2 = 100;
        int n3 = 100000;

        int[] array1Seq = Ej2.generateRandomArray(n1);
        int[] array1Insert= array1Seq;
        int[] array1Bubble = array1Seq;

        int[]array2Seq = Ej2.generateRandomArray(n2);
        int[] array2Insert= array2Seq;
        int[] array2Bubble = array2Seq;

        int[]array3Seq = Ej2.generateRandomArray(n3);
        int[] array3Insert= array2Seq;
        int[] array3Bubble = array2Seq;

        System.out.println("n = 3 (time in nanoseconds)");

        long startTime = System.nanoTime();
        Ej2.selectionSort(array1Seq);
        long endTime = System.nanoTime();
        long result = (endTime-startTime);
        System.out.println("Selection: " + result);


        startTime = System.nanoTime();
        Ej2.insertionSort(array1Insert);
        endTime = System.nanoTime();
        result = (endTime-startTime);
        System.out.println("Insertion: " + result);

        startTime = System.nanoTime();
        Ej2.bubbleSort(array1Bubble);
        endTime = System.nanoTime();
        result = (endTime-startTime);
        System.out.println("Bubble: " + result);

        //--------------------------------------------------------------------------------------------------------
        System.out.println();
        System.out.println("n = 100 ");

        startTime = System.nanoTime();
        Ej2.selectionSort(array2Seq);
        endTime = System.nanoTime();
        result = (endTime-startTime);
        System.out.println("Selection: " + result);


        startTime = System.nanoTime();
        Ej2.insertionSort(array2Insert);
        endTime = System.nanoTime();
        result = (endTime-startTime);
        System.out.println("Insertion: " + result);

        startTime = System.nanoTime();
        Ej2.bubbleSort(array2Bubble);
        endTime = System.nanoTime();
        result = (endTime-startTime);
        System.out.println("Bubble: " + result);

        //--------------------------------------------------------------------------------------------------------
        System.out.println();
        System.out.println("n = 100000 ");

        startTime = System.nanoTime();
        Ej2.selectionSort(array3Seq);
        endTime = System.nanoTime();
        result = (endTime-startTime);
        System.out.println("Selection: " + result);


        startTime = System.nanoTime();
        Ej2.insertionSort(array3Insert);
        endTime = System.nanoTime();
        result = (endTime-startTime);
        System.out.println("Insertion: " + result);

        startTime = System.nanoTime();
        Ej2.bubbleSort(array3Bubble);
        endTime = System.nanoTime();
        result = (endTime-startTime);
        System.out.println("Bubble: " + result);
    }
}
