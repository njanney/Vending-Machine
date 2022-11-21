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
        The fortune is stored as "Error!"
        */
        try{
            ArrayList<String> fortunes = new ArrayList<>();
            boolean mode = false;
            int count = 0;
            File myObj = new File("database.txt");
            System.out.println(myObj.getAbsolutePath());
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                if (mode == false){
                    String data = myReader.nextLine();
                    System.out.println(data);
                    if (data.equals("RANDOM")) {mode = true;}
                }
                else {
                    String data = myReader.nextLine();
                    System.out.println(data);
                    fortunes.add(data);
                }
            } 
            Random rand = new Random();
            int random = rand.nextInt(count);
            fortune = fortunes.get(random);
        }
        catch (IOException e){
            System.out.println("File read error! " + e);
            fortune = "Error!";
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
