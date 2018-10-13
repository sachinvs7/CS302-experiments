//Java program to print DFS traversal from a given source vertex
import java.util.*; 
class Graph 
{ 
	private int V;
	private LinkedList<Integer> adj[]; 
	Graph(int v) 
	{ 
		V = v; 
		adj = new LinkedList[v]; 
		for (int i=0; i<v; ++i) 
			adj[i] = new LinkedList(); 
	} 
	//Function to add edge
	void addEdge(int v, int w) 
	{ 
		adj[v].add(w);
	} 
	void DFSUtil(int v,boolean visited[]) 
	{ 
		//Mark the current node as visited and print
		visited[v] = true; 
		System.out.print(v+" "); 

		//Recur for all the vertices adjacent to this vertex 
		Iterator<Integer> i = adj[v].listIterator(); 
		while (i.hasNext()) 
		{ 
			int n = i.next(); 
			if (!visited[n]) 
				DFSUtil(n, visited); 
		} 
	}
	void DFS(int v) 
	{ 
		//Mark all vertices as not visited, false by default 
		boolean visited[] = new boolean[V]; 
		//Call the recursive helper function to print DFS traversal 
		DFSUtil(v, visited); 
	} 
	public static void main(String args[]) 
	{ 
		Graph g = new Graph(4); 
		g.addEdge(0, 1); 
		g.addEdge(0, 2); 
		g.addEdge(1, 2); 
		g.addEdge(2, 0); 
		g.addEdge(2, 3); 
		g.addEdge(3, 3); 
		System.out.println("DFS from vertex 2: "); 
		g.DFS(2); 
	} 
} 
