//按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。 
//
// n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。 
//
// 
// 
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[["Q"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 
// 
// 
// Related Topics 数组 回溯 👍 1498 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;


/*解答成功:
        执行耗时:7 ms,击败了12.69% 的Java用户
        内存消耗:41.5 MB,击败了69.05% 的Java用户

        经典回溯法、
*/
public class XL_51_NQueens{
    public static void main(String[] args) {
        Solution solution = new XL_51_NQueens().new Solution();
        solution.solveNQueens(2);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private List<List<String>> result = new ArrayList<>();
    private StringBuilder rowStr = null;
    private int n;

    public List<List<String>> solveNQueens(int n) {
        result.clear();
        List<StringBuilder> firstRow = new ArrayList<>();
        firstRow.add(getRow(n));
        this.n = n;

        backtrack(firstRow, 0);
        return result;
    }

    private void backtrack(List<StringBuilder> board, int row){
        if(row == n){
            // 没有棋盘了、
            // 删掉虚棋盘、
            board.remove(board.size() - 1);

            List<String> temp = new ArrayList<>();
            for(StringBuilder sb : board){
                temp.add(sb.toString());
            }
            result.add(temp);

            board.add(new StringBuilder()); // 放回虚节点、防止数组越界、
            return;
        }

        board.add(getRow(n));// 先把下一列棋盘搭好、后面就不用后撤了、

        for(int i = 0; i < n; i++){
            // 逐个考虑下一行可以放的位置、
            if(!isValid(board, row, i))
                continue;

            // 放下皇后、

            board.get(row).setCharAt(i, 'Q');

            backtrack(board, row + 1);

            // 撤销皇后、
            board.get(row).setCharAt(i, '.');
        }

        board.remove(board.size() - 1);
    }

    private boolean isValid(List<StringBuilder> board, int row, int col){
        for(int i = 0; i < row; i++){
            if(board.get(i).charAt(col) == 'Q')
                return false;
        }

        // 检查右上方是否有皇后互相冲突
        for (int i = row - 1, j = col + 1;
             i >= 0 && j < n; i--, j++) {
            if (board.get(i).charAt(j) == 'Q')
                return false;
        }
        // 检查左上方是否有皇后互相冲突
        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0; i--, j--) {
            if (board.get(i).charAt(j) == 'Q')
                return false;
        }
        return true;
    }

    private StringBuilder getRow(int n){
        if(rowStr != null)
            return rowStr;

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++)
            sb.append('.');
//        rowStr = sb.toString();
//        return rowStr;
        return sb;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}