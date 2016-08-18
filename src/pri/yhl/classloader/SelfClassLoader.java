package pri.yhl.classloader;

import org.junit.Test;

import java.io.*;
/**
 * Created by yhl on 2016/8/9.
 */
public class SelfClassLoader extends ClassLoader{
    enum Color{
        GREEN(1,"GREEN"),
        RED(2,"RED"),
        BLACK(3,"BLACK");
        int num;
        String name;
        Color(int num,String name){
              this.name = name;
            this.num = num;
        }
        int getNum(){
            return this.num;
        }
        String getName(){
            return this.name;
        }
        void test(Color color){
            switch(color){
                case GREEN : System.out.println("GREEN"); break;
            }
        }
    }
    public void testSuper(){
        System.out.println(super.getClass());
    }
            public static void main(String args[]) throws IllegalAccessException, InstantiationException {
                   String s1 = "a";
                   String s2 = s1 + "b";
                   String s3 = "a" + "b";
                   System.out.println(s2 == "ab");
                   System.out.println(s3 == "ab");
                Color col = Color.BLACK;
                System.out.println(col.getNum());
                for(int i=0;i<Color.values().length;i++){
                    System.out.println(Color.values()[i]);
                }
                new SelfClassLoader().testSuper();

//                SelfClassLoader selfClassLoader = new SelfClassLoader();
//                ClassLoader classLoader = selfClassLoader.getParent();
//
//                try {
//                    Class teClazz = selfClassLoader.loadClass("TE");
//                    Object obj = teClazz.newInstance();
//                    kk:
//                    for(int i=0;i<45;i++){
//                        for(int j=0;i<10;j++) {
//                            break kk;
//                        }
//                    }
//
//                } catch (ClassNotFoundException e) {
//                    e.printStackTrace();
//                }
            }
            public Class findClass(String name) throws ClassNotFoundException{
                byte[] b = new byte[0];
                try {
                    b = loadClassData(name);
                } catch (IOException e) {
                    throw new ClassNotFoundException();
                }
                return defineClass(name, b, 0, b.length);
            }

                    private byte[] loadClassData(String name) throws IOException {
                     // load the class data from the connection
                        String classPath = name.replace('.','\\');
                        FileInputStream fileInputStream = new FileInputStream("E:\\"+"\\"+classPath+".class");
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        byte[] bytes = new byte[4096];
                        int realReadNum = 0;
                        while((realReadNum =fileInputStream.read(bytes))>0){
                            byteArrayOutputStream.write(bytes,0,realReadNum);
                        }
                        return byteArrayOutputStream.toByteArray();
                    }
            public void bn(int o){
                System.out.println("son");
            }
            public void bn(long o){
                System.out.println("f");
            }
    @Test
    public void testOption(){
        bn(111111111111L);
        bn(1);
    }
}
class Option extends FOption{
     int a ;
     class vg{
        public void fun(){
            a = 0;
        }
    }
}
class FOption{

}