import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class App {
    String dirname = "../text/"; // camiho do txt
    Scanner scan = new Scanner(System.in);
    Scanner in = new Scanner(System.in);

    int coluna;
    int linha;
    float[][] A; // Matriz A
    float[] vetSolu;
    String tipo = "MAX";
    float z; // Resultado do Custo

    // abrir o arquivo
    public void open() {
        boolean ok = true;
        String name;
        do {
            System.err.print("Insira o nome do arquivo (exTrabalho.txt, exMatusalem.txt, exAulaSimples.txt): ");
            name = in.next();
            try {
                scan = new Scanner(new File(dirname + name));
                ok = false;
            } catch (FileNotFoundException fileNotFoundException) {
                System.err.println("erro");
            }
        } while (ok);
    }

    // ler o arquivo
    public void readFile() {
        linha = scan.nextInt();
        coluna = scan.nextInt();
        A = new float[linha][coluna];
        while (scan.hasNextInt()) {
            for (int i = 0; i < linha; i++) {
                for (int j = 0; j < coluna; j++) {
                    A[i][j] = scan.nextFloat();
                }
            }
            tipo = scan.next().toString();

        }
        if(tipo.equals("MIN")){
            for (int i = 0; i < coluna; i++) {
                A[A.length-1][i] =  A[A.length-1][i]*-1;
                System.out.println(" Cadê MIN");
            }
        }
        
    }

    // verificar se a loção é ótima
    private boolean verOtima() {
        for (int j = 0; j < coluna; j++) {
            if (A[A.length - 1][j] > 0) {
                return true;
            }
        }
        return false;
    }

    // selecionar a coluna do maior custo e retornar o index dela
    private int selecColunaIndexMaiorCusto() {
        float maiorCusto = A[A.length - 1][0];
        int index = 0;
        for (int j = 0; j < (coluna); j++) {
            if (maiorCusto < A[A.length - 1][j]) {
                maiorCusto = A[A.length - 1][j];
                index = j;
            } 
        }
        return index;
    }

    // seleciona a linha do pivo
    private int seletcLinhaPivo() {
        int index = selecColunaIndexMaiorCusto();
        float[] vet = new float[linha - 1];
        for (int i = 0; i < linha - 1; i++) {
            vet[i] = (int) A[i][coluna - 1] / A[i][index];
        }

        float menor = 1000000000;
        int indice = 0;

        for (int j = 0; j < vet.length; j++) {
            if ((vet[j] > 0) && (menor > vet[j])) {
                menor = vet[j];
                indice = j;
            }
        }
        return indice;
    }

    // escalona a martriz, mostra o passo a passo
    private void escalonar() {
        int colunaP = selecColunaIndexMaiorCusto();
        int linhaP = seletcLinhaPivo();

        float pivo = A[linhaP][colunaP];
        float numberMudar;

        System.out.println();
        System.out.println("Pivo: " + pivo);

        for (int i = 0; i < coluna; i++) {
            if (pivo != 0) {
                A[linhaP][i] = A[linhaP][i] / pivo;
            }
        }
        System.out.println("Expresão matematica: 1/" + pivo + "*LinhaDoPivo -> LinhaDoPivo");
        pivo = A[linhaP][colunaP];
        for (int i = 0; i < linha; i++) {
            numberMudar = A[i][colunaP];
            if (i != linhaP) {
                System.out.println("Expresão matematica: (" + pivo + "*L" + i + ") - (" + numberMudar + "*L" + linhaP
                        + ") -> L" + i);
            }
            if (i != linhaP) {
                for (int j = 0; j < coluna; j++) {
                    A[i][j] = (pivo * A[i][j]) - (numberMudar * A[linhaP][j]);
                }
            }
        }
    }

    private void mostrarSolucao() {
        System.out.println("\nSolução");
        float soma;
        int index = 0;
        vetSolu = new float[linha];
        for (int i = 0; i < linha; i++) {
            vetSolu[i] = A[i][coluna - 1];
        }

        for (int j = 0; j < coluna - 1; j++) {
            soma = 0;
            for (int i = 0; i < linha; i++) {
                soma += A[i][j];
            }

            if (soma == 1) {
                for (int i = 0; i < linha; i++) {
                    if (A[i][j] == 1) {
                        index = i;
                    }
                }
                System.out.println("Nao basica x" + (j + 1) + " = " + A[index][coluna - 1]);
            } else {
                System.out.println("Basica x" + (j + 1) + " = 0");
            }
        }
        if(tipo.equals("MIN")){
            System.out.println("Z = " + A[linha - 1][coluna - 1]);
        }else{
            System.out.println("Z = " + -1*A[linha - 1][coluna - 1]);
        }
        System.out.println("\n\t*******Tales*******\n");
    }

    public void solucionar() {
        while (verOtima()) { // Enquanto não tiver solução otima ele escalona
            escalonar();
            printMat();
        }
        mostrarSolucao();
    }

    public void printMat() {
        System.out.println();
        for (int i = 0; i < linha; i++) {
            System.out.println();
            for (int j = 0; j < coluna; j++) {
                System.out.print(A[i][j] + "\t");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println(
                "Voce pode inserir seu proprio arquivo txt,\ndentro da pasta text, no entato ele terar que segir\n"
                        + " o padrão: n° linhas n° colunas, matriz A, as variaveis básica e vetor B e C e MAX/MIN\n\n"
                        + "n°Linhas n°colunas\nA A A 1 0 0 B\nA A A 0 1 0 B\nA A A 0 0 1 B\nC C C 0 0 0 0\nMAX/MIN\n\n"
                        + "Exemplo:\n4 7\n1 2 3 1 0 0 15\n4 5 6 0 1 0 20\n7 8 9 0 0 1 30\n50 60 20 0 0 0 0\nMAX");
        App app = new App();
        app.open();
        app.readFile();
        app.solucionar();
    }
}
