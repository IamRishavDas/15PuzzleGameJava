package its.BlockPuzzle;

public class BoardModel {
    private int noOfRows, noOfCols;
    private int[][] board; // The board as an array 6.
    private int[] rowOfBlock; // The number of the row of every block 7.
    private int[] colOfBlock; // The number of the column of every block 8.

    public BoardModel(int nr, int nc) {
        noOfRows = nr;
        noOfCols = nc;
        board = new int[noOfRows][noOfCols];
        rowOfBlock = new int[noOfRows * noOfCols];
        colOfBlock = new int[noOfRows * noOfCols];
        // initialize the board. The blocks are 16.
        // numbered row-wise 1,2,...
        int kk = 1;

        for (int r = 0; r < noOfRows; r++) {
            for (int c = 0; c < noOfCols; c++) {
                if (kk < noOfRows * noOfCols) {
                    board[r][c] = kk;
                    rowOfBlock[kk] = r;
                    colOfBlock[kk] = c;
                    kk++;
                }
            } // for c
        } // for r

        // ... and the missing block is at the lower right.
        board[noOfRows - 1][noOfCols - 1] = 0;
        rowOfBlock[0] = noOfRows - 1;
        colOfBlock[0] = noOfCols - 1;
    }

    public boolean moveIt(MoveModel mm) {
        int dir = mm.getDirection();
        int block = mm.getBlockNumber();
        int row = rowOfBlock[block];
        int col = colOfBlock[block];
        boolean ok = true;
        // an UP move is possible if the missing block

        // is above the position (r,c), i.e., at
        // (r-1,c). Esp. r has to be larger than 0.
        // The tests for the other directions are similar.
        if (dir == Constants.DIRECTION_UP) {
            if ((row > 0) && (board[row - 1][col] == 0)) {
                board[row - 1][col] = board[row][col];
                rowOfBlock[block]--;
                board[row][col] = 0;
                rowOfBlock[0]++;
            } else {
                ok = false;
            }
        } else if (dir == Constants.DIRECTION_DOWN) {
            if ((row < noOfRows - 1) && (board[row + 1][col] == 0)) {
                board[row + 1][col] = board[row][col];
                rowOfBlock[block]++;
                board[row][col] = 0;
                rowOfBlock[0]--;
            } else {
                ok = false;
            }
        } else if (dir == Constants.DIRECTION_LEFT) {
            if ((col > 0) && (board[row][col - 1] == 0)) {
                board[row][col - 1] = board[row][col];
                colOfBlock[block]--;
                board[row][col] = 0;
                colOfBlock[0]++;
            } else {
                ok = false;
            }
        } else if (dir == Constants.DIRECTION_RIGHT) {
            if ((col < noOfCols - 1) && (board[row][col + 1] == 0)) {
                board[row][col + 1] = board[row][col];
                colOfBlock[block]++;
                board[row][col] = 0;
                colOfBlock[0]--;
            } else {
                ok = false;
            }
        }
        return (ok);
    }

    public ConfigurationModel getCurrentConfiguration() {

        return (new ConfigurationModel(board));
    }

    public int getNoOfCols() {
        return (noOfCols);
    }

    public int getNoOfRows() {
        return (noOfRows);
    }
}