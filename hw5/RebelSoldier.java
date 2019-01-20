/**
 * This makes it possible to construct new Rebel Soldiers
 * @author Preston Knibbe
 * @version 1
 */
import java.util.Random;
public class RebelSoldier extends Soldier {
  /**
   * This method builds a Rebel Soldier
   * @param health Health status of the soldier
   * @param attack Damage dealt to opponents
   * @param defense The soldiers defense attribute
   * @param identifier The id of the Soldier
   */
    public RebelSoldier(double health, double attack,
        double defense, String identifier) {
        super(health, attack, defense, identifier);
    }

    public double attack(Soldier target) {
        Random rand = new Random();
        int randNum = rand.nextInt(101);
        double damage = this.getAttack();
        if (randNum < 81) {
            target.hurt(damage);
        }
        return damage;
    }

    public String getName() {
        return "Rebel Soldier " + getIdentifier();
    }
}
