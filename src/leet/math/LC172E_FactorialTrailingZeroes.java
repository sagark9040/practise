package leet.math;

public class LC172E_FactorialTrailingZeroes {
    //957
    
    // 1 1
    // 2 2
    // 3 6
    // 4 24
    // 5 120
    // 6 720
    // 7 5040
    // 8 40320
    // 9 362880
    // 10 3628800
    
    
    public int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }
}
