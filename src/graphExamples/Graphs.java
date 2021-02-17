package graphExamples;

import graphRepresentation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graphs {

  public static Graph graphConstructor(String order, List<Integer> nodesInt, List<List<Integer>> arcsInt) {
    final List<Node> nodes = new ArrayList<>();
    final Map<Integer, Node> maps = new HashMap<>();

    for (Integer integer : nodesInt) {
      final Node newNode = new Node(integer);
      nodes.add(newNode);
      maps.put(integer, newNode);
    }

    final List<Arc> arcs = new ArrayList<>();
    for (List<Integer> integers : arcsInt) {
      arcs.add(new WeightedArc(
          maps.get(integers.get(0)),
          maps.get(integers.get(1)),
          integers.get(2)));
      if (order.equals("undirected")) {
        arcs.add(new WeightedArc(
            maps.get(integers.get(1)),
            maps.get(integers.get(0)),
            integers.get(2)));
      }
    }

    return new AdjacencyList(nodes, arcs);
  }

  public static Graph graph1 = graphConstructor(
        "undirected",
        List.of(
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11
        ),
        List.of(
            List.of(1, 2, 3),
            List.of(1, 6, 8),
            List.of(1, 8, 2),
            List.of(1, 10, 3),
            List.of(1, 11, 2),
            List.of(2, 3, 5),
            List.of(2, 11, 4),
            List.of(3, 4, 4),
            List.of(3, 5, 3),
            List.of(3, 6, 3),
            List.of(4, 5, 3),
            List.of(5, 6, 4),
            List.of(6, 7, 4),
            List.of(7, 8, 3),
            List.of(8, 9, 3),
            List.of(8, 10, 2),
            List.of(9, 10, 2),
            List.of(10, 11, 2)
        )
    );
}
