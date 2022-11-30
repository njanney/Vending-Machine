/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vending.Machine;
import java.io.*;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

/**
 *  This is our definition of the subclass called Sad
 * This class extends from parent class Fortune.java
 * This class is used only in TestVendingMachine.java
 * 
 * <br>Names: Andrea Martinez, Nick Janney, Ronnie Saenz, Jen-Ryann Ngo-Antonio 
 * <br>Date: Nov 8 2022
 *
 * @author nicho
 */

public class Sad extends Fortune{
    private String fortune;
    private String emotion;
    
    public Sad () {
        emotion = "SAD";
        /*
        This is the constructor for Sad fortunes, which requires no parameters
        Each constructor uses a similar algorithm for fetching a fortune from the database
        
        This algorithm reads the file line for line until it finds the SAD section
        Then stores each fortune in that section into an ArrayList of Strings
        Once it reaches the end of the section, or reaches ANGRY, then terminates file reading
        Lastly, we generate a random int based on the number of sad fortunes
        And save the fortune corresponding to that int in our ArrayList
        
        If there is an error in fortune fetching, or the file read is unsucessfull,
        The fortune is a defualt fortune, and the error is sent to the terminal
        */
        try{
            ArrayList<String> fortunes = new ArrayList<>();
            boolean mode = false;
            File myObj = new File("database.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (mode == false){ 
                    /*
                    If we are currently reading fortunes,
                    but we are not in the right section of the database,
                    wait until we reach the correct section 
                    to start saving the fortunes in our ArrayList
                    */
                    if (data.equals("SAD ")) {
                        mode = true;
                    }
                }
                else {
                    /*
                    If we are currently reading and saving fortunes
                    Check if we have reached the end of the right section
                    in our database
                    If we are at the end, stop reading fortunes
                    */
                    if (data.equals("ANGRY ")) {mode = false;}
                    else {fortunes.add(data);}
                }
            }
            myReader.close();
            Random rand = new Random();
            // Generate a random int based on the size of the ArrayList
            // Use that random int to pick a fortune index from the ArrayList
            int random = rand.nextInt(fortunes.size());
            fortune = fortunes.get(random);
        }
        catch (IOException e){
            /*
            If there is a file read error
            Send the error to the console
            and give the user a default fortune
            */
            System.out.println("File read error! " + e);
            fortune = "Tomorrow will be a better day";
        }
    }
    
    @Override
    public String getFortune(){
        return fortune;
    }
    @Override
    public String setFortune(String fortune){
        this.fortune = fortune;
        return fortune;
    }
    
    @Override
    public String toString() {
        return "Your " + emotion + " fortune is: " + fortune;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (getClass() != obj.getClass())
            throw new java.lang.RuntimeException("compareTo: Empty Object!");
        Sad other = (Sad) obj;
        return (fortune.equals(other.fortune) && emotion.equals(other.emotion));
    }
    
}
