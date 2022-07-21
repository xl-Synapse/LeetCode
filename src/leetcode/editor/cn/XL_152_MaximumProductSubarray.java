//给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
//
// 测试用例的答案是一个 32-位 整数。 
//
// 子数组 是数组的连续子序列。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 
//输入: nums = [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -10 <= nums[i] <= 10 
// nums 的任何前缀或后缀的乘积都 保证 是一个 32-位 整数 
// 
// Related Topics 数组 动态规划 👍 1726 👎 0


package leetcode.editor.cn;
public class XL_152_MaximumProductSubarray{
    public static void main(String[] args) {
        Solution solution = new XL_152_MaximumProductSubarray().new Solution();
    }

    /**
     * 由于乘法可能符号变换、因此需要维持最大表和最小表、两个表都要查、
     * 仍存在优化空间、i 时刻只需要查 i-1 、实际只需要常数级别辅助空间、
     * 解答成功:
     * 			执行耗时:3 ms,击败了17.03% 的Java用户
     * 			内存消耗:41.8 MB,击败了17.83% 的Java用户
     */

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProduct(int[] nums) {
        int[] maxSubV = new int[nums.length];
        int[] minSubV = new int[nums.length];

        int maxV = nums[0];
        maxSubV[0] = nums[0];
        minSubV[0] = nums[0];

        for(int i = 1; i < nums.length; i++){
            if(nums[i] == 0){
                maxV = Math.max(maxV, 0);
                continue;
            }
            // 两个表都查、
            int mul1 = maxSubV[i - 1] * nums[i];
            int mul2 = minSubV[i - 1] * nums[i];

            maxSubV[i] = Math.max(Math.max(mul1, mul2), nums[i]);
            minSubV[i] = Math.min(Math.min(mul1, mul2), nums[i]);

            maxV = Math.max(maxV, maxSubV[i]);

        }
        return maxV;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}