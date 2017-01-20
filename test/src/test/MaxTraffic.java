package test;

import java.util.List;

public class MaxTraffic {

	private class City{
		int population;
		List<City> neighbors;
	}
	
	//List:
	//1-Max(5) - 1 = 4
	//2-Max(5) - 2 = 3
	//3-Max(5) - 3 = 2
	//4-Max(5) - 4 = 1
	//5-1,2,3,4 - Max(1 - 5, 2 - 5, 3 - 5, 4 - 5) = 4 - 5 = -1
	
}

/*
You are given a graph with no cycles, each node representing different cities and there are stadiums for baseball games in all cities. 

Each node contains a value representing the population of the city, and a list of neighbors. (feel free to extend data structure) 

Every time there is a baseball game at a city, everyone from all the different cities will go to the city with the baseball game. 

Return the maximum traffic between a city and its neighbours when there is a game at that city, for all cities. (Does not have to be sorted) 

The total run-time after returning everything should be O(n). 

Examples:


Input:
1   2
 \ /
  5
 / \
4   3
Output:
1 14
2 13
3 12
4 11
5 4

Input:
      7
     /
1   2
 \ / \
  5   15
 / \
4   3
Output:
1 36
2 15
3 34
4 33
5 24
7 30
15 22
*/

