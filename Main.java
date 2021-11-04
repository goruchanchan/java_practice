import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args ) throws Exception {
        Scanner sc = new Scanner(System.in);//scanner用意
        int N = sc.nextInt();//一文字文リード
        
        ArrayList<String> column = new ArrayList<String>();//List用意
        //データ格納
        for (int i = 0; i < N; i++) {
            column.add(sc.next());
        }
        //データ出力
        for (String data : column) {
            System.out.println(data);
        }

    }
}
