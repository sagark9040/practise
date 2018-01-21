package leet.array;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC239H_MaximumSlidingWindow {

	// DIDN'T THINK ABOUT QUEUE!!! WTH !!!!       < ------------        ARGHHHHHH!!!  (https://www.youtube.com/watch?v=ShbRCjvB_yQ)
	
	
	// Thoughts - 1017
    // I'll use a max heap of size k. For every n, the heap operation to remove oldest value (using array pointer) and add the latest value is log k. Total complexity is O(n log k)
    // 
    
    // TCs
    // Empty nums, k = 0 --> return empty max window.
    // if k = 1 then return nums itself
    
	
	
//    public int[] maxSlidingWindowOLD(int[] nums, int k) {
//        if (nums == null || nums.length == 0 || k == 0)
//            return new int[]{};
//        if(k == 1)
//            return nums;
//        if(k > nums.length)
//            return new int[] {getMax(nums)};    
//        
///* Window position             Max
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
//*/
//            
//        int[] window = new int[k];
//        for (int i=0; i<k; i++)
//            window[i] = nums[i];
//        
//        int[] maxWindow = new int[nums.length];
//        maxWindow[0] = getMax(window);
//        
//        //012345 .. l = 6 .. k = 3 .. l - k -1 = 6 - 3 - 1 = 2 ... 0 to 2
//        //012  
//            
//        for (int i = 1; i+k-1 < nums.length; i++) {
////            heap.remove(nums[i-1]);
////            heap.add(nums[i+k-1]);
////            maxWindow[pos] = getMax(window);
//        }
//		return maxWindow;
//            
//    }
//
//public int getMax(int[] nums) {
//    int max = Integer.MIN_VALUE;
//    for(int n:nums) {
//        if (n > max)
//            max = n;
//    }
//    return max;
//}
    
	public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k < 1)
            return new int[]{};
        
        int[] res = new int[nums.length - k + 1];
        int resPtr = 0;
        Deque<Integer> q = new ArrayDeque<Integer>();
        
        for(int i=0; i<nums.length; i++) {
            // Removing out of window numbers
            while (!q.isEmpty() && i > 0 && q.peek() < i - k + 1)
                q.poll();
            
            while(!q.isEmpty() && nums[q.peekLast()] < nums[i])
                q.pollLast();
            
            q.offer(i);
            if(i >= k-1) {
                res[resPtr] = nums[q.peek()];
                resPtr++;
            }
        }
        return res;
    }
    

    
    public static void main(String args[]) {
    	LC239H_MaximumSlidingWindow maxWindow = new LC239H_MaximumSlidingWindow();
    	maxWindow.maxSlidingWindow(new int[] {}, 10);
    }
}
