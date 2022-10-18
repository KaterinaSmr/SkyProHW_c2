package pro.sky;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class StringArrayListTest {
    private StringArrayList out;

    @BeforeEach
    public void setUp(){
        out = new StringArrayList();
        out.add("Hello");
    }

    @Test
    void shouldReturnItemWhenAddIsCalled() {
        assertEquals("Test", out.add("Test"));
        assertEquals(2,out.size());
    }

    @Test
    void shouldAddItemWhenArrayIsFull(){
        StringArrayList out = new StringArrayList(1);
        out.add("Test");
        out.add("Test1");
        assertEquals(2, out.size());
    }

    @Test
    void shouldReturnItemWhenAddWithIndexIsCalled() {
        assertEquals("Test", out.add(0, "Test"));
        assertEquals(2, out.size());
        assertEquals("Test", out.get(0));
    }

    @Test
    void shouldThrowExceptionWhenAddWithIncorrectIndexIsCalled(){
        assertThrows(StringArrayListIndexOutOfBoundsException.class, ()-> out.add(15, "Test"));
    }

    @Test
    void shouldSetNewValueWhenSetIsCalled() {
        out.add("world");
        out.set(1, "java");
        assertEquals("java", out.get(1));
    }

    @Test
    void shouldThrowExceptionWhenSetIsCalledWithIncorrectIndex(){
        assertThrows(StringArrayListIndexOutOfBoundsException.class, () -> out.set(22, "Test"));
    }

    @Test
    void shouldRemoveItemByIndexAndShiftArray() {
        out.add("Test");
        out.add("Test1");
        assertEquals("Test", out.remove(1));

        StringArrayList expected = new StringArrayList();
        expected.add("Hello");
        expected.add("Test1");
        assertEquals(expected, out);
    }

    @Test
    void shouldThrowExceptionWhenRemoveWithIncorrecteIndexIsCalled(){
        assertThrows(StringArrayListIndexOutOfBoundsException.class, ()->out.remove(12));
    }

    @Test
    void shouldRemoveItemByValueAndShiftArray() {
        out.add("Test");
        out.add("Test1");
        assertEquals("Test", out.remove("Test"));

        StringArrayList expected = new StringArrayList();
        expected.add("Hello");
        expected.add("Test1");
        assertEquals(expected, out);
    }

    @Test
    void shouldReturnTrueWhenContainsWithExistingItemIsCalled() {
        assertTrue(out.contains("Hello"));
    }

    @Test
    void shouldReturnFalseWhenContainsWithExistingItemIsCalled() {
        assertFalse(out.contains("Hello!"));
    }

    @Test
    void shouldReturnIndexOfExistingItem() {
        out.add("java");
        out.add("Hi");
        out.add("java");
        out.add("OOP");
        assertEquals(1, out.indexOf("java"));
    }
    @Test
    void shouldReturnMinusOneWhenIndexOfIsCalledForNonExistentItem() {
        assertEquals(-1, out.indexOf("java"));
    }

    @Test
    void shouldReturnLastIndexOfExistingItem() {
        out.add("java");
        out.add("Hi");
        out.add("java");
        out.add("OOP");
        assertEquals(3, out.lastIndexOf("java"));
    }

    @Test
    void shouldReturnItemByIndex() {
        out.add("java");
        out.add("Hi");
        assertEquals("java", out.get(1));
    }

    @Test
    void shouldThrowExceptionWhenGetIsCalledWithWrongIndex(){
        assertThrows(StringArrayListIndexOutOfBoundsException.class, ()-> out.get(3));
    }

    @Test
    void shouldReturnTrueForEqualStringArrayLists() {
        StringArrayList expected = new StringArrayList();
        expected.add("Hello");
        assertTrue(out.equals(expected));
    }
    @Test
    void shouldReturnFalseForInEqualStringArrayLists() {
        StringArrayList expected = new StringArrayList(9);
        expected.add("Hello");
        assertFalse(out.equals(expected));
    }

    @Test
    void shouldReturnSizeOfStringArrayList() {
        assertEquals(1, out.size());

        out.add("java");
        assertEquals(2, out.size());

        out.add("Hi");
        assertEquals(3, out.size());
    }

    @Test
    void shouldReturnTrueWhenEmpty() {
        out.remove(0);
        assertTrue(out.isEmpty());
    }
    @Test
    void shouldReturnFalseWhenNotEmpty() {
        assertFalse(out.isEmpty());
    }

    @Test
    void shouldBeClearedWhenClearIsCalled() {
        out.clear();
        assertEquals(0, out.size());
    }

    @Test
    void toArray() {
        out.add("java");
        assertArrayEquals(new String[]{"Hello", "java"}, out.toArray());
    }
}