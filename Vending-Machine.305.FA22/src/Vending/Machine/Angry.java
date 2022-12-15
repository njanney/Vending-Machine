/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vending.Machine;

/**
 *  This is our definition of the subclass called Angry
 * This class extends from parent class Fortune.java
 * This class is used only in TestVendingMachine.java
 * 
 * <br>Names: Andrea Martinez, Nick Janney, Ronnie Saenz, Jen-Ryann Ngo-Antonio 
 * <br>Date: Nov 8 2022
 *
 * @author nicho
 */

public class Angry extends Fortune{
    private String fortune;
    private String emotion;
    
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
        return "";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (getClass() != obj.getClass())
            throw new java.lang.RuntimeException("compareTo: Empty Object!");
        Angry other = (Angry) obj;
        return (fortune.equals(other.fortune) && emotion.equals(other.emotion));
    }
    
}
