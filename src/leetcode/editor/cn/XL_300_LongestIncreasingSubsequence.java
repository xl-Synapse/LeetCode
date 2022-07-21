//给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。 
//
// 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子
//序列。 
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,9,2,5,3,7,101,18]
//输出：4
//解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,0,3,2,3]
//输出：4
// 
//
// 示例 3： 
//
// 
//输入：nums = [7,7,7,7,7,7,7]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2500 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
//
// 进阶： 
//
// 
// 你能将算法的时间复杂度降低到 O(n log(n)) 吗? 
// 
// Related Topics 数组 二分查找 动态规划 👍 2637 👎 0


package leetcode.editor.cn;
public class XL_300_LongestIncreasingSubsequence{
    public static void main(String[] args) {
        Solution solution = new XL_300_LongestIncreasingSubsequence().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int[] tnums;
    private int[] temps;
//    public int lengthOfLIS(int[] nums) {
//        tnums = nums;
//        temps = new int[nums.length];
//
//        int result = 0;
//        for(int i = 0; i < nums.length; i++){
//            result = Math.max(result, f(i));
//        }
//        return result;
//    }

        /**
         * 自顶向下非递归写法、节省传参时间、
         * 解答成功:
         * 			执行耗时:49 ms,击败了75.70% 的Java用户
         * 			内存消耗:41.1 MB,击败了31.81% 的Java用户
         * @param nums
         * @return
         */
    public int lengthOfLIS(int[] nums) {
        tnums = nums;
        temps = new int[nums.length];

        int result = 0;
        for(int i = 0; i < nums.length; i++){
            int maxi = 0;
            for(int j = 0; j < i; j++){ // 必须把所有子问题都扫描一遍、才能得到最优解、
                if(tnums[j] < tnums[i])
                    maxi = Math.max(temps[j], maxi);
            }
            temps[i] = maxi + 1;
            result = Math.max(result, temps[i]);
        }
        return result;
    }



//        /**
//         * 记忆化递归、自顶向下、
//         * 解答成功:
//         * 			执行耗时:55 ms,击败了71.26% 的Java用户
//         * 			内存消耗:40.9 MB,击败了54.83% 的Java用户
//         * @param i
//         * @return
//         */
//    public int f(int i){
////        if(temps[i] != 0)
////            return temps[i];
//        int maxi = 0;
//        for(int j = 0; j < i; j++){ // 必须把所有子问题都扫描一遍、才能得到最优解、
//            if(tnums[j] < tnums[i])
//                maxi = Math.max(temps[j], maxi);
//        }
//        temps[i] = maxi + 1;
//        return temps[i];
//    }




//        /**
//         * 普通递归、超时、
//         * @param i
//         * @return
//         */
//    public int f(int i){
//        int maxi = 0;
//        for(int j = 0; j < i; j++){ // 必须把所有子问题都扫描一遍、才能得到最优解、
//            if(tnums[j] < tnums[i])
//                maxi = Math.max(f(j), maxi);
//        }
//        return maxi + 1;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

}