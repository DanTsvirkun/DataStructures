import java.util.Arrays;

public class MyQueue<E> {
    private E[] instance;
    private static final int DEFAULT_CAPACITY = 11;
    private int currentCapacity = DEFAULT_CAPACITY;
    private int index = -1;

    public MyQueue(int size) throws IllegalArgumentException {
        if (size < 0) {
            throw new IllegalArgumentException("Size can't be less than 0");
        }

        if(size == 0) {
            instance = (E[]) new Object[DEFAULT_CAPACITY];
        }

        instance = (E[]) new Object[size];
    }

    public MyQueue() {
        this(DEFAULT_CAPACITY);
    }

    public boolean add(E value) {
        index++;
        instance[index] = value;

        if (index == size() - 1) {
            currentCapacity *= 2;
            E[] newInstance = (E[]) new Object[currentCapacity];

            System.arraycopy(instance, 0, newInstance, 0, size());

            instance = newInstance;
        }

        return true;
    }

    public boolean remove(int index) {
        if (index < 0 || index > size() - 1) {
            return false;
        }

        instance[index] = null;
        this.index--;

        System.arraycopy(instance, index + 1, instance, index, size() - 1 - index);

        instance[this.index + 1] = null;

        return true;
    }

    public void clear() {
        instance = (E[]) new Object[0];
        index = -1;
        currentCapacity = DEFAULT_CAPACITY;
    }

    public int size() {
        return index + 1;
    }

    public E peek() {
        if (size() == 0) {
            return null;
        }

        return instance[0];
    }

    public E poll() {
        if (size() == 0) {
            return null;
        }

        E firstItem = instance[0];

        System.arraycopy(instance, 1, instance, 0, size() - 1);

        instance[index] = null;
        this.index--;

        return firstItem;
    }
}
