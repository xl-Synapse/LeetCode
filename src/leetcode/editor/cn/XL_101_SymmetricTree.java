//给你一个二叉树的根节点 root ， 检查它是否轴对称。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,2,3,4,4,3]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2,2,null,3,null,3]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 1000] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你可以运用递归和迭代两种方法解决这个问题吗？ 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 2085 👎 0

/*解答成功:
        执行耗时:0 ms,击败了100.00% 的Java用户
        内存消耗:39.6 MB,击败了65.18% 的Java用户
        */
package leetcode.editor.cn;
public class XL_101_SymmetricTree{
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
        Solution solution = new XL_101_SymmetricTree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)


class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;

        return isSameTree(root.left, root.right);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null){
            return q == null;
        }

        if(q == null)
            return false;

        if(p.val != q.val)
            return false;

        if(!isSameTree(p.left, q.right))
            return false;

        if(!isSameTree(p.right, q.left))
            return false;

        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}