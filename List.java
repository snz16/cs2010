public abstract class List<T> implements MyCollectionInterface<T>{
   
   private T[] list;
   private int numberOfEntries = 0;
   private static final int DEFAUL_CAPACITY = 25;

     /**
    * Adds a new entry to this collection
    * 
    * @param newItem The object to be added to the collection
    * @return True if the addition is successful, or false if not.
    */
    
   @Override 
   public boolean add (T newItem) {
      
        try{
             list[numberOfEntries + 1] = newItem;
             numberOfEntries++;
             return true;
        } // End try
        catch (Exception e) {
            
            System.err.println(e.getMessage());
            return false;
        } // End catch
   } // End add
   
   //************************************************************************

   /**
    * Removes one unspecified entry from the collection, if possible.
    *
    * @return Either the removed entry, if the removal was successful, or null.
    */
    @Override   
   public T remove () {
      T temp = null;
      
      if(isEmpty() == false && numberOfEntries >= 0) {
         temp = list[numberOfEntries];
         list[numberOfEntries] = null;
         numberOfEntries--;
      } // End if 
      return temp;
   } // End remove

   //************************************************************************

   /**
    * Removes one occurrence of a given entry from this collection.
    *
    * @param anEntry The entry to be removed.
    * @return true if the removal was successful, false if not.
    */
   @Override 
   public boolean remove (T anEntry) {
      boolean found = false;
      int position = 0;
      
      for(int i = 1; i <= numberOfEntries && found == false; i++) {
         if(list[i] == anEntry) {
            position = i;
            found = true;
         } // End if
      } //End for
      for(int i = position; i <= numberOfEntries; i++) {
         list[i] = list[i++];
      } // End for
      
      numberOfEntries--;
      
      return found;
   } // End remove

   //************************************************************************

   /**
    * Removes all entries from this collection.
    */
   @Override
   public void clear() {
   
      numberOfEntries = 0;
   } // End clear 

   //************************************************************************

   /**
    * Gets the current number of entries in this collection.
    *
    * @return The integer number of entries currently in the collection.
    */
    @Override
   public int getCurrentSize() {
      if(numberOfEntries <= 0) {
         return 0; 
      } // End if
      return numberOfEntries;
   } // End get

   //************************************************************************

   /**
    * Check to see if the collection is empty.
    *
    * @return True if the collection is empty, or false if not.
    */
   @Override
   public boolean isEmpty() {
      if(getCurrentSize() > 0) {
         return false;
      } // End if
      return true;
   } // End isEmpty

   //************************************************************************

   /**
    * Counts the number of times a given entry appears in this collection.
    *
    * @param anEntry The entry to be counted.
    * @return The number of times anEntry appears in the collection.
    */
   @Override
   public int getFrequencyOf(T anEntry) {
      int frequency = 0;
      
      for(int i = 0; i < numberOfEntries; i++) {
         if(list[i] == anEntry) {
            frequency++;
         } // End if
      } // End for
      return frequency;
   } // End getFrequencyOf

   //************************************************************************

   /**
    * Tests whether this collection contains a given entry.
    *
    * @param anEntry The entry to locate.
    * @return True if the collection contains anEntry, or false if not.
    */
   @Override
   public boolean contains (T anEntry){
      boolean found = false; 
      int index = 1;
      while(!found && (index <= numberOfEntries)) {
         if(list[index].equals(anEntry)) {
            found = true;
         } // End if
         index++;
      }// End for 
      return found;
   } // End contains

   //************************************************************************

   /**
    * Retrieves all entries that are in this collection.
    *
    * @return A newly allocated array of all the entries in the collection. 
    * Note: If the collection is empty, the returned array is empty.
    */
    public Object[] toArray (T[] result) { 
      for(int index = 0; index < numberOfEntries; index++) { 
         result[index] = list[index + 1];
      } // End for
      return result;
   } // End toArray 
}// End List