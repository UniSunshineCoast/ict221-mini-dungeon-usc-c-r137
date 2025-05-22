package dungeon.engine;

public class MutantMelee extends Enemy {
    private final int enemyLocationX;
    private final int enemyLocationY;

    public MutantMelee(int x, int y) {
        enemyLocationX = x;
        enemyLocationY = y;
    }

    public int getEnemyLocationY() {
        return enemyLocationY;
    }

    public int getEnemyLocationX() {
        return enemyLocationX;
    }

    public int getEnemyType() {
        return 1;
    }
}
