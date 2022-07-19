//给定一个二进制数组 nums 和一个整数 k，如果可以翻转最多 k 个 0 ，则返回 数组中连续 1 的最大个数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1,0,0,0,1,1,1,1,0], K = 2
//输出：6
//解释：[1,1,1,0,0,1,1,1,1,1,1]
//粗体数字从 0 翻转到 1，最长的子数组长度为 6。 
//
// 示例 2： 
//
// 
//输入：nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
//输出：10
//解释：[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
//粗体数字从 0 翻转到 1，最长的子数组长度为 10。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// nums[i] 不是 0 就是 1 
// 0 <= k <= nums.length 
// 
// Related Topics 数组 二分查找 前缀和 滑动窗口 👍 443 👎 0


package leetcode.editor.cn;
public class XL_1004_MaxConsecutiveOnesIii{ // 与424解法完全不同、
    public static void main(String[] args) {
        Solution solution = new XL_1004_MaxConsecutiveOnesIii().new Solution();
        System.out.println(solution.longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestOnes(int[] nums, int k) {
        // 转化为求最长子区间、其中最多k个0、
        // 双指针滑动窗口、
        int maxL = 0;
        int max0 = 0;
        int left = 0, right = 0;

        while(right < nums.length){
            // right右移、遇到0、增加数量、
            if(nums[right] == 0){
                max0++;
            }

            // 区间不满足条件、left右移、直到区间再次满足条件、
            while (max0 > k){
                if(nums[left++] == 0)
                    max0--;
            }

            // 维持最大区间长度、
            maxL = Math.max(maxL, right - left + 1);
            right++;
        }
        return maxL;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}