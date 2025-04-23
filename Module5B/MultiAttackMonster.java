import java.util.Random;

public class MultiAttackMonster implements Monster {
    private String name;
    private int health;
    private Weapon weapon;
    private int numberOfAttacks;
    private Random random;

    public MultiAttackMonster(String name, int health, Weapon weapon, int numberOfAttacks) {
        this.name = name;
        this.health = health;
        this.weapon = weapon;
        this.numberOfAttacks = numberOfAttacks;
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
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numberOfAttacks; i++) {
            int damage = random.nextInt(weapon.getMaxDamage()) + 1;
            other.takeDamage(damage);
            result.append(String.format("%s attacks %s with %s doing %d damage\n", 
                name, other.getName(), weapon.getName(), damage));
        }
        return result.toString();
    }
} 