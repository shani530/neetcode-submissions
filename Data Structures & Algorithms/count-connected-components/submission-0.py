class Solution:
    def countComponents(self, n: int, edges: List[List[int]]) -> int:
        count = 0;
        visited = [False] * n
        # graph builder
        m = len(edges)
        graph = defaultdict(list)
        for i in range(m):
            start = edges[i][0]
            end = edges[i][1]
            graph[start].append(end)
            graph[end].append(start)
        for i in range(n):
            if(visited[i] == False):
                self.dfs( i , graph , visited)
                count += 1
        return count
            
    def dfs(self , i : int , graph : dict[List[int]], visited : List[bool]) -> None :
        visited[i] = True
        neighbours = graph[i]
        for neighbour in neighbours:
            if(visited[neighbour] == False):
                self.dfs(neighbour, graph , visited)
        return


