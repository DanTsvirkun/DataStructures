import java.util.Arrays;

public class MyStack<E> {
    private E[] instance;

    MyStack() {
        instance = (E[]) new Object[0];
    }

    public E push(E value) {
        E[] newInstance = (E[]) new Object[instance.length + 1];

        for (int i = 0; i < instance.length; i++) {
            newInstance[i] = instance[i];
        }

        newInstance[newInstance.length - 1] = value;

        instance = newInstance;

        return value;
    }

    public E remove(int index) throws IllegalArgumentException {
        if (index < 0 || index > size() - 1) {
            throw new IllegalArgumentException("Index out of bounds");
        }

        E itemToDelete = instance[index];

        E[] newInstance = (E[]) new Object[instance.length - 1];

        for (int i = 0, j = 0; i < instance.length; i++) {
            E currentItem = instance[i];

            if (itemToDelete != currentItem) {
                newInstance[j++] = currentItem;
            }
        }

        instance = newInstance;

        return itemToDelete;
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

        return instance[size() - 1];
    }

    public E pop() {
        if (size() == 0) {
            return null;
        }

        E firstItem = instance[size() - 1];

        E[] newInstance = (E[]) Arrays.copyOfRange(instance, 0, size() - 1);

        instance = newInstance;

        return firstItem;
    }
}
