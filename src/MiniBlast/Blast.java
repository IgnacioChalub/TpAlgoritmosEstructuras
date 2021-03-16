package MiniBlast;

public class Blast {
    public static double  BlastComparison(char[] referenceSequence, char[] querySequence) {
        int coincidences = 0; //Counts the elements that match
        for (int i = 0; i < referenceSequence.length; i++) {
            if(referenceSequence[i] == querySequence[i]){
                coincidences++;
            }
        }
        return ((double)coincidences/referenceSequence.length) * 100;
    }

    public static double  BlastComparisonPonderation(char[] referenceSequence, char[] querySequence) {
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

    public static void main(String[] args) {
        char[] qry = {'a', 'g', 'c','t','t','t'};
        char[] ref = {'u', 'g', 'g','t','a','t'};
        char[]ref2 = {'c', 'a', 'g','t','t','t'};


        System.out.println("Coincidence Percentage 1 : "+BlastComparison(ref,qry) + "%");
        System.out.println("Coincidence Percentage 2: "+BlastComparison(ref2,qry) + "%");

        System.out.println("Coincidence Percentage 1 : "+BlastComparisonPonderation(ref,qry) + "%");
        System.out.println("Coincidence Percentage 2 : "+BlastComparisonPonderation(ref,qry) + "%");

    }
}
