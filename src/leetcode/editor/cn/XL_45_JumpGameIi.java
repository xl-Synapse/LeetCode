//给你一个非负整数数组 nums ，你最初位于数组的第一个位置。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 你的目标是使用最少的跳跃次数到达数组的最后一个位置。 
//
// 假设你总是可以到达数组的最后一个位置。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [2,3,1,1,4]
//输出: 2
//解释: 跳到最后一个位置的最小跳跃数是 2。
//     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
// 
//
// 示例 2: 
//
// 
//输入: nums = [2,3,0,1,4]
//输出: 2
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 10⁴ 
// 0 <= nums[i] <= 1000 
// 
// Related Topics 贪心 数组 动态规划 👍 1779 👎 0


package leetcode.editor.cn;

import java.util.*;

public class XL_45_JumpGameIi{
    public static void main(String[] args) {
        Solution solution = new XL_45_JumpGameIi().new Solution();
        solution.jump(new int[]{2,3,1,1,4});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int jump(int[] nums) {
        if(nums.length == 1)
            return 0;
        int[] dp = new int[nums.length];
//        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i = 1; i < nums.length; i++) {
            dp[i] = 1 << 31 - 1;
            for(int j = 0; j < i; j++){
                if(j + nums[j] >= i){
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                    break; // dp[i] 是单调递增的、只需要找到第一个即可、
                }
            }
        }
        return dp[nums.length - 1];
    }

    /*
    * hash保存递归法、超时、
    * */
    public int jumpHash(int[] nums) {
        if(nums.length == 1)
            return 0;

        int[] dp = new int[nums.length]; // 这题只需要跳到最后一个位置、不需要获取最后一个位置的值、所以不用考虑 + 1、
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        // 首先将能到各个位置的前置位置关系记录下来、
        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int target = i + nums[i];
            for(int j = i; j <= target; j++){
                if(hashMap.containsKey(j)){
                    hashMap.get(j).add(i);
                }
                else {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    hashMap.put(j, list);
                }
            }

        }

        for(int i = 1; i < nums.length; i++){
            List<Integer> list = hashMap.getOrDefault(i, null);
            // 因为题目保证一定能跳到最后、每个index都会有list、
            for(Iterator<Integer> iterator = list.iterator(); iterator.hasNext();){
                int lastIndex = iterator.next();
                dp[i] = Math.min(dp[i], dp[lastIndex] + 1);
            }
        }
        return dp[nums.length - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}