package leet.array;

public class LC739M_DailyTemperatures_WarmerDays {
    //155a->217a
    
    //[73, 74, 75, 71, 69, 72, 76, 73]
    //BF
    //take every single value t:temps
    //init days to 0
    //keep going right to end of the array and if temp > cur, then pos - posOfcur
    //O(n^2)

    // 0    1  2   3   4   5    6   7
    //[73, 74, 75, 71, 69, 72, 76, 73]
    //                     1    0    0]
    //                          76, 6    73, 7
    //[30-100] mark them as present .. O(1) space with their pos
    
    //Algo:
    //[30-100]
    //everytime from len-1 to 0, encounter a temperature, then mark it's pos
    //for n-1 .. res = 0;
    //for every i from n-2 to 0, check the array for lowest positions more than cur day temperature
    
    
    //TCs
    //array len = 0 or 1
    
    //increase from left -> right
    //decre right to left
    
    
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures == null || temperatures.length == 0) {
            return new int[]{};
        }
        
        //atleast one day's data is present 
        //init result and temp tracker
        
        int numDays = temperatures.length;
        int[] warmerDays = new int[temperatures.length];
        int[] tempTracker = new int[101];
        warmerDays[numDays-1] = 0;
        tempTracker[temperatures[numDays-1]] = numDays-1;
        
        for(int curDay = numDays-2; curDay >= 0; curDay--) {
            int curDayTemp = temperatures[curDay];
            
            warmerDays[curDay] = getWarmerDay(curDay, curDayTemp, tempTracker);
            tempTracker[curDayTemp] = curDay;
        }
        return warmerDays;
    }
    
    int getWarmerDay(int curDay, int curTemp, int[] tempHistory) {
        int closestWarmDay = Integer.MAX_VALUE;
        for(int i=curTemp+1; i<tempHistory.length; i++) {
            if(tempHistory[i] != 0) {
                closestWarmDay = Math.min(closestWarmDay, tempHistory[i]-curDay);
            }
        }
        return closestWarmDay == Integer.MAX_VALUE ? 0 : closestWarmDay;
    }
}
