package task5_number_to_words.number_to_words;

public interface Word {
    String MINUS = "минус ";
    String ZERO = "ноль";
    String ILLION = "иллион";
    String[] START_SYMBOLS = {
            "м", "б", "тр", "квадр", "квинт", "секст", "септ", "окт", "нон", "дец"
    };
    String[] START_OVER_36_POW = {
            "ун", "дуо", "тре", "кваттор", "квин", "секс", "септ", "окто", "новем"
    };
    String VIGINT = "вигинт";
    String THOUSANDS = "тысяч";
    String _I = "и";
    String _OV = "ов";
    String _A = "а";

    String EMPTY_STRING = "";
    String SPACE = " ";
}
