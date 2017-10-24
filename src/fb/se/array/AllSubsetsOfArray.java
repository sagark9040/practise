package fb.se.array;

import java.util.ArrayList;
import java.util.List;

public class AllSubsetsOfArray {
	
	public List<List<Integer>> subsets(int[] nums) {
		
		int n = nums.length;
		 
		List<List<Integer>> allLists = new ArrayList<List<Integer>>();
		System.out.println(1<<n);
        for (int i = 0; i < (1<<n); i++)
        { 
        	System.out.println("Cur i:" + i + " -------------- " + Integer.toBinaryString(i));
        	List<Integer> list = new ArrayList<Integer>();
            for (int j = 0; j < n; j++){
 
            	System.out.println(i + " & " + (1 << j)  + " --> "+(i & (1 << j)));
                if ((i & (1 << j)) > 0)
                	list.add(nums[j]);
            }

            
            
            System.out.print("---------------------------------------- [ ");
            for(int l: list)
            	System.out.print(l + " ");
            System.out.println("] \n\n");
            allLists.add(list);
        }
		return allLists;
	}
	public static void main(String args[]){
		AllSubsetsOfArray all = new AllSubsetsOfArray();
		int[] arr = {1,2,3, 4};
		all.subsets(arr);				
	}
}
