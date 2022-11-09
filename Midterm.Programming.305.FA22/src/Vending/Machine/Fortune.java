/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vending.Machine;

/**
 *  This is our definition of the abstract class called Fortune
 * This class is used only in TestVendingMachine.java
 * 
 * <br>Names: Andrea Martinez, Nick Janney, Ronnie Saenz, Jen-Ryann Ngo-Antonio 
 * <br>Date: Nov 8 2022
 *
 * @author nicho
 */

public abstract class Fortune extends Object{
    private String fortune;
    private String emotion;
    
    public abstract String getFortune();
    public abstract String setFortune();
    
    @Override
    public String toString() {
        return "";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (getClass() != obj.getClass())
            throw new java.lang.RuntimeException("compareTo: Empty Object!");
        Fortune other = (Fortune) obj;
        return (fortune.equals(other.fortune) && emotion.equals(other.emotion));
    }
    
}
