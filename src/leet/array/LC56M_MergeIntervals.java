package leet.array;

import java.util.ArrayList;
import java.util.List;

class Interval {
  int start;
  int end;
  Interval() { start = 0; end = 0; }
  Interval(int s, int e) { start = s; end = e; }
}
		 
public class LC56M_MergeIntervals {

	public List<Interval> merge(List<Interval> limits) {
    	if (limits.size() <= 1)
        return limits;
    
        // Sort step is IMPORTANT !!!!!!!!!!!!!!
        //limits.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
    	
        boolean isFirst = true;
        List<Interval> partitions = new ArrayList<Interval>();        
        int start = 0, end = 0;
        for(Interval limit: limits){   			 
            if(isFirst) {
                start = limit.start;
                end = limit.end;
                isFirst = false;
                continue;
            } 

            int curStart = limit.start, curEnd = limit.end;

            // New limit merges/overlaps into old
            if(curStart >= start && curStart <= end)
                end = end > curEnd ? end : curEnd;        /// USED 'curEnd =' instead of 'end=' arghhhhhhhhhhhhhh .. 
            else {
                partitions.add(new Interval(start, end));
                start = curStart;
                end = curEnd;
            }
        }
        partitions.add(new Interval(start, end));
        return partitions;        
    }
    
    public static void main(String args[]) {
    	
    }
}