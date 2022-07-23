//给你一个整数数组 nums，请你将该数组升序排列。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,2,3,1]
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：nums = [5,1,1,2,0,0]
//输出：[0,0,1,1,2,5]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 10⁴ 
// -5 * 10⁴ <= nums[i] <= 5 * 10⁴ 
// 
// Related Topics 数组 分治 桶排序 计数排序 基数排序 排序 堆（优先队列） 归并排序 👍 619 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

public class XL_912_SortAnArray{
    public static void main(String[] args) {
        Solution solution = new XL_912_SortAnArray().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        /**
         * 纯排序题、
         * 选择排序和冒泡排序都会超时、
         *
         * 暂时不写、直接学后面的排序、
         *
         * @param nums
         * @return
         */
    public int[] sortArray(int[] nums) {
        Arrays.sort(nums);
        return nums;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}