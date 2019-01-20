/**
 * This makes it possible to create a new Sith lord
 * @author Preston Knibbe
 * @version 1
 */
public class Sith extends Soldier implements ForceSensitive {
  /**
   * This method builds a Sith lord
   * @param health Health status of the soldier
   * @param attack Damage dealt to opponents
   * @param defense The soldiers defense attribute
   * @param identifier The id of the Soldier
   */
    public Sith(double health, double attack,
        double defense, String identifier) {
        super(health, attack, defense, identifier);
    }
    private double power = this.getDefense() / 6.0;
    private int usedForce = 0;
    public void useTheForce() {
        this.hurt(power / 10.0);
        this.changeAttack(power);
        usedForce += 1;
    }
    public double attack(Soldier target) {
        double damage = this.getAttack();
        target.hurt(damage);
        if (usedForce == 1) {
            this.changeAttack(-1 * power);
            usedForce -= 1;
        }
        return damage;
    }
    public String getName() {
        return "Sith " + getIdentifier();
    }

}
