/**
 *	Student class that holds the student's information
 *	
 *	@author Serena	Zarate
 *	@version	09/04/2019
 */
 
import java.util.Scanner; // Gives access to the Scanner	class

public class Student	{
	
	private String	studentId;		      // Student Identification number
	private String	firstName;			 // Student's first name
	private String	lastName;			 // Student's last name
	private String	studentEmail;		 // Student's email address
	private String     str = "@";			// The special char in the email
	
	//	Start of constructor
	public Student	(String id,	String fName, String	lName, String email)	
										  throws IllegalArgumentException {
										  
		if(isInvalid(id)) {
			throw	new IllegalArgumentException("Student Id cannot be blank");
		}
		
		if(isInvalid(fName))	{
			throw	new IllegalArgumentException("First name cannot be blank");
		}
		
		 if(isInvalid(lName)) {
			throw	new IllegalArgumentException("Last name cannot be blank");
		}
		
		 if(isInvalid(email)) {
			throw	new IllegalArgumentException("Email address cannot be blank");
		}
		
		if(!email.contains("@")) {
			throw	new IllegalArgumentException("Email does not have '@' sign");
		}
			this.studentId	= id;	
			this.firstName	 =	fName;
			this.lastName = lName;
			this.studentEmail	= email;		  
	}// End of constructor	
	
	//	Start of get methods	  
	public String getStudentId() {
		return studentId;	  
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getStudentEmail() {
		return studentEmail;
	}
	//	End of get methods  
	
	//	Start of toString
	public String toString() {
	  String	studentInfo;
	  studentInfo = "Student { studentId = " + studentId 
										+ " ,  firstName  =" + firstName 
										+ " ,  lastName  =  "	+ lastName 
										+ " ,  emailAddress  =  " +	studentEmail +	"}";
	  return	studentInfo;
	} // End of toString
  
	//	Start of equals method
	public boolean equals( Student other) {
		boolean results = false;
		if(this.studentId.equals(other.getStudentId()) && this.firstName.equals(other.getFirstName()) && 
			this.lastName.equals(other.getLastName()) && this.studentEmail.equals(other.getStudentEmail())){
				results = true;
			}
			return results;
	} // End of equals method
	
		 @Override 
		 public int	hashCode() {
			final	int prime =	31;
			int result = 1;
			result = prime * result + ((firstName == null) ? 0 
			  : firstName.hashCode());
			  
			result = prime * result + ((lastName == null) ? 0	
			  : lastName.hashCode());
			  
			result = prime * result + ((studentEmail == null) ? 0 
			  : studentEmail.hashCode());
			  
			return result = prime * result + ((studentId == null) ? 0 
			  : studentId.hashCode());
		 }	//	End of hashCode
	
	 // Checks to see if each instance equals what's entered	in	by the user
		@Override
		 public boolean equals(Object obj) {
			if	(this	== obj) {
				return true;
			}
			if	(obj == null) {
				return false;
			}
			if	(!(obj instanceof Student)) {
				return false;
			}
			Student other = (Student) obj;
			if	(firstName == null) {
				if(other.getFirstName() != null) {
					return false;
				}
			} else if (!firstName.equals(other.getFirstName())) {
				return false;
			}
			if	(lastName == null) {
				if(other.getLastName() !=	null)	{
					return false;
					}
				} else if(!lastName.equals(other.getLastName())) {
					return false;
				}
			if	(studentEmail == null) {
				if	(other.getStudentEmail() != null) {
					return false;
				}
			} else if (!studentEmail.equals(other.getStudentEmail())) {
				return false;
			}
			if	(studentId == null) {
				if	(other.getStudentId() != null) {
					return false;
				}
			} else if (!studentId.equals(other.getStudentId())) {
				return false;
			}
			return true;
		 } // End of equals method
 
	  // Checks if a field is invalid 
	  private boolean	isInvalid(String fieldName) {
		return (fieldName	==	null || fieldName.equals(""));
	} // End of	isInvalid
	
} // End of class