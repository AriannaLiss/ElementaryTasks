package task5_number_to_words.number_to_words;

public abstract class Number implements Word {

    private int number;
    private int rate;

    /**
     * class Number and his children works only with number>0
     */
    Number(int number,int rate){
        this.number = number;
        this.rate = rate;
    }

    private int cutNumber(int number, int rate) { return number % rate; }

    int getRateDigit(int number,int rate){
        return cutNumber(number,rate * 10)/rate;
    }
    int getUnit(int number){return cutNumber(number,10);}
    int getDecadeFigure(int number){return getRateDigit(number,100);}
    int getDecades(int number){return cutNumber(number,100);}

    int getRateDigit(){
        return getRateDigit(number,rate);
    }
    int getDecadeFigure(){return getDecadeFigure(number);}
    int getUnit(){ return getUnit(number); }
    int getDecades(){ return getDecades(number); }
    int getHundreds(){ return cutNumber(number,1000); }
    int getThousands(){ return cutNumber(number,1000000); }

    @Override
    public String toString(){
        return toString(Number.Sex.MALE);
    }
}
