package com.example.nonetty;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

/**
 * @author caoyajuan
 * @ClassName PlainOIOServer
 * @Description TODO
 * @date 2021/2/26 17:48
 */
public class PlainOIOServer {
    public void server(int port) throws Exception{
        // 将服务器绑定到指定端口
        final ServerSocket serverSocket = new ServerSocket(port);
        try{
            for (;;){
                // 接受连接
                final Socket clientSocket = serverSocket.accept();
                System.out.println("Acceptted connection from " + clientSocket);
                // 创建一个新线程来处理该连接
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        OutputStream os;
                        try{
                            os = clientSocket.getOutputStream();
                            // 将消息写给已连接的客户端
                            os.write("Hi!\r\n".getBytes(
                                    Charset.forName("UTF-8")));
                            os.flush();
                            clientSocket.close();

                        } catch (IOException e) {
                            e.printStackTrace();
                        } finally {
                            try{
                                clientSocket.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }).start(); // 启动线程
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
