import java.util.Arrays;

// Q3
class Scratch {
  private static int max(int a, int b) {
    return Math.max(a, b);
  }

  private static int min(int a, int b) {
    return Math.min(a, b);
  }

  public static int[][] floydBandwidth(int[][] a) {
    final int size = a.length;
    int[][] b = Arrays.copyOf(a, size);

    for (int k = 0; k < size; k++) {
      for (int i = 0; i < size; i++) {
        for (int j = 0; j < size; j++) {
          b[i][j] = max(b[i][j], min(b[i][k], b[k][j]));
        }
      }
    }

    return b;
  }

  public static void printSquareArray(int[][] a) {
    for (int[] ints : a) {
      for (int anInt : ints) {
        System.out.printf("%-10d", anInt);
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    final int M = 0x7ffffff;
    int[][] b = {
        {M, 5, 1, 0},
        {5, M, 2, 4},
        {1, 2, M, 3},
        {0, 4, 3, M}
    };

    printSquareArray(floydBandwidth(b));
  }

}