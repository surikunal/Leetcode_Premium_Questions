// HashMap + BFS ===========================================================
class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < ppid.size(); ++i) {
            if (map.get(ppid.get(i)) == null) map.put(ppid.get(i), new ArrayList<>());
            map.get(ppid.get(i)).add(pid.get(i));
        }
        Queue<Integer> que = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        que.add(kill);
        while (!que.isEmpty()) {
            int rem = que.poll();
            ans.add(rem);
            if (map.containsKey(rem))
                for (int i: map.get(rem))
                    que.add(i);
        }
        return ans;
    }
}

// HashMap + DFS ===========================================================
class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < ppid.size(); ++i) {
            if (map.get(ppid.get(i)) == null) map.put(ppid.get(i), new ArrayList<>());
            map.get(ppid.get(i)).add(pid.get(i));
        }
        List<Integer> ans = new ArrayList<>();
        ans.add(kill);
        dfs(map, ans, kill);
        return ans;
    }
    
    public void dfs(HashMap<Integer, List<Integer>> map, List<Integer> ans, int kill) {
        if (map.containsKey(kill)) {
            for (int i: map.get(kill)) {
                ans.add(i);
                dfs(map, ans, i);
            }
        }
    }
}
