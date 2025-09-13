import java.io.File;

public class Demo8 {
    public static void main(String[] args) {
        File source = new File("D:/install/text.txt");
        File destination = new File("D:/text.txt");
        source.renameTo(destination);
    }
}
