//设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。 
//
// 请实现 KthLargest 类： 
//
// 
// KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。 
// int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//["KthLargest", "add", "add", "add", "add", "add"]
//[[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
//输出：
//[null, 4, 5, 5, 8, 8]
//
//解释：
//KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
//kthLargest.add(3);   // return 4
//kthLargest.add(5);   // return 5
//kthLargest.add(10);  // return 5
//kthLargest.add(9);   // return 8
//kthLargest.add(4);   // return 8
// 
//
// 
//提示：
//
// 
// 1 <= k <= 10⁴ 
// 0 <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// -10⁴ <= val <= 10⁴ 
// 最多调用 add 方法 10⁴ 次 
// 题目数据保证，在查找第 k 大元素时，数组中至少有 k 个元素 
// 
// Related Topics 树 设计 二叉搜索树 二叉树 数据流 堆（优先队列） 👍 375 👎 0


package leetcode.editor.cn;

import java.util.PriorityQueue;


/*解答成功:
        执行耗时:12 ms,击败了93.25% 的Java用户
        内存消耗:44.6 MB,击败了74.69% 的Java用户

        基础堆应用、
*/
public class XL_703_KthLargestElementInAStream{
    public static void main(String[] args) {
        KthLargest solution = new XL_703_KthLargestElementInAStream().new KthLargest(2, new int[]{0});
        solution.add(-1);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class KthLargest {
    private int k;
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // 求第k大、维持最小堆、top即第k大、
    public KthLargest(int k, int[] nums) {
        minHeap.clear();
        this.k = k;

        for(int i = 0; i < nums.length; i++) {
            if(minHeap.size() < k) {
                minHeap.add(nums[i]);
                continue;
            }

            if(nums[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(nums[i]);
            }
        }
    }
    
    public int add(int val) {
        if(minHeap.size() < k){
            minHeap.add(val);
            return minHeap.peek();
        }

        if(val > minHeap.peek()){
            minHeap.poll();
            minHeap.add(val);
        }


        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
//leetcode submit region end(Prohibit modification and deletion)

}