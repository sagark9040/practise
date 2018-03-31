
public class LC75M_SortColors {
    public void sortColors(int[] nums) {
        int pos = 0, countOne = 0, countTwo = 0, countZero = 0;
        
        for(int n:nums) {
            if(n == 0)  countZero++;
            if(n == 1)  countOne++;
            if(n == 2)  countTwo++;
        }
        
        while(countZero > 0) {
            nums[pos] = 0;
            pos++; countZero--;
        }

        while(countOne > 0) {
            nums[pos] = 1;
            pos++; countOne--;
        }

        while(countTwo > 0) {
            nums[pos] = 2;
            pos++; countTwo--;
        }        
    }
}