import java.util.*;


public class Challenges_485 {
    public static void main(String[] args) {
        int[][] dataArray = new int[10][10];    //char配列用意
        String result = "";
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N;j++){
                dataArray[i][j] = sc.nextInt();//値格納
            }
        }
        
        for(int i = 0; i < N; i++){
            long tmpSum = 0;
            boolean tmpResult = true;
            for(int j = 0; j < N;j++){
                if(dataArray[j][i] >= M){
                    tmpResult = false;
                }
            }
            if(tmpResult){
                if(result.equals("")){
                    result += (i+1);
                }else{
                    result += " " + (i+1);             
                }
            }
        }
        
        if(result.equals("")){
            System.out.println("wait");
        }else{
            System.out.println(result);        
        }

    }
}
