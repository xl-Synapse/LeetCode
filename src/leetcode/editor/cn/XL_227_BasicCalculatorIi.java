//给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。 
//
// 整数除法仅保留整数部分。 
//
// 你可以假设给定的表达式总是有效的。所有中间结果将在 [-2³¹, 2³¹ - 1] 的范围内。 
//
// 注意：不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "3+2*2"
//输出：7
// 
//
// 示例 2： 
//
// 
//输入：s = " 3/2 "
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：s = " 3+5 / 2 "
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 10⁵ 
// s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开 
// s 表示一个 有效表达式 
// 表达式中的所有整数都是非负整数，且在范围 [0, 2³¹ - 1] 内 
// 题目数据保证答案是一个 32-bit 整数 
// 
// Related Topics 栈 数学 字符串 👍 619 👎 0


package leetcode.editor.cn;

import java.util.Stack;


/*解答成功:
        执行耗时:18 ms,击败了42.55% 的Java用户
        内存消耗:41.3 MB,击败了91.83% 的Java用户

        单栈法、提前模拟一个+号在等式前面、+ -只能入栈当前数、而* /需要出栈上一个数与当前数计算后再入栈、
        此方法只能没有括号、括号需要加递归、
*/
public class XL_227_BasicCalculatorIi{
    public static void main(String[] args) {
        Solution solution = new XL_227_BasicCalculatorIi().new Solution();
        solution.calculate("3+ 2* 2");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int calculate(String s) {
        s = s.trim();

        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char last = '+';

        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if(temp == ' ')
                continue;

            if(isDigit(temp)){
                num = num * 10 + (temp - '0');
                if(i != s.length() - 1)
                    continue;
            }

            switch (last) {
                case '+':
                    stack.push(num);
                    break;
                case '-':
                    stack.push(-num);
                    break;
                case '*':
                    stack.push(stack.pop() * num);
                    break;
                case '/':
                    stack.push(stack.pop() / num);
                    break;
            }
            last = temp;
            num = 0;

        }

        int res = 0; // 最后一个数字没有入栈、
        while(!stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }

    private boolean isDigit(char target){
        return target >= '0' && target <= '9';
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}