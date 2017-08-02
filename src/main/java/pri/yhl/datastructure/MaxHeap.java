package pri.yhl.datastructure;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by yhl on 17-8-1.
 */
public class MaxHeap<T extends Comparable> {
    private int initDefaultCap = 10;
    private int increase = 5;
    private Object[] elements = null;
    private int length = 0;
    private int capacity = 0;
    private Object[] EMPTY_ELEMENTS = {};

    public MaxHeap(){
//        ArrayList
        this.elements = new Object[10];
        this.capacity = 10;
    }
    public MaxHeap(int initCap){
        this.initDefaultCap = initCap>0 ? initCap:initDefaultCap;
        this.elements = new Object[initDefaultCap];
        this.capacity = initDefaultCap;
    }

    public MaxHeap(T[] eles){
        if(eles.length!=0){
            elements = new Object[eles.length];
            for(int i=0;i<eles.length;i++){
                insert(eles[i]);
            }
        }else{
            elements = EMPTY_ELEMENTS;
            capacity = 0;
        }

    }
//
//    public void insert(T ele){
//        if(length+1>capacity){
//            ensureCap();
//        }
//        elements[length] = ele;
//        int upIndex = length;
//        int parentIndex = (length-1)/2;
//        while(parentIndex>=0 &&  ele.compareTo(elements[parentIndex])>0) {
//            Object tmp = elements[parentIndex];
//            elements[parentIndex] = elements[upIndex];
//            elements[upIndex] = tmp;
//            upIndex = parentIndex;
//            parentIndex = (upIndex-1)/2;
//        }
//        length = length+1;
//
//    }


    public void insert(T ele){
        if(length+1>capacity){
            ensureCap();
        }
        elements[length] = ele;
        int i = length;
        while(i>0 && ele.compareTo(elements[(i-1)/2])>0){
            elements[i] = elements[(i-1)/2];
            i = (i-1)/2;
        }
        elements[i] = ele;
        length = length+1;

    }


    private void ensureCap(){
        elements = Arrays.copyOf(elements,elements.length+increase,Object[].class);
        capacity = elements.length;

    }

    public static void main(String args[]){
        int a = -1/2;
        MaxHeap<Integer> maxHeap = new MaxHeap<Integer>();
        maxHeap.insert(new Integer(10));
        maxHeap.insert(new Integer(30));
        maxHeap.insert(new Integer(20));
        maxHeap.insert(new Integer(45));
        maxHeap.insert(new Integer(70));
        maxHeap.insert(new Integer(25));
        maxHeap.insert(new Integer(35));
        maxHeap.insert(new Integer(10));
        maxHeap.insert(new Integer(30));
        maxHeap.insert(new Integer(20));
        maxHeap.insert(new Integer(45));
        maxHeap.insert(new Integer(70));
        maxHeap.insert(new Integer(25));
        maxHeap.insert(new Integer(35));
    }

}
