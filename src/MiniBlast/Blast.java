package MiniBlast;

public class Blast {
    public static <T> double  BlastComparison(Comparable<T> referenceSequence[], Comparable<T> querySequence[]) {
        int coincidences = 0; //Counts the elements that match
        int changesRequired = 0; //Counts the ammounts of blocks of mismatches.
        boolean lastElementWasEqual = false;

        for (int i = 0; i < referenceSequence.length; i++) {
            if (referenceSequence[i].compareTo((T) querySequence[i]) == 0) {
                coincidences++;
                lastElementWasEqual = true;
            } else if (lastElementWasEqual) {
                changesRequired++;
                lastElementWasEqual = false;
            }
        }
        return ((double)coincidences/referenceSequence.length) * 100;
    }

    public static void main(String[] args) {
        String[] ref = {"baa", "a", "asd","qqqq","dasaf","ssg"};
        String[] qry = {"aaa", "a", "asd","qqqq","das","sgsfg"};
        String[]ref2 = {"baa", "a", "asds","qqqq","sf","sgsfg"};

        System.out.println("Coincidence Percentaje 1 : "+BlastComparison(ref,qry) + "%");
        System.out.println("Coincidence Percentaje 2: "+BlastComparison(ref2,qry) + "%");

    }
}
