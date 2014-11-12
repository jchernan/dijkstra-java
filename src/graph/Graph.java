package graph;

import java.util.*;

public class Graph {
  
  private Map<State, HashMap<State, Integer>> graph;
  
  
  /**
   * Constructs a new Graph
   * @effects Constructs a new Graph
   */
  public Graph() {
    graph = new HashMap<State, HashMap<State, Integer>>();
  }
  
  /**
   * Adds a node to a Graph
   * @requires node != null && node not already in this
   * @modifies this
   * @effects adds a node to this
   */
  public void addNode(State node) {
    HashMap<State, Integer> map = new HashMap<State, Integer>(); 
    graph.put(node, map);
  }
  
  /**
   * Add an edge to a Graph
   * @requires n1 != null && n2 != null && n1,n2 exist in this 
   * && edge between n1 and n2 does not exist already
   * @modifies this
   * @effects makes an edge from node1 to node2
   */
  public void addEdge(State n1, State n2, int cost) {
    graph.get(n1).put(n2, cost);
  }
  
  
  /**
   * @return the collection of the nodes that form this
   */
  public List<State> getNodes() {
    List<State> nodes = new ArrayList<State>(graph.keySet());
    return nodes;
  }
  
  /**
   * @return the collection of nodes that are children of node 
   */
  public List<State> getChildren(State node) {
    List<State> children = new ArrayList<State>(graph.get(node).keySet());
    return children;
  }
  
  public Integer getCost(State n1, State n2) {
    return graph.get(n1).get(n2);
  }
  
  
} // Graph
