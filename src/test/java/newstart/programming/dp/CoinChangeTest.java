package newstart.programming.dp;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoinChangeTest {

    @Test
    void minCoinChange() {
        CoinChange obj = new CoinChange();
        int expected = 3;
        int real =obj.minCoinChange(new int[]{1,3,5}, 11);
        Assert.assertEquals("Return as expected", expected,real);

        real =obj.minCoinChange(new int[]{2}, 11);
        Assert.assertEquals("Return as expected", -1,real);
    }
}