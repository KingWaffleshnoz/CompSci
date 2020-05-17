import java.lang.Math;
import java.util.ArrayList;

public class APFRQ {
    public static void main(String[] args) {

    }
}

public class Movie {

    public String getTitle() {

    }
}

/**
 * @author J.L.
 * APID: WYY5V618
 */
public class MovieTheater {
    private Movie[] screenArr;
    ArrayList<Movie> theaters = new ArrayList<Movie>();

    //Part A
    public ArrayList<Integer> screensWithMovies() {
        ArrayList<Integer> output = new ArrayList<Integer>();
        for (int i = 0; i < theaters.size(); i++) {
            if (theaters.get(i) != null) {
                output.add(i);
            }
        }
        return output;
    }

    //Part B
    public void updateScreenArr(ArrayList<Movie> moviesToAssign) {
        for (int i = 0; i < theaters.size(); i++) {
            if (theaters.get(i) == null) {
                theaters.set(i, moviesToAssign.get(0));
                moviesToAssign.remove(0);
            }
        }
    }
}

//Part C
/**
 * Method header: public void removeUnpopular()
 * I would add a `private double` to the movie class that denotes its popularity as
 * well as a `public void setPopularity` method that can change the given popularity level. 
 * Afterwards, the `removeUnpopular` method would then need to use a for loop to examine
 * each movie object within the screensWithMovies ArrayList and 
 * remove any movie objects whose popularity variable is below
 * a given threshold, thus setting that specific theater back to a null setting.
 */