package pri.yhl.NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by yhl on 17-7-24.
 */
public class NIOClient {
    public static void main(String args[]) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.socket().connect(new InetSocketAddress(8080));
        socketChannel.configureBlocking(false);
        socketChannel.write(ByteBuffer.wrap("client 8080".getBytes("UTF-8")));
        socketChannel.finishConnect();
    }
}
