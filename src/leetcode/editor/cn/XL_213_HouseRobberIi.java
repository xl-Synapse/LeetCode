//你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的
//房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,2]
//输出：3
//解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,1]
//输出：4
//解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 3： 
//
// 
//输入：nums = [1,2,3]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 1000 
// 
// Related Topics 数组 动态规划 👍 1105 👎 0


package leetcode.editor.cn;
public class XL_213_HouseRobberIi{
    public static void main(String[] args) {
        Solution solution = new XL_213_HouseRobberIi().new Solution();
        System.out.println(solution.rob(new int[]{2,1,2,6,1,8,10,10}));
    }

    /**
     * 去头去尾两个新数组、
     * 各求一遍打家劫舍、
     * 再求最大值、
     *
     * 解答成功:
     * 			执行耗时:0 ms,击败了100.00% 的Java用户
     * 			内存消耗:39.4 MB,击败了5.03% 的Java用户
     */

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int rob(int[] nums) {
            if(nums.length == 1)
                return nums[0];

            int[] x1 = new int[nums.length - 1];
            for(int i = 0; i < nums.length - 1; i++){
                x1[i] = nums[i];
            }
            int max1 = robProcess(x1);

            for(int i = 1; i < nums.length; i++){
                x1[i - 1] = nums[i];
            }
            int max2 = robProcess(x1);
            return Math.max(max1, max2);
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
/*        public int rob(int[] nums) {
            // 小偷只有两种选择、 隔一个偷或者隔两个偷、 但是第一个和最后一个是相邻的、得额外记录当前最大是否从第一个开始偷、
            if(nums == null)
                return 0;
            switch (nums.length){
                case 1:
                    return nums[0];
                case 2:
                    return Math.max(nums[0], nums[1]);
                case 3:
                    // 不能首尾偷、
                    return Math.max(Math.max(nums[0], nums[1]), nums[2]);
            }

            // 只有四个以上元素才值得算法、
            int[][] maxSumArray = new int[nums.length][4]; // 二维数组第二维度、 0 上次隔一个偷的最大值、 1 上次隔两个偷的最大值、2 3 是否从第一个偷
            // 这里要注意值相等的情况、

            for(int i = 0; i < 2; i++) { // 0 1 无论隔几个偷都一样、
                maxSumArray[i][0] = nums[i];
                maxSumArray[i][1] = nums[i];
                maxSumArray[i][2] = Math.abs(i - 1);
                maxSumArray[i][3] = Math.abs(i - 1);
            }
            // 这里由于有四个元素以上、所以 0 2 可以一起偷、
            maxSumArray[2][0] = nums[0] + nums[2];
            maxSumArray[2][1] = nums[2];
            maxSumArray[2][2] = 1;
            maxSumArray[2][3] = 0;

//            int maxSum = Math.max(maxSumArray[2][0], maxSumArray[2][1]);

            for(int i = 3; i < nums.length - 1; i++){
//            maxSumArray[i][0] = Math.max(maxSumArray[i - 1][0], maxSumArray[i - 1][1]) + nums[i];
//            maxSumArray[i][1] = Math.max(maxSumArray[i - 2][0], maxSumArray[i - 2][1]) + nums[i];

                // 隔一个偷、和隔两个偷
                int lastMaxIndex = 0;
                for(int j = 2; j <= 3; j++) {
                    lastMaxIndex = (maxSumArray[i - j][0] > maxSumArray[i - j][1]) ? 0 : 1;
                    maxSumArray[i][j - 2] = maxSumArray[i - j][lastMaxIndex] + nums[i]; // 加上最大值、

                    maxSumArray[i][j] = maxSumArray[i - j][lastMaxIndex + 2]; // 更新是否第一偷、
                    // 特殊情况、相等、
                    if(maxSumArray[i - j][0] == maxSumArray[i - j][1]){
                        maxSumArray[i][j] = maxSumArray[i - j][2] &  maxSumArray[i - j][3];
                    }
                }

                // 维护以i结尾的最高sum、
//                if(maxSumArray[i][0] > maxSumArray[i][1]){
//                    maxSumArray[i][2] = maxSumArray[i][0];
//                    maxSumArray[i][3] = maxSumArray[i - 2][3];
//                }
//                else if((maxSumArray[i][0] == maxSumArray[i][1])){
//
//                    // 相等的情况下、可能出现既可以从第一偷、也可以不从第一偷、
//                    // 那就不从第一偷、这样保证最后能偷尾、
//                    maxSumArray[i][2] = maxSumArray[i][0];
//                    maxSumArray[i][3] = maxSumArray[i - 2][3] &  maxSumArray[i - 3][3];
//                }
//                else {
//                    maxSumArray[i][2] = maxSumArray[i][1];
//                    maxSumArray[i][3] = maxSumArray[i - 3][3];
//                }

//                // 不用更新最大、全是正数、最终结果一定在最后一位的判定中产生、
//                maxSum = Math.max(maxSum, maxSumArray[i][2]);
            }

            // 节省判断、将最后一个元素的判定提出、
            int i = nums.length - 1;
            int lastMaxIndex = 0;
            for(int j = 2; j <= 3; j++) {
                lastMaxIndex = (maxSumArray[i - j][0] > maxSumArray[i - j][1]) ? 0 : 1;
                maxSumArray[i][j - 2] = maxSumArray[i - j][lastMaxIndex] + nums[i]; // 加上最大值、

//                maxSumArray[i][j] = maxSumArray[i - j][lastMaxIndex + 2]; // 更新是否第一偷、最后一个不需要更新、
                // 特殊情况、相等、
                if(maxSumArray[i - j][0] == maxSumArray[i - j][1]) {
                    maxSumArray[i][j - 2] = maxSumArray[i - j][0] + nums[i] + (((maxSumArray[i - j][2] & maxSumArray[i - j][3]) == 0) ? 0 : -nums[0]);
                }
                else if((maxSumArray[i - j][0] > maxSumArray[i - j][1])){
                    maxSumArray[i][j - 2] = maxSumArray[i - j][0] + nums[i] + ((maxSumArray[i - j][2] == 0) ? 0 : -nums[0]);
                }
                else {
                    maxSumArray[i][j - 2] = maxSumArray[i - j][1] + nums[i] + ((maxSumArray[i - j][3] == 0) ? 0 : -nums[0]);
                }

            }
//            // 如果该最大是从第一位开始偷、那么就必须把第一家换成最后一家、
//            maxSumArray[i][0] = maxSumArray[i - 2][2] + nums[i] + ((maxSumArray[i - 2][3] == 0) ? 0 : -nums[0]); // 没从第一家偷 0、偷了就得还回去、
//            maxSumArray[i][1] = maxSumArray[i - 3][2] + nums[i] + ((maxSumArray[i - 3][3] == 0) ? 0 : -nums[0]);
//            maxSumArray[i][2] = Math.max(maxSumArray[i][0], maxSumArray[i][1]);
//            maxSum = Math.max(maxSum, maxSumArray[i][2]);
            return 0;
        }*/
    }
//leetcode submit region end(Prohibit modification and deletion)

}