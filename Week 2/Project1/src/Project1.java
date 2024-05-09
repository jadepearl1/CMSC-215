/* Jade Pearl
 * Project 1
 * 8/20/2023 updated: 8/22/2023
 * The Project class contains the main method of the program. The purpose of this class is to prompt the user
 * to enter a specified number of players to put into an ArrayList. As players are read in, the total age of all players
 * is calculated and once all players are input and run through, the average age is then output. After that, the list of players
 * is traversed to find the tallest player whose age is less than or equal to the average age of all players.
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Project1 {
    public static void main(String[] args) {
        //Define an array list to hold players and Scanner for input
        ArrayList<Player> players = new ArrayList<Player>();
        Scanner input = new Scanner(System.in);
        //holds the age of all players. This will help take the average age later
        int totalAge = 0; 

        //promt the user to input the number of players they would like to add to the list
        System.out.print("How many players would you like to add?");
        int num = input.nextInt();
        //loop that fills the ArrayList of Players
        for(int i = 0; i < num; i++) {
            input.nextLine(); //skip the newline character
            System.out.print("Name: ");
            String pName = input.nextLine();

            System.out.print("Height in feet and inches: ");
            int feet = input.nextInt();
            int inches = input.nextInt();
            //create a new height object in order to construct the player's height
            Height pHeight = new Height(feet, inches);

            System.out.print("Age: ");
            int pAge = input.nextInt();
            totalAge += pAge; //increment the total age by the current player's age in each iteration

            Player p = new Player(pName, pHeight, pAge);
            players.add(p);
        }

        //calculate the average age among all players
        double averageAge = (double) totalAge / num;
        System.out.println("The average age of all players is: " + averageAge);

        //calculate the tallest player out of the list
        Player tall = null;
        int maxHeight = 0;
        //for loop that iterates through the ArrayList and finds the tallest player above or equal to the average age
        for (Player p : players) {
            if(p.getHeight().toInches() > maxHeight && p.getAge() <= averageAge) {
                maxHeight = p.getHeight().toInches();
                tall = p;
            }
        }
        //make sure there is a tallest player that is younger than or as old as the average age of all players
        if (tall != null) {
            System.out.println("The tallest player that is younger or as old as the average age of all players: ");
            System.out.println(tall);
        }
        else
            System.out.println("There is no tallest player that is younger or as old as the average age of all players.");
    }
}
