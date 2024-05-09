/* Jade Pearl
 * Project 1
 * 8/20/2023 updated: 8/22/2023
 * The Height class is an immutable class that takes the feet and inch measurements of a
 * basketball player. It can convert those measurements into total inches and into a string
 * representation. It contains data variables feet and inches, a constructor, and methods
 * toInches (returns height in total inches) and toString which converts the height into a
 * String value and display the normalized height so that inches are less than 12.
 */
public class Height {

    private int feet;
    private int inches;

    public Height(int feet, int inches) {
        this.feet = feet;
        this.inches = inches;
    }

    public int toInches() {
        return feet * 12 + inches;
    }

    public String toString() {
        //normalize feet and inches to maintain proper format no matter how many inches the user enters
        feet = feet + inches / 12;
        inches = inches % 12;
        return feet + "' " + inches + "\"";
    }
}
