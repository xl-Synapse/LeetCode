//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// Related Topics 数组 回溯 👍 1182 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*解答成功:
        执行耗时:1 ms,击败了99.80% 的Java用户
        内存消耗:42.2 MB,击败了53.27% 的Java用户

        多个选择只遍历第一条、这可以保证去重的同时可以接着考虑下一个重复的值、
*/
public class XL_47_PermutationsIi{
    public static void main(String[] args) {
        Solution solution = new XL_47_PermutationsIi().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private List<List<Integer>> results = new ArrayList<>();
    private List<Integer> result = new ArrayList<>();
    private int[] nums;
    private boolean[] used;
    public List<List<Integer>> permuteUnique(int[] nums) {
        result.clear();
        results.clear();
        Arrays.sort(nums);
        this.nums = nums;
        this.used = new boolean[nums.length];

        back(0);
        return results;
    }

    private void back(int cnt){
        if(cnt == nums.length){
            results.add(new ArrayList<>(result));
        }

        for(int i = 0; i < nums.length; i++){
            if(used[i]){
                // 这个值已经被用过、
                continue;
            }

            if(i > 0 && nums[i] == nums[i - 1] && !used[i - 1]){
                continue;
            }

            // 做选择
            result.add(nums[i]);
            used[i] = true;
            // 向后
            back(cnt + 1);
            // 撤销
            result.remove(result.size() - 1);
            used[i] = false;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}