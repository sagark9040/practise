package leet.array;

public class LC88E_MergeSortedArray {
	// 210 .. 9 min AC with help of Run button
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //1 2 6 10 xx
        //3 7
        
        //compare m-1 with n-1
        //whichever is higher goes into p
        
        
        int p = m+n-1;
        m--;
        n--;
        
        while(p >= 0) {
            int dig1 = m >= 0 ? nums1[m] : Integer.MIN_VALUE;
            int dig2 = n >= 0 ? nums2[n] : Integer.MIN_VALUE;
            
            if(dig1 > dig2) {
                nums1[p] = dig1;
                m--;
            } else {
                nums1[p] = dig2;
                n--;
            }
            p--;
        }
    }
}
