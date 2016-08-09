package pri.yhl.classloader;

import java.io.*;
/**
 * Created by yhl on 2016/8/9.
 */
public class SelfClassLoader extends ClassLoader{
            public static void main(String args[]) throws IllegalAccessException, InstantiationException {
                SelfClassLoader selfClassLoader = new SelfClassLoader();
                ClassLoader classLoader = selfClassLoader.getParent();
                try {
                    Class teClazz = selfClassLoader.loadClass("TE");
                    Object obj = teClazz.newInstance();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
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
}
