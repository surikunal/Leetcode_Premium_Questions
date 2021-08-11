// leetcode 737
import java.util.Map;
import java.util.HashMap;
public class sentenseSimilarity2 {
    public static String find(Map<String, String> map, String i) {
        if (!map.containsKey(i)) {
            return i;
        }
        if (!i.equals(map.get(i))) {
            i = map.get(i);
        }
        return i;
    }
    public static void unionFind(Map<String, String> map, String i, String j) {
        String par1 = find(map, i);
        String par2 = find(map, j);
        map.put(par1, par2);
    }
    public static boolean areSentenseSimilar2(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length)
            return false;
        
        // this is simply a map which is used same as parent array
        Map<String, String> map = new HashMap<>();
        for (String[] pair: pairs) {
            if (!map.containsKey(pair[0])) {
                map.put(pair[0], pair[0]);
            }
            if (!map.containsKey(pair[1])) {
                map.put(pair[1], pair[1]);
            }
            unionFind(map, pair[0], pair[1]);
        }
        for (int i = 0; i < words1.length; ++i) {
            String par1 = find(map, words1[i]);
            String par2 = find(map, words2[i]);
            if (par1 != par2)
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        String[] words1 = {"great", "acting", "skills"};
        String[] words2 = {"fine", "drama", "talent"};
        String[][] pairs = {{"great", "good"}, {"fine", "good"}, {"acting","drama"}, {"skills","talent"}};
        System.out.println(areSentenseSimilar2(words1, words2, pairs));
    }
}
