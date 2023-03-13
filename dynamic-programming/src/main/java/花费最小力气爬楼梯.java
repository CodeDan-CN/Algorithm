/**
 * @ClassName: 花费最小力气爬楼梯
 * @Description: 花费最小力气爬楼梯
 * @Author: CodeDan
 * @Date: 2023/3/13 21:56
 * @Version: 1.0.0
 **/
public class 花费最小力气爬楼梯 {

    public static int minCostClimbingStairs(int[] cost) {
        // 这题主要是理解一下，到楼顶啊，不是到数组最后一个元素就可以了，所以得最后一步得超过数组边界
        // 动态规划五步法
        // 1、我们先来确定一个dp[i]是干嘛的，根据提议很明显，是到达下标为i时的最低花费
        // 2、确定一个递推公式，dp[i] = min(dp[i - 1]+ cost[i - 1], dp[i - 2]  + cost[i - 2]);
        // 3、确定初始化的值，dp[0] = 0; dp[1] = 0;
        // 4、确定边界，基本就是cost数组 + 1的边界
        // 5、确定递推方向，从左到右，最右那个就是到楼顶的最低花费
        int[] dp = new int[cost.length + 1];
        dp[0] = 0;
        dp[1] = 0;
        for( int index = 2 ; index < dp.length ; index++ ){
            dp[index] = Math.min(dp[index - 1] + cost[index - 1] , dp[index - 2] + cost[index - 2]);
            System.out.println("dp["+index+"] = "+dp[index]);
        }
        return dp[cost.length];
    }

    public static void main(String[] args) {
        minCostClimbingStairs(new int[]{10,15,20});
    }
}
