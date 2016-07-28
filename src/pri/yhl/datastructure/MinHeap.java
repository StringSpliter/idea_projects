package pri.yhl.datastructure;

import com.sun.xml.internal.bind.v2.model.core.EnumLeafInfo;
import org.junit.Test;

import java.net.URL;

/**
 * Created by yhl on 2016/7/26.
 */
public class MinHeap<T extends Comparable>{
    T[] elements;
    int curLength = 0;
    public MinHeap(){
       elements = null;
    }
    public MinHeap(T[] elements,int curLength){
        this.elements = elements;
        this.curLength = curLength;
        reset();
    }
    private void reset(){
        if(elements==null||curLength == 0) return ;

        int length = curLength;
        int startPoint = (length - 2)/2;
        while(startPoint>=0){
            siftDown(startPoint);
            startPoint --;
        }
    }
    private void siftDown(int curPoint){
        int length = curLength;

        while(true){
            int leftChild  = ( 2*curPoint + 1 ) > length-1 ? -1:(2*curPoint + 1);
            int rightChild = ( 2*curPoint + 2 ) > length-1 ? -1:(2*curPoint + 2);
            if (leftChild > -1 && rightChild > -1 ){
                T leftE = elements[leftChild];
                T rightE = elements[rightChild];
                int res = leftE.compareTo(rightE);
                int singl = ( res == 1) ? (elements[curPoint].compareTo(elements[rightChild]) == 1 ? rightChild:-1):(elements[curPoint].compareTo(elements[leftChild]) == 1 ? leftChild:-1);
                if(singl != -1) {

                        T tmp = elements[curPoint];
                        elements[curPoint] = elements[singl];
                        elements[singl] = tmp;
                        curPoint = singl;

                }else {
                    break;
                }
            } else{
                int singl = ( leftChild == rightChild ? -1:(leftChild >rightChild ? leftChild : rightChild));
                T tmp = elements[curPoint];
                elements[curPoint] = elements[singl];
                elements[singl] = tmp;
                curPoint = rightChild;
                break;
            }
        }
    }

    public static void main(String args[]){
//        Element[] elements = new Element[10];
//        int [] eles = {53,17,78,9,45,65,87,23};
//        for(int i = 0;i<8;i++){
//            elements[i] = new Element(eles[i]);
//        }
//        MinHeap<Element> minHeap = new MinHeap<Element>(elements,8);
//        System.out.print(minHeap);
//        Out out1 = new Out(1);
//        setOut(out1.next);
//        System.out.println(out1.next);

//        URL url = Thread.currentThread().getContextClassLoader().getResource(".");
//        URL url = MinHeap.class.getResource(".");
//        System.out.println(url.getPath());

//                URL url = MinHeap.class.getResource("t.txt");
//        System.out.println(url.getPath());

//          URL url = MinHeap.class.getClassLoader().getResource("t.txt");
//          System.out.println(url.getPath());

        URL url = Thread.currentThread().getContextClassLoader().getResource("t.txt");
        System.out.println(url.getPath());

    }
public static void setOut(Out out){
    out = new Out(3);
}

}
class Out{
    int id;
    Out next;
    public Out(int id){
        this.id = id;
    }

}
class Element implements Comparable{
    private int n ;
    public Element(int m){
        n = m;
    }
    public int getN(){
        return n;
    }
    @Override
    public int compareTo(Object o) {
        if(o instanceof Element) {
            Element oEle = (Element) o;
            if (oEle.getN() > this.getN()) {
                return -1;
            } else if (oEle.getN() < this.getN()) {
                return 1;
            } else {
                return 0;
            }

        }else{
            return 0;
        }
    }
}
