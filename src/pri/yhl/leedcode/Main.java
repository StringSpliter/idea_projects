package pri.yhl.leedcode;
class Fa{
    static{
        System.out.println("Fa static ");
    }
    public Fa(){
        System.out.println("Fa constructor");
    }
    {
        System.out.println("Fa init");
    }
}
public class Main extends Fa{
    static{
        System.out.println("sub static ");
    }
    public Main(){
        System.out.println("sub constructor");
    }
    {
        System.out.println("sub init");
    }
    public static void main(String args[]){
        new Main();
    }
}

interface big{
    void hg();
}
//import java.util.*;
//public class Main {
//    public static  void main(String args[]) {
//        Scanner in = new Scanner(System.in);
//        while(in.hasNext()){
//            int n = in.nextInt();
//            int m = in.nextInt();
//            int[] arr = new int[1000];
//            int nums =0;
//            int index = -1;
//            for(int i=n;i<=m-2;i++){
//                if(isP(i)&&isP(i+2)){
//                    arr[++index] = i;
//                    arr[++index] = i+2;
//                }
//            }
//            if(index==-1){
//                System.out.println("no");
//                continue;
//            }
//            int a = arr[0];
//            System.out.print(arr[0]);
//            for(int i=0;i<index;i++){
//                if(a!=arr[i]){
//                    a = arr[i];
//                    System.out.print(arr[i]);
//                }
//            }
//        }
//
//    }
//    public static boolean isP(int n){
//        int k = (int)Math.sqrt(n);
//        for(int i=2;i<=k;i++){
//            if(k%i==0) return false;
//        }
//        return true;
//    }
//}

//package pri.yhl.leedcode;
//import java.util.*;
//class Node{
//    int value;
//    Node next=null;
//    public Node(int value){
//       this.value = value;
//    }
//}
//class SingleList{
//    Node first;
//    Node tail;
//    int num=0;
//    public void tailInsert(int n){
//        if(num==0){
//            first = new Node(n);
//            tail = first;
//            num++;
//        }else{
//            Node newNode = new Node(n);
//            Node tmp = first;
//            while(tmp.next!=null){
//                tmp=tmp.next;
//            }
//            tmp.next = newNode;
//            num++;
//        }
//    }
//    public boolean remove(int index){
//        if(index<this.num){
//            if(index==0) {
//                first = first.next;
//                num--;
//                return true;
//            }
//            Node beforeNode = first;
//               while(--index>0){
//                   beforeNode = beforeNode.next;
//               }
//               beforeNode.next = beforeNode.next.next;
//               num--;
//            return true;
//        }else{
//            return false;
//        }
//    }
//    public boolean indexInsert(int index,int n){
//        if(index==0){
//            Node node = new Node(n);
//            node.next = first;
//            first = node;
//            num++;
//            return true;
//        }else if(index<=num){
//            Node beforeNode = first;
//            Node node = new Node(n);
//            while(--index>0){
//                beforeNode = beforeNode.next;
//            }
//            node.next = beforeNode.next;
//            beforeNode.next = node;
//            num++;
//            return true;
//        }else{
//            return false;
//        }
//
//    }
//    public void printList(boolean fg){
//
//        Node tmp = first;
//        while(tmp!=null){
//            System.out.print(tmp.value);
//            if(tmp.next!=null){
//                System.out.print(" ");
//            }
//            tmp = tmp.next;
//        }
//        System.out.println();
//    }
//}
//public class Main {
//    public static  void main(String args[]) {
//        Scanner in = new Scanner(System.in);
//        int num = 0;
//        num = in.hasNext() ? num=in.nextInt():0;
//        SingleList singleList = new SingleList();
//        boolean fg = true;
//        while(num-->0){
//            int nn = in.nextInt();
//            singleList.tailInsert(nn);
//        }
//        int index1 = in.nextInt();
//        int value = in.nextInt();
//        int index2 = in.nextInt();
//        fg = singleList.indexInsert(index1,value);
//        if(fg==false){
//            System.out.println("error");
//        }
//        fg = true;
//        fg = singleList.remove(index2);
//        if(fg==false){
//            System.out.println("error");
//        }
//        singleList.printList(fg);
//
//    }
//}
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
// class Node{
//    int value;
//    ArrayList<Node> nodes ;
//     public Node(int i){
//         value =i;
//     }
//}
//public class Main {
//
//    public static  void main(String args[]) {
//        Scanner in = new Scanner(System.in);
//        int i=0;
//        int j=0;
//        Node root = null;
//        Node cur = null;
//        while(in.hasNextLine()){
//            String str = in.nextLine();
//            if(i==0){
////                root = new Node();
//                cur = root;
//            }
//            String[] strs = str.split(" ");
//            ArrayList<Node> nodes = null;
//            if(strs.length>1) nodes = new ArrayList<Node>();
//            for(int k=0;k<strs.length;k++){
//                if(k==0){
//                    cur.value = Integer.valueOf(strs[k]);
//                }else{
//                    nodes.add(new Node(Integer.valueOf(strs[k])));
//                }
//            }
//
//
//        }
//
//
//    }
//}

//import java.util.*;
//public class Main{
//    public static void main(String args[]){
//        String A = "[a+b*(5-4)]*{x+b+b*}";
//        System.out.println(get(A));
//
//    }
//    public static boolean get(String A){
//        char[] aa = new char[A.length()];
//        int aaST = -1;
//
//        int cyc = 0;
//        while(cyc<A.length()){
//            char curC = A.charAt(cyc);
//            if(curC=='['||curC == '('||curC=='{'){
//                aaST++;
//                aa[aaST] = curC;
//            }else if(curC == ']'||curC == ')'||curC=='}'){
//                if((curC==']'&& aa[aaST]!='[')||(curC==')'&& aa[aaST]!='(')||(curC=='}'&& aa[aaST]!='{')){
//                    return false;
//                }else{
//                    aaST--;
//                }
//            }else{
////                continue;
//            }
//            cyc++;
//        }
//        if(aaST==-1)return true;
//        else{
//            return false;
//        }
//    }
//}