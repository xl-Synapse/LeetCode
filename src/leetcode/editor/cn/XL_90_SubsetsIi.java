//给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,2]
//输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// 
// 
// 
// Related Topics 位运算 数组 回溯 👍 924 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*解答成功:
        执行耗时:1 ms,击败了99.72% 的Java用户
        内存消耗:41.4 MB,击败了91.45% 的Java用户

        回溯时、下一步选择如果有多个相同值可以选、只选第一条进行向后遍历、其余跳过、
        这样第一条的遍历仍可以考虑其他相同的值、又保证了去重、
*/
public class XL_90_SubsetsIi{
    public static void main(String[] args) {
        Solution solution = new XL_90_SubsetsIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private List<List<Integer>> results = new ArrayList<>();
    private List<Integer> result = new ArrayList<>();
    private int[] nums;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        result.clear();
        results.clear();
        Arrays.sort(nums);
        this.nums = nums;

        backtrack(0);
        return results;
    }

    private void backtrack(int start){ // start 代表下一个待考虑的起点、
        results.add(new ArrayList<>(result)); // 每选择一个节点、都会记录一个结果、

        for(int i = start; i < nums.length; i++){
            // 判断是否与上一个重复、
            if(i > start && nums[i] == nums[i - 1]){
                // 相同元素不进入相同的递归、
                continue;
            }

            result.add(nums[i]); // 做选择
            backtrack(i + 1); // 向后、
            result.remove(result.size() - 1); // 撤销选择、
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}