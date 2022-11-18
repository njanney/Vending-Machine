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
        try{
            ArrayList<String> fortunes = new ArrayList<>();
            boolean mode = false;
            int count = 0;
            File myObj = new File("database.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                if (mode == false){
                    String data = myReader.nextLine();
                    System.out.println(data);
                    if (data.equals("SAD")) {mode = true;}
                }
                else {
                    String data = myReader.nextLine();
                    System.out.println(data);
                    fortunes.add(data);
                    if (data.equals("ANGRY")) {break;}
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
        Sad other = (Sad) obj;
        return (fortune.equals(other.fortune) && emotion.equals(other.emotion));
    }
    
}
