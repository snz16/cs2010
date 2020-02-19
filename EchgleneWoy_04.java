/*
 * EchgleneWoy_04 this class will read from input file and
 * will also generate a report to an output file.
 * Echglene Woy & Serena Zarate
 * Project 4
 * Eclipse
 * Philomath - a lover of learning 
 * "If you're not making mistakes, then you're
 * not making decisions." - Catherine Cook
 * 	
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class EchgleneWoy_04 {

   private static LinkedList<Student> listOfStudents;						                          // List class of students
	private static LinkedList<GradeItem> listOfGradeItem;					                // List class of GradeItem
	private final static String INPUT_FILE = "Project_04_Input01.txt";         // Name of the input file
	private final static String OUTPUT_FILE = "Project_04_Output01.txt"; // Name of the output file
			

	public static void main(String[] args) throws IOException {
		
		// Instantiating the Student and GradeItem as arrayLists
		listOfStudents = new ArrayList<Student>();
	    listOfGradeItem = new ArrayList<GradeItem>();
		
		processInput();
		System.out.println("-------------------------");
		generateReport();
		
		
	} // End main
	
	//********************************************************
	
	/**
	 * processInput - Open and read the input file 
	 * and depending on the data; will either call
	 * processStudentData() or processGradeItemData()
	 * @throws FileNotFoundException
	 * @return none
	 */
	
	public static void processInput() throws IOException {
		
		//Out statement let user know the input file is being read	
		Scanner scnr;
		String[] splitString;
		
		File file = new File("Project_04_Input01.txt");
		scnr = new Scanner(file);
		
		System.out.println("Reading data from " + file + "...");
		
		while(scnr.hasNextLine()) {
			String line = scnr.nextLine();
			splitString = line.split(",");

			if (splitString[0].contains("STUDENT")) {
				
				// Call processStudentData
				processStudentData(splitString);
				System.out.println("'STUDENT' has been found in the file.");

			} // End if
			
			else if (splitString[0].contains("GRADEITEM") ) {
				
				// Call processGradeItemData
				processGradeItemData(splitString);
				System.out.println("'GRADEITEM' has been found in the file.");
				
			} // End if
		} // End while
		
		// Close the file
		scnr.close();
			
	} // End processInput

	//********************************************************
	
	/**
	 * processStudentData - create a Student object, and 
	 * output to a file
	 * @param splitString - Array of type String with Student data
	 * @throws IllegalArgumentException
	 * @return none
	 */
	
	public static void processStudentData(String[] splitString) throws 
										IllegalArgumentException {
	
		Student student;
		
		if (splitString[1].equals("ADD")) {
			
			 // Create a new student object
			 student = new Student(splitString[2], splitString[3], splitString[4], splitString[5]);
		
			if (listOfStudents.contains(student)) {
				System.out.println("List already contains the Student data with student ID " + splitString[2]);
			} // End if
			else { 
				// Add method to add student to list
				listOfStudents.add(student);
				
			} // End else
				
		} // End if
		
		else if(splitString[1].equals("DEL")) {
			
			// Create a new student object
			 student =  new Student(splitString[2], splitString[3], splitString[4], splitString[5]);
			// Remove method to remove Student from list
			listOfStudents.remove(student);
			System.err.println("Student was removed in the list with Student ID " + splitString[2]);
		} // End if
		else if (!(splitString[1].equals("ADD")) && 
				!(splitString[1].equals("DEL"))) {
			throw new IllegalArgumentException("Line does not contain 'ADD' or 'DEL' " + splitString[1]);
			
		} // End else if
		
	} // End processStudentData
	
	//********************************************************
	
	/**
	 * processGradeItemData - Create a GradeItem object, and
	 * output to a file
	 * @param splitString - Array of type String with Student data
	 * @throws IllegalArgumentException
	 * @return none
	 */
	
	public static void processGradeItemData(String[] splitString) throws
	IllegalArgumentException {
		
		// Create a new gradeitem object
		GradeItem gradeItem = new GradeItem(splitString[3], Integer.parseInt(splitString[2]), splitString[4], 
						splitString[5],
						splitString[6], 
						Integer.parseInt(splitString[7]),
						Integer.parseInt(splitString[8]));
		
		if (splitString[1].contains("ADD")) {
			
			if (listOfGradeItem.contains(gradeItem)) {
				System.err.println("Grade Item list already contains grade Item data with Student ID: " 
									+ splitString[3] + "and Grade Item ID: " + splitString[2]);
				
			} else {
				// Add new grade Item object to list
				listOfGradeItem.add(gradeItem); 
				System.out.println("Grade Item with Grade Item Id " + splitString[2] +
							       " was added to the list.");
			} // End else	
			
		} // End if
		else if (splitString[1].contains("DEL")) {
			// Create grade item object?
			
			listOfGradeItem.remove(gradeItem);	
			System.err.println("Grade Item with Grade Item ID " + splitString[2] + 
					" has been deleted.");
		} // End if
		else if (!splitString[1].contains("DEL") && !splitString[1].contains("ADD")) {
			throw new IllegalArgumentException("Line does not contain 'ADD' or 'DEL' " + splitString[1]);
		} // End else if
		
		
	} // End processGradeItemData
	
   //********************************************************

	public static void generateReport() throws FileNotFoundException {
		

		// Temporary student and gradeitem objects to store their information
		Student tempStudent = new Student("Number", "First", "Last", "email@gmail.com");
		GradeItem tempGradeItem = new GradeItem("studentID", 1, "course", "HW", "data", 100, 95);

		
		// Makes a new file to generate the report
		File OUTPUT_FILE = new File("Project_03_Output01.txt");
		PrintWriter outFile = new PrintWriter(OUTPUT_FILE);
		System.out.println("Generating report to output file " + OUTPUT_FILE);

		// Turning arraylist to array
		Object[] arrayOfStudents = listOfStudents.toArray();
		Object[] arrayOfGradeItem = listOfGradeItem.toArray();
		
		for (int i = 0; i < arrayOfStudents.length; i++) {
			
			// Declaring the score variables 
			int totalMaximumScore = 0;
			int totalActualScore = 0;
			
			if (arrayOfStudents[i] instanceof Student) {
			 tempStudent = (Student) arrayOfStudents[i];
			 
			 outFile.printf("\n%s %s %s %s", tempStudent.getStudentID(),
					 							   tempStudent.getFirstName(),
					 							   tempStudent.getLastName(),
					 							   tempStudent.getEmail());
			 outFile.println("\n");
			 outFile.println("   Grade Items");
			 
			 
			 for (int x = 0; x < arrayOfGradeItem.length; x++) {
				 
				 if (arrayOfGradeItem[x] instanceof GradeItem) {
					 tempGradeItem = (GradeItem) arrayOfGradeItem[x];
					 
					 if (tempStudent.getStudentID().equals(tempGradeItem.getStudentID())) {
						 
						 outFile.printf("   %s\t%s\t%s\t  %s\t%s\t%s", tempGradeItem.getGradeItemID(),
								 						 tempGradeItem.getCourseID(),
								 					     tempGradeItem.getItemType(),
						 									tempGradeItem.getDate(),
								 							tempGradeItem.getMaximumScore(),
								 							tempGradeItem.getActualScore());
								 										
						 outFile.println("\n");
					 } // End inner if
						 totalMaximumScore += tempGradeItem.getMaximumScore();
						 totalActualScore += tempGradeItem.getActualScore();
						 
				 } // End if
			 }// end inner-for loop
			 
			 // Calculating the grade percentage 
			 double percentGrade = ((double)totalActualScore / totalMaximumScore) * 100;
			 
			 outFile.print("\n");
			 outFile.println("=============================================================");
			 
			 //Prints max and actual scores
			 outFile.printf("   Total%35s\t%s\t", totalMaximumScore, totalActualScore);
			 outFile.printf("%.1f", percentGrade);
			 outFile.print("%");
			 outFile.println(" ");
			  
			} // end if
		}// End for loop
		 System.out.println("Report finished generating ... ");
		
		 // Close the output file
		 outFile.close();
		
	} // End generateReport

} // Main class