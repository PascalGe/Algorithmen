package paper12;
import java.util.List;
import java.util.ArrayList;

public class Node 
{
    private Graph      graph;               // the graph this node belongs to
    private String     name;
    private List<Edge> adjacentEdges;       // list of outgoing edges
    private int        distance = -1;       // distance to start node
    private Node       predecessor = null;  // predecessor of this node on a shortest path
    
    /**
     * Instantiates a new Node object that will be part of the given graph.
     * @param graph the graph to which the node belongs
     */
    public Node(Graph graph, String name) 
    {
        this.graph         = graph;
        this.name          = name;
        this.adjacentEdges = new ArrayList<Edge>();
    }
    
    /**
     * Returns the graph to which this node belongs.
     * @return The graph to which this node belongs.
     */
    public Graph getGraph()
    {
        return this.graph;
    }
    
    /**
     * Returns the distance to this node.
     * @return Returns the data associated to this node with the given key.
     */
    public int getDistance()
    {
        return this.distance;
    }
    
    /**
     * Sets the distance to this node.
     */
    public void setDistance(int distance)
    {
        this.distance = distance;
    }
    
    /**
     * Returns the predecessor of this node.
     * @return predecessor
     */
    public Node getPredecessor()
    {
        return this.predecessor;
    }
    
    /**
     * Sets the predecessor of this node.
     */
    public void setPredecessor(Node predecessor)
    {
        this.predecessor = predecessor;
    }   
    
    
    /**
     * Returns the degree of this node.
     * @return The degree of this node.
     */
    public int degree()
    {
        return adjacentEdges.size();
    }
    
    /**
     * Returns the adjacent edges.
     * @return The adjacent edges.
     */
    public List<Edge> getAdjacentEdges()
    {
        return this.adjacentEdges;
    }
    
    /**
     * Returns a string representation of this node.
     * @return A string representation of this node.
     */
    public String toString()
    {
        return this.name;
    }
}
