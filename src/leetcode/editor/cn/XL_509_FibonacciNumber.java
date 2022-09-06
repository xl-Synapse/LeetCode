//斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是： 
//
// 
//F(0) = 0，F(1) = 1
//F(n) = F(n - 1) + F(n - 2)，其中 n > 1
// 
//
// 给定 n ，请计算 F(n) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：1
//解释：F(2) = F(1) + F(0) = 1 + 0 = 1
// 
//
// 示例 2： 
//
// 
//输入：n = 3
//输出：2
//解释：F(3) = F(2) + F(1) = 1 + 1 = 2
// 
//
// 示例 3： 
//
// 
//输入：n = 4
//输出：3
//解释：F(4) = F(3) + F(2) = 2 + 1 = 3
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 30 
// 
// Related Topics 递归 记忆化搜索 数学 动态规划 👍 525 👎 0


package leetcode.editor.cn;

/*解答成功:
        执行耗时:0 ms,击败了100.00% 的Java用户
        内存消耗:38.5 MB,击败了15.79% 的Java用户

*/
public class XL_509_FibonacciNumber{
    public static void main(String[] args) {
        Solution solution = new XL_509_FibonacciNumber().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int fib(int n) {
        if(n == 0)
            return 0;

        int dp1 = 0, dp2 = 1;
        for(int i = 2; i <= n; i++) {
            int temp = dp1 + dp2;
            dp1 = dp2;
            dp2 = temp;
        }

        return dp2;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}