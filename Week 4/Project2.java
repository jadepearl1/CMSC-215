/* Jade Pearl
 * CMSC 215 Project 2
 * Date Modified: 9/12/2023
 * The Project 2 class consists of the main method. It makes an ArrayList of students and reads in students from a file one by one. As
 * each student is read in, the values of name, creditHours, qualityPoints, and yearOrDegree are assigned and they are added to the ArrayList
 * as an undergrad or grad depending on their year or degree sought. As they are added, the totalGPA and number of students increases for later
 * calculation. After all students are read in, the average Gpa is calculated so that the gpa threshold for determining honors eligibility
 * is calculated. Once the threshold is output to the console, a list of students who are eligible along with their GPA and year/degree is
 * printed to the console.
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.*;

class Project2 {
    public static void main(String[] args) {
        //define an ArrayList to hold students
        ArrayList<Student> students = new ArrayList<>();
        //initialize totalGPA and the number of students in the list to later find the average
        double totalGPA = 0.0;
        int numStudents = 0;
        try {
            //make a new scanner object for the file name.
            Scanner input = new Scanner(new File("students.txt"));
    
            //loop through the file until there are no more lines
            while(input.hasNextLine()) {
                //create the variables of name, creditHours, qualityPoints, and yearOrDegree so that each student is sorted in the list as
                //a grad or undergrad
                String name;
                double creditHours;
                double qualityPoints;
                String yearOrDegree;
                String line = input.nextLine();
                //split the line with a space as a delimiter so that all pieces of data are separated.
                String[] splits = line.split(" ");
                //The name is always first followed by credit hours, quality points, and then year or degree sought
                name = splits[0];
                creditHours = Double.valueOf(splits[1]);
                qualityPoints = Double.valueOf(splits[2]);
                yearOrDegree = splits[3];
                //sort students into grad/undergrad depending on value of yearOrDegree and accumulate totalGPA
                if (yearOrDegree.equals("Freshman") || yearOrDegree.equals("freshman") || yearOrDegree.equals("Sophomore") || yearOrDegree.equals("sophomore") || yearOrDegree.equals("Junior") || yearOrDegree.equals("junior") || yearOrDegree.equals("Senior") || yearOrDegree.equals("senior")) {
                    Student student = new Undergraduate(name, creditHours, qualityPoints, yearOrDegree);
                    double gpa = student.gpa();
                    totalGPA += gpa;
                    numStudents++;
                    students.add(student);
                }
                else if (yearOrDegree.equals("Masters")  || yearOrDegree.equals("masters") || yearOrDegree.equals("Doctorate") || yearOrDegree.equals("doctorate")) {
                    Student student = new Graduate(name, creditHours, qualityPoints, yearOrDegree);
                    double gpa = student.gpa();
                    totalGPA += gpa;
                    numStudents++;
                    students.add(student);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: students.txt not found.");
            System.exit(1);
        }
        //calculate the average GPA and the threshold for eligibility
        double averageGPA = totalGPA / numStudents;
        double threshold = averageGPA + ((4.0 - averageGPA) / 2);
        Student.setGpaThreshold((averageGPA + 4.0) / 2);

        //Print out the needed information
        System.out.println("Threshold GPA: " + Student.getGpaThreshold());

        System.out.println("Eligible for Honor Society:");
        for (Student student : students) {
            if (student.eligibleForHonorSociety()) {
                System.out.println(student.toString());
            }
       }
    }
}