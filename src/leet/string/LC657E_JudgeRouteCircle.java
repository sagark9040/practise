package leet.string;

public class LC657E_JudgeRouteCircle {
    //813 pm -> 823
    //Can the input make it go out of bounds? If this is in a grid
    //Limit to the number of moves?
    //Circle at the end or in the middle somewhere is also fine?

    //Brute Force:
    //Add 1 to x for U, -1 to x for D
    //Add 1 to y for R, -1 to y for L
    
    //Modified: calculate diffUD, diffLR and if both is zero then circle
    
    //TCs:
    //no moves
    //one move will definitely mean no circle
    //a large string input
    //case sensitive moves?
    
    public boolean judgeCircle(String moves) {
        
        //base case, not moved from 0,0
        if(moves == null || moves.length() == 0) {
            return true;
        }
        
        int diffUD = 0, diffLR = 0;
        for(char c:moves.toCharArray()) {
            switch(c) {
            case 'U': diffUD++;
                break;
            case 'D': diffUD--;
                break;
            case 'L': diffLR--;
                break;
            case 'R': diffLR++;
                break;
            }
        }
        
        return (diffUD == 0) && (diffLR == 0);
    }
}
