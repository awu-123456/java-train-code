package utils;

import book.Book;
import com.bit.utils.FileUtils;
import constant.Constant;

import java.io.IOException;
import java.time.LocalDate;

public class AnalyzingBook {
    public void storeObject(Book[] books, String filename) throws IOException {
        int booksUseLen = 0;
        for (int i = 0; i < books.length; i++) {
            if(books[i] != null) {
                booksUseLen++;
            }
        }
        StringBuilder jsonArray = new StringBuilder();
        for (int i = 0; i < booksUseLen; i++) {
            if(books[i] != null) {
                jsonArray.append(books[i].toJSON());
                if(i != booksUseLen-1) {
                    jsonArray.append("\n");
                }
            }
        }
        //数据写入文件
        FileUtils.writeFile(jsonArray.toString(),filename);
    }

    public Book[] loadObject(String filename) throws IOException {
        //1. 从⽂件读取数据
        String content = FileUtils.readFile(filename);
        if(content == null || content.isEmpty()) {
            System.out.println("File is empty or does not exist: "+filename);
            return null;
        }
        String[] bookJsonStrings = content.split("\n");
        Book[] bookList = new Book[bookJsonStrings.length];
        for (int i = 0; i < bookJsonStrings.length; i++) {
            Book book = parseBookJson(bookJsonStrings[i]);
            bookList[i] = book;
        }
        return bookList;
    }

    private Book parseBookJson(String json) {
        if(json.isEmpty()) {
            return null;
        }
        String[] pairs = json.split(",");
        int bookId = Integer.parseInt(pairs[0]);
        String title = pairs[1];
        String author = pairs[2];
        String category = pairs[3];
        int publishYear = Integer.parseInt(pairs[4]);
        boolean isBorrowed = Boolean.parseBoolean(pairs[5]);
        int borrowCont = Integer.parseInt(pairs[6]);
        LocalDate shelfDate = LocalDate.parse(pairs[7]);
        if(title != null && author != null && category != null && shelfDate != null){
            Book book = new Book(title,author,category,publishYear,shelfDate);
            book.setBorrowed(isBorrowed);
            book.setBorrowCount(borrowCont);
            book.setBookId(bookId);
            return book;
        }
        return null;
    }

    public static void main(String[] args) {
        Book[] books = new Book[4];
        books[0] = new Book("java", "gaobo", " 编程 ", 1994, LocalDate.of(2023, 9, 24));
        books[1] = new Book("mysql", "lisi", " 编程 ", 1999, LocalDate.of(2024, 2, 10));
        books[2] = new Book("php", "gaobo", " 编程 ", 2020, LocalDate.of(2023, 9, 23));
        books[3] = new Book(" 西游记 ", " 吴承恩 ", "⼩说 ", 2024, LocalDate.of(2023, 9,23));
        AnalyzingBook analyzingBook = new AnalyzingBook();
        try {
            analyzingBook.storeObject(books, Constant.ALL_BOOK_FILE_NAME);

            Book[] ret = analyzingBook.loadObject(Constant.ALL_BOOK_FILE_NAME);

            for (int i = 0; i < ret.length; i++) {
                System.out.println(ret[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
