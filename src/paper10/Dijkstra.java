package paper10;

public class Dijkstra {

	public static void runDijkstra(Graph g, Node start) {
		// init
		start.setDistance(0);
		boolean[] visited = new boolean[g.nodeCount()];

		// Dijkstra
		for (int c = 0; c < g.nodeCount(); c++) {
			// find cheapest node
			Node current = null;
			int currentId = -1;
			for (int i = 0; i < visited.length; i++) {
				if (visited[i] == false && g.nodes().get(i).getDistance() >= 0
						&& (current == null || g.nodes().get(i).getDistance() < current.getDistance())) {
					current = g.nodes().get(i);
					currentId = i;
				}
			}
			// visit cheapest
			visited[currentId] = true;
			// update rest
			for (int i = 0; i < g.edgeCount(); i++) {
				Edge edge = g.edges().get(i);
				Node source = edge.getSource();
				Node target = edge.getTarget();

				if (source == current
						&& (target.getDistance() < 0 || target.getDistance() > source.getDistance() + edge.getCost())) {
					target.setDistance(current.getDistance() + edge.getCost());
					target.setPredecessor(source);
				}
			}
		}
	}

	public static void main(String[] args) {
		// This is the graph from Exercise 4 of PÜ 9.
		Graph g = new Graph();

		Node s = g.createNode(); // 0
		Node a = g.createNode(); // 1
		Node b = g.createNode(); // 2
		Node c = g.createNode(); // 3
		Node d = g.createNode(); // 4
		Node e = g.createNode(); // 5
		Node f = g.createNode(); // 6
		Node t = g.createNode(); // 7

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
		g.nodes().stream().forEach(u -> {
			System.out.println(u + " " + u.getDistance());
		});
	}
}
