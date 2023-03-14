/**
 * @ClassName: 不同路径
 * @Description: 不同路径
 * @Author: CodeDan
 * @Date: 2023/3/14 21:14
 * @Version: 1.0.0
 **/
public class 不同路径 {

    public static int uniquePaths(int m, int n) {
        //这个题也很简单，我感觉应该不算中等题目
        // 第一步：递推公式含义，也就是dp[i][j]代表什么，根据题意可以知道dp[i][j]代表到达i，j位置的路径条数
        // 第二步：确定递推公式，可以看的出来最后位置i，j只能由i-1，j或者i，j-1走到，所以dp[i][j] = dp[i-1][j] + dp[i][j - 1];
        // 第三步：确定初始化值，从图和题意可以知道dp[0][j]（j=0，1，2，3...） = 1;dp[i][0]（i=0，1，2，3...） = 1;
        // 第四步：确定数组边界，即从dp[1,1]开始，dp[m - 1][n - 1]结束
        // 第五步：确定递推方向，从左上到右下
        int[][] dp = new int[m][n];
        if (m == 1 || n == 1) return 1;
        for (int index = 0; index < m; index++) {
            for (int jndex = 0; jndex < n; jndex++) {
                if (index == 0 && jndex == 0) {
                    continue;
                } else if (index == 0 || jndex == 0) {
                    dp[index][jndex] = 1;
                } else {
                    dp[index][jndex] = dp[index - 1][jndex] + dp[index][jndex - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
//leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        uniquePaths(3,7);
    }

}
