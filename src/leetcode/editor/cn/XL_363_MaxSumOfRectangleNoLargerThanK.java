//给你一个 m x n 的矩阵 matrix 和一个整数 k ，找出并返回矩阵内部矩形区域的不超过 k 的最大数值和。 
//
// 题目数据保证总会存在一个数值和不超过 k 的矩形区域。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,0,1],[0,-2,3]], k = 2
//输出：2
//解释：蓝色边框圈出来的矩形区域 [[0, 1], [-2, 3]] 的数值和是 2，且 2 是不超过 k 的最大数字（k = 2）。
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[2,2,-1]], k = 3
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 100 
// -100 <= matrix[i][j] <= 100 
// -10⁵ <= k <= 10⁵ 
// 
//
// 
//
// 进阶：如果行数远大于列数，该如何设计解决方案？ 
// Related Topics 数组 二分查找 动态规划 矩阵 有序集合 👍 413 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.TreeSet;

public class XL_363_MaxSumOfRectangleNoLargerThanK{
    public static void main(String[] args) {
        Solution solution = new XL_363_MaxSumOfRectangleNoLargerThanK().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int[] nums = new int[matrix[0].length];
        int result = Integer.MIN_VALUE;

        for(int i = 0; i < matrix.length; i++){
            Arrays.fill(nums, 0);
            for(int j = i; j < matrix.length; j++){
                // ij 行夹逼、
                for(int m = 0; m < matrix[0].length; m++){
                    nums[m] += matrix[j][m];
                }

                // 这里求得是一个特殊的 sum、令 sum i = nums1+++numsi、 需要选择最小的 suml 满足大于 sumr - k、

                // 求最大子段和、
                int sum = 0;

                TreeSet<Integer> treeSet = new TreeSet<>();
                treeSet.add(0); // 最少要返回 0 、

                for (int num : nums) {
                    sum += num;
                    Integer minsumR = treeSet.ceiling(sum - k);
                    if (minsumR != null) {
                        // 存在满足条件的 sumr、
                        result = Math.max(result, sum - minsumR);
                    }
                    // 维持sum有序序列、
                    treeSet.add(sum);
                }
            }
        }
        return result;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}