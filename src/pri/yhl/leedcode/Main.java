package pri.yhl.leedcode;

///**
// * Created by yhl on 2016/8/22.
// */
//public class Main {
//}
//import java.util.Scanner;
//public class Main {
//    public static  void main(String args[]) {
//        Scanner in = new Scanner(System.in);
//        int n = 0;
//        while (in.hasNext()&&(n=in.nextInt())!=0) {//注意while处理多个case
//            int time = 0;
//            while(n>2){
//                int m = n/3;
//                time += m;
//                n -=3*m;
//                n+=m;
//            }
//            if(n==2){ time++;}
//            System.out.println(time);
//        }
//    }
//}
//import java.util.*;
//
//public class Main {
//    public static  void main(String args[]) {
//        Scanner in = new Scanner(System.in);
//        int n=0;
//        while(in.hasNext()){
//            if(in.hasNext())n=in.nextInt();
//            int i = 0;
//            Map<Integer,Integer>  map = new TreeMap<Integer,Integer>();
//            while (i<n) {//注意while处理多个case
//                int m = in.hasNext() ? in.nextInt():0;
//                map.put(m,1);
//                i++;
//            }
//            for(Map.Entry<Integer,Integer> entry:map.entrySet()){
//                System.out.println(entry.getKey());
//            }
//        }
//
//    }
//}
import java.util.*;

public class Main {
    public static  void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String str;
        while(in.hasNext()){
            str=in.next();
            int res = 0;
            int index = 0;
            for(int i=str.length()-1;i>=0;i--){
                char ele = str.charAt(i);
                if ( ele == 'x'){
                    break;
                }
                else if (ele < 'A'){
                    res += (int)(ele - '0')*Math.pow(16,index);
                }else{
                    int intOfIndex = ele - 'A'+10;
                    res +=(int)intOfIndex*Math.pow(16,index);
                }
                index++;
            }
            System.out.println(res);
        }

    }
}