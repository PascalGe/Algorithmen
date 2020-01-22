package paper12;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DFS {
	
	
	public final Graph g;
	
	public Map<Node, Integer> dfsnum;
	public Map<Node, Integer> compnum;
	
	public Set<Edge> treeEdges;
	public Set<Edge> forwardEdges;
	public Set<Edge> backwardEdges;
	public Set<Edge> crossEdges;
	
	
	public DFS(Graph g) {
		
		this.g = g;
		
		dfsnum  = new HashMap<Node, Integer>();
		compnum = new HashMap<Node, Integer>();
		
		treeEdges     = new HashSet<Edge>();
		forwardEdges  = new HashSet<Edge>();
		backwardEdges = new HashSet<Edge>();
		crossEdges    = new HashSet<Edge>();
	}
	
	

	//TODO: Use this space for additional variables, if needed
	
	
	
	public void runDfs()
	{		
		// calculate dfsnum, compnum and tree edges

		//TODO: Implement me
		
		
		
		// calculate forward, backward, cross edges using dfsnum and compnum

		//TODO: Implement me
		
	}
	
	
	//TODO: Use this space for additional methods, if needed
		
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args)
	{
		

		// FIRST EXAMPLE WITH A CONNECTED GRAPH
		// This is the graph from Exercise 1 of PÜ 11.
		Graph graph = new Graph();
		
		Node a = graph.createNode("a");
		Node b = graph.createNode("b");
		Node c = graph.createNode("c");
		Node d = graph.createNode("d");
		Node e = graph.createNode("e");
		Node f = graph.createNode("f");
		Node g = graph.createNode("g");
		Node h = graph.createNode("h");
		Node i = graph.createNode("i");

		graph.createEdge(a, b);
		graph.createEdge(a, d);
		graph.createEdge(b, c);
		graph.createEdge(b, i);
		graph.createEdge(c, f);
		graph.createEdge(d, e);
		graph.createEdge(d, g);
		graph.createEdge(d, h);
		graph.createEdge(e, a);
		graph.createEdge(e, i);
		graph.createEdge(f, i);
		graph.createEdge(h, i);
				
		
		DFS dfsSolve = new DFS(graph);
		dfsSolve.runDfs();
		
		
		System.out.println("FIRST EXAMPLE");
		
		graph.nodes().stream().forEach( u -> {
			System.out.println("Node:" + u + " - dfsnum:" + dfsSolve.dfsnum.get(u) + " - compnum:" + dfsSolve.compnum.get(u));
		});
		
		System.out.println("\nTREE EDGES");
		dfsSolve.treeEdges.stream().forEach( edge -> {
			System.out.print(edge + " ");
		});
		
		System.out.println("\n\nBACKWARD EDGES");
		dfsSolve.backwardEdges.stream().forEach( edge -> {
			System.out.print(edge + " ");
		});

		System.out.println("\n\nFORWARD EDGES");
		dfsSolve.forwardEdges.stream().forEach( edge -> {
			System.out.print(edge + " ");
		});

		System.out.println("\n\nCROSS EDGES");
		dfsSolve.crossEdges.stream().forEach( edge -> {
			System.out.print(edge + " ");
		});
		
		
		
		
		// SECOND EXAMPLE WITH A NON-CONNECTED GRAPH
		Graph graph2 = new Graph();

		Node r = graph2.createNode("r");
		Node s = graph2.createNode("s");
		Node t = graph2.createNode("t");
		Node x = graph2.createNode("x");
		Node y = graph2.createNode("y");
		Node z = graph2.createNode("z");

		graph2.createEdge(s, r);
		graph2.createEdge(s, t);
		graph2.createEdge(x, y);
		graph2.createEdge(x, z);
		graph2.createEdge(y, x);
		graph2.createEdge(y, z);	
		graph2.createEdge(z, x);	
		
		DFS dfsSolve2 = new DFS(graph2);
		dfsSolve2.runDfs();
		
		

		System.out.println("\n\n\nSECOND EXAMPLE");
		
		graph2.nodes().stream().forEach( u -> {
			System.out.println("Node:" + u + " - dfsnum:" + dfsSolve2.dfsnum.get(u) + " - compnum:" + dfsSolve2.compnum.get(u));
		});
		
		System.out.println("\nTREE EDGES");
		dfsSolve2.treeEdges.stream().forEach( edge -> {
			System.out.print(edge + " ");
		});
		
		System.out.println("\n\nBACKWARD EDGES");
		dfsSolve2.backwardEdges.stream().forEach( edge -> {
			System.out.print(edge + " ");
		});

		System.out.println("\n\nFORWARD EDGES");
		dfsSolve2.forwardEdges.stream().forEach( edge -> {
			System.out.print(edge + " ");
		});

		System.out.println("\n\nCROSS EDGES");
		dfsSolve2.crossEdges.stream().forEach( edge -> {
			System.out.print(edge + " ");
		});
		
	}
}
