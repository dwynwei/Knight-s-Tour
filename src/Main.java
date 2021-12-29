import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        while(true){
            ChessUtil chessUtil = new ChessUtil();
            int[][] board = new int[8][8]; // Tahtayı oluştur Toplam 64 Kare
            String[][] chessArr = chessUtil.boardChess();
            int[] vert = {1,2,2,1,-1,-2,-2,-1}; // Atın olası hareketleri dikeyde
            int[] horz = {-2,-1,1,2,2,1,-1,-2}; // Atın olası hareketleri yatayda
            int counter;
            String input;
            input = chessUtil.inputPlease();
            int num1 = chessUtil.checkFChar(input);
            int num2 = chessUtil.checkSChar(input);
            board[num1][num2] = 1;
            counter = nextMove(board, vert, horz);
            writeMoves(board, counter);

        }

    }

    public static int nextMove(int[][] board, int[] xIndex, int[] yIndex) {
        int counter = 1;
        int cRow = 0;
        int cCol = 0;
        int mNum = 0;
        int bound = 8;
        Random random = new Random();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 1) {
                    cRow = i;
                    cCol = j;
                    break;
                }
            }
        }

        int move = board[cRow][cCol];

        do {
           /* mNum = random.nextInt(bound); // Kontrolü Yapılacak Bound ona göre verilecek !*/
            for(int i = 0; i<=7;i++){
                cRow += xIndex[i];
                cCol += yIndex[i];
                if (!(checkSafe(cRow, cCol, board))) {
                    cRow -= xIndex[i];
                    cCol -= yIndex[i];
                    counter--;
                }else {
                    move++;
                    board[cRow][cCol] = move;
                    i=0;
                }

                counter++;
            }

        } while (!(SafeOrNot(cRow, cCol, xIndex, yIndex, board)));

        return counter;
    }

    public static boolean SafeOrNot(int i, int j, int[] x, int[] y, int[][] board) { // Uğranan Nokta Kontrolü
        return (!(checkSafe(i+=x[0],j+=y[0],board)) &&
                !(checkSafe(i+=x[1],j+=y[1],board)) &&
                !(checkSafe(i+=x[2],j+=y[2],board)) &&
                !(checkSafe(i+=x[3],j+=y[3],board)) &&
                !(checkSafe(i+=x[4],j+=y[4],board)) &&
                !(checkSafe(i+=x[5],j+=y[5],board)) &&
                !(checkSafe(i+=x[6],j+=y[6],board)) &&
                !(checkSafe(i+=x[7],j+=y[7],board)));
    }

    public static boolean checkSafe(int x, int y, int[][] board)
    {
        return ((x >= 0) && (x < 8) && (y >= 0) && (y < 8) && (board[x][y] == 0)); // board[x][y] == 0 olunan yer daha önce gitmemiş olduğu bölgedir
    }

    public static void writeMoves(int[][] board, int count) {
        ChessUtil chessUtil = new ChessUtil();

        int move = 1;
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                if(board[i][j]==move) {
                    System.out.print(Arrays.toString(new String[]{chessUtil.boardChess()[i][j]})+" --> ");
                    move++;
                    i=0;
                    j=0;
                }
            }
        }
        if (count == 64) {
            System.out.println(count + " Adımda Bitti. BAŞARILI !");
        } else {
            System.out.println(count + " Adımda Bitti. BAŞARISIZ !");
        }

    }

}
