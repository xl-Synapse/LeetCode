//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// Related Topics 哈希表 字符串 回溯 👍 2089 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;


/*解答成功:
        执行耗时:5 ms,击败了15.40% 的Java用户
        内存消耗:40.2 MB,击败了46.68% 的Java用户

        暴力、回溯、队列法、
*/
public class XL_17_LetterCombinationsOfAPhoneNumber{
    public static void main(String[] args) {
        Solution solution = new XL_17_LetterCombinationsOfAPhoneNumber().new Solution();
        solution.letterCombinations("23");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0)
            return new ArrayList<>();

        List<String> queue = new ArrayList<>();
        String[] temp = new String[]{"", "", "abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

        for(char now : temp[digits.charAt(0) - '0'].toCharArray()){
            queue.add("" + now);
        }

        for(int i = 1; i < digits.length(); i++){
            int size = queue.size();
            for(int j = 0; j < size; j++){
                String lastStr = queue.get(0);
                queue.remove(0);

                for(char now : temp[digits.charAt(i) - '0'].toCharArray()){
                    queue.add(lastStr + now);
                }
            }
        }
        return queue;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}