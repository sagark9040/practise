package in.gd.senDev;

import java.util.List;

/** 
* Given a nested list of integers, returns the sum of all integers in the list weighted by their depth 
* For example, given the list {{1,1},2,{1,1}} the function should return 10 (four 1's at depth 2, one 2 at depth 1) 
* Given the list {1,{4,{6}}} the function should return 27 (one 1 at depth 1, one 4 at depth 2, and one 6 at depth 3) 
*/ 




/*
** 
* This is the interface that represents nested lists. 
* You should not implement it, or speculate about its implementation. 
*/ 
interface NestedInteger 
{ 
/** @return true if this NestedInteger holds a single integer, rather than a nested list */ 
boolean isInteger(); 

/** @return the single integer that this NestedInteger holds, if it holds a single integer 
* Return null if this NestedInteger holds a nested list */ 
Integer getInteger(); 

/** @return the nested list that this NestedInteger holds, if it holds a nested list 
* Return null if this NestedInteger holds a single integer */ 
List<NestedInteger> getList(); 
}

public class NestedListSum implements NestedInteger{

	// start of careercup answer
	
	public int depthSum (List<NestedInteger> input)
	{  
	    return depthSumHelper(input, 1);
	}

	private int depthSumHelper(List<NestedInteger> input, int level){
	    int sum = 0;

	    // look at each nested integer
	    for( NestedInteger nestedInt : input){
	        if(nestedInt.isInteger()){
	            sum += nestedInt.getInteger() * level;
	        } else {
	            sum += depthSumHelper(nestedInt.getList(), level+1);
	        }
	    }
	    return sum;
	}

	// end of careercup answer
	
	// another answer (#2)
	private int getListSum(List<NestedInteger> lni, int depth)
	{
		int sum = 0;
		NestedInteger ni = null;
		//while(lni.hasNext()){ //Instead of for loop as above, we use a while loop with .hasNext() method. Exactly the same as above, really.
		{	//ni = lni.next();
			if(ni.isInteger()) sum += ni.getInteger() * depth;
			else sum += getListSum(ni.getList(), depth + 1);
		}
		return sum;
	}
	public int getSum(NestedInteger ni)
	{
		if(ni.isInteger()) return ni.getInteger();
		else return getListSum(ni.getList(), 1);
	}
	// END: another answer (#2)
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public boolean isInteger() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Integer getInteger() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<NestedInteger> getList() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
