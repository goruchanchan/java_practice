import java.util.*;
import java.lang.*;

public class Sort {
    public static void main(String[] args ) throws Exception {
        Scanner sc = new Scanner(System.in);//scanner用意
        int N = sc.nextInt();//一文字文リード
        
        ArrayList<Integer> column = new ArrayList<Integer>();//List用意
        //データ格納
        for (int i = 0; i < N; i++) {
            column.add(sc.nextInt());
        }
        //並び替え
        for (int i = 0; i < column.size(); i++)
        {
            for (int j = 0;j < column.size() - 1 ; j++) {
                int tmp;
                if( column.get(j) > column.get(j+1)){
                    tmp = column.get(j);
                    column.set(j,column.get(j+1));
                    column.set(j+1,tmp);
                }
            }
        }
        System.out.println("---------------result---------------");
        //データ出力
        for (int data : column) {
            System.out.println(data);
        }
    }
}
