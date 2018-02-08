package leet.misc;

import java.util.HashSet;

public class LC771E_JewelsAndStones_APieceOfCake {
	public int numJewelsInStones(String J, String S) {
        HashSet<Character> jewels = new HashSet<Character>();
        for(char c:J.toCharArray()) {
            jewels.add(c);
        }
        int count = 0;
        for(char st:S.toCharArray()) {
            if(jewels.contains(st)) {
                count++;
            }
        }
        return count;
    }
}
