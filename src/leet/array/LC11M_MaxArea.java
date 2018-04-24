package leet.array;

public class LC11M_MaxArea {

	//406  
    // did it like the wall-trapping rainwater one in 20mins ..
    // saw the soln and doing it for lines 
    //error on right-left multiplier

    public int maxArea(int[] height) {
        if(height.length == 0 || height.length == 1) {
            return 0;
        }
        
        int left = 0, right = height.length-1;
        int maxArea = 0;
        while(left < right) {
            int curArea = Math.min(height[left], height[right]) * (right-left);
            maxArea = Math.max(maxArea, curArea);            
            
            if(height[left] < height[right]) left++;
            else right--;
        }
        return maxArea;
    }
    
	public static void main(String args[]) {
		int[] height = {1,2,3,1};
		LC11M_MaxArea ma = new LC11M_MaxArea();
		System.out.println(ma.maxArea(height));
	}
}
