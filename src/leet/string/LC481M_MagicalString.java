package leet.string;

public class LC481M_MagicalString {
	//547
    //1 22 11 2 1 22 1 22 11 2 11 22
    //1  2 2  1 1  2 1 2  2  1  2 2
    
    
    public int magicalString(int n) {
        //n = 1 - 1
        //n = 2 - 1
        //n = 3 - 1
        //n = 4 - 2
        //n = 5 - 3
        //n = 6 - 3
        //n = 7 - 4
            // 8  4
            // 9  4
            // 10 5
            // 11 5
            // 12 5
            // 13 6
            // 14 7
            // 15 7
            // 16 8
            // 17 9
            // 18 9
            // 19 9
        
        // 122112 
        //     . 1
                
        if(n < 1)   return 0;
        if(n <= 3 && n > 0)  return 1;
        if(n == 4)  return 2;
        if(n == 5 || n == 6)    return 3;
        if(n < 10)  return 4;
                
        StringBuilder sb = new StringBuilder();
        sb.append("122112");
        int p1 = 4;
        int num = 1;
        
        while(sb.length() <= n) {
            
            String temp = "";
            
            if(num == 1) {
                temp = sb.charAt(p1) == '1' ? "1" : "11";
                num = 2;
            } else {
                temp = sb.charAt(p1) == '1' ? "2" : "22";
                num = 1;
            }
            sb.append(temp);
            p1++;
        }
        
        return countOnes(sb.toString(), n);        
    }
    
    int countOnes(String sb, int n) {
        int count = 0;
        
        for(int i=0; i<n; i++)
            count += sb.charAt(i) == '1' ? 1 : 0;    
        
        return count;
    }
}
