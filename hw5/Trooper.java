/**
 * This is the typical Stormtrooper
 * @author Preston Knibbe
 * @version 1
 */
public class Trooper extends Stormtrooper {
  /**
   * This method builds the typical Stormtrooper
   * @param health Health status of the soldier
   * @param attack Damage dealt to opponents
   * @param defense The soldiers defense attribute
   * @param identifier The id of the Soldier
   */
    public Trooper(double health, double attack, double defense,
        String identifier) {
        super(health, attack, defense, identifier);
    }
    public double attack(Soldier target) {
        this.hurt(this.getAttack());
        return this.getAttack();
    }
    public String getName() {
        return "Trooper " + getIdentifier();
    }
}
