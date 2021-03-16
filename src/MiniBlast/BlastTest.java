package MiniBlast;

import MiniBlast.Blast;
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

}
