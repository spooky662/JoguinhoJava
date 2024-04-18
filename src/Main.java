import java.util.Scanner;

public class Main {
    public static void mesa(Personagem[][] matrix){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if(matrix[i][j].desenho == "X") {
                    System.out.print("[ " + "\u001B[36m" + matrix[i][j] + "\u001B[0m" + " ]");
                } else if (matrix[i][j].desenho == "0"){
                    System.out.print("[ " + "\u001B[35m" + matrix[i][j] + "\u001B[0m" + " ]");
                } else {
                    System.out.print("[ " + matrix[i][j] + " ]");
                }
            }
            System.out.println();
        }
    }

    public static void norte(Personagem[][] matrix, int i, int j){
        String aux;
        aux = matrix[i-1][j].desenho;
        matrix[i-1][j].desenho = matrix[i][j].desenho;
        matrix[i][j].desenho = aux;
    }

    public static void sul(Personagem[][] matrix, int i, int j){
        String aux;
        aux = matrix[i+1][j].desenho;
        matrix[i+1][j].desenho = matrix[i][j].desenho;
        matrix[i][j].desenho = aux;
    }

    public static void leste(Personagem[][] matrix, int i, int j){
        String aux;
        aux = matrix[i][j+1].desenho;
        matrix[i][j+1].desenho = matrix[i][j].desenho;
        matrix[i][j].desenho = aux;
    }

    public static void oeste(Personagem[][] matrix, int i, int j){
        String aux;
        aux = matrix[i][j-1].desenho;
        matrix[i][j-1].desenho = matrix[i][j].desenho;
        matrix[i][j].desenho = aux;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Personagem[][] tabuleiro = new Personagem[10][10];
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                tabuleiro[i][j] = new Personagem(i, j, ".");
            }
        }

        mesa(tabuleiro);
        System.out.println();

        Player hero = new Player(3, 5, "X");
        tabuleiro[hero.posx][hero.posy] = hero;

        Inimigo enemy = new Inimigo(4, 5, "0");
        tabuleiro[enemy.posx][enemy.posy] = enemy;

        mesa(tabuleiro);

        // mover personagem
        char esc = 's';
        System.out.println("Mover o personagem?");
        esc = sc.next().charAt(0);
        if(esc == 's'){
            do{
                System.out.println("Direção: ");
                System.out.println("1- norte");
                System.out.println("2- leste");
                System.out.println("3- sul");
                System.out.println("4- oeste");
                int esc2 = sc.nextInt();
                switch (esc2){
                    case 1:
                        norte(tabuleiro, hero.posx, hero.posy);
                        hero.posx -= 1;
                        break;
                    case 2:
                        leste(tabuleiro, hero.posx, hero.posy);
                        hero.posy += 1;
                        break;
                    case 3:
                        sul(tabuleiro, hero.posx, hero.posy);
                        hero.posx += 1;
                        break;
                    case 4:
                        oeste(tabuleiro, hero.posx, hero.posy);
                        hero.posy -= 1;
                        break;
                    default:
                        break;
                }
                mesa(tabuleiro);
                System.out.println("Mover o personagem?");
                esc = sc.next().charAt(0);
            }while(esc == 's');
        }

        sc.close();
    }
}
