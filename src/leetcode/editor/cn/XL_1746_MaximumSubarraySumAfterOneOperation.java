//你有一个整数数组 nums。你只能将一个元素 nums[i] 替换为 nums[i] * nums[i]。 
//
// 返回替换后的最大子数组和。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,-1,-4,-3]
//输出：17
//解释：你可以把-4替换为16(-4*(-4))，使nums = [2,-1,16,-3]. 现在，最大子数组和为 2 + -1 + 16 = 17. 
//
// 示例 2： 
//
// 
//输入：nums = [1,-1,1,1,-1,-1,1]
//输出：4
//解释：你可以把第一个-1替换为1，使 nums = [1,1,1,1,-1,-1,1]. 现在，最大子数组和为 1 + 1 + 1 + 1 = 4. 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
// Related Topics 数组 动态规划 👍 21 👎 0


package leetcode.editor.cn;

/*解答成功:
        执行耗时:37 ms,击败了5.13% 的Java用户
        内存消耗:55.4 MB,击败了21.79% 的Java用户

        空间还可以再优化、
*/
public class XL_1746_MaximumSubarraySumAfterOneOperation{
    public static void main(String[] args) {
        Solution solution = new XL_1746_MaximumSubarraySumAfterOneOperation().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSumAfterOperation(int[] nums) {
        int[][] dp = new int[nums.length + 1][2];

        dp[0][0] = Math.max(nums[0], 0); // 不换
        dp[0][1] = nums[0] * nums[0]; // 存在换

        int max = Math.max(dp[0][0], dp[0][1]);
        for(int i = 1; i < nums.length; i++){

            dp[i][0] = Math.max(nums[i], dp[i - 1][0] + nums[i]);

            // 存在换、
            int temp1 = nums[i] * nums[i];
            int temp2 = dp[i - 1][0] + temp1;
            int temp3 = dp[i - 1][1] + nums[i]; // 前面换过、

            dp[i][1] = Math.max(Math.max(temp1, temp2), temp3);

            max = Math.max(Math.max(max, dp[i][0]), dp[i][1]);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}