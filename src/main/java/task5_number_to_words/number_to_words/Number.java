package task5_number_to_words.number_to_words;

abstract class Number {
    enum Gender {MALE, FEMALE}

    private final short number;

    /**
     * class Number and his children works only with number > 0
     */
    Number(short number) {
        this.number = number;
    }

    short getNumber() {
        return number;
    }

    byte getHundredFigure() {
        return (byte) ((number % 1000) / 100);
    }

    byte getDecadeFigure() {
        return (byte) ((number % 100) / 10);
    }

    byte getUnit() {
        return (byte) (number % 10);
    }

    @Override
    public String toString() {
        return toString(Gender.MALE);
    }

    abstract String toString(Gender gender);

    String combineWords(StringBuilder word1, String word2) {
        StringBuilder word = new StringBuilder(word1);
        if (!word2.isEmpty()) {
            if (word1.length() != 0) {
                word.append(Word.SPACE);
            }
            word.append(word2);
        }
        return word.toString();
    }
}
