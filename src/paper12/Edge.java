package paper12;


public class Edge
{
	private Graph graph;     // the graph this edge belongs to
    private Node  source;    // the source of this edge
    private Node  target;    // the target of this edge
 
    
    /**
     * Creates a new edge that belongs to the given graph.
     * @param graph the graph that belongs to
     * @param source the source node
     * @param target the target node
     */
	public Edge(Graph graph, Node source, Node target)
	{
            this.graph  = graph;
            this.source = source;
            this.target = target;
    }   
    
    
    /**
     * Returns the graph this edge belongs to.
     * @return The graph to which the edge belongs.
     */
    public Graph getGraph()
    {
        return this.graph;
    }
    
    /**
     * Returns the source node connected to this edge.
     * @return The source node to this edge.
     */
    public Node getSource()
    {
        return this.source;
    }
    
    /**
     * Returns the target node connected to this edge.
     * @return The target node to this edge.
     */
    public Node getTarget()
    {
        return this.target;
    }
    
    
    /**
     * Returns the node at this edge which is on the opposite side of the given node.
     * @param node the given node
     * @return The node at this edge which is on the opposite side of the given node.
     */  
    public Node getOppositeNode(Node node)
    {   
        if (node == this.getTarget())
        {
            return this.getSource();
        }
        else
        {
            if (node == this.getSource())
            {
                return this.getTarget();
            }
            else
            {
                return null;
            }
        }            
    }
    
    /**
     * Returns a string representation of this edge.
     * @return A string representation of edge.
     */
    public String toString()
    {
        return "("+ this.source + "," + this.target + ")";
    }

}
