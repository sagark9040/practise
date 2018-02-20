package leet.string;

import java.util.ArrayList;
import java.util.List;

public class LC293E_FlipGame1 {
	//10 min AC
	public List<String> generatePossibleNextMoves(String s) {
        List<String> combos = new ArrayList<String>();        
        for(int i=0; i<s.length()-1; i++) {
            if(s.substring(i, i+2).equals("++")) {
                StringBuilder sb = new StringBuilder();
                sb.append(s.substring(0, i));
                sb.append("--");
                sb.append(s.substring(i+2));
                combos.add(sb.toString());
            }
        }
        return combos;
    }
}
