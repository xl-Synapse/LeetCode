//给你一个二叉树的根结点，返回其结点按 垂直方向（从上到下，逐列）遍历的结果。 
//
// 如果两个结点在同一行和列，那么顺序则为 从左到右。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[9],[3,15],[20],[7]]
// 
//
// 示例 2： 
//
// 
//输入：root = [3,9,8,4,0,1,7]
//输出：[[4],[9],[3,0,1],[8],[7]]
// 
//
// 示例 3： 
//
// 
//输入：root = [3,9,8,4,0,1,7,null,null,null,2,5]
//输出：[[4],[9,5],[3,0,1],[8,2],[7]]
// 
//
// 
//
// 提示： 
//
// 
// 树中结点的数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 哈希表 二叉树 👍 186 👎 0


package leetcode.editor.cn;

import java.util.*;


/*解答成功:
        执行耗时:2 ms,击败了95.55% 的Java用户
        内存消耗:41.9 MB,击败了20.94% 的Java用户

        层序遍历、维持col值、
*/
public class XL_314_BinaryTreeVerticalOrderTraversal{
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

    public TreeNode processTreeNode(Integer[] array) {
        if (array.length == 0) {
            return null;
        }
        TreeNode treeNode = new TreeNode(array[0]);
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(treeNode);
        // 先左后右
        boolean isleft = true;
        for (int i = 1; i < array.length; i++) {
           TreeNode peek = deque.getFirst();
            if (isleft) {
                if (array[i] != null) {
                    peek.left = new TreeNode(array[i]);
                    //将左节点添加至队尾
                    deque.offer(peek.left);
                }
                isleft = false;

            } else {
                if (array[i] != null) {
                    peek.right = new TreeNode(array[i]);
                    deque.offer(peek.right);
                }
                // 删除队头第一个元素
                deque.pollFirst();
                isleft = true;
            }
        }
        return treeNode;
    }


    public static void main(String[] args) {
        Solution solution = new XL_314_BinaryTreeVerticalOrderTraversal().new Solution();
        TreeNode root = new XL_314_BinaryTreeVerticalOrderTraversal().processTreeNode(new Integer[]{3,9,8,4,0,1,7});
        solution.verticalOrder(root);
    }
    //leetcode submit region begin(Prohibit modification and deletion)


class Solution {
    class Entity{
        public int col;
        public TreeNode treeNode;
        public Entity(int col, TreeNode treeNode){
            this.col = col;
            this.treeNode = treeNode;
        }
    }

    private Map<Integer, List<Integer>> map = new HashMap<>();
    private int min;
    private int max;
    private Queue<Entity> queue = new LinkedList<>();
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if(root == null)
            return new ArrayList<>();

        map.clear();
        queue.clear();
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;

        queue.add(new Entity(0, root));
        fOrder();

        List<List<Integer>> list = new ArrayList<>();
        for(int i = min; i <= max; i++){
            list.add(map.get(i));
        }
        return list;
    }

    // 层序遍历、
    private void fOrder(){
        while(!queue.isEmpty()) {
            Entity entity = queue.poll();
            // 将子节点入栈、
            if(entity.treeNode.left != null)
                queue.add(new Entity(entity.col - 1, entity.treeNode.left));
            if(entity.treeNode.right != null)
                queue.add(new Entity(entity.col + 1, entity.treeNode.right));

            max = Math.max(entity.col, max);
            min = Math.min(entity.col, min);

            if (map.containsKey(entity.col)) {
                map.get(entity.col).add(entity.treeNode.val);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(entity.treeNode.val);
                map.put(entity.col, list);
            }
        }


    }
}
//leetcode submit region end(Prohibit modification and deletion)

}