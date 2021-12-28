class Solution {
    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if (sentence1.length != sentence2.length) return false;
        HashMap<String, HashSet<String>> map = new HashMap<>();
        for (List<String> similar: similarPairs) {
            if (map.get(similar.get(0)) == null) map.put(similar.get(0), new HashSet<>());
            if (map.get(similar.get(1)) == null) map.put(similar.get(1), new HashSet<>());
            map.get(similar.get(0)).add(similar.get(1));
            map.get(similar.get(1)).add(similar.get(0));
        }
        for (int i = 0; i < sentence1.length; ++i) {
            if (sentence1[i].equals(sentence2[i])) continue;
            if (map.get(sentence1[i]) == null) return false;
            if (!map.get(sentence1[i]).contains(sentence2[i])) return false;
        }
        return true;
    }
}
