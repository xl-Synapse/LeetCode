//给你一个披萨，它由 3n 块不同大小的部分组成，现在你和你的朋友们需要按照如下规则来分披萨： 
//
// 
// 你挑选 任意 一块披萨。 
// Alice 将会挑选你所选择的披萨逆时针方向的下一块披萨。 
// Bob 将会挑选你所选择的披萨顺时针方向的下一块披萨。 
// 重复上述过程直到没有披萨剩下。 
// 
//
// 每一块披萨的大小按顺时针方向由循环数组 slices 表示。 
//
// 请你返回你可以获得的披萨大小总和的最大值。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：slices = [1,2,3,4,5,6]
//输出：10
//解释：选择大小为 4 的披萨，Alice 和 Bob 分别挑选大小为 3 和 5 的披萨。然后你选择大小为 6 的披萨，Alice 和 Bob 分别挑选大小
//为 2 和 1 的披萨。你获得的披萨总大小为 4 + 6 = 10 。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：slices = [8,9,8,6,1,1]
//输出：16
//解释：两轮都选大小为 8 的披萨。如果你选择大小为 9 的披萨，你的朋友们就会选择大小为 8 的披萨，这种情况下你的总和不是最大的。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= slices.length <= 500 
// slices.length % 3 == 0 
// 1 <= slices[i] <= 1000 
// 
// Related Topics 贪心 数组 动态规划 堆（优先队列） 👍 105 👎 0


package leetcode.editor.cn;
public class XL_1388_PizzaWith3nSlices{
    public static void main(String[] args) {
        Solution solution = new XL_1388_PizzaWith3nSlices().new Solution();
        System.out.println(solution.maxSizeSlices(new int[]{1,2,3,4,5,6}));
    }

    /**
     * 看官解、做不出来、
     *
     * 解答成功:
     * 			执行耗时:6 ms,击败了76.24% 的Java用户
     * 			内存消耗:41.4 MB,击败了57.46% 的Java用户
     */

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSizeSlices(int[] slices) {
        int[] slices1 = new int[slices.length - 1];
        System.arraycopy(slices, 1, slices1, 0, slices.length - 1);
        int[] slices2 = new int[slices.length - 1];
        System.arraycopy(slices, 0, slices2, 0, slices.length - 1);
        int choose = slices.length / 3;
        int ans1 = calculate(slices1, choose);
        int ans2 = calculate(slices2, choose);
        return Math.max(ans1, ans2);
    }

    private int calculate(int[] slices, int choose){ // 披萨数组和总共我需要取多少块、
        int length = slices.length;
        int[][] dp = new int[length + 1][choose + 1]; // 为什么都 + 1、因为以下代码不使用 00索引的位置、便于理解、
        for(int i = 1; i <= length; i++){
            for(int j = 1; j <= choose; j++){
                dp[i][j] = Math.max(dp[i - 1][j], (i - 2 >= 0 ? dp[i - 2][j - 1] : 0) + slices[i - 1]); // i - 1 是因为语义上第一个实际在数据第0、
            }
        }
        return dp[length][choose];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}