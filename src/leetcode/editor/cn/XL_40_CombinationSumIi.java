//给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用 一次 。 
//
// 注意：解集不能包含重复的组合。 
//
// 
//
// 示例 1: 
//
// 
//输入: candidates = [10,1,2,7,6,1,5], target = 8,
//输出:
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//] 
//
// 示例 2: 
//
// 
//输入: candidates = [2,5,2,1,2], target = 5,
//输出:
//[
//[1,2,2],
//[5]
//] 
//
// 
//
// 提示: 
//
// 
// 1 <= candidates.length <= 100 
// 1 <= candidates[i] <= 50 
// 1 <= target <= 30 
// 
// Related Topics 数组 回溯 👍 1094 👎 0


package leetcode.editor.cn;

import java.util.*;

/*
解答成功:
        执行耗时:3 ms,击败了58.70% 的Java用户
        内存消耗:41.7 MB,击败了67.14% 的Java用户

        必须先排序再回溯去重、直接回溯去重超时、
*/

public class XL_40_CombinationSumIi{
    public static void main(String[] args) {
        Solution solution = new XL_40_CombinationSumIi().new Solution();
        solution.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private List<List<Integer>> results = new ArrayList<>();
    private int[] candiates;
    private List<Integer> now = new ArrayList<>();
    private HashMap<Integer, Integer> hashMap = new HashMap<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.candiates = candidates;
        now.clear();
        hashMap.clear();
        results.clear();

        // 记录每个数字出现的次数、
        for(int num : candidates){
            if(hashMap.containsKey(num)){
                hashMap.put(num, hashMap.get(num) + 1);
            }
            else {
                hashMap.put(num, 1);
            }
        }

        dfs(0, target);
        return results;
    }

    private void dfs(int index, int target) {
        if (target == 0) {
            results.add(new ArrayList<>(now));
        }
        if (index >= candiates.length || target < candiates[index]) {
            return;
        }

        int freq = hashMap.getOrDefault(candiates[index], 0);

        // 不选我、直接回溯下一个、

        dfs(index + freq, target);


        int most = Math.min(freq, target / candiates[index]);
        for (int i = 1; i <= most; i++) { // 至少选一次、否则没必要往下dfs、
            now.add(candiates[index]);
            dfs(index + freq, target - i * candiates[index]);
        }

        for (int i = 1; i <= most; ++i) {
            now.remove(now.size() - 1);
        }
    }

    // 先回溯、再排序哈希去重、超时、
    public List<List<Integer>> combinationSum2Old(int[] candidates, int target) {
        results = new ArrayList<>();

        if(candidates.length == 1 && target == candidates[0]){
            List<Integer> list = new ArrayList<>();
            list.add(target);
            results.add(list);
            return results;
        }


        combinationSum2(candidates, target, -1, new ArrayList<>());

        HashSet<Integer> hashSet = new HashSet<>();
        for(int i = 0; i < results.size(); i++){
            List<Integer> list = results.get(i);
            list.sort((o1, o2) -> o1 - o2);

            if(hashSet.contains(list.hashCode())){
                results.remove(i--);
            }
            else {
                hashSet.add(list.hashCode());
            }
        }
        return results;
    }

    public void combinationSum2(int[] candidates, int target, int lastIndex, List<Integer> result) {
        for(int i = lastIndex + 1; i < candidates.length; i++){
            if(candidates[i] > target){
                continue;
            }
            else if(candidates[i] == target) {
                List<Integer> temp = new ArrayList<>(result);
                temp.add(candidates[i]);
                results.add(temp);
            }
            else {
                result.add(candidates[i]);
                combinationSum2(candidates, target - candidates[i], i, result);
            }
        }
        if(result.size() != 0)
            result.remove(result.size() - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}