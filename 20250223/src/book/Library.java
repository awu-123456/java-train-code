package book;

import constant.Constant;
import utils.AnalyzingBook;

import java.io.IOException;

public class Library {
    private Book[] books;
    private int bookCount;
    private static Library library;
    AnalyzingBook analyzingBook = new AnalyzingBook();
    private Library() {
        //当调⽤该构造⽅法的时候，要加载⽂件当中的数据进⾏到books数组当中
        loadAllBook();
    }
    public static Library getLibrary() {
        if(library == null) {
            library = new Library();
        }
        return library;
    }
    private void loadAllBook() {
        try {
            Book[] allBook = analyzingBook.loadObject(Constant.ALL_BOOK_FILE_NAME);
            books = new Book[Constant.CAPACITY];
            if(allBook == null) {
                bookCount = 0;
            } else {
                int allBookLen = allBook.length;
                if(allBookLen > books.length) {
                    books = new Book[allBookLen];
                }
                for (int i = 0; i < allBookLen; i++) {
                    books[i] = allBook[i];
                }
                bookCount = allBookLen;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void storeBook() {
        try {
            analyzingBook.storeObject(books,Constant.ALL_BOOK_FILE_NAME);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //公用的方法
    public void searchBook() {
        System.out.println("查找图书");
    }

    public void displayBooks() {
        System.out.println("显示图书");
    }

    public void exit() {
        System.out.println("退出系统");
    }

    public void addBook(Book book) {
        System.out.println("Library类addBook方法执行了");
    }
}
