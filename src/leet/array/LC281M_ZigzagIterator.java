package leet.array;

import java.util.ArrayList;
import java.util.List;

public class LC281M_ZigzagIterator {
	
	//1040 pm to 1058 pm..looks straightforward, if I use an outer while.	
	
	List<Integer> list1, list2;    
    int nextVal;
    int pos1 = 0, pos2 = 0, cur = 0;
    public LC281M_ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        list1 = new ArrayList<Integer>(v1);
        list2 = new ArrayList<Integer>(v2);
    }

    public int next() {        
        if(cur == 0 && pos1 < list1.size()) {
            cur = 1;
            return list1.get(pos1++);
        } else if(cur == 0 && pos2 < list2.size()) {
            return list2.get(pos2++);
        } else if(cur == 1 && pos2 < list2.size()) {
            cur = 0;
            return list2.get(pos2++);
        } else {
            return list1.get(pos1++);
        }
    }

    public boolean hasNext() {
        return pos1 < list1.size() || pos2 < list2.size();
    }
}
