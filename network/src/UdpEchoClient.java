import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UdpEchoClient {
    // 创建 socket 对象
    private DatagramSocket socket = null;
    private String serverIp;
    private int serverPort;

    private UdpEchoClient(String serverIp,int serverPort) throws SocketException {
        socket = new DatagramSocket();
        this.serverIp = serverIp;
        this.serverPort = serverPort;
    }

    public void start() throws IOException {
        System.out.println("client start!");

        Scanner scanner = new Scanner(System.in);

        // 用户通过控制台, 输入字符串, 把字符串发给服务器. 从服务器读取响应.
        while(true) {
            // 1. 从控制台读取用户输入.
            System.out.println("-> ");
            String request =scanner.next();
            if(request.equals("exit")) {
                break;
            }
            // 2. 把用户输入的字符串构造成 UDP 数据报, 进行发送.
            DatagramPacket requestPacket = new DatagramPacket(request.getBytes(),request.getBytes().length,
                    InetAddress.getByName(this.serverIp),this.serverPort);
            socket.send(requestPacket);
            // 3. 从服务器读取响应
            DatagramPacket responsePacket = new DatagramPacket(new byte[1024],1024);
            socket.receive(responsePacket);
            String response = new String(responsePacket.getData(),0,requestPacket.getData().length);
            // 4. 显示响应.
            System.out.println(response);
        }
    }

    public static void main(String[] args) throws IOException {
        UdpEchoClient client = new UdpEchoClient("101.200.34.238",9090);
        client.start();
    }
}
