//给定一个未排序的整数数组 nums ， 返回最长递增子序列的个数 。 
//
// 注意 这个数列必须是 严格 递增的。 
//
// 
//
// 示例 1: 
//
// 
//输入: [1,3,5,4,7]
//输出: 2
//解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
// 
//
// 示例 2: 
//
// 
//输入: [2,2,2,2,2]
//输出: 5
//解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。
// 
//
// 
//
// 提示: 
//
// 
//
// 
// 1 <= nums.length <= 2000 
// -10⁶ <= nums[i] <= 10⁶ 
// 
// Related Topics 树状数组 线段树 数组 动态规划 👍 629 👎 0


package leetcode.editor.cn;
public class XL_673_NumberOfLongestIncreasingSubsequence{
    public static void main(String[] args) {
        Solution solution = new XL_673_NumberOfLongestIncreasingSubsequence().new Solution();
        System.out.println(solution.findNumberOfLIS(new int[]{1,2,4,3,5,4,7,2}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int[] tnums;
    private int[] temps;
    private int[] lengthes;

        /**
         * 解答成功:
         * 			执行耗时:24 ms,击败了12.78% 的Java用户
         * 			内存消耗:41 MB,击败了51.52% 的Java用户
         * @param nums
         * @return
         */

    public int findNumberOfLIS(int[] nums) {
        tnums = nums;
        temps = new int[nums.length]; // 以i结尾的最长子序列长度、
        lengthes = new int[nums.length]; // 以i结尾的最长子序列数量、

        int maxL = 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            temps[i] = 1;
            lengthes[i] = 1;
            for (int j = 0; j < i; j++) { // 必须把所有子问题都扫描一遍、才能得到最优解、
                if (tnums[j] < tnums[i]) { // 可以在倒数第二为j、倒数第一为i的情况下满足序列条件、
                    // 此时temps[i]还没有确定、但是可以开始维持、
                    if (temps[j] + 1 > temps[i]) {
                        // 重置计数和维持、
                        temps[i] = temps[j] + 1;
                        lengthes[i] = lengthes[j];
                    }
                    else if(temps[j] + 1 == temps[i]){
                        // 可以达到相同的最大子序列长度、累加、
                        lengthes[i] += lengthes[j];
                    }
                }
            }

            // temps[i] 已经确定、
            if (maxL < temps[i]) {
                // 重置总计数、
                maxL = temps[i];
                result = lengthes[i];
            }
            else if(maxL == temps[i]){
                result += lengthes[i];
            }
        }

        return result;
    }
}

    /**
     * 解答成功:
     * 			执行耗时:23 ms,击败了15.57% 的Java用户
     * 			内存消耗:41 MB,击败了52.54% 的Java用户
     */

//    public int findNumberOfLIS(int[] nums) {
//        tnums = nums;
//        temps = new int[nums.length];
//        lengthes = new int[nums.length];
//
//        int result = 0;
//        for(int i = 0; i < nums.length; i++){
//            int maxi = 0;
//            for(int j = 0; j < i; j++){ // 必须把所有子问题都扫描一遍、才能得到最优解、
//                if(tnums[j] < tnums[i]) { // 可以在倒数第二为j、倒数第一为i的情况下满足序列条件、
//                    maxi = Math.max(temps[j], maxi);
//                }
//            }
//            temps[i] = maxi + 1; // 以i结尾的最长子序列长度、
//            result = Math.max(result, temps[i]);
//        }
//
//        // 动态规划以i结尾的满足长度temps[i]的子序列数量、并填表、
//        for(int i = 0; i < nums.length; i++) {
//            if(temps[i] == 1){
//                lengthes[i] = 1;
//                continue;
//            }
//            for (int j = 0; j < i; j++) {
//                if(tnums[j] < tnums[i] && temps[j] + 1 == temps[i]){
//                    // 可以组成满足 temps[i] 的序列、
//                    lengthes[i] += lengthes[j];
//                }
//            }
//        }
//
//        int numOfLIS = 0;
//        // 最后查表、满足最长子序列的数目、
//        for(int i = 0; i < lengthes.length; i++){
//            if(result == temps[i]){
//                numOfLIS += lengthes[i];
//            }
//        }
//        return numOfLIS;
//    }
//
//    }
//leetcode submit region end(Prohibit modification and deletion)

}