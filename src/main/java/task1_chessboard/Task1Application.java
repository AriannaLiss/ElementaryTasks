package task1_chessboard;

import general.*;


public class Task1Application implements Application {
    static private final String WELCOME_MSG =
            "This application print chess board with your parameters width and height.\n";
    static private final String RULES = "Set height and width for chess board.\nExample: 6 5\n";
    static private final String MODE = "Modes:\n"+
            "1 : *  \n2 : ░░▓▓\n3 : ▀▄\n0 : your symbols\n"+
            "Please, choose mode: ";
    static private final String SET = "Please, set ";
    static private final String HEIGHT = "height: ";
    static private final String WIDTH = "width: ";
    static private final String BLACK = "symbols for black fields: ";
    static private final String WHITE = "symbols for white fields: ";

    private InputOutput io;
    private NumberValidator validator;
    private Dialog dialog;

    public Task1Application(InputOutput io){
        this.io = io;
        validator = new IntegerValidator();
        dialog = new Dialog(io, validator);
    }

    public void run(){
        do{
            int width = dialog.getNotZeroPositiveNumber(SET+WIDTH).intValue();
            int height = dialog.getNotZeroPositiveNumber(SET+HEIGHT).intValue();
            ChessBoard cb = new ChessBoard(height,width);
            int mode = dialog.getNumberInRange(MODE,0,3).intValue();
            switch (mode){
                case 1:
                    dialog.print(cb.getBoard()); break;
                case 2:
                    dialog.print(cb.getBoard("░░", "▓▓")); break;
                case 3:
                    dialog.print(cb.getBoardFromPairs('▀', '▄')); break;
                case 0:
                    dialog.print(customChessBoard(cb));
            }
        }
        while(dialog.yesNo());
    }

    private String customChessBoard(ChessBoard cb){
        String black, white;
        black = dialog.getLine(SET+BLACK);
        white = dialog.getLine(SET+WHITE);
        return cb.getBoard(black,white);
    }

    public void run(String... args) {
        int height, width;
        try {
            if (args.length == 0) {
                io.print(RULES);
                return;
            } else if (args.length == 1) {
                height = width = Integer.parseInt(args[0]);
            } else {
                height = Integer.parseInt(args[0]);
                width = Integer.parseInt(args[1]);
            }
            ChessBoard cb = new ChessBoard(height, width);
            io.print(cb.getBoard() + "\n");
            io.print(cb.getBoard("░░", "▓▓") + "\n");
            io.print(cb.getBoardFromPairs('▀', '▄') + "\n");
        }
        catch(NumberFormatException e){
            System.err.println(RULES);
        }
    }
}