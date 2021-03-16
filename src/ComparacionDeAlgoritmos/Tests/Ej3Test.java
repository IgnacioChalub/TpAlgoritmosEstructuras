package ComparacionDeAlgoritmos.Tests;

import ComparacionDeAlgoritmos.Ej3;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Ej3Test {
    @Test
    public void mergeArrays(){
        String[] arrayA = {"a","c","g","z"};
        String[] arrayB = {"b","i"};
        String[] outputArray = {"a","b","c","g","i","z"};
        String[] newArray = new String[arrayA.length+arrayB.length];
        String[] arrayC = (String[]) Ej3.mergeArrays(newArray,arrayA, arrayB);
        for (int i = 0; i < arrayC.length; i++) {
            assertEquals(outputArray[i], arrayC[i]);
        }
    }
}
