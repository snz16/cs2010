/**
 * SerenaZarate_05 generates the Postfix and 
 * the Stack class to convert Infix to Postfix
 * Project #5
 * Computer
 *  Acceptation: a generally accepted meaning of a word
 * "The difference between ordinary and extraordinary is that little extra." 
 *  Jimmy Johnson 1943
 *@author Selamawit Abdo, Busra Ozdemir, and Serena Zarate
 *@version Project 5
 *@class SerenaZarate_05
 */
 
import java.io.*;
import java.util.EmptyStackException;
import java.util.Scanner;

public class SerenaZarate_05 {

   public static void main (String [] args) {

      final String INPUT_FILE = "Project_05_Input01.txt";
      try {
			File inputFile = new File(INPUT_FILE);
			Scanner scnr = new Scanner(inputFile);
			System.out.printf("Infix Expresssion  %52s%n", "Postfix Expression");
			
         while (scnr.hasNextLine()) {
           
            try {
               Postfix p = new Postfix();
               String infix = scnr.nextLine();
               System.out.printf("\n%-52s", infix);
               System.out.printf("          %s", p.convertToPostfix(infix));
            } // End of try 

            catch (Exception e) {
               System.err.println(e.getMessage());
            } // End of catch
            
        } // End of while
	} // End of try

      catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		} // End of catch
      
   } // End of main
} // End of class