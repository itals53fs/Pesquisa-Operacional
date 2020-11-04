import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ten {
  int size=5;
  int somaA=0;
  int somaB=0;
  int [][] matA; 
  int [][] matB;
  int resp=0;
  String dirname = "../text/";
  Scanner scan = new Scanner(System.in);
  Scanner in = new Scanner(System.in);
  public void open(){
    boolean ok = true;
    String name;
    do{
      System.err.print("Insira o nome do arquivo (ten.txt): ");
      name = in.next();
      System.err.print(name);
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
    matA = new int [size][size];
    matB = new int[size][size];
    while(scan.hasNextInt()){
      for(int i=0; i<size; i++){
        for(int j=0; j<size; j++){ 
              matA[i][j]=scan.nextInt();
        }
      }
      for(int i=0; i<size; i++){
        for(int j=0; j<size; j++){                      
              matB[i][j]= scan.nextInt();
        }
      }             
    }
  }
    public void mult(){
      for(int i=0; i<size; i++){
        for(int j=0; j<size; j++){
          resp = matA[i][j]*matB[i][j]+resp;
            
        }
      }
        System.out.println("Somatório da matrizes: "+resp);
    }
   
    public static void main(String[] args) {
      ten somatorio = new ten();
      somatorio.open();
      somatorio.readFile();
      somatorio.mult();
    }
    
}