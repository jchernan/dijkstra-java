package graph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class UnitedStates {

  // set the path of the file with the graph information here
  public static String FILE_PATH = "src/graph/usa.txt";
  
  public HashMap<String, State> states;
  public Graph graph;
  
  public UnitedStates() {
    states = new HashMap<String, State>();
    graph = new Graph();
    loadGraph();
  }
  
  public Graph getGraph() {
    return graph;
  }
  
  public void setStart(String stateName) {
    states.get(stateName).setDistance(0);
  }
  
  public State getState(String stateName) {
    return states.get(stateName);
  }
  
  private void loadGraph() {
    loadStates();
    loadEdges();
  }
  
  private void loadStates() {
    try {
      BufferedReader br = new BufferedReader(new FileReader(FILE_PATH));
      String line;
      while ((line = br.readLine()) != null) {
        String sName = line.substring(0, line.indexOf("-"));
        State s = new State(sName);
        states.put(sName, s);
        graph.addNode(s);
      }
      br.close();
    } catch(Exception e) {
      System.out.println(e.getMessage());
    }
  }
  
  private void loadEdges() {
    try {
      BufferedReader br = new BufferedReader(new FileReader(FILE_PATH));
      String line;
      while ((line = br.readLine()) != null) {
        String s1 = line.substring(0, line.indexOf("-"));
        String[] adjacent = line.substring(
          line.indexOf("-") + 1).split(",");
        for (String s : adjacent) {
          String s2 = s.substring(0, s.indexOf("("));
          String cost = s.substring(s.indexOf("(") + 1, s.indexOf(")"));
          graph.addEdge(
            states.get(s1),
            states.get(s2),
            Integer.parseInt(cost));
        }  
      }
      br.close();
    } catch(Exception e) {
      System.out.println(e);
    }
  }
  
  public static void main(String[] args) {
    
    String start = "Massachusetts";
    String end = "California";
    
    UnitedStates us = new UnitedStates();
    us.setStart(start);
    Dijkstra d = new Dijkstra(us.getGraph(), us.getState(end));
    d.run();
    
    List<State> path = new ArrayList<State>();
    State state = us.getState(end);
    
    while (state.previous() != null) {
      path.add(state);
      state = state.previous();
    }
    path.add(state);
    Collections.reverse(path);
    System.out.println("Shortest Path: " + path);
    System.out.println("Distance (in miles): " + us.getState(end).distance());
    
  }
}
