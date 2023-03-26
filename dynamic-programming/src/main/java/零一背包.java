/**
 * @ClassName: 零一背包
 * @Description: 零一背包
 * @Author: CodeDan
 * @Date: 2023/3/23 22:49
 * @Version: 1.0.0
 **/
/**
 * 背包最大重量为4。
 *
 * 物品为：
 *
 *       重量 价值
 * 物品0	  1	 15
 * 物品1	  3	 20
 * 物品2	  4	 30
 * 问背包能背的物品最大价值是多少？
 */
public class 零一背包 {
    public static void main(String[] args) {
        int[] weight = {1,3,4};
        int[] value = {15,20,30};
        int bagSize = 4;
        testWeightBagProblem(weight,value,bagSize);
    }

    /**
     * 动态规划获得结果
     * @param weight  物品的重量
     * @param value   物品的价值
     * @param bagSize 背包的容量
     */
    public static void testWeightBagProblem(int[] weight, int[] value, int bagSize){
        // 背包类型入门题，这题核心在于你得清楚dp的含义，而且这是一个二维dp，即背包物品为纵向轴，背包存放量为横向轴的二维数组。那么就需要判断出dp的含义，这个含义错了后面没法做
        // 第一步：dp[i][j]代表了在背包不存放、单个或者多个物品(0-i)之间并且占用容量为j的最大价值
        // 第二步：确认递推公式，遇到一个新物品，我们需要判断拿还是不拿，肯定是依据最大值来的，即dp[i][j] = max(dp[i - 1][j] , dp[i - 1][j - weight[i]] + value[i]);
        // 第三步：确定初始值，在容量为0的时候，肯定价值最大也是0，反之，如果是物品0的时候，最大也就是0的价值，还得看拿不拿的下（这点不仅仅在初始化阶段，推算阶段也要注意）
        // 第四步：确定边界值，[value.length][bagSize + 1]
        // 第五步：确定递推方向，从左到右，从上到下

        //定义dp数组
        int[][] dp = new int[value.length][bagSize + 1];
        // 初始化(由于Java数组元素值本身就为0，所以无需为0初始化)
        for( int jndex = 1 ; jndex <= bagSize; jndex++ ){
            // 判断是否可以装下weight[0];
            if( jndex >= weight[0] ){
                dp[0][jndex] = value[0];
            }
        }
        // 开始进行dp数组的递推
        for( int index = 1 ; index < value.length ; index++ ){
            for( int jndex = 1 ; jndex <= bagSize ; jndex++){
                if (jndex < weight[index]) {
                    /**
                     * 当前背包的容量都没有当前物品i大的时候，是不放物品i的
                     * 那么前i-1个物品能放下的最大价值就是当前情况的最大价值
                     */
                    dp[index][jndex] = dp[index-1][jndex];
                } else {
                    /**
                     * 当前背包的容量可以放下物品i
                     * 那么此时分两种情况：
                     *    1、不放物品i
                     *    2、放物品i
                     * 比较这两种情况下，哪种背包中物品的最大价值最大
                     */
                    dp[index][jndex] = Math.max(dp[index-1][jndex] , dp[index-1][jndex-weight[index]] + value[index]);
                }
            }
        }

        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j <= bagSize; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println("\n");
        }

    }
}
