import java.util.Scanner;

public class eleven{
  public void termos(int n){
    int numerador;
    double denominador;
    double somatorio = 0;
    for(int i=1; i<=n; i++){
      numerador = (2*i-1);
      denominador = (Math.pow(-2, i+1));
      somatorio = (numerador/denominador) + somatorio;
      System.out.print("+ "+ numerador +"/"+ denominador + " ");
    }
    System.out.println(" = " + somatorio);
  }
  public static void main(String[] args) {
    eleven t = new eleven();
    Scanner scan = new Scanner(System.in);
    int n;
    System.out.print("Insira um numero: ");
    n = scan.nextInt();
    t.termos(n);
  }
}