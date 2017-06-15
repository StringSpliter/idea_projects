package pri.yhl.VM;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yhl on 2016/7/13.
 */
public class HeapOOM {
    static class OOMObject{}
    public static void main(String args[]){
        List<OOMObject> list = new ArrayList<OOMObject>();
        while(true){
            list.add(new OOMObject());
        }
    }
}
