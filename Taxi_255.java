import java.util.*;
import java.lang.*;
 
public class Taxi_255{
  public static void main(String[] args ) throws Exception {
    Scanner sc = new Scanner(System.in);//scanner用意
    int N = 0;
    int distance = 0;
    int min = 5001;
    int max = 0;
    
    N = sc.nextInt();//台数
    distance = sc.nextInt();//移動距離

    for(int i = 0; i < N ;i++){
        int tmpValue=0;
        int firstDis = sc.nextInt();
        int firstVal = sc.nextInt();
        int addDis = sc.nextInt();
        int addVal = sc.nextInt();
        
        if(distance < firstDis){
            tmpValue = firstVal;
        }
        else{
            tmpValue = firstVal + (((distance - firstDis)/addDis)+1) * addVal;

        }
        
        if(tmpValue < min){
            min = tmpValue;
        }
        if(tmpValue > max){
            max = tmpValue;
        }
    }
    
    System.out.println(min+" "+max);
 }
}
