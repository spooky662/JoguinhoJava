public class Main {
    public static void mesa(String[][] matrix){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if(matrix[i][j] != ".") {
                    System.out.print("[ " + "\u001B[36m" + matrix[i][j] + "\u001B[0m" + " ]");
                } else {
                    System.out.print("[ " + matrix[i][j] + " ]");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        String[][] tabuleiro = new String[10][10];
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                tabuleiro[i][j] = ".";
            }
        }

        mesa(tabuleiro);
        System.out.println();

        Personagem personagem1 = new Personagem(3, 5, "X");
        tabuleiro[personagem1.posx][personagem1.posy] = personagem1.desenho;

        Personagem personagem2 = new Personagem(4, 5, "0");
        tabuleiro[personagem2.posx][personagem2.posy] = personagem2.desenho;

        mesa(tabuleiro);
    }
}
