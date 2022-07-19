//给定一个字符串，对该字符串可以进行 “移位” 的操作，也就是将字符串中每个字母都变为其在字母表中后续的字母，比如："abc" -> "bcd"。这样，我们可
//以持续进行 “移位” 操作，从而生成如下移位序列： 
//
// "abc" -> "bcd" -> ... -> "xyz" 
//
// 给定一个包含仅小写字母字符串的列表，将该列表中所有满足 “移位” 操作规律的组合进行分组并返回。 
//
// 
//
// 示例： 
//
// 输入：["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"]
//输出：
//[
//  ["abc","bcd","xyz"],
//  ["az","ba"],
//  ["acef"],
//  ["a","z"]
//]
//解释：可以认为字母表首尾相接，所以 'z' 的后续为 'a'，所以 ["az","ba"] 也满足 “移位” 操作规律。 
// Related Topics 数组 哈希表 字符串 👍 89 👎 0


package leetcode.editor.cn;

import java.util.*;

public class XL_249_GroupShiftedStrings{
    public static void main(String[] args) {
        Solution solution = new XL_249_GroupShiftedStrings().new Solution();
        solution.groupStrings(new String[]{"abc","al"});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        HashMap<String, List<String>> hashMap = new HashMap<>();
        for (String str:
                strings) {
            String key = getKey(str);
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

    public String getKey(String target){
        if(target.length() == 1)
            return "0,";
        StringBuilder result = new StringBuilder("0,");

        // 把当前位与前一位的差值添加到key、防止差值出现歧义、添加分隔符、
        for(int i = 1; i < target.length(); i++){
            int temp = target.charAt(i) - target.charAt(i - 1);
            temp = (temp > 0) ? temp : temp + 26;
            result.append(temp);
            result.append(',');
        }
        return result.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}