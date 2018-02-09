package leet.dp;

public class LC91M_DecodeWaysTotalNumStrDecodings {
	public int numDecodings(String s) {       
       if(s == null || s.length() == 0) {
           return 0;
       }
       int len = s.length(); 
       int[] ways = new int[len+1];
       ways[0] = 1;
       if(s.charAt(0) != '0') {
           ways[1] = 1;
       } 
        
        for (int i=2; i<=len; i++) {
            int first = Integer.valueOf(s.substring(i-1, i));
            int second = Integer.valueOf(s.substring(i-2, i));
            if(first != 0) {
                ways[i] += ways[i-1];
            }
            if(second >= 10 && second <= 26) {
                ways[i] += ways[i-2];
            }
        }
        return ways[len];
    }
}
