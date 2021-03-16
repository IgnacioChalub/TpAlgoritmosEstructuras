package ComparacionDeAlgoritmos;

public class Ej1 {

    public static <T> int binarySearch(Comparable <T> a[], Comparable <T> k){
    int min = 0;
    int max = a.length-1;
    int middle = (min+max)/2;

    while(min <= max) {
        if (k.compareTo((T) a[middle])== 0)
            return middle;
        else if (k.compareTo((T) a[middle]) < 0 )
            max = middle-1;
        else
            min = middle +1;

        middle = (min+max)/2;
    }
    return -1;
    }

    public static <T> int seqSearch (Comparable<T> a[], Comparable<T> k) {
        for (int i = 0; i < a.length; i++)
            if (k.compareTo((T)a[i]) == 0){
                return i;
            }
        return -1;
    }
}
