public class BalletTicket {
    private String section;
    private int age;

    public BalletTicket(String section; int age) {
        if (section.equals("orchestra") || section.equals("mezzanine")) {
            this.section = section;
        } else {
            this.section = "orchestra";
            System.out.println("Incorrect ticket type, default = orchestra");
        }
        this.age = age;
    }
    public
}
