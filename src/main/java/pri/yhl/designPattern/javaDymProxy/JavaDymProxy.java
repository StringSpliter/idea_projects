package pri.yhl.designPattern.javaDymProxy;

import com.sun.deploy.net.proxy.ProxyHandler;

import java.lang.reflect.Proxy;

/**
 * Created by yhl on 17-9-12.
 */
public class JavaDymProxy {
    public static void main(String args[]){

        FishingInter fishingInter = (FishingInter) Proxy.newProxyInstance(JavaDymProxy.class.getClassLoader(),
                                                                    new Class[]{FishingInter.class},
                                                                    new JavaProxyHandler(new FishingInterImpl()));
        System.out.println(fishingInter.getFishNum("fish "));
        fishingInter.fishing();
    }
}
