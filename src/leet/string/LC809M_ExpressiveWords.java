package leet.string;

import java.util.ArrayList;
import java.util.List;

public class LC809M_ExpressiveWords {
	// 950 .. 40 min AC 
	public int expressiveWords(String S, String[] words) {
		// heeellooo
		// he*llo*

		// helo
		// 1e2e
		if (S == null || S.length() == 0 || words == null || words.length == 0) {
			return 0;
		}

		int result = 0;
		List<Pairs> allPairs = generatePairs(S);

		for (String word : words) {
			if (S.length() >= word.length() && matchesPattern(word, allPairs)) {
				result++;
			}
		}

		return result;
	}

	public boolean matchesPattern(String word, List<Pairs> allPairs) {
		List<Pairs> wordPairs = generatePairs(word);

		if (wordPairs.size() != allPairs.size()) {
			return false;
		}

		for (int i = 0; i < wordPairs.size(); i++) {
			if (wordPairs.get(i).c != allPairs.get(i).c || (wordPairs.get(i).count != 1 && allPairs.get(i).count == 1)
					|| (wordPairs.get(i).count != 2 && allPairs.get(i).count == 2)
					|| (wordPairs.get(i).count > allPairs.get(i).count)) {
				return false;
			}
		}
		return true;
	}

	public List<Pairs> generatePairs(String word) {
		List<Pairs> allPairs = new ArrayList<Pairs>();
		int count = 1;
		char prev = word.charAt(0);

		for (int i = 1; i < word.length(); i++) {
			if (word.charAt(i) != prev) {
				Pairs p = null;
				p = new Pairs(prev, count);
				allPairs.add(p);
				count = 1;
			} else {
				count++;
			}
			prev = word.charAt(i);
		}

		Pairs p = null;
		p = new Pairs(prev, count);
		allPairs.add(p);

		return allPairs;
	}
}

class Pairs {
	char c;
	int count;

	Pairs(char ch, int cnt) {
		count = cnt;
		c = ch;
	}
}
