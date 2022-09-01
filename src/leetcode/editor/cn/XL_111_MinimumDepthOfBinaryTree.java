//给定一个二叉树，找出其最小深度。 
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
//
// 说明：叶子节点是指没有子节点的节点。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：root = [2,null,3,null,4,null,5,null,6]
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数的范围在 [0, 10⁵] 内 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 828 👎 0


package leetcode.editor.cn;
public class XL_111_MinimumDepthOfBinaryTree{
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
        Solution solution = new XL_111_MinimumDepthOfBinaryTree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    private int min = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        minDepth(root, 0);
        return min;
    }

    public void minDepth(TreeNode root, int cnt){
        if (root != null){
            if(root.left == null && root.right == null){
                // 叶子、
                min = Math.min(min, cnt + 1);
                return;
            }
            minDepth(root.left, cnt + 1);
            minDepth(root.right, cnt + 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}