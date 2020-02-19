/**
 * Java implementation to convert infix expression to postfix using stack class
 * Selamawit Abdo, Busra Ozdemir, and Serena Zarate
 * Stack Class
 * jGrasp
 * Cupidity: Intense desire for riches and wealth
 * "If you spend too much time thinking about a thing, you'll never get it done."
 * - Bruce Lee (1940-1973)
 *@author Serena Zarate, Selamawit Abdo, and Busra Ozdemir
 *@version Project 5
 *@class SerenaZarate_05
 */
import java.util.EmptyStackException;

public class Stack<T> implements StackInterface<T> {

     private T[] stack;		                                                   // Array of stack entries
	private int topIndex;	                                                   // Index of top entry
	private boolean initialized = false;                            // Initialized boolean
	private static final int DEFAULT_CAPACITY = 50;  // Default Capacity for stack
	private static final int MAX_CAPACITY = 10000;   // Maximum Capacity for stack

 //***********************************************
/**
* Creating a new stack
*/
   public Stack() {

	  @SuppressWarnings("unchecked")
      T[] tempStack = (T[])new Object[DEFAULT_CAPACITY];
	  stack = tempStack;
      topIndex = 0;
      initialized = true;
	} // End constructor

 //***********************************************
/**    
* Creates a stack that already has a capacity
*@param initial Capacity 
*/
   public Stack(int initialCapacity) {

		@SuppressWarnings("unchecked")
		T[] tempStack = (T[])new Object[initialCapacity];
		stack = tempStack;
		topIndex = 0;
		initialized = true;

	} // end constructor

 //***********************************************
/**
 * Adds a new entry to the top of this stack.
 * @param newEntry object to add to stack.
 */
	public void push(T newEntry) {

		stack[topIndex + 1] = newEntry;
		topIndex++;
	} // end push

//***********************************************
	/**
	 * Removes and returns the stack's top entry.
	 * @return either object at top of stack or, if stack is empty
	 * 	stack is empty before operation, null
	 */

	public T pop() {

		if(isEmpty()) {
			throw new EmptyStackException();
		} // End else
      
		else {

			T top = stack[topIndex];
			stack[topIndex] = null;
			topIndex--;
			return top;
		} // End else
	} // end pop

//***********************************************
 /**
  * Checks if the stack is empty.
  * @return true if the stack is empty.
  */

	public T peek() {
		if(isEmpty()) {
			throw new EmptyStackException();
		} // End if

		else {
			return stack[topIndex];
		} // End else
	} // end peek

//***********************************************
/**
  * Checks if the stack is empty.
  * @return true if the stack is empty
  */

	public boolean isEmpty() {
		return topIndex < 1;
	} // end isEmpty

 //***********************************************
/**
  * Removes all entries from the stack.
  */

	public void clear() {
		topIndex = 0;
	} // End of clear
 
} // End of Stack Class