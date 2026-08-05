// BFS
//T.C : O(V+E) , V = number of nodes(methods), E = number of edges
//S.C : O(V+E), V = number of nodes(methods), E = number of edges
class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        //O(V+E), V = nodes , E = edges
        //graph - adjacency list
        List<List<Integer>> adj = new ArrayList<>(); //u -> {ngbr1, ngbr2} //O(V+E)
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        int[] inDegree = new int[n];        //O(V)
        boolean[] suspicious = new boolean[n]; //O(V)

        for(int[] edge : invocations) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            inDegree[v]++;
        }

        //BFS
        Queue<Integer> que = new LinkedList<>();
        que.offer(k);
        suspicious[k] = true;

        while(!que.isEmpty()) {
            int curr = que.poll();

            for(int ngbr : adj.get(curr)) {
                inDegree[ngbr]--;
                if(!suspicious[ngbr]) {
                    que.offer(ngbr);
                    suspicious[ngbr] = true;
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        boolean cannotRemove = false;

        for(int i = 0; i < n; i++) {
            if(suspicious[i] && inDegree[i] > 0) {
                cannotRemove = true;
                break;
            }

            if(!suspicious[i]) {
                result.add(i);
            }
        }

        if(cannotRemove) {
            List<Integer> vec = new ArrayList<>(); //0, 1, 2,... n-1
            for(int i = 0; i < n; i++) {
                vec.add(i);
            }
            return vec;
        }

        return result;
    }
}
