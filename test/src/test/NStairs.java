package test;

public class NStairs {
	
	public static int stairs (int n) {
		if(n == 1 || n == 0)
			return 1;
		
		return stairs(n-1) + stairs(n-2);		
	}
	
	public static int stairsDP (int n, int ar[]) {
		if(n == 1 || n == 0)
			return 1;
		else if (ar[n] > 0)
			return ar[n];
		
		ar[n] = stairsDP(n-1, ar) + stairsDP(n-2, ar);
		return ar[n];		
	}
	
	public static void main (String args[]) {
		long t = System.currentTimeMillis();
		System.out.println(stairs(0));
		System.out.println(stairs(1));
		System.out.println(stairs(2));
		System.out.println(stairs(3));
		System.out.println(stairs(35));
		
		System.out.println(System.currentTimeMillis() - t);
		
		System.out.println("--");
		t = System.currentTimeMillis();
		
		System.out.println(stairsDP(0, new int[1]));
		System.out.println(stairsDP(1, new int[2]));
		System.out.println(stairsDP(2, new int[3]));
		System.out.println(stairsDP(3, new int[4]));
		System.out.println(stairsDP(35, new int[36]));
		
		System.out.println(System.currentTimeMillis() - t);

	}
	
}
