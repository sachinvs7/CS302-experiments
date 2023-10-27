from collections import defaultdict, deque

class Graph:
    def __init__(self, v):
        self.V = v
        self.adj = defaultdict(list)

    def add_edge(self, v, w):
        self.adj[v].append(w)

    def bfs(self, s):
        visited = [False] * self.V
        queue = deque()
        visited[s] = True
        queue.append(s)

        while queue:
            s = queue.popleft()
            print(s, end=" ")

            for n in self.adj[s]:
                if not visited[n]:
                    visited[n] = True
                    queue.append(n)

if __name__ == "__main__":
    g = Graph(4)
    g.add_edge(0, 1)
    g.add_edge(0, 2)
    g.add_edge(1, 2)
    g.add_edge(2, 0)
    g.add_edge(2, 3)
    g.add_edge(3, 3)
    print("BFS from vertex 2: ")
    g.bfs(2)
