package pri.yhl.compute;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by yhl on 16-3-17.
 */
public class ArrayListSort {
    public static void main(String[] args){
        ArrayList<String> test = new ArrayList<String>();
        test.add("sd");
        test.add("sdc");
        test.add("adf");
        test.add("dcx");
        test.add("efr");
        for(int i=0;i<test.size()-1;i++){
            int minIndex = i;
            for(int j=i+1;j<test.size();j++){
                if(test.get(minIndex).compareTo(test.get(j))>0){
                    minIndex = j;
                }
            }
            String temp = test.get(i);
            test.remove(i);
            test.add(i,test.get(minIndex-1));
            test.remove(minIndex);
            test.add(minIndex,temp);
        }
        Iterator<String> it = test.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
