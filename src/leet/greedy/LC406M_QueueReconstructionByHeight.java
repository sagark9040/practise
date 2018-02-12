package leet.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class LC406M_QueueReconstructionByHeight {
	int[][] people;
    public int[][] reconstructQueue2(int[][] p) {
        //70,71,61,50,52,44
        people = p;
        sortByHeight();
        
        for(int i=0; i<p.length; i++) {
        	if(i == people[i][1]) {
        		continue;
        	} else {
        		putInRightPlace(i);
        	}
        }
        
        return people;
        
    }
    
    public int[][] reconstructQueue(int[][] people) {
        //pick up the tallest guy first
        //when insert the next tall guy, just need to insert him into kth position
        //repeat until all people are inserted into list
        Arrays.sort(people,new Comparator<int[]>(){
           @Override
           public int compare(int[] o1, int[] o2){
               return o1[0]!=o2[0]?-o1[0]+o2[0]:o1[1]-o2[1];
           }
        });
        List<int[]> res = new LinkedList<>();
        for(int[] cur : people){
            res.add(cur[1],cur); 
            System.out.println(cur[0]+"-"+cur[1]);
        }
        return res.toArray(new int[people.length][]);
    }
    
    private void putInRightPlace(int i) {
    	int countBigger = 0;
    	for(int pos=0; pos<i; pos++) {
    		if(people[pos][0] > people[i][0]) {
    			countBigger++;    			
    		}
    		if(countBigger == people[i][1]) {
    			people[pos+1] = people[i];
    			
    		}
    	}		
	}

	public void sortByHeight() {        
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o2[0] == o1[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        });
    }
    
    public static void main(String args[]) {
    	int[][] p = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
    	LC406M_QueueReconstructionByHeight q = new LC406M_QueueReconstructionByHeight();
    	for(int[] i:q.reconstructQueue(p))
    		System.out.println(i[0] + "" + i[1]);
    }
}
