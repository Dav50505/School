import java.util.Random;

public class CrazyMonster implements Monster {
    private int health;
    private int attackStrength;
    private int damageCount;
    private Random random;
    private static final char[] SYMBOLS = {'!', '@', '#', '$', '%', '^', '&', '*', '?'};

    public CrazyMonster(int health) {
        this.health = health;
        this.attackStrength = 1;
        this.damageCount = 0;
        this.random = new Random();
    }

    @Override
    public String getName() {
        StringBuilder name = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            name.append(SYMBOLS[random.nextInt(SYMBOLS.length)]);
        }
        return name.toString();
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public void takeDamage(int damage) {
        health -= damage;
        damageCount++;
        if (damageCount % 2 == 0) {
            attackStrength += damage;
        }
    }

    @Override
    public String attack(Monster other) {
        int damage = random.nextInt(attackStrength) + 1;
        other.takeDamage(damage);
        return String.format("%s attacks %s doing %d damage\n", 
            getName(), other.getName(), damage);
    }
} 