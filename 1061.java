class Solution {
    private int findPar(int i, int[] par) {
        if (i == par[i]) return i;
        return par[i] = findPar(par[i], par);
    }
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int[] par = new int[26];
        for (int i = 0; i < 26; ++i) par[i] = i;
        for (int i = 0; i < s1.length(); ++i) {
            int par1 = findPar(s1.charAt(i) - 'a', par);
            int par2 = findPar(s2.charAt(i) - 'a', par);
            par[par1] = Math.min(par1, par2);
            par[par2] = Math.min(par1, par2);
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < baseStr.length(); ++i)
            ans.append((char)(findPar(baseStr.charAt(i) - 'a', par) + 'a'));
        return ans.toString();
    }
}
