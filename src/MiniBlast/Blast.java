package MiniBlast;

public class Blast {
    public static double  blastComparison(char[] referenceSequence, char[] querySequence) {
        int coincidences = 0; //Counts the elements that match
        for (int i = 0; i < referenceSequence.length; i++) {
            if(referenceSequence[i] == querySequence[i]){
                coincidences++;
            }
        }
        return ((double)coincidences/referenceSequence.length) * 100;
    }

    public static double  blastComparisonPonderation(char[] referenceSequence, char[] querySequence) {
        int coincidences = 0; //Counts the elements that match
        int changesRequired = 0; //Counts the ammount of blocks of mismatches.
        boolean lastElementWasEqual = true;

        //char[] qry = {'a', 'g', 'c','t','t','t'};
        //char[] ref = {'u', 'g', 'g','t','a','t'};
        for (int i = 0; i < referenceSequence.length; i++) {
            if (referenceSequence[i] == querySequence[i]){
                coincidences++;
                lastElementWasEqual = true;
            } else if (lastElementWasEqual) {
                changesRequired++;
                lastElementWasEqual = false;
            }
        }
        if(coincidences == 0){
            return 0;
        }
        return (((double)coincidences/referenceSequence.length) * 0.8 + (1 - (double)changesRequired/((double)referenceSequence.length/2)) * 0.2) * 100;
    }
}
