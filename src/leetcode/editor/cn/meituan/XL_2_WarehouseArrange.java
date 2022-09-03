package leetcode.editor.cn.meituan;

import java.util.Scanner;

/*
        执行用时:516 ms ,在所有Java提交中击败了38.46%的用户
        内存消耗: 65.8 MB ，在所有Java提交中击败了46.92%的用户

        类动态规划做法、
*/

public class XL_2_WarehouseArrange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        int[] wares = new int[num];
        int[] weights = new int[num];


        for(int i = 0; i < num; i++) {
            wares[i] = sc.nextInt();
            weights[i] = wares[i] + ((i == 0) ? 0 : weights[i - 1]);
        }
        sc.nextLine();

        /*
        * 维持一个类似动态规划的dp数组、
        * 每次拿走一个货物、就把该货物对应的格子置为0、且把该货物往后的格子全部减去该格子的值、即断开连续、（该操作只进行到下一个已经被拿走的格子）
        * */

        int maxIndex = num - 1;
        int maxWeight = weights[num - 1];

        for(int i = 0; i < num; i++) {
            int now = sc.nextInt() - 1; // 输入从1开始、我需要的是从0开始的索引、
            // 取走货物、从当前格子到下一个被断开的格子全部减去该格子的值、

            int j = now + 1;
            for(; j < num && weights[j] != 0; j++){
                weights[j] -= weights[now];
            }

            weights[now] = 0;

            if(maxIndex == j - 1) { // j 跳出循环要么 +1 跳出、要么遇到断开跳出、两种情况都是前一个格子可能为前最大值、

                // 上一轮的最大值受到了断开的影响、需要重新求最大值、且此时maxindex后一个一定是断开的、即weights已经更新完毕、
                maxWeight = 0;
                for (int cnt = 0; cnt < num; cnt++) {
                    if (weights[cnt] > maxWeight) {
                        maxIndex = cnt;
                        maxWeight = weights[cnt];
                    }
                }
            }

            System.out.println(maxWeight);
        }
    }

}
