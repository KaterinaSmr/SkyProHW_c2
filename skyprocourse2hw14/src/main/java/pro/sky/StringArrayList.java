package pro.sky;

import java.util.Arrays;

public class StringArrayList implements StringList{
    private String[] data;
    private int capacity;
    private static final int DEFAULT_CAPACITY = 10;
    private static final float GROW_RATE = 1.25f;
    private int size;

    public StringArrayList(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        data = new String[capacity];
    }

    public StringArrayList() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public String add(String item) {
        if (size >= capacity){
            growArray();
        }
        if (item == null){
            throw new StringArrayListNullItemNotAllowed();
        }
        data[size] = item;
        size++;
        return item;
    }

    @Override
    public String add(int index, String item) {
        if (index >= size){
            throw new StringArrayListIndexOutOfBoundsException(String.valueOf(index));
        }
        if (item == null){
            throw new StringArrayListNullItemNotAllowed();
        }
        if (size >= capacity){
            growArray();
        }
        shiftArray(index);
        data[index] = item;
        return item;
    }

    @Override
    public String toString(){
        return Arrays.toString(data) + "\n" +
                "size = " + this.size() +"\n" +
                "capacity = " + this.capacity;
    }

    private void shiftArray(int startPosition){
        for (int i = size; i > startPosition ; i--) {
            data[i] = data[i-1];
        }
        size++;
    }
    private void shiftBackArray(int startPosition){
        for (int i = startPosition; i < size - 1; i++) {
            data[i] = data[i+1];
        }
        data[size-1] = null;
        size--;
    }

    private void growArray(){
        capacity = (int) (capacity * GROW_RATE) + 1;
        data = Arrays.copyOf(data, capacity);
    }

    @Override
    public String set(int index, String item) {
        if (index >= size){
            throw new StringArrayListIndexOutOfBoundsException(String.valueOf(index));
        }
        if (item == null){
            throw new StringArrayListNullItemNotAllowed();
        }
        String temp = data[index];
        data[index] = item;
        return temp;
    }

    @Override
    public String remove(String item) {
        int index = indexOf(item);
        if (index < 0){
            throw new StringArrayListElementNotFoundException(item);
        }
        if (item == null){
            throw new StringArrayListNullItemNotAllowed();
        }
        return remove(index);
    }

    @Override
    public String remove(int index) {
        if (index >= size){
            throw new StringArrayListIndexOutOfBoundsException(String.valueOf(index));
        }
        String item = data[index];
        shiftBackArray(index);
        return item;
    }

    @Override
    public boolean contains(String item) {
        if (item == null){
            throw new StringArrayListNullItemNotAllowed();
        }
        return indexOf(item) >= 0;
    }

    @Override
    public int indexOf(String item) {
        if (item == null){
            throw new StringArrayListNullItemNotAllowed();
        }
        for (int i = 0; i < size; i++) {
            if (data[i].equals(item)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        if (item == null){
            throw new StringArrayListNullItemNotAllowed();
        }
        for (int i = size-1; i >= 0; i--) {
            if (data[i].equals(item)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        if (index >= size){
            throw new StringArrayListIndexOutOfBoundsException(String.valueOf(index));
        }
        return data[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if (otherList == null){
            throw new StringArrayListIndexOutOfBoundsException("The list is null");
        }
        if (otherList instanceof StringArrayList) {
            return Arrays.equals(data, ((StringArrayList) otherList).data);
        }
        return false;
    }
    @Override
    public boolean equals(Object object) {
        if (object == null){
            throw new StringArrayListIndexOutOfBoundsException("The list is null");
        }
        if (object instanceof StringList) {
            return equals((StringList) object);
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        //        data = new String[capacity];
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        size = 0;
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(data,size);
    }
}
