/* Jade Pearl
 * CMSC 215 Project 2
 * Date Modified: 9/12/2023
 * The Undergraduate class is a subclass of Student that adds a String instance variable of year to the student's information which describes
 * what year of college the student is in. It consists of a constructor which uses the super() function, a method that determines eligibility
 * if the student is a junior or senior, and converts the needed data to a string with a toString method which calls the toString in Student
 * and adds the year the student is in at the end.
 */

class Undergraduate extends Student {
    //define an instance variable for the year of a student
    private String year;

    
    //Constructor that allows Student's name, credit hours, quality points
    //and year to be initialized.
    public Undergraduate(String name, double creditHours, double qualPts, String year) {
        //you can use super to initialize the variables of the class that Undergraduate extends (Student)
        super(name, creditHours, qualPts);
        this.year = year;
    }

    public boolean eligibleForHonorSociety() {
        return (super.eligibleForHonorSociety() && (year.equals("Junior") || year.equals("Senior")
            || year.equals("junior") || year.equals("senior")));
    }

    public String toString() {
        return super.toString() + "\nYear: " + year;
    }
}