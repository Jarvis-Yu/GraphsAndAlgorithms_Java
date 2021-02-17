package graphRepresentation;

public abstract class Arc {

  private final Node Node1;
  private final Node Node2;

  protected Arc(Node node1, Node node2) {
    Node1 = node1;
    Node2 = node2;
  }

  public Node getNode1() {
    return Node1;
  }

  public Node getNode2() {
    return Node2;
  }

  public abstract int getWeight();
}
