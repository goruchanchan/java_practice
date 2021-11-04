import java.util.*;
import java.lang.*;
 
public class Tic_tac_toe_0{
  public static void main(String[] args ) throws Exception {
    Scanner sc = new Scanner(System.in);//scanner用意
    ArrayList<String> column = new ArrayList<String>();//List用意
    //データ格納
    for (int i = 0; i < 5; i++) {
        column.add(sc.next());
    }
    //データ出力
    for (String data : column) {
        System.out.println(data);
    }
  }
}
