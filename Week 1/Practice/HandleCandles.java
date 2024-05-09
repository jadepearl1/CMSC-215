import java.util.ArrayList;
import java.util.Scanner;

public class HandleCandles {
    ArrayList<Candle> list; // attribute to store a list of Candle objects
    // constructor
    
    public HandleCandles() {
        list = new ArrayList<Candle>(); // creates new instance of an empty list
    }

    // method to display the menu
    public void displayMenu() {
        System.out.println("\n MENU");
        System.out.println("1: Add candle ");
        System.out.println("2: Remove candle ");
        System.out.println("3: Light candle ");
        System.out.println("4: Extinguish candle ");
        System.out.println("5: Display candles ");
        System.out.println("9: Exit program");
    }

    // method to handle user's selection
    public void processChoice(int c) {
        switch (c) {
            case 1 : addCandle();
            break;
            case 2 : removeCandle();
            break;
            case 3 : lightCandle(true);
            break;
            case 4 : lightCandle(false);
            break;
            case 5 : displayCandles();
            break;
            case 9: System.out.println("\nThank you for using the program. Goodbye!");
            break;
            default: System.out.println("Invalid choice");
        }
    }
    
    // method to display all candle information in the list
    private void displayCandles() {
        if (list.size() == 0)
            System.out.println("\nThere are no candles to display");
        else {
            System.out.println(); // empty line before candle data
            for (int i=0; i < list.size(); i++) { // loop for all candles in the list
                Candle c = list.get(i); // get candle instance from the list for each index value
                System.out.println(c.toString()); // print candle data to console
            }
        }
    }

    // when light=true, lit the candle and if light=false, extinguish candle
    // TODO: could also first check if already lit or extinguished and give message
    private void lightCandle(boolean light) {
        Scanner stdin = new Scanner(System.in);
        // prompt user for data to find the candle to remove
        System.out.print("What is the height of the candle you want to light/extinguish? ");
        int height = stdin.nextInt();
        System.out.print("What is color of the candle you want to light/extinguish? ");
        String color = stdin.next();
        // look for the candle that matches above
        int size = list.size(); // number of candles in the list
        System.out.println(); // empty line before candle data
        for (int i=0; i < size; i++) { // loop for all candles in the list
            Candle c = list.get(i); // get candle instance from the list for each index value
            if (c.height == height && c.color.equalsIgnoreCase(color)) {
                if (light)
                    c.isLit = true; // light candle
                else
                    c.isLit = false; // extinguish candle
                list.set(i, c); // update in list
                System.out.println("\nLit/extinguished candle: " + c.toString()); // print candle data to console
                return; // done
            }
        }
        // if here than did not find the candle
        System.out.println("\nThere is no candle with this height and color");
    }

    // method to remove the first candle that matches user's criteria
    private void removeCandle() {
        Scanner stdin = new Scanner(System.in);
        // prompt user for data to find the candle to remove
        System.out.print("What is the height of the candle you want to remove? ");
        int height = stdin.nextInt();
        System.out.print("What is color of the candle you want to remove? ");
        String color = stdin.next();
        // look for the candle that matches above
        int size = list.size(); // number of candles in the list
        System.out.println(); // empty line before candle data
        for (int i=0; i < size; i++) { // loop for all candles in the list
            Candle c = list.get(i); // get candle instance from the list for each index value
            if (c.height == height && c.color.equalsIgnoreCase(color)) {
                list.remove(i); // remove the candle
                System.out.println("\nRemoved the following candle: " + c.toString()); // print candle data to console
                return; // done so can return from method
            }
        }
        // if did not return from for-loop that mean sit did not find the candle
        System.out.println("\nThere is no candle with this height and color");
    }
    
    private void addCandle() {
        Scanner stdin = new Scanner(System.in);
        // prompt user for all candle data to be set on creation
        System.out.print("What is the candle's height? ");
        int height = stdin.nextInt();
        System.out.print("What is the candle's diameter? ");
        double diameter = stdin.nextDouble();
        System.out.print("What is the candle's color? ");
        String color = stdin.next();
        // candle must start as unlit so not prompting
        // create Candle instance
        Candle c = new Candle(color, height, diameter);
        // tell user what was created
        System.out.println("\nThe following candle was created: " + c.toString());
        // add candle instance to list
        list.add(c);
    }
    public static void main(String[] args) {
        HandleCandles handler = new HandleCandles(); // new instance of driver class
        Scanner stdin = new Scanner(System.in);
        int selection = 0;
        do {
            handler.displayMenu();
            System.out.print("\nEnter your selection : ");
            selection = stdin.nextInt();
            handler.processChoice(selection);
        } while (selection != 9);
        stdin.close();
    }
}