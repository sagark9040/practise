package leet.math;

public class LC168E_ExcelSheetColumnTitle {
	// took more time than I think necessary
	
	public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        
        char[] charVal = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        
        while(n > 0) {
            n--;
            sb.append(charVal[n%26]);
            n /= 26;            
        }
        
        return sb.reverse().toString();
    }
}
