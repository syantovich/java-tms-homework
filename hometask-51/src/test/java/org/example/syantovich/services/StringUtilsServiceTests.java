package org.example.syantovich.services;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringUtilsServiceTests {

    private final StringUtilsService stringUtilsService = new StringUtilsService();

    @Test
    public void testIndexOfIgnoreCase_Found() {
        assertEquals(0, stringUtilsService.indexOfIgnoreCase("Hello", "he"));
    }

    @Test
    public void testIndexOfIgnoreCase_NotFound() {
        assertEquals(-1, stringUtilsService.indexOfIgnoreCase("Hello", "world"));
    }

    @Test
    public void testIndexOfIgnoreCase_NullStr() {
        assertEquals(-1, stringUtilsService.indexOfIgnoreCase(null, "he"));
    }

    @Test
    public void testIndexOfIgnoreCase_NullSearchStr() {
        assertEquals(-1, stringUtilsService.indexOfIgnoreCase("Hello", null));
    }

    @Test
    public void testContainsIgnoreCase_True() {
        assertTrue(stringUtilsService.containsIgnoreCase("Hello", "he"));
    }

    @Test
    public void testContainsIgnoreCase_False() {
        assertFalse(stringUtilsService.containsIgnoreCase("Hello", "world"));
    }

    @Test
    public void testContainsIgnoreCase_NullStr() {
        assertFalse(stringUtilsService.containsIgnoreCase(null, "he"));
    }

    @Test
    public void testContainsIgnoreCase_NullSearchStr() {
        assertFalse(stringUtilsService.containsIgnoreCase("Hello", null));
    }
}
