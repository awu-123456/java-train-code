import java.io.File;
import java.io.IOException;

public class Demo2 {
    public static void main(String[] args) throws IOException {
        File file = new File("./text.txt");
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getCanonicalPath());
    }
}
