package its.BlockPuzzle;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.BorderLayout;
import javax.swing.JFrame;

public class BlockPuzzleFrame extends JFrame {
    private DirectionPanel dirPanel;
    private BlockPuzzlePanel bpPanel;

    // Constructor
    public BlockPuzzleFrame(int rows, int cols) {

        this.setLocation(200, 200);
        this.setTitle("Block Puzzle Game");
        BoardModel boardMod = new BoardModel(rows, cols);
        bpPanel = new BlockPuzzlePanel(boardMod);
        dirPanel = new DirectionPanel();
        getContentPane().add(bpPanel, BorderLayout.CENTER);
        getContentPane().add(dirPanel, BorderLayout.EAST);

        BlockPuzzleListener bpList = new BlockPuzzleListener(bpPanel, dirPanel);
        bpPanel.addMouseListener(bpList);

        // Correct termination:
        // Otherwise only the frame disappears when clicking
        // on the ”close” symbol but the process keeps running.
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        pack();
    }

    public void showIt() {
        this.setVisible(true);
    }

    public void hideIt() {
        this.setVisible(false);
    }

}