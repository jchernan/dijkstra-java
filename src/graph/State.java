package graph;


public class State {
  private final String name;
  private int distance;
  private State previous;

  public State(String name) {
    this.name = name;
    this.distance = Integer.MAX_VALUE;
    this.previous = null;
  }

  public String name() {
    return name;
  }

  public int distance() {
    return distance;
  }
  
  public State previous() {
    return previous;
  }
  
  public void setDistance(int d) {
    distance = d;
  }
  
  public void setPrevious(State s) {
    previous = s;
  }

  public boolean equals(Object o) {
    if (o instanceof State) {
      State other = (State) o;
      return this.name.equals(other.name);
    }
    return false;
  }

  public int hashCode() {
    return name.hashCode();
  }

  public String toString() {
    return name.toString();
  }
}
