//给你一个链表数组，每个链表都已经按升序排列。 
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
// Related Topics 链表 分治 堆（优先队列） 归并排序 👍 2153 👎 0


package leetcode.editor.cn;

import java.util.Comparator;
import java.util.PriorityQueue;

/*解答成功:
        执行耗时:4 ms,击败了70.52% 的Java用户
        内存消耗:43.7 MB,击败了18.84% 的Java用户

        与合并两个有序链表相同的做法、区别是怎么快速获得当前最小的待插入节点、
        利用堆、将k个链表的头结点入堆、
        每次出堆就是最小值、加入结果后、把该出堆值的next入堆、
*/

public class XL_23_MergeKSortedLists{

//Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        Solution solution = new XL_23_MergeKSortedLists().new Solution();
        solution.mergeKLists(new ListNode[0]);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0)
            return null;

        ListNode dummy = new ListNode(), p = dummy;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (o1, o2) -> o1.val - o2.val);
        for(ListNode temp : lists){
            if(temp != null) // 可能出现空、
                queue.add(temp);
        }

        while(!queue.isEmpty()){
            ListNode next = queue.poll(); // 获取到下一个最小的节点、
            p.next = next;

            if(next.next != null){
                queue.add(next.next);
            }

            next.next = null;
            p = next;
        }

        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}