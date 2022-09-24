//给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的
// 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。 
//
// candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。 
//
// 对于给定的输入，保证和为 target 的不同组合数少于 150 个。 
//
// 
//
// 示例 1： 
//
// 
//输入：candidates = [2,3,6,7], target = 7
//输出：[[2,2,3],[7]]
//解释：
//2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
//7 也是一个候选， 7 = 7 。
//仅有这两种组合。 
//
// 示例 2： 
//
// 
//输入: candidates = [2,3,5], target = 8
//输出: [[2,2,2,2],[2,3,3],[3,5]] 
//
// 示例 3： 
//
// 
//输入: candidates = [2], target = 1
//输出: []
// 
//
// 
//
// 提示： 
//
// 
// 1 <= candidates.length <= 30 
// 1 <= candidates[i] <= 200 
// candidate 中的每个元素都 互不相同 
// 1 <= target <= 500 
// 
// Related Topics 数组 回溯 👍 2156 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/*解答成功:
        执行耗时:3 ms,击败了55.32% 的Java用户
        内存消耗:42 MB,击败了23.74% 的Java用户

        需要重复取相同元素、即进入下一轮递归时不使用 +1 即可、
*/
public class XL_39_CombinationSum{
    public static void main(String[] args) {
        Solution solution = new XL_39_CombinationSum().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private List<List<Integer>> results = new ArrayList<>();
    private List<Integer> result = new ArrayList<>();
    private int sum;
    private int target;
    private int[] candidates;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        results.clear();
        result.clear();
        sum = 0;
        this.target = target;
        this.candidates = candidates;
        back(0);

        return results;
    }

    private void back(int start){
        if(sum == target){
            results.add(new ArrayList<>(result));
        }
        else if(sum > target){
            return;
        }

        for(int i = start; i < candidates.length; i++){

            result.add(candidates[i]);
            sum += candidates[i];

            back(i);

            result.remove(result.size() - 1);
            sum -= candidates[i];
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}