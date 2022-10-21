package com.example.homework2_15;

import com.example.homework2_15.exeptions.ElementNotFoundException;
import com.example.homework2_15.exeptions.ListFromSizeException;
import com.example.homework2_15.exeptions.RequestNullException;
import com.example.homework2_15.service.IntegerList;
import com.example.homework2_15.service.IntegerListImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IntegerListImplTest {
    private IntegerList list = new IntegerListImpl();

    @AfterEach
    public void afterEach() {
        list = new IntegerListImpl();
    }

    //add(Integer item);
    @Test
    void returnCorrectValueAddTest1() {
        Integer expected = list.add(1);
        Assertions.assertEquals(expected, 1);
    }

    @Test
    void returnCorrectValueAddTest2() {
        list.add(2);
        Integer[] expectedResult = new Integer[]{2};
        Integer[] result = list.toArray();
        assertArrayEquals(expectedResult, result);
    }

    @Test
    void returnRequestNullExceptionAddTest3() {
        assertThrows(RequestNullException.class, () -> list.add(null));
    }

    @Test
    void returnCorrectValueAddWithIndexTest1() {
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1, 3);
        Integer[] result = list.toArray();
        Integer[] expectedResult = new Integer[]{1, 3, 1, 1};
        assertArrayEquals(expectedResult, result);
    }

    @Test
    void returnRequestNullExceptionAddWithIndexTest2() {
        list.add(1);
        list.add(1);
        assertThrows(RequestNullException.class, () -> list.add(1, null));
    }

    @Test
    void returnCorrectValueAddWithIndexTest3() {
        list.add(1);
        list.add(1, 2);
        Integer[] result = list.toArray();
        Integer[] expectedResult = new Integer[]{1, 2};
        assertArrayEquals(expectedResult, result);
    }

    @Test
    void returnListFromSizeExceptionAddWithIndexTest4() {
        list.add(1);
        list.add(1);
        assertThrows(ListFromSizeException.class, () -> list.add(7, 2));
    }

    @Test
    void returnCorrectValueSetTest1() {
        list.add(1);
        list.add(1);
        list.add(1);
        list.set(1, 2);
        Integer[] expectedResult = new Integer[]{1, 2, 1};
        Integer[] result = list.toArray();
        assertArrayEquals(expectedResult, result);
    }

    @Test
    void returnListFromSizeExceptionSetTest2() {
        list.add(1);
        list.add(1);
        assertThrows(ListFromSizeException.class, () -> list.set(7, 2));
    }

    @Test
    void returnCorrectValueRemoveTest1() {
        list.add(1);
        list.add(2);
        list.add(1);
        list.removeItem(2);
        Integer[] expectedResult = new Integer[]{1, 1};
        Integer[] result = list.toArray();
        assertArrayEquals(expectedResult, result);
    }

    @Test
    void returnElementNotFoundExceptionRemoveTest2() {
        list.add(1);
        list.add(1);
        assertThrows(ElementNotFoundException.class, () -> list.removeItem(2));
    }

    @Test
    void returnCorrectValueRemoveWithIndexTest1() {
        list.add(1);
        list.add(2);
        list.add(1);
        list.remove(1);
        Integer[] expectedResult = new Integer[]{1, 1};
        Integer[] result = list.toArray();
        assertArrayEquals(expectedResult, result);
    }

    @Test
    void returnListFromSizeExceptionRemoveTest2() {
        list.add(1);
        list.add(1);
        assertThrows(ListFromSizeException.class, () -> list.remove(7));
    }

    @Test
    void returnCorrectValueSortTest1() {
        list.add(5);
        list.add(2);
        list.add(1);
        list.add(4);
        list.add(3);
        list.sort();
        Integer[] expectedResult = new Integer[]{1, 2, 3, 4, 5};
        Integer[] result = list.toArray();
        assertArrayEquals(expectedResult, result);
    }

    @Test
    void returnPositiveContainsTest1() {
        list.add(7);
        list.add(9);
        list.add(1);
        list.add(0);
        list.add(3);
        list.add(4);
        list.add(1);
        list.add(2);
        list.add(5);
        assertTrue(list.contains(2));
    }

    @Test
    void returnNegativeContainsTest2() {
        list.add(1);
        list.add(2);
        list.add(1);
        assertFalse(list.contains(5));
    }

    @Test
    void returnCorrectIndexItemTest1() {
        list.add(1);
        list.add(2);
        list.add(1);
        assertEquals(list.indexOf(2), 1);
    }

    @Test
    void returnMinusOneIfThereAreNoItemIndexTest1() {
        list.add(1);
        list.add(2);
        list.add(1);
        assertEquals(list.indexOf(3), -1);
    }

    @Test
    void returnCorrectIndexItemLastIndexTest1() {
        list.add(1);
        list.add(2);
        list.add(1);
        assertEquals(list.lastIndexOf(1), 2);
    }

    @Test
    void returnMinusOneIfThereAreNoItemLastIndexTest1() {
        list.add(1);
        list.add(2);
        list.add(1);
        assertEquals(list.lastIndexOf(3), -1);
    }

    @Test
    void returnCorrectValueGetTest1() {
        list.add(1);
        list.add(2);
        list.add(1);
        Assertions.assertEquals(list.get(1), 2);
    }

    @Test
    void returnListFromSizeExceptionGetTest2() {
        list.add(1);
        list.add(1);
        assertThrows(ListFromSizeException.class,
                () -> list.get(7));
    }

    @Test
    void returnTrueIfStringListsAreEqualsEqualsTest1() {
        list.add(1);
        list.add(2);
        list.add(1);
        IntegerList expectedList = new IntegerListImpl();
        expectedList.add(1);
        expectedList.add(2);
        expectedList.add(1);
        assertTrue(list.equals(expectedList));
    }

    @Test
    void returnFalseIfStringListsAreNotEqualsEqualsTest2() {
        list.add(2);
        list.add(2);
        list.add(1);
        IntegerList expectedList = new IntegerListImpl();
        expectedList.add(1);
        expectedList.add(2);
        expectedList.add(1);
        assertFalse(list.equals(expectedList));
    }

    @Test
    void returnRequestNullExceptionEqualsTest3() {
        list.add(1);
        list.add(1);
        IntegerList expectedList = null;
        assertThrows(RequestNullException.class, () -> list.equals(null));
    }

    @Test
    void returnCorrectSizeTest1() {
        list.add(1);
        list.add(1);
        list.add(1, 1);
        list.set(1, 1);
        list.remove(1);
        assertEquals(list.size(), 2);
    }

    @Test
    void returnTrueIsEmptyTest1() {
        assertTrue(list.isEmpty());
    }

    @Test
    void returnFalseIsEmptyTest2() {
        list.add(5);
        assertFalse(list.isEmpty());
    }

    @Test
    void removeAllItemsAndDecreaseSizeClearTest() {
        list.add(1);
        list.add(2);
        list.add(1);
        list.clear();
        Integer[] result = list.toArray();
        Integer[] expectedResult = new Integer[]{};
        assertArrayEquals(expectedResult, result);
    }

    @Test
    void returnCorrectValueToArrayTest1() {
        Integer[] expectedResult = new Integer[]{};
        Integer[] result = list.toArray();
        assertArrayEquals(expectedResult, result);
    }

    @Test
    void returnCorrectValueToArrayTest2() {
        list.add(1);
        Integer[] expectedResult = new Integer[]{1};
        Integer[] result = list.toArray();
        assertArrayEquals(expectedResult, result);
    }

    @Test
    void correctlyTransferElementValuesToTheNewArrayWhenTheStorageIncremented() {
        for (int i = 0; i < 11; i++) {
            Integer expected = list.add(1);
        }
        Integer[] expectedResult = new Integer[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        Integer[] result = list.toArray();
        assertArrayEquals(expectedResult, result);
    }
}
