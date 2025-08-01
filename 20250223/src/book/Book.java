package book;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Book {
    private int bookId;
    private String title;
    private String author;
    private String category;
    private int publishYear;
    private boolean isBorrowed;
    private int borrowCount;
    private LocalDate shelfDate;

    public Book(String title, String author, String category, int publishYear, LocalDate shelfDate) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.publishYear = publishYear;
        this.shelfDate = shelfDate;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    public int getBorrowCount() {
        return borrowCount;
    }

    public void setBorrowCount(int borrowCount) {
        this.borrowCount = borrowCount;
    }

    public LocalDate getShelfDate() {
        return shelfDate;
    }

    public void setShelfDate(LocalDate shelfDate) {
        this.shelfDate = shelfDate;
    }

    public void incrementBorrowCount() {
        this.borrowCount++;
    }

    public void decreaseBorrowCount() {
        this.borrowCount--;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", category='" + category + '\'' +
                ", publishYear=" + publishYear +
                ", isBorrowed=" + isBorrowed +
                ", borrowCount=" + borrowCount +
                ", shelfDate=" + shelfDate +
                '}';
    }

    public String toJSON() {
        StringBuilder json = new StringBuilder();
        json.append(bookId).append(",");
        json.append(title).append(",");
        json.append(author).append(",");
        json.append(category).append(",");
        json.append(publishYear).append(",");
        json.append(isBorrowed).append(",");
        json.append(borrowCount).append(",");
        json.append(shelfDate != null ? shelfDate.format(DateTimeFormatter.ISO_LOCAL_DATE) : "null");
        return json.toString();
    }
}
