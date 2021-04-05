package newstart.programming.dp;

import java.util.Arrays;

public class CoinChange {

    /* lets assume minCoinChange(new int[]{1,2,5}, 11)
    Coins     amount -->
 idx       0  1  2  3  4  5  6  7  8  9  10 11
           12 12 12 12 12 12 12 12 12 12 12 12
  0   1    12 12
  1   2    12 12
  2   5    12 12


  0 12 12 12 12 12 12 12 12 12 12 12
0 12 12 12 12 12 12 12 12 12 12 12
0 12 12 12 12 12 12 12 12 12 12 12
0 1 12 12 12 12 12 12 12 12 12 12
0 1 12 12 12 12 12 12 12 12 12 12
0 1 12 12 12 12 12 12 12 12 12 12
0 1 2 12 12 12 12 12 12 12 12 12
0 1 1 12 12 12 12 12 12 12 12 12
0 1 1 12 12 12 12 12 12 12 12 12
0 1 1 2 12 12 12 12 12 12 12 12
0 1 1 2 12 12 12 12 12 12 12 12
0 1 1 2 12 12 12 12 12 12 12 12
0 1 1 2 3 12 12 12 12 12 12 12
0 1 1 2 2 12 12 12 12 12 12 12
0 1 1 2 2 12 12 12 12 12 12 12
0 1 1 2 2 3 12 12 12 12 12 12
0 1 1 2 2 3 12 12 12 12 12 12
0 1 1 2 2 1 12 12 12 12 12 12
0 1 1 2 2 1 2 12 12 12 12 12
0 1 1 2 2 1 2 12 12 12 12 12
0 1 1 2 2 1 2 12 12 12 12 12
0 1 1 2 2 1 2 3 12 12 12 12
0 1 1 2 2 1 2 2 12 12 12 12
0 1 1 2 2 1 2 2 12 12 12 12
0 1 1 2 2 1 2 2 3 12 12 12
0 1 1 2 2 1 2 2 3 12 12 12
0 1 1 2 2 1 2 2 3 12 12 12
0 1 1 2 2 1 2 2 3 4 12 12
0 1 1 2 2 1 2 2 3 3 12 12
0 1 1 2 2 1 2 2 3 3 12 12
0 1 1 2 2 1 2 2 3 3 4 12
0 1 1 2 2 1 2 2 3 3 4 12
0 1 1 2 2 1 2 2 3 3 2 12
0 1 1 2 2 1 2 2 3 3 2 3
0 1 1 2 2 1 2 2 3 3 2 3
0 1 1 2 2 1 2 2 3 3 2 3
    * */

    public int minCoinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount == 0) return 0;

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 0; i < amount + 1; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                }
                print(dp);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        coinChange.minCoinChange(new int[]{1, 2, 5}, 11);

    }
}
