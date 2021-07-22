import java.util.*;
public class 1061{
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int[] par = new int[26];
        for (int i = 0; i < 26; ++i) {
            par[i] = i;
        }
        for (int i = 0; i < s1.length(); ++i) {
            int par1 = findPar(s1.charAt(i) - 'a');
            int par2 = findPar(s2.charAt(i) - 'a');
            par[par1] = Math.min(par1, par2);
            par[par2] = Math.min(par1, par2);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < baseStr.length(); ++i) {
            char ch = (char) (findPar(baseStr.charAt(i) - 'a') + 'a');
            sb.append(ch);
        }
        return sb.toString();
    }
};