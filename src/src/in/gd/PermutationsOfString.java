package src.in.gd;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PermutationsOfString {

	public static void permutation(String str) { 
	    permutation("", "ABC"); 
	}

	private static void permutation(String prefix, String str) {
	    int len = str.length();
	    if (len == 0) System.out.println("-->" + prefix);
	    else {
	        for (int i = 0; i < len; i++) {	            
	        	System.out.println("i=" + i + " " + prefix + str.charAt(i) + " " + str.substring(0, i) + str.substring(i+1, len));
	        	permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, len));
	        }
	    }
	}

	/* Driver program to test above functions */
	public static void main(String args[])
	{
		String str = "ABC";
		permutation(str);
	}

}


class StringPermutation {

    public List<String> permute(char input[]) {
        Map<Character, Integer> countMap = new TreeMap<>();
        for (char ch : input) {
            if (countMap.get(ch) == null) {
                countMap.put(ch, 1);
            } else {
                countMap.put(ch, countMap.get(ch)+1);
            }         
        }
        char str[] = new char[countMap.size()];
        int count[] = new int[countMap.size()];
        int index = 0;
        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            str[index] = entry.getKey();
            count[index] = entry.getValue();
            index++;
        }
        List<String> resultList = new ArrayList<>();
        char result[] = new char[input.length];
        permuteUtil(str, count, result, 0, resultList);
        return resultList;
    }

    public void permuteUtil(char str[], int count[], char result[], int level, List<String> resultList) {
        if (level == result.length) {
            resultList.add(new String(result));
            return;
        }

        for(int i = 0; i < str.length; i++) {
            if(count[i] == 0) {
                continue;
            }
            result[level] = str[i];
            count[i]--;
            permuteUtil(str, count, result, level + 1, resultList);
            count[i]++;
        }
    }

    private void printArray(char input[]) {
        for(char ch : input) {
            System.out.print(ch);
        }
        System.out.println();
    }

    public static void main(String args[]) {
        StringPermutation sp = new StringPermutation();
        sp.permute("AABC".toCharArray())
    }
}