//给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。 
//
// 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。 
//
// 假设每一种面额的硬币有无限个。 
//
// 题目数据保证结果符合 32 位带符号整数。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：amount = 5, coins = [1, 2, 5]
//输出：4
//解释：有四种方式可以凑成总金额：
//5=5
//5=2+2+1
//5=2+1+1+1
//5=1+1+1+1+1
// 
//
// 示例 2： 
//
// 
//输入：amount = 3, coins = [2]
//输出：0
//解释：只用面额 2 的硬币不能凑成总金额 3 。
// 
//
// 示例 3： 
//
// 
//输入：amount = 10, coins = [10] 
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 300 
// 1 <= coins[i] <= 5000 
// coins 中的所有值 互不相同 
// 0 <= amount <= 5000 
// 
// Related Topics 数组 动态规划 👍 912 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

/*
解答成功:
        执行耗时:3 ms,击败了46.36% 的Java用户
        内存消耗:38.9 MB,击败了69.89% 的Java用户

        dp 里维持的变成组合数、状态转移变成 += 上个组合数、
*/
public class XL_518_CoinChange2{
    public static void main(String[] args) {
        Solution solution = new XL_518_CoinChange2().new Solution();
        solution.change(5, new int[]{1, 2, 5});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int change(int amount, int[] coins) {
        if(amount == 0)
            return 1;

        int[] dp = new int[amount + 1];

        dp[0] = 0;

        for(int i = 0; i < coins.length; i++){
            if(coins[i] > amount)
                continue;
            dp[coins[i]] += 1;
            for(int j = coins[i] + 1; j < amount + 1; j++){
                // i开始、保证数组不越界、至少能装一个、
                dp[j] += dp[j - coins[i]];

            }
        }
        return dp[amount];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}