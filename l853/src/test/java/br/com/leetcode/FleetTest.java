package br.com.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FleetTest {

    @Test
    void sampleTest() {
        assertEquals(3,
                Fleet.carFleet(12,
                        new int[]{10, 8, 0, 5, 3},
                        new int[]{2, 4, 1, 1, 3})
        );

        assertEquals(1,
                Fleet.carFleet(10,
                        new int[]{3},
                        new int[]{3})
        );

        assertEquals(1,
                Fleet.carFleet(100,
                        new int[]{0, 2, 4},
                        new int[]{4, 2, 1})
        );
    }
}