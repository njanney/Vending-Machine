package Vending.Machine;

import java.util.Date;

/**
 * In this programming exercise, you are required to create a Java data class,
 * Employee with attributes name, employee id, and whole number salary.
 * <pre>
 * 1. Using standard techniques to find the Median salary of the employees, as well
 * as lowest and highest.
 * 2. You are required to output the information to the JTextFrame provided in
 * the starter code.
 * 3. Please zip your files and named the zip file firstname_midterm_305_fa22.zip
 * before uploading to BB
 * 
 * Hint: A compareTo() method is required for the Java data class
 *
 * Please match the sample output below:
 * List of employees as is ...
 * Employee[name=Anton, id=10000, salary=500200]
 * Employee[name=Mai, id=40000, salary=200000]
 * Employee[name=Jose, id=3050, salary=300500]
 * Employee[name=Wayne, id=25000, salary=150700]
 *
 * Sorting employees based on salary ...
 * Employee[name=Wayne, id=25000, salary=150700]
 * Employee[name=Mai, id=40000, salary=200000]
 * Employee[name=Jose, id=3050, salary=300500]
 * Employee[name=Anton, id=10000, salary=500200]
 *
 * Lowest salary $150,700
 * Median salary $250,250
 * Highest salary $500,200
 * </pre>
 * <br>Name: Nicholas Janney
 * <br>Date: Oct 18 2022
 *
 * @author Prof A. Nuzen anuzen@sandiego.edu
 */
public class TestEmployee extends Object {

    public static void main(String[] args) {
        TextJFrame win = new TextJFrame("Midterm.305.FA22",
                new Date().toString() + "\n");
        win.Append2TextArea("Output of TestEmployee ...\n");
        /*
        Beginning of implementation
        
        Initialize our employee array and intitalize each employee
        
        Each Employee is a data class from Employee.java
        
        Output each employee in order once initialized, using the overriden
        toString method from Employee.java
        */
        Employee[] emps = new Employee[4];
        
        Employee Anton = new Employee("Anton", 10000, 500200);
        emps[0] = Anton;
        Employee Mai = new Employee("Mai", 40000, 200000);
        emps[1] = Mai;
        Employee Jose = new Employee("Jose", 3050, 300500);
        emps[2] = Jose;
        Employee Wayne = new Employee("Wayne", 25000, 150700);
        emps[3] = Wayne;
        
        int n = emps.length;
        for (int i = 0; i < n; i++)
            win.Append2TextArea(emps[i] + "\n");
        
        /*
        Sorting employees based on salary
        
        Must sort array, I used a selection sort which is complexity O(n^2)
        So it is not very efficient
        */
        win.Append2TextArea("Sorting employees based on salary ...\n");
        for (int i = 0; i < n-1; i++) {
            int min_indx = i;
            for (int j = i+1; j < n; j++){
                if (emps[j].getSalary() < emps[min_indx].getSalary()){
                    min_indx = j;
                }   
            }
            Employee temp = emps[min_indx];
            emps[min_indx] = emps[i];
            emps[i] = temp;
        }
        
        for (int i = 0; i < n; i++)
            win.Append2TextArea(emps[i] + "\n");
        
        /*
        Output the smallest, median, and largest salary among the employees
        
        Median is based on the average of the middle two if there are an even
        number of employees
        */
        int lowest_salary = emps[0].getSalary();
        int median_salary = 0;
        if (emps.length % 2 == 0) {
            median_salary = (emps[emps.length/2].getSalary() + emps[(emps.length/2) - 1].getSalary()) / 2;
        }
        int highest_salary = emps[emps.length-1].getSalary();
        
        win.Append2TextArea("Lowest Salary " + lowest_salary + "\n");
        win.Append2TextArea("Median Salary " + median_salary + "\n");
        win.Append2TextArea("Highest Salary " + highest_salary + "\n");
        
        win.setVisible(true);
    }
}
