public class MyArrayList<E> {
    private E[] instance;

    MyArrayList(int size) throws IllegalArgumentException {
        if (size < 0) {
            throw new IllegalArgumentException("Size can't be less than 0");
        }
        instance = (E[]) new Object[size];
    }

    MyArrayList() {
        this(0);
    }

    public void add(E value) {
        E[] newInstance = (E[]) new Object[instance.length + 1];

        for (int i = 0; i < size(); i++) {
            newInstance[i] = instance[i];
        }

        newInstance[newInstance.length - 1] = value;

        instance = newInstance;
    }

    public E remove(int index) throws IllegalArgumentException {
        if (index < 0 || index > size() - 1) {
            throw new IllegalArgumentException("Index out of bounds");
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

        return itemToDelete;
    }

    public void clear() {
        instance = (E[]) new Object[0];
    }

    public int size() {
        return instance.length;
    }

    public E get(int index) throws IllegalArgumentException {
        if (index < 0 || index > size() - 1) {
            throw new IllegalArgumentException("Index out of bounds");
        }

        return instance[index];
    }
}
