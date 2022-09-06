//在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。 
//
// 示例 1: 
//
// 
//输入：s = "abaccdeff"
//输出：'b'
// 
//
// 示例 2: 
//
// 
//输入：s = "" 
//输出：' '
// 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 50000 
// Related Topics 队列 哈希表 字符串 计数 👍 263 👎 0


package leetcode.editor.cn;

import java.util.HashMap;

/*

        执行用时: 28 ms ,在所有Java提交中击败了20.67%的用户
        内存消耗:42.1MB ，在所有Java提交中击败了19.51%的用户

        先hash再遍历出第一个次数1、
*/

public class XL_2514_DiYiGeZhiChuXianYiCiDeZiFuLcof{
    public static void main(String[] args) {
        Solution solution = new XL_2514_DiYiGeZhiChuXianYiCiDeZiFuLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public char firstUniqChar(String s) {
        // 直接用基数排序更好、
        HashMap<Character, Integer> hashMap = new HashMap<>();
        char[] temps = s.toCharArray();
        for(char temp : temps){
            if(hashMap.containsKey(temp)){
                hashMap.put(temp, hashMap.get(temp) + 1);
            }
            else {
                hashMap.put(temp, 1);
            }
        }

        for(char temp : temps){
            if(hashMap.get(temp) == 1)
                return temp;
        }
        return ' ';
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}