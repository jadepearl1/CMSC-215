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
        return super.toString() + "Degree Sought: " + degree;
    }
}
