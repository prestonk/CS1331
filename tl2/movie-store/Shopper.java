public class Shopper {

    public static void main(String[] args) {
        Cart cart = new Cart();
        cart.add(new ComedyMovie("Super Troopers"));
        System.out.printf("%-40s  %6s%n", "Movie", "Price");
        for (Movie movie: cart.getMovies()) {
            int price = movie.getPrice();
            System.out.printf("%-40s $%6d%n", movie, price);
        }
        System.out.printf("%-40s $%6d%n", "Total:", cart.totalPrice());
    }
}
