package its.BlockPuzzle;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

import javax.swing.JOptionPane;

public class BlockPuzzlePanel extends JPanel {

    private BoardModel boardMod;
    private ConfigurationModel currentConf;
    private int noOfRows, noOfCols;
    private int columnWidth, rowHeight;

    public BlockPuzzlePanel(BoardModel bm) {
        boardMod = bm;
        noOfRows = bm.getNoOfRows();
        noOfCols = bm.getNoOfCols();
        this.setPreferredSize(new Dimension(300, 300));
        this.setBackground(Color.white);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int w = getWidth();
        int h = getHeight();
        columnWidth = w / noOfCols;
        rowHeight = h / noOfRows;
        currentConf = boardMod.getCurrentConfiguration();
        for (int r = 0; r < noOfRows; r++) {
            for (int c = 0; c < noOfCols; c++) {
                if (currentConf.getBlockNo(r, c) != 0) {
                    drawBlock(r, c, currentConf.getBlockNo(r, c), g);
                } else {
                    drawMissingBlock(r, c, g);
                }
            } // for c
        } // for r
    }

    public void makeMove(MoveModel move) {
        if (boardMod.moveIt(move)) {
            this.repaint();
        } else {
            JOptionPane.showMessageDialog(this,
                    "U Dumb its Illegal Move", "BlockPuzzle Game",
                    JOptionPane.WARNING_MESSAGE);
        } // ifelse

    }

    private void drawBlock(int r, int c, int n, Graphics g) {
        g.drawRect(c * columnWidth + 2, r * rowHeight + 2, columnWidth - 4,
                rowHeight - 4);
        g.drawString("" + n, c * columnWidth + (columnWidth / 2),
                r * rowHeight + rowHeight / 2);
    }

    private void drawMissingBlock(int r, int c, Graphics g) {
        g.fillRect(c * columnWidth, r * rowHeight, columnWidth, rowHeight);
    }

    public int getBlockNoAtPixels(int x, int y) {
        int c = x / (this.getWidth() / noOfCols);
        int r = y / (this.getHeight() / noOfRows);
        return (currentConf.getBlockNo(r, c));
    }
}