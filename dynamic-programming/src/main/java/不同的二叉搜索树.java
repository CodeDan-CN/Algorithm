/**
 * @ClassName: 不同的二叉搜索树
 * @Description: TODO
 * @Author: CodeDan
 * @Date: 2023/3/22 21:06
 * @Version: 1.0.0
 **/
public class 不同的二叉搜索树 {
        public int numTrees(int n) {
            // 第一步：dp[i] 代表这n=i时，n个节点互不相同的二叉搜索树有多少种
            // 图中是n=3的时候一共5棵树，那么n=1的时候，很明显就一颗树，n = 2的时候，有两个树，自己画一下
            // 可以看到头节点为1的时候，其子树形状和n=2一模一样，头节点为3的时候，也是如此（只看形状不看数值），那么头节点为2的时候，左右子树为n=1的时候一模一样
            // 所以dp[3] = dp[0] * dp[2] + dp[1] * dp[1] + dp[2] * dp[0];
            // 第二步：递推公式dp[i] = dp[i - j] * dp[j - 1] ( j <= i , j >= 1 )
            // 第三步：初始化，dp[0] = 0; dp[1] = 1, dp[2] = 2
            // 第四步：边界值，n + 1
            // 第五步：从左到右
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            for( int index = 2; index <= n ; index++ ){
                for( int jndex = 1 ; jndex <= index; jndex++ ){
                    dp[index] += dp[index - jndex] * dp[jndex - 1];
                }
            }
            return dp[n];
        }

}
