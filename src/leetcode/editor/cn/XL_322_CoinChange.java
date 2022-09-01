//给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。 
//
// 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1, 2, 5], amount = 11
//输出：3 
//解释：11 = 5 + 5 + 1 
//
// 示例 2： 
//
// 
//输入：coins = [2], amount = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：coins = [1], amount = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 2³¹ - 1 
// 0 <= amount <= 10⁴ 
// 
// Related Topics 广度优先搜索 数组 动态规划 👍 2116 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

/*
解答成功:
        执行耗时:11 ms,击败了87.07% 的Java用户
        内存消耗:40.9 MB,击败了73.59% 的Java用户

        这里比 279 多一点判断条件、即可能以往的项目选择不能满足、导致当前项目也不能满足、出现 -1、
*/

public class XL_322_CoinChange{
    public static void main(String[] args) {
        Solution solution = new XL_322_CoinChange().new Solution();
        solution.coinChange(new int[]{2, 5}, 8);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i = 0; i < coins.length; i++){
            for(int j = coins[i]; j < amount + 1; j++){
                // i开始、保证数组不越界、至少能装一个、
                int temp = dp[j - coins[i]] + 1;
                if(temp < 0){
                    // 前面的项目无法满足、因此这里也无法满足、
                    continue;
                }
                else
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}