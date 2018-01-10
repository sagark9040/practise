package leet.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LC616M_AddBoldTag_MergeArraySolution {
	
    public static void main(String args[]) {
    	String s = "aaabbcc";
    	s = "qrzjsorbkmyzzzvoqxefvxkcwtpkhzbakuufbpgdkykmojwuennrjeciqvvacpzrrczfhxnsmginzwinzihpomxtmweyyzzmgcoiupjnidphvzlnxtcogufozlenjfvokztghwckzyvmktduqkizixzxpanjwrdeudjyftxksjgdklwxrhmudhrtemuvelykqaafzlqmennttkighcdxfozdcoqkyshhajipnsdrljrnlwmyjuwxsebpqm";
		String[] dict = {"qr","zj","so","rb","km","yz","zz","vo","qx","ef","vx","kc","wt","pk"}; 
				
				//dict = {"aaa","aab","bc"};
		LC616M_AddBoldTag_MergeArraySolution merge = new LC616M_AddBoldTag_MergeArraySolution();
		System.out.println(merge.addBoldTag(s, dict));				
    }
    
    public String addBoldTag(String s, String[] dict) {
        
        // Merging intervals        
        List<Interval> intervals = mergeArray(s, dict);
        
        // Add the bold tag   
        StringBuffer sb = new StringBuffer();
        int start = 0;
        for (Interval intvl: intervals) {
        	System.out.print(intvl.start + " " + intvl.end + " .. ");
        	sb.append(s.substring(start, intvl.start));
        	sb.append("<b>");
        	sb.append(s.substring(intvl.start, intvl.end));
        	sb.append("</b>");
        	start = intvl.end;
        }
        
        if (start < s.length()) {
        	sb.append(s.substring(start));
        }
        
        System.out.println();
		return sb.length() > s.length() ? sb.toString(): s;
    }
    
	private List<Interval> mergeArray(String s, String[] dict) {
		List<Interval> intervals = new ArrayList<Interval>();		        
		    
		for (String word: dict) {
			int start = -1, end = -1;			
			
			start = s.indexOf(word);
			
			while (start != -1) { 
				end = start + word.length();
				
				intervals.add(new Interval(start, end));
				
				start += 1;
				start = s.indexOf(word, start);
			}							
		}
		
		return mergeIntervals(intervals);		
	}   
	
	public List<Interval> mergeIntervals (List<Interval> intervals) {
		
		if(intervals == null || intervals.size() <= 1)
			return intervals;
		
		Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
		
		int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        List<Interval> res = new ArrayList<>();
        
        for(Interval intvl: intervals) {
        	
        	if(intvl.start <= end) {
        		end = Math.max(end, intvl.end);
        	} else {
        		res.add(new Interval(start, end));
        		start = intvl.start;
        		end = intvl.end;        		
        	}
        }
        
        res.add(new Interval(start, end));
        
    	return res;
	}


class Interval {
    public Interval(int start2, int end2) {
    	start = start2;
    	end = end2;
	}

	int start, end;
}
}
/*
    
    public String addBoldTag(String s, String[] dict) {
    List<Interval> intervals = new ArrayList<>();
    for (String str : dict) {
    	int index = -1;
    	index = s.indexOf(str, index);
    	while (index != -1) {
    		intervals.add(new Interval(index, index + str.length()));
    		index +=1;
    		index = s.indexOf(str, index);
    	}
    }
    System.out.println(Arrays.toString(intervals.toArray()));
    intervals = merge(intervals);
    System.out.println(Arrays.toString(intervals.toArray()));
    int prev = 0;
    StringBuilder sb = new StringBuilder();
    for (Interval interval : intervals) {
    	sb.append(s.substring(prev, interval.start));
    	sb.append("<b>");
    	sb.append(s.substring(interval.start, interval.end));
    	sb.append("</b>");
    	prev = interval.end;
    }
    if (prev < s.length()) {
    	sb.append(s.substring(prev));
    }
    return sb.toString();
}

class Interval {
	int start, end;
	public Interval(int s, int e) {
		start = s;
		end = e;
	}
	
	public String toString() {
		return "[" + start + ", " + end + "]" ;
	}
}

public List<Interval> merge(List<Interval> intervals) {
    if (intervals == null || intervals.size() <= 1) {
        return intervals;
    }
    Collections.sort(intervals, new Comparator<Interval>(){
        public int compare(Interval a, Interval b) {
            return a.start - b.start;
        }
    });
    
    int start = intervals.get(0).start;
    int end = intervals.get(0).end;
    List<Interval> res = new ArrayList<>();
    for (Interval i : intervals) {
        if (i.start <= end) {
            end = Math.max(end, i.end);
        } else {
            res.add(new Interval(start, end));
            start = i.start;
            end = i.end;
        }
    }
    res.add(new Interval(start, end));
    return res;
}
}*/