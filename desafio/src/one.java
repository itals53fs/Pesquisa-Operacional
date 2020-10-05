import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class one {
    String dirname = "../text/";
    Scanner scan = new Scanner(System.in);
    Scanner in = new Scanner(System.in);
    int size;
    int mat[][];
    int[] vet;
  public void open(){
    boolean ok = true;
    String name;
    do{
      System.err.print("Insira o nome do arquivo (one.txt): ");
      name = in.next();
      try{
          scan= new Scanner(new File (dirname+name));
          ok = false;
      }
      catch(FileNotFoundException fileNotFoundException){
          System.err.println("erro");
      }
    }while(ok);
  }
  public void readFile(){
    size = scan.nextInt();
    mat = new int[size][size];
    while(scan.hasNextInt()){
      for(int i=0; i<size; i++){
        for(int j=0; j<size; j++){ 
              mat[i][j]=scan.nextInt();
        }
      }          
    }
  }
    public void p_vet(int size){
        vet = new int[size];
        System.out.println();
        System.out.println("Insira os custos ");
        for(int i =0; i<size;i++){
            vet[i] = in.nextInt();
        }
    }
    public int custo(){
        int soma=0;
        for(int i=0; i<vet.length; i++){
            if(i==vet.length-1){
                return soma;
            }
            System.out.println();
            soma = mat[vet[i]][vet[i+1]] +soma;
        }
        return 0;
    }
    public static void main(String[] args){
        one fun = new one();
        Scanner in = new Scanner(System.in);
        int soma;
        int size;
        System.out.print("Insira o numero total de custos: ");
        size = in.nextInt();
        fun.p_vet(size);
        fun.open();
        fun.readFile();
        soma = fun.custo();
        System.out.println("O custo do itinerário e: "+soma);
        
    }
}
