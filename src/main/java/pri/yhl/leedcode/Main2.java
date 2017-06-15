package pri.yhl.leedcode;
public class Main2{
    public static void main(String args[]){
    System.out.println("\\\\\\");
    }
}
//public class Main2{
//    public static void main(String args[]){
//        System.out.println(getR(78));
//
//    }
//    public static int getR(int n){
//
//
//        int m = (int)Math.sqrt(n);//获取n的开根号，减少遍历次数
//        if(m*m==n) return 1;//如果本身为平方数，直接返回1
//
//        /*
//        * //申请辅助数组，其中如果数组下标为i，则数组值的含义是i可以由nums[i]个最小平方数组成。
//        * 舍弃nums[0],方便程序表达含义
//        * */
//        int[] nums = new int[n+1];
//
//        nums[1]  = 1;
//        for(int i=2;i<=n;i++){
//            int jd = (int)Math.sqrt(i);
//            if(jd*jd==i) {//当前值为平方数，直接赋值为1，继续下次循环
//                nums[i]= 1;
//                continue;
//            }
//            int min = Integer.MAX_VALUE;
//            for(int j=1;j*j<=i;j++){
//                if(min>(nums[i-j*j]+1)){//j从1开始搜索F(i)的最优解
//                    min = nums[i-j*j]+1;
//                }
//            }
//            nums[i] = min;
//        }
//        return nums[n];
//    }
//}
//public class Main2{
//    public static void main(String args[]){
//        int[] weight = {0,5,3,4,7,8};
//        int[] value = {0,14,6,9,18,20};
//        int pw = 20;
//        int[][] values = new int[6][21];
//
//        for(int i=1;i<6;i++){
//            for(int j=1;j<21;j++){
//                if(weight[i]<=j){
//                    if((value[i]+values[i-1][j-weight[i]])>values[i-1][j]){
//                        values[i][j] = value[i]+values[i-1][j-weight[i]];
//                    }else{
//                        values[i][j] = values[i-1][j];
//                    }
//                }else{
//                    values[i][j] = values[i-1][j];
//                }
//            }
//        }
//
//        for(int i=0;i<6;i++){
//            for(int j=0;j<21;j++){
//                System.out.print(values[i][j]+" ");
//            }
//            System.out.println();
//        }
//
//    }
//}

//package pri.yhl.leedcode;
//class Node {
//    public Node next;
//    public int value;
//}
//public class List{
//    Node swap(Node list){
//        Node firstOdd = null;
//        Node firstEven = null;
//        while(list!=null){
//            if(list.value%2==0){//如果为偶数
//                Node tmp = firstEven;//将指向偶数序列的链表首指针暂存
//                firstEven = list;//将首指针指向最新发现的偶数节点
//                list = list.next;//list指针下移，防止原始数据链丢失
//                firstEven.next = tmp;//断开当前偶数节点后续链，使用前插法，插入元素
//            }else{//类似偶数处理过程
//                Node tmp = firstOdd;
//                firstOdd = list;
//                list = list.next;
//                firstOdd.next = tmp;
//            }
//        }
//
//        Node lastOdd = firstOdd;
//        while(lastOdd.next!=null) lastOdd = lastOdd.next;//找到最后一个奇数
//
//        lastOdd.next = firstEven; //合并奇偶链
//        return firstOdd;
//    }
//    public static void main(String args[]){
//
//        int[] nums = {4,5,7,1,6};
//        Node list = null;
//        Node curNode = null;
//        for(int i=0;i<nums.length;i++){
//            Node node = new Node();
//            node.next = null;
//            node.value = nums[i];
//                if(i==0){
//                    list = node;
//                    curNode = node;
//                }else{
//                    curNode.next = node;
//                    curNode = node;
//                };
//
//        }
//
//        List maim2 = new List();
//        Node tmp = maim2.swap(list);
//        while(tmp!=null){
//            System.out.println(tmp.value);
//            tmp=tmp.next;
//        }
//    }
//
//}


//package pri.yhl.leedcode;
//
//import pri.yhl.compute.ArrayListSort;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by yhl on 2016/8/31.
// */
//public class Main2 {
//    public static void main(String args[]){
//
//        String[] A = {"coder","xfcoderjbixcoderpuvwhcoderodpacoderycacoderjskcoderptcoderkcoderdtwcodergalucoderfnjpwcoderagmtcodermkzoqcoderysqsycoderlvccodervbycoderacuagcodereueucoderscoderrbcoder","xbxcoderlafrcoderyuccoderjcoderefldcodersstujcoderelcoder","dvfowcoderfencoderqekcoderbtmcoderehcoderriyjdcodermocoder","ncbacoderjnvcoderfqcoderenwjpcoderkintcoderwtgcoder"};
//        int n = 5;
//
//        int cata = 0;
//        for(int i=0;i<n;i++){
//            if(A[i].toLowerCase().contains("coder")) cata++;
//        }
//
//        int[] catas = new int[cata];
//        String[] B = new String[cata];
//        int index = 0;
//        char[] target = {'c','o','d','e','r'};
//        for(int i=0;i<n;i++){
//            if(A[i].toLowerCase().contains("coder")){
//                B[index] = A[i];
//
//                String tmp = A[i];
//                int time =0;
//                int count =0;
//                for(int j=0;j<tmp.length();j++){
//
//
//
//                    if( count == 4 && target[count] == tmp.charAt(j) ){
//                        time++;
//                        count = 0;
//                    }else if( target[count]==tmp.charAt(j) ){
//                        count++;
//                    }else{
//                        if( count!=0 && target[0]==tmp.charAt(j))
//                            count = 1;
//                        else{
//                            count = 0;
//                        }
//                    }
//                }
//                catas[index++] = time;
//                System.out.println(time);
//            };
//        }
//
//        for(int i=cata-1;i>=0;i--){
//            for(int j= 0;j<i;j++){
//
//                if(catas[j]<catas[j+1]){
//
//                    int tmp = catas[j];
//                    catas[j] = catas[j+1];
//                    catas[j+1] = tmp;
//
//                    String t = B[j];
//                    B[j] = B[j+1];
//                    B[j+1] = t;
//
//                }
//
//            }
//        }
//
//       int h = 0;
//        h++;
//
//    }
//}
