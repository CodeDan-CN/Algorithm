/**
 * @ClassName: 整数拆分
 * @Description: 整数拆分
 * @Author: CodeDan
 * @Date: 2023/3/20 21:22
 * @Version: 1.0.0
 **/
public class 整数拆分 {

    public int integerBreak(int n) {
        // 这个直接不好推，得从1开始往上找规律
        // dp[5] = 6 (4 + 1)(3 + 2)(2 + 2 + 1)( 2 + 1 + 1 + 1 )( 1 + 1 + 1 + 1 + 1 )
        // dp[4] = 4 (3 + 1)(2 + 2)(2 + 1 + 1)(1 + 1 + 1 + 1)
        // dp[3] = 2 (2 + 1)(1 + 1 + 1)
        // dp[2] = 1 (1 + 1)
        // dp[1] = 1 (1)
        // 这题日恐怖，要始终谨记一点， dp的含义，dp[i]是数字i拆分整数之后最大的乘积
        // 那么我们就需要思考一个问题，dp[i]最大乘积的来源，其中一直就是两个数相乘会最大，
        // 还有一种可能就是i - 1 * dp[i-1]的值（这里的i - 1 * dp[i-1]只是为了方便理解，正常应该是dp[i - j] * j，j < i && j>=1）
        // 这里其实递推公式就出来了，dp[i] = max(dp[i], max(dp[i - j] * j, (i - j) * j ))
        // 上面已经推断出dp的含义和dp递推，那么接下来走流程
        // 第三步：确认初始化的值，dp[1] = 1, dp[2] = 1
        // 第四步：边界值，n + 1为dp的边界值
        // 第五步：递推方向，从左到右
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        for (int index = 3; index <= n; index++) {
            for (int jndex = index - 1; jndex >= 1; jndex--) {
                dp[index] = Math.max(dp[index], Math.max(dp[index - jndex] * jndex, (index - jndex) * jndex));
            }
        }
        return dp[n];
    }

}
