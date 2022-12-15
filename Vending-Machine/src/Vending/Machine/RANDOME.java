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
 *  This is our definition of the subclass called Random
 * This class extends from parent class Fortune.java
 * This class is used only in TestVendingMachine.java
 * 
 * <br>Names: Andrea Martinez, Nick Janney, Ronnie Saenz, Jen-Ryann Ngo-Antonio 
 * <br>Date: Nov 8 2022
 *
 * @author nicho
 */

public class RANDOME extends Fortune{
    private String fortune;
    private String emotion;
    
    public RANDOME () {
        emotion = "RANDOM";
        /*
        This is the constructor for RANDOM fortunes, which requires no parameters
        Each constructor uses a similar algorithm for fetching a fortune from the database
        
        This algorithm reads the file line for line until it finds the RANDOM section
        Then stores each fortune in that section into an ArrayList of Strings
        Once it reaches the end of the file, terminate file reading
        Lastly, we generate a random int based on the number of RANDOM fortunes
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
                    if (data.equals("RANDOM")) {
                        mode = true;
                    }
                }
                else {
                    /*
                    Since RANDOM fortunes are at the end of the database
                    There is no need to check for the end of the file
                    */
                    fortunes.add(data);
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
            fortune = "You are my 13th reason";
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
        RANDOME other = (RANDOME) obj;
        return (fortune.equals(other.fortune) && emotion.equals(other.emotion));
    }
    
}
