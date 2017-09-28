package in.cc;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	
	static Map<Integer, Integer> myStore=new HashMap<Integer, Integer>();

	//Store the data element
	public static void store(int num){
		if(myStore.containsKey(num)){
			myStore.put(num, myStore.get(num)+1);
		}
		else
			myStore.put(num, 1);
	}
	
	//Test the input for two sum presence
	public static boolean twoSum(int num){
		for(int i:myStore.keySet()){
			myStore.put(i, myStore.get(i)-1);
			
			if(myStore.get(i)!=null && myStore.get(num-i)>0)
				return true;
		}
		
		return false;
	}
	
	//
	public static void main(String args[]){
		store(2);
		store(3);
		store(3);
		store(6);
		store(5);
		store(5);
		
		System.out.println(twoSum(12));
	}
	
}
