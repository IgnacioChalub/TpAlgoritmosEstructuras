package ComparacionDeAlgoritmos;

public class Ej2 {
    /* DESCRIPCIONES
     a)
     Selection Sort: El algoritmo busca el elemento mas chico de  la parte desordenada del arreglo, y lo pone al final
     de la parte ordenada. Funciomaniento: itera el arreglo a partir de la parte todavia no ordenada, y busca el elemento
     mas chico y luego lo intercambia por el elemento que estaba donde arranco a iterar.

     Insertion Sort: el arreglo se divide en una parte ordenada, y una parte desordenada. Los elementos de la parte
     desordenada se van tomando y ubicando en el lugar correcto en el que esta ordenado. Funcionamiento: Se itera el
     arreglo de 1 a n y compara el elemento actual con el anterior. Si el actual es menor, se compara con los
     elementos anteriores. Y se mueven los elementos mayores una posicion arriba para hacerle lugar al elemento cambiado.

     Bubble Sort: Compara de a dos logares empezando por el principio. Si el de la izquierda es mayor, lo manda para la
     derecha y lo compara con el proximo. De esta forma con la primera recorrida el elemento mayor "gana" todas las
     comparaciones y termina llegando hasta el fondo.
     La segunda recorrida hace lo mismo. Empieza desde el principio pero llega solo hasta el anteultimo lugar para
     mandar al segundo mas grande anteultimo.

    */
    // --------Integer Sorts-----
    //b)
    public static void selectionSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++){//loops the array and saves the position in the index variable
            int index = i;
            for (int j = i + 1; j < arr.length; j++){//loops and if an element is smaller than the one in the indexv puts the smaller element index in the inddex variable
                if (arr[j] < arr[index]){
                    index = j;//searching for lowest index
                }
            }
            //swaps the smaller element with the element in the index position
            int smallerNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }
    }

    public static void insertionSort(int[] a){ //
        int key, j;
        for (int i = 1; i < a.length; i++) {
            key = a[i];
            j = i-1;
            while(j >= 0 && a[j] > key){ // if j is a valid array index (not out of bounds) and the element in J that is before the key is greater than the key, it changes their places.
                a[j+1] = a[j]; //
                j = j-1;
            }
            a[j + 1] = key;
        }

    }
    public static void bubbleSort(int[] a){
        for (int i = 0; i < a.length-1; i++) {//the value of i marks the current iteration
            for (int j = 0; j < a.length-1-i; j++) {//the value of j marks the position in the array which is comparing with j+1. The for goes up to length-1-i
                if(a[j]> a[j+1]){//if the element on the left is grater than the one on the right, it swaps the positions. If not, it continues.
                    int elementJ = a[j];
                    a[j] = a[j+1];
                    a[j+1] = elementJ;
                }
            }
        }
    }
    //parte del c)
    public static int[] generateRandomArray(int size){ // method that generates an array of randon number with lenght n.
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random() * 101); //0 - 100
        }
        return array;
    }

    //----String sorts-----
    //d)
    public static void selectionSort(String[] a) {
        for (int i = 0; i < a.length-1; i++) { //loops the array and saves the position in the index variable
            int index = i;
            for (int j = i+1; j < a.length; j++) { //loops and if an element is smaller than the one in the indexv puts the smaller element index in the inddex variable
                if (a[j].compareTo(a[index]) < 0) {
                    index = j;
                }
            }
            //swaps the smaller element with the element in the index position
            String smallerElement = a[index];
            a[index] = a[i];
            a[i] = smallerElement;
        }
    }

    public static void insertionSort(String[] a){ //
        String key;
        int j;
        for (int i = 1; i < a.length; i++) {
            key = a[i];
            j = i-1;
            while(j >= 0 && a[j].compareTo(key) > 0){ // if j is a valid array index (not out of bounds) and the element in J that is before the key is greater than the key, it changes their places.
                a[j+1] = a[j]; //
                j = j-1;
            }
            a[j + 1] = key; //Java requires casting to the generic comparable to assure that the element introduced into the array is the correct type.
        }

    }

    public static void bubbleSort(String[] a){
        for (int i = 0; i < a.length-1; i++) {//the value of i marks the current iteration
            for (int j = 0; j < a.length-1-i; j++) {//the value of j marks the position in the array which is comparing with j+1. The for goes up to length-1-i
                if(a[j].compareTo(a[j+1]) > 0){//if the element on the left is grater than the one on the right, it swaps the positions. If not, it continues.
                    String elementJ = a[j];
                    a[j] = a[j+1];
                    a[j+1] = elementJ;
                }
            }
        }
    }

    //--Generic Sorts-----
    //e)
    public static <T> void selectionSort(Comparable <T> a[]) {
        for (int i = 0; i < a.length-1; i++) { //loops the array and saves the position in the index variable
            int index = i;
            for (int j = i+1; j < a.length; j++) { //loops and if an element is smaller than the one in the indexv puts the smaller element index in the inddex variable
                if (a[j].compareTo((T) a[index]) < 0) {
                    index = j;
                }
            }
            //swaps the smaller element with the element in the index position
            T smallerElement = (T) a[index];
            a[index] = a[i];
            a[i] = (Comparable<T>) smallerElement;
        }
    }


    public static <T> void insertionSort(Comparable <T> a[]){ //
        T key;
        int j;
        for (int i = 1; i < a.length; i++) {
            key = (T) a[i];
            j = i-1;

            while(j >= 0 && a[j].compareTo(key) > 0){ // if j is a valid array index (not out of bounds) and the element in J that is before the key is greater than the key, it changes their places.
                a[j+1] = a[j]; //
                j = j-1;
            }
            a[j + 1] = (Comparable<T>) key; //Java requires casting to the generic comparable to assure that the element introduced into the array is the correct type.
        }

    }

    public static <T> void bubbleSort(Comparable<T> a[]){
        for (int i = 0; i < a.length-1; i++) {//the value of i marks the current iteration
            for (int j = 0; j < a.length-1-i; j++) {//the value of j marks the position in the array which is comparing with j+1. The for goes up to length-1-i
                if(a[j].compareTo((T) a[j+1]) > 0){//if the element on the left is grater than the one on the right, it swaps the positions. If not, it continues.
                    T elementJ = (T) a[j];
                    a[j] = a[j+1];
                    a[j+1] = (Comparable<T>) elementJ;
                }
            }
        }
    }
    //g)
    public static <T> void recursiveSelectionSort(Comparable<T> a[]){
        recursiveSelectionSort(a, 0);
    }

    private static <T> void recursiveSelectionSort(Comparable<T> a[], int index){ //Selective sort Auxiliary
        if(index == a.length){
            return;
        }
        int j = index+1;
        int smallestElementIndex = smallestElementIndex(a, j, index);
        T smallerElement = (T) a[smallestElementIndex];
        a[smallestElementIndex] = a[index];
        a[index] = (Comparable<T>) smallerElement;
        index++;
        recursiveSelectionSort(a, index);
    }

    private static <T> int smallestElementIndex(Comparable<T> a[], int j, int minIndex){//Selective sort Auxiliary
      if(j == a.length){
          return minIndex;
      }
      if(a[minIndex].compareTo((T) a[j]) > 0){ //a[minIndex] > a[j]
          minIndex = j;
      }
      j++;
      return smallestElementIndex(a, j, minIndex);
    }

}
