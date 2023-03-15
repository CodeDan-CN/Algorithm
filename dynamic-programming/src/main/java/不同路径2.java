/**
 * @ClassName: 不同路径2
 * @Description: 不同路径2
 * @Author: CodeDan
 * @Date: 2023/3/15 21:33
 * @Version: 1.0.0
 **/
public class 不同路径2 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // 初步理解就是将dp数组中可能有石头的位置设置为0即可。在之前的基础上，判断终点是不是石头也很有必要
        // 还有就是石头可能出现在初始化值路径上，需要注意一下。如果出现在初始化值的边界上，之后的位置均是无法到达的。
        // 第一步：递推公式含义，也就是dp[i][j]代表什么，根据题意可以知道dp[i][j]代表到达i，j位置的路径条数
        // 第二步：确定递推公式，可以看的出来最后位置i，j只能由i-1，j或者i，j-1走到，所以dp[i][j] = dp[i-1][j] + dp[i][j - 1];
        // 第三步：确定初始化值，从图和题意可以知道dp[0][j]（j=0，1，2，3...） = 1；如果j在递增的过程中遇到原数组是此位置是1，那么为0，之后均为0
        // ;dp[i][0]（i=0，1，2，3...） = 1;i和上述j一样，同理
        // 第四步：确定数组边界，即从dp[1,1]开始，dp[m - 1][n - 1]结束
        // 第五步：确定递推方向，从左上到右下
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        //如果在起点或终点出现了障碍，直接返回0
        if (obstacleGrid[m - 1][n - 1] == 1 || obstacleGrid[0][0] == 1) {
            return 0;
        }
        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n && obstacleGrid[0][j] == 0; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = (obstacleGrid[i][j] == 0) ? dp[i - 1][j] + dp[i][j - 1] : 0;
            }
        }
        return dp[m - 1][n - 1];
    }

}
