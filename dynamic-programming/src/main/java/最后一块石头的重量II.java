/**
 * @ClassName: 最后一块石头的重量II
 * @Description: TODO
 * @Author: CodeDan
 * @Date: 2023/3/30 20:54
 * @Version: 1.0.0
 **/
public class 最后一块石头的重量II {

    class Solution {
        public int lastStoneWeightII(int[] stones) {
            // 遍历数组，计算/2
            int sum = 0;
            for( int i = 0 ; i < stones.length; i++ ){
                sum += stones[i];
            }
            int target = sum / 2;
            // 这题的核心就是获取到最解决一堆石头中一半重量的石头堆，能刚好获取到一般最好，获取不到也是小于一半的，可以获取到最小值
            // 第一步：dp[i][j]代表j容量了0-i个石头的最大价格。
            // 第二步：dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - stones[i] + stones[i]]);
            // 第三步：dp[i][0] = 0( i=1，2，3...) dp[0][j] = stones[0] ( J >= stones[0] ) dp[0][j] = 0 ( J < stones[0] )
            // 第四步：i = stones.length     j = total + 1;
            int[][] dp = new int[stones.length][target + 1];
            //dp[i][0]默认初始化为0
            //dp[0][j]取决于stones[0]
            for (int j = stones[0]; j <= target; j++) {
                dp[0][j] = stones[0];
            }
            for (int i = 1; i < stones.length; i++) {
                for (int j = 1; j <= target; j++) {//注意是等于
                    if (j >= stones[i]) {
                        //不放:dp[i - 1][j] 放:dp[i - 1][j - stones[i]] + stones[i]
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stones[i]] + stones[i]);
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
            System.out.println(dp[stones.length - 1][target]);
            return (sum - dp[stones.length - 1][target]) - dp[stones.length - 1][target];
        }
    }


}
