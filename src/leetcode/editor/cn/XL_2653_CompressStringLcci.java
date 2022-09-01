//字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没
//有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。 
//
// 示例1: 
//
// 
// 输入："aabcccccaaa"
// 输出："a2b1c5a3"
// 
//
// 示例2: 
//
// 
// 输入："abbccd"
// 输出："abbccd"
// 解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
// 
//
// 提示： 
//
// 
// 字符串长度在[0, 50000]范围内。 
// 
// Related Topics 双指针 字符串 👍 145 👎 0

/*执行结果：
        通过
        执行用时：        5 ms        , 在所有 Java 提交中击败了        42.60%        的用户
        内存消耗：        41.4 MB        , 在所有 Java 提交中击败了        46.36%        的用户
        */
package leetcode.editor.cn;
public class XL_2653_CompressStringLcci{
    public static void main(String[] args) {
        Solution solution = new XL_2653_CompressStringLcci().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String compressString(String S) {
        int left = 0;
        int right = 0;
        int num = 0;
        StringBuilder sb = new StringBuilder();
        for(; right < S.length(); right++){
            if(S.charAt(left) == S.charAt(right)){
                num++;
            }
            else {
                sb.append(S.charAt(left));
                sb.append(num);
                left = right;
                num = 0;
            }
        }
        sb.append(S.charAt(left));
        sb.append(num + 1);

        return (sb.length() < S.length()) ? sb.toString() : S;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}