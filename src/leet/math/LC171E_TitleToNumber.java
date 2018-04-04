package leet.math;

public class LC171E_TitleToNumber {
	public int titleToNumber(String s) {
        //1028
        
        //AZ = 52
        //BA = 53 = 26*2 + A = 53
        
        //CA = 26*3 + A
        
        //DA = 26*4 + A 
        //ZZ = 26*26 + 26 = 702
        
        //AAA = 26*26 + 27 
        
        //26^3*CHAR  26^2*CHAR 26^1*CHAR  26^0*CHAR
        
        int num = 0;
        int factor = 0;
        for(int i=s.length()-1; i>=0; i--, factor++) {
            num += Math.pow(26, factor)*getValue(s.charAt(i));
        }
        return num;
    }
    
    public int getValue(char c) {
        return (int) c-64;        
    }
    
    public static void main(String args[]) {
    	LC171E_TitleToNumber t = new LC171E_TitleToNumber();
    	System.out.println(t.titleToNumber("ZZ"));
    	
    }
}
