public class ArrayList {

    // Attributes
    private int[] array; 
    private int index;
    
    public ArrayList() {
        array = new int[3]; 
        index = 0;            // Points to the next empty spot (also represents size)
    }

    
    private void resize() {
        int[] newArr = new int[array.length * 2];
        for (int i = 0; i < array.length; i++) {
            newArr[i] = array[i]; // Deep copy
        }
        array = newArr; // rename array
    }

   
    public void insertAtPosition(int value, int position) { 
        
        if (position < 0 || position > index) {
            System.out.println("Error: Invalid position");
            return;
        }
        
        
        if (index == array.length) {
            resize();
        }
        
        // Shift elements to the right to make room
        for (int i = index; i > position; i--) {
            array[i] = array[i - 1];
        }
        
        // Insert value and update end pointer
        array[position] = value;
        index++;
    }

    
    public void insertLast(int value) {
        
        insertAtPosition(value, index);
    }

    
    public void deleteAtPosition(int position) {  
        
        if (position < 0 || position >= index) {
            System.out.println("Error: Invalid position");
            return;
        }
        
        // Shift elements left to overwrite the deleted item 
        for (int i = position; i < index - 1; i++) {
            array[i] = array[i + 1];
        }
        
        // Update the end pointer 
        index--;
    }

    // to delete the last element
    public void deleteLast() {
        if (index > 0) {
            deleteAtPosition(index - 1);
        }
    }

    
    public void print() {
        
        System.out.print("[ ");
        for (int i = 0; i < index; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("]");
    }

    public int size() {
        return index; // Returns how many elements are in the list 
    }

    public int search(int target) {
        // Linear search 
        for (int i = 0; i < index; i++) {
            if (array[i] == target) {
                return i; // Return index if found 
            }
        }
        return -1; // Return -1 if not found 
    }
}