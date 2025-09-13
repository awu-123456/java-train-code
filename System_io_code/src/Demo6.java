import java.io.File;

public class Demo6 {
    public static void main(String[] args) {
        File file = new File("D:/");
        File[] files = file.listFiles();
        for(File f : files) {
            System.out.println(f.getName());
        }
//        String[] fileNames = file.list();
//        for(String fileName : fileNames) {
//            System.out.println(fileName);
//        }
    }
}
