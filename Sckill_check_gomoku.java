import java.util.*;

public class Sckill_check_gomoku {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();                   //目の数
        int S = sc.nextInt();                   //先手(0:黒)or後手(1:白)

        String winResult = "";                  //勝ち用結果
        String loseResult = "";                 //負け用結果
        int[][] dataArray = new int[20][20];    //char配列用意
        int[]   analyArray = new int[20];       //char配列用意

        String result  = "";                    //途中結果格納用
        int tmpResult[] = {-1,0};               //正解位置格納用

        //入力配列へ代入
        for(int i = 0; i < N; i++){
            for(int j = 0;j < N; j++){
                dataArray[i][j] = sc.nextInt();
            }
        }   
        
      //勝ち手あるかの確認
        //行成分
        for(int i = 0; i< N;i++){
            Arrays.fill(analyArray,-1);
            for(int j = 0;j < N;j++){
                analyArray[j] = dataArray[i][j];                
            }
            tmpResult = gomokuCheck(analyArray,S,N);
            if(tmpResult[0] != -1){
                result = (i+1) + " " + (tmpResult[0]);
                break;
            }
        }

        //列成分
        if(result.equals("")){
            for(int i = 0; i< N;i++){
                Arrays.fill(analyArray,-1);
                for(int j = 0;j < N;j++){
                    analyArray[j] = dataArray[j][i];                
                }
                tmpResult = gomokuCheck(analyArray,S,N);
                if(tmpResult[0] != -1){
                    result = (tmpResult[0]) + " " + (i+1);            
                    break;
                }
            }
        }

        //対角成分
        if(result.equals("")){
            //左上から対角まで
            for( int k = 0 ; k < N ; k++ ) {
                Arrays.fill(analyArray,-1);
                for( int j = 0 ; j <= k ; j++ ) {
                    int i = k - j;
                    analyArray[j] = dataArray[i][j];
                }
                if(k > 4){
                    tmpResult = gomokuCheck(analyArray,S,N);
                    if(tmpResult[0] != -1){
                        result = (k-(tmpResult[0]-1)+1) + " " + (0+(tmpResult[0]-1)+1);
                    }
                }
            }
            //対角から右下まで
            for( int k = N - 2 ; k >= 0 ; k-- ) {
                Arrays.fill(analyArray,-1);
                for( int j = 0 ; j <= k ; j++ ) {
                    int i = k - j;
                    analyArray[j] = dataArray[N-j-1][N-i-1];
                }
                tmpResult = gomokuCheck(analyArray,S,N);
                if(k >= 4){
                    if(tmpResult[0] != -1 ){
                        result = (N-(tmpResult[0]-1)) + " " + ((N-k)+(tmpResult[0]-1));
                    }
                }
            }
            //右上から対角まで
            for( int k = 0 ; k < N ; k++ ) {
                Arrays.fill(analyArray,-1);
                for( int j = 0 ; j <= k ; j++ ) {
                    int i = k - j;
                    analyArray[j] = dataArray[i][N-j-1];
                }
                if(k >= 4){
                    tmpResult = gomokuCheck(analyArray,S,N);
                    if(tmpResult[0] != -1 ){
                        result = (k+1-tmpResult[0]+1) + " " + ((N)-(tmpResult[0])+1);
                    }
                }
            }
             //対角から左下まで
            for( int k = N - 2 ; k >= 0 ; k-- ) {
                Arrays.fill(analyArray,-1);
                for( int j = 0 ; j <= k ; j++ ) {
                    int i = k - j;
                    analyArray[j] = dataArray[N-j-1][i];
                }
                if(k >= 4){
                    tmpResult = gomokuCheck(analyArray,S,N);
                    if(tmpResult[0] != -1 ){
                        result = (N-(tmpResult[0]-1)) + " " + ((N-k)-(tmpResult[0]-1)+1);
                    }
                }
            }
        }

        //勝ち手あるなら出力して終了
        if(!result.equals("")){
            //反対になっているので反転
            StringBuilder resultreverse = new StringBuilder(result);
            winResult = resultreverse.reverse().toString();
            System.out.println( winResult );
        }
        //勝ち手ないなら負け手があるかを確認
        else{
            result = "";
            int patternNum=0;//負け手となる数
            //行成分
            for(int i = 0; i< N;i++){
                Arrays.fill(analyArray,-1);
                for(int j = 0;j < N;j++){
                    analyArray[j] = dataArray[i][j];                
                }
                tmpResult = gomokuCheck(analyArray,1-S,N);
                if(tmpResult[0] != -1){
                    patternNum = patternNum + tmpResult[1];
                    result = (i+1) + " " + (tmpResult[0]+1);
                    break;
                }
            }
            //列成分
            if(result.equals("")){
                for(int i = 0; i< N;i++){
                    Arrays.fill(analyArray,-1);
                    for(int j = 0;j < N;j++){
                        analyArray[j] = dataArray[j][i];                
                    }                 
                    tmpResult = gomokuCheck(analyArray,1-S,N);
                    if(tmpResult[0] != -1){
                        patternNum = patternNum + tmpResult[1];
                        result = (tmpResult[0]+1) + " " + (i+1);            
                        break;
                    }
                    
                }
            }
            //対角成分
            //左上から対角まで
            for( int k = 0 ; k < N ; k++ ) {
                Arrays.fill(analyArray,-1);
                for( int j = 0 ; j <= k ; j++ ) {
                    int i = k - j;
                    analyArray[j] = dataArray[i][j];
                }
                if(k > 4){
                    tmpResult = gomokuCheck(analyArray,1-S,N);
                    if(tmpResult[0] != -1){
                        patternNum = patternNum + tmpResult[1];
                        result = (k-(tmpResult[0]-1)+1) + " " + (0+(tmpResult[0]-1)+1);
                    }
                }
            }
            //対角から右下まで
            for( int k = N - 2 ; k >= 0 ; k-- ) {
                Arrays.fill(analyArray,-1);
                for( int j = 0 ; j <= k ; j++ ) {
                    int i = k - j;
                    analyArray[j] = dataArray[N-j-1][N-i-1];
                }
                tmpResult = gomokuCheck(analyArray,1-S,N);
                if(k >= 4){
                    if(tmpResult[0] != -1 ){
                        patternNum = patternNum + tmpResult[1];
                        result = (N-(tmpResult[0]-1)) + " " + ((N-k)+(tmpResult[0]-1));
                    }
                }
            }
            //右上から対角まで
            for( int k = 0 ; k < N ; k++ ) {
                Arrays.fill(analyArray,-1);
                for( int j = 0 ; j <= k ; j++ ) {
                    int i = k - j;
                    analyArray[j] = dataArray[i][N-j-1];
                }
                if(k >= 4){
                    tmpResult = gomokuCheck(analyArray,1-S,N);
                    if(tmpResult[0] != -1 ){
                        patternNum = patternNum + tmpResult[1];
                        result = (k+1-tmpResult[0]+1) + " " + ((N)-(tmpResult[0])+1);
                    }
                }
            }
            //対角から左下まで
            for( int k = N - 2 ; k >= 0 ; k-- ) {
                Arrays.fill(analyArray,-1);
                for( int j = 0 ; j <= k ; j++ ) {
                    int i = k - j;
                    analyArray[j] = dataArray[N-j-1][i];
                }
                if(k >= 4){
                    tmpResult = gomokuCheck(analyArray,1-S,N);
                    if(tmpResult[0] != -1 ){
                        patternNum++;
                        result = (N-(tmpResult[0]-1)) + " " + ((N-k)-(tmpResult[0]-1)+1);
                    }
                }
            }

            if(patternNum==0){
            //勝ち負け決まらないときは、適当な手を探す
                for(int i=0;i<N-1;i++){
                    for(int j=0;j<N-1;j++){
                        if(dataArray[i][j]==(S))
                        {
                            if(dataArray[i+1][j] == -1){
                                loseResult = (i+1+1) + " " + (j+1);
                            }else if(dataArray[i][j+1] == -1){
                                loseResult = (i+1) + " " + (j+1+1);
                            }else if(dataArray[i+1][j+1] == -1){
                                loseResult = (i+1+1) + " " + (j+1+1);
                            }
                            //反対になっているので反転
                            StringBuilder resultreverse = new StringBuilder(loseResult);
                            loseResult = resultreverse.reverse().toString();
                        }
                    }
                }            
            }else if(patternNum == 1){
                loseResult = result;
                //反対になっているので反転
                StringBuilder resultreverse = new StringBuilder(loseResult);
                loseResult = resultreverse.reverse().toString();
            }else{
                loseResult = "LOSE";
            }
            System.out.println(loseResult);           
        }      
    }
                 
    //五目判定
    public static int[] gomokuCheck(int[] analyArray, int target,int N) {

        int result[] = {-1,0};//一個目：正解の位置、二個目：正解の数
        int tmpCnt = 0;
        
        for(int j = 0;j < N;j++){
            if(analyArray[j] == target){
                tmpCnt++;
            }else if(analyArray[j] == (1-target) || analyArray[j] == -1 ){
                tmpCnt = 0;
            }

            if(tmpCnt == 4){
                //左側空きチェック
                if((j-4)>=0){
                    if(analyArray[j-4] == -1){
                        result[0] = j-4+1;
                        result[1]++;
                    }
                }
                //右側空きチェック
                if((j+1)<N){
                    if(analyArray[j+1] == -1){
                        result[0] = j+1+1;
                        result[1]++;
                    }
                }
            }
        }
        return(result);
    }
}
