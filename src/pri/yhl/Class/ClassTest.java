package pri.yhl.Class;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.omg.PortableInterceptor.Interceptor;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by yhl on 2016/6/22.
 */
public class ClassTest {
    @Test
    public void contrustorTest() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<ConTest> conTest = ConTest.class;
        ConTest con = conTest.getConstructor(Integer.class).newInstance(new Integer(10));
//        conTest.getClassLoader().loadClass();
        assertEquals(con.getI(),10);
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
