class Solution {
    public boolean validTree(int n, int[][] edges) {
        // prepare graph
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0 ;  i < n ; i++){
            ArrayList<Integer> list = new ArrayList<>();
            graph.add(list);
        }
        for(int i = 0; i < edges.length; i++){
            int start = edges[i][0];
            int end = edges[i][1];
            graph.get(start).add(end);
            graph.get(end).add(start);
            // added both ways as its bidirectional
        }
        boolean[] visited = new boolean[n];
        // boolean[] path = new boolean[n];  only be used in case of directed graph 
        // use parent and child connectivity in case of undirected graph
            
        if(checkCycle(0 , graph , visited, -1)){
                return false;
        }
        // check conectivity between the nodes
        for(int i = 0 ; i < n; i++){
            if(visited[i] == false){
                return false;
            }
        }
               
        return true;
    }
    public boolean checkCycle(int node , ArrayList<ArrayList<Integer>> graph, 
     boolean[] visited, int parent){
        visited[node] = true;
       
        for (int neighbour : graph.get(node)){
            if (neighbour == parent) continue;
            // cycle found
            if(visited[neighbour]){
                return true;
            }
            if(!visited[neighbour]){
                if (checkCycle(neighbour , graph , visited, node)) return true;
            }
        }
        
        return false;

    }
}