public class ComedyMovie extends Movie {


    private String name;
    private int price = 3;

    public void ComedyMovie(String name) {
        super(name);
    }
    public int getPrice() {
        return price;
    }
    @Override
    public String toString() {
        return name;
    }
    @Override
    public boolean equals(Object other) {
        if (this.toString() == other.toString()) {
            return true;
        } else {
            return false;
        }
    }
}
