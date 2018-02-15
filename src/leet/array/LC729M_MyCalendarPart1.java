package leet.array;

import java.util.Map;
import java.util.TreeMap;

public class LC729M_MyCalendarPart1 {
    TreeMap<Integer, Integer> books = new TreeMap<>();

    public boolean book(int s, int e) {
        Map.Entry<Integer, Integer> prevBooking = books.floorEntry(s), 
        		nextBooking = books.ceilingEntry(s);
        if (prevBooking != null && s < prevBooking.getValue()) {
        	return false; // (s, e) start within floor
        }
        if (nextBooking != null && nextBooking.getKey() < e) { 
        	return false; // ceiling start within (s, e)
        }
        books.put(s, e);
        return true;
    }
    
    public static void main(String args[]) {
    	LC729M_MyCalendarPart1 m = new LC729M_MyCalendarPart1();
    	m.book(5, 10);
    	m.book(15, 20);
    	m.book(14, 16);
    	m.book(10,15);
    	
    }
}