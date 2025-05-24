package dungeon.engine;

public class HealthPotion {
    private final int healAmount = 4;
    private final int healthLocationX;
    private final int healthLocationY;

    public HealthPotion(int x, int y) {
        healthLocationX = x;
        healthLocationY = y;
    }

    public int getHealAmount() {
        return healAmount;
    }

    public int getHealthLocationX() {
        return healthLocationX;
    }

    public int getHealthLocationY() {
        return healthLocationY;
    }
}
