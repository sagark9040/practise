package leet.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC358H_RearrangeStringkDistanceApart {
	//1100p
    //Count of nothing should NOT be more than 1/k
    //Brute Force answer n! and print whatever is the first answer
    
    //CountArray[256]
    //a-4 bcdefghiklmnopqrstuvwxy z-4
	
	
	public String rearrangeString(String str, int k) {
        int length = str.length();
        int[] count = new int[26];
        int[] valid = new int[26];
        for(int i=0;i<length;i++){
            count[str.charAt(i)-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int index = 0;index<length;index++){
            int candidatePos = findValidMax(count, valid, index);
            if( candidatePos == -1) return "";
            count[candidatePos]--;
            valid[candidatePos] = index+k;
            sb.append((char)('a'+candidatePos));
        }
        return sb.toString();
    }
    
   private int findValidMax(int[] count, int[] valid, int index){
       int max = Integer.MIN_VALUE;
       int candidatePos = -1;
       for(int i=0;i<count.length;i++){
           if(count[i]>0 && count[i]>max && index>=valid[i]){
               max = count[i];
               candidatePos = i;
           }
       }
       return candidatePos;
   }
    
    int maxCount = Integer.MIN_VALUE;
    HashMap<Character, Integer> lastPos = new HashMap<Character, Integer>();
    int dist;
    public String rearrangeString2(String s, int k) {
        dist = k;
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> counts = getCounts(s, k);
        if(maxCount*k > s.length()) {
            return "";
        }
        List<HashSet<Character>> countsByChar = getCountsByChar(counts);
        int pos = 0;
        
        for(int curCount = maxCount; curCount >= 0; curCount--) {
            HashSet<Character> set = countsByChar.get(curCount);
            if(set != null && set.size() > 0) {
                
                for(char c:set) {
                    if(isValidChar(c, pos)) {
                        sb.append(c);
                        updateLastPos(c, pos++);
                    }    
                }
                
            }
        }
        
        return sb.toString();
    }
    
    public boolean isValidChar(char c, int pos) {
        if(!lastPos.containsKey(c)) {
            return true;            
        } else {
            return (pos - lastPos.get(c) >= dist);
        }
    }
    
    public void updateLastPos(char c, int pos) {
        lastPos.put(c, pos);
    }
    
    public HashMap<Character, Integer> getCounts(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(char c:s.toCharArray()) {
            int count = 1;
            if(map.containsKey(c)) {
                count += map.get(c);
            }
            map.put(c, count);
            maxCount = Math.max(maxCount, count);
        }
        return map;
    }
    
    public List<HashSet<Character>> getCountsByChar(HashMap<Character, Integer> counts) {
        List<HashSet<Character>> countsByChar = new ArrayList<HashSet<Character>>();
        for(Character c:counts.keySet()) {
            int count = counts.get(c);
            HashSet<Character> charSetForOneCount = countsByChar.get(count);
            
            if(charSetForOneCount == null) {
                charSetForOneCount = new HashSet<Character>();                
            }
            charSetForOneCount.add(c);
            countsByChar.add(count, charSetForOneCount);
        }
        return countsByChar;
    } 
}
