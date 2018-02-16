package leet.array;

import java.util.ArrayList;
import java.util.List;

public class LC448E_FindAllNumbersDisapperaredInArray {
    
    /**
     * 

-4, -3, -2, -7, 8, 2, -3, -1

1, 2, 3, 4, 5, 6, 7, 8

Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

Example:

Input:
[4,3,2,7,8,2,3,1]

[3, -1, -2, 2, 3]
[]

Output:
[5,6]*/

public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums == null || nums.length == 0) {
            new ArrayList<Integer>();
        }

        for(int i=0; i<nums.length; i++) {
            int curNum = Math.abs(nums[i]);
            if(nums[curNum-1] > 0) {
                nums[curNum-1] = -nums[curNum-1];
            }
        }

        List<Integer> list = new ArrayList<Integer>();        
        for(int i=0; i<nums.length; i++) {
            if(nums[i] > 0) {
                list.add(i+1);
            }
        }
        return list;
    }
}
