package graphRepresentation;

import java.util.*;

public class AdjacencyList implements Graph{

  private final List<Node> nodes;
  private final List<Arc> arcs;
  private final Map<Node, Map<Node, Arc>> toNodes = new HashMap<>();

  public AdjacencyList(List<Node> nodes, List<Arc> arcs) {
    this.nodes = nodes;
    this.arcs = arcs;
    nodes.forEach(item -> toNodes.put(item, Map.of()));
    formMapping();
  }

  private void formMapping() {
    arcs.forEach(item -> toNodes.get(item.getNode1()).put(item.getNode2(), item));
  }

  @Override
  public List<Arc> getAllArcs() {
    return new ArrayList<>(arcs);
  }

  @Override
  public List<Node> getAllNodes() {
    return new ArrayList<>(nodes);
  }

  @Override
  public List<Arc> getAllArcsFrom(Node node) {
    return new ArrayList<>(toNodes.get(node).values());
  }
}
