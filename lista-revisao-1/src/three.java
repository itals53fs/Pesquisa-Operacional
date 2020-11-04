import java.util.Scanner;

class three {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int size = 10;
    int[][] mat = new int[size][size];

    for(int i=0; i<size; i++){
      for(int j=0; j<size; j++){
        mat[i][j] = scan.nextInt();
      }
    }

    for(int i=0; i<size; i++){
      System.out.println();
      for(int j=0; j<size; j++){
        System.out.print(mat[i][j] + " ");
      }
    }

    System.out.println();
  }
}