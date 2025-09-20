import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TcpEchoServer {
    private ServerSocket serverSocket = null;
    public TcpEchoServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }
    private void start() throws IOException {
        System.out.println("server start!");
        ExecutorService executorService = Executors.newCachedThreadPool();
        while (true) {
            // 首先要先接受客户端的连接, 然后才能进行通信.
            // 如果有客户端和服务器建立好了连接, accept 能够返回.
            // 否咋 accept 会阻塞.
            Socket socket = serverSocket.accept();
            // 通过这个方法处理这个客户端整个的连接过程.
            executorService.submit(() -> {
                processConnection(socket);
            });
        }
    }

    private void processConnection(Socket socket) {
        // 在一次连接中, 客户端和服务器之间可能会进行多组数据传输.
        System.out.printf("[%s:%d] 客户端上线！\n",socket.getInetAddress(),socket.getPort());
        try (InputStream inputStream = socket.getInputStream();
             OutputStream outputStream = socket.getOutputStream()) {
            Scanner scanner = new Scanner(inputStream);
            PrintWriter printWriter = new PrintWriter(outputStream);
            while(true) {
                // 处理多次请求/响应的读写操作.
                // 一次循环就是读写一个请求/响应
                // 1. 读取请求并解析 (可以直接使用 Scanner 完成)
                if (!scanner.hasNext()) {
                    System.out.printf("[%s:%c] 客户端下线！\n",socket.getInetAddress(),socket.getPort());
                    break;
                }
                String request = scanner.next();
                // 2. 根据请求计算响应
                String response = process(request);
                // 3. 把响应写回客户端
                printWriter.println(response);
                printWriter.flush();
                // 4. 打印日志
                System.out.printf("[%s:%d] req: %s,resp: %s\n",socket.getInetAddress(),socket.getPort(),response,response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        TcpEchoServer server = new TcpEchoServer(9090);
        server.start();
    }
}
