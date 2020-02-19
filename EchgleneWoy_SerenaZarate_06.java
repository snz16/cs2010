/**
 * EchgleneWoy_SerenaZarate_06 
 *
 * Project #6
 * Computer
 *  
 * Hugger-mugger: Chaotic and disorganized 
 *
 * "Why do anything unless it is going to be great?"
 *  - Peter Block
 *
 *@author Echglene Woy and Serena Zarate
 *@version Project 6
 *@class EchgleneWoy_SerenaZarate_06
 */
import java.util.Arrays;
import java.io.*;
import java.util.Scanner;

public class EchgleneWoy_SerenaZarate_06 {

       private static String INPUT_FILE_NAME = "2050 Project 06_Input.txt";             // Input File
       private static String OUTPUT_FILE_NAME = "SerenaZarate_06_Output1.txt";          // Shell Sort output file 
       private static String OUTPUT_FILE_NAME1 = "EchgleneWoy_06_Output2.txt";          // Quick Sort output file
      
       private static int length = 100;        // Array length of 100
       private static int array[];             // Int array used for unsorted  
       private static int[] sortedArray;       // Array used for sorted  
       private static PrintStream output;      // Converts output into bytes
      
       public static void main (String[] args) throws Exception {
            INPUT_FILE_NAME = "2050 Project 06_Input.txt";
            OUTPUT_FILE_NAME = "SerenaZarate_06_Output1.txt";
            
            processInput();
            shellSort(sortedArray);
            quickSort(sortedArray, 0, sortedArray.length - 1);
            generateReport();
               
       } // End main
//********************************************
	/**
	 * process input method will use scanner to read file 
     * then convert it to an integer array to be sorted.
	 */
    
	public static void processInput() throws IOException {
		int lineInput = 0;
		File file = new File(INPUT_FILE_NAME);
		Scanner fileReader;

      // Scans the file and return error if not found
		try {
			fileReader = new Scanner(file);
		} // End of try
         catch (FileNotFoundException e) {
			System.err.println(INPUT_FILE_NAME + " was not found.");
			return;
		} // End of catch

		array = new int[length];
		sortedArray = new int[length];
      
      // Reads the unspaced integers 
		while (fileReader.hasNextInt()) {
			array[lineInput] = fileReader.nextInt();
			sortedArray[lineInput] = array[lineInput];
			lineInput++;
		} // End of while loop
} // End of processInput method
   
//********************************************   
	/**
	 *  Shell sort method will compare each index that are a  
     *  specific number of spaces apart and then
  	 *  it will lower the gap until the gap is 1. 
     *
     * @param All random numbers that need to be sorted 
     *  are held in a integer array.
	 */
private static void shellSort (int[] a) {
   // gap is reduced after each pass until 
   // gap size is 1 making it an insertion sort
   int increment = a.length / 2;
   
   // 
   while (increment > 0) {
   // gap insertion sort for this gap size
   // first gap elements are in gapped order
   // keep adding one more element until entire array is gap sorted
         for (int i = increment; i < a.length; i++) {
            int h = i;
            int temp = a[i]; // makes a hole at position i
            // shift earlier gap-sorted elements up until the correct location for a[i] is found 
            while (h >= increment && a[h - increment] > temp) {
                  a[h] = a[h - increment]; 
                  h = h - increment;
            } // End while
            // put temp (the origial a[i]) in it's correct location
            a[h] = temp;
            
         } // End for
         
         if (increment == 2) {
            increment = 1; 
         } // End if
         else {
               increment *= (5.0 / 11);
         } // End else
      } // End while
   } // End shellSort

//********************************************
	/**
	 *  Sort method will compare each index with 
  	 *  one another and also compare them with the pivot.
	 */

private static void sort(int lowIndex, int highIndex) {

		int inner = lowIndex;
		int outer = highIndex;
		int pivot = array[inner + (outer - inner) / 2];

		while (inner <= outer) {
			while (array[inner] < pivot) {
				inner++;
			} // End while

			while (array[outer] > pivot) {
				outer--;
			} // End while

			if (inner <= outer) {
				swap(inner, outer);
				inner++;
				outer--;
			} // End if			
		} // End while
		
		if (inner < outer){
			sort(lowIndex, outer);
        } // End if 
		if (inner < outer) {
			sort(inner, highIndex);
		} // End if
      
	} // End sort 
//********************************************
   /**
	 *  Quick sort method will use the pivot to compare 
  	 *  integers on the left and right side of it. 
     *
     * @param int[] array
     * @param int start , int end
	 */
   public static void quickSort(int[] sortedArray, int start, int end) {
	   if (start < end) {
		   int partitionIndex = partition(sortedArray, start, end);
		   quickSort(sortedArray, start, partitionIndex -1);
		   quickSort(sortedArray, partitionIndex + 1, end);
	   } // End if
   } // End quickSort
//********************************************
   /**
    * partition method will find the pivot, increment through the array
    * and will swap elements in array depending on values compared
    * to pivot
    * 
    * @param int[] array
    * @param int start, int end
    * @return int 
    */
	public static int partition(int[] sortedArray, int start, int end) {
		int pivot = sortedArray[end];
		int i = start - 1;
		for (int j = start; j < end; j++) {
			// If current element is less than pivot
			if (sortedArray[j] < pivot) {
				i++;
				// Swap i and j
				int temp = sortedArray[i];
				sortedArray[i] = sortedArray[j];
				sortedArray[j] = temp;
			}
		}
		
		int temp = sortedArray[i + 1];
		sortedArray[i + 1] = sortedArray[end];
		sortedArray[end] = temp;
		
		return i + 1;
	}
//********************************************

 	/**
	 *  Swap method will  
  	 *  the new sorted array into the output file.
	 */
  private static void swap(int lowIndex, int highIndex) {

		int temp = array[lowIndex];
		array[lowIndex] = array[highIndex];
		array[highIndex] = temp;

	} // End swap 

//********************************************
	/**
	 *  This generateReport method with write 
  	 *  the new sorted array into the output file.
	 */

	public static void generateReport() throws IOException {

		File sorted1 = new File(OUTPUT_FILE_NAME);
      // Prints sorted array into OUTPUT_FILE_NAME
      try {
			output = new PrintStream(sorted1);

			for (int h = 0; h < sortedArray.length; h++) {

				if (h % 10 == 0 && h > 0) {
					output.println();
				} // End of if statement

				output.print(sortedArray[h] + " ");
			} // End of for loop
         
			output.close();
         
		} catch (IOException ex) {
			System.out.printf("Data could not be exported to filee $s\n", ex);
		} // End of catch

		File sorted2 = new File(OUTPUT_FILE_NAME1);
        
        // Prints quick sorted array into OUTPUT_FILE_NAME1
		try {
			output = new PrintStream(sorted2);

			for (int h = 0; h < sortedArray.length; h++) {
				if (h % 10 == 0 && h > 0) {
					output.println();
				} // End of if statement

				output.print(sortedArray[h] + " ");

			} // End of for loop

			output.close();

		} catch (IOException ex) {
			System.out.printf("Data could not be exported to file $s\n", ex);
		} // End of catch
	} // End of generateReport method
   
} // End class

