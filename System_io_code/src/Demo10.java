import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Demo10 {
    public static void main(String[] args) {
        try (OutputStream outputStream = new FileOutputStream("D:/test.txt",true)) {
            outputStream.write(65);
            outputStream.write(66);
            outputStream.write(67);
            outputStream.write(68);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
