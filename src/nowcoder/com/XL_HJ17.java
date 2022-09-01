package nowcoder.com;

import java.util.HashMap;
import java.util.Scanner;

public class XL_HJ17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(";");
        int x = 0;
        int y = 0;
        for(String str : input){
            if(str.matches("[WASD][0-9]{1,2}")){
                int val = Integer.valueOf(str.substring(1));
                switch (str.charAt(0)){
                    case 'A':
                        x -= val;
                        break;
                    case 'S':
                        y -= val;
                        break;
                    case 'D':
                        x += val;
                        break;
                    case 'W':
                        y += val;
                        break;
                }
            }
        }
        System.out.println(x + "," + y);
    }

    private static void todo(char way, int num){

    }
}
