import java.util.Scanner;
class quatro{
  public static void main(String[] args) {
    int size = 10;
    Scanner scan = new Scanner(System.in);
    int[] array = new int[size];
    int aux;
    float media = 0;
    System.out.println("digite " + size + " numeros");
    for(int i=0;i<size;i++){
      array[i] = scan.nextInt();
      media = media + array[i];
    }
    for(int i=0;i<size;i++){
      for(int j=0;j<size;j++){
        if(array[i]<array[j]){
          aux = array[i];
          array[i] = array[j];
          array[j] = aux;
        }
      }
    }
    System.out.println("maior numero: "+ array[size-1]);
    System.out.println("menor numero: "+ array[0]);
    System.out.println("media: "+ media/size);
  }
}