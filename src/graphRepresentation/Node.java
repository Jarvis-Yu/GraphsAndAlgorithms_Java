package graphRepresentation;

public class Node {

  private final int nodeCode;
  private final String nodeName;

  public Node(int nodeCode, String nodeName) {
    this.nodeCode = nodeCode;
    this.nodeName = nodeName;
  }

  public Node(int nodeCode) {
    this.nodeCode = nodeCode;
    this.nodeName = String.valueOf(nodeCode);
  }

  public String getNodeName() {
    return nodeName;
  }

  public int getNodeCode() {
    return nodeCode;
  }

  @Override
  public int hashCode() {
    return this.nodeName.hashCode() + new Integer(this.nodeCode).hashCode();
  }
}
