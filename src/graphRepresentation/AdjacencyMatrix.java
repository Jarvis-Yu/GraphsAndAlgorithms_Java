//package graphRepresentation;
//
//import java.util.List;
//
//public class AdjacentMatrix implements Graph{
//
//  private final List<Arc> arcs;
//  private final List<Node> nodes;
//  private final Arc[][] matrix;
//
//  public AdjacentMatrix(List<Arc> arcs, List<Node> nodes) {
//    this.arcs = arcs;
//    this.nodes = nodes;
//    matrix = [[new Arc(new Node(1), new Node(2))]];
//  }
//
//  @Override
//  public List<Arc> getAllArcs() {
//    return arcs;
//  }
//
//  @Override
//  public List<Node> getAllNodes() {
//    return nodes;
//  }
//
//  @Override
//  public List<Arc> getAllArcsFrom() {
//    return null;
//  }
//}
