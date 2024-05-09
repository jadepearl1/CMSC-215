class Student {
    //define three instance variables for student name, credit hours, and quality points
    private String name;
    private double creditHours;
    private double qualPts;
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
}