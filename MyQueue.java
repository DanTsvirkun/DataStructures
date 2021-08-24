import java.util.Arrays;

public class MyQueue<E> {
    private E[] instance;

    MyQueue(int size) throws IllegalArgumentException {
        if (size < 0) {
            throw new IllegalArgumentException("Size can't be less than 0");
        }
        instance = (E[]) new Object[size];
    }

    MyQueue() {
        this(0);
    }

    public boolean add(E value) {
        E[] newInstance = (E[]) new Object[instance.length + 1];

        for (int i = 0; i < size(); i++) {
            newInstance[i] = instance[i];
        }

        newInstance[newInstance.length - 1] = value;

        instance = newInstance;

        return true;
    }

    public boolean remove(int index) {
        if (index < 0 || index > size() - 1) {
            return false;
        }

        E itemToDelete = instance[index];

        E[] newInstance = (E[]) new Object[instance.length - 1];

        for (int i = 0, j = 0; i < size(); i++) {
            E currentItem = instance[i];

            if (itemToDelete != currentItem) {
                newInstance[j++] = currentItem;
            }
        }

        instance = newInstance;

        return true;
    }

    public void clear() {
        instance = (E[]) new Object[0];
    }

    public int size() {
        return instance.length;
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

        E[] newInstance = (E[]) Arrays.copyOfRange(instance, 1, instance.length);

        instance = newInstance;

        return firstItem;
    }
}
