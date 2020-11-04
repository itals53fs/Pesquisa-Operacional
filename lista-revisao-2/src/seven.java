import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class seven {

    String dirname = "../text/";
    int size;
    Scanner scan = new Scanner(System.in);
    Scanner in = new Scanner(System.in);
    int linha;
    int coluna;
    int[][] adjacencia = new int[linha][coluna];
    int[][] grafo = new int[linha][coluna];

    public void open(){
        boolean ok = true;
        do{
            System.out.printf("Informe o nome de arquivo de texto: (grafo.txt)\n");
            String name = scan.nextLine();
            try{
                scan = new Scanner(new File (dirname+name));
                ok = false;
            }
            catch(FileNotFoundException fileNotFoundException){
                System.err.println("erro");
            }
        }while(ok);
    }
    public void readFile(){
      linha =  scan.nextInt();
        coluna = scan.nextInt();
        size = linha * coluna;
        grafo = new int[linha][coluna];
        while(scan.hasNextInt()){
            for(int i =0; i<linha; i++){
                for(int j =0; j<coluna; j++){
                   grafo[i][j] = scan.nextInt();
                }
            }
        }
    }
    public void matadjacencia(){
        size =0;
        for(int i =0; i<Math.sqrt(grafo.length)+1; i++){
            for(int j =0; j<Math.sqrt(grafo.length)+1; j++){
                size++;
            }
        }
        adjacencia = new int[size][size];
        for(int i =0; i<Math.sqrt(grafo.length)+1; i++){
            for(int j =0; j<Math.sqrt(grafo.length)+1; j++){
               adjacencia[i][j] = 0;
            }
        }
        for(int i =0; i<linha; i++){
            adjacencia[grafo[i][0]][grafo[i][1]] = grafo[i][2];
        }
    }
    public void printvertice(){
      int vertice;
      System.out.println("Insira o vertice >= "+ (Math.sqrt(size)-1) + " sem o ponto decimal");
      vertice = in.nextInt();
        for(int i =0; i<Math.sqrt(grafo.length)+1; i++){
           if(i==vertice){
            System.out.print(i + " liga com ");
              for(int j =0; j<Math.sqrt(grafo.length)+1; j++){
                if(adjacencia[i][j] !=0){
                  System.out.print(j +", ");
                }
              }
            }
        }
        System.out.println();
    }
    public static void main(String[] args){
        seven read = new seven();
        read.open();
        read.readFile();
        read.matadjacencia();
        read.printvertice();
    }
}
