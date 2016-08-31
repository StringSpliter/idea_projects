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
//            map.size();
//            int [] a = new  int[10];
//            while (i<n) {//注意while处理多个case
//                int m = in.hasNext() ? in.nextInt():0;
//                map.put(m,1);
//                i++;
//            }
//            for(Map.Entry<Integer,Integer> entry:map.entrySet()){
//                System.out.println(entry.getKey());
//                entry.getValue()
//            }
//        }
//
//    }
//}
//import java.util.*;
//
//public class Main {
//    public static  void main(String args[]) {
//        int [] arr = {1,2,3,4,1};
//        TreeMap<Integer,Integer> map = new TreeMap<Integer,Integer>();
//
//        for(int i=0;i<arr.length;i++){
//            for(int j=arr.length-1;j>i;j--){
//                if(arr[j]>arr[j-1]){
//                    int tmp = arr[j];
//                    arr[j] = arr[j-1];
//                    arr[j-1] = tmp;
//                }
//                con
//            }
//        }
//
//        int curTime = 0;
//        int curN = arr[0];
//        for(int i=0;i<arr.length;i++){
//            if(curN == arr[i]){
//                curTime++;
//            }else{
//                map.put(curN,curTime);
//                curN = arr[i];
//                curTime = 1;
//            }
//        }
//        map.put(curN,curTime);
//        int keyL = map.size();
//        int[] arrKey = new int[keyL];
//        int[] times = new int[keyL];
//        int it = 0;
//        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
//            arrKey[it] = entry.getKey();
//            times[it] = entry.getValue();
//            it++;
//        }
//        for(int i=0;i<keyL;i++){
//            for(int j=keyL-1;j>i;j--){
//                if(times[j]>times[j-1]){
//                    int tmp = times[j];
//                    times[j] = times[j-1];
//                    times[j-1] = tmp;
//
//                    tmp = arrKey[j];
//                    arrKey[j] = arrKey[j-1];
//                    arrKey[j-1] = tmp;
//                }
//            }
//        }
//        int index = 0;
//        for(int i=0;i<keyL;i++){
//            for(int j=0;j<times[i];j++){
//                arr[index++] = arrKey[i];
//            }
//        }
//        return arr;
//
//    }
//}
//import java.util.*;
//
//public class Main {
//    public static  void main(String args[]) {
//        Scanner in = new Scanner(System.in);
//        String str;
//        while(in.hasNext()){
//            str=in.next();
//            int res = 0;
//            int index = 0;
//            for(int i=str.length()-1;i>=0;i--){
//                char ele = str.charAt(i);
//                if ( ele == 'x'){
//                    break;
//                }
//                else if (ele < 'A'){
//                    res += (int)(ele - '0')*Math.pow(16,index);
//                }else{
//                    int intOfIndex = ele - 'A'+10;
//                    res +=(int)intOfIndex*Math.pow(16,index);
//                }
//                index++;
//            }
//            System.out.println(res);
//        }
//
//    }
//}
//import java.util.*;
//
//public class Main {
//    public static  void main(String args[]) {
//        HashMap hp = new HashMap();
//        ArrayList<String> arrayList = new ArrayList<String>();
//        HashSet<String> hashSet = new HashSet<String>();
//        Scanner in = new Scanner(System.in);
//        String str;
//        while(in.hasNext()){
//            str=in.next();
//            int res = 0;
//            int index = 0;
//            for(int i=str.length()-1;i>=0;i--){
//                char ele = str.charAt(i);
//                if ( ele == 'x'){
//                    break;
//                }
//                else if (ele < 'A'){
//                    res += (int)(ele - '0')*Math.pow(16,index);
//                }else{
//                    int intOfIndex = ele - 'A'+10;
//                    res +=(int)intOfIndex*Math.pow(16,index);
//                }
//                index++;
//            }
//            System.out.println(res);
//        }
//
//    }
//}

import java.util.*;
public class Main{
    public static void main(String args[]){
        String A = "[a+b*(5-4)]*{x+b+b*}";
        System.out.println(get(A));

    }
    public static boolean get(String A){
        char[] aa = new char[A.length()];
        int aaST = -1;

        int cyc = 0;
        while(cyc<A.length()){
            char curC = A.charAt(cyc);
            if(curC=='['||curC == '('||curC=='{'){
                aaST++;
                aa[aaST] = curC;
            }else if(curC == ']'||curC == ')'||curC=='}'){
                if((curC==']'&& aa[aaST]!='[')||(curC==')'&& aa[aaST]!='(')||(curC=='}'&& aa[aaST]!='{')){
                    return false;
                }else{
                    aaST--;
                }
            }else{
//                continue;
            }
            cyc++;
        }
        if(aaST==-1)return true;
        else{
            return false;
        }
    }
}