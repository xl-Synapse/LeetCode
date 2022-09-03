package leetcode.editor.cn.meituan;

import java.util.Scanner;


/*
        执行用时： 132 ms, 在所有 Java 提交中击败了 70.03% 的用户
        内存消耗： 30.7 MB, 在所有 Java 提交中击败了 12.20% 的用户

        最基础写法、还能够优化、有很多不必要代码和分支、但是如果追求用例得分、这样就行了、
*/

public class XL_1_MName {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        while(num-- > 0){
            String name = sc.nextLine();
            if((name.charAt(0) >= 'a' && name.charAt(0) <= 'z') || (name.charAt(0) >= 'A' && name.charAt(0) <= 'Z')){
                // 满足第一个条件、
                int letter = 1;
                int digit = 0;
                boolean flag = true;
                for(int i = 1; i < name.length(); i++){
                    char temp = name.charAt(i);
                    if((temp >= 'a' && temp <= 'z') || (temp >= 'A' && temp <= 'Z')){
                        letter++;
                    }
                    else if(temp >= '0' && temp <= '9'){
                        digit++;
                    }
                    else {
                        System.out.println("Wrong");
                        flag = false;
                        break;
                    }
                }

                if(!flag)
                    continue;

                if(digit == 0){
                    System.out.println("Wrong");
                }
                else {
                    System.out.println("Accept");
                }
            }
            else {
                System.out.println("Wrong");
            }
        }
    }
}
