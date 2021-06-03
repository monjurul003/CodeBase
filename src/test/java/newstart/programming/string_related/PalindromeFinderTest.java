package newstart.programming.string_related;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeFinderTest {
    PalindromeFinder obj;

    @BeforeEach
    void setUp() {
        obj = new PalindromeFinder();
    }

    @Test
    void TestIsPalindrome1WorkingWithValidPalindromeString() {
        boolean result = obj.isPalindrome1("asdsa");
        Assert.assertEquals(true, result);
    }

    @Test
    void TestIsPalindrome1WorkingWithInvalidPalindromeString() {
        boolean result = obj.isPalindrome1("aasdsa");
        Assert.assertEquals(false, result);
    }

    @Test
    void TestIsPalindrome2WorkingWithValidPalindromeString() {
        boolean result = obj.isPalindrome2("asdsa");
        Assert.assertEquals(true, result);
    }

    @Test
    void TestIsPalindrome2WorkingWithInvalidPalindromeString() {
        boolean result = obj.isPalindrome2("aasdsa");
        Assert.assertEquals(false, result);
    }

    @Test
    void TestIsPalindrome3WorkingWithValidPalindromeString() {
        boolean result = obj.isPalindrome3("asdsa");
        Assert.assertEquals(true, result);
    }

    @Test
    void TestIsPalindrome3WorkingWithInvalidPalindromeString() {
        boolean result = obj.isPalindrome3("aasdsa");
        Assert.assertEquals(false, result);
    }
}