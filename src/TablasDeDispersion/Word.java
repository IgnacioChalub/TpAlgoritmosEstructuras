package TablasDeDispersion;

public class Word implements Hashable{
    String word;
    String hash;

    public Word(String word) {
        this.word = word;
    }

    private static String getCode(char c){
        switch(c){
            case 'B': case 'F': case 'P': case 'V':
                return "1";
            case 'C': case 'G': case 'J': case 'K':
            case 'Q': case 'S': case 'X': case 'Z':
                return "2";
            case 'D': case 'T':
                return "3";
            case 'L':
                return "4";
            case 'M': case 'N':
                return "5";
            case 'R':
                return "6";
            default:
                return "";
        }
    }

    @Override
    public int hash(int M){
        String code, previous, soundex;
        code = word.toUpperCase().charAt(0) + "";
        previous = "7";
        for(int i = 1;i < word.length();i++){
            String current = getCode(word.toUpperCase().charAt(i));
            if(current.length() > 0 && !current.equals(previous)){
                code = code + current;
            }
            previous = current;
        }
        soundex = (code + "0000").substring(0, 4);
        Integer value = Integer.parseInt(soundex);
        return (int) value;
    }
}
