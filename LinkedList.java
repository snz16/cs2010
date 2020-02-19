public abstract class LinkedList<T> implements MyCollectionInterfaceProject04<T>{
   
   private T[] linkedList;
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
         Node newNode;
         Node firstNode; 
         
         newNode.setData(newItem);
         
         try {
               if(numberOfEntries == 0) {
                  firstNode = newNode;
               } // End if
               else {
                      newNode.next = firstNode;
                      firstNode = newNode;   
                } // End else
         } // End try
         
         catch (Exception e) {
             System.err.print("Unable to add to the list.");
             return false; 
         } // End catch
         return true;
   } // End add
   
   //************************************************************************

   /**
    * Adds a new entry to this collection at the given position 
    *
    * @param newItem the obejct to be added to the collection 
    * @param position the location where newItem will be inserted.
    * @return True if the addition is successful, or false if not.
    */
   public boolean add(T newItem, int position){
         if((position >= 1) && (position <= numberOfEntries + 1)){
            Node newNode = new Node (newItem);
            if(position == 1) {
               newNode.setNextNode(firstNode);
               firstNode = newNode; 
            } // End inner if
            else {
               Node nodeBefore = getNodeAt(position -1);
               Node nodeAfter = nodeBefore.getNextNode();
               newNode.setNextNode(nodeAfter);
               nodeBefore.setNextNode(newNode);
            } // End else
             numberOfEntries++;
             return true; 
         } // End if
         else {
            return false;
            throw new IndexOutOfBoundsException("Illegal position given to add operation.");
            } // End else
         } // End add

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
      
      
      for(int i = 0; i < linkedList.size();  i++) {
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
      return numberOfEntries == 0;
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
    public Object[] toArray () { 
    int index = 0; 
    Node currentNode = firstNode;
      while((index < numberOfEntries) && (currentNode != null)){
            result[index] = currentNode.getData();
            currentNode = currentNode.getNextNode();
            index++;
       } // End while
       return result;
   } // End toArray
   
}// End List