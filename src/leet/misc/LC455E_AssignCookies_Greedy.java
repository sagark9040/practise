package leet.misc;

import java.util.Arrays;

public class LC455E_AssignCookies_Greedy {
	public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        for(int cookie=0, child=0; cookie<s.length && child<g.length; cookie++) {
            if(s[cookie] >= g[child]) {
                child++;
                count++;
            }
        }
        return count;
    }
}
