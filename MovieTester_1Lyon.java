//Jared Lyon P1
//Class-A5: Movie Class

/**
 * Creates two movie objects with stats and ratings
 */
public class MovieTester_1Lyon {
    public static void main(String[] args) {
        //Object A
        Movie schindler = new Movie("Schindler's List", "Drama, History, & Biography", 195, "R");
        schindler.addRating(9.27);
        System.out.println("You find a digital poster at a movie theater that reads:");
        System.out.println(schindler);
        System.out.println("You decide to go and watch it.");
        System.out.println("...");
        System.out.println("...");
        System.out.println("...195 minutes later...");
        System.out.println("...");
        System.out.println("...");
        System.out.println("You decide to rate it an 8.96/10.");
        schindler.addRating(8.96);
        System.out.println("The poster now reads:");
        System.out.println(schindler);

        //divider
        System.out.println("-----");
        System.out.println("Next month, you revisit the movie theater...");
        System.out.println("-----");

        //object B
        Movie interstellar = new Movie("Interstellar", "Adventure, Drama, & Sci-Fi", 169, "PG-13");
        interstellar.addRating(8.32);
        System.out.println("You find a digital poster at a movie theater that reads:");
        System.out.println(interstellar);
        System.out.println("You decide to go and watch it.");
        System.out.println("...");
        System.out.println("...");
        System.out.println("...169 minutes later...");
        System.out.println("...");
        System.out.println("...");
        System.out.println("You decide to rate it an 8.96/10.");
        interstellar.addRating(9.03);
        System.out.println("The poster now reads:");
        System.out.println(interstellar);
    }
}

/**
 * Creates a movie with a name, genre, length, mpaa rating, rating points, & number of ratings
 */
class Movie {
    private String name;
    private String genre;
    private int length;
    private String mpaaRating;
    private int numRatings;
    private double agRating;
    private double avgRating;
    private int roundRating;

    //constructors
    public Movie(String name, String genre, int length, String mpaaRating) {
        this.name = name;
        this.genre = genre;
        this.length  = length;
        this.mpaaRating = mpaaRating;
    }

    //accessors
    public String toString() {
        String yeahBuddy = "The movie \"" + name + "\" is a(n) " + genre + " movie that is " + length + " minutes long. It is rated " + mpaaRating + ".";
        String rateBuddy = "The movie is currently rated " + avgRating + "/10 by " + numRatings + " critic(s).";

        return yeahBuddy + "\n" + rateBuddy;
    }

    //mutator
    public void addRating(double rating) {
        numRatings++;
        agRating = agRating + rating;
        avgRating = agRating / numRatings;

        //round average ratings
        roundRating = (int)((agRating / (numRatings)) * 100 );
        avgRating = (roundRating / 100.0);
    }
}