/**
 * Grade Item class that tracks the student's information
 * 
 *@author Serena Zarate
 * @version 09/04/2019
 */
import java.util.Scanner; // Access the scanner class
import java.util.Arrays;   // Access the array class 
 
public class GradeItem {

   private String studentId;                 // Student Identification Number
   private int gradeItemId;                  // Grade Item Identification Number
   private String courseId;                  // Course Identification Number
   private String itemType;                 // Item Type
   String [] types = {"HW", "Quiz", 
                              "Class Work", 
                              "Test", "Final"};    // Item Types available
   private String date;                         // The date
   private int maxScore;                      // The maximum score
   private int actScore;                        // The actual score 
   
   // Start of Constructor
    public GradeItem (int gItemId, String sId, String cId, String type, 
                                 String date, int maxScore, int actScore)                           
                                  throws IllegalArgumentException {
      boolean isFound = false;
            
      if(isInvalid(gItemId)) {
         throw new IllegalArgumentException("GradeItem Id cannot be blank.");
         }
      
       if (isInvalid(sId)) {
         throw new IllegalArgumentException("Student Id cannot be blank.");
         }
      
       if(isInvalid(cId)) {
         throw new IllegalArgumentException("Course Id cannot be blank.");
         }
      
       if(isInvalid(type)) {
         throw new IllegalArgumentException("Item type cannot be blank.");
         }
      
      for (int i = 0; i < types.length; i++){
         if (types[i].equals(type)){
            isFound = true;
            break;
            } // End of if
         
         if (!isFound){
         throw new IllegalArgumentException("Item type entered is invalid." 
                                                                   + "Must be one of the few listed: " 
                                                                   + "'HW', 'Quiz', 'Class Work', 'Test', 'Final'");
            } // End of if
         } // End of for 

      if(isInvalid(date)) {
         throw new IllegalArgumentException("Date cannot be blank.");
         }
      
      if(isInvalid(maxScore)) {
         throw new IllegalArgumentException("Maximum score cannot be blank.");
         }
      
      if(isInvalid(actScore)) {
         throw new IllegalArgumentException("Actual score cannot be blank.");
         }
         
       if(gradeItemId <= 0) {
         throw new IllegalArgumentException("GradeItem Id must be greater than zero." + 
                                                                     "For example, GradeItem = 5 instead of " 
                                                                     + gradeItemId);
         }
      
      if(maxScore <= 0) {
         throw new IllegalArgumentException
         ("Maximum score must be greater than zero.");
         }
      
      if(actScore < 0 || actScore >= maxScore) {
         throw new IllegalArgumentException("Actual score: " + actScore 
                                                                   + "must be in the range of 0 to maximum score = " 
                                                                   + maxScore);
         }
                              
         this.gradeItemId = gItemId;                                        
         this.studentId = sId;
         this.courseId = cId;
         this.itemType = type;
         this.date = date;
         this.maxScore = maxScore;
         this.actScore = actScore;     
              
      } // End of constructor

   //Start of get methods
  public int getGradeItemId() {
      return gradeItemId;
   }
   public String getStudentId() {
      return studentId;
   }
   public String getCourseId() {
      return courseId;
   }
   public String getItemType() {
      return itemType;
   }
   public String getDate() {
      return date;
   }
   public int getMaxScore() {
      return maxScore;
   }
   public int getActScore() {
      return actScore;
   }
   // End of get methods
   
   // Start of toString method
   public String toString() {
      String gradeItemInfo;
      gradeItemInfo = " GradeItem{ gradeItemId=" + gradeItemId +",studentId= " + studentId +
                                 " courseId=" + courseId + ",type= " + itemType + " ,date= " 
                                 + date + ",maxScore=" + maxScore + "actualScore=" + actScore + "}";
         return gradeItemInfo;
   } // End of toString method
   
   // Start of equals method
   public boolean equal(GradeItem other) {
      boolean result = false;
      if(studentId.equals(other.studentId) && gradeItemId == other.gradeItemId 
         && courseId.equals(other.courseId) && itemType.equals(other.itemType)
         && date.equals(other.date) && maxScore == other.maxScore 
         && actScore == other.actScore){
            result = true;
         }
        return result;
   } // End of equals method
    
    // Checks if the String fields are invalid  
    private boolean isInvalid(String fieldName) {
      return (fieldName == null || fieldName.equals(""));
   } // End of isInvalid
   
   // Checks if the int fields are invalid
   private boolean isInvalid(int fieldNumber) {
      return false;
   }// End of isInvalid
  
} // End of class