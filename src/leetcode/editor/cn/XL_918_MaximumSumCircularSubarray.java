//给定一个长度为 n 的环形整数数组 nums ，返回 nums 的非空 子数组 的最大可能和 。 
//
// 环形数组 意味着数组的末端将会与开头相连呈环状。形式上， nums[i] 的下一个元素是 nums[(i + 1) % n] ， nums[i] 的前一个
//元素是 nums[(i - 1 + n) % n] 。 
//
// 子数组 最多只能包含固定缓冲区 nums 中的每个元素一次。形式上，对于子数组 nums[i], nums[i + 1], ..., nums[j] ，不
//存在 i <= k1, k2 <= j 其中 k1 % n == k2 % n 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,-2,3,-2]
//输出：3
//解释：从子数组 [3] 得到最大和 3
// 
//
// 示例 2： 
//
// 
//输入：nums = [5,-3,5]
//输出：10
//解释：从子数组 [5,5] 得到最大和 5 + 5 = 10
// 
//
// 示例 3： 
//
// 
//输入：nums = [3,-2,2,-3]
//输出：3
//解释：从子数组 [3] 和 [3,-2,2] 都可以得到最大和 3
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 3 * 10⁴ 
// -3 * 10⁴ <= nums[i] <= 3 * 10⁴ 
// 
// Related Topics 队列 数组 分治 动态规划 单调队列 👍 382 👎 0


package leetcode.editor.cn;
public class XL_918_MaximumSumCircularSubarray{
    public static void main(String[] args) {
        Solution solution = new XL_918_MaximumSumCircularSubarray().new Solution();
        System.out.println(solution.maxSubarraySumCircular(new int[]{5,-3,5}));
    }

    /**
     * 这道题题目有问题、没说清楚、应该是要连续子数组、
     * 解答成功:
     * 			执行耗时:4 ms,击败了88.98% 的Java用户
     * 			内存消耗:48.5 MB,击败了27.59% 的Java用户
     */

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int[] maxSubSums = new int[nums.length]; // 求跨环时复用前面的存储、
        int[] maxSubSumsLastIndexs = new int[nums.length];
        int noRingMaxSum = nums[0];
        int ringMaxSum = 0;

        /**
         * 1.不跨环、
         * 2.跨环、 总和 - 不跨环最小连续子数组、
         * 3.全是负数、即求最大值、这个情况可以包含在不跨环内、
         *
         */

        // 求不跨环、为了求跨环、这里得记忆每个子数组的位置、
        maxSubSums[0] = nums[0];

        for(int i = 1; i < nums.length; i++){
            if(maxSubSums[i - 1] > 0){
                // 纳入、
                maxSubSums[i] = maxSubSums[i - 1] + nums[i];
                maxSubSumsLastIndexs[i] = maxSubSumsLastIndexs[i - 1];
            }
            else {
                // 断开、
                maxSubSums[i] = nums[i];
                maxSubSumsLastIndexs[i] = i;
            }

            // i 计算完毕
            noRingMaxSum = Math.max(noRingMaxSum, maxSubSums[i]);
        }

        if(noRingMaxSum < 0) // 出现全负数、没必要求跨环、
            return noRingMaxSum;

        // 求跨环、复用存储地址、
        int sum = nums[0];
        maxSubSums[0] = nums[0];

        for(int i = 1; i < nums.length; i++){
            sum += nums[i];
            if(maxSubSums[i - 1] < 0){
                // 纳入、
                maxSubSums[i] = maxSubSums[i - 1] + nums[i];
            }
            else {
                // 断开、破开了环、
                maxSubSums[i] = nums[i];
            }
            ringMaxSum = Math.min(maxSubSums[i], ringMaxSum);
        }
        ringMaxSum = sum - ringMaxSum;

        return Math.max(noRingMaxSum, ringMaxSum);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}