package leet.array;

public class LC370M_RangeAddition {
    //1200a
    
//Given:
//     length = 5,
//     updates = [
//         [1,  3,  2],
//         [2,  4,  3],
//         [0,  2, -2]
//     ]

    
	
	
// Output:

//     [-2, 0, 3, 5, 3]

    //Brute Force way .... 10 mins
    //Init result array [0 0 0 0 0]
    //for i=0 to <updates.len
    //      inner for loop...takes in the range and increments the value according to curUpd[2]
    //return result
    
    // TCs 
    // len < 1 .. return empty array
    // if some of the values in curUpd are out of bounds, then what?
    // curUpd values are reversed for start and end?
    // too large value for update? integer overflow maybe?
    // too many updates, what then?
    // 
	
	// Optimal Way - Genius Solution
	// [1,  3,  2],
	// [0 2 0 0 -2 0 ]
	
	// [2,  4,  3],
	// [0 2 3 0 -2 -3 ]
	
	// [0,  2, -2]
	// [-2 2 3 2 -2 -3 ]
	// [-2 0 3 5 3  0]
	
	public int[] genius(int length, int[][] updates) {
		int result[] = new int[length+1];
		for(int i=0; i<updates.length; i++) {
			int start = updates[i][0];
            int end = updates[i][1];
            int incr = updates[i][2];
            
            result[start] += incr;
            result[end+1] += incr;
		}
		
		int prev = 0;
		for(int i=0; i<length; i++) {
			result[i] += prev;
			prev = result[i]; 
		}
		
		return result;
	}
    
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] result = new int[length];
        
        for(int i=0; i<updates.length; i++) {
            int start = updates[i][0];
            int end = updates[i][1];
            int incr = updates[i][2];
            
            for(int pos=start; pos<=end; pos++) {
                result[pos] += incr;
            }
        }
        return result;
    }
    
    public static void main(String args[]) {
    	LC370M_RangeAddition l = new LC370M_RangeAddition();
    	int[][] updates = {{1,  3,  2},
    	         {2,  4,  3},
    	         {0,  2, -2}};
    	for(int i:l.genius(5, updates))
    		System.out.println(i + " ");
    }
}
