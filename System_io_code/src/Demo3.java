import java.io.File;

public class Demo3 {
    public static void main(String[] args) {
        File file = new File("./text.txt");
        System.out.println(file.exists());
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());
    }
}
