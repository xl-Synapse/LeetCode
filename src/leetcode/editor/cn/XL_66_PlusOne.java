//////给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。 
//////
////// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。 
//////
////// 你可以假设除了整数 0 之外，这个整数不会以零开头。 
//////
////// 
//////
////// 示例 1： 
//////
////// 
//////输入：digits = [1,2,3]
//////输出：[1,2,4]
//////解释：输入数组表示数字 123。
////// 
//////
////// 示例 2： 
//////
////// 
//////输入：digits = [4,3,2,1]
//////输出：[4,3,2,2]
//////解释：输入数组表示数字 4321。
////// 
//////
////// 示例 3： 
//////
////// 
//////输入：digits = [0]
//////输出：[1]
////// 
//////
////// 
//////
////// 提示： 
//////
////// 
////// 1 <= digits.length <= 100 
////// 0 <= digits[i] <= 9 
////// 
////// Related Topics 数组 数学 👍 1038 👎 0
////
//


package leetcode.editor.cn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class XL_66_PlusOne{
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static String integerArrayToString(int[] nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for(int index = 0; index < length; index++) {
            int number = nums[index];
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayToString(int[] nums) {
        return integerArrayToString(nums, nums.length);
    }

    public static void main(String[] args) throws IOException {
        String line = "[9, 9, 9]";
        int[] digits = stringToIntegerArray(line);
        int[] ret = new XL_66_PlusOne().new Solution().plusOne(digits);
        String out = integerArrayToString(ret);
        System.out.print(out);

    }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] plusOne(int[] digits) {
        if(digits[0] == 0){
            digits[0] = 1;
            return digits;
        }
        digits[digits.length - 1] += 1;

        int i = digits.length - 1;
        for(; i > 0; i--){
            if (digits[i] <= 9)
                return digits;
            else {
                digits[i] = digits[i] % 10;
                digits[i - 1] += 1;
            }
        }

        if(digits[i] <= 9)
            return digits;

        int[] result = new int[digits.length + 1];
        result[0] = 1;
        result[1] = digits[i] % 10;
        i += 2;
        for(; i < digits.length + 1; i++)
            result[i] = digits[i - 1];
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}