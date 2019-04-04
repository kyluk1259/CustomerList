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
    public static String existingList, in;
    public static String[] newNames;
    public static String[] newPostalCodes;
    //public static String[][] customers = new String[newNames.length][newPostalCodes.length];
    public static BufferedReader text;
    public static File customerFile;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        readFile();
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
        
       do{

            try {
                in = (text.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
            
            if(in != null){
                existingList += (in + "\n");
            }

       }while(in != null);
            
        System.out.println(existingList);

        return existingList;
    }
    
    public static void newCust(){
        
        count++;
        
        Scanner input = new Scanner(System.in);
        newNames[count] = input.next();
    }
    
}


