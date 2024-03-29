//给定一个正整数、负整数和 0 组成的 N × M 矩阵，编写代码找出元素总和最大的子矩阵。 
//
// 返回一个数组 [r1, c1, r2, c2]，其中 r1, c1 分别代表子矩阵左上角的行号和列号，r2, c2 分别代表右下角的行号和列号。若有多个满
//足条件的子矩阵，返回任意一个均可。 
//
// 注意：本题相对书上原题稍作改动 
//
// 示例： 
//
// 输入：
//[
//   [-1,0],
//   [0,-1]
//]
//输出：[0,1,0,1]
//解释：输入中标粗的元素即为输出所表示的矩阵 
//
// 
//
// 说明： 
//
// 
// 1 <= matrix.length, matrix[0].length <= 200 
// 
// Related Topics 数组 动态规划 矩阵 前缀和 👍 154 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

public class XL_2706_MaxSubmatrixLcci{
    public static void main(String[] args) {
        Solution solution = new XL_2706_MaxSubmatrixLcci().new Solution();
        System.out.println(solution.getMaxMatrix(new int[][]{
//                {9,-8,1,3,-2},{-3,7,6,-2,4},{6,-4,-4,8,-7}
//                {-1, -2, -9, 6}, {8, -9, -3, -6}, {2, 9, -7, -6}\
//                {-1,0},{0,-1}
                {-26, -30, -13, -48, -44, -48, -18, -23, -32, -24, -49, -19, -6, -49, -15, -23, -48, -43, -28, -15, -38, -6, -19, -50, -44, -17, -36, -11, -29, -10, -36, -10, -30, -30, -3, -5, -19, -25, -10, -49, -23, -49, -8, -18, -30, -10, -10, -14, -49, -41}, {-49, -34, -5, -28, -33, -33, -2, -19, -34, -38, -45, -15, -34, -10, -33, -19, -14, -25, -23, -5, -49, -20, -39, -18, -33, -18, -20, -38, -22, -47, -26, -39, -45, -21, -25, -27, -35, -14, -11, -35, -9, -34, -23, -8, -43, -38, -18, -9, -11, -11}, {-2, -26, -2, -16, -38, -35, -9, -25, -33, -37, -33, -41, -27, -41, -8, -8, -25, -2, -26, -47, -31, -12, -17, -20, -8, -41, -43, -23, -37, -39, -50, -6, -40, -22, -43, -46, -12, -22, -41, -27, -38, -38, -5, -23, -15, -19, -29, -23, -10, -36}, {-5, -18, -20, -31, -4, -10, -18, -42, -24, -50, -38, -10, -19, -10, -33, -20, -48, -38, -2, -18, -8, -48, -39, -37, -20, -39, -41, -10, -28, -19, -22, -16, -6, -33, -39, -22, -18, -6, -28, -21, -37, -12, -11, -32, -21, -42, -20, -5, -47, -34}, {-17, -9, -17, -47, -46, -41, -39, -12, -5, -11, -31, -14, -28, -24, -21, -39, -6, -22, -22, -17, -11, -26, -40, -23, -27, -10, -39, -10, -47, -29, -23, -50, -18, -49, -24, -31, -50, -34, -34, -47, -34, -47, -43, -19, -24, -15, -25, -5, -50, -37}, {-42, -6, -47, -33, -17, -12, -45, -10, -8, -11, -38, -39, -41, -29, -8, -20, -46, -47, -36, -42, -10, -39, -28, -6, -26, -2, -33, -47, -32, -42, -41, -22, -35, -23, -20, -46, -13, -4, -44, -43, -42, -20, -44, -21, -43, -29, -24, -27, -26, -29}, {-32, -42, -40, -4, -9, -12, -5, -22, -10, -49, -5, -19, -45, -15, -11, -27, -37, -40, -16, -32, -50, -38, -48, -47, -12, -2, -47, -29, -6, -2, -9, -45, -39, -46, -31, -36, -16, -36, -9, -47, -23, -49, -18, -25, -3, -4, -10, -14, -22, -16}, {-10, -31, -27, -17, -50, -26, -39, -7, -44, -27, -39, -11, -39, -42, -29, -31, -25, -27, -47, -27, -48, -7, -35, -25, -5, -50, -35, -47, -33, -22, -28, -32, -8, -4, -47, -39, -20, -45, -8, -9, -44, -28, -17, -30, -19, -50, -6, -48, -3, -36}, {-6, -32, -21, -50, -3, -21, -43, -37, -13, -50, -48, -14, -27, -6, -32, -13, -50, -48, -5, -26, -20, -5, -8, -49, -16, -37, -13, -30, -13, -22, -12, -40, -19, -25, -28, -3, -25, -50, -49, -21, -41, -22, -45, -29, -46, -20, -9, -2, -37, -35}, {-8, -17, -49, -2, -44, -46, -5, -8, -16, -44, -46, -42, -16, -10, -11, -11, -39, -47, -41, -14, -25, -37, -18, -19, -19, -50, -3, -18, -11, -11, -27, -20, -38, -20, -29, -46, -24, -49, -46, -32, -25, -16, -6, -3, -33, -15, -30, -49, -11, -50}, {-30, -3, -13, -34, -17, -39, -12, -4, -11, -46, -31, -7, -7, -48, -31, -18, -47, -35, -42, -24, -50, -18, -30, -32, -2, -7, -18, -34, -8, -27, -42, -15, -41, -27, -35, -16, -21, -19, -31, -24, -42, -24, -25, -32, -50, -29, -32, -34, -15, -3}, {-22, -15, -3, -47, -47, -3, -47, -10, -18, -38, -41, -32, -37, -18, -30, -3, -34, -35, -23, -6, -20, -48, -16, -7, -13, -5, -40, -9, -43, -36, -25, -6, -16, -14, -38, -31, -17, -46, -18, -26, -48, -41, -38, -43, -22, -44, -31, -29, -24, -24}, {-17, -19, -41, -23, -46, -3, -16, -39, -30, -2, -4, -10, -5, -27, -26, -43, -14, -12, -21, -14, -5, -16, -36, -48, -35, -15, -20, -45, -27, -38, -10, -39, -18, -26, -10, -28, -7, -34, -38, -36, -32, -50, -38, -28, -48, -15, -8, -8, -2, -50}, {-35, -7, -37, -49, -33, -42, -8, -47, -2, -9, -16, -34, -35, -6, -34, -10, -10, -38, -30, -4, -39, -31, -47, -50, -12, -50, -32, -43, -42, -29, -14, -13, -18, -7, -17, -32, -3, -35, -40, -4, -24, -16, -15, -18, -48, -41, -42, -19, -13, -26}, {-38, -35, -43, -12, -11, -6, -19, -32, -41, -32, -21, -19, -30, -37, -16, -27, -30, -49, -4, -48, -19, -40, -40, -40, -26, -10, -35, -3, -19, -12, -17, -49, -9, -43, -38, -17, -6, -22, -36, -40, -46, -44, -6, -13, -5, -36, -21, -44, -45, -28}, {-49, -35, -12, -19, -7, -47, -20, -2, -15, -5, -19, -5, -28, -47, -44, -18, -13, -41, -23, -37, -23, -20, -31, -33, -36, -41, -40, -37, -19, -10, -36, -23, -20, -37, -29, -19, -33, -24, -13, -3, -3, -36, -44, -2, -2, -36, -25, -11, -26, -36}, {-11, -44, -27, -47, -24, -33, -22, -33, -27, -3, -9, -23, -33, -6, -11, -4, -25, -47, -23, -5, -5, -11, -47, -22, -29, -17, -4, -49, -8, -50, -23, -36, -33, -22, -12, -30, -3, -3, -12, -9, -26, -43, -21, -21, -46, -35, -27, -20, -26, -40}, {-42, -21, -7, -10, -17, -45, -21, -37, -49, -47, -28, -39, -31, -6, -19, -5, -22, -26, -35, -33, -14, -37, -4, -47, -47, -16, -30, -34, -13, -49, -35, -39, -35, -13, -17, -28, -44, -8, -27, -24, -14, -3, -37, -2, -44, -15, -49, -7, -8, -6}, {-17, -9, -41, -29, -8, -43, -22, -11, -28, -24, -12, -39, -43, -14, -6, -45, -41, -12, -43, -31, -21, -34, -31, -23, -41, -5, -8, -39, -9, -48, -4, -49, -11, -35, -11, -46, -36, -33, -15, -49, -47, -14, -34, -25, -39, -44, -21, -30, -14, -38}, {-19, -48, -47, -41, -26, -11, -23, -3, -14, -14, -10, -34, -47, -30, -50, -3, -43, -22, -24, -47, -5, -13, -28, -46, -22, -17, -22, -33, -33, -23, -38, -45, -35, -50, -43, -40, -21, -8, -50, -50, -4, -22, -29, -34, -50, -34, -43, -9, -14, -29}, {-35, -4, -40, -17, -27, -48, -27, -21, -7, -18, -19, -8, -25, -34, -6, -5, -36, -36, -24, -10, -41, -24, -26, -16, -48, -46, -22, -7, -38, -17, -3, -19, -35, -19, -40, -6, -48, -43, -46, -40, -24, -41, -43, -34, -35, -48, -49, -23, -42, -39}, {-10, -13, -20, -4, -41, -41, -21, -20, -29, -48, -12, -23, -41, -37, -43, -50, -7, -3, -7, -41, -48, -34, -35, -30, -12, -36, -29, -37, -25, -11, -13, -4, -19, -20, -8, -37, -11, -6, -25, -17, -14, -17, -18, -16, -19, -38, -17, -26, -17, -32}, {-49, -14, -10, -15, -34, -6, -31, -12, -29, -7, -13, -16, -16, -11, -34, -9, -40, -28, -22, -12, -24, -11, -31, -24, -28, -38, -18, -27, -2, -32, -20, -41, -46, -16, -46, -35, -14, -45, -19, -49, -18, -46, -17, -46, -26, -31, -7, -8, -38, -26}, {-50, -13, -40, -17, -48, -18, -20, -22, -28, -12, -24, -12, -50, -28, -13, -5, -28, -48, -35, -24, -7, -5, -25, -24, -23, -8, -34, -28, -36, -31, -42, -15, -3, -4, -29, -29, -3, -34, -41, -21, -42, -19, -19, -47, -12, -37, -32, -14, -4, -19}, {-48, -9, -21, -23, -29, -29, -16, -9, -31, -5, -31, -21, -12, -9, -28, -21, -12, -23, -20, -48, -41, -16, -19, -30, -11, -44, -8, -15, -19, -7, -17, -6, -12, -12, -33, -36, -30, -22, -24, -49, -7, -27, -47, -30, -16, -20, -23, -6, -48, -24}, {-44, -12, -24, -40, -20, -17, -45, -31, -13, -47, -32, -16, -22, -7, -20, -23, -8, -11, -32, -17, -18, -19, -13, -12, -4, -27, -50, -27, -27, -39, -33, -14, -4, -43, -36, -4, -24, -23, -12, -42, -34, -20, -47, -24, -21, -27, -16, -3, -12, -47}, {-13, -18, -9, -5, -38, -24, -10, -20, -22, -25, -5, -28, -9, -20, -24, -49, -41, -31, -30, -5, -8, -12, -29, -16, -45, -15, -50, -50, -9, -7, -33, -6, -8, -17, -10, -26, -31, -11, -13, -39, -43, -43, -16, -43, -47, -42, -9, -25, -21, -8}, {-39, -23, -25, -8, -8, -30, -5, -30, -50, -31, -36, -23, -38, -43, -6, -34, -22, -44, -20, -49, -6, -28, -13, -9, -48, -14, -5, -49, -32, -20, -3, -22, -9, -48, -3, -41, -15, -23, -47, -36, -15, -19, -33, -30, -45, -20, -48, -5, -10, -50}, {-47, -39, -16, -49, -7, -11, -39, -17, -38, -27, -43, -34, -40, -41, -32, -34, -26, -9, -7, -9, -29, -28, -49, -7, -19, -10, -23, -11, -7, -34, -16, -33, -21, -10, -5, -13, -3, -48, -32, -45, -29, -43, -11, -15, -31, -2, -29, -44, -35, -36}, {-33, -47, -8, -39, -45, -22, -13, -35, -20, -28, -12, -9, -18, -41, -27, -43, -39, -41, -33, -12, -13, -23, -20, -46, -2, -42, -47, -11, -18, -31, -44, -11, -33, -14, -48, -18, -35, -8, -26, -11, -49, -38, -39, -38, -34, -41, -14, -24, -18, -42}, {-37, -2, -48, -42, -12, -7, -16, -40, -35, -18, -33, -39, -50, -13, -3, -18, -33, -27, -9, -41, -28, -49, -9, -28, -4, -22, -15, -28, -27, -13, -30, -7, -30, -49, -21, -40, -13, -38, -33, -43, -7, -28, -36, -16, -20, -33, -44, -3, -36, -49}, {-2, -26, -10, -24, -14, -17, -30, -23, -44, -28, -40, -18, -11, -35, -41, -8, -31, -16, -20, -13, -26, -31, -12, -14, -39, -11, -37, -34, -11, -33, -21, -7, -18, -5, -16, -33, -10, -31, -28, -34, -3, -17, -21, -10, -8, -31, -39, -45, -16, -41}, {-28, -38, -8, -20, -12, -2, -26, -5, -18, -23, -3, -39, -10, -50, -41, -49, -42, -50, -23, -5, -24, -33, -4, -15, -6, -3, -9, -44, -2, -9, -30, -12, -11, -46, -27, -48, -11, -23, -22, -26, -37, -18, -34, -50, -34, -13, -33, -14, -36, -5}, {-23, -16, -6, -39, -5, -12, -18, -27, -10, -13, -10, -46, -19, -15, -30, -30, -9, -47, -22, -3, -9, -23, -48, -37, -13, -26, -32, -31, -35, -12, -2, -39, -6, -32, -44, -20, -34, -32, -6, -13, -22, -6, -9, -2, -28, -47, -33, -2, -48, -50}, {-43, -45, -26, -6, -48, -12, -35, -5, -3, -4, -46, -29, -20, -46, -24, -10, -47, -40, -3, -44, -46, -18, -23, -9, -34, -14, -19, -25, -27, -15, -28, -10, -50, -26, -33, -22, -40, -2, -21, -8, -25, -24, -16, -28, -26, -48, -14, -10, -24, -40}, {-27, -41, -48, -42, -15, -5, -41, -24, -26, -48, -45, -43, -36, -33, -46, -50, -6, -21, -18, -39, -43, -11, -11, -36, -43, -28, -34, -20, -43, -27, -4, -33, -6, -32, -43, -45, -10, -2, -42, -26, -45, -4, -5, -35, -35, -6, -45, -21, -5, -24}, {-12, -31, -16, -4, -30, -42, -32, -21, -23, -46, -19, -18, -43, -44, -16, -28, -11, -15, -17, -15, -11, -45, -28, -2, -4, -22, -16, -32, -3, -37, -37, -9, -17, -19, -18, -30, -46, -26, -2, -49, -19, -39, -35, -6, -14, -32, -15, -16, -8, -30}, {-50, -45, -3, -13, -12, -32, -31, -4, -18, -30, -12, -46, -23, -18, -29, -19, -10, -42, -3, -48, -6, -38, -9, -29, -40, -3, -31, -17, -9, -43, -5, -14, -49, -22, -39, -41, -36, -28, -16, -48, -41, -17, -48, -12, -24, -49, -9, -48, -35, -15}, {-6, -35, -14, -43, -7, -28, -2, -11, -34, -3, -35, -5, -10, -21, -38, -19, -42, -2, -47, -22, -24, -28, -42, -11, -38, -44, -42, -16, -8, -29, -2, -6, -49, -5, -26, -25, -12, -46, -10, -25, -42, -35, -13, -18, -49, -3, -4, -31, -40, -19}, {-15, -16, -40, -28, -40, -31, -25, -4, -35, -46, -28, -8, -35, -8, -9, -17, -19, -41, -4, -49, -32, -38, -10, -23, -45, -17, -11, -29, -11, -7, -18, -47, -39, -7, -9, -49, -19, -27, -50, -30, -40, -45, -49, -29, -31, -7, -30, -28, -18, -40}, {-33, -49, -30, -5, -38, -29, -20, -50, -35, -48, -19, -13, -42, -34, -38, -19, -18, -48, -13, -20, -29, -32, -18, -48, -47, -29, -36, -20, -47, -2, -35, -20, -7, -49, -28, -23, -28, -13, -36, -5, -36, -39, -44, -9, -18, -30, -15, -2, -40, -4}, {-44, -36, -48, -39, -21, -8, -49, -34, -12, -17, -41, -10, -2, -41, -22, -41, -43, -39, -21, -9, -47, -43, -17, -48, -40, -17, -14, -34, -21, -19, -32, -42, -38, -36, -38, -21, -39, -38, -43, -30, -43, -12, -49, -5, -31, -28, -4, -31, -38, -35}, {-10, -20, -37, -14, -13, -46, -8, -6, -6, -21, -4, -35, -23, -39, -16, -2, -43, -40, -24, -37, -7, -24, -19, -37, -16, -49, -48, -4, -30, -17, -34, -7, -3, -46, -32, -30, -31, -12, -6, -19, -8, -16, -2, -22, -45, -16, -6, -19, -19, -11}, {-38, -49, -23, -21, -26, -44, -37, -10, -39, -14, -35, -26, -23, -20, -42, -43, -44, -38, -33, -19, -49, -45, -25, -44, -48, -3, -37, -36, -7, -7, -10, -34, -18, -44, -11, -27, -39, -49, -22, -4, -23, -9, -41, -14, -50, -18, -32, -14, -12, -31}, {-27, -47, -42, -31, -5, -50, -39, -25, -48, -40, -13, -46, -29, -31, -25, -2, -18, -46, -28, -29, -26, -32, -8, -4, -25, -22, -45, -50, -50, -44, -8, -28, -44, -44, -14, -20, -26, -44, -10, -50, -49, -34, -40, -19, -43, -50, -41, -20, -33, -5}, {-7, -11, -32, -47, -11, -2, -23, -31, -30, -16, -46, -30, -35, -4, -27, -45, -6, -36, -24, -44, -30, -44, -6, -26, -47, -26, -11, -14, -34, -28, -46, -41, -9, -45, -30, -19, -35, -36, -44, -18, -43, -41, -35, -16, -34, -22, -41, -3, -5, -29}, {-46, -16, -31, -8, -48, -24, -6, -41, -49, -6, -22, -39, -20, -42, -19, -33, -2, -35, -41, -45, -22, -50, -10, -8, -44, -15, -2, -36, -4, -31, -48, -8, -3, -5, -25, -12, -12, -48, -9, -6, -15, -31, -45, -2, -15, -39, -23, -43, -2, -27}, {-27, -31, -39, -44, -43, -33, -49, -24, -44, -40, -5, -35, -21, -29, -23, -36, -11, -40, -25, -28, -9, -28, -4, -19, -26, -24, -48, -42, -2, -19, -43, -28, -46, -21, -47, -43, -5, -23, -43, -14, -27, -44, -39, -41, -9, -48, -7, -36, -40, -34}, {-29, -50, -2, -47, -40, -16, -5, -6, -16, -44, -32, -36, -41, -45, -12, -39, -13, -23, -18, -15, -38, -31, -46, -50, -4, -41, -15, -26, -14, -34, -31, -13, -5, -13, -16, -8, -35, -34, -7, -21, -2, -23, -27, -13, -13, -41, -18, -31, -15, -16}, {-6, -4, -47, -9, -5, -37, -48, -10, -44, -24, -22, -37, -9, -44, -22, -24, -2, -43, -47, -31, -45, -21, -36, -28, -21, -26, -30, -34, -28, -19, -12, -28, -41, -29, -49, -47, -46, -24, -50, -19, -49, -15, -2, -41, -20, -14, -35, -23, -10, -24}, {-2, -31, -48, -43, -24, -15, -33, -21, -17, -23, -9, -19, -38, -46, -46, -32, -19, -30, -14, -6, -25, -44, -18, -39, -7, -39, -16, -41, -30, -15, -25, -33, -48, -42, -27, -20, -43, -25, -10, -32, -8, -23, -23, -18, -35, -18, -32, -5, -35, -31}, {-32, -48, -33, -9, -37, -13, -40, -17, -45, -32, -2, -25, -5, -17, -19, -34, -2, -20, -19, -27, -36, -7, -12, -7, -46, -5, -6, -32, -41, -42, -21, -13, -33, -20, -2, -34, -2, -15, -9, -29, -30, -42, -20, -44, -40, -28, -34, -30, -24, -49}, {-11, -22, -9, -23, -20, -42, -2, -18, -8, -44, -36, -10, -42, -20, -49, -17, -45, -44, -20, -33, -33, -33, -8, -20, -21, -8, -33, -36, -30, -44, -38, -50, -39, -43, -26, -9, -17, -36, -10, -16, -4, -12, -9, -21, -40, -31, -36, -31, -27, -22}, {-36, -12, -34, -39, -50, -46, -47, -8, -14, -25, -10, -21, -33, -16, -46, -10, -13, -20, -26, -25, -50, -11, -22, -48, -34, -32, -8, -11, -27, -24, -13, -26, -30, -6, -4, -36, -21, -22, -9, -48, -2, -40, -23, -42, -8, -40, -40, -38, -16, -30}, {-34, -20, -40, -3, -24, -15, -48, -20, -23, -5, -41, -30, -42, -25, -38, -38, -39, -41, -11, -26, -7, -16, -3, -27, -42, -5, -16, -27, -41, -39, -36, -41, -5, -16, -25, -4, -34, -47, -44, -5, -27, -2, -14, -6, -38, -43, -4, -15, -44, -3}, {-42, -38, -50, -21, -9, -19, -21, -45, -43, -32, -46, -40, -3, -23, -33, -11, -28, -30, -48, -12, -50, -47, -24, -25, -23, -40, -11, -33, -21, -16, -36, -33, -15, -50, -43, -25, -2, -2, -14, -27, -33, -37, -37, -5, -45, -15, -35, -29, -19, -38}, {-18, -47, -30, -50, -21, -40, -4, -42, -10, -29, -50, -23, -13, -17, -10, -3, -25, -7, -28, -8, -11, -39, -28, -16, -35, -41, -17, -28, -35, -26, -35, -28, -28, -7, -48, -21, -36, -17, -45, -30, -7, -29, -45, -5, -43, -30, -42, -11, -43, -37}, {-47, -38, -35, -16, -40, -39, -26, -41, -8, -37, -10, -16, -23, -13, -32, -46, -46, -42, -2, -23, -21, -31, -49, -4, -40, -15, -29, -43, -38, -7, -38, -41, -49, -26, -29, -41, -43, -9, -10, -45, -14, -21, -6, -34, -21, -25, -40, -47, -13, -20}, {-11, -26, -27, -24, -24, -5, -46, -36, -26, -15, -40, -28, -34, -30, -25, -49, -50, -36, -49, -45, -26, -12, -4, -41, -5, -21, -14, -47, -35, -38, -24, -43, -19, -28, -50, -34, -25, -9, -29, -24, -6, -25, -43, -21, -42, -10, -32, -28, -36, -45}, {-48, -23, -38, -50, -42, -44, -19, -10, -18, -43, -41, -41, -40, -37, -9, -42, -13, -4, -49, -22, -15, -40, -9, -21, -25, -40, -28, -33, -20, -50, -49, -27, -32, -34, -41, -13, -8, -50, -41, -21, -37, -2, -19, -32, -5, -8, -3, -30, -39, -38}, {-48, -35, -23, -43, -32, -10, -25, -4, -32, -50, -25, -32, -24, -24, -49, -12, -50, -5, -39, -33, -4, -49, -4, -49, -19, -37, -31, -49, -45, -3, -35, -29, -9, -20, -15, -8, -28, -14, -28, -15, -14, -38, -46, -14, -49, -40, -47, -21, -46, -27}, {-9, -18, -46, -39, -41, -50, -31, -39, -43, -6, -31, -37, -50, -20, -13, -16, -25, -5, -25, -27, -5, -36, -41, -19, -27, -37, -27, -26, -10, -12, -8, -31, -46, -47, -7, -29, -29, -12, -30, -37, -13, -10, -29, -13, -20, -18, -42, -50, -36, -32}, {-40, -25, -21, -35, -16, -37, -11, -25, -38, -34, -20, -11, -44, -29, -4, -49, -48, -39, -50, -4, -26, -42, -12, -36, -12, -34, -19, -17, -25, -23, -31, -3, -14, -21, -8, -23, -32, -6, -11, -47, -18, -44, -37, -36, -24, -49, -39, -11, -18, -24}, {-14, -20, -3, -50, -16, -23, -37, -40, -16, -34, -5, -30, -27, -33, -43, -7, -38, -40, -40, -10, -27, -47, -21, -5, -31, -39, -35, -27, -45, -47, -46, -39, -32, -6, -15, -12, -24, -4, -39, -13, -22, -39, -38, -8, -34, -16, -14, -46, -45, -6}, {-32, -49, -19, -17, -25, -43, -28, -50, -48, -29, -39, -47, -4, -2, -45, -35, -23, -33, -15, -6, -17, -32, -38, -12, -48, -34, -30, -35, -4, -24, -35, -17, -42, -50, -21, -50, -21, -39, -12, -30, -32, -33, -30, -18, -6, -47, -23, -26, -36, -14}, {-25, -10, -42, -44, -19, -36, -2, -15, -37, -14, -41, -20, -33, -17, -13, -40, -14, -11, -7, -16, -42, -14, -28, -41, -48, -33, -45, -42, -5, -10, -18, -5, -26, -43, -49, -33, -17, -23, -47, -41, -9, -50, -41, -14, -32, -2, -48, -11, -5, -39}, {-33, -16, -17, -17, -12, -49, -32, -36, -50, -3, -35, -8, -23, -45, -42, -14, -43, -5, -26, -10, -46, -26, -4, -4, -35, -29, -21, -27, -9, -22, -12, -31, -20, -19, -27, -41, -41, -45, -14, -10, -40, -10, -44, -28, -12, -12, -25, -14, -4, -45}, {-3, -7, -30, -36, -30, -10, -46, -26, -13, -31, -3, -27, -28, -22, -47, -16, -20, -46, -38, -32, -43, -15, -5, -23, -46, -31, -15, -12, -43, -48, -26, -33, -16, -2, -17, -25, -4, -45, -20, -7, -21, -50, -23, -38, -9, -27, -35, -4, -35, -38}, {-49, -16, -41, -41, -31, -10, -36, -14, -43, -6, -39, -29, -22, -14, -46, -45, -15, -42, -48, -2, -37, -18, -33, -45, -50, -49, -31, -34, -15, -20, -37, -43, -34, -31, -28, -35, -22, -23, -18, -42, -31, -50, -28, -17, -18, -46, -21, -45, -39, -44}, {-35, -33, -50, -21, -31, -45, -46, -28, -26, -17, -4, -26, -39, -6, -14, -11, -22, -16, -42, -48, -17, -50, -23, -4, -6, -48, -44, -20, -12, -40, -7, -7, -6, -8, -33, -5, -21, -42, -38, -30, -13, -43, -28, -48, -30, -11, -22, -32, -38, -8}, {-12, -11, -7, -8, -23, -32, -21, -30, -43, -41, -32, -8, -32, -13, -38, -42, -21, -4, -34, -29, -20, -8, -18, -22, -9, -45, -9, -18, -4, -20, -47, -12, -5, -37, -43, -44, -19, -31, -49, -22, -27, -21, -33, -38, -31, -36, -44, -20, -28, -18}, {-10, -23, -50, -29, -21, -49, -24, -7, -45, -2, -26, -6, -6, -48, -39, -39, -32, -9, -47, -47, -2, -44, -19, -30, -10, -13, -50, -48, -36, -34, -24, -29, -31, -12, -34, -7, -5, -3, -22, -13, -45, -40, -16, -38, -19, -28, -15, -34, -19, -10}, {-30, -12, -28, -11, -27, -34, -5, -43, -24, -43, -39, -50, -25, -19, -5, -36, -25, -8, -21, -7, -41, -20, -8, -37, -38, -14, -26, -20, -35, -13, -10, -6, -13, -23, -47, -18, -9, -20, -41, -13, -47, -37, -46, -19, -13, -10, -6, -19, -29, -31}, {-44, -47, -28, -42, -8, -26, -7, -46, -27, -15, -38, -21, -48, -37, -13, -19, -30, -50, -30, -8, -20, -31, -34, -7, -2, -14, -31, -13, -47, -18, -49, -12, -45, -28, -23, -24, -19, -46, -39, -16, -35, -8, -9, -31, -30, -15, -12, -21, -17, -17}, {-12, -27, -43, -21, -27, -21, -25, -37, -32, -50, -39, -45, -20, -5, -32, -41, -22, -25, -26, -27, -15, -24, -30, -7, -4, -20, -10, -22, -5, -22, -39, -31, -40, -39, -45, -46, -25, -43, -13, -27, -46, -15, -34, -49, -20, -23, -30, -26, -13, -20}, {-24, -50, -49, -34, -29, -38, -13, -19, -41, -39, -30, -30, -10, -5, -18, -26, -41, -6, -41, -23, -35, -44, -4, -7, -41, -19, -46, -21, -10, -30, -36, -19, -20, -42, -44, -3, -35, -15, -19, -20, -42, -4, -25, -39, -16, -3, -27, -3, -6, -19}, {-10, -32, -43, -39, -6, -7, -43, -2, -34, -50, -49, -23, -16, -20, -2, -45, -38, -7, -6, -30, -5, -37, -28, -47, -23, -7, -14, -37, -22, -26, -4, -4, -21, -49, -35, -5, -29, -2, -12, -15, -39, -18, -50, -10, -4, -37, -43, -48, -3, -15}, {-9, -25, -48, -31, -15, -5, -4, -9, -31, -4, -21, -37, -8, -42, -11, -23, -40, -13, -2, -42, -2, -31, -13, -13, -46, -24, -43, -45, -4, -35, -35, -49, -43, -22, -31, -42, -43, -34, -36, -33, -9, -35, -33, -49, -34, -28, -40, -14, -43, -23}, {-29, -30, -7, -10, -5, -50, -5, -16, -42, -15, -17, -27, -21, -19, -45, -7, -36, -7, -42, -29, -36, -18, -29, -25, -39, -39, -6, -23, -29, -38, -44, -8, -9, -36, -5, -33, -16, -31, -28, -35, -33, -25, -48, -40, -23, -16, -5, -16, -37, -25}, {-18, -23, -20, -48, -21, -13, -33, -47, -42, -29, -38, -6, -22, -48, -26, -17, -17, -29, -7, -33, -7, -2, -33, -5, -36, -16, -33, -10, -25, -38, -13, -7, -21, -44, -21, -18, -6, -33, -47, -18, -41, -24, -22, -12, -22, -48, -29, -36, -38, -40}, {-33, -13, -31, -29, -15, -30, -41, -9, -44, -30, -5, -23, -15, -40, -25, -39, -45, -40, -25, -48, -25, -49, -28, -17, -24, -21, -20, -12, -49, -36, -11, -14, -37, -12, -17, -36, -44, -16, -33, -22, -37, -14, -44, -50, -3, -46, -44, -11, -36, -35}, {-16, -3, -33, -4, -14, -4, -13, -44, -31, -49, -14, -13, -3, -6, -14, -2, -33, -34, -39, -34, -3, -4, -49, -11, -46, -26, -34, -8, -48, -9, -30, -42, -28, -26, -31, -40, -47, -37, -4, -15, -48, -4, -14, -2, -22, -4, -5, -50, -43, -39}, {-37, -15, -47, -44, -28, -37, -48, -4, -6, -17, -19, -28, -26, -26, -11, -43, -21, -38, -5, -23, -29, -25, -21, -4, -41, -4, -8, -30, -10, -36, -29, -6, -44, -47, -43, -21, -20, -38, -31, -11, -18, -6, -19, -45, -42, -13, -15, -41, -30, -32}, {-22, -34, -33, -28, -5, -8, -40, -38, -49, -40, -30, -46, -13, -44, -42, -21, -4, -41, -23, -34, -27, -25, -37, -20, -46, -14, -10, -46, -20, -20, -18, -12, -50, -42, -39, -19, -32, -23, -26, -2, -28, -15, -7, -34, -26, -5, -25, -8, -35, -43}, {-42, -42, -30, -21, -31, -26, -25, -36, -17, -22, -48, -37, -9, -17, -24, -39, -10, -26, -32, -18, -9, -9, -12, -20, -22, -48, -36, -27, -49, -18, -38, -9, -17, -20, -11, -13, -39, -22, -20, -37, -43, -22, -3, -40, -6, -8, -9, -39, -44, -23}, {-33, -31, -46, -34, -24, -38, -46, -44, -27, -21, -17, -10, -45, -38, -21, -50, -23, -46, -5, -9, -21, -5, -47, -43, -3, -42, -25, -40, -48, -22, -48, -39, -18, -9, -28, -45, -19, -14, -23, -36, -19, -36, -32, -50, -15, -41, -18, -21, -50, -18}, {-45, -28, -22, -39, -18, -47, -37, -44, -28, -32, -32, -47, -46, -42, -28, -47, -9, -27, -23, -9, -24, -17, -34, -36, -19, -40, -36, -13, -40, -28, -16, -11, -15, -26, -37, -8, -42, -44, -16, -24, -43, -17, -2, -19, -25, -8, -24, -46, -16, -47}, {-28, -39, -33, -33, -24, -24, -37, -12, -39, -17, -44, -5, -18, -16, -32, -23, -26, -6, -12, -27, -25, -30, -24, -33, -29, -14, -40, -13, -24, -33, -22, -37, -26, -20, -11, -38, -6, -28, -20, -19, -46, -7, -26, -41, -17, -25, -24, -9, -5, -42}, {-35, -10, -49, -3, -18, -45, -34, -13, -22, -30, -8, -23, -2, -43, -25, -9, -23, -2, -14, -10, -50, -31, -43, -16, -14, -47, -37, -5, -34, -48, -40, -23, -18, -12, -46, -12, -45, -48, -50, -36, -17, -30, -49, -29, -22, -48, -31, -30, -47, -13}, {-24, -44, -16, -46, -47, -39, -28, -48, -35, -6, -50, -27, -3, -3, -23, -8, -17, -2, -13, -38, -8, -42, -50, -24, -2, -23, -37, -31, -22, -28, -11, -23, -49, -24, -9, -5, -7, -32, -39, -13, -43, -47, -36, -30, -31, -47, -28, -36, -3, -24}, {-22, -33, -22, -15, -9, -9, -31, -44, -5, -22, -4, -17, -49, -41, -20, -21, -10, -36, -27, -28, -30, -23, -3, -27, -24, -45, -22, -46, -45, -13, -39, -21, -3, -40, -39, -44, -3, -30, -2, -28, -28, -42, -8, -27, -25, -48, -30, -2, -31, -14}, {-26, -29, -47, -11, -43, -45, -12, -38, -32, -21, -43, -21, -41, -14, -31, -22, -13, -3, -48, -26, -40, -7, -13, -47, -50, -47, -38, -40, -41, -39, -11, -11, -48, -26, -41, -24, -27, -19, -45, -28, -46, -31, -28, -8, -27, -33, -33, -45, -9, -31}, {-14, -19, -33, -41, -47, -49, -28, -50, -32, -31, -50, -37, -29, -42, -25, -39, -42, -31, -27, -37, -11, -45, -29, -50, -12, -50, -34, -25, -8, -25, -45, -8, -34, -35, -3, -38, -11, -4, -15, -22, -2, -27, -9, -31, -42, -42, -48, -34, -30, -14}, {-11, -43, -24, -28, -14, -8, -43, -35, -7, -10, -25, -49, -11, -39, -12, -36, -44, -2, -28, -33, -33, -40, -39, -42, -30, -38, -2, -3, -10, -6, -50, -23, -25, -49, -32, -8, -37, -40, -24, -49, -48, -16, -4, -11, -41, -10, -27, -10, -6, -20}, {-6, -47, -8, -31, -16, -27, -19, -16, -4, -27, -45, -17, -16, -10, -34, -2, -8, -3, -44, -3, -2, -10, -11, -20, -9, -7, -44, -46, -33, -33, -31, -27, -26, -14, -34, -33, -23, -21, -48, -49, -23, -22, -36, -33, -32, -12, -23, -3, -40, -47}, {-36, -4, -42, -30, -38, -43, -20, -9, -43, -46, -19, -29, -18, -49, -7, -7, -34, -35, -12, -35, -27, -32, -10, -31, -4, -16, -13, -44, -44, -37, -32, -32, -49, -50, -49, -4, -21, -13, -35, -31, -41, -22, -12, -50, -30, -11, -32, -28, -3, -32}, {-21, -26, -38, -9, -11, -27, -50, -33, -18, -49, -26, -4, -41, -37, -27, -34, -39, -49, -18, -15, -39, -10, -30, -22, -28, -48, -11, -25, -39, -2, -40, -47, -6, -22, -21, -14, -42, -31, -40, -47, -10, -19, -19, -50, -29, -40, -40, -22, -26, -10}, {-16, -9, -4, -17, -33, -19, -14, -38, -27, -15, -6, -18, -25, -16, -43, -7, -22, -32, -10, -41, -37, -19, -29, -48, -19, -23, -24, -28, -47, -29, -24, -35, -35, -50, -43, -35, -41, -38, -47, -32, -27, -7, -7, -35, -30, -26, -18, -32, -31, -14}, {-8, -29, -48, -17, -40, -35, -42, -3, -38, -24, -16, -13, -3, -29, -35, -27, -22, -4, -16, -5, -34, -33, -32, -46, -38, -8, -36, -25, -49, -4, -3, -26, -29, -21, -34, -23, -3, -15, -12, -21, -10, -21, -33, -31, -12, -8, -19, -24, -14, -20}, {-30, -7, -25, -24, -13, -15, -28, -28, -31, -42, -47, -37, -18, -17, -2, -30, -7, -31, -6, -7, -35, -11, -49, -6, -13, -39, -47, -23, -25, -25, -5, -42, -18, -5, -49, -45, -23, -11, -44, -43, -22, -4, -44, -37, -22, -48, -41, -8, -44, -26}
        }));
    }

    /**
     * 利用最大连续字段和、子数组为基石、
     * 利用 i ~ j 行的矩阵压缩为一维调用最大连续子数组、记录起点终点、
     * 遍历所有行压缩可能、最终得到全局最大子矩阵、
     *
     * 耗时约 2.5 小时、
     *
     * 可以优化一些传参、
     *
     * 执行用时：     * 67 ms     * , 在所有 Java 提交中击败了     * 12.11%     * 的用户
     * 内存消耗：     * 47.3 MB   * , 在所有 Java 提交中击败了     * 5.04%     * 的用户
     */

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int[] getMaxSubArray(int[] nums){
        int[] result = new int[3]; // start end max
        result[2] = nums[0];

        int[] maxSubL = new int[nums.length];
        int maxL = nums[0];
        maxSubL[0] = nums[0];

        int begin = 0;
        for(int i = 1; i < nums.length; i++){
            maxSubL[i] = nums[i];
            if(maxSubL[i - 1] > 0){ // 题目要求子数组连续、因此只需要判断上一位即可、
                maxSubL[i] += maxSubL[i - 1];
            }
            else {
                // 自成一体、
                begin = i;
            }

            if(maxL < maxSubL[i]){
                // 需要更新、
                maxL = maxSubL[i];
                result[0] = begin;
                result[1] = i;
            }
        }

        result[2] = maxL;
        return result;
    }

    public int[] getMaxMatrix(int[][] matrix) {
        // 我的原始想法、只能答对一半用例、
        // 矩阵终点可以从上左两个方向延伸过来、
        // 记录每次求解的起点、

        int[] nums = new int[matrix[0].length];
        int[] result = new int[4];
        int maxSum = Integer.MIN_VALUE;

        for(int i = 0; i < matrix.length; i++){
            Arrays.fill(nums, 0);
            for(int j = i; j < matrix.length; j++){
                // 对于 i ~ j行、

                for(int k = 0; k < matrix[0].length; k++){
                    // 对于每一列、求和、
                    nums[k] += matrix[j][k];
                }
                // 求当前区间、最长连续子数组、
                int[] colSTM = getMaxSubArray(nums);
                if(colSTM[2] > maxSum){
                    maxSum = colSTM[2];
                    result[0] = i;
                    result[1] = colSTM[0];
                    result[2] = j;
                    result[3] = colSTM[1];
                }
            }
        }
        return result;


/*        int[][] maxSums = new int[matrix.length][matrix[0].length];
        int[][][] maxSumsIndex = new int[matrix.length][matrix[0].length][2];
        int[] result = new int[4];
        int maxSum = matrix[0][0];

        // 处理 00、
        maxSums[0][0] = matrix[0][0];
        maxSumsIndex[0][0][0] = 0;
        maxSumsIndex[0][0][1] = 0;


        // 处理 01、
        // 处理 10、
//        if(matrix[0][0] > 0){
//            // 01
//            maxSums[0][1] = matrix[0][1] + matrix[0][0];
//            maxSumsIndex[0][1][0] = 0;
//            maxSumsIndex[0][1][1] = 0;
//
//            if(maxSum < maxSums[0][1]){
//                // 更新值和index、
//                maxSum = maxSums[0][1];
//                result[2] = 0;
//                result[3] = 1;
//            }
//
//            // 10
//            maxSums[1][0] = matrix[1][0] + matrix[0][0];
//            maxSumsIndex[1][0][0] = 0;
//            maxSumsIndex[1][0][1] = 0;
//
//            if(maxSum < maxSums[1][0]){
//                // 更新值和index、
//                maxSum = maxSums[1][0];
//                result[2] = 1;
//                result[3] = 0;
//            }
//        }
//        else {
//            maxSums[0][1] = matrix[0][1];
//            maxSumsIndex[0][1][0] = 0;
//            maxSumsIndex[0][1][1] = 1;
//
//            maxSums[1][0] = matrix[1][0];
//            maxSumsIndex[1][0][0] = 1;
//            maxSumsIndex[1][0][1] = 0;
//
//            if(matrix[0][1] > matrix[1][0]){
//                maxSum = maxSums[0][1];
//                result[0] = 0;
//                result[1] = 1;
//                result[2] = 0;
//                result[3] = 1;
//            }
//            else {
//                maxSum = maxSums[1][0];
//                result[0] = 1;
//                result[1] = 0;
//                result[2] = 1;
//                result[3] = 0;
//            }
//        }



        for(int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                // 默认值、
                maxSums[i][j] = matrix[i][j];
                maxSumsIndex[i][j][0] = i;
                maxSumsIndex[i][j][1] = j;

                int temp = 0;
                // 检查两个方向、
                // 上、

                if(i - 1 >= 0 && maxSums[i - 1][j] > 0){
                    // 纳入、
                    temp = maxSums[i - 1][j];
                    for(int k = maxSumsIndex[i - 1][j][1]; k <= j; k++){
                        temp += matrix[i][k];
                    }

                    if(temp > maxSums[i][j]){
                        // 更新值和index、
                        maxSums[i][j] = temp;
                        maxSumsIndex[i][j][0] = maxSumsIndex[i - 1][j][0];
                        maxSumsIndex[i][j][1] = maxSumsIndex[i - 1][j][1];
                    }
                }

                // 左、
                if(j - 1 >= 0 && maxSums[i][j - 1] > 0){
                    // 纳入、
                    temp = maxSums[i][j - 1];
                    for(int k = maxSumsIndex[i][j - 1][0]; k <= i; k++){
                        temp += matrix[k][j];
                    }

                    if(temp > maxSums[i][j]){
                        // 更新值和index、
                        maxSums[i][j] = temp;
                        maxSumsIndex[i][j][0] = maxSumsIndex[i][j - 1][0];
                        maxSumsIndex[i][j][1] = maxSumsIndex[i][j - 1][1];
                    }
                }

                // 还有一种情况、我的思路已经无法处理这种特殊情况了、即、ij不由 i-1 j 和 i j-1决定、

                // ij 点处理完毕、
                if(maxSum < maxSums[i][j]){
                    // 更新全局值、
                    maxSum = maxSums[i][j];
                    result[0] = maxSumsIndex[i][j][0];
                    result[1] = maxSumsIndex[i][j][1];
                    result[2] = i;
                    result[3] = j;
                }
            }
        }

        return result;*/
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}