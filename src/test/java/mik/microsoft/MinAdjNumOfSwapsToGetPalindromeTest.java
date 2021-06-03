package mik.microsoft;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class MinAdjNumOfSwapsToGetPalindromeTest {

    @ParameterizedTest
    @CsvSource({"mamad,3", "asflkj,-1", "aabb,2"})
    void getNoOfSwaps(String input, String expectedValue) {
        MinAdjNumOfSwapsToGetPalindrome obj = new MinAdjNumOfSwapsToGetPalindrome();
        int actual = obj.getNoOfSwaps(input);
        int expected = Integer.parseInt(expectedValue);
        Assert.assertEquals(expected,actual);
    }

}