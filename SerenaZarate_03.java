/**
 * SerenaZarate_03 implements the list class to create a 
 * list of students and grade items
 * Project #3
 * Computer
 *  Acceptation: a generally accepted meaning of a word
 * "The difference between ordinary and extraordinary is that little extra." 
 *  Jimmy Johnson 1943
 */
import java.io.*;
import java.util.Scanner; 
 
public abstract class SerenaZarate_03 implements MyCollectionInterface{

   private static List <listOfStudents> Student = new ArrayList<listOfStudents>();
   private static List<listOfStudents> GradeItem = new ArrayList<listOfGradeItems>(); 
   private static String INPUT_FILE;
   private static String OUTPUT_FILE; 
   
   public static void main (String[] args) {
      String XX = "01";
		if(args.length > 0) {
			XX = args[0];
			if (XX.length() == 1) {
				XX = "0" + XX;
			} // End of 2nd if
		} // End of 1st if

       INPUT_FILE = "hw3input" + XX + ".txt";	

        processInput();     // Calling the method
		generateReport(); // Calling the method
   } // End of main
   
   private static void processInput(){
     listOfStudents Student = new ArrayList<listOfStudents>();
     listOfGradeItems GradeItem = new ArrayList<listOfGradeItems>();
   }
   
   private static void processStudentData(String[] student) throws IOException {
   
   } 

   private static void processGradeItemData(String[] student) throws IOException{
   
   }
   
   private static void generateReport () throws IOException {
      
      PrintWriter outFile = new PrintWriter(new File(OUTPUT_FLIENAME));
      int currentSize = 0;
      
      arrayOfStudents = new Student[listOfStudents.getCurrentsize()];
   }
} // End of class