public class Main {
    public static void mesa(String[][] matrix){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if(matrix[i][j] == "X") {
                    System.out.print("[ " + "\u001B[36m" + matrix[i][j] + "\u001B[0m" + " ]");
                } else if (matrix[i][j] == "0"){
                    System.out.print("[ " + "\u001B[35m" + matrix[i][j] + "\u001B[0m" + " ]");
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

        Player hero = new Player(3, 5, "X");
        tabuleiro[hero.posx][hero.posy] = hero.desenho;

        Inimigo enemy = new Inimigo(4, 5, "0");
        tabuleiro[enemy.posx][enemy.posy] = enemy.desenho;

        mesa(tabuleiro);
    }
}
