//给你一个字符串 s 和一个整数 k 。你可以选择字符串中的任一字符，并将其更改为任何其他大写英文字符。该操作最多可执行 k 次。 
//
// 在执行上述操作后，返回包含相同字母的最长子字符串的长度。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ABAB", k = 2
//输出：4
//解释：用两个'A'替换为两个'B',反之亦然。
// 
//
// 示例 2： 
//
// 
//输入：s = "AABABBA", k = 1
//输出：4
//解释：
//将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
//子串 "BBBB" 有最长重复字母, 答案为 4。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁵ 
// s 仅由大写英文字母组成 
// 0 <= k <= s.length 
// 
// Related Topics 哈希表 字符串 滑动窗口 👍 653 👎 0


package leetcode.editor.cn;

import java.util.HashMap;

public class XL_424_LongestRepeatingCharacterReplacement{
    public static void main(String[] args) {
        Solution solution = new XL_424_LongestRepeatingCharacterReplacement().new Solution();
        solution.characterReplacement("ABAB", 2);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int characterReplacement(String s, int k) {
        int[] nums = new int[26];
        int length = s.length();
        int left = 0, right = 0, maxN = 0; // 最长重复字符数、
        // 利用 right - left 维持最大区间长度、只要保持区间长度只增不减、就一定能找到最大符合条件区间长度、当然最后指向这个区间不一定是目标区间、但长度一定正确、

        while(right < length){
            nums[s.charAt(right) - 'A']++;
            maxN = Math.max(maxN, nums[s.charAt(right) - 'A']); // right在上一轮结束时右移、可能引发区间长度增大、因此需要对最大重复字符数修正、

            // 必须放后面、当前已经检查right 所以区间窗口为 left ~ right、长度为 right - left + 1、
            if(right - left - maxN + 1 > k){
                // 区间不满足、
                nums[s.charAt(left) - 'A']--;
                left++;
                // left 和 right 都右移、不可能造成区间大小增大、因此不需要判断、
            }
            right++;

        }
        return right - left;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}