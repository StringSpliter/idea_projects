package pri.yhl.common.set;

import java.util.*;
import java.util.Random;

/**
 * Created by yhl on 16-3-10.
 */
public class HashSetTest {
    public static void main(String[] args){


        Set<Diss> set = new HashSet<Diss>();

        for(int i=0;i<10; i++){
            Diss dis = new Diss(i);
            set.add(dis);

        }
        System.out.println(set.add(new Diss(0)));
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