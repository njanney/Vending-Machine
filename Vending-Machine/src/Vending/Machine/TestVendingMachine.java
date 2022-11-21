package Vending.Machine;

import java.util.Date;

/**
 *  This is the testing file for the Vending Machine
 *  Requires Fortune.java, Happy.java, Sad.java, Angry.java.
 *  Makes use of TextJFrame.java
 * 
 * <br>Names: Andrea Martinez, Nick Janney, Ronnie Saenz, Jen-Ryann Ngo-Antonio 
 * <br>Date: Nov 8 2022
 *
 * @author nicho
 */
public class TestVendingMachine extends Object {

    public static void main(String[] args) {
        TextJFrame win = new TextJFrame("Vending Machine",
                new Date().toString() + "\n");
        win.Append2TextArea("Output of TestVendingMachine ...\n");
        
        win.setVisible(true);
    }
}
