package leet.string;

public class LC43M_MultiplyTwoNums {
	public String multiply(String num1, String num2) {
        int[] product = new int[num1.length() + num2.length()];
        int len1 = num1.length(), len2 = num2.length();
        for(int i=len2-1; i>=0; i--) {
            for(int j=len1-1; j>=0; j--) {
                int index = len1 + len2 - i - j - 2;
                product[index] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                product[index + 1] += product[index] / 10;
                product[index] %= 10;
            }
        }
 
        StringBuilder sb = new StringBuilder();
        for(int i=product.length-1; i>0; i--) {
            if (sb.length() == 0 && product[i] == 0)
                continue;
            sb.append(product[i]);
        }
        sb.append(product[0]);
        return sb.toString();
    }
	
//	public String multiply(String num1, String num2) {
//		// 742
//		// clear approach since I've solved similar linkedlist problem
//
//		// 12345
//		// 6789
//
//		if (num1.length() == 0 && num2.length() == 0) {
//			return "";
//		}
//		if (num1.length() == 0 || num2.length() == 0) {
//			return num1.length() == 0 ? num2 : num1;
//		}
//
//		int p1 = 0, p2 = num2.length() - 1;
//
//		List<String> temp = new ArrayList<>();
//
//		for (int i = p2, pow = 0; i >= 0; i--, pow++) {
//			p1 = num1.length() - 1;
//			StringBuilder sb = new StringBuilder();
//			int carry = 0, secondDigit = Character.getNumericValue(num2.charAt(i)), digit = 0;
//			int firstDigit = 0;
//
//			while (p1 > 0) {
//				firstDigit = Character.getNumericValue(num1.charAt(p1));
//				digit = (firstDigit * secondDigit) + carry;
//				carry = digit > 9 ? 1 : 0;
//				sb.append(String.valueOf(digit % 10));
//
//				p1--;
//			}
//
//			temp.add(reverse(sb.toString(), pow));
//		}
//		String res = getResult(temp);
//		return res.length() == 0 ? "0" : res;
//	}
//
//	int getLongestLength(List<String> temp) {
//		int l = 0;
//		for (String s : temp) {
//			if (s.length() > l) {
//				l = s.length();
//			}
//		}
//		return l;
//	}
//
//	String getResult(List<String> temp) {
//		int pos = 1;
//		int digit = 0, carry = 0;
//		StringBuilder sb = new StringBuilder();
//
//		int longestLength = getLongestLength(temp);
//		for (int i = 0; i < longestLength; i++) {
//			digit = 0;
//
//			for (String s : temp) {
//				if (s.length() - pos >= 0) {
//					digit += Character.getNumericValue(s.charAt(s.length() - pos)) + carry; // out
//																							// of
//																							// bounds
//				}
//				sb.append(String.valueOf(digit % 10));
//				carry = digit / 10;
//
//				pos++;
//			}
//		}
//
//		return reverse(sb.toString(), 0);
//	}
//
//	String reverse(String str, int pow) {
//		StringBuilder sb = new StringBuilder();
//		for (int i = str.length() - 1; i >= 0; i--) {
//			sb.append(str.charAt(i));
//		}
//
//		while (pow > 0) {
//			sb.append("0");
//			pow--;
//		}
//
//		return sb.toString();
//	}

	public static void main(String args[]) {
		String num1 = "12";
		String num2 = "12";
		LC43M_MultiplyTwoNums m = new LC43M_MultiplyTwoNums();
		System.out.println(m.multiply(num1, num2));
	}
}
