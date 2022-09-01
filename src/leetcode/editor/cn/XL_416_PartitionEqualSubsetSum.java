//给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,5,11,5]
//输出：true
//解释：数组可以分割成 [1, 5, 5] 和 [11] 。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,5]
//输出：false
//解释：数组不能分割成两个元素和相等的子集。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
// Related Topics 数组 动态规划 👍 1472 👎 0

/*解答成功:
        执行耗时:54 ms,击败了5.38% 的Java用户
        内存消耗:42.7 MB,击败了16.61% 的Java用户
        */
package leetcode.editor.cn;
public class XL_416_PartitionEqualSubsetSum{
    public static void main(String[] args) {
        Solution solution = new XL_416_PartitionEqualSubsetSum().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canPartition(int[] nums) {
        // 数组之和必须为偶数、
        // 转化为01背包问题、从数组中选数、使得恰好和为数组的一半、
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if(sum % 2 == 1)
            return false;

        sum = sum / 2;

        // 项目数、容量、
        boolean[][] dp = new boolean[nums.length][sum + 1];

        if(nums[0] <= sum){
            dp[0][nums[0]] = true; // 第一个项目只能让这个背包装满、
        }

        int temp = 0;
        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < sum + 1; j++){
                // 考虑第 i 个项目能否让容量 j 装满、
                dp[i][j] = dp[i - 1][j];

                if(nums[i] == j){
                    // 刚好只需要这一个东西就能装满、
                    dp[i][j] = true;
                    continue;
                }

                if(nums[i] < j){
                    // 需要前面的项目辅助、要么以前装满过、要么和以前加在一起刚好装满、
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[nums.length - 1][sum];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}