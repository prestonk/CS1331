public class ScifiMovie extends Movie {

    private String name;
    private int price = 5;

    public void ScifiMovie(String name) {
        this.name = name;
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
