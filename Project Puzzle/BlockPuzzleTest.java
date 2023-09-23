package its.BlockPuzzle;

public class BlockPuzzleTest {

    private static boolean passed;

    public static void main(String[] args) {

        passed = true;
        // Generate a model and print it (also as string)
        BoardModel bm = new BoardModel(4, 4);
        ConfigurationModel trueConf, expectedConf;
        trueConf = bm.getCurrentConfiguration();
        expectedConf = new ConfigurationModel(
                new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 0 } });
        check(expectedConf, expectedConf);

        // Make a move
        System.out.println("Move 15 right");
        MoveModel move1 = new MoveModel(Constants.DIRECTION_RIGHT, 15);
        if (!bm.moveIt(move1)) {
            System.out.println("Illegal Move!");
        }
        trueConf = bm.getCurrentConfiguration();
        expectedConf = new ConfigurationModel(
                new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 0, 15 } });
        check(expectedConf, expectedConf);

        // Make another move
        System.out.println("Move 5 up");
        MoveModel move2 = new MoveModel(Constants.DIRECTION_UP, 5);
        if (!bm.moveIt(move2)) {
            System.out.println("Illegal Move!");
        }
        trueConf = bm.getCurrentConfiguration();
        expectedConf = new ConfigurationModel(
                new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 0, 15 } });
        check(expectedConf, expectedConf);
        // display the test result
        if (passed) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test NOT passed");
        }
    }

    private static void check(ConfigurationModel conf1,
            ConfigurationModel conf2) {
        if (conf1.equals(conf2)) {
            System.out.println("Configuration ok:");
            System.out.println(conf1.toString());
        } else {
            System.out.println("Expected and true configurations"
                    + "do NOT match");

            System.out.println(conf2.toString());
            System.out.println(conf1.toString());
            passed = false;
        }
    }
}