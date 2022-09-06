//你有一些苹果和一个可以承载 5000 单位重量的篮子。 
//
// 给定一个整数数组 weight ，其中 weight[i] 是第 i 个苹果的重量，返回 你可以放入篮子的最大苹果数量 。 
//
// 
//
// 示例 1： 
//
// 
//输入：weight = [100,200,150,1000]
//输出：4
//解释：所有 4 个苹果都可以装进去，因为它们的重量之和为 1450。
// 
//
// 示例 2： 
//
// 
//输入：weight = [900,950,800,1000,700,800]
//输出：5
//解释：6 个苹果的总重量超过了 5000，所以我们只能从中任选 5 个。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= weight.length <= 10³ 
// 1 <= weight[i] <= 10³ 
// 
// Related Topics 贪心 数组 排序 👍 12 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

/*
解答成功:
        执行耗时:389 ms,击败了5.33% 的Java用户
        内存消耗:41.1 MB,击败了98.67% 的Java用户

        写的时候考虑太多、就是从0开始遍历的 01 背包问题、

*/
public class XL_1196_HowManyApplesCanYouPutIntoTheBasket{
    public static void main(String[] args) {
        Solution solution = new XL_1196_HowManyApplesCanYouPutIntoTheBasket().new Solution();
        solution.maxNumberOfApples(new int[]{900,950,800,1000,700,800});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxNumberOfApples(int[] weight) {
        int[] dp = new int[5001];
//        if(weight[0] <= 5000)
//            Arrays.fill(dp, 1);
//        else
//            Arrays.fill(dp, 0);

        for(int i = 0; i < weight.length; i++){ // 遍历待考虑的数组、

            for(int j = 5000; j >= weight[i]; j--){ // 遍历限制条件、可能是体积、可能是持有钱数、   要保证依赖的格子是未更新的上一行、因此需要从大到小、
                dp[j] = Math.max(dp[j - weight[i]] + 1, dp[j]);
            }
        }
        System.out.println(dp[5000]);
        return dp[5000];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}