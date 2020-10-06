import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class two {
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
      System.err.print("Insira o nome do arquivo (l.txt): ");
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
  public void cidadeK(){
    int k;
    System.out.println("Insira a cidade K: ");
    k = in.nextInt();
    int entrada=0;
    int saida =0;
    for(int i=0; i<size; i++){
      if(mat[k][i] == 1 &&  i!=k){
        saida++;
      }
      if(mat[i][k] == 1 && i!=k){
        entrada++;
      }
    } 
    System.out.println("São "+ saida +" saidas da cidade "+ k);
    System.out.println("São "+ entrada +" entradas da cidade "+ k);
    System.out.println();
  }
  public void maiorNcidades(){
    int estrada;
    int aux=0;
    int index=0;
    for(int i=0; i<size; i++){
      estrada = 0;
      for(int j=0; j<size; j++){
        if(mat[i][j] == 1 && i!=j){
          estrada++;
        }
        if(mat[j][i] == 1 && i!=j){
          estrada++;
        }
        if(aux<estrada){
          aux = estrada;
          index=i;
        }
      }
    } 
    System.out.println("A cidade com mais estradas eh: "+index+" com  " +aux+" estradas");
    System.out.println();
  }
  public void maodubla(){
    for(int i=0; i<size; i++){
      for(int j=0; j<size; j++){
        if(mat[i][j] == 1 && mat[j][i]== 1 && i!=j){
          System.out.println("A cidade: "+i+" tem mao dubla com " +j);
        }
      }
    }
    System.out.println(); 
  }

  public void saidaK(){
    int k;
    System.out.print("Insira a cidade K para ver as cidades que possui saidas diretas: ");
    k = in.nextInt();
    for(int i=0; i<size; i++){
      if(mat[i][k] == 1 && i!=k ){
        System.out.println(i+" possui");
      }else{
        System.out.println(i+" nao possui");
      }
    }
    System.out.println();
  }
  public void isolada(){
    boolean cidade=true;
    for(int i=0; i<size; i++){
      cidade=true;
      for(int j=0; j<size; j++){
        if((mat[i][j] == 1 || mat[j][i]== 1) && i!=j){
          cidade = false;
        }
      }
      if(cidade){
        System.out.println("A cidade: "+i+" eh isolada");
      }else{
        System.out.println("A cidade: "+i+" NAO eh isolada");
      }
    }
    System.out.println();
  }
  public void naoSaida(){
    boolean cidade=true;
    for(int i=0; i<size; i++){
      cidade=true;
      for(int j=0; j<size; j++){
        if(mat[i][j] == 1 && i!=j){
          cidade = false;
        }
      }
      if(cidade){
        System.out.println("A cidade: "+i+" NAO tem saida");
      }else{
        System.out.println("A cidade: "+i+" tem saida");
      }
    }
    System.out.println();
  }
  public void naoEntrada(){
    boolean cidade=true;
    for(int i=0; i<size; i++){
      cidade=true;
      for(int j=0; j<size; j++){
        if(mat[j][i] == 1 && i!=j){
          cidade = false;
        }
      }
      if(cidade){
        System.out.println("A cidade: "+i+" NAO tem Entrada");
      }else{
        System.out.println("A cidade: "+i+" tem Entrada");
      }
    }
    System.out.println();
  }

  public void roteiro(){
    int[] vet = new int[size];
    boolean caminho = true;
    System.out.println("Insira o roteiro com "+(size)+" numeros sendo todos menores que " +size+": ");
    for(int i=0; i<size; i++){
      vet[i] = in.nextInt();
    }

    for(int i=1; i<size; i++){
      if(i==vet.length-2){
        if((mat[vet[i]][vet[i+1]]== 0)){
          caminho = false;
        }
      }
    }
    if(caminho){
      System.out.println("caminho possivel");
    }else{
      System.out.println("caminho impossivel");
    }
    System.out.println();
  }
  public int menorCaminho(int origem, int destino){
    int aux = origem;
    for(int i=0; i<size; i++){
      if(mat[aux][i] == 1){
        System.out.print((origem + " "));
        if(i== destino && aux == destino){
          System.out.print(destino);
          System.out.println(" certo");
          return 0;
        }
      }
    }

       if(aux<destino){
        return menorCaminho(aux+1, destino);
      }
      if(aux>destino){
        return menorCaminho(aux-1, destino);
      }
      if(aux== destino){
        return menorCaminho(aux, destino);
      }
    return 0;
  }
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    boolean op;
    /*System.out.println("Aqui estão todas as pergutas da questão 2\nQuer executar tudo ou escolher: 1 sim, 0 nao");*/
      two fun = new two();
      fun.open();
      fun.readFile();
      fun.cidadeK();
      fun.maiorNcidades();
      fun.maodubla();
      fun.saidaK();
      fun.isolada();
      fun.naoSaida();
      fun.naoEntrada();
      fun.roteiro();
      int origem;
      int destino;
      System.out.print("Insira cidade de origem: ");
      origem = in.nextInt();
      System.out.print("Insira cidade de detino: ");
      destino = in.nextInt();
      fun.menorCaminho(origem, destino);
  }
}