//输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。 
//
// 
//
// 示例 1: 
//
// 输入: [10,2]
//输出: "102" 
//
// 示例 2: 
//
// 输入: [3,30,34,5,9]
//输出: "3033459" 
//
// 
//
// 提示: 
//
// 
// 0 < nums.length <= 100 
// 
//
// 说明: 
//
// 
// 输出结果可能非常大，所以你需要返回一个字符串而不是整数 
// 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0 
// 
// Related Topics 贪心 字符串 排序 👍 504 👎 0


package leetcode.editor.cn;
public class XL_2452_BaShuZuPaiChengZuiXiaoDeShuLcof{
    public static void main(String[] args) {
        Solution solution = new XL_2452_BaShuZuPaiChengZuiXiaoDeShuLcof().new Solution();
        System.out.println(solution.minNumber(new int[]{3,30,34,67,88,0,67,45,5,9}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);

        String temp;
        for(int i = 0; i < nums.length; i++){ // 次数、
            for(int j = 1; j < nums.length - i; j++){
                if(compare(strs[j - 1], strs[j])){
                    temp = strs[j - 1];
                    strs[j - 1] = strs[j];
                    strs[j] = temp;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < nums.length; i++){
            sb.append(strs[i]);
        }
        return sb.toString();
    }

    private boolean compare(String num1, String num2){
        return (num1 + num2).compareTo(num2 + num1) > 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}