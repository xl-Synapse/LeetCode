//给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。 
//
// 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
// 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 12
//输出：3 
//解释：12 = 4 + 4 + 4 
//
// 示例 2： 
//
// 
//输入：n = 13
//输出：2
//解释：13 = 4 + 9 
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁴ 
// 
// Related Topics 广度优先搜索 数学 动态规划 👍 1480 👎 0

/*解答成功:
        执行耗时:23 ms,击败了78.96% 的Java用户
        内存消耗:41.3 MB,击败了8.20% 的Java用户
        */

/*
转化为完全背包问题、
朴素解法复杂度过高、超时、
需要进行一维dp优化、从小到大遍历、保证所依赖的格子已经被更新过、
* */
package leetcode.editor.cn;

import java.util.Arrays;

public class XL_279_PerfectSquares{
    public static void main(String[] args) {
        Solution solution = new XL_279_PerfectSquares().new Solution();
        solution.numSquares(12);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numSquares(int n) {
        int maxRoot = (int) Math.ceil(Math.sqrt(n));

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;

        for(int i = 1; i < maxRoot + 1; i++) {
            for (int j = i * i; j < n + 1; j++) {
                dp[j] = Math.min(dp[j], dp[j - i * i] + 1); // 如果前面没处理的值、都是无穷大、因此会被直接变成当前值、
            }
        }
        return dp[n];
    }

    public int numSquares_ps(int n) {
        int maxRoot = (int) Math.ceil(Math.sqrt(n));
        int[][] dp = new int[maxRoot + 1][n + 1];

        // 只考虑从1开始、只有一件物品、有多少选多少、
        for(int i = 0; i < n + 1; i++){
            dp[1][i] = i;
        }

        for(int i = 2; i < maxRoot + 1; i++){
            for(int j = 0; j < n + 1; j++){
                dp[i][j] = dp[i - 1][j]; // 先抄过来、

                for(int cnt = 1; ; cnt++){
                    if(cnt * Math.pow(i, 2) > j){
                        // 不能选这么多容量
                        break;
                    }

                    int temp = j - (int) (cnt * Math.pow(i, 2));
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][temp] + cnt); // 可能是更小的数量、
                }
            }
        }
        System.out.println(dp[maxRoot][n]);
        return dp[maxRoot][n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}