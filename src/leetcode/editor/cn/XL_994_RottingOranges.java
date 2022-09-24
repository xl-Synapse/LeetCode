//在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一： 
//
// 
// 值 0 代表空单元格； 
// 值 1 代表新鲜橘子； 
// 值 2 代表腐烂的橘子。 
// 
//
// 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。 
//
// 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：grid = [[2,1,1],[1,1,0],[0,1,1]]
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：grid = [[2,1,1],[0,1,1],[1,0,1]]
//输出：-1
//解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
// 
//
// 示例 3： 
//
// 
//输入：grid = [[0,2]]
//输出：0
//解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 10 
// grid[i][j] 仅为 0、1 或 2 
// 
// Related Topics 广度优先搜索 数组 矩阵 👍 608 👎 0


package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


/*解答成功:
        执行耗时:1 ms,击败了100.00% 的Java用户
        内存消耗:40.9 MB,击败了64.48% 的Java用户

        多源广度优先搜索、
*/
public class XL_994_RottingOranges{
    public static void main(String[] args) {
        Solution solution = new XL_994_RottingOranges().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int orangesRotting(int[][] grid) {
        // 多源广度优先搜索、BFS需要使用队列、相当于假设一个超级源点一开始指向多源、从而转化为一个普通的BFS、

        int count = 0;
        Queue<Integer[]> queue = new LinkedList<>();
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if(grid[row][col] == 1){ // 新鲜苹果、记录、
                    count++;
                }
                else if(grid[row][col] == 2){
                    queue.add(new Integer[]{row, col});
                }
            }
        }

        int round = 0;
        while(!queue.isEmpty() && count > 0){
            round++;
            int num = queue.size(); // 本层节点数、
            for (int i = 0; i < num; i++) {
                Integer[] location = queue.remove();
                int row = location[0];
                int col = location[1];

                if(row - 1 >= 0 && grid[row - 1][col] == 1){
                    grid[row - 1][col] = 2;
                    count--;
                    queue.add(new Integer[]{row - 1, col});
                }

                if(row + 1 < grid.length && grid[row + 1][col] == 1){
                    grid[row + 1][col] = 2;
                    count--;
                    queue.add(new Integer[]{row + 1, col});
                }

                if(col - 1 >= 0 && grid[row][col - 1] == 1){
                    grid[row][col - 1] = 2;
                    count--;
                    queue.add(new Integer[]{row, col - 1});
                }

                if(col + 1 < grid[0].length && grid[row][col + 1] == 1){
                    grid[row][col + 1] = 2;
                    count--;
                    queue.add(new Integer[]{row, col + 1});
                }
            }
        }

        return (count > 0) ? -1 : round;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}