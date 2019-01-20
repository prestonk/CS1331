/**
* Makes it possible to make a TA
* @author Preston Knibbe
* @version 1
*/
public class TA extends UndergradStudent {
    public double piazzaScore;
    public double recitationScore;
    public double officeHoursScore;
    public boolean tester(double data) {
        if (data > 0 && data < 1) {
            return true;
        } else {
            return false;
        }
    }

    public TA(String fname, String lname, String username,
        double piazzaScore, double recitationScore,
        double officeHoursScore) {
        super(fname, lname, username);
        if (tester(piazzaScore) && tester(recitationScore)
            && tester(officeHoursScore)) {
            this.piazzaScore = piazzaScore;
            this.recitationScore = recitationScore;
            this.officeHoursScore = officeHoursScore;
        } else {
            throw new IllegalArgumentException();
        }
    }
    public double getPiazzaScore() {
        return piazzaScore;
    }
    public double getRecitaionScore() {
        return recitationScore;
    }
    public double getOfficeHoursScore() {
        return officeHoursScore;
    }
    public void setPiazzaScore(double piazzaScore) {
        if (tester(piazzaScore)) {
            this.piazzaScore = piazzaScore;
        } else {
            throw new IllegalArgumentException();
        }
    }
    public void setRecitationScore(double recitationScore) {
        if (tester(recitationScore)) {
            this.recitationScore = recitationScore;
        } else {
            throw new IllegalArgumentException();
        }
    }
    public void setOfficeHoursScore(double officeHoursScore) {
        if (tester(officeHoursScore)) {
            this.officeHoursScore = officeHoursScore;
        } else {
            throw new IllegalArgumentException();
        }
    }


}
