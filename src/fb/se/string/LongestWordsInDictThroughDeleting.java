package fb.se.string;

import java.util.List;

public class LongestWordsInDictThroughDeleting {

	public String findLongestWord(String s, List<String> d) {
		if (s == null || s.length() == 0)
			return "";

		String longestWord = "";

		for (String dictWord : d) {
			if (isSubsequence(dictWord, s)) {
				if (dictWord.length() > longestWord.length())
					longestWord = dictWord;
				else if (dictWord.length() == longestWord.length() && (dictWord.compareTo(longestWord) < 0)) {
					longestWord = dictWord;
				}
			}
		}

		return longestWord;
	}

	public boolean isSubsequence(String a, String b) {
		if (a.length() > b.length())
			return false;

		int indexOfB = 0;
		for (char charA : a.toCharArray()) {
			while (indexOfB < b.length() && b.charAt(indexOfB) != charA) {
				indexOfB++;
			}

			if (indexOfB == b.length())
				return false;

			indexOfB++;
		}

		return true;
	}
}