package graphRepresentation;

public class WeightedArc extends Arc{

  private final int weight;

  public WeightedArc(Node node1, Node node2, int weight) {
    super(node1, node2);
    this.weight = weight;
  }

  @Override
  public int getWeight() {
    return weight;
  }
}
