package pri.yhl.classloader;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by yhl on 2016/8/9.
 */
public class NetworkClassLoader extends ClassLoader{
    //
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

        private String rootUrl;

        public NetworkClassLoader(String rootUrl) {
            this.rootUrl = rootUrl;
        }

        protected Class<?> findClass(String name) throws ClassNotFoundException {
            byte[] classData = this.getClassData(name);
            if(classData == null) {
                throw new ClassNotFoundException();
            } else {
                return this.defineClass(name, classData, 0, classData.length);
            }
        }

        private byte[] getClassData(String className) {
            String path = this.classNameToPath(className);

            try {
                URL e = new URL(path);
                InputStream ins = e.openStream();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                short bufferSize = 4096;
                byte[] buffer = new byte[bufferSize];
                boolean bytesNumRead = false;

                int bytesNumRead1;
                while((bytesNumRead1 = ins.read(buffer)) != -1) {
                    baos.write(buffer, 0, bytesNumRead1);
                }

                return baos.toByteArray();
            } catch (Exception var9) {
                var9.printStackTrace();
                return null;
            }
        }

        private String classNameToPath(String className) {
            return this.rootUrl + "/" + className.replace('.', '/') + ".class";
        }

}
