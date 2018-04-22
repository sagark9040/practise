package leet.string;

public class LC6M_ZigZagString {

	// 1251
	// 24 min AC .. string init to null <-- take care of that.

	public String convert(String s, int numRows) {
		if (numRows <= 0 || s == null || s.length() == 0) {
			return "";
		}

		if (numRows == 1 || numRows >= s.length()) {
			return s;
		}

		int p = 0, len = s.length(), r = numRows;
		String[] subs = new String[r];

		while (p < len) {
			for (int i = 0; i < r && p < len; i++, p++) {
				if (subs[i] == null)
					subs[i] = "";
				subs[i] += s.charAt(p);
			}

			for (int i = r - 2; i >= 1 && p < len; p++, i--) {
				if (subs[i] == null)
					subs[i] = "";
				subs[i] += s.charAt(p);
			}
		}

		return appendAll(subs);
	}

	public String appendAll(String[] subs) {
		String s = "";
		for (String sub : subs) {
			if (sub != null && sub.length() > 0)
				s += sub;
		}

		return s;
	}

	public static void main(String args[]) {
		String s = "PAYPALISHIRING";
		LC6M_ZigZagString z = new LC6M_ZigZagString();
		System.out.println(z.convert(s, 3));
	}
}