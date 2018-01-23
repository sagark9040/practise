package leet.array;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LC763M_PartitionLabels {
	//1033p
    //Sort the thing n log n - whatever overlaps with original stays in the partition
    //Get the start and end of characters: a[0,12]b[1,8]c[5,9]d[10,14],e[11,15]f[13]g[16] <-- merge partitions
    
    
    public List<Integer> partitionLabels(String s) {
        if(s == null || s.length() == 0)
            return new ArrayList<Integer>();
        
        Map<Character, int[]> limits = new LinkedHashMap<Character, int[]>();
        int pos = 0;
        for(char c: s.toCharArray()) {
            
            //First time char is added
            if(!limits.containsKey(c))
                limits.put(c, new int[]{pos, pos});               			// Map is put 
            else {
            // limits already has the char, so append its end position
                int startPos = limits.get(c)[0];
                limits.put(c, new int[]{startPos, pos});
            }
            pos++;
        }
        
        //we have start and end pos of all chars, time to merge their limits and its result is the partition list
        return mergePartitions(limits);
    }
    
    public List<Integer> mergePartitions(Map<Character, int[]> limits) {
        boolean isFirst = true;
        List<Integer> partitions = new ArrayList<Integer>();        
        int start = 0, end = 0;
        for(int[] limit: limits.values()){   			/// .values() ... not getValues 
            if(isFirst) {
                start = limit[0];
                end = limit[1];
                isFirst = false;
                continue;
            } 
            
            int curStart = limit[0], curEnd = limit[1];
            
            // New limit merges/overlaps into old
            if(curStart > start && curStart < end)
                end = end > curEnd ? end : curEnd;        /// USED 'curEnd =' instead of 'end=' arghhhhhhhhhhhhhh .. took 30 mins to debug!!!         
            else {
                partitions.add(end-start+1);
                start = curStart;
                end = curEnd;
            }
        }
        partitions.add(end-start+1);
        return partitions;        
    }
    
    public static void main(String args[]) {
    	LC763M_PartitionLabels p = new LC763M_PartitionLabels();
    	System.out.println("ababcbacadefegdehijhklij");
    	System.out.println("012345678901234567890123");
    	p.partitionLabels("ababcbacadefegdehijhklij");
    }
}
