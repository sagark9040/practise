package in.cc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DuplicatesInArray {

	//Two Hash Sets
	static void showDuplicates(int[] arr){
		Set<Integer> elements = new HashSet<Integer>();
		Set<Integer> displayed = new HashSet<Integer>();
		
		for(int i:arr){
			if(elements.contains(i)){
				if(!(displayed.contains(i))){
					System.out.println(i);
					displayed.add(i);
				}
			}
			else
				elements.add(i);
		}
	}
	
	//Hash Map - Space O(n)x2 Time O(n) x2
	static void showDuplicatesUsingHashSet(int[] arr){
		Map<Integer, Integer> hMap = new HashMap<Integer, Integer>();
		for(int i:arr){
			if(hMap.containsKey(i)){
				hMap.put(i, hMap.get(i)+1);
			}
			else{
				hMap.put(i,  1);
			}
		}
		
		for(int i:hMap.keySet()){
			if(hMap.get(i)>1)
				System.out.println(i);
		}
			
	}
	
	public static void main(String args[]){
		int arr[]={1,2,3,1,4,5,2,3,3,3,3};
		showDuplicates(arr);
		System.out.println("--");
		showDuplicatesUsingHashSet(arr);
	}
	
}
