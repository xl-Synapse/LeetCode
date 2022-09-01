//给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。 
//
// 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。 
//
// 
//
// 示例 1： 
//
// 
//输入：p = [1,2,3], q = [1,2,3]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：p = [1,2], q = [1,null,2]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：p = [1,2,1], q = [1,1,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 两棵树上的节点数目都在范围 [0, 100] 内 
// -10⁴ <= Node.val <= 10⁴ 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 890 👎 0

/*解答成功:
        执行耗时:0 ms,击败了100.00% 的Java用户
        内存消耗:39.2 MB,击败了19.30% 的Java用户
        */
package leetcode.editor.cn;


public class XL_100_SameTree{
    //  Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static void main(String[] args) {
        Solution solution = new XL_100_SameTree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null){
            return q == null;
        }

        if(q == null)
            return false;

        if(p.val != q.val)
            return false;

        if(!isSameTree(p.left, q.left))
            return false;

        if(!isSameTree(p.right, q.right))
            return false;

        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}