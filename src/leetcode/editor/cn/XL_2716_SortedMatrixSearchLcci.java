//给定M×N矩阵，每一行、每一列都按升序排列，请编写代码找出某元素。 
//
// 示例: 
//
// 现有矩阵 matrix 如下： 
//
// [
//  [1,   4,  7, 11, 15],
//  [2,   5,  8, 12, 19],
//  [3,   6,  9, 16, 22],
//  [10, 13, 14, 17, 24],
//  [18, 21, 23, 26, 30]
//]
// 
//
// 给定 target = 5，返回 true。 
//
// 给定 target = 20，返回 false。 
// Related Topics 数组 二分查找 分治 矩阵 👍 47 👎 0


package leetcode.editor.cn;

/*
        执行用时: 5 ms ,在所有Java提交中击败了 91.37%的用户
        内存消耗:47.1 MB ，在所有Java提交中击败了72.42%的用户

        从右上角开始抖动、
*/

public class XL_2716_SortedMatrixSearchLcci{
    public static void main(String[] args) {
        Solution solution = new XL_2716_SortedMatrixSearchLcci().new Solution();
//        boolean result = solution.searchMatrix(new int[][]{
//                        {1,4,7,11,15},
//                        {2,5,8,12,19},
//                        {3,6,9,16,22},
//                        {10,13,14,17,24},
//                        {18,21,23,26,30}}, 20);
        boolean result = solution.searchMatrix(new int[][]{
                {5,6,10,14},
                {6,10,13,18},
                {10,13,18,19}}, 14);
        System.out.println(result);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if (row == 0)
            return false;

        int col = matrix[0].length;
        if (col == 0)
            return false;

        int currentRow = 0;
        int currentCol = col - 1;
        while (currentCol >= 0 && currentRow < row){
            if(matrix[currentRow][currentCol] == target)
                return true;

            if(matrix[currentRow][currentCol] < target){
                currentRow++;
            }
            else {
                currentCol--;
            }
        }
        return false;
    }

    // 失败、
    public boolean searchMatrix_false(int[][] matrix, int target) {
        // Z字抖动法、
        if(matrix.length == 0 || matrix[0].length == 0)
            return false;

        int i = 0;
        int j = 0;

        if(matrix[0][0] == target)
            return true;
        else if(matrix[0][0] > target)
            return false;

        boolean[][] temp = new boolean[matrix.length][matrix[0].length];
//        temp[0][0] = true;

        while(i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length){
            if(temp[i][j] == true)
                return false;
            else
                temp[i][j] = true;

            if(matrix[i][j] == target)
                return true;
            else if(matrix[i][j] < target){
                if(i + 1 >= matrix.length){
                    j++;
                    continue;
                }

                if(j + 1 >= matrix[0].length){
                    i++;
                    continue;
                }


                if(matrix[i + 1][j] > matrix[i][j + 1]){
                    j++; // 优先找小的那一个、
                }
                else if (matrix[i + 1][j] == matrix[i][j + 1]){
                    if(temp[i + 1][j] == false){
                        i++;
                    }
                    else if(temp[i][j + 1] == false){
                        j++;
                    }
                    else {
                        break;
                    }
                }
                else {
                    i++;
                }
            }
            else{
                if(i - 1 <= -1){
                    j--;
                    continue;
                }

                if(j - 1 <= -1){
                    i--;
                    continue;
                }

                if(matrix[i - 1][j] > matrix[i][j - 1]){
                    i--; // 优先找大的那一个、
                }
                else if(matrix[i - 1][j] == matrix[i][j - 1]){
                    if(temp[i - 1][j] == false){
                        i--;
                    }
                    else if(temp[i][j - 1] == false){
                        j--;
                    }
                    else {
                        break;
                    }
                }
                else {
                    j--;
                }
            }
        }

        return false;
    }



    /*
        用例只能通过118/129、无法再修正、
    */
    public boolean searchMatrixOld(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0)
            return false;

        // 先行再列、
        int i = 0;
        for(; i < matrix.length; i++){
            if(matrix[i][0] > target) {
                break;
            }
        }
        if(i == 0)
            return false;
        i--;

        for(int j = 0; j < matrix[0].length; j++){
            if(matrix[i][j] > target) {
                break;
            }
            else if(matrix[i][j] == target){
                return true;
            }
        }

        // 先列再行、
        i = 0;
        for(; i < matrix[0].length; i++){
            if(matrix[0][i] > target) {
                break;
            }
        }

        if(i == 0)
            return false;
        i--;

        for(int j = 0; j < matrix.length; j++){
            if(matrix[j][i] > target) {
                break;
            }
            else if(matrix[j][i] == target){
                return true;
            }
        }

        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}