package nowcoder.com;

import java.lang.Integer;
import java.util.*;


/*运行时间：105ms
        超过39.15% 用Java提交的代码
占用内存：12956KB
        超过45.31%用Java提交的代码

        1.先用hash存储附件关系、
        2.动态规划扫描、遇到附件直接跳过、遇到主件几种情况同时考虑、主、主1、主2、主12、即各种附件情况、然后普通动态规划即可、
*/
public class XL_HJ16 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String[] line1 = sc.nextLine().split(" ");
        int coin = Integer.parseInt(line1[0]);
        int num = Integer.parseInt(line1[1]);

        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
        int[][] buy = new int[num][3];

        int index = 0;
        while(sc.hasNextLine()){
            String[] line = sc.nextLine().split(" "); // 1 2 3
            if(Integer.parseInt(line[0]) == -1)
                break;

            int price = Integer.parseInt(line[0]);
            int point = Integer.parseInt(line[1]);
            int father = Integer.parseInt(line[2]) - 1;

            buy[index][0] = price;
            buy[index][1] = point;
            buy[index][2] = father;

            if(father != -1){
                // 利用 hashmap 将附件关系提前存储、
                if(hashMap.containsKey(father)){
                    hashMap.get(father).add(index);
                }
                else {
                    List<Integer> list = new ArrayList<>();
                    list.add(index);
                    hashMap.put(father, list);
                }
            }
            index++;
        }

//        int[][][] dp = new int[index][2][3]; // 项数、、、、、买与不买、\\\\\\\\\钱、数量、满意度、
        int[] dp = new int[coin + 1]; // 买到coin钱数时、最大的满意度、
        int maxPoint = 0;

        for(int i = 0; i < num; i++){

            // 判断是否为附件、附件不处理、
            if(buy[i][2] != -1){
                continue;
            }

            List<Integer> integerList = hashMap.getOrDefault(i, null);
//            if(integerList != null) {
//                integerList.sort((o1, o2) -> o1 - o2);
//            }

            // 主件、
            // 两种选择、买与不买、

            // 不买、附件也不需要处理、

            // 买、附件也需要处理、
            for(int j = coin; j >= buy[i][0]; j--){ // 最少要能买一件才需要更新、

                // 处理附件、
                int temp = dp[j - buy[i][0]] + buy[i][0] * buy[i][1];

                int temp1 = 0, temp2 = 0, temp12 = 0, index1 = 0, index2 = 0;

                if(integerList == null){
                    dp[j] = Math.max(dp[j], temp);
                    maxPoint = Math.max(dp[j], maxPoint);
                    continue;
                }

                switch (integerList.size()){
                    case 2:
                        index2 = integerList.get(1);
                        temp2 = (j - buy[i][0] - buy[index2][0] >= 0) ? dp[j - buy[i][0] - buy[index2][0]] + buy[i][0] * buy[i][1] + buy[index2][0] * buy[index2][1] : 0;
                        index1 = integerList.get(0);
                        temp1 = (j - buy[i][0] - buy[index1][0] >= 0) ? dp[j - buy[i][0] - buy[index1][0]] + buy[i][0] * buy[i][1] + buy[index1][0] * buy[index1][1] : 0;

                        temp12 = (j - buy[i][0] - buy[index1][0] - buy[index2][0] >= 0) ? dp[j - buy[i][0] - buy[index1][0] - buy[index2][0]] + buy[i][0] * buy[i][1] + buy[index1][0] * buy[index1][1] + buy[index2][0] * buy[index2][1] : 0;
                        break;
                    case 1:
                        index1 = integerList.get(0);
                        temp1 = (j - buy[i][0] - buy[index1][0] >= 0) ? dp[j - buy[i][0] - buy[index1][0]] + buy[i][0] * buy[i][1] + buy[index1][0] * buy[index1][1] : 0;
                        break;
                }

                dp[j] = Math.max(dp[j], temp);
                dp[j] = Math.max(dp[j], temp1);
                dp[j] = Math.max(dp[j], temp2);
                dp[j] = Math.max(dp[j], temp12);
                maxPoint = Math.max(dp[j], maxPoint);
            }
        }

        System.out.println(maxPoint);

    }
}