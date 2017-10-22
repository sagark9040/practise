package fb.se.dynamicprogramming;

public class LongestIncreasingSubsequence{
public int lengthOfLIS(int[] nums) {
        
        if(nums.length == 0)
            return 0;
        if(nums.length == 1)
            return 1;
        
        int[] longestSeq = initArray(nums.length);
        int longestSeqLen = 0;
        
        for(int cur = 1; cur < nums.length; cur++){
            
            for(int j = 0; j < cur; j++){
                if(nums[cur] > nums[j])
                    longestSeq[cur] = (longestSeq[j]+1) > longestSeq[cur] ? longestSeq[j]+1 : longestSeq[cur];     
                
                longestSeqLen =  longestSeq[cur] > longestSeqLen ? longestSeq[cur] : longestSeqLen;   
            }
        }
        return longestSeqLen;      
    }
    
    public int[] initArray(int len){
        int[] arr = new int[len];
        for(int i=0; i<len; i++)
            arr[i] = 1;
        
        return arr;
    }
        
    
    public static void main(String args[]){
    	LongestIncreasingSubsequence lng = new LongestIncreasingSubsequence();
    	
    	int[] a = {1,3,6,7,9,4,10,5,6}; 
    			
    			// {10,9,2,5,3,4}; //{10,9,2,5,3,4}; 
    		
    		//{10, 9, 2, 5, 3, 7, 101, 18};
    	System.out.println(lng.lengthOfLIS(a));
    }
}