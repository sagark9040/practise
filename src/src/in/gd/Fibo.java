package src.in.gd;

//Given a positive integer N, write a function to return a list of the first N fibonacci
//numbers in order. For example, if N=5, the output list is 0 1 1 2 3.

public class Fibo {

	//Iterative
	static void fiboIterative(int n) {
		if(n < 1) {
			System.out.println("n<1");
			return;
		}
		
		if(n == 1) {
			System.out.println("0");
			return;
		}
		
		if(n == 2) {
			System.out.println("0 1 ");
			return;
		}
		
		int a = 0, b = 1;
		System.out.print(a+" "+b+" ");
		while (n>2) {
			int c = a+b;
			System.out.print(c+" ");
			a = b;
			b = c;
			n--;
		}
		System.out.println("--");
	}
	
	//Recursive
	static void fiboRecursive(int n) {
		if(n < 1) {
			System.out.println("n<1");
			return;
		}
		
		if(n == 1) {
			System.out.println("0");
			return;
		}
		
		if(n == 2) {
			System.out.println("0 1 ");
			return;
		}
		
		int a = 0, b = 1;
	}
	
	public static void main(String args[]){
		fiboIterative(0);
		fiboIterative(1);
		fiboIterative(2);
		fiboIterative(3);
		fiboIterative(5);
		fiboIterative(15);
	}
}
