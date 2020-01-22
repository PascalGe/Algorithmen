package paper12;
import java.util.List;
import java.util.ArrayList;

public class Graph
{	
    private List<Node> nodeList; // nodes belonging to this graph
    private List<Edge> edgeList; // edges belonging to this graph

    /**
     * Creates a new instance of an empty Graph.
     */
    public Graph() 
    {
        this.nodeList = new ArrayList<Node>();
        this.edgeList = new ArrayList<Edge>();
    }
    
    /**
     * Returns a list of the nodes of the graph.
     * @return A list of the nodes of the graph.
     */
    public List<Node> nodes()
    {
        return this.nodeList;
    }
    
    /**
     * Provides a list of the edges of the graph.
     * @return A list of the edges of the graph.
     */
    public List<Edge> edges()
    {
        return this.edgeList;
    }
    
    /**
     * Returns the number of nodes in this graph.
     * @return The number of nodes in this graph.
     */
    public int nodeCount()
    {
        return this.nodeList.size();
    }
    
    /**
     * Returns the number of edges in this graph.
     * @return The number of edges in this graph.
     */
    public int edgeCount()
    {
        return this.edgeList.size();
    }
    
    /**
     * Returns true if this graph contains no nodes.
     * @return True if this graph contains no nodes, false otherwise.
     */
    public boolean isEmpty()
    {
        return (this.nodeCount()==0);
    }
    
    /**
     * Creates a new node in this graph.
     * @return The new node.
     */
    
    public Node createNode(String name)
    {
    	Node node = new Node(this, name);
    	this.nodeList.add(node);
    	return node;
    }
    
    /**
     * Creates a new edge in this graph.
     * @param source the source node
     * @param target the target node
     * @return The new edge.
     */
    public Edge createEdge(Node source, Node target)
    {
        Edge edge = new Edge(this, source, target);
        this.edgeList.add(edge);
        source.getAdjacentEdges().add(edge);
        return edge;
    }
    
    /**
     * Returns a string representation of this graph.
     * @return A string representation of this graph.
     */
    public String toString()
    {
        return new StringBuffer().append("Graph Nodes: #")
                                 .append(this.nodeCount())
                                 .append("\n----------------\n")
                                 .append(this.nodeList)
                                 .append("\nGraph Edges: #")
                                 .append(this.edgeCount())
                                 .append("\n----------------\n")
                                 .append(this.edgeList)
                                 .toString();
    }
}
