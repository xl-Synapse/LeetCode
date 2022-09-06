//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
// 
//
// 示例 2： 
//
// 输入：arr = [0,1,2,1], k = 1
//输出：[0] 
//
// 
//
// 限制： 
//
// 
// 0 <= k <= arr.length <= 10000 
// 0 <= arr[i] <= 10000 
// 
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 481 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.PriorityQueue;


/*
        执行用时:15 ms ,在所有Java提交中击败了28.70%的用户
        内存消耗: 42.8 MB，在所有Java提交中击败了24.77%的用户

        解法一、可以优化为解法二（维持k大小的最大堆）、但是这个写起来简单、
*/

public class XL_2496_ZuiXiaoDeKgeShuLcof{
    public static void main(String[] args) {
        Solution solution = new XL_2496_ZuiXiaoDeKgeShuLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i = 0; i < arr.length; i++)
            minHeap.add(arr[i]);

        int[] result = new int[k];
        for(int i = 0; i < k; i++)
            result[i] = minHeap.poll();

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}