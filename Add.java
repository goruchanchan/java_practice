import java.util.*;
import java.lang.*;
 
public class Add {
  public static void main(String[] args ) throws Exception {
    Scanner sc = new Scanner(System.in);
    int N = 2;
    int sum = 0;
    
    //データ格納
    for (int i = 0; i < N; i++) {
        sum += sc.nextInt();
    }
    //データ出力
    System.out.println(sum);
  }
}
