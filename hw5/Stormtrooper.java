/**
 * This makes it possible to create a Stromtrooper
 * @author Preston Knibbe
 * @version 1
 */
import java.util.Random;
public class Stormtrooper extends Soldier {
  /**
   * This method builds a new Stormtrooper
   * @param health Health status of the soldier
   * @param attack Damage dealt to opponents
   * @param defense The soldiers defense attribute
   * @param identifier The id of the Soldier
   */
    public Stormtrooper(double health, double attack,
        double defense, String identifier) {
        super(health, attack, defense, identifier);
    }

    public double attack(Soldier target) {
        Random rand = new Random();
        int randNum = rand.nextInt(101);
        double damage = this.getAttack();
        if (randNum < 61) {
            damage += (damage * 0.25);
            target.hurt(damage);
        }
        return damage;
    }

    public String getName() {
        return "Stormtrooper " + getIdentifier();
    }
}
