//给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的连续子数组的个数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1], k = 2
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3], k = 3
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -1000 <= nums[i] <= 1000 
// -10⁷ <= k <= 10⁷ 
// 
// Related Topics 数组 哈希表 前缀和 👍 1682 👎 0


package leetcode.editor.cn;

import java.util.HashMap;

/*解答成功:
        执行耗时:23 ms,击败了64.58% 的Java用户
        内存消耗:45.3 MB,击败了48.72% 的Java用户

        前缀和 + hash优化、
        存储 前缀和为 sum 的次数、最后遍历的时候查 sum - k次数、
*/
public class XL_560_SubarraySumEqualsK{
    public static void main(String[] args) {
        Solution solution = new XL_560_SubarraySumEqualsK().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 1);

        int sum = 0;
        int cnt = 0;
        for (int num : nums) {
            sum += num;
            cnt += hashMap.getOrDefault(sum - k, 0);


            // 维护定义、
            hashMap.put(sum, hashMap.getOrDefault(sum, 0) + 1);
        }
        return cnt;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}