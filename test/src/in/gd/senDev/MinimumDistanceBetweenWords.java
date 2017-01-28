package in.gd.senDev;

/*
Find minimum distance between two words (order preserved) in a big string. 
For e.g 1. "hello how are you" - distance between "hello" and "you" is 3. 
e.g 2. "hello how are hello you" - distance is 1 
e.g 3. "you are hello" - distance is -1. Order of "hello" and "you" should be preserved. 
e.g 4. "hello how are hello" - distance is -1 since "you" didnt occur even once.
 */

public class MinimumDistanceBetweenWords {

	public static int minimumDistance(String[] aS,String a,String b){
		int aIndex=-1;
		int bIndex=-1;
		int minDistance=Integer.MAX_VALUE;
		//String[] aS=str.toLowerCase().split("[ \t]+");
		int i=0;
		for(String t:aS){
			if(t.equals(a)){
				aIndex=i;
			}
			if(t.equals(b)){
				bIndex=i;
			}
			if(aIndex!=-1 && bIndex!=-1){
				minDistance= minDistance > Math.abs(bIndex-aIndex) ? bIndex-aIndex : minDistance; 
			}
			i++;
		}
		if(aIndex ==-1 || bIndex==-1)
			return -1;
		else
			return minDistance;
	}
	
	public static void main(String args[]) {
		
		String[] sentence = {"how", "are", "you", "hello"};
		String firstWord = "hello";
		String secondWord = "you";
		System.out.println(minimumDistance(sentence, firstWord, secondWord));
	}
	
}
