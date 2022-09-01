//给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并
//返回其根节点。 
//
// 
//
// 示例 1: 
//
// 
//输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//输出: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入: preorder = [-1], inorder = [-1]
//输出: [-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder 和 inorder 均 无重复 元素 
// inorder 均出现在 preorder 
// preorder 保证 为二叉树的前序遍历序列 
// inorder 保证 为二叉树的中序遍历序列 
// 
// Related Topics 树 数组 哈希表 分治 二叉树 👍 1711 👎 0

/*解答成功:
        执行耗时:1 ms,击败了99.40% 的Java用户
        内存消耗:41.2 MB,击败了47.92% 的Java用户
        */
package leetcode.editor.cn;

import java.util.HashMap;

public class XL_105_ConstructBinaryTreeFromPreorderAndInorderTraversal{
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
        Solution solution = new XL_105_ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
        solution.buildTree(new int[]{1,2}, new int[]{2,1});
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    private HashMap<Integer, Integer> hashMap = new HashMap<>();
    private int[] preorder;
    private int[] inorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        hashMap.clear();

        for(int i = 0; i < inorder.length; i++){
            hashMap.put(inorder[i], i);
        }
        this.preorder = preorder;
        this.inorder = inorder;
        return buildSubTree(0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode buildSubTree(int prel, int prer, int inl, int inr){
        if(prel > prer || inl > inr)
            return null;

        TreeNode root = new TreeNode(preorder[prel]);
        if(prel == prer)
            return root;

        int rootIndex = hashMap.get(root.val);

        // 递归地构建树、前序第一个必定为根节点、中序根节点划分序列为左右子树、
        root.left = buildSubTree(prel + 1, prel + rootIndex - inl, inl, rootIndex - 1);
        root.right = buildSubTree(prel + rootIndex - inl + 1, prer, rootIndex + 1, inr);

        return root;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}