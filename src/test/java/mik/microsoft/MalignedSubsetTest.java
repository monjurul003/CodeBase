package mik.microsoft;

import org.junit.Test;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MalignedSubsetTest {
    @Test
    public void testWithInput1(){
        int[] arr = {4, 7, 10, 6, 9};
        assertEquals(3, MalignedSubset.getLargestMAlignedSubset(arr,4 ));
    }

}