import java.util.*;

public class Tic_tac_toe_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean resultBatsu = false;    //☓用結果
        boolean resultMaru = false;     //O用結果
        char result;                    //最終結果
        char[][] dataArray = new char[5][5];   //char配列用意
        
        for(int i = 0; i < 5; i++){
            String line = sc.nextLine();    //入力
            for(int j = 0;j < line.length(); j++){
                dataArray[i][j] = line.charAt(j);
            }
        }   
        
        //五目判定
        resultMaru = gomokuJudge(dataArray , 'O');
        resultBatsu = gomokuJudge(dataArray , 'X');

        //判定
        if(resultMaru){
            result = 'O';
        }else if(resultBatsu){
            result = 'X';
        }else{
            result = 'D';
        }
        System.out.println(result);
    }
    
    //行成分の五目判定    
    public static boolean gomokuJudge(char[][] data , char target) {
        int tmpCntTarget = 0;                   //O or ☓の数
        boolean result = false;                 //結果

        //行成分の五目判定
        for(int i = 0;i < 5&&result!=true; i++){
            tmpCntTarget = 0;
            for(int j = 0; j < 5; j++){
                if(data[i][j] == target){       //一文字ずつチェック
                    tmpCntTarget++;
                    if(tmpCntTarget == 5)
                    {
                        result = true;
                        break;
                    }
                }
            }
        }
        
        //列成分の五目判定
        for(int i = 0;i < 5&&result!=true; i++){
            tmpCntTarget = 0;
            for(int j = 0; j < 5; j++){
                if(data[j][i] == target){       //一文字ずつチェック
                    tmpCntTarget++;
                    if(tmpCntTarget == 5)
                    {
                        result = true;
                        break;
                    }
                }
            }
        }

        //対角成分(左上から右下)の五目判定
        tmpCntTarget = 0;
        for(int i = 0;i < 5; i++){
            if(data[i][i] == target){       //一文字ずつチェック
                tmpCntTarget++;
                if(tmpCntTarget == 5)
                {
                    result = true;
                    break;
                }
            }
        }
        
        //対角成分(右上から左下)の五目判定
        tmpCntTarget = 0;
        for(int i = 0;i < 5; i++){
            if(data[i][4-i] == target){       //一文字ずつチェック
                tmpCntTarget++;
                if(tmpCntTarget == 5)
                {
                    result = true;
                    break;
                }
            }
        }


        return(result);
    }

}
