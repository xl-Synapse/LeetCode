//给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。 
//
// 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。 
//
// 请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。 
//
// 注意：不允许旋转信封。 
// 
//
// 示例 1： 
//
// 
//输入：envelopes = [[5,4],[6,4],[6,7],[2,3]]
//输出：3
//解释：最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。 
//
// 示例 2： 
//
// 
//输入：envelopes = [[1,1],[1,1],[1,1]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= envelopes.length <= 10⁵ 
// envelopes[i].length == 2 
// 1 <= wi, hi <= 10⁵ 
// 
// Related Topics 数组 二分查找 动态规划 排序 👍 768 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

public class XL_354_RussianDollEnvelopes{
    public static void main(String[] args) {
        Solution solution = new XL_354_RussianDollEnvelopes().new Solution();
        System.out.println(solution.maxEnvelopes(new int[][]{{5,4},{6,4},{6,7},{2,3}}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int[] maxEs = new int[envelopes.length]; // 以i结尾的信封的最大数、
        int maxL = 0;

        // 防止无序导致无法遍历时访问前一状态、得先排序、
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] e1, int[] e2) {
                if (e1[0] != e2[0]) {
                    return e1[0] - e2[0];
                } else {
                    return e2[1] - e1[1];
                }
            }
        });

        Arrays.fill(maxEs, 1);

        for(int i = 0; i < envelopes.length; i++){
            for(int j = 0; j < i; j++){
                // 由于信封无序、需要全部遍历、但是这样会无法访问未计算的j、因此必须对数组先排序、

                if(envelopes[i][1] > envelopes[j][1]){ // 0 维度通过排序策略已经确认不可能引入错误值、因此可以忽略处理、
                    // 如果j可以装进i、
                    maxEs[i] = Math.max(maxEs[i], maxEs[j] + 1);
                }
            }

            // 以i结尾计算完毕、维持最大信封数、
            maxL = Math.max(maxL, maxEs[i]);
        }
        return maxL;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}