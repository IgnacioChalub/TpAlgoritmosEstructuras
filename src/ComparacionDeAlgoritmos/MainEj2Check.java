package ComparacionDeAlgoritmos;


public class MainEj2Check {
    public static void main(String[] args) {
        int[] array = {5,3,1,2,7,6,4};
        Ej2.insertionSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
