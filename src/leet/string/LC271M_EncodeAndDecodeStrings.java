package leet.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//NOT SURE WHY IT WAS MEDIUM
//LOOKED STRAIGHTFORWARD TO ME

public class LC271M_EncodeAndDecodeStrings {
    public String encode(List<String> strs) {
        StringBuilder code = new StringBuilder();
        for(String s:strs) {
            code.append(s);
            code.append("xENDx");
        }
        return code.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> strings = new ArrayList<String>(Arrays.asList(s.split("xENDx")));
        System.out.println("->"+strings.get(0)+"<-");
        return strings;
    }
    
    public static void main(String args[]) {
    	LC271M_EncodeAndDecodeStrings ed = new LC271M_EncodeAndDecodeStrings();
    	List<String> strs = new ArrayList<String>(Arrays.asList(new String[]{}));
    	String code = ed.encode(strs);
    	System.out.println("Encoded:" + code);
    	System.out.println("------");
    	List<String> res = ed.decode(code);
    	for(String s:res){
    		System.out.println(s + "<-");
    	}
    	
    }
}
