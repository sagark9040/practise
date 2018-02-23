package leet.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LC253M_MeetingRooms2 {
	public int minMeetingRooms(Interval[] intervals) {
		
		if(intervals.length<2) {
			return intervals.length;
		}	
        
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval o1, Interval o2) {
                // Intentional: Reverse order for this demo
                if(o1.start == o2.start) {
                	return o1.end - o2.end;
                }
                return o1.start - o2.start;
            }
        });

		List<Interval> rooms = new ArrayList<Interval>();
		rooms.add(intervals[0]);

		for(int i=1; i<intervals.length; i++) {
			Interval intvl = intervals[i];
			int[] curInterval = new int[]{intvl.start, intvl.end};
			
			boolean foundRoom = false;

			for(int j=0; j<rooms.size(); j++) {
				int[] lastMeeting = new int[]{rooms.get(j).start, rooms.get(j).end};
				//either overlap or not
				//overlap
				if(lastMeeting[1] > curInterval[0]) {
				
				} else {
					//no overlap
					rooms.set(j, intvl);
					foundRoom = true;
					break;
				}
			}		
			
			if(!foundRoom) {
				rooms.add(intvl);
			}
		}
		return rooms.size();        
	}
	
	public class Interval {
       int start;
	   int end;
	   Interval() { start = 0; end = 0; }
	   Interval(int s, int e) { start = s; end = e; }
	}
	
	public static void main(String args[]) {
			
	}
}
