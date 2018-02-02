package leet.string;

public class LC186M_ReverseWordsInAStringPart2 {
	public void reverseWords(char[] str) {
		if(str.length < 2)
			return;
		int l=0, r=str.length-1;
		
		str = reverse(str, l, r);
		
		int start = 0;
		for(int i=1; i<str.length; i++) {
			if(str[i] == ' ') {
				str = reverse(str, start, i-1);
				start = i+1;
			}			
		}
		str = reverse(str, start, str.length-1); // I forgot to add this line. Dry run helped!!!
		System.out.println(String.valueOf(str));
    }

	private char[] reverse(char[] str, int start, int end) {
		int left = start, right = end;
		while(left < right) {
			char temp = str[left];
			str[left]= str[right];
			str[right] = temp;
			left++;
			right--;
		}
		return str;
	}
	
	public static void main(String args[]) {
		LC186M_ReverseWordsInAStringPart2 rev = new LC186M_ReverseWordsInAStringPart2();
		rev.reverseWords("the sky is blue".toCharArray());
	}
}
