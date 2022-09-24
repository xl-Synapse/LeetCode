//你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9
//' 。每个拨轮可以自由旋转：例如把 '9' 变为 '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。 
//
// 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。 
//
// 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。 
//
// 字符串 target 代表可以解锁的数字，你需要给出解锁需要的最小旋转次数，如果无论如何不能解锁，返回 -1 。 
//
// 
//
// 示例 1: 
//
// 
//输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
//输出：6
//解释：
//可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
//注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
//因为当拨动到 "0102" 时这个锁就会被锁定。
// 
//
// 示例 2: 
//
// 
//输入: deadends = ["8888"], target = "0009"
//输出：1
//解释：把最后一位反向旋转一次即可 "0000" -> "0009"。
// 
//
// 示例 3: 
//
// 
//输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], 
//target = "8888"
//输出：-1
//解释：无法旋转到目标数字且不被锁定。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= deadends.length <= 500 
// deadends[i].length == 4 
// target.length == 4 
// target 不在 deadends 之中 
// target 和 deadends[i] 仅由若干位数字组成 
// 
// Related Topics 广度优先搜索 数组 哈希表 字符串 👍 543 👎 0


package leetcode.editor.cn;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;


/*解答成功:
        执行耗时:69 ms,击败了72.41% 的Java用户
        内存消耗:47.6 MB,击败了24.11% 的Java用户

        BFS、层序遍历、广度优先遍历、提前锁定dead状态、
*/
public class XL_752_OpenTheLock{
    public static void main(String[] args) {
        Solution solution = new XL_752_OpenTheLock().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 将 s[j] 向上拨动一次
    private String plusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '9')
            ch[j] = '0';
        else
            ch[j] += 1;
        return new String(ch);
    }
    // 将 s[i] 向下拨动一次
    private String minusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '0')
            ch[j] = '9';
        else
            ch[j] -= 1;
        return new String(ch);
    }

    public int openLock(String[] deadends, String target) {


        Queue<String> queue = new LinkedList<>();
        HashSet<String> hashSet = new HashSet<>();
        for(String dead : deadends)
            hashSet.add(dead);

        if(hashSet.contains("0000"))
            return -1;

        queue.add("0000");
        hashSet.add("0000");

        int row = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                String cur = queue.poll();

                // 判断终点、
//                if(hashSet.contains(cur))
//                    continue;

                if(cur.equals(target))
                    return row;

                for(int i = 0; i < 4; i++){
                    String up = plusOne(cur, i);
                    if(!hashSet.contains(up)){
                        queue.add(up);
                        hashSet.add(up);
                    }

                    String down = minusOne(cur, i);
                    if(!hashSet.contains(down)){
                        queue.add(down);
                        hashSet.add(down);
                    }
                }
            }

            // 下一层、
            row++;
        }
        return -1;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}