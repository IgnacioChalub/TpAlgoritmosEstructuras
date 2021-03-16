package ComparacionDeAlgoritmos.Tests;


import ComparacionDeAlgoritmos.Ej1;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Ej1Test {
    @Test
    public void binarySearch() {
        assertEquals(4, Ej1.binarySearch(new Integer[]{1, 2, 4, 6, 9, 10, 10}, 9));
        assertEquals(2, Ej1.binarySearch(new String[]{"abc", "df", "ghi", "jk", "lm"}, "ghi"));
        assertEquals(-1, Ej1.binarySearch(new Integer[]{1, 2, 4, 6, 9, 10, 10}, 3));

    }

    @Test
    public void seqSearch(){
        assertEquals(4,Ej1.seqSearch(new Integer[] {1, 2, 4, 6, 9, 10, 10},9));
        assertEquals(2,Ej1.seqSearch(new String[] {"abc","df","ghi","jk","lm"},"ghi"));
        assertEquals(-1, Ej1.seqSearch(new Integer[]{1, 2, 4, 6, 9, 10, 10}, 3));
    }
}
