//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
//
// 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
// Related Topics 链表 双指针 👍 2202 👎 0


package leetcode.editor.cn;

import java.util.List;

/*解答成功:
        执行耗时:0 ms,击败了100.00% 的Java用户
        内存消耗:39.9 MB,击败了23.68% 的Java用户

        k差速双指针、
*/
public class XL_19_RemoveNthNodeFromEndOfList{

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        Solution solution = new XL_19_RemoveNthNodeFromEndOfList().new Solution();
        solution.removeNthFromEnd(new XL_19_RemoveNthNodeFromEndOfList().new ListNode(1), 1);
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = new ListNode(), q = head;
        p.next = head; // 造一个虚节点、方便判定、

        for(int i = 0; i < n; i++){
            q = q.next;
        }

        while(q != null){
            p = p.next;
            q = q.next;
        }

        // 此时要删的节点就是p next、 需要判断是否删了头结点、
        if(head == p.next)
            head = p.next.next;

        ListNode temp = p.next;
        if(temp != null){
            p.next = temp.next;
            temp.next = null;
        }

        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}