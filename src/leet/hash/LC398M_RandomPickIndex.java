package leet.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class LC398M_RandomPickIndex {
	//1037 - 1044 7 min AC no issues
    //range for nums?
    //all nums are present?
    //HashMap to store the num, list<int> indices. and choose a random number and do a indices.get(r)
    
    HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>(); 

    public LC398M_RandomPickIndex(int[] nums) {
        int pos = 0;
        for(int n:nums) {
            List<Integer> indices = new ArrayList<Integer>();
            indices.add(pos);
            if(map.containsKey(n)) {
                indices.addAll(map.get(n));
            }
            map.put(n, indices);                
            pos++;
        }
    }
    
    public int pick(int target) {
        List<Integer> indices = map.get(target);
        Random r = new Random();
        return indices.get(r.nextInt(indices.size()));
    }
}
