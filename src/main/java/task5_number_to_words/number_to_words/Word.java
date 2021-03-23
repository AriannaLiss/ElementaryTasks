package task5_number_to_words.number_to_words;

public interface Word {
    enum Sex {MALE, FEMALE}
    String EMPTY_STRING = "";
    String SPACE = " ";
    String _A = "а";

    String toString(Sex sex);

    default String combineWords(String word1, String word2){
        StringBuilder word = new StringBuilder(word1);
        if (!word2.equals(EMPTY_STRING)){
            if (!word1.equals(EMPTY_STRING)){
                word.append(SPACE);
            }
            word.append(word2);
        }
        return word.toString();
    }

    default String combineWords(StringBuilder word1, String word2){
        return combineWords(word1.toString(),word2);
    }
}
