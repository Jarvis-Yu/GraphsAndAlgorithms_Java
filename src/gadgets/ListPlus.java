package gadgets;

import java.util.*;

public class ListPlus {

  public static <U> List<U> removeAll(List<U> list, Collection<U> collection) {
    List<U> newList = new LinkedList<>(List.copyOf(list));
    newList.removeAll(collection);
    return newList;
  }

  public static void main(String[] args) {
    List<Integer> list1 = new ArrayList<>(List.of(1, 2, 3, 5, 6));
    Set<Integer> set1 = new HashSet<>(Set.of(2, 3, 4, 5));
    removeAll(list1, set1);
    for (Integer integer : list1) {
      System.out.println(integer);
    }
  }
}
