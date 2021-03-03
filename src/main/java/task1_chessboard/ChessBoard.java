package task1_chessboard;

/** Task 1 Chess Board

 Print chess board with parameters height and width.

 Example:
 *  *  *  *  *  *
   *  *  *  *  *  *
 *  *  *  *  *  *
   *  *  *  *  *  *

 For running program you should run main class with parameters.
 */

public class ChessBoard {
    static private final String rules = "Set height and width for chess board.\nExample: java Main 6 5";
    private final int height, width;

    ChessBoard(int height, int width) {
        if ((width <= 0) || (height <= 0)) {
            throw new IllegalArgumentException("Width and height should be positive and don't equal zero.");
        }
        this.height = height;
        this.width = width;
    }

    public static String getRules() {
        return rules;
    }

    public String getBoard() {
        return getBoard("*", "  ");
    }

    public String getBoard(String black, String white) {
        StringBuilder[] row = new StringBuilder[2];
        row[0] = new StringBuilder();
        row[1] = new StringBuilder();
        for (int i = 0; i < width; i++) {
            row[(i + 1) % 2].append(white);
            row[i % 2].append(black);
        }
        StringBuilder board = new StringBuilder();
        for (int j = 0; j < height; j++) {
            board.append(row[j % 2]).append("\n");
        }
        return board.toString();
    }

    public String getBoardFromPairs(char top, char bottom) {
        StringBuilder row = new StringBuilder();
        StringBuilder rowEnd = new StringBuilder();
        for (int i = 0; i < width; i++) {
            if (i % 2 == 0) {
                row.append(top);
                rowEnd.append(top);
            } else {
                row.append(bottom);
                rowEnd.append(' ');
            }
        }
        String board = (row + "\n").repeat(height / 2);
        if (height % 2 != 0) {
            board = board + rowEnd;
        }
        return board;
    }
}
