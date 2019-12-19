package copa.util;

/**
 * Self made version of Java ArrayDeque data structure. Only methods that are required in this application are implemented.
 * @author salojuur
 * @param <T> Type of element that is defined when ArrayDeque instance is created.
 */
public class ArrayDeque<T> {
    
    private int size;
    private T[] values;
    
    public ArrayDeque() {
        this.size = 0;
        this.values = (T[]) new Object[10];
    }
    
    /** 
     * Returns the amount of values in queue 
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
     * Adds new value to the end of queue
     * @param value value to be added
     */
    public void add(T value) {
        if (this.values.length == this.size + 1) {
            doubleArrayLength();
        }
        this.size++;
        this.values[this.size] = value;
    }
    
    /**
     * Returns the first added value from queue and deletes it from the queue
     * @return First value of the queue
     */
    public T poll() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("Queue is empty - can't poll anymore");
        }
        T firstValue = this.values[1];
        decreaseValuesArraySizeByOne();
        return firstValue;
    }
    
    /** 
     * Decreases value of size and indexes in values array by one
     */
    private void decreaseValuesArraySizeByOne() {
        int index = 1;
        while (index < this.size) {
            this.values[index] = this.values[index + 1];
            index++;
        }
        size--;
    }
    

    
}
