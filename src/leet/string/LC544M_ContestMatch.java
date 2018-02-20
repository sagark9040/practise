package leet.string;

import java.util.ArrayList;
import java.util.List;

public class LC544M_ContestMatch {
//	423p --> 445p .. 22 mins AC including one off by one error fixed
//	Input: 8
//	Output: (((1,8),(4,5)),((2,7),(3,6)))
//
//	18 45
//	27 36
//
//	Input: 16
//	((1 16) (8 9))
//	((2 15) (7 10))
//	((3 14) (6 11))
//	((4 13) (5 12))
//
//	for(1 to N/2 .. N/2 +1 to N)
//	1,16
//	2,15
//	3,14
//	4,13
//	5,12
//	6,11
//	7,10
//	8,9
//
//	ListOfStrings
//
//	while(N > 0) { n>0 is wrong ..shoudl be n>1
//		newArray = prev
//		prev = []
//		for(1 to N/2 .. N/2 +1 to N) {
//			(i
//			N-i)
//			newArray.add();
//		}
//		prev = newArray	
//
//	return newArray
	
	
	public String findContestMatch(int n) {
        List<String> newList = initList(n);
 
        while(n > 1) {								//					n > 0 would have been an off-by-one-error
            List<String> prevList = newList;
            newList = new ArrayList<String>();
            
            for(int i=0; i<prevList.size()/2; i++) {
                newList.add("(" + prevList.get(i) + "," + prevList.get(prevList.size()-i-1) + ")");
            }
            n = n/2;
        }
        
        return newList.size() > 0 ? newList.get(0) : "";
    }
    
    public List<String> initList(int n) {
        List<String> list = new ArrayList<String>();
        for(int i=1; i<=n; i++) {
            list.add(String.valueOf(i));
        }
        return list;
    }
    
    public static void main(String args[]) {
    	
    	LC544M_ContestMatch cm = new LC544M_ContestMatch();
    	int n = 16;
    	System.out.println(cm.findContestMatch(n));
    }
}
