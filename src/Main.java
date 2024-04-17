public class Main {
    public static void mesa(String[][] matrix){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print("[ " + matrix[i][j] + " ]");
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

        Personagem personagem1 = new Personagem(3, 5, "<3");
        tabuleiro[personagem1.posx][personagem1.posy] = personagem1.desenho;

        mesa(tabuleiro);
    }
}