//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 字符串 滑动窗口 👍 7856 👎 0


package leetcode.editor.cn;

import java.util.HashSet;

public class XL_3_LongestSubstringWithoutRepeatingCharacters{
    public static void main(String[] args) {
        Solution solution = new XL_3_LongestSubstringWithoutRepeatingCharacters().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hashSet = new HashSet<>();

        int left = 0, right = 0;
        int maxL = 0;
        int length = s.length();

        while(right < length){
            //
            if(hashSet.contains(s.charAt(right))){
                // 区间不满足要求、
                while(s.charAt(left) != s.charAt(right)){
                    hashSet.remove(s.charAt(left));
                    left++;
                }

                // 当前区间首位字符相同、left再移动一位、
                left++;
            }
            else {
                // 该字符满足要求、放入hashset、
                hashSet.add(s.charAt(right));
            }

            maxL = Math.max(maxL, right - left + 1);

            //
            right++;
        }
        return maxL;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}