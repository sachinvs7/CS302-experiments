import sys

INFINITY = float('inf')

def dijkstra(G, n, startnode):
    cost = [[0 for _ in range(n)] for _ in range(n)]
    distance = [0] * n
    pred = [0] * n
    visited = [False] * n
    count = 0
    mindistance = 0
    nextnode = 0

    for i in range(n):
        for j in range(n):
            if G[i][j] == 0:
                cost[i][j] = INFINITY
            else:
                cost[i][j] = G[i][j]

    for i in range(n):
        distance[i] = cost[startnode][i]
        pred[i] = startnode
        visited[i] = False

    distance[startnode] = 0
    visited[startnode] = True
    count = 1

    while count < n - 1:
        mindistance = INFINITY

        for i in range(n):
            if distance[i] < mindistance and not visited[i]:
                mindistance = distance[i]
                nextnode = i

        visited[nextnode] = True

        for i in range(n):
            if not visited[i]:
                if mindistance + cost[nextnode][i] < distance[i]:
                    distance[i] = mindistance + cost[nextnode][i]
                    pred[i] = nextnode

        count += 1

    for i in range(n):
        if i != startnode:
            print(f"Distance of node {i} = {distance[i]}")
            print(f"Path = {i}", end='')
            j = i
            while j != startnode:
                j = pred[j]
                print(f"<-{j}", end='')
            print()

if __name__ == "__main__":
    MAX = 10
    G = [[0 for _ in range(MAX)] for _ in range(MAX)]
    n = int(input("Enter no. of vertices: "))
    print("Enter the adjacency matrix:")

    for i in range(n):
        row_values = input().split()
        for j in range(n):
            G[i][j] = int(row_values[j])

    u = int(input("Enter the starting node: "))
    dijkstra(G, n, u)
