/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vending.Machine;

/**
 *  This is my definition of the data class called Employee
 * This class is used only in TestEmployee.java
 * This class requires a String and two ints to be initialized
 * 
 * <br>Name: Nicholas Janney
 * <br>Date: Oct 18 2022
 *
 * @author nicho
 */

public class Employee extends Object{
    /*
    Our class variables for Employee are a String for a name,
    an integer for an id, and an int for a salary
    */
    private final String name;
    private final int id;
    private final int salary;
    
    public Employee(String name, int id, int salary){
        /*
        Constructor for Employee data class
        */
        this.name = name;
        this.id = id;
        this.salary = salary;
    }
    
    public String getName() {
        /*
        Returns the name as a String
        */
        return name;
    }
    public int getId() {
        /*
        Returns the id as an integer
        */
        return id;
    }
    public int getSalary() {
        /*
        Returns the salary as an integer
        */
        return salary;
    }
    
    @Override
    public String toString() {
        /*
        Override the default toString() method for use in our test program
        */
        return "Employee[name=" + name 
                + ", id=" 
                + id 
                + ", salary=" 
                + salary + "]";
    }
    
    public int compareTo(Object obj){
        /*
        compareTo method, required for all data classes
        
        Throw an exception if the current class cannot be compared with
        the given class
        
        Returns an integer, 1 if the two objects are identical, 0 if they are not
        */
        if (getClass() != obj.getClass())
            throw new java.lang.RuntimeException("compareTo: Empty Object!");
        
        Employee other = (Employee) obj;
        Boolean result = (name.equals(other.getName()) && (id == other.getId()) && (salary == other.getSalary()));
	if (result == true)
            return 1;
        else
            return 0;
    }
}
