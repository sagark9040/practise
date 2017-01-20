package test;


	
	import java.util.*;
	 
	public class WordsFromDicIn2DMatrix {
	 
		static int counter=0;
		
		static Set<String> set = new HashSet<String>();
	 
		static void makeSet() {
			set.add("GEEKS");
			set.add("FOR");
			set.add("QUIZ");
			set.add("GO");
		}
	 
		static boolean isValidWord(String str) {
			return set.contains(str);
		}
	 
		static void DFSUtil(char[][] boggle, boolean[][] visited, int i, int j, String str) {
			visited[i][j] = true;
			str += boggle[i][j];
	 
			counter++;
			
			if(isValidWord(str))
				System.out.println(str);
	 
			for(int row=i-1;row<=i+1 && row<boggle.length;row++) {
				for(int col=j-1;col<=j+1 && col<boggle[0].length;col++) {
					if(row>=0 && col >= 0 && !visited[row][col])
						DFSUtil(boggle,visited,row,col,str);
				}
			}
	 
			String temp = str.substring(0,str.length()-1);
			str = temp;
			visited[i][j] = false;
		}
	 
		static void printWords(char[][] boggle) {
			int M = boggle.length;
			int N = boggle[0].length;
	 
			boolean[][] visited = new boolean[M][N];
			String str = "";
	 
			for(int i=0;i<M;i++) {
				for(int j=0;j<N;j++)
					DFSUtil(boggle,visited,i,j,str);
			}
		}
	 
		static void printMatrix(char[][] boggle) {
			for(int i=0;i<boggle.length;i++) {
				for(int j=0;j<boggle[0].length;j++)
					System.out.print(boggle[i][j] + " ");
				System.out.println();
			}
		}
	 
		public static void main(String[] args) {
	 
			makeSet();
	 
			char[][] boggle = {{'G','I','Z'},
			                 {'U','E','K'},
			                 {'Q','S','E'}};
	 
			System.out.println("Boggle:");
			printMatrix(boggle);
			
			System.out.println("\nWords:");
			printWords(boggle);
			System.out.println("counter:" + counter);
		}
	
	
}
