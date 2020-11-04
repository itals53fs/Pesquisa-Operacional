import java.util.Scanner;

public class nine {
  public int somatorio(int n){
    if(n==1){
      return n*(n+1);
    }
    return n *(n+1) + somatorio(n-1);
  }
  public static void main(String[] args) {
    nine somat = new nine();
    Scanner scan = new Scanner(System.in);
    int n;
    System.out.print("Insira um numero: ");
    n = scan.nextInt();
    if(n>0){
      System.out.println("somatorio: n*(n+1): "+ somat.somatorio(n));
    }else{
      System.out.println("Numero invalido");
    }
  }
}