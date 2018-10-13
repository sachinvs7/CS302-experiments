//Java program to print BFS traversal from a given source vertex
import java.io.*; 
import java.util.*; 
class Graph 
{ 
	private int V; //Number of vertices 
	private LinkedList<Integer> adj[]; //Adjacency Lists 
	Graph(int v) 
	{ 
		V = v; 
		adj = new LinkedList[v]; 
		for (int i=0; i<v; ++i) 
			adj[i] = new LinkedList(); 
	} 

	//Function to add edge
	void addEdge(int v,int w) 
	{ 
		adj[v].add(w); 
	} 

	void BFS(int s) 
	{ 
		//Mark all vertices as not visited, false by default 
		boolean visited[] = new boolean[V]; 
		//Create a queue for BFS 
		LinkedList<Integer> queue = new LinkedList<Integer>(); 
		//Mark the current node as visited and enqueue it 
		visited[s]=true; 
		queue.add(s); 
		while (queue.size() != 0) 
		{ 
			//Dequeue a vertex from queue and print 
			s = queue.poll(); 
			System.out.print(s+" "); 

			//Get all adjacent vertices of the dequeued vertex s 
			//If an adjacent vertex has not been visited, mark it visited and enqueue it 
			Iterator<Integer> i = adj[s].listIterator(); 
			while (i.hasNext()) 
			{ 
				int n = i.next(); 
				if (!visited[n]) 
				{ 
					visited[n] = true; 
					queue.add(n); 
				} 
			} 
		} 
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
		System.out.println("BFS from vertex 2: "); 
		g.BFS(2); 
	} 
} 

