//给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。 
//
// 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。 
//
// 
//
// 示例 1: 
//
// 
//输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出: [["bat"],["nat","tan"],["ate","eat","tea"]] 
//
// 示例 2: 
//
// 
//输入: strs = [""]
//输出: [[""]]
// 
//
// 示例 3: 
//
// 
//输入: strs = ["a"]
//输出: [["a"]] 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 10⁴ 
// 0 <= strs[i].length <= 100 
// strs[i] 仅包含小写字母 
// 
// Related Topics 数组 哈希表 字符串 排序 👍 1202 👎 0


package leetcode.editor.cn;

import java.util.*;

public class XL_49_GroupAnagrams{
    public static void main(String[] args) {
        Solution solution = new XL_49_GroupAnagrams().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hashMap = new HashMap<>();
        for (String str:
             strs) {
            String key = sort(str);
            if(hashMap.containsKey(key)){
                hashMap.get(key).add(str);
            }
            else {
                List<String> newList = new ArrayList<String>();
                newList.add(str);
                hashMap.put(key, newList);
            }
        }

        List<List<String>> result = new ArrayList<>();
        // 遍历hashmap并组合、
        for(Iterator<List<String>> iterator = hashMap.values().iterator(); iterator.hasNext();){
            result.add(iterator.next());
        }
        return result;
    }

    public String sort(String target){
        char[] array = target.toCharArray();
        Arrays.sort(array);
        return new String(array);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}