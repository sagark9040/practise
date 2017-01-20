package test;

public class CharactersPrint {
	
	private char[] characters;
	
	CharactersPrint() {
		characters = new char[256];
		for (int i=0;i<256; i++)
			characters[i] = (char)i;
	}
	
	public static void main (String args[]) {
		for (int i=0;i<256;i++) {
			System.out.print(i + "=" + (char)i + "\t");
			if (i%5==0)
				System.out.println();
		}
	}
}
