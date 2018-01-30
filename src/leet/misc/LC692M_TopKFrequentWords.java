package leet.misc;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class LC692M_TopKFrequentWords {
	public List<String> topKFrequent(String[] words, int k) {
		
		// I AM NOT ABLE TO DO THIS COMPARATOR WITHOUT HELP. KNOW THE LOGIC, NEED THE EXECUTION/SYNTAX !!!!!!
        PriorityQueue<MaxHeapNode> pq = new PriorityQueue<MaxHeapNode>(k, new Comparator<MaxHeapNode>() {
            public int compare(MaxHeapNode n1, MaxHeapNode n2) {
            	return (n1.count == n2.count) ? n1.word.compareTo(n2.word) : n2.count - n1.count;
            }
        });
        
        Map<String, Integer> map = new TreeMap<String, Integer>();
        
        for(String word:words) {
        	if(!map.containsKey(word))
        		map.put(word, 1);
        	else
        		map.put(word, map.get(word) + 1);
        }
        
        for(String wordKey:map.keySet()) {
        	pq.offer(new MaxHeapNode(wordKey, map.get(wordKey)));
        }
     
        return listFromHeap(pq, k);
	}
	
	private List<String> listFromHeap(PriorityQueue<MaxHeapNode> pq, int k) {
		List<String> topKWords = new ArrayList<String>();
		for(int i=0; i<k && !pq.isEmpty(); i++) {
			MaxHeapNode cur = pq.poll();
			topKWords.add(cur.word);
			System.out.println(cur.word + " " + cur.count);
		}
		return topKWords;
	}

	class MaxHeapNode {
		public MaxHeapNode(String wordKey, Integer c) {
			this.word = wordKey;
			this.count = c;
		}

		public int count;
		public String word;
	}
	
	@SuppressWarnings("unused")
	public static void main(String args[]) {
		LC692M_TopKFrequentWords top = new LC692M_TopKFrequentWords();
		String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
				 
				//{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
		
		int k = 3;
		for(String word: top.topKFrequent(words, k)){}
			//System.out.println(word);
	
	}
}