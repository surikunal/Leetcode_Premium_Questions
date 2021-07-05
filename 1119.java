public class 1119 {
    public String removeVowels(String str) {
        Set<Character> map = new HashSet<Character>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (!map.contains(str.charAt(i))) {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
}
