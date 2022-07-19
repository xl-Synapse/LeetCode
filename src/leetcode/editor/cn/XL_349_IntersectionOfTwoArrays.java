//给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4]
//解释：[4,9] 也是可通过的
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length, nums2.length <= 1000 
// 0 <= nums1[i], nums2[i] <= 1000 
// 
// Related Topics 数组 哈希表 双指针 二分查找 排序 👍 575 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class XL_349_IntersectionOfTwoArrays{
    public static void main(String[] args) {
        Solution solution = new XL_349_IntersectionOfTwoArrays().new Solution();
        int[] nums1 = new int[]{1, 2, 2, 1};
        int[] nums2 = new int[]{2, 2};
        System.out.println(solution.intersection(nums1, nums2));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> hashSet1  = new HashSet<>();
        HashSet<Integer> hashSet2  = new HashSet<>();
        for(int i = 0; i < nums1.length; i++)
            hashSet1.add(nums1[i]);

        for(int i = 0; i < nums2.length; i++)
            hashSet2.add(nums2[i]);

        HashSet<Integer> hashSet3 = new HashSet<>();

        for(Iterator<Integer> iterator = hashSet1.iterator(); iterator.hasNext();){
            int temp = iterator.next();
            if(hashSet2.contains(temp)){
                hashSet3.add(temp);
            }
        }

        int[] result = new int[hashSet3.size()];
        int i = 0;
        for(Iterator<Integer> iterator = hashSet3.iterator(); iterator.hasNext(); i++){
            result[i] = iterator.next();
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}