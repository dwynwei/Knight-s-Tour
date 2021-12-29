import java.util.Arrays;
import java.util.Scanner;

public class ChessUtil {

    public String inputPlease(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Lütfen At'ı yerleştirmek İstediğiniz Yeri Belirleyiniz ! : ");
        String str = scan.nextLine();
        str = str.trim();
        str = str.replace(" ","");
        return str;
    }

    public boolean isContain(String str, String[][] board){
        for(int i = 0; i< board.length;i++){
            for(int j = 0; j< board[i].length;j++){
                if(str.equals(board[i][j])){
                    return true;
                }else{
                    return false;
                }
            }
        }
        return false;
    }

    public Integer checkFChar(String str){
        char fChar,sChar;
        fChar = str.charAt(0);
        if(fChar == 'A'){
            return 0;
        }else if(fChar == 'B'){
            return 1;
        }else if(fChar == 'C'){
            return 2;
        }else if(fChar == 'D'){
            return 3;
        }else if(fChar == 'E'){
            return 4;
        }else if(fChar == 'F'){
            return 5;
        }else if(fChar == 'G'){
            return 6;
        }else if(fChar == 'H'){
            return 7;
        }else{
            return null;
        }

    }

    public Integer checkSChar(String str){
        char sChar = str.charAt(1);

        if(sChar == '1'){
            return 0;
        }else if(sChar == '2'){
            return 1;
        }else if(sChar == '3'){
            return 2;
        }else if(sChar == '4'){
            return 3;
        }else if(sChar == '5'){
            return 4;
        }else if(sChar == '6'){
            return 5;
        }else if(sChar == '7'){
            return 6;
        }else if(sChar == '8'){
            return 7;
        }else{
            return null;
        }
    }

    public String[][] boardChess(){
        char rows = 'A';
        int indx = 1;
        int col;
        String[][] strArr = new String[8][8];
        Integer[][] grid = new Integer[8][8];
        for(int i = 0 ; i<strArr.length; i++,rows++){
            for(col = 1; col<=strArr[i].length;col++,indx++){
                strArr[i][indx-1]=String.valueOf(rows)+String.valueOf(col);
            }
            indx=1;
        }
        return strArr;
    }

}
