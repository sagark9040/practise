package leet.dp;

public class LC651M_4KeysKeyboardMaxAs {
	
//625pm
    
    //N could be < 1
    //n = 1 = A
    //n = 2 = AA
    //n = 3 = AAA
    //n = 4 = AAAA
    //n = 5 = AAAAA     (AA select copy paste)
    //n = 6 = AAA.AAA   (AAA select copy paste)
    //n = 7 = AAA.AAA.AAA       (AAA select copy paste paste)
    //n = 8 = AAA.AAA.AAA.AAA       (AAA select copy paste paste paste)
    //n = 9 = AAA.AAA.AAA.AAA.AAA or (AAAAA.AAAAA.AAAAA)
    //n = 10 = AAAx6
    
    //10-5 * 3
    //10-6 * 4
    //10-7 * 5
    
    //N = 11-5 * 3 + 3 = 18
    //N = 11-6 * 4 + 4 = 20
    //N = 11-7 * 5= 20
    //N = 11-8 * 6 = 18
    
    //N = n-5 * 3 * (n-5) = 10-5 * 3 * 10-5 = 75
    //N = n-6 * 4 * (n-6) = 4 * 4 * 4 = 64
    //N = n-7 * 5 * n-7 = 45

    //N = (N-2 - x) * x
	
	public int maxA(int N) {
        int[] max = new int[N+1];
        
        for(int i=0; i<=N; i++) {
            if(i <= 6) {
                max[i] = i;
            } else {
                for(int factor=3; factor<=(i/2); factor++) {                    
                    // max[i] = Math.max(max[i], (max[factor] * (i-factor-1))); <<<<------ WRONG SOLN
                    max[i] = Math.max(max[i - 4] * 3, max[i - 5] * 4);                    
                }       
            }            
        }
        return N < 0 ? 0 : max[N];
    }
	public static void main(String[] args) {
		LC651M_4KeysKeyboardMaxAs m = new LC651M_4KeysKeyboardMaxAs();
		System.out.println(m.maxA(9));
	}
}
