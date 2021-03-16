package MiniBlast;

public class Blast {
    public static double blastComparison(char[] referenceSequence, char[] querySequence) {
        int coincidences = 0; //Counts the elements that match
        for (int i = 0; i < referenceSequence.length; i++) {
            if(referenceSequence[i] == querySequence[i]){
                coincidences++;
            }
        }
        return ((double)coincidences/referenceSequence.length) * 100;
    }

    public static double blastComparisonPonderation(char[] referenceSequence, char[] querySequence) {
        int coincidences = 0; //Counts the elements that match
        int changesRequired = 0; //Counts the ammounts of blocks of mismatches.
        boolean lastElementWasEqual = false;

        for (int i = 0; i < referenceSequence.length; i++) {
            if (referenceSequence[i] == querySequence[i]){
                coincidences++;
                lastElementWasEqual = true;
            } else if (lastElementWasEqual) {
                changesRequired++;
                lastElementWasEqual = false;
            }
        }
        return (((double)coincidences/referenceSequence.length) * 0.8 + (1 - (double)changesRequired/referenceSequence.length) * 0.2) * 100;
    }

}
