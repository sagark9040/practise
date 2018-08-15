package leet.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC187M_RepeatedDNASequences {
	 //910
    //window of len = 1
    //AAAAAAAAAAAAAAAAAAAAA
    
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        if(s == null || s.length() < 10) return result;
        
        for(int i=0; i<=s.length()-10; i++) {
            String seq = s.substring(i, i+10);
            int count = 1;
            if(map.containsKey(seq)) {
                count += map.get(seq);
            }
            map.put(seq, count);
        }
        
        for(String seq:map.keySet()) {
            if(map.get(seq) > 1)
                result.add(seq);
        }
        return result;
    }
}
