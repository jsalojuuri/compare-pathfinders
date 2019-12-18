package copa.util;

import java.util.Comparator;

/** Self made version of Java PriorityQueue data structure. Only methods that are required in this application are implemented.
 * @author Jari Salojuuri
 * @param <T> Type of element that is defined when PriorityQueue instance is created.
 */
public class PriorityQueue<T> {
    
    private int size;
    private T[] values;
    private Comparator comparator;
    
    /**  
     * Constructor to initialise PriorityQueue object
     * @param comparator object that compares queue's values
     */
    public PriorityQueue(Comparator comparator) {
        this.size = 0;
        this.values = (T[]) new Object[5];
        this.comparator = comparator;
    }
    
    /** 
     * Returns the amount of value in queue 
     * @return queue size
     */
    public int size() {
        return this.size;
    }
    
    /**  
     * Checks if size is empty
     * @return true if queue size is 0, else false
     */
    public boolean isEmpty() {
        return this.size == 0;
    }
    
    /** Doubles array length */
    private void doubleArrayLength() {
        T[] newValues = (T[]) new Object[this.values.length * 2];
        for (int i = 0; i < this.values.length; i++) {
            newValues[i] = this.values[i];
        }
        this.values = newValues;
    }
    
    /** 
     * Swaps two indexes
     * @param index1 first index
     * @param index2 second index
     */
    private void swapIndex(int index1, int index2) {
        T t = this.values[index1];
        this.values[index1] = this.values[index2];
        this.values[index2] = t;
    }
    
    /** 
     * Finds right priority for given value. Swaps child and parent, if child has greater priority
     * @param lastChildIndex the last index that has a value set = size of values array
     * @param value value to be added in queue
     */
    private void findValuePriority(int lastChildIndex, T value) {
        this.values[lastChildIndex] = value;
        while (lastChildIndex > 1 && comparator.compare(this.values[getParentIndexOf(lastChildIndex)], this.values[lastChildIndex]) > 0) {
            swapIndex(lastChildIndex, getParentIndexOf(lastChildIndex));
            lastChildIndex = getParentIndexOf(lastChildIndex);
        }
    }
    
    /** 
     * Adds new value to queue
     * @param value value to be added
     */
    public void add(T value) {
        if (this.values.length == this.size + 1) {
            doubleArrayLength();
        }
        this.size++;
        findValuePriority(this.size, value);
    }
    
    /** 
     * Finds left child index based on given parent index
     * @param parentIndex parent index
     * @return left child index
     */
    private int getLeftChildIndexOf(int parentIndex) {
        return 2 * parentIndex;
    }
    
    /** 
     * Finds right child index based on given parent index
     * @param parentIndex parent index
     * @return right child index
     */
    private int getRightChildIndexOf(int parentIndex) {
        return 2 * parentIndex + 1;
    }
    
    /** 
     * Finds parent index based on given children index
     * @param childIndex parent index
     * @return parent index
     */
    private int getParentIndexOf(int childIndex) {
        return childIndex / 2;
    }
    
    /** 
     * Compares value in given index with its children and pushes it down if it is greater
     * @param index index to be checked 
     */
    private void pushDownValueOf(int index) {
        int leftChildIndex = getLeftChildIndexOf(index);
        int rightChildIndex = getRightChildIndexOf(index);
        int minIndex = index;
        
        if (leftChildIndex <= this.size && comparator.compare(this.values[leftChildIndex], this.values[minIndex]) < 0) {
            minIndex = leftChildIndex;
        }
        if (rightChildIndex <= this.size && comparator.compare(this.values[rightChildIndex], this.values[minIndex]) < 0) {
            minIndex = rightChildIndex;
        }
        if (minIndex != index) {
            swapIndex(index, minIndex);
            pushDownValueOf(minIndex);
        }
    }
    
    /** 
     * Polls minimum value from queue
     * @return minimum value
     */
    public T poll() {
        if (this.size < 1) {
            throw new ArrayIndexOutOfBoundsException("Queue is empty");
        }
        
        T minValue = this.values[1];
        this.values[1] = this.values[this.size];
        this.size--;
        pushDownValueOf(1);
        return minValue;
    }
}
