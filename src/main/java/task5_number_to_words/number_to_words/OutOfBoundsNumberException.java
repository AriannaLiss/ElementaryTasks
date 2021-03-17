package task5_number_to_words.number_to_words;

public class OutOfBoundsNumberException extends RuntimeException {
    OutOfBoundsNumberException(){
        super("Application works with numbers < 10^66.\n");
    }

    OutOfBoundsNumberException(String msg){
        super(msg);
    }
}
