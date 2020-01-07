package paper10;


public class Dijkstra {

	public static void runDijkstra(Graph g, Node start)
	{
		//TODO: Add your implementation here.
	}
	
	public static void main(String[] args)
	{
		// This is the graph from Exercise 4 of PÜ 9.
		Graph g = new Graph();
		
		Node s = g.createNode();
		Node a = g.createNode();
		Node b = g.createNode();
		Node c = g.createNode();
		Node d = g.createNode();
		Node e = g.createNode();
		Node f = g.createNode();
		Node t = g.createNode();

		g.createEdge(s, a, 4);
		g.createEdge(s, b, 6);
		g.createEdge(a, c, 6);
		g.createEdge(b, c, 2);
		g.createEdge(b, d, 5);
		g.createEdge(c, d, 2);
		g.createEdge(c, e, 7);
		g.createEdge(d, e, 5);
		g.createEdge(d, f, 1);
		g.createEdge(f, e, 3);
		g.createEdge(e, t, 5);
		g.createEdge(f, t, 9);
				
		runDijkstra(g, s);
		g.nodes().stream().forEach( u -> {
			System.out.println(u + " " + u.getDistance());
		});
		
	}
}
