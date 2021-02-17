package algorithms;

import graphExamples.Graphs;
import graphRepresentation.Graph;
import graphRepresentation.Node;

import java.util.List;

public class Dijkstra {

  private static Node getNode(List<Node> nodes, int n) {
    for (Node node : nodes) {
      if (node.getNodeCode() == n) {
        return node;
      }
    }
    throw new IllegalArgumentException("n is not found");
  }

  public static void main(String[] args) {
    Graph graph = Graphs.graph1;
    List<Node> nodes = graph.getAllNodes();
    Node start = getNode(nodes, 1);
    Node end = getNode(nodes, 1);
  }
}
