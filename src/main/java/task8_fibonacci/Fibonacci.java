package task8_fibonacci;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {
    private List<Integer> fibonacciRow = new ArrayList<>();

    Fibonacci(){
        init(0,1);
    }

    private int init (int firstNumber, int secondNumber){
        init();
        fibonacciRow.add(firstNumber);
        fibonacciRow.add(secondNumber);
        return firstNumber+secondNumber;
    }

    //only one number could be in the row
    private int init (int number){
        init();
        fibonacciRow.add(number);
        return 0;
    }

    //no numbers in the row
    private int init(){
        fibonacciRow.clear();
        return 0;
    }

    //fibonacci should has at least two numbers!
    private int getNextNumber(){
        return fibonacciRow.get(fibonacciRow.size()-1)+fibonacciRow.get(fibonacciRow.size()-2);
    }

    //make fibonacci with first two numbers greater or equal value from
    //returns third fibonacci number or 0 if there are only 1 or no numbers in the row
    private int startFibonacci(int from) {
        if (from == 0) {
            return init(0, 1);
        }
        if (from == 1) {
            return init(1, 1);
        }
        int f0 = 0;
        int f1 = 1;
        int f = f0 + f1;
        while ((f < from)&&(f>0)) {
            f = f0 + f1;
            f0 = f1;
            f1 = f;
        }
        if (f<0){
            return init();
        }
        int f2 = f + f0;
        if (f2<0){
            return init (f);
        }
        return init(f, f2);
    }

    //from>=0 and to>=0
    //from and to < 1000000000
    public List<Integer> getFibonacciRow(int from, int to){
        if (from>to){
            int buf = from;
            from=to;
            to=buf;
        }
        int f = startFibonacci(from);
        if ((fibonacciRow.size()>1)&&(to>0)) {
            while ((f <= to)&&(f>0)) {
                fibonacciRow.add(f);
                f = getNextNumber();
            }
        }
        //remove if 'to' less then last numbers in the row
        removeExtra(to);
        return fibonacciRow;
    }

    private void removeExtra(int higherBound){
        while ((fibonacciRow.size()>0)&&(fibonacciRow.get(fibonacciRow.size()-1)>higherBound)){
            fibonacciRow.remove(fibonacciRow.size()-1);
        }
    }

    //Requirements: (countOfDigits>0)&&(countOfDigits<10)
    //return fibonacci row with numbers witch have countOfDigits digits
    public List<Integer> getFibonacciRow(int countOfDigits){
        int from=0,to=9;
        if(countOfDigits>1){
            from = (int)Math.pow(10,countOfDigits - 1);
            to = from*10-1;
        }
        return getFibonacciRow(from, to);
    }

    @Override
    public String toString() {
        return fibonacciRow.toString();
    }
}
