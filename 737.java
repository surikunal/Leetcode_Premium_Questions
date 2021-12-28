// leetcode 737
class Solution {
    // union find
    public boolean areSentencesSimilarTwo(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        int n = sentence1.length, m = sentence2.length;
        if (n != m) return false;
        HashMap<String, String> par = new HashMap<String, String>();
        for (List<String> s: similarPairs) {
            String par1 = findPar(s.get(0), par), par2 = findPar(s.get(1), par);
            if (!par1.equals(par2)) par.put(par1, par2);
        }
        for (int i = 0; i < n; ++i)
            if (!sentence1[i].equals(sentence2[i]) && !findPar(sentence1[i], par).equals(findPar(sentence2[i], par))) return false;
        return true;
    }
    
    public String findPar(String str, HashMap<String, String> par) {
        if (!par.containsKey(str)) par.put(str, str);
        return str.equals(par.get(str)) ? str : findPar(par.get(str), par);
    }
}
