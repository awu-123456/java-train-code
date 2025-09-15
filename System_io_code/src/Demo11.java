import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Demo11 {
    public static void main(String[] args) {
        try(Reader reader = new FileReader("D:/test.txt")) {
            while(true) {
                char[] chars = new char[1024];
                int n = reader.read(chars);
                if(n == -1) {
                    break;
                }
                for (int i = 0; i < n; i++) {
                    System.out.print(chars[i] + " ");
                }
            }
//            while(true) {
//                int n = reader.read();
//                if(n == -1) {
//                    break;
//                }
//                char c = (char) n;
//                System.out.print(c+" ");
//            }
        } catch (IOException e) {
            e.printStackTrace();;
        }
    }
}
