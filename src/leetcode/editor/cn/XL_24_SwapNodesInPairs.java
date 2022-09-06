//给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
// 
//
// 示例 2： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 100] 内 
// 0 <= Node.val <= 100 
// 
// Related Topics 递归 链表 👍 1552 👎 0


package leetcode.editor.cn;

/*
解答成功:
        执行耗时:0 ms,击败了100.00% 的Java用户
        内存消耗:39.4 MB,击败了25.22% 的Java用户

        双指针差2遍历、
*/
public class XL_24_SwapNodesInPairs{

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        ListNode add(int val){this.next = new ListNode(val); return this.next;}
    }

    public static void main(String[] args) {
        Solution solution = new XL_24_SwapNodesInPairs().new Solution();
        ListNode node = new XL_24_SwapNodesInPairs().new ListNode(1);
        node.add(2).add(3).add(4);
        solution.swapPairs(node);
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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode p = new ListNode();
        p.next = head;

        ListNode q = head.next;

        ListNode result = head.next;

        while(q != null){ // 只要还有元素、都还是要换的、
            // 换
            ListNode temp = p.next;
            p.next = q;
            temp.next = q.next;
            q.next = temp;

            // 后移两位、
            if(q.next.next == null){
                // 尾部、
                break;
            }
            q = q.next.next.next; // q和q-1换过、所以要后移三位、
            p = p.next.next;

        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}