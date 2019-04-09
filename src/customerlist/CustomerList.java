/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customerlist;

import java.io.*;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author kyluk1259
 */
public class CustomerList {

    public static int count = 0;
    public static String existingList, in, newName, newPC, output;
    public static BufferedReader text;
    public static BufferedWriter writeFile;
    public static File customerFile;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        readFile();
        newCust();
    }

    public static String readFile() {

        try {
            customerFile = new File("Y:\\Documents\\NetBeansProjects\\CustomerList\\Resources\\Customers.txt");
            text = new BufferedReader(new FileReader(customerFile));
        } catch (FileNotFoundException e) {
            System.out.println("Fatal Error: Customer List Not Found. \nPlease reinstall or create a new one called Customers.txt in \\CustomerList\\Resources\\");
            System.exit(0);
        }

        in = "";
        existingList = "";

        do {

            try {
                in = (text.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (in != null) {
                existingList += (in + "\n");
            }

        } while (in != null);

        System.out.println(existingList);

        return existingList;
    }

    public static void newCust() {
        
        Boolean running = true;
        Scanner input = new Scanner(System.in);
        
        //Initialize Buffered Writer
        try{
        writeFile = new BufferedWriter(new FileWriter(customerFile, true)); 
        } catch (IOException e) {
            System.out.println("Fatal Error: File Can't Be Written To. \nPlease reinstall or create a new one called Customers.txt in \\CustomerList\\Resources\\");
            System.exit(0);
        }
        
        //Get and check name of new customer
        System.out.print("\nPlease enter the customer's name: ");
        while (running != false) {
            newName = input.next();
            for (char val : newName.toCharArray()) {
                if (!Character.isAlphabetic(val)) {
                    System.out.println("Please enter the customer's NAME");
                } else {
                    running = false;
                }
            }
        }

        //Get and check postal code of new customer
        running = true;
        System.out.print("\nPlease enter the customer's postal code(A#A#A#): ");
        while (running != false) {
            newPC = input.next();
            if (Character.isAlphabetic(newPC.charAt(0)) && Character.isDigit(newPC.charAt(1))
                    && Character.isAlphabetic(newPC.charAt(2)) && Character.isDigit(newPC.charAt(3))
                    && Character.isAlphabetic(newPC.charAt(4)) && Character.isDigit(newPC.charAt(5))) {
                running = false;
            } else {
                System.out.println("Please enter the customer's NAME");
            }
        }
        
        //Set line output and print to file
        running = true;
        output = (newName + ": " + newPC);
        try{
        writeFile.newLine();
        writeFile.write(output);
        }catch(IOException e){}
        
        //Ask if the user wants to input another customer
         while (running = true) {
            System.out.print("Would you like to add another customer? (1 - Yes / 2 - No): ");
            in = "";
            in = input.next();
            if(in.equals("1")){
                newCust();
            }else if(in.equals("2")){
                try{
                    writeFile.close();
                }catch(IOException e){}
                break;
            }else{
            }
        }
        System.out.println("New customers have been written to the file.");
    }
}


