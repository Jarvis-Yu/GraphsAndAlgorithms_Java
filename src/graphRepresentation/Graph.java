package graphRepresentation;

import java.util.List;

public interface Graph {

  public List<Arc> getAllArcs();

  public List<Node> getAllNodes();

  public List<Arc> getAllArcsFrom(Node node);

}
