import java.util.Scanner;
class two{
  public static void main(String[] args) {
    int[] array;
    array = new int[10];
    Scanner in = new Scanner(System.in);
    for(int i =0; i <10; i++){
      System.out.println("number: " +(i+1));
      array[i] = in.nextInt();
    }
    System.out.println("array");
    for(int a : array){
      System.out.print(" " + a);
  
    }
    System.out.println();
  }
}