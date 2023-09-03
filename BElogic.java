import java.util.Scanner;

public class BElogic {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[][] tabuleiro = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
        };
        
        System.out.println("Bem vindo Jogador! Para jogar, primeiro selecione se você quer X ou O");

        char jogador1 = in.next().toUpperCase().charAt(0);
        char jogador2 = (jogador1 == 'X') ? 'O' : 'X';

        System.out.println("Perfeito! Vamos começar, escolha uma posição:");
        System.out.println("   A   B   C");  //linha das letras das colunas
        for (int i = 0; i < 3; i++) {
            System.out.print(i + 1);  //número da linha
            for (int j = 0; j < 3; j++) {
                System.out.print(" " + tabuleiro[i][j]);
                if (j < 2) {
                    System.out.print(" |");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("  --+---+--");
            }
        }
        
        while (true) {
            System.out.println("Vez do jogador " + jogador1 + ". Digite a posição onde deseja colocar " + jogador1 + " (por exemplo, A1, B2, C3):");
            String posicao = in.next().toUpperCase();
            int linha = posicao.charAt(1) - '1';
            int coluna = posicao.charAt(0) - 'A';
            
            if (linha >= 0 && linha < 3 && coluna >= 0 && coluna < 3 && tabuleiro[linha][coluna] == ' ') {
                tabuleiro[linha][coluna] = jogador1;
            } else {
                System.out.println("Posição inválida ou ocupada. Tente novamente.");
                continue;
            }

            //imprime o tabuleiro atualizado
            imprimirTabuleiro(tabuleiro);

            //verifica vitória ou empate
            if (verificarVitoria(tabuleiro, jogador1)) {
                System.out.println("Jogador " + jogador1 + " venceu!");
                break;
            } else if (verificarEmpate(tabuleiro)) {
                System.out.println("Empate!");
                break;
            }

            System.out.println("Vez do jogador " + jogador2 + ". Digite a posição onde deseja colocar " + jogador2 + ":");
            posicao = in.next().toUpperCase();
            linha = posicao.charAt(1) - '1';
            coluna = posicao.charAt(0) - 'A';
            
            if (linha >= 0 && linha < 3 && coluna >= 0 && coluna < 3 && tabuleiro[linha][coluna] == ' ') {
                tabuleiro[linha][coluna] = jogador2;
            } else {
                System.out.println("Posição inválida ou ocupada. Tente novamente.");
                continue;
            }

            //imprime o tabuleiro atualizado
            imprimirTabuleiro(tabuleiro);

            //verifica vitória ou empate
            if (verificarVitoria(tabuleiro, jogador2)) {
                System.out.println("Jogador " + jogador2 + " venceu!");
                break;
            } else if (verificarEmpate(tabuleiro)) {
                System.out.println("Empate!");
                break;
            }
        }
    }

    //função pra imprimir
    public static void imprimirTabuleiro(char[][] tabuleiro) {
        System.out.println("   A   B   C");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + 1);
            for (int j = 0; j < 3; j++) {
                System.out.print(" " + tabuleiro[i][j]);
                if (j < 2) {
                    System.out.print(" |");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("  --+---+--");
            }
        }
    }

    // função vitoria
    public static boolean verificarVitoria(char[][] tabuleiro, char jogador) {
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[i][0] == jogador && tabuleiro[i][1] == jogador && tabuleiro[i][2] == jogador) {
                return true;  //linhas
            }
            if (tabuleiro[0][i] == jogador && tabuleiro[1][i] == jogador && tabuleiro[2][i] == jogador) {
                return true;  //colunas
            }
        }
        if (tabuleiro[0][0] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][2] == jogador) {
            return true;  //diagonal 1
        }
        if (tabuleiro[0][2] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][0] == jogador) {
            return true;  //diagonal 2
        }
        return false;
    }

    //verificar empate
    public static boolean verificarEmpate(char[][] tabuleiro) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tabuleiro[i][j] == ' ') {
                    return false;  
                }
            }
        }
        return true;  
    }
}
//Desenvolvido por: Emanuel Isaac Moura Martins.*.