//给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。 
//
// 你应当 保留 两个分区中每个节点的初始相对位置。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,4,3,2,5,2], x = 3
//输出：[1,2,2,4,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [2,1], x = 2
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 200] 内 
// -100 <= Node.val <= 100 
// -200 <= x <= 200 
// 
// Related Topics 链表 双指针 👍 618 👎 0


package leetcode.editor.cn;

/*        解答成功:
        执行耗时:0 ms,击败了100.00% 的Java用户
        内存消耗:41.5 MB,击败了5.01% 的Java用户

        类似合并两个有序链表、但是反过来做、一个拆成两个链表、遍历可以保证有序、按照条件分别放入、最后两个链表接起来、
*/
public class XL_86_PartitionList{

//Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        Solution solution = new XL_86_PartitionList().new Solution();
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
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode();
        ListNode dummy2 = new ListNode();

        ListNode p1 = dummy1, p2 = dummy2;

        while(head != null){
            if(head.val < x){
                p1.next = head;
                p1 = head;
            }
            else {
                p2.next = head;
                p2 = head;
            }

            // 要断开该节点、否则出现环、
            ListNode temp = head.next;
            head.next = null;
            head = temp;
        }

        p1.next = dummy2.next;
        return dummy1.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}