package junit5tests;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

public class AssertionsTest {

    @Test
    void assetEqualsTest() {
        assertEquals("firstString", "secondString",
                "The String values were not equal");
    }

    @Test
    void assertEqualsListTest() {
        List<String> expectedValues = Arrays.asList("firstString",
                "secondString", "thirdString");

        List<String> actualValues = Arrays.asList("firstString",
                "secondString", "thirdString");

        assertEquals(expectedValues, actualValues,
                "The list values were not equal");
    }

    @Test
    void assertArraysEqualsTest() {
        int[] expectedValues = {1, 5, 3};
        int[] actualValues = {1, 2, 3};
        assertArrayEquals(expectedValues, actualValues,
                "The array values were not equal");
    }

    @Test
    void assertTrueTest() {
        assertFalse(false);
        assertTrue(false, "This boolean condition did not evaluete to true");
    }

    @Test
    void assertThrowsTest() {
        assertThrows(NullPointerException.class, null);
    }

    @Test
    void assertAllTest() {
        assertAll(
                () -> assertEquals("firstString", "secondString",
                        "The String values were not equal"),
                () -> assertThrows(NullPointerException.class, null),
                () -> assertTrue(false, "This boolean condition did not evaluate to true"));

    }

    @Test
    void assertForMapTest() {
        Map<String, Integer> theMap = new HashMap<>();
        theMap.put("firstKey", 1);
        theMap.put("secondKey", 2);
        theMap.put("thirdKey", 3);

        assertThat(theMap, hasValue(22));
        assertThat(theMap, hasKey("secondKey1"));
    }

    @Test
    void assertForList() {
        List<String> theList = Arrays.asList("firstString", "secondString",
                "thirdString");

        assertThat(theList, hasItem("thirdStrings"));
    }

    @Test
    void assertForAnyOf() {
        List<String> theList = Arrays.asList("firstString", "secondString",
                "thirdString");

        assertThat(theList, anyOf(hasItem("thirdString"),
                hasItem("noString")));
    }

    @Test
    void assertForContainsAnyOrder() {
        List<String> theList = Arrays.asList("firstString", "secondString",
                "thirdString");

        assertThat(theList, containsInAnyOrder("firstString", "thirdString",
                "secondString"));

    }




}


