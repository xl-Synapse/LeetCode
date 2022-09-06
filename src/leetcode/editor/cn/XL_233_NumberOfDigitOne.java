//给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 13
//输出：6
// 
//
// 示例 2： 
//
// 
//输入：n = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 10⁹ 
// 
// Related Topics 递归 数学 动态规划 👍 456 👎 0


package leetcode.editor.cn;
public class XL_233_NumberOfDigitOne{
    public static void main(String[] args) {
        Solution solution = new XL_233_NumberOfDigitOne().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countDigitOne(int n) {
        if(n < 1)
            return 0;
        int num = 1; // 个位上只可能出现一个1、

        int now = 2;
        while(n > 0){
            if(n % 10 >= 1){
                // 上一位支持1、
                if(n / 10 > 0){
                    // 这一位还有、
                    num = now + 1;
                }
            }

            n /= 10;
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}