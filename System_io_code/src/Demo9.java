import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Demo9 {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = new FileInputStream("D:/test.txt");
        while(true) {
            byte[] bytes = new byte[1024];
            int n = inputStream.read(bytes);
            if(n == -1) {
                break;
            }
            for(int i = 0;i < n;i++) {
                System.out.printf("%x ",bytes[i]);
            }
        }
//        while(true) {
//            int n = inputStream.read();
//            if(n == -1) {
//                break;
//            }
//            System.out.printf("%x ",n);
//        }
    }
}
