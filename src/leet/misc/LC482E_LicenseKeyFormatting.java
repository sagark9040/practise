package leet.misc;

public class LC482E_LicenseKeyFormatting {
	//TCs
    //Only alphanum
    //Only dashes
    //Normal case
    //Empty string
    //Case issue
    //English alphabets only?
    
    public String licenseKeyFormatting(String S, int K) {
        StringBuffer formattedStr = new StringBuffer();
        
        //5F3Z-2e-9-w
        //2-5g-3-J
        
        int count = 0;
        for(int i=S.length()-1; i>=0; i--) {

            if ((S.charAt(i) >= 'a' && S.charAt(i) <= 'z') || 
                (S.charAt(i) >= 'A' && S.charAt(i) <= 'Z') || 
                (S.charAt(i) >= '0' && S.charAt(i) <= '9')) {
                formattedStr.append(String.valueOf(S.charAt(i)));
                count++;                
            }
            
            if(count == K && i != 0){
                formattedStr.append("-");
                count = 0;
            }
        }
        
        String semiFinal = formattedStr.reverse().toString().toUpperCase();
        
        StringBuffer finalStr = new StringBuffer();
        boolean firstAlphanumFound = false;
        
        for(int i=0; i<semiFinal.length(); i++){
            if(firstAlphanumFound)
                finalStr.append(semiFinal.charAt(i));
            else if(!firstAlphanumFound && semiFinal.charAt(i) != '-'){                
                finalStr.append(semiFinal.charAt(i));
                firstAlphanumFound = true;
            }                
        }
        
        
        return finalStr.toString();
    }
}
