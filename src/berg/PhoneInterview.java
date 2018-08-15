package berg;

import java.util.ArrayList;
import java.util.List;

//[1, 1, 2, 2, 3, 3, 3, 2, 2, 1]  -> [1, 1, 2, 2, 2, 2, 1] -> [1, 1, 1] -> []
//[1, 2, 3, 1, 2, 3, 1, 2, 3]  

//Iterate one by one .. keep track of consecutive count, start end indexes
//wherever preNum's count >= 3, arrayCopy (0 to start-1, end+1, len-1);

public class PhoneInterview {
	static boolean foundThrees = true;

	public static int[] suppressWrapper(int[] a) {

		while (foundThrees) { // potential prob at the beginning
			if (a == null || a.length < 3) {
				return a;
			}

			a = suppress(a);
		}
		return a;
	}

	public static int[] suppress(int[] a) {

		int len = a.length;

		// System.out.println(": " + a.length);
		int prev = a[0], start = 0, end = 0;
		int count = 1;

		for (int i = 1; i < len; i++) { // 1,2,2,2
			if (a[i] == prev) {
				count++;
				end++;
			} else {
				// prev num count >= 3
				if (count >= 3) {
					// copy to a new array
					foundThrees = true;
					int[] cp = copiedArray(a, start, end);

					// for(int number:cp) {
					// System.out.println("-->" + number);
					// }

					return cp;
				} else { // prev num count < 3
					// continue processing
					start = i;
					end = i;
					count = 1; // 1 1 1
				}
			}
			prev = a[i];
		}

		// 1, 2, 2, 2 --> 1
		if (count >= 3) {
			// copy array from 0 to start-1
			foundThrees = true;
			return copiedArray(a, start, end);
		}

		foundThrees = false;
		return a;
	}

	public static int[] copiedArray(int[] a, int start, int end) {
		List<Integer> result = new ArrayList<Integer>();

		for (int i = 0; i < a.length; i++) {
			if (!(i >= start && i <= end)) {
				result.add(a[i]);
			}
		}

		int[] array = new int[result.size()];
		for (int i = 0; i < result.size(); i++)
			array[i] = result.get(i);

		return array;
	}

	public static void main(String args[]) throws Exception {
		int[] a = { 1, 2, 2, 3, 3, 3, 2, 2, 1, 1,7,8};
		int[] res = suppressWrapper(a);
		for (int num : res) {// suppressWrapper
			System.out.print(num + " ");
		}
	}
}