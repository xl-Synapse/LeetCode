//请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。 
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图） 
// 
//
// 
//
// 注意： 
//
// 
// 一个有效的数独（部分已被填充）不一定是可解的。 
// 只需要根据以上规则，验证已经填入的数字是否有效即可。 
// 空白格用 '.' 表示。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：board = 
//[["5","3",".",".","7",".",".",".","."]
//,["6",".",".","1","9","5",".",".","."]
//,[".","9","8",".",".",".",".","6","."]
//,["8",".",".",".","6",".",".",".","3"]
//,["4",".",".","8",".","3",".",".","1"]
//,["7",".",".",".","2",".",".",".","6"]
//,[".","6",".",".",".",".","2","8","."]
//,[".",".",".","4","1","9",".",".","5"]
//,[".",".",".",".","8",".",".","7","9"]]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = 
//[["8","3",".",".","7",".",".",".","."]
//,["6",".",".","1","9","5",".",".","."]
//,[".","9","8",".",".",".",".","6","."]
//,["8",".",".",".","6",".",".",".","3"]
//,["4",".",".","8",".","3",".",".","1"]
//,["7",".",".",".","2",".",".",".","6"]
//,[".","6",".",".",".",".","2","8","."]
//,[".",".",".","4","1","9",".",".","5"]
//,[".",".",".",".","8",".",".","7","9"]]
//输出：false
//解释：除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。 但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无
//效的。 
//
// 
//
// 提示： 
//
// 
// board.length == 9 
// board[i].length == 9 
// board[i][j] 是一位数字（1-9）或者 '.' 
// 
// Related Topics 数组 哈希表 矩阵 👍 920 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;

public class XL_36_ValidSudoku{
    // 有更好的方法、用三个数组分别保存 行、列、宫 内各数字出现次数、
    // 只需要遍历一次数独即可、最后扫描数组是否满足条件、
    public static void main(String[] args) {
        Solution solution = new XL_36_ValidSudoku().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private HashSet<Character> hashSet = new HashSet<>();
    public boolean isValidSudoku(char[][] board) {

        for(int i = 0; i < board.length; i++){
            hashSet.clear();
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == '.')
                    continue;
                if(hashSet.contains(board[i][j]))
                    return false;
                hashSet.add(board[i][j]);
            }
        }

        for(int j = 0; j < board[0].length; j++){
            hashSet.clear();
            for(int i = 0; i < board.length; i++){
                if(board[i][j] == '.')
                    continue;
                if(hashSet.contains(board[i][j]))
                    return false;
                hashSet.add(board[i][j]);
            }
        }

        for(int row = 0; row < board.length; row += 3){
            for(int col = 0; col < board[row].length; col += 3){
                if(!isVaild(board, row, col))
                    return false;
            }
        }
        return true;

    }

    private boolean isVaild(char[][] board, int row, int col){
        hashSet.clear();
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(board[row + i][col + j] == '.')
                    continue;
                if(hashSet.contains(board[row + i][col + j]))
                    return false;
                hashSet.add(board[row + i][col + j]);
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}