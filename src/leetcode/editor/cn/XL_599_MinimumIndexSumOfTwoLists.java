//假设 Andy 和 Doris 想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。 
//
// 你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设答案总是存在。 
//
// 
//
// 示例 1: 
//
// 
//输入: list1 = ["Shogun", "Tapioca Express", "Burger King", "KFC"]，list2 = [
//"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
//输出: ["Shogun"]
//解释: 他们唯一共同喜爱的餐厅是“Shogun”。
// 
//
// 示例 2: 
//
// 
//输入:list1 = ["Shogun", "Tapioca Express", "Burger King", "KFC"]，list2 = ["KFC",
// "Shogun", "Burger King"]
//输出: ["Shogun"]
//解释: 他们共同喜爱且具有最小索引和的餐厅是“Shogun”，它有最小的索引和1(0+1)。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= list1.length, list2.length <= 1000 
// 1 <= list1[i].length, list2[i].length <= 30 
// list1[i] 和 list2[i] 由空格 ' ' 和英文字母组成。 
// list1 的所有字符串都是 唯一 的。 
// list2 中的所有字符串都是 唯一 的。 
// 
// Related Topics 数组 哈希表 字符串 👍 223 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class XL_599_MinimumIndexSumOfTwoLists{
    public static void main(String[] args) {
        Solution solution = new XL_599_MinimumIndexSumOfTwoLists().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        HashSet<String> hashSet = new HashSet<>();

        int minX = Integer.MAX_VALUE;

        // 遍历1 最小索引和可能相等、
        for(int i = 0; i < list1.length; i++){
            hashMap.put(list1[i], i);
        }

        // 遍历2
        for(int i = 0; i < list2.length && i <= minX; i++){ // 索引已经超过最小索引和、直接忽略后续、
            if(hashMap.containsKey(list2[i])){
                int sum = hashMap.get(list2[i]) + i;
                if(sum > minX)
                    continue;
                if(sum < minX){
                    hashSet.clear();
                    minX = sum;
                }
                hashSet.add(list2[i]);
            }
        }

        String[] result = new String[hashSet.size()];
        int i = 0;
        for(Iterator<String> iterator = hashSet.iterator(); iterator.hasNext(); i++){
            result[i] = iterator.next();
        }
        return result;

        // 维持最小索引和 和 对应的值、
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}