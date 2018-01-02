package fb.se.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllSequencesArray {
    int stopper = 0;
	List<List<Integer>> allLists = new ArrayList<List<Integer>>();
	
	
    public List<List<Integer>> subsets(int[] nums) {
    	allLists.add(new ArrayList<Integer>());
    	
        stopper = nums.length;
        Integer[] curList = new Integer[nums.length];
        subsets(nums, 0, curList);
		return allLists;
    }
    
    public void subsets(int[] nums, int pos, Integer[] curList){
        if(pos == stopper){
        	addCurListToAllLists(curList);
            return;
        }
        
        for(int i=0; i<nums.length; i++){
            curList[pos] = nums[i];
            int[] left = Arrays.copyOfRange(nums, 0, i);
            int[] right = Arrays.copyOfRange(nums, i+1, nums.length);
            
            subsets(mergeArrays(left, right), pos+1, curList);

        }        
    }
    
	private void addCurListToAllLists(Integer[] curList) {
		List<Integer> list = new ArrayList<Integer>();
		for(Integer i:curList){
			list.add(i);
			System.out.print(i);
		}
		System.out.println();
		allLists.add(list);
	}

	private int[] mergeArrays(int[] array1, int[] array2) {
		int[] array1and2 = new int[array1.length + array2.length];
		System.arraycopy(array1, 0, array1and2, 0, array1.length);
		System.arraycopy(array2, 0, array1and2, array1.length, array2.length);
		return array1and2;
	}

	public static void main(String args[]){
		AllSequencesArray all = new AllSequencesArray();
		int[] arr = {1,2,3};
		all.subsets(arr);
	}
}
