package leetcode.editor.cn;

import java.util.PriorityQueue;

public class XL_HeapTest {
    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(9);
        minHeap.add(6);
        minHeap.add(3);
        minHeap.add(8);
/*        System.out.println(minHeap.toString());

        System.out.println(minHeap.peek());
        minHeap.poll();

        System.out.println(minHeap.toString());
        System.out.println(minHeap.size());

        System.out.println(minHeap.isEmpty());*/

        f(4);

    }

    private static int f(int i){
        i = i >> 4;
        int temp = (1 << 4) - 1;
        i = i & temp;
        System.out.println(i);
        return i;
    }
}
