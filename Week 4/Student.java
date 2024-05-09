/* Jade Pearl
 * CMSC 215 Project 2
 * Date Modified: 9/12/2023
 * The Student class has 4 private instance variables: name, creditHours, qualPts, and gpaThreshold. Each holds the values from a string 
 * originating in a text file (except gpaThreshold). It consists of a constructor, a method that calculates gpa, a method that determines
 * eligibility for honors, a toString method to output name and GPA as a string, and a getter and setter for the gpaThreshold in order to 
 * help define the gpaThreshold of all students read in in the main method.
 */

class Student {
    //define three instance variables for student name, credit hours, and quality points
    private String name;
    private double creditHours;
    private double qualPts;
    //create another instance variable that is static for the gpaThreshold when the main method uses it
    private static double gpaThreshold;

    public Student(String name, double creditHours, double qualPts) {
        this.name = name;
        this.creditHours = creditHours;
        this.qualPts = qualPts;
    }

    public double gpa(){
        if(creditHours == 0.0){
            return 0.0;
        }
        else
            return qualPts / creditHours;
    }

    public boolean eligibleForHonorSociety() {
        if (gpa() > gpaThreshold) {
            return true;
        }
        else
            return false;
    }

    public String toString() {
        return "Name: " + name + "\nGPA: " + gpa();
    }

    public static void setGpaThreshold(double threshold) {
        gpaThreshold = threshold;
    }

    public static double getGpaThreshold() {
        return gpaThreshold;
    }
}