import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class six {

    String dirname = "../text/";
    int size;
    Scanner scan = new Scanner(System.in);
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
        for(int i =0; i<Math.sqrt(grafo.length); i++){
            for(int j =0; j<Math.sqrt(grafo.length); j++){
                size++;
            }
        }
        adjacencia = new int[size][size];
        for(int i =0; i<Math.sqrt(grafo.length); i++){
            for(int j =0; j<Math.sqrt(grafo.length); j++){
               adjacencia[i][j] = 0;
            }
        }
        for(int i =0; i<linha; i++){
            adjacencia[grafo[i][0]][grafo[i][1]] = grafo[i][2];
        }
    }
    public void printAdjacencia(){
        System.out.println();
        System.out.println("Matriz de adjacencia");
        for(int i =0; i<Math.sqrt(grafo.length); i++){
            System.out.println();
            for(int j =0; j<Math.sqrt(grafo.length); j++){
               System.out.print(adjacencia[i][j] + " ");
            }
        }
        System.out.println();
    }
    public void printFile(){
        System.out.println("Aquivo txt");
        for(int i =0; i<linha; i++){
            System.out.println();
            for(int j =0; j<coluna; j++){
                System.out.print(grafo[i][j] + " ");
            }
        }
        System.out.println();
    }
    public void grauDosVertices(){
        int soma = 0;
        System.out.println("grau dos vertices");
        for(int i =0; i<Math.sqrt(grafo.length); i++){
            for(int j =0; j<Math.sqrt(grafo.length); j++){
                soma = adjacencia[i][j] + soma;
            }
            System.out.println(" grau vertice " + i + ": " + soma);
            soma =0;
        }
    }
    public static void main(String[] args){
        six read = new six();
        read.open();
        read.readFile();
        read.printFile();
        read.matadjacencia();
        read.printAdjacencia();
        read.grauDosVertices();
    }
}
