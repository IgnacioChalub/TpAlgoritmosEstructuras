package MiniBlast;


import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BlastTest {

    @Test
    public void blastComparison(){
        char[] qry = {'a', 'g', 'c','t','t','t'};
        char[] ref = {'u', 'g', 'g','t','a','t'};
        char[]ref2 = {'a', 'a', 'g','t','t','t'};

        assertEquals(50.0,Blast.blastComparison(qry, ref),1e-15);
        assertEquals(((double)4/6)*100,Blast.blastComparison(qry, ref2),1e-15);
    }

    @Test
    public void blastComparisonPonderation(){
        char[] qry = {'a', 'g', 'c','t','t','t'};
        char[] ref = {'u', 'g', 'g','t','a','t'};
        char[] ref2 = {'a', 'a', 'g','t','t','a'};
        char[] ref3 = {'a', 'g', 'c','t','t','t'};

        assertEquals(40.0,Blast.blastComparisonPonderation(qry, ref),1e-15);
        assertEquals((double)140/3,Blast.blastComparisonPonderation(qry, ref2),1e-15);
        assertEquals(100.0,Blast.blastComparisonPonderation(qry, ref3),1e-15);
    }
}
