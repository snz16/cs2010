/*
   SerenaZarate_02 tests the Student and GradeItem Class
   Serena Zarate & Edglene Woy
   Project #2 
   Laptop
   Desuetude: a state of disuse
   "Successful people have fear, successful people have doubts, and sucessful
   people have worry. They just don't let these feelings stop them.", by T. Harv Eker 
   1954
*/
import java.io.*;
import java.util.Scanner;

public class SerenaZarate_02 {
   private static Student student1;
   private static Student student2;
   private static GradeItem gradeItem1;
   private static GradeItem gradeItem2;
   
   public static void main(String[] args) throws IOException{
        // Holds the input file number, 01, 02,...
        String XX = "01"; 			      
										           
		 if(args.length > 0) {			  
			XX = args[0];
			if (XX.length() == 1) {		
				XX = "0" + XX;
			} // End inner if
		} // End outer if
	
		final String INPUT_FILENAME = "Project_02_Input" + XX + ".txt";
		File inputFile = new File (INPUT_FILENAME);
		Scanner input = new Scanner (inputFile);  

       // Setup input
        File inFile = null;  
        FileReader fr = null;             // Creates a file reader and throws FileNotFoundException 
        BufferedReader br = null;  // Created to pass any object that extends the reader
        try {
            inFile = new File(INPUT_FILENAME); 
            fr = new FileReader(inFile); 
            br = new BufferedReader(fr); 
        } catch(Exception e) {
            System.err.print("Input file: " + INPUT_FILENAME +" is not found");
            System.exit(1); 
        } 
 //*****************************************************************************
  // Test Set 1: Checks the constructors with parameters for each field
  // and the toString method for each class.
  
  // Test 1a: Hard codes student
  student1 = new Student("900123456", "Joe", "Doe", "joedoe@msudenver.edu");
  System.out.println("Running Test 1a:");
  System.out.println(student1.toString());
  System.out.println("");
  
  // Test 1b: Hard codes grade item 
  gradeItem1  = new GradeItem("900899197",1,"23456","HW","20190829",100,95);
  System.out.println("Running Test 1b:");
  System.out.println(gradeItem1.toString());
  System.out.println("");
  
  //*****************************************************************************
 // Test Set 2: Checks the constructors, getters, and the reading of the data 
 // from a second input data file.
 
 // Test 2a: Scans the first line of the input file and displays a message   
  System.out.println("Running Test 2a:");
  String inputLine = br.readLine();
  String[] splitData = inputLine.split(",");
  
  if (splitData[0].equals("STUDENT")){
      processStudentData(splitData);
      System.out.println(student1.toString());
  }
  
 else if (splitData[0].equals("GRADE ITEM")){
      processGradeItemData(splitData);
  }  
  
  else {
   throw new IllegalArgumentException("Data entered is incomplete." + 
                                                               "Must enter either 'STUDENT' or 'GRADE ITEM'" );
  }
  input.close();  
  
//*****************************************************************************
  
  // Test Set 3: Checks the equals() method for both classes
  // Test 3a:
  
   System.out.print("Running Test 3a:");
   if(student1.equals(student2)) {
      System.out.println("Student objects are equal: Student IDs are " + student1);
   }
   else {
      System.out.println("Student objects are unequal: Student IDs are " + student1 + " and " + student2);
   }
   System.out.println("");
   
  // Test 3b: 
    System.out.println("Running Test 3b:");
    if(gradeItem1.equals(gradeItem2)) {
        System.out.println("GradeItem objects are equal: Student IDs are " + gradeItem1);
    }
    else {
         System.out.println("GradeItem objects are unequal: Student IDs are " + gradeItem1 + " and " + gradeItem2);
    }
    System.out.println("");
}// End of main   

  //*****************************************************************************
 
 // Test 2a (continued)
 public static void processStudentData (String[] splitString) throws IllegalArgumentException {
      int numberOfItems = splitString.length;
      
      for(int i = 0; i < numberOfItems; i++) {
        if(splitString[1].equals("ADD")) {
         student2 = new Student(splitString[2], splitString[3], splitString[4], splitString[5]);
        }
            else {
                     throw new IllegalArgumentException("Does not contain 'ADD' in the text file.");
            }
            try {
                   student2 = new Student(splitString[2], splitString[3], splitString[4], splitString[5]);
            }
            catch(IllegalArgumentException e) {
                    System.err.println("one of the arguments in the student constructor has an illegal argument.");
            } 
         } // End of for         
   } // End of processStudentData
   
 // Test 2b: Scans the second line of the input file and displays a message
   
   public static void processGradeItemData (String[] splitString) {
      System.out.println("Running Test 2b:");
      if(splitString[1].equals("ADD")) {
         gradeItem2 = new GradeItem (splitString[3], Integer.parseInt(splitString[2]), splitString[4],
                                                                   splitString[5], splitString[6], Integer.parseInt(splitString[7]),
                                                                   Integer.parseInt(splitString[8]));
         } // End of if
         else {
            throw new IllegalArgumentException("Does not contain 'ADD' in the text file.");
         }
         try {
            gradeItem2 = new GradeItem (splitString[3], Integer.parseInt(splitString[2]), splitString[4], 
                                                                      splitString[5], splitString[6], Integer.parseInt(splitString[7]), 
                                                                       Integer.parseInt(splitString[8]));
         }
         catch(IllegalArgumentException e) {
            System.err.println("One of the arguments in the gradeItem constructor has an illegal argument.");
         }     
   } // End of processGradeItemData
   
} // End of class 