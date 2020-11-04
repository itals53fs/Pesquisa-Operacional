import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class five {
    
    Scanner scan = new Scanner(System.in);
    int size=10;
    int [][] mat1;
    int [][] mat2;
    int [][] soma;
    int i;
    int j;
    public void open(){
        try{
            scan= new Scanner(new File ("../text/matriz.txt"));
        }
        catch(FileNotFoundException fileNotFoundException){
            System.err.println("erro!");
            System.exit(1);
        
        }
    }
    public void readFile(){
        mat1 = new int [size][size];
        mat2 = new int[size][size];
        soma = new int[size][size];
       while(scan.hasNextInt()){
            for(i=0; i<size; i++){
                for(j=0; j<size; j++){ 
                      mat1[i][j]=scan.nextInt();
                }
            }
            // depois de percorrer a size/2 no arquivo irá para o proximo for
            for(i=0; i<size; i++){
                for(j=0; j<size; j++){                      
                      mat2[i][j]=scan.nextInt();
                }
            }             
       }
    }
    public void read(){
        System.out.println("mat1");
        for(i=0; i<size; i++){
            System.out.println();
            for(j=0; j<size; j++){             
                System.out.print(mat1[i][j] + "\t");
            }
        }
        System.out.println();

        System.out.println("mat2");
            for(i=0; i<size; i++){
                System.out.println();
                for(j=0; j<size; j++){
                    System.out.print(mat2[i][j] + "\t");
                }
            }
        for(i=0; i<size; i++){
            for(j=0; j<size; j++){
                soma[i][j]=mat1[i][j]+mat2[i][j];
            }
        }
        System.out.println();
        System.out.println("soma");
        for(i=0; i<size; i++){
            System.out.println();
            for(j=0; j<size; j++){
                System.out.print(soma[i][j] + "\t");
            }
        }
    }
        
     

    public static void main (String args[]){
        five leitura = new five();
        leitura.open();
        leitura.readFile();
        leitura.read();
    }			
}