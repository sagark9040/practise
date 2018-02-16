package leet.dfsBfs;

public class LC542M_Matrix01 {
	//1236a
    //start from top left corner, 
        //do nothing if it is a zero
        //if it's a 1, then check for nearest 0
                //if UD or LR or is a zero then 1, or else min of valid val[i-1][j] and val[i][j-1], can't check for the valid of the R and D as they've not been processed, we could Integer.MAX_VALUE all ones

    //TCs
    //matrix == null or empty
    //mat = 1 element
    //mat = 1 row
    // 1 col
    //all 1s and 0s only, right? or do you want me to add checks for that as well?
    //proper mxn
    //all 1s - what then? return -1s
    //all 0s
    //
    
    int rowLen, colLen;
    int mat[][], res[][];
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return null;
        }
        rowLen = matrix.length;
        colLen = matrix[0].length;
        mat = matrix;
        res = new int[rowLen][colLen];
        
        updateMatrixUtil();
        return res;
    }
    
    //Do this in reverse too
    void updateMatrixUtil() {
        for(int r=0; r<rowLen; r++) {
            for(int c=0; c<colLen; c++) {
                if(mat[r][c] == 0) {
                    res[r][c] = 0;
                    continue;
                }
                
                if(checkNeigborsForZero(r, c) == 1) {
                    res[r][c] = 1;
                } else {
                    res[r][c] = Math.min(validCellValue(r, c-1), validCellValue(r-1, c)) + 1;
                }
            }
        }
    }
    
    int checkNeigborsForZero(int r, int c) {
        int[][] neighbors = {{-1,0},{1,0},{0,1},{0,-1}};
        
        for(int[] curNeighbor:neighbors) {
            if(validCellValue(r+curNeighbor[0], c+curNeighbor[1]) != Integer.MAX_VALUE && 
               mat[r+curNeighbor[0]][c+curNeighbor[1]] == 0) {
                return 1;
            } else {
                return Integer.MAX_VALUE;
            }
        }
        
        return Integer.MAX_VALUE;
    }
    
    int validCellValue(int r, int c) {
        if(r < 0 || c < 0 || r >= rowLen || c >= colLen) {
            return Integer.MAX_VALUE;
        }
        return res[r][c];
    }
}
