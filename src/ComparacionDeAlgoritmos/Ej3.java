package ComparacionDeAlgoritmos;

public class Ej3 {

    public static <T> Comparable<T>[] mergeArrays(Comparable<T>[] newArray, Comparable<T>[] arrayA, Comparable<T>[] arrayB){
        int a = 0, b = 0;
        for (int i = 0; i < newArray.length; i++) {
            if(a == arrayA.length){
                for (int j = i; j < newArray.length; j++) {
                    newArray[j] = (Comparable<T>) arrayB[b];
                    b++;
                }
                return newArray;
            }
            if(b == arrayB.length){
                for (int j = i; j < newArray.length; j++) {
                    newArray[j] = arrayA[a];
                    a++;
                }
                return newArray;
            }
            if(arrayA[a].compareTo((T) arrayB[b]) < 0){
                newArray[i] = arrayA[a];
                a++;
            }else if(arrayA[a].compareTo((T) arrayB[b]) >= 0){
                newArray[i] = arrayB[b];
                b++;
            }
        }
        return newArray;
    }

    public static void main(String[] args) {
        String[] arrayA = {"a","c","g","z"};
        String[] arrayB = {"b","i"};
        String[] newArray = new String[arrayA.length+arrayB.length];
        String[] arrayC = (String[]) mergeArrays(newArray, arrayA, arrayB);
        for (int i = 0; i < arrayC.length; i++) {
            System.out.println(arrayC[i]);
        }
    }

    public static int[] mergeArrays(int[] arrayA, int[] arrayB){
        int[] newArray = new int[arrayA.length + arrayB.length];
        int a = 0, b = 0, i = 0;
        while (a < arrayA.length && b < arrayB.length){
            if (arrayA[a] < arrayB[b]){
                newArray[i] = arrayA[a];
                a++;
            } else {
                newArray[i] = arrayB[b];
                b++;
            }
            i++;
        }
        if (a == arrayA.length){
            for (int j = i; j < newArray.length; j++){
                newArray[j] = arrayB[b];
                b++;
            }
        } else {
            for (int j = i; j < newArray.length; j++) {
                newArray[j] = arrayB[a];
                a++;
            }
        }
        return newArray;
    }

}
