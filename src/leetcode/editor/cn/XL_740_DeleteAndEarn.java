//给你一个整数数组 nums ，你可以对它进行一些操作。 
//
// 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除 所有 等于 nums[i] - 1 和 nums[i]
// + 1 的元素。 
//
// 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,4,2]
//输出：6
//解释：
//删除 4 获得 4 个点数，因此 3 也被删除。
//之后，删除 2 获得 2 个点数。总共获得 6 个点数。
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,3,3,3,4]
//输出：9
//解释：
//删除 3 获得 3 个点数，接着要删除两个 2 和 4 。
//之后，再次删除 3 获得 3 个点数，再次删除 3 获得 3 个点数。
//总共获得 9 个点数。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// 1 <= nums[i] <= 10⁴ 
// 
// Related Topics 数组 哈希表 动态规划 👍 652 👎 0


package leetcode.editor.cn;
public class XL_740_DeleteAndEarn{
    public static void main(String[] args) {
        Solution solution = new XL_740_DeleteAndEarn().new Solution();
        System.out.println(solution.deleteAndEarn(new int[]{3,4,2}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        /**
         * 面试等通知法、
         * 强行用大数组统计每个数字对应的所有价值、
         * 最后调用打家劫舍、都是不能相邻数字偷取、
         *
         * 解答成功:
         * 		执行耗时:20 ms,击败了5.16% 的Java用户
         * 		内存消耗:41.9 MB,击败了17.57% 的Java用户
         *
         * @param nums
         * @return
         */
    public int deleteAndEarn(int[] nums) {
        int[] datas = new int[(int)Math.pow(10, 4) + 1];
        for (int num : nums) {
            datas[num] += num;
        }
        return robProcess(datas);

    }

    public int robProcess(int[] nums) {
        // 小偷只有两种选择、 隔一个偷或者隔两个偷、
        if(nums == null)
            return 0;
        switch (nums.length){
            case 1:
                return nums[0];
            case 2:
                return Math.max(nums[0], nums[1]);
            case 3:
                return Math.max(nums[0] + nums[2], nums[1]);
        }

        // 只有四个以上元素才值得算法、
        int[][] maxSumArray = new int[nums.length][3]; // 二维数组第二维度、 0 上次隔一个偷的最大值、 1 上次隔两个偷的最大值、2 两者最大值、


        for(int i = 0; i < 2; i++) { // 0 1 无论隔几个偷都一样、
            maxSumArray[i][0] = nums[i];
            maxSumArray[i][1] = nums[i];
            maxSumArray[i][2] = nums[i];
        }
        maxSumArray[2][0] = nums[0] + nums[2];
        maxSumArray[2][1] = nums[2];
        maxSumArray[2][2] = maxSumArray[2][0];

        int maxSum = Math.max(nums[0] + nums[2], nums[1]);


        for(int i = 3; i < nums.length; i++){
//            maxSumArray[i][0] = Math.max(maxSumArray[i - 1][0], maxSumArray[i - 1][1]) + nums[i];
//            maxSumArray[i][1] = Math.max(maxSumArray[i - 2][0], maxSumArray[i - 2][1]) + nums[i];
            maxSumArray[i][0] = maxSumArray[i - 2][2] + nums[i];
            maxSumArray[i][1] = maxSumArray[i - 3][2] + nums[i];
            maxSumArray[i][2] = Math.max(maxSumArray[i][0], maxSumArray[i][1]);
            maxSum = Math.max(maxSum, maxSumArray[i][2]);
        }
        return maxSum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}