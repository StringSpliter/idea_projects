package pri.yhl.common.set;
import java.io.ObjectInputStream;
import java.util.*;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by yhl on 16-3-10.
 */
public class HashSetTest<T> {
    public static void main(String[] args){


        Set<Diss> set = new HashSet<Diss>();

        for(int i=0;i<10; i++){
            Diss dis = new Diss(i);
            set.add(dis);
        }

        System.out.println(set.add(new Diss(0)));
    }
    public void testT(){
        Object obj = (new HashSet<Object>());
        ConcurrentHashMap<String,String> ch = new ConcurrentHashMap<String,String>();
        ch.put(null,"ff");
    }
}
class Diss{

    int i = 0;

    public Diss(){


    }
    public  Diss(int j){
        this.i = j;
    }
    @Override
    public int hashCode(){
        return new Random().nextInt();
    }
    @Override
    public boolean equals(Object obj){

        if(obj == null){
            return false;
        }else{
            if(obj == this){
                return true;
            } else if( obj instanceof Diss && (((Diss) obj).getI() == this.getI())){
                return true;
            }else{
                return false;
            }
        }

    }
    public int getI(){
        return this.i;
    }
    public void setI(int i){
        this.i = i;
    }

}