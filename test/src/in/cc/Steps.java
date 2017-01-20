package in.cc;

/*
 * If you can hop 1, 2, or 3 steps at a time, calculate the total number of possible combinations for `n` steps.
 */
public class Steps {

	public static int getSteps(int n){ // int[] dp){
/*		if(dp[n]!=-1)
			return dp[n];*/

		if(n<=1)
			return 1;
		if (n==2)
			return 2;
		if (n==3)
			return 4;
		
		
		return getSteps(n-1)+getSteps(n-2)+getSteps(n-3);
	}
	
	public static int getStepsDP(int n, int[] dp){
		if(dp[n]!=-1)
			return dp[n];

		if(n<=1)
			return 1;
		if (n==2)
			return 2;
		if (n==3)
			return 4;
		
		
		dp[n]=getSteps(n-1)+getSteps(n-2)+getSteps(n-3);
		return dp[n];
	}

	public static void main(String args[]){
		long t=System.currentTimeMillis();
		int[] n=new int[]{-1,-1,-1,-1,-1, -1,-1,-1,-1,-1,-1, -1,-1,-1,-1,-1,-1, -1,-1,-1,-1,-1,-1, -1,-1,-1,-1,-1,-1, -1,-1,-1,-1,-1,-1, -1,-1,-1,-1,-1,-1, -1,-1,-1,-1,-1,-1, -1,-1,-1,-1,-1,-1, -1,-1,-1,-1,-1,-1, -1,-1,-1,-1,-1,-1, -1,-1,-1,-1,-1,-1, -1};
		System.out.println(getStepsDP(35,n));
		System.out.println(System.currentTimeMillis()-t);
		
		t=System.currentTimeMillis();
		System.out.println(getSteps(35));
		System.out.println(System.currentTimeMillis()-t);
		
		
		
		
	}
}
