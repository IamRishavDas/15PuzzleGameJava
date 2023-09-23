package its.BlockPuzzle;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BlockPuzzleListener extends MouseAdapter {
    private DirectionPanel dirPanel;

    private BlockPuzzlePanel bpPanel;

    BlockPuzzleListener(BlockPuzzlePanel bp, DirectionPanel m) {
        dirPanel = m;
        bpPanel = bp;
    }

    public void mouseClicked(MouseEvent evt) {
        //
        int x = evt.getX();
        int y = evt.getY();
        int blockNo = bpPanel.getBlockNoAtPixels(x, y);
        // Constructs the move
        MoveModel move = new MoveModel(dirPanel.getDirection(), blockNo);
        // Request a move to made be in the BlockPuzzlePanel.
        // Note that the BlockPuzzleListener does not know HOW to make
        // a move.
        bpPanel.makeMove(move);
    }

}