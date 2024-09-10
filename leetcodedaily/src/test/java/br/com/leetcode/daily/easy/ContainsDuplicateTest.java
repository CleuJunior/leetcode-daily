package br.com.leetcode.daily.easy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ContainsDuplicateTest {

    private ContainsDuplicate underTest;

    @BeforeEach
    void setUp() {
        underTest = new ContainsDuplicate();
    }

    @Test
    void caseOne() {
        assertTrue(underTest.hasDuplicate(new int[]{1, 2, 3, 1}));
    }

    @Test
    void caseTwo() {
        assertFalse(underTest.hasDuplicate(new int[]{1, 2, 3, 4}));
    }

    @Test
    void caseThree() {
        assertTrue(underTest.hasDuplicate(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}));
    }

}