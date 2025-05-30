package dungeon.engine;

public class Maps {

    private final int[][] mapValues;

    /**
     * Initializes the map walls into a 2d array.
     *
     */
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

    /**
     * The walls of the map.
     *
     * @return the walls, which is a 2d array.
     */
    public Object[] getMapVaules() {
        return this.mapValues;
    }
}
