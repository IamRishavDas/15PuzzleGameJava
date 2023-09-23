package its.BlockPuzzle;

public class MoveModel {

    private int direction;
    private int blockNumber;

    public MoveModel(int dir, int bn) {
        direction = dir;
        blockNumber = bn;
    }

    public int getBlockNumber() {
        return (blockNumber);
    }

    public int getDirection() {
        return (direction);
    }
}