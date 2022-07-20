//给定一棵二叉树 root，返回所有重复的子树。 
//
// 对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。 
//
// 如果两棵树具有相同的结构和相同的结点值，则它们是重复的。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,2,3,4,null,2,4,null,null,4]
//输出：[[2,4],[4]] 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [2,1,1]
//输出：[[1]] 
//
// 示例 3： 
//
// 
//
// 
//输入：root = [2,2,2,3,null,3,null]
//输出：[[2,3],[3]] 
//
// 
//
// 提示： 
//
// 
// 树中的结点数在[1,10^4]范围内。 
// -200 <= Node.val <= 200 
// 
// Related Topics 树 深度优先搜索 哈希表 二叉树 👍 441 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class XL_652_FindDuplicateSubtrees{
    public static void main(String[] args) {
        Solution solution = new XL_652_FindDuplicateSubtrees().new Solution();
    }

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
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

    /***
     * 设计一个合适的哈希键、然后后序遍历二叉树、遇到出现过的键、就加入返回列表、再利用另一个hash去重、
     */

class Solution {
    private List<TreeNode> result = new ArrayList<>();
    private HashSet<String> hashSet = new HashSet<>();
    private HashSet<String> resultSet = new HashSet<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        result.clear();
        hashSet.clear();
        resultSet.clear();
        getTag(root);
        return result;
    }

    public String getTag(TreeNode root) {
        if(root == null)
            return ",";
        String tag = root.val + "," + getTag(root.left) + "," + getTag(root.right);
        if(hashSet.contains(tag)){
            if(!resultSet.contains(tag)){
                resultSet.add(tag);
                result.add(root);
            }
        }
        else {
            hashSet.add(tag);
        }
        return tag;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}