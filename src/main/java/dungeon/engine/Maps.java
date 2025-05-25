package dungeon.engine;

public class Maps {

    private final int[][] mapValues;

    public Maps() {
        mapValues = new int[][] {
                {0, 1, 1, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 1, 0, 1, 1},
                {0, 1, 0, 1, 1, 0, 1, 0, 0, 0},
                {0, 1, 0, 1, 1, 0, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 0, 1, 1},
                {0, 0, 1, 1, 0, 1, 1, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 1, 1, 1, 1},
                {1, 0, 0, 0, 1, 0, 1, 0, 0, 0},
                {1, 0, 1, 0, 1, 0, 0, 0, 1, 0},
                {0, 0, 1, 0, 1, 0, 1, 0, 1, 0},
                {1, 0, 0, 1, 0, 0, 1, 0, 0, 1}
        };
    }

    public Object[] getMapVaules() {
        return this.mapValues;
    }
}
