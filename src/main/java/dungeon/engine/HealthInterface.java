package dungeon.engine;

public interface HealthInterface {
    int getHealth();
    int getMaxHealth();
    void damageHealth(int x);
    boolean isDead();
}
