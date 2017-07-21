package pri.yhl.Class;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.omg.PortableInterceptor.Interceptor;

import java.lang.reflect.InvocationTargetException;
import java.util.Stack;

/**
 * Created by yhl on 2016/6/22.
 */
public class ClassTest {
    public enum  Tg{
        isT("isT"),isG("isG");
        String sd ;
        Tg(String sd){
            this.sd = sd;
        }
    }
    @Test
    public void contrustorTest() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<ConTest> conTest = ConTest.class;
        ConTest con = conTest.getConstructor(Integer.class).newInstance(new Integer(10));
//        conTest.getClassLoader().loadClass();
        assertEquals(con.getI(),100);
    }
    @Test
    public void ABTest(){
        System.out.println(Tg.isG.name());
        B b = new B();
        System.out.println(b.getA());
        System.out.println(b.a);
        Stack stack = new Stack();
        
    }
}

class ConTest {
    private Integer i =0;
    public ConTest(Integer i){
        this.i = i;
    }
    public int getI(){
        return this.i;
    }
}
class A{
    public int a = 1;
}
class B extends A{
    public int a = 2;
    public int getA(){
        return super.a;
    }
}