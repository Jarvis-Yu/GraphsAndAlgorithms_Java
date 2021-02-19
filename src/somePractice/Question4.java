package somePractice;

import gadgets.Pair;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static gadgets.ListPlus.removeAll;
import static java.lang.Math.min;

public class Question4 {

  public static void incrementFlags(List<Boolean> flags) {
    final int size = flags.size();
    for (int i = 0; i < size; i++) {
      if (flags.get(i)) {
        flags.set(i, false);
      } else {
        flags.set(i, true);
        return;
      }
    }
    return;
  }

  public static boolean notAllTrue(List<Boolean> flags) {
    for (Boolean flag : flags) {
      if (!flag) {
        return true;
      }
    }
    return false;
  }

  public static List<Set<Integer>> allCombinationSorted(List<Integer> a) {
    final int size = a.size();
    final List<Set<Integer>> combinations = new ArrayList<>();
    final List<Boolean> flags = new ArrayList<>();
    for (int i = 0; i < size; i++) {
      flags.add(false);
    }
    do {
      incrementFlags(flags);
      final Set<Integer> set = new HashSet<>();
      for (int i = 0; i < size; i++) {
        if (flags.get(i)) {
          set.add(a.get(i));
        }
      }
      combinations.add(set);
    } while (notAllTrue(flags));

    combinations.sort(new Comparator<Set<Integer>>() {
      @Override
      public int compare(Set<Integer> o1, Set<Integer> o2) {
        return o1.size() - o2.size();
      }
    });

    return new LinkedList<>(combinations);
  }

  public static boolean hasHamiltonianCircuit(int[][] b) {
    final int M = 0x7fffffff;

    final int start = 0;
    List<Integer> nodes = IntStream.range(0, b.length).boxed().collect(Collectors.toList());
    List<Integer> nodesNoStart = new ArrayList<>(nodes);
    nodesNoStart.remove(start);
    final List<Set<Integer>> noStartSets = allCombinationSorted(nodesNoStart);
    final Map<Pair<Set<Integer>, Integer>, Integer> pathLength = new HashMap<>();

    for (int node : nodesNoStart) {
      if (node != start) {
        pathLength.put(Pair.pair(Set.of(), node), b[start][node]);
      }
    }

    for (Set<Integer> someSet : noStartSets) {
      List<Integer> someSets1 = removeAll(nodesNoStart, someSet);
      for (int node : someSets1) {
        pathLength.put(Pair.pair(Set.copyOf(someSet), node), M);
        for (int otherNode : someSet) {
          Set<Integer> setNoOther = new HashSet<>(someSet);
          setNoOther.remove(otherNode);
          pathLength.put(
              Pair.pair(Set.copyOf(someSet), node),
              min(
                  pathLength.get(Pair.pair(setNoOther, otherNode)) + b[otherNode][node],
                  pathLength.get(Pair.pair(someSet, node)))
          );
        }
      }
    }

    int opt = M;

    for (Integer node : nodesNoStart) {
      Set<Integer> excludedNodes = new HashSet<>(nodesNoStart);
      excludedNodes.remove(node);
      opt = min(pathLength.get(Pair.pair(excludedNodes, node)) + b[node][start], opt);
    }

    return opt < M;
  }

  public static final int[][] graph5 = {
      { 0,  8,  5,  1,  3},
      { 8,  0,  7, 10,  4},
      { 5,  7,  0,  6,  9},
      { 1, 10,  6,  0,  2},
      { 3,  4,  9,  2,  0}
  };

  public static void main(String[] args) {
    int[][] b = graph5;

    System.out.println(hasHamiltonianCircuit(b));
  }
}

