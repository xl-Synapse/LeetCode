//单词的 缩写 需要遵循 这样的格式。如果单词只有两个字符，那么它就是它自身的 缩写 。 
//
// 以下是一些单词缩写的范例： 
//
// 
// dog --> d1g 因为第一个字母 'd' 和最后一个字母 'g' 之间有 1 个字母 
// internationalization --> i18n 因为第一个字母 'i' 和最后一个字母 'n' 之间有 18 个字母 
// it --> it 单词只有两个字符，它就是它自身的 缩写 
// 
//
// 
//
// 实现 ValidWordAbbr 类： 
//
// 
// ValidWordAbbr(String[] dictionary) 使用单词字典 dictionary 初始化对象 
// boolean isUnique(string word) 如果满足下述任意一个条件，返回 true ；否则，返回 false ：
// 
// 字典 dictionary 中没有任何其他单词的 缩写 与该单词 word 的 缩写 相同。 
// 字典 dictionary 中的所有 缩写 与该单词 word 的 缩写 相同的单词都与 word 相同 。 
// 
// 
// 
//
// 
//
// 示例： 
//
// 
//输入
//["ValidWordAbbr", "isUnique", "isUnique", "isUnique", "isUnique", "isUnique"]
//[[["deer", "door", "cake", "card"]], ["dear"], ["cart"], ["cane"], ["make"], [
//"cake"]]
//输出
//[null, false, true, false, true, true]
//
//解释
//ValidWordAbbr validWordAbbr = new ValidWordAbbr(["deer", "door", "cake", 
//"card"]);
//validWordAbbr.isUnique("dear"); // 返回 false，字典中的 "deer" 与输入 "dear" 的缩写都是 "d2
//r"，但这两个单词不相同
//validWordAbbr.isUnique("cart"); // 返回 true，字典中不存在缩写为 "c2t" 的单词
//validWordAbbr.isUnique("cane"); // 返回 false，字典中的 "cake" 与输入 "cane" 的缩写都是 "c2
//e"，但这两个单词不相同
//validWordAbbr.isUnique("make"); // 返回 true，字典中不存在缩写为 "m2e" 的单词
//validWordAbbr.isUnique("cake"); // 返回 true，因为 "cake" 已经存在于字典中，并且字典中没有其他缩写为 "c2
//e" 的单词
// 
//
// 
//
// 提示： 
//
// 
// 1 <= dictionary.length <= 3 * 10⁴ 
// 1 <= dictionary[i].length <= 20 
// dictionary[i] 由小写英文字母组成 
// 1 <= word <= 20 
// word 由小写英文字母组成 
// 最多调用 5000 次 isUnique 
// 
// Related Topics 设计 数组 哈希表 字符串 👍 17 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;

public class XL_288_UniqueWordAbbreviation{
    public static void main(String[] args) {
        String[] dictionary = new String[]{"deer","door","cake","card"};
        ValidWordAbbr solution = new XL_288_UniqueWordAbbreviation().new ValidWordAbbr(dictionary);
        System.out.println(solution.isUnique("door"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /***
     * 空间使用太多、但是从复杂度的分析上、时间空间都是 O(n)、
     */

class ValidWordAbbr {
    private HashMap<String, HashSet<String>> hashMap;

    public ValidWordAbbr(String[] dictionary) {
        hashMap = new HashMap<>();
        for (String word:
             dictionary) {
            String simpleForm = getSimpleForm(word);

            if(hashMap.containsKey(simpleForm)){
                hashMap.get(simpleForm).add(word);
            }
            else {
                HashSet<String> hashSet = new HashSet<>();
                hashSet.add(word);
                hashMap.put(simpleForm, hashSet);
            }
        }
    }
    
    public boolean isUnique(String word) {
        String simpleForm = getSimpleForm(word);
        if(hashMap.containsKey(simpleForm)){
            HashSet<String> hashSet = hashMap.get(getSimpleForm(word));
            if(hashSet.size() >= 2)
                return false;
            else if(hashSet.size() == 0)
                return true;
            else if(hashSet.contains(word))
                return true;
            else
                return false;
        }
        return true;
    }

    private String getSimpleForm(String word){
        return new StringBuilder()
                .append(word.charAt(0))
                .append(
                        (word.length() - 2 > 0) ? word.length() - 2 : ""
                )
                .append(word.charAt(word.length() - 1))
                .toString();
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */
//leetcode submit region end(Prohibit modification and deletion)

}