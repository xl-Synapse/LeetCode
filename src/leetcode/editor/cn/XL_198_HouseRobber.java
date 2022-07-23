//你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上
//被小偷闯入，系统会自动报警。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 
//输入：[1,2,3,1]
//输出：4
//解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 2： 
//
// 
//输入：[2,7,9,3,1]
//输出：12
//解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
//     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 400 
// 
// Related Topics 数组 动态规划 👍 2217 👎 0


package leetcode.editor.cn;
public class XL_198_HouseRobber{
    public static void main(String[] args) {
        Solution solution = new XL_198_HouseRobber().new Solution();
        System.out.println(solution.rob(new int[]{1, 2, 3, 1}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int rob(int[] nums) {
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

        int maxSum = Math.max(nums[0] + nums[2], nums[1]); // 假装前三个没偷到东西、第四个元素一定会将前面的算上、因此这里可以忽略、


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