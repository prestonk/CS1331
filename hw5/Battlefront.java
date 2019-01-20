import java.util.Scanner;
/**
 * This sets the battlefield for the simulation and determines the sizes
 * and variation of troops in the armies based on user input.
 * @author Preston Knibbe
 * @version 1
 */
public class Battlefront {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("+-------------------------------------------+");
        System.out.println("| Welcome to the Battlefront1331 Simulator! |");
        System.out.println("+-------------------------------------------+");
        System.out.println("How many Rebel Soldiers?");
        int rebels = input.nextInt() + 1;
        System.out.println("How many Jedi?");
        int jedi = input.nextInt() + 1;
        System.out.println("How many Storm Troopers?");
        int storm = input.nextInt() + 1;
        System.out.println("How many Sith?");
        int sith = input.nextInt() + 1;
        Trooper avgTroop = new Trooper(100.0, 20.0, 50.0, "AA-00");
        Rebel avgRebel = new Rebel(100.0, 20.0, 60.0, "BB-00");
        Simulation battle = new Simulation(rebels, jedi, storm, sith,
            avgRebel, avgTroop);

        System.out.println("Press Enter to begin the simulation");
        String keyPress = input.nextLine();
        boolean condition = battle.simulateSkirmish(false);
        while (condition) {
            System.out.println("Press Enter to continue simulation");
            input.nextLine();
            condition = battle.simulateSkirmish(false);
        }
        System.out.println("Simulation Complete");
        if ((battle.getNumRebellionRemaining() == 0)
            || (battle.getNumEmpireRemaining()
            > battle.getNumRebellionRemaining())) {
            System.out.println("The Empire Won");
        } else {
            System.out.println("The Rebelion Won");
        }
        System.out.println(battle.getNumRebelsRemaining() + " of "
            + rebels + " Rebel Soldiers remain!");
        System.out.println(battle.getNumJediRemaining() + " of "
            + jedi + " Jedi ramain!");
        System.out.println(battle.getNumTroopersRemaining() + " of "
            + storm + " Stormtroopers remain!");
        System.out.println(battle.getNumSithRemaining() + " of "
            + sith + " Sith remain!");
    }

}
