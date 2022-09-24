//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 1 <= n <= 2 * 10⁴ 
// 0 <= height[i] <= 10⁵ 
// 
// Related Topics 栈 数组 双指针 动态规划 单调栈 👍 3804 👎 0


package leetcode.editor.cn;

/*解答成功:
        执行耗时:752 ms,击败了5.99% 的Java用户
        内存消耗:42.1 MB,击败了50.91% 的Java用户

        暴力法、只关注当前格子能装多少雨水、最后加起来、

解答成功:
		执行耗时:1 ms,击败了76.20% 的Java用户
		内存消耗:42.3 MB,击败了37.49% 的Java用户

		暴力法的基础上优化、预先计算并保存 l_max 和 r_max、
*/
public class XL_42_TrappingRainWater{
    public static void main(String[] args) {
        Solution solution = new XL_42_TrappingRainWater().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int trap(int[] height) {
        int n = height.length;
        int res = 0;

        int[] r_max = new int[n];
        int[] l_max = new int[n];
        r_max[n - 1] = height[n - 1];
        l_max[0] = height[0];

        for (int i = 1; i < n; i++) {
            l_max[i] = Math.max(l_max[i - 1], height[i]);
        }

        for (int i = n - 2; i >= 0 ; i--) {
            r_max[i] = Math.max(r_max[i + 1], height[i]);
        }

        for (int i = 0; i < n; i++) {
            res = res + Math.min(r_max[i], l_max[i]) - height[i];
        }
        return res;
    }

    public int trapV0(int[] height) {
        int n = height.length;
        int res = 0;

        for (int i = 0; i < n; i++) {
            int l_max = 0, r_max = 0;
            for (int j = i; j < n; j++) {
                l_max = Math.max(l_max, height[j]);
            }

            for (int j = i; j >= 0 ; j--) {
                r_max = Math.max(r_max, height[j]);
            }

            res = res + Math.min(r_max, l_max) - height[i];
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}