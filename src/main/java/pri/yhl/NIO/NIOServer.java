package pri.yhl.NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;

/**
 * Created by yhl on 17-7-24.
 */
public class NIOServer {
    public static void main(String args[]) throws Exception{
        //创建ServerSocketChannel，监听8080端口
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.socket().bind(new InetSocketAddress(8080));
        //设置为非阻塞模式
        ssc.configureBlocking(false);
        //为ssc注册选择器
        Selector selector = Selector.open();
        ssc.register(selector,SelectionKey.OP_ACCEPT);
        //创建处理器

    }
    private static class Handler{

        private int bufferSize = 1024;
        private String localCharset = "UTF-8";

        public Handler(){}
        public Handler(int bufferSize){
            this(bufferSize,null);
        }
        public Handler(String LocalCharset){
            this(-1,LocalCharset);
        }
        public Handler(int bufferSize,String localCharset){
            if(bufferSize>0) this.bufferSize = bufferSize;
            if(localCharset!=null) this.localCharset = localCharset;
        }

        public void handlerAccept(SelectionKey key) throws IOException{
            SocketChannel sc = ((ServerSocketChannel)key.channel()).accept();
            sc.configureBlocking(false);
            sc.register(key.selector(),SelectionKey.OP_READ,ByteBuffer.allocate(this.bufferSize));
        }
        public void handlerRead(SelectionKey key) throws IOException{
            //获取channel
            SocketChannel sc = (SocketChannel)key.channel();
            //获取buffer并重置
            ByteBuffer buffer = (ByteBuffer)key.attachment();
            buffer.clear();
            //没有读到内容则关闭
            if(sc.read(buffer)==-1){
                sc.close();
            }else{
                //将buffer转换为度状态
                buffer.flip();
                //讲buffer中接收到的值localCharset格式编码后保存到receivedString
                String receivedString = Charset.forName(localCharset).newDecoder().decode(buffer).toString();
                System.out.println("Received from client: "+receivedString);

                //返回数据给客户端
                String
            }

        }

    }
}

