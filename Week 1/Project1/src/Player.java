/* Jade Pearl
 * Project 1
 * 8/20/2023 updated: 8/22/2023
 * The Player class is an immutable class that includes the player's name, height, and age.
 * It contains a constructor that takes all three variables and creates a Player object,
 * contains getters for each instance variables, and a method toString that returns the string
 * representation of a player with each field appropriately labeled.
 * The toString class will utilize the Height class by also calling the toString method in the Height class.
 */
public class Player {
    
    private String name;
    private Height height;
    private int age;

    public Player(String name, Height height, int age) {
        this.name = name;
        this.height = height;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Height getHeight() {
        return height;
    }

    public int getAge() {
        return age;
    }

    public String toString() {
        return "Name: " + name + ", Height: " + height.toString() + ", Age: " + age + "\n";
    }
}
