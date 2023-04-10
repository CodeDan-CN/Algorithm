/**
 * @ClassName: 目标和
 * @Description: TODO
 * @Author: CodeDan
 * @Date: 2023/4/1 15:29
 * @Version: 1.0.0
 **/
public class 目标和 {

    public static void main(String[] args) {

        System.out.println(findTargetSumWays(new int[]{1,1,1,1,1}, 3));
    }

    public static int findTargetSumWays(int[] nums, int target) {
        // 这题回溯和动态规划都能做，动态规划来一手
        // 核心：数组可以分为两个部分，即left + right = target， right = sum - right ， left - （ sum - left ） = target ， left = sum + target / 2;
        // 那么left的结果也就出来了，我们就可以将题意变成，数组中结果为left的组合有多少种(01背包)
        // 推导一下：
        // 第一步：dp[i][j]为容量j时，0-i之间组合之和等于j的数量。
        // 第二步：dp[i][j] = dp[i - j][j] + dp[i - 1][j - nums[i]]
        // 第三步：初始化-j = 0的，dp[i][0] = 1（啥都不拿，不就是0）; i = 0的时候，dp[0][j] =  （nums[0] != left , 0 AND nums[0] == left , 1  ）
        // 第四步: 边界范围，即dp[nums.length - 1][left];

        // 先计算出left
        int sum = 0;
        for(int index = 0 ; index < nums.length ; index++){
            sum += nums[index];
        }
        if( (sum + target) % 2 == 1 ){
            return 0;
        }
        int left = (sum + target) / 2;
        if( left > sum ){
            return 0;
        }
        int[][] dp = new int[nums.length][left + 1];
        for( int index = 0 ; index < nums.length ; index++ ){
            for( int jndex = 0 ; jndex <= left ; jndex++ ){
                if( jndex == 0 ){
                    dp[index][jndex] = 1;
                }else if( index == 0 && nums[index] == jndex ){
                    dp[index][jndex] = 1;
                }else if( index != 0 && jndex >= nums[index] ){
                    dp[index][jndex] = dp[index - 1][jndex] + dp[index - 1][jndex - nums[index]];
                }
            }
        }
        return dp[nums.length - 1][left];
    }
}
