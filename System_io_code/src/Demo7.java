import java.io.File;

public class Demo7 {
    public static void main(String[] args) {
        File file = new File("./aaa/bbb/ccc/ddd");
        System.out.println(file.isDirectory());
        file.mkdirs();
        System.out.println(file.isDirectory());
    }
}
