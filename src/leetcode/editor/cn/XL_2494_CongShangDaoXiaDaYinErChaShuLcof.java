//从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。 
//
// 
//
// 例如: 
//给定二叉树: [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回： 
//
// [3,9,20,15,7]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 1000 
// 
// Related Topics 树 广度优先搜索 二叉树 👍 232 👎 0


package leetcode.editor.cn;

import java.util.*;


/*
    执行用时:1 ms ,在所有Java提交中击败了 97.88%的用户
    内存消耗:41.3 MB ，在所有Java提交中击败了 54.94%的用户

    单纯的利用队列进行层序遍历、
*/

public class XL_2494_CongShangDaoXiaDaYinErChaShuLcof{

//    Definition for a binary tree node.
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        Solution solution = new XL_2494_CongShangDaoXiaDaYinErChaShuLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    public int[] levelOrder(TreeNode root) {
        if(root == null)
            return new int[0];

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        List<TreeNode> temp = new ArrayList<>();
        while(!queue.isEmpty()){
            TreeNode now = queue.poll();

            if(now.left != null)
                queue.add(now.left);

            if(now.right != null)
                queue.add(now.right);

            temp.add(now);
        }

        int[] result = new int[temp.size()];
        int i = 0;
        for(TreeNode treeNode : temp){
            result[i++] = treeNode.val;
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}