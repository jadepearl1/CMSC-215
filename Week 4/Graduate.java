/* Jade Pearl
 * CMSC 215 Project 2
 * Date Modified: 9/12/2023
 * The Graduate class is a subclass of Student that adds a String instance variable of degree to the student's information which describes
 * what grad degree the student is pursuing. It consists of a constructor which uses the super() function, a method that determines eligibility
 * if the student is pursuing their Masters, and converts the needed data to a string with a toString method which calls the toString in Student
 * and adds the sought degree the student is pursuing at the end.
 */

class Graduate extends Student {
    //make an instance variable that will describe if a grad student wants a masters or doctoral degree
    private String degree;

    public Graduate(String name, double creditHours, double qualPts, String degree) {
        //call the contructor in Student
        super(name, creditHours, qualPts);
        this.degree = degree;
    }

    public boolean eligibleForHonorSociety() {
        return super.eligibleForHonorSociety() && (degree.equals("Masters") || degree.equals("masters"));
    }

    public String toString() {
        return super.toString() + "\nDegree Sought: " + degree;
    }
}
