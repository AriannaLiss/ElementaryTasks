package task5_number_to_words.number_to_words;

//only number>0
public class Unit {
    //long number;
/*    enum Sex {MALE, FEMALE}
    private Sex sex = Sex.FEMALE;
*/
    public static int getUnit(long number){
        return (int)(number % 10);
    }
/*
    public static String unitToWord(long number){
        return unitToWord(number,Sex.MALE);
    }
*/
    public static String toString(long number){
        String word="";
        int unit = getUnit(number);
        switch (unit) {
            case 0:
                word = "";//(this.number != 0) ? "" : "ноль";
                break;
            case 1:
                word = "один";// (sex==Sex.MALE) ? "один" : "одна";
                break;
            case 2:
                word = "два";// (sex==Sex.MALE) ? "два" : "две";
                break;
            case 3:
                word = "три";
                break;
            case 4:
                word = "четыре";
                break;
            case 5:
                word = "пять";
                break;
            case 6:
                word = "шесть";
                break;
            case 7:
                word = "семь";
                break;
            case 8:
                word = "восемь";
                break;
            case 9:
                word = "девять";
                break;
        }
        return word;
    }
/*
    Unit(long number){
        if (number<0) { number = -number; }
        this.number = number;
        resetSex();
    }

    public int getUnit(){
        return getUnit(number);
    }

    void setFemaleSex(){
        sex = Sex.FEMALE;
    }

    void resetSex(){
        sex = Sex.MALE;
    }

    public Sex getSex(){
        return sex;
    }
*/

    /*public String unitToWord(){
        return unitToWord(number, sex);
    }*/


}
