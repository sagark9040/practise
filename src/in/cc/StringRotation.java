package in.cc;

public class StringRotation {

	static public boolean isRotated(String s1, String s2){
		
		String combined = s1+s1;
		
		return combined.contains(s2);
	}

	public static void main(String args[]){
		System.out.println(isRotated("didigoo", "digooid"));
	}
	
}
