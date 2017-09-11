package pri.yhl.designPattern.javaDymProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by yhl on 17-9-12.
 */
public class JavaProxyHandler implements InvocationHandler{

    FishingInter fishingInter = null;

    public JavaProxyHandler(FishingInter fishingInter){
        this.fishingInter = fishingInter;
    }

    private  void before(){
        System.out.println("before");
    }

    private void after(){
        System.out.println("after");
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        before();

        Object obj = null;
        if(method.getName().equals("getFishNum")) {
             obj = method.invoke(fishingInter, args);
        }else{
             obj = method.invoke(fishingInter);
        }
        after();

        return obj;
    }
}
