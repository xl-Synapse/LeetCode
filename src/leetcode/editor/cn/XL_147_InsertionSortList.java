//给定单个链表的头 head ，使用 插入排序 对链表进行排序，并返回 排序后链表的头 。 
//
// 插入排序 算法的步骤: 
//
// 
// 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。 
// 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。 
// 重复直到所有输入数据插入完为止。 
// 
//
// 下面是插入排序算法的一个图形示例。部分排序的列表(黑色)最初只包含列表中的第一个元素。每次迭代时，从输入数据中删除一个元素(红色)，并就地插入已排序的列表
//中。 
//
// 对链表进行插入排序。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: head = [4,2,1,3]
//输出: [1,2,3,4] 
//
// 示例 2： 
//
// 
//
// 
//输入: head = [-1,5,3,4,0]
//输出: [-1,0,3,4,5] 
//
// 
//
// 提示： 
//
// 
//
// 
// 列表中的节点数在 [1, 5000]范围内 
// -5000 <= Node.val <= 5000 
// 
// Related Topics 链表 排序 👍 534 👎 0


package leetcode.editor.cn;
public class XL_147_InsertionSortList{
    public static void main(String[] args) {
        Solution solution = new XL_147_InsertionSortList().new Solution();
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
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
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode dumpHead = new ListNode(-1);
        dumpHead.next = head;

        for(ListNode now = head.next, nowLast = head; now != null; nowLast = now, now = now.next){ // 排序轮数、从第二个开始排、
            // 如果 now 比前驱大、不需要插入、
            // 如果不加这个、每次都要从头结点找位置、会超时、
            if(now.val > nowLast.val)
                continue;

            // 想要排序 temp、从 head 开始往后找到合适的插入位置、
            for(ListNode temp = dumpHead.next, tempLast = dumpHead; temp != now; tempLast = temp, temp = temp.next){ // 查到最多当前 now 位置、
                if(temp.val > now.val){
                    // now 插入到 temp 前面、
                    nowLast.next = now.next;
                    now.next = temp;

                    tempLast.next = now;

                    // now 已经找到位置、继续排下一个、
                    break;
                }
            }
        }

        return dumpHead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}