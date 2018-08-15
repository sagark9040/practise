package leet.string;

import java.util.HashSet;
import java.util.Set;

public class NextClosestTime {
	int smallestOverall = 9999;
	int smallestGreater = 1440;
	int currentTime = 1440;

	public String nextClosestTime(String time) {
		Set<Integer> values = getValues(time);
		int[] slots = new int[4];
		currentTime = Character.getNumericValue(time.charAt(4)) + Character.getNumericValue(time.charAt(3)) * 10 + 
				Character.getNumericValue(time.charAt(1)) * 60 + Character.getNumericValue(time.charAt(0)) * 600;
		dfs(slots, 0, values);
		return smallestGreater >= 1440 ? stringify(smallestOverall) : stringify(smallestGreater);
	}

	public String stringify(int time) {
		String res = "" + time/60%24 + ':' + time%60;
		if(res.indexOf(":") == 0) res = "00" + res;
		if(res.indexOf(":") == 1 ) res = "0" + res;
		if(res.indexOf(":") == 2 && res.length() == 3) res = res + "00";
		if(res.indexOf(":") == 2 && res.length() == 4) res = res + "0";
		return res;
	}

	public Set<Integer> getValues(String time) {
		Set<Integer> values = new HashSet<Integer>();
		for (char c : time.toCharArray()) {
			if (Character.isDigit(c)) {
				values.add(Character.getNumericValue(c));
			}
		}
		return values;
	}

	void dfs(int[] slots, int pos, Set<Integer> values) {
		if(pos == 4) {
//			if(slots[3] == 9 && slots[2] == 3 && slots[1] == 9 && slots[0] == 1) {
//				System.out.println();
//			}
			
			if(checkValid(slots)) {
				smallestOverall = Math.min(smallestOverall, 
						numbify(slots));
				smallestGreater = Math.min(smallestGreater, 
						checkRange(slots));
			}	
			return;
		}
		for(int v:values) {
			slots[pos] = v;
			dfs(slots, pos+1, values);
		}	
	}

	private boolean checkValid(int[] slots) {
		if(slots[2] > 5 || slots[0] > 2) {
			return false;
		}
		return true;
	}

	private int numbify(int[] slots) {
		int number = slots[3] + slots[2] * 10 + slots[1] * 60 + slots[0] * 600;
		return number;
	}

	private int checkRange(int[] slots) {
		if(numbify(slots) > currentTime && numbify(slots) < 1440) {
			return numbify(slots);
		}
		return 1440;
	}
	
	public static void main(String args[]) {
		String s = "03:05"; 
				//"01:32"; 
				//"23:59"; 
				//"19:34";
		NextClosestTime n = new NextClosestTime();
		System.out.println(n.nextClosestTime(s));
		
	}
}
