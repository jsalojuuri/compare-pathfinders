package copa.util;

/**
 * Self made version of Java ArrayList data structure. Only methods that are required in this application are implemented.
 * @author salojuur
 * @param <T> Type of element that is defined when ArrayList instance is created.
 */
public class ArrayList<T> {
    
    private T[] values;
    private int size;
    
    public ArrayList() {
        this.values = (T[]) new Object[5];
        this.size = 0;
    }
    
    /**
     * Returns size of the list
     * @return ArrayList size
     */
    public int size() {
        return this.size;
    }
    
    /**
     * Doubles array size of values
     */
    public void doubleValueArraySize() {
        T[] newValues = (T[]) new Object[this.values.length * 2];
        for (int i = 0; i < this.values.length; i++) {
            newValues[i] = this.values[i];
        }
        this.values = newValues;
    }
    
    /**
     * Adds new value to list
     * @param value new value to be added to list
     */
    public void add(T value) {
        if (this.values.length == this.size) {
            doubleValueArraySize();
        }
        this.values[this.size++] = value;
    }
    
    /**
     * Gets a value from list
     * @param i value index in list
     * @return value returned
     */
    public T get(int i) {
        if (this.size < i || i < 0) {
            throw new ArrayIndexOutOfBoundsException("Given index " + i + "is not within allowed range of [0," + this.size + "]");
        }
        return this.values[i];
    }
    
}
