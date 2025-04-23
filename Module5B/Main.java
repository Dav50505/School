import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Create weapons
        Weapon sword = new Weapon("Sword", 15);
        Weapon axe = new Weapon("Axe", 20);
        Weapon staff = new Weapon("Staff", 10);

        // Create monsters
        ArrayList<Monster> monsters = new ArrayList<>();
        monsters.add(new BasicMonster("Goblin", 100, sword));
        monsters.add(new MultiAttackMonster("Dragon", 150, axe, 3));
        monsters.add(new CrazyMonster(120));

        Random random = new Random();
        
        // Battle loop
        while (getAliveMonstersCount(monsters) > 1) {
            for (Monster attacker : monsters) {
                if (attacker.getHealth() <= 0) continue;
                
                // Find a random alive monster to attack (excluding self)
                Monster target;
                do {
                    target = monsters.get(random.nextInt(monsters.size()));
                } while (target == attacker || target.getHealth() <= 0);
                
                // Perform attack
                System.out.print(attacker.attack(target));
            }
        }

        // Announce winner
        Monster winner = getWinner(monsters);
        if (winner != null) {
            System.out.println("\nThe winner is " + winner.getName() + " with " + winner.getHealth() + " health remaining!");
        } else {
            System.out.println("\nIt's a draw! All monsters have fallen!");
        }
    }

    private static int getAliveMonstersCount(ArrayList<Monster> monsters) {
        int count = 0;
        for (Monster monster : monsters) {
            if (monster.getHealth() > 0) count++;
        }
        return count;
    }

    private static Monster getWinner(ArrayList<Monster> monsters) {
        for (Monster monster : monsters) {
            if (monster.getHealth() > 0) return monster;
        }
        return null;
    }
}
