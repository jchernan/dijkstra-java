package graph;

import java.util.*;

public class Dijkstra {

  private final Graph graph;
  private final State goal;
  
  public Dijkstra(Graph graph, State goal) {
    this.graph = graph;
    this.goal = goal;
  }

  public void run() {
    List<State> list = new ArrayList<State>(graph.getNodes());
    while (!list.isEmpty()) {
      State node = getMin(list);
      if (node.equals(goal))
        break;
      for (State neighbor : graph.getChildren(node)) {
        int d = node.distance() + graph.getCost(node, neighbor);
        if (d < neighbor.distance()) {
          neighbor.setDistance(d);
          neighbor.setPrevious(node);
        }
      }
    }
  }
  
  public State getMin(List<State> list) {
    State min = list.get(0);
    for (int i=0 ; i < list.size() ; i++) {
      if (list.get(i).distance() < min.distance())
        min = list.get(i);
    }
    list.remove(min);
    return min;
  }
}
