package mik.dp.minmaxpath;

import newstart.programming.dp.MinCostClimbingStairs746;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinCostClimbingStairs746Test {

    @Test
    @DisplayName("Test happy path")
    void minCostClimbingStairs() {
        int expected = 15;
        int actual = MinCostClimbingStairs746.minCostClimbingStairs(new int[]{10,15,20});
        assertEquals(expected,actual,"min cost did not calculated properly");
    }
}