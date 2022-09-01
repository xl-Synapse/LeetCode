//给定一个二叉树，找出其最大深度。 
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 
//给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1352 👎 0

/*解答成功:
        执行耗时:0 ms,击败了100.00% 的Java用户
        内存消耗:41.7 MB,击败了5.11% 的Java用户
        */
package leetcode.editor.cn;
public class XL_104_MaximumDepthOfBinaryTree{
    // * Definition for a binary tree node.
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
        Solution solution = new XL_104_MaximumDepthOfBinaryTree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)


class Solution {
    public int maxDepth(TreeNode root) {
        return maxDepth(root, 0);
    }

    public int maxDepth(TreeNode root, int cnt){
        if (root == null)
            return cnt;
        return Math.max(maxDepth(root.left, cnt + 1), maxDepth(root.right, cnt + 1));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}