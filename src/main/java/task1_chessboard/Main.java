package task1_chessboard;

public class Main {

    public static void main(String[] args) {
        int height,width;
        try {
            if (args.length==0) {
                System.out.println(ChessBoard.getRules());
                return;
            }
            else if (args.length==1){
                height=width=Integer.parseInt(args[0]);
            }
            else {
                height = Integer.parseInt(args[0]);
                width = Integer.parseInt(args[1]);
            }
            ChessBoard cb = new ChessBoard(height, width);
            System.out.println(cb.getBoard());
            System.out.println(cb.getBoard("░░", "▓▓"));
            System.out.println(cb.getBoardFromPairs('▀', '▄'));
        }
        catch(NumberFormatException e){
            System.err.println(ChessBoard.getRules());
        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
}
