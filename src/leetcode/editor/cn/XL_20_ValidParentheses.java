//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 每个右括号都有一个对应的相同类型的左括号。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 👍 3512 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Stack;

/*解答成功:
        执行耗时:2 ms,击败了52.87% 的Java用户
        内存消耗:39.5 MB,击败了56.86% 的Java用户

        栈简单题、
*/
public class XL_20_ValidParentheses{
    public static void main(String[] args) {
        Solution solution = new XL_20_ValidParentheses().new Solution();
        solution.isValid("()");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        if(s.length() % 2 != 0)
            return false;

        HashMap<Character, Character> hashMap = new HashMap<>();
        hashMap.put(')', '(');
        hashMap.put(']', '[');
        hashMap.put('}', '{');

        Stack<Character> stack = new Stack<>();
        boolean flag = true;
        for (int i = 0; i < s.length() && flag; i++) {
            char temp = s.charAt(i);
            switch (temp){
                case '(':
                case '[':
                case '{':
                    stack.push(temp);
                    break;
                case ')':
                case ']':
                case '}':
                    if(stack.isEmpty()){
                        // 不可能匹配、
                        flag = false;
                    }
                    else {
                        char last = stack.pop();
                        flag = (last == hashMap.get(temp));
                    }
                    break;
            }
        }
        return flag && stack.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}