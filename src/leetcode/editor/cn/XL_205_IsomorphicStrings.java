//给定两个字符串 s 和 t ，判断它们是否是同构的。 
//
// 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。 
//
// 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。 
//
// 
//
// 示例 1: 
//
// 
//输入：s = "egg", t = "add"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "foo", t = "bar"
//输出：false 
//
// 示例 3： 
//
// 
//输入：s = "paper", t = "title"
//输出：true 
//
// 
//
// 提示： 
//
// 
//
// 
// 1 <= s.length <= 5 * 10⁴ 
// t.length == s.length 
// s 和 t 由任意有效的 ASCII 字符组成 
// 
// Related Topics 哈希表 字符串 👍 485 👎 0


package leetcode.editor.cn;

import java.util.HashMap;

public class XL_205_IsomorphicStrings{
    public static void main(String[] args) {
        Solution solution = new XL_205_IsomorphicStrings().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Integer> hashMap1 = new HashMap<>();
        HashMap<Character, Integer> hashMap2 = new HashMap<>();
        if(s.length() != t.length())
            return false;
        for(int i = 0; i < s.length(); i++){
            if(hashMap1.containsKey(s.charAt(i))){
                // 重复字符、
                int indexS = hashMap1.get(s.charAt(i));
                if(t.charAt(indexS) != t.charAt(i))
                    return false;
            }
            else {
                // 新字符、
                if (hashMap2.containsKey(t.charAt(i)))
                    return false;
                hashMap1.put(s.charAt(i), i);
                hashMap2.put(t.charAt(i), i);
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}