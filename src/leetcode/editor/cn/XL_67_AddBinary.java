//给你两个二进制字符串，返回它们的和（用二进制表示）。 
//
// 输入为 非空 字符串且只包含数字 1 和 0。 
//
// 
//
// 示例 1: 
//
// 输入: a = "11", b = "1"
//输出: "100" 
//
// 示例 2: 
//
// 输入: a = "1010", b = "1011"
//输出: "10101" 
//
// 
//
// 提示： 
//
// 
// 每个字符串仅由字符 '0' 或 '1' 组成。 
// 1 <= a.length, b.length <= 10^4 
// 字符串如果不是 "0" ，就都不含前导零。 
// 
// Related Topics 位运算 数学 字符串 模拟 👍 847 👎 0


package leetcode.editor.cn;
public class XL_67_AddBinary{
  public static void main(String[] args) {
       Solution solution = new XL_67_AddBinary().new Solution();
       String result = solution.addBinary("11", "1");
      System.out.println(result);
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder(a);
        int isPlus = 0;
        for(int i = 0; i < b.length() || isPlus > 0; i++){
            if(i >= result.length()){
                result.insert(0, '0');
            }

            int tempA = result.charAt(result.length() - i - 1) - '0';
            int tempB = (i < b.length()) ? b.charAt(b.length() - i - 1) - '0' : 0;
            int sum = tempA + tempB + isPlus;

            result.setCharAt(result.length() - i - 1, (char) (sum % 2 + '0'));

            isPlus = sum / 2;

        }
        return result.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}