package leet.array;

public class LC769M_MaximumChunks {
	
	// TOOK TIME TO THINK BUT GOT THERE EVENTUALLY WITH A SUB-OPTIMAL SOLN
	
	public int maxChunksToSorted(int[] arr) {
        int chunks = 0;
        boolean[] presentElements = new boolean[arr.length];
        for(int i=0; i<arr.length; i++) {
            presentElements[arr[i]] = true;
            if(countPresentElements(i, presentElements) == i+1) {
                chunks++;
            }
        }        
        return chunks;
    }
    
    public int countPresentElements(int i, boolean[] presentElements) {
        int countPresent = 0;
        for(int cur=0; cur<=i; cur++) {
            if(presentElements[cur] == true) {
                countPresent++;
            }
        }
        return countPresent;
    }
    
    //OPTIMAL SOLN
    public int maxChunksToSorted_OPTIMAL_LC(int[] arr) {
        int n = arr.length;
        int[] maxOfLeft = new int[n];
        int[] minOfRight = new int[n];

        maxOfLeft[0] = arr[0];
        for (int i = 1; i < n; i++) {
            maxOfLeft[i] = Math.max(maxOfLeft[i-1], arr[i]);
        }

        minOfRight[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            minOfRight[i] = Math.min(minOfRight[i + 1], arr[i]);
        }

        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            if (maxOfLeft[i] <= minOfRight[i + 1]) res++;
        }

        return res + 1;
    }
    
    public static void main(String args[]) {
    	LC769M_MaximumChunks m = new LC769M_MaximumChunks();
    	int[] arr = {5,1,2,3,4,0};
    	System.out.println(m.maxChunksToSorted(arr));
    }
}
