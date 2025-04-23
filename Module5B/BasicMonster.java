import java.util.Random;

public class BasicMonster implements Monster {
    private String name;
    private int health;
    private Weapon weapon;
    private Random random;

    public BasicMonster(String name, int health, Weapon weapon) {
        this.name = name;
        this.health = health;
        this.weapon = weapon;
        this.random = new Random();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public void takeDamage(int damage) {
        health -= damage;
    }

    @Override
    public String attack(Monster other) {
        int damage = random.nextInt(weapon.getMaxDamage()) + 1;
        other.takeDamage(damage);
        return String.format("%s attacks %s with %s doing %d damage\n", 
            name, other.getName(), weapon.getName(), damage);
    }
} 