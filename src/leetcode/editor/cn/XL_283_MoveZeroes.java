//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 请注意 ，必须在不复制数组的情况下原地对数组进行操作。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [0,1,0,3,12]
//输出: [1,3,12,0,0]
// 
//
// 示例 2: 
//
// 
//输入: nums = [0]
//输出: [0] 
//
// 
//
// 提示: 
// 
//
// 
// 1 <= nums.length <= 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 
//
// 
//
// 进阶：你能尽量减少完成的操作次数吗？ 
// Related Topics 数组 双指针 👍 1666 👎 0


package leetcode.editor.cn;
public class XL_283_MoveZeroes{
    public static void main(String[] args) {
        Solution solution = new XL_283_MoveZeroes().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        /**
         * 非零全部往前面放、最后把剩余全部置0、
         *
         * 解答成功:
         * 			执行耗时:1 ms,击败了100.00% 的Java用户
         * 			内存消耗:43.2 MB,击败了5.76% 的Java用户
         * @param nums
         */
        public void moveZeroes(int[] nums) {
            int index = 0;
            for(int i = 0; i < nums.length; i++){
                if(nums[i] != 0)
                    nums[index++] = nums[i];
            }

            while(index < nums.length)
                nums[index++] = 0;
        }

        /**
         * 冒泡最高优化、
         * 解答成功:
         * 			执行耗时:131 ms,击败了5.01% 的Java用户
         * 			内存消耗:43.1 MB,击败了11.70% 的Java用户
         */
/*    public void moveZeroes(int[] nums) {
        int lastChangeIndex = nums.length;
        int tempIndex = 0;
        boolean isChange = true;

        for(int i = 0; i < nums.length; i++){
            if(!isChange) // 上一轮没有发生交换、已经有序、
                return;
            isChange = false;

            for(int j = 1; j < lastChangeIndex; j++){
                if(nums[j - 1] == 0){
                    // 发生交换、
                    nums[j - 1] = nums[j];
                    nums[j] = 0;
                    tempIndex = j;
                    isChange = true;
                }
            }
            // 这一轮冒泡完毕、保存最后交换的index、
            lastChangeIndex = tempIndex;
        }
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)

}