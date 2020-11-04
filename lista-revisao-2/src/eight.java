import java.util.Scanner;

public class eight{
  public int Soma(int[] vet, int size){
    if(size == 1){
      return vet[0];
    }
    size--;
    return vet[size] + Soma(vet, size);
  }
  public static void main(String[] args) {
    eight op = new eight();

    int soma=0;
    int size;
    Scanner scan = new Scanner(System.in);
    System.out.print("Insira o tamanho do array: ");
    size = scan.nextInt();
    int[] vet = new int[size];
    System.out.println("Insira "+size+" numeros");
    for(int i=0;i<size;i++){
      vet[i] = scan.nextInt();
    }


    System.out.println("A soma dos numeros eh: "+ op.Soma(vet, size));
  }
}