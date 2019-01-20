/**
 * This is the typical Rebel Soldier
 * @author Preston Knibbe
 * @version 1
 */
public class Rebel extends RebelSoldier {
  /**
   * This method builds a typical Rebel Soldier
   * @param health Health status of the soldier
   * @param attack Damage dealt to opponents
   * @param defense The soldiers defense attribute
   * @param identifier The id of the Soldier
   */
    public Rebel(double health, double attack, double defense,
        String identifier) {
        super(health, attack, defense, identifier);
    }
    public double attack(Soldier target) {
        this.hurt(this.getAttack());
        return this.getAttack();
    }
    public String getName() {
        return "Rebel" + getIdentifier();
    }
}
