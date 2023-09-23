package its.BlockPuzzle;

public class ConfigurationModel {
    private int[][] board;
    int noOfRows, noOfCols;

    public ConfigurationModel(int[][] b) {
        noOfRows = b.length;
        noOfCols = b[0].length;
        board = new int[noOfRows][noOfCols];
        for (int r = 0; r < noOfRows; r++) {
            for (int c = 0; c < noOfCols; c++) {
                board[r][c] = b[r][c];
            } // for r
        } // for c
    }

    public int getBlockNo(int r, int c) {
        return (board[r][c]);
    }

    public String toString() {
        String confAsString = "";
        for (int r = 0; r < noOfRows; r++) {
            for (int c = 0; c < noOfCols; c++) {
                if (board[r][c] < 10) {
                    confAsString += " " + board[r][c];
                } else {
                    confAsString += " " + board[r][c];
                } // ifelse
            } // for c
            confAsString += "\n";
        } // for r
        confAsString += "\n";
        return (confAsString);
    }

    public boolean equals(ConfigurationModel conf) {
        boolean result = true;
        for (int r = 0; r < noOfRows; r++) {
            for (int c = 0; c < noOfCols; c++) {
                if (this.board[r][c] != conf.board[r][c]) {
                    result = false;
                } // if
            } // for c
        } // for r
        return (result);
    }
}