package leet.bit;

import java.util.ArrayList;
import java.util.List;

public class LC409M_BinaryWatch {

	//1020p
	//8 4 2 1
	//32 16 8 4 2 1
	//Thinking of 
	//TCs more LEDs than permissible time -> n:10
	//DFS:
	//Take one each put it in VALID spots in first minute and then hour, do DFS from there and print only when the slot count is full

	//[][] <-- fill n
	//Binary:
	//m:n-m
	
	// Simple binary solution!!! I almost thought of this
	public List<String> readBinaryWatchBINARYSOLUTION(int num) {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                if (Integer.bitCount(i) + Integer.bitCount(j) == num) {
                    
                    String mins = (j == 0) ? "00" : String.valueOf(j);                
                    if(j < 10) {
                        mins = "0";
                        mins += String.valueOf(j);
                    }
                    
                    String curRes = String.valueOf(i) + ":" + mins;
                    result.add(curRes);
                }
            }
        }
        return result;
    }
	
	// I was very close to this!!!...execution issue
	public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        int[] nums1 = new int[]{8, 4, 2, 1}, nums2 = new int[]{32, 16, 8, 4, 2, 1};
        for(int i = 0; i <= num; i++) {
            List<Integer> list1 = generateDigit(nums1, i);
            List<Integer> list2 = generateDigit(nums2, num - i);
            for(int num1: list1) {
                if(num1 >= 12) continue;
                for(int num2: list2) {
                    if(num2 >= 60) continue;
                    res.add(num1 + ":" + (num2 < 10 ? "0" + num2 : num2));
                }
            }
        }
        return res;
    }

    private List<Integer> generateDigit(int[] nums, int count) {
        List<Integer> res = new ArrayList<>();
        generateDigitHelper(nums, count, 0, 0, res);
        return res;
    }

    private void generateDigitHelper(int[] nums, int count, int pos, int sum, List<Integer> res) {
        if(count == 0) {
            res.add(sum);
            return;
        }
        
        for(int i = pos; i < nums.length; i++) {
            generateDigitHelper(nums, count - 1, i + 1, sum + nums[i], res);    
        }
    }
    
    public static void main(String args[]) {
    	LC409M_BinaryWatch w = new LC409M_BinaryWatch();
    	for(String s : w.readBinaryWatch(3)) {
    		System.out.println(s);
    	}
    }
}
