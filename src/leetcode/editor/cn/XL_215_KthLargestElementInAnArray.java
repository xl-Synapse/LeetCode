//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4], k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6], k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 1765 👎 0


package leetcode.editor.cn;
public class XL_215_KthLargestElementInAnArray{
    public static void main(String[] args) {
        Solution solution = new XL_215_KthLargestElementInAnArray().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        /**
         * 选择插入排序、但是已经会超时了、
         * 不超时得用堆排序、
         *
         * @param nums
         * @param k
         * @return
         */
    public int findKthLargest(int[] nums, int k) {
        int temp = Integer.MIN_VALUE;
        int tempIndex = -1;
        for(int i = 0; i < k; i++){ // 只需要找到第k大、
            for(int j = i; j < nums.length; j++){
                if(nums[j] > temp){
                    temp = nums[j];
                    tempIndex = j;
                }
            }
            // 找到了该轮的最大、
            nums[tempIndex] = nums[i];
            nums[i] = temp;
            temp = Integer.MIN_VALUE;
        }
        return nums[k - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}