package newstart.programming.dp;

import java.util.Arrays;

public class CoinChange {
    public int minCoinChange(int[] coins, int amount){
        if(coins == null || coins.length == 0 || amount == 0) return 0;

        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for (int i = 0; i < amount+1; i++) {
            for (int j = 0; j < coins.length; j++) {
                if(coins[j] <= i) {
                    dp[i] = Math.min(dp[i], 1+dp[i-coins[j]]);
                 }
            }
        }
        return dp[amount] == amount+1 ? -1 : dp[amount];
    }
}
