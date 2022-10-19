package pro.sky;

import java.util.Arrays;

public class IntegerArrayList implements IntegerList {
    private Integer[] data;
    private int capacity;
    private static final int DEFAULT_CAPACITY = 10;
    private static final float GROW_RATE = 1.25f;
    private int size;

    public IntegerArrayList(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        data = new Integer[capacity];
    }

    public IntegerArrayList() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public Integer add(Integer item) {
        if (size >= capacity){
            growArray();
        }
        if (item == null){
            throw new IntegerArrayListNullItemNotAllowed();
        }
        data[size] = item;
        size++;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        if (index >= size){
            throw new IntegerArrayListIndexOutOfBoundsException(String.valueOf(index));
        }
        if (item == null){
            throw new IntegerArrayListNullItemNotAllowed();
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
    public Integer set(int index, Integer item) {
        if (index >= size){
            throw new IntegerArrayListIndexOutOfBoundsException(String.valueOf(index));
        }
        if (item == null){
            throw new IntegerArrayListNullItemNotAllowed();
        }
        Integer temp = data[index];
        data[index] = item;
        return temp;
    }

    @Override
    public Integer remove(Integer item) {
        int index = indexOf(item);
        if (index < 0){
            throw new IntegerArrayListElementNotFoundException(String.valueOf(item));
        }
        if (item == null){
            throw new IntegerArrayListNullItemNotAllowed();
        }
        return remove(index);
    }

    @Override
    public Integer remove(int index) {
        if (index >= size){
            throw new IntegerArrayListIndexOutOfBoundsException(String.valueOf(index));
        }
        Integer item = data[index];
        shiftBackArray(index);
        return item;
    }

    @Override
    public boolean contains(Integer item) {
        if (item == null){
            throw new IntegerArrayListNullItemNotAllowed();
        }
        return indexOf(item) >= 0;
    }

    @Override
    public int indexOf(Integer item) {
        insertionSorting(data);
        return binarySearch(item);
//        if (item == null){
//            throw new IntegerArrayListNullItemNotAllowed();
//        }
//        for (int i = 0; i < size; i++) {
//            if (data[i].equals(item)){
//                return i;
//            }
//        }
//        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        if (item == null){
            throw new IntegerArrayListNullItemNotAllowed();
        }
        for (int i = size-1; i >= 0; i--) {
            if (data[i].equals(item)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        if (index >= size){
            throw new IntegerArrayListIndexOutOfBoundsException(String.valueOf(index));
        }
        return data[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        if (otherList == null){
            throw new IntegerArrayListIndexOutOfBoundsException("The list is null");
        }
        if (otherList instanceof IntegerArrayList) {
            return Arrays.equals(data, ((IntegerArrayList) otherList).data);
        }
        return false;
    }
    @Override
    public boolean equals(Object object) {
        if (object == null){
            throw new IntegerArrayListIndexOutOfBoundsException("The list is null");
        }
        if (object instanceof IntegerList) {
            return equals((IntegerList) object);
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
    public Integer[] toArray() {
        return Arrays.copyOf(data,size);
    }

    private Integer[] insertionSorting(Integer[] arr) {
        for (int i = 1; i < size; i++) {
            Integer temp = arr[i];
            Integer j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
        return arr;
    }

    private int binarySearch(Integer num){
        return binarySearch(num, 0, size-1, data);
    }

    private int binarySearch(Integer num, int begin, int end, Integer[] arr) {
        if (num < arr[begin] || num > arr[end]){
            return -1;
        }
        int mid = (begin + end)/2; //
        if (arr[mid] == num){
            return mid;
        }
        if (arr[mid] < num){
            return binarySearch(num, mid + 1, end, arr);
        }
        return binarySearch(num, begin, mid, arr);
    }


}
