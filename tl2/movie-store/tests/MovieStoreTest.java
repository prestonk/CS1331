import edu.gatech.cs1331.annotations.*;
import static edu.gatech.cs1331.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.*;

public class MovieStoreTest {

    @Test(points=5)
    public void movieIsAbstract() {
        assertTrue("Movie is not abstract",
                   Modifier.isAbstract(Movie.class.getModifiers()));
    }

    @Test(points=5)
    public void movieGetPriceMethod() {
        try {
            assertTrue("Movie's getPrice method is not abstract",
                       Modifier.isAbstract(Movie.class.getMethod("getPrice")
                       .getModifiers()));
        } catch (NoSuchMethodException e) {
            fail("Movie does not have a getPrice method");
        }
    }

    @Test(points=5)
    public void movieOverridesToString() {
        Movie testMovie = new Movie("Caddyshack") {
                public int getPrice() { return 1; }
            };
        assertEquals("Movie does not correctly override toString",
                     "Caddyshack", testMovie.toString());
    }

    @Test(points=10)
    public void movieOverridesEquals() {
        Movie testMovie1 = new Movie("Caddyshack") {
                public int getPrice() { return 1; }
            };
        Movie testMovie2 = new Movie("Caddyshack") {
                public int getPrice() { return 2; }
            };

        assertTrue("Movie does not correctly override equals",
                   testMovie1.equals(testMovie2));
    }

    @Test(points=5)
    public void comedyMovie() {
        try {
            Class.forName("ComedyMovie");
             assertEquals("ComedyMovie has incorrect price.",
                         3, new ComedyMovie("A").getPrice());
        } catch (NoClassDefFoundError | ClassNotFoundException e){
            fail("ComedyMovie not implemented.", 10);
        }
    }

    @Test(points=5)
    public void dramaMovie() {
        try {
            Class.forName("DramaMovie");
            assertEquals("DramaMovie has incorrect price.",
                         4, new DramaMovie("A").getPrice());
        } catch (ClassNotFoundException e){
            fail("DramaMovie not implemented.", 10);
        }
    }

    @Test(points=5)
    public void scifiMovie() {
        try {
            Class.forName("ScifiMovie");
            assertEquals("ScifiMovie has incorrect price.",
                         5, new ScifiMovie("A").getPrice());
        } catch (ClassNotFoundException e){
            fail("ScifiMovie not implemented.", 10);
        }
    }

    @Test(points=5)
    public void actionMovie() {
        try {
            Class.forName("ActionMovie");
            assertEquals("ActionMovie has incorrect price.",
                         2, new ActionMovie("A").getPrice());
        } catch (ClassNotFoundException e){
            fail("ActionMovie not implemented.", 10);
        }
    }

    @Test(points=10)
    public void totalPrice() {
        Cart cart = new Cart();
        cart.add(new Movie("A") {
            public int getPrice() { return 2; }
        });
        cart.add(new Movie("B") {
            public int getPrice() { return 3; }
        });
        cart.add(new Movie("C") {
            public int getPrice() { return 4; }
        });
        cart.add(new Movie("D") {
            public int getPrice() { return 1; }
        });
        cart.add(new Movie("First Silent Film Ever") {
            public int getPrice() { return 100; }
        });

        assertEquals("Cart.totalPrice calculates incorrect price.",
           110, cart.totalPrice()); 
    }
}
