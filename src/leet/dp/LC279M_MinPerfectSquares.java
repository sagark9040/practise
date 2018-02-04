package leet.dp;

public class LC279M_MinPerfectSquares {
	//320 pm --> 349 pm .. SOLVED IT! YAYYY
    //thinking of DP obviously, starting with 1 and building till n, but how?
    //alternate theory: start from n and go back till. Looks inefficient so parking it for now

    //n = 10
    //1=1 2=1+1 3=1+1+1 4=2 5=
    //when a number itself is a perfect square, what value is assigned to it?
    //negative numbers?
    //negative value of n
    //n=0    
    
   public int numSquares(int n) {
        if(n<1) {
            return 0;            
        }
        int[] squares = new int[n+1];
        squares[0] = 1;
        squares[1] = 1;

        if(isPerfectSquare(n)) {
            return 1;
        }

        for(int cur = 2; cur <= n; cur++) {
            if(isPerfectSquare(cur)) {
                squares[cur] = 1;
            } else {
                squares[cur] = computeMinNumOfSquares(cur, squares);
            }
        }
        return squares[n];
    }

    public int computeMinNumOfSquares(int num, int[] squares) {
        int min = Integer.MAX_VALUE;

        for(int i=1; i<=(num+1)/2; i++) {
            min = Math.min(min, squares[i] + squares[num-i]);
        }
        return min;
    }

    public boolean isPerfectSquare(int n) {
        double sqrt = Math.sqrt(n);
        int x = (int) sqrt;
        return (Math.pow(sqrt,2) == Math.pow(x,2)) ? true : false;
    }
}
