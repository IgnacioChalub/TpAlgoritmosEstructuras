package ComparacionDeAlgoritmos;

public class MainEj1 {
    public static void main(String[] args) {
        Integer[] array = {1, 2, 4, 6, 9, 10, 10};

        System.out.println(Ej1.BinarySearch(array, 9));
        System.out.println(Ej1.SeqSearch(array, 9));

        System.out.println(Ej1.BinarySearch(array, 10));
        System.out.println(Ej1.SeqSearch(array, 10));

        System.out.println(Ej1.BinarySearch(array, 3));
        System.out.println(Ej1.SeqSearch(array, 3));
    }
}
