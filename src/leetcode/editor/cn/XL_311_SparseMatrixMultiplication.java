//给定两个 稀疏矩阵 ：大小为 m x k 的稀疏矩阵 mat1 和大小为 k x n 的稀疏矩阵 mat2 ，返回 mat1 x mat2 的结果。你可以假
//设乘法总是可能的。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：mat1 = [[1,0,0],[-1,0,3]], mat2 = [[7,0,0],[0,0,0],[0,0,1]]
//输出：[[7,0,0],[-7,0,3]]
// 
//
// 示例 2: 
//
// 
//输入：mat1 = [[0]], mat2 = [[0]]
//输出：[[0]]
// 
//
// 
//
// 提示: 
//
// 
// m == mat1.length 
// k == mat1[i].length == mat2.length 
// n == mat2[i].length 
// 1 <= m, n, k <= 100 
// -100 <= mat1[i][j], mat2[i][j] <= 100 
// 
// Related Topics 数组 哈希表 矩阵 👍 70 👎 0


package leetcode.editor.cn;
public class XL_311_SparseMatrixMultiplication{
    public static void main(String[] args) {
        Solution solution = new XL_311_SparseMatrixMultiplication().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int[][] result = new int[mat1.length][mat2[0].length];

        for(int row = 0; row < mat1.length; row++){
            for(int col = 0; col < mat1[row].length; col++){
                if(mat1[row][col] == 0) // 稀疏矩阵、
                    continue;
                for(int col2 = 0; col2 < mat2[0].length; col2++){
                    result[row][col2] += mat1[row][col] * mat2[col][col2]; // 不直接算出每个部位的值、而是算部分、在遍历中逐渐累加、可以省一层循环、
                }
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}