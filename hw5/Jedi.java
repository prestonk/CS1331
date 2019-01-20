/**
 * This makes it possible to create a Jedi soldier
 * @author Preston Knibbe
 * @version 1
 */
public class Jedi extends Soldier implements ForceSensitive {
  /**
   * This method builds a Jedi Soldier
   * @param health Health status of the soldier
   * @param attack Damage dealt to opponents
   * @param defense The soldiers defense attribute
   * @param identifier The id of the Soldier
   */
    public Jedi(double health, double attack,
        double defense, String identifier) {
        super(health, attack, defense, identifier);
    }
    private double power = this.getDefense() * 0.25;
    private int usedForce = 0;
    public void useTheForce() {
        this.heal(power * 0.25);
        this.changeDefense(power);
        usedForce += 1;
    }
    /**
     * This method determines how much damage to deal and if attack is
     * successful.
     * @param target The student to be delt damage.
     */
    @Override
    public double attack(Soldier target) {
        double damage = this.getAttack();
        target.hurt(damage);
        if (usedForce == 1) {
            this.changeDefense(-1 * power);
            usedForce -= 1;
        }
        return damage;
    }
    public String getName() {
        return "Jedi " + getIdentifier();
    }

}
