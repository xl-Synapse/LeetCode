//给定一个字符串 s ，找出 至多 包含两个不同字符的最长子串 t ，并返回该子串的长度。 
//
// 示例 1: 
//
// 输入: "eceba"
//输出: 3
//解释: t 是 "ece"，长度为3。
// 
//
// 示例 2: 
//
// 输入: "ccaabbb"
//输出: 5
//解释: t 是 "aabbb"，长度为5。
// 
// Related Topics 哈希表 字符串 滑动窗口 👍 178 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;

public class XL_159_LongestSubstringWithAtMostTwoDistinctCharacters{
    public static void main(String[] args) {
        Solution solution = new XL_159_LongestSubstringWithAtMostTwoDistinctCharacters().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private HashMap<Character, Integer> hashMap = new HashMap<>();
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        hashMap.clear();

        int left = 0;
        int right = 0;

        int maxL = 0;
        int length = s.length();

        while (right < length){
            // 处理right、

            numsAdd(s.charAt(right));

            // 判断区间、是否移动left、
            while (hashMap.size() > 2){
                numsDel(s.charAt(left++));
            }

            // 符合条件的区间、维持最大长度、
            maxL = Math.max(right - left + 1, maxL);

            // 移动right、
            right++;
        }
        return maxL;
    }


    private void numsAdd(char target){
        if(!hashMap.containsKey(target))
            hashMap.put(target, 1);
        else
            hashMap.put(target, hashMap.get(target) + 1);
    }

    private void numsDel(char target){
        // 一定有添加过、才可能触发del、
        if(hashMap.get(target) == 1)
            hashMap.remove(target);
        else
            hashMap.put(target, hashMap.get(target) - 1);
    }

//    以下为另一种题目理解的解法、同424题、

//    private HashMap<Character, Integer> hashMap = new HashMap<>();
//    public int lengthOfLongestSubstringTwoDistinct(String s) {
//        hashMap.clear();
//
//        int left = 0;
//        int right = 0;
//
//        int maxN = 0; // 最长重复字符数、
//        int length = s.length();
//        // 利用 right - left 维持最大区间长度、只要保持区间长度只增不减、就一定能找到最大符合条件区间长度、当然最后指向这个区间不一定是目标区间、但长度一定正确、
//
//        while(right < length){
//            numsAdd(s.charAt(right));
//            maxN = Math.max(maxN, hashMap.get(s.charAt(right))); // right在上一轮结束时右移、可能引发区间长度增大、因此需要对最大重复字符数修正、
//
//            // 必须放后面、当前已经检查right 所以区间窗口为 left ~ right、长度为 right - left + 1、
//            if(right - left - maxN + 1 > 2){
//                // 区间不满足、
//                numsDel(s.charAt(left));
//                left++;
//                // left 和 right 都右移、不可能造成区间大小增大、因此不需要判断、
//            }
//            right++;
//
//        }
//        return right - left;
//
//    }
//
//    private void numsAdd(char target){
//        if(!hashMap.containsKey(target))
//            hashMap.put(target, 1);
//        else
//            hashMap.put(target, hashMap.get(target) + 1);
//    }
//
//    private void numsDel(char target){
//        // 一定有添加过、才可能触发del、
//        hashMap.put(target, hashMap.get(target) - 1);
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

}