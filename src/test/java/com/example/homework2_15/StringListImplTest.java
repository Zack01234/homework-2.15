package com.example.homework2_15;

import com.example.homework2_15.exeptions.ElementNotFoundException;
import com.example.homework2_15.exeptions.ListFromSizeException;
import com.example.homework2_15.exeptions.RequestNullException;
import com.example.homework2_15.service.StringList;
import com.example.homework2_15.service.StringListImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringListImplTest {
    private StringList list = new StringListImpl();

    @AfterEach
    public void afterEach() {
        list = new StringListImpl();
    }

    //add(String item);
    @Test
    void returnCorrectValueTest1() {
        String expected = list.add("1");
        Assertions.assertEquals(expected, "1");
    }

    @Test
    void returnCorrectValueTest2() {
        list.add("Test");
        String[] expectedResult = new String[]{
                "Test"};
        String[] result = list.toArray();
        assertArrayEquals(expectedResult, result);
    }

    @Test
    void returnNullRequestExceptionTest3() {
        assertThrows(RequestNullException.class,
                () -> list.add(null));
    }

    @Test
    void returnCorrectValueWithIndexTest1() {
        list.add("1");
        list.add("1");
        list.add("1");
        list.add(1, "3");
        String[] result = list.toArray();
        String[] expectedResult = new String[]{"1", "3", "1", "1"};
        assertArrayEquals(expectedResult, result);
    }

    @Test
    void returnNullRequestExceptionWithIndexTest2() {
        list.add("1");
        list.add("1");
        assertThrows(RequestNullException.class,
                () -> list.add(1, null));
    }

    @Test
    void returnOutOfListSizeExceptionWithIndexTest3() {
        list.add("1");
        list.add("1");
        assertThrows(ListFromSizeException.class,
                () -> list.add(7, "2"));
    }

    @Test
    void returnCorrectValueSetTest1() {
        list.add("1");
        list.add("1");
        list.add("1");
        list.set(1, "2");
        String[] result = list.toArray();
        String[] expectedResult = new String[]{"1", "2", "1"};
        assertArrayEquals(expectedResult, result);
    }

    @Test
    void returnOutOfListSizeExceptionSetTest2() {
        list.add("1");
        list.add("1");
        assertThrows(ListFromSizeException.class,
                () -> list.set(7, "2"));
    }

    @Test
    void returnCorrectValueRemoveTest1() {
        list.add("1");
        list.add("2");
        list.add("1");
        list.remove("2");
        String[] result = list.toArray();
        String[] expectedResult = new String[]{"1", "1"};
        assertArrayEquals(expectedResult, result);
    }

    @Test
    void returnElementNotFoundExceptionRemoveTest2() {
        list.add("1");
        list.add("1");
        list.add("1");
        assertThrows(ElementNotFoundException.class,
                () -> list.remove("3"));
    }

    @Test
    void returnCorrectValueRemoveWithIndexTest1() {
        list.add("1");
        list.add("2");
        list.add("1");
        list.remove(1);
        String[] result = list.toArray();
        String[] expectedResult = new String[]{"1", "1"};
        assertArrayEquals(expectedResult, result);
    }

    @Test
    void returnOutOfListSizeExceptionRemoveTest2() {
        list.add("1");
        list.add("1");
        assertThrows(ListFromSizeException.class,
                () -> list.remove(7));
    }

    //contains(String item);
    @Test
    void returnTrueContainsTest1() {
        list.add("1");
        list.add("2");
        list.add("1");
        assertTrue(list.contains("2"));
    }

    @Test
    void returnFalseContainsTest2() {
        list.add("1");
        list.add("2");
        list.add("1");
        assertFalse(list.contains("5"));
    }

    @Test
    void returnCorrectIndexOfItemIndexOfTest1() {
        list.add("1");
        list.add("2");
        list.add("1");
        assertEquals(list.indexOf("2"), 1);
    }

    @Test
    void returnMinusOneIfThereAreNoItemIndexOfTest1() {
        list.add("1");
        list.add("2");
        list.add("1");
        assertEquals(list.indexOf("3"), -1);
    }

    @Test
    void returnCorrectIndexOfItemLastIndexOfTest1() {
        list.add("1");
        list.add("2");
        list.add("1");
        assertEquals(list.lastIndexOf("1"), 2);
    }

    @Test
    void returnMinusOneIfThereAreNoItemLastIndexOfTest1() {
        list.add("1");
        list.add("2");
        list.add("1");
        assertEquals(list.lastIndexOf("3"), -1);
    }

    @Test
    void returnCorrectValueGetTest1() {
        list.add("1");
        list.add("2");
        list.add("1");
        Assertions.assertEquals(list.get(1), "2");
    }

    @Test
    void returnOutOfListSizeExceptionGetTest2() {
        list.add("1");
        list.add("1");
        assertThrows(ListFromSizeException.class,
                () -> list.get(7));
    }

    @Test
    void returnTrueIfStringListsAreEqualsEqualsTest1() {
        list.add("1");
        list.add("2");
        list.add("1");
        StringList expectedList = new StringListImpl();
        expectedList.add("1");
        expectedList.add("2");
        expectedList.add("1");
        assertTrue(list.equals(expectedList));
    }

    @Test
    void returnFalseIfStringListsAreNotEqualsEqualsTest2() {
        list.add("2");
        list.add("2");
        list.add("1");
        StringList expectedList = new StringListImpl();
        expectedList.add("1");
        expectedList.add("2");
        expectedList.add("1");
        assertFalse(list.equals(expectedList));
    }

    @Test
    void returnNullRequestExceptionEqualsTest3() {
        list.add("1");
        list.add("1");
        StringList expectedList = null;
        assertThrows(RequestNullException.class,
                () -> list.equals(expectedList));
    }


    @Test
    void returnCorrectSizeTest1() {
        list.add("1");
        list.add("1");
        list.add(1, "1");
        list.set(1, "1");
        list.remove(1);
        assertEquals(list.size(), 2);
    }

    @Test
    void returnTrueIsEmptyTest1() {
        assertTrue(list.isEmpty());
    }

    @Test
    void returnFalseIsEmptyTest2() {
        list.add("5");
        assertFalse(list.isEmpty());
    }

    @Test
    void removeAllItemsAndDecreaseSizeClearTest() {
        list.add("1");
        list.add("2");
        list.add("1");
        list.clear();
        String[] result = list.toArray();
        String[] expectedResult = new String[]{};
        assertArrayEquals(expectedResult, result);
    }

    @Test
    void returnCorrectValueToArrayTest1() {
        String[] result = list.toArray();
        String[] expectedResult = new String[]{};
        assertArrayEquals(expectedResult, result);
    }

    @Test
    void returnCorrectValueToArrayTest2() {
        list.add("1");
        String[] result = list.toArray();
        String[] expectedResult = new String[]{"1"};
        assertArrayEquals(expectedResult, result);
    }

    @Test
    void correctlyTransferElementValuesToTheNewArrayWhenTheStorageIsIncremented() {
        for (int i = 0; i <= 10; i++) {
            String expected = list.add("1");
        }
        String[] result = list.toArray();
        String[] expectedResult = new String[]{"1", "1", "1", "1", "1", "1", "1", "1", "1", "1"};
        assertArrayEquals(expectedResult, result);
    }
}