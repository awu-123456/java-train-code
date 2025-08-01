package utils;

import java.util.Scanner;

public class ScannerSingleton {
    private  static Scanner scanner;
    private ScannerSingleton() {

    }
    public static Scanner getScannerSingleton() {
        if(scanner == null) {
            scanner = new Scanner(System.in);
        }
        return scanner;
    }
}
