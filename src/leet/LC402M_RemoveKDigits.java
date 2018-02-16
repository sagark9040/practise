package leet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC402M_RemoveKDigits {
	
	
    //918pm
	
	//Took 30 mins to get the suboptimal soln .. may not have gotten the optimal soln in 45 mins of interview 
    
    //1439
    
    //if k = 1: (set) 439, 139, 149, 143
    //if k = 2: (set) iterate above set and remove one more digit: 39, 49, 43, 19, 13, 14
    //I'll need a remove digit method where input is a string, and returned value is a 
    
    //TCs 
    //k > len
    //k=0
    //k=1
    //nums with duplicate digits
    //nums with too many zeroes
    //nums with all same digits
    //
	
	
	 public String removeKdigitsOptimal(String num, int k) {        
			int len = num.length();
	        if (num.length() == k) {
	            return "0";
	        }
	        
			//holds new min number eventually
			char[] arr = new char[len];
			int top = 0; // top element of the 'stack'
			
			//iterate our entire number O(n)
			for(int i=0; i<len; i++) {
				char cur = num.charAt(i);
				while(top > 0 && k > 0 && arr[top-1] > cur) {
					top -= 1;
					k--;  
				}
				arr[top++] = cur;
				
			}
			int index = 0;
			int digits = len - k;
			while(index < digits && arr[index] == '0') {
				index++;
			}
			
			return index == digits ? "0" : new String(arr, index, digits-index);
	        
	    }
	
	public String removeKdigits(String num, int k) {
		if(k == 0) {
			return num;
		} else if (k >= num.length()) {
			return "0";
		}
        
        Set<String> allNums = new HashSet<String>();
        allNums.add(num);        
        
        for(int i=1; i<=k; i++) {
            Set<String> newAllNums = new HashSet<String>();
                
            if(!allNums.isEmpty()) {
                for(String curNum:allNums) {
                    newAllNums.addAll(removeDigit(curNum));
                }
                
            }
            
            allNums = newAllNums;
        }
        
        return getMax(allNums);
    }
    
    public String getMax(Set<String> allNums) {
        int max = Integer.MAX_VALUE;
        for(String curNum:allNums) {
            max = Math.min(max, Integer.parseInt(curNum));
        }
        return String.valueOf(max);
    }
    
    public List<String> removeDigit(String num) {
        if(num == null || num.length() < 2) {
            return new ArrayList<String>();
        } else {
            List<String> list = new ArrayList<String>();
            
            for(int i=0; i<num.length(); i++) {
                StringBuilder sb = new StringBuilder();
                sb.append(num.substring(0, i));
                sb.append(num.substring(i+1, num.length()));                   ///             NPE potential
                list.add(sb.toString());
            }
            
            return list;
        }
    }
    
    public static void main (String args[]) {
    	LC402M_RemoveKDigits r = new LC402M_RemoveKDigits();
    	System.out.println(r.removeKdigitsOptimal("1111", 2));
    	
    }
}
