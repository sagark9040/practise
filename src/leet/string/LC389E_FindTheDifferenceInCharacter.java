package leet.string;

public class LC389E_FindTheDifferenceInCharacter {
	//5 mins AC
	
	public char findTheDifference(String s, String t) {
        int[] sChar = new int[256];
        int[] tChar = new int[256];
        for(char cur:s.toCharArray()) {
            sChar[cur]++;
        }
        for(char cur:t.toCharArray()) {
            tChar[cur]++;
        }
        for(int i=0; i<256; i++) {
            if(sChar[i] != tChar[i]) {
                return (char) i;
            }
        }
        return 'c';
    }
}
