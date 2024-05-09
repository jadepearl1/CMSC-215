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