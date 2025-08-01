package user;

import book.Library;
import constant.Constant;
import utils.PermissionException;

public class ProxyUser {
    //被代理的真实用户
    private User realUser;
    Library library;
    public ProxyUser(User user) {
        this.realUser = user;
        library = Library.getLibrary();
    }

    public User getRealUser() {
        return realUser;
    }

    //其他操作
    //调⽤菜单
    public int display() {
        return this.realUser.display();
    }

    //--------------------------------管理员相关⽅法------------------------------//

    private void checkRealUserWhetherAdminUser(String exceptionMessage) {
        if(!(realUser instanceof AdminUser)) {
            throw new PermissionException(exceptionMessage);
        }
    }

    //添加书籍操作
    public void addBook() {
        System.out.println("代理类addBook方法执行了");
        try {
            checkRealUserWhetherAdminUser("普通用户没有权限上架图书");
        } catch(PermissionException e) {
            e.printStackTrace();
        }
        ((AdminUser)(this.realUser)).addBook();
    }

    //更新书籍操作
    public void updateBook() {
        System.out.println("代理类updateBook方法执行了");

    }

    //移除图书
    public void removeBook() {
        System.out.println("代理类removeBook方法执行了");

    }

    //查看图书的借阅次数
    public void borrowCount() {
        System.out.println("代理类borrowCount方法执行了");

    }

    //查看最受欢迎的前K本书
    public void generateBook() {
        System.out.println("代理类generateBook方法执行了");

    }

    //查看库存状态
    public void checkInventoryStatus() {
        System.out.println("代理类checkInventoryStatus方法执行了");

    }

    //移除上架超过1年的书籍
    public void checkAndRemoveOldBooks() {
        System.out.println("代理类checkAndRemoveOldBooks方法执行了");

    }

    //--------------------------------普通相关⽅法------------------------------//

    private void checkRealUserWhetherNormalUser(String exceptionMessage) {
        if(!(realUser instanceof NormalUser)) {
            throw new PermissionException(exceptionMessage);
        }
    }

    //借阅图书
    public void borrowBook() {
        System.out.println("代理类borrowBook方法执行了");

    }

    //归还图书
    public void returnBook() {
        System.out.println("代理类returnBook方法执行了");

    }

    //查看个⼈借阅情况
    public void viewBorrowHistory() {
        System.out.println("代理类viewBorrowHistory方法执行了");

    }


    public void handleOperation(int choice) {
        if (realUser instanceof AdminUser) {
            switch (choice) {
                case Constant.SEARCH_BOOK:
                    library.searchBook();
                    break;
                case Constant.DISPLAY_BOOK:
                    library.displayBooks();
                    break;
                case Constant.EXIT:
                    library.exit();
                    break;
                case Constant.ADD_BOOK:
                    addBook();
                    break;
                case Constant.UPDATE_BOOK:
                    updateBook();
                    break;
                case Constant.REMOVE_BOOK:
                    removeBook();
                    break;
                case Constant.BORROWED_BOOK_COUNT:
                    borrowCount();
                    break;
                case Constant.GENERATE_BOOK:
                    generateBook();
                    break;
                case Constant.CHECK_INVENTORY_STATUS:
                    checkInventoryStatus();
                    break;
                case Constant.CHECK_AND_REMOVE_OLD_BOOK:
                    checkAndRemoveOldBooks();
                    break;
                default:
                    System.out.println("⽆效的操作。");

            }
        } else if (realUser instanceof NormalUser) {
            switch (choice) {
                case Constant.SEARCH_BOOK:
                    library.searchBook();
                    break;
                case Constant.DISPLAY_BOOK:
                    library.displayBooks();
                    break;
                case Constant.EXIT:
                    library.exit();
                case Constant.BORROWED_BOOK:
                    borrowBook();
                    break;
                case Constant.RETURN_BOOK:
                    returnBook();
                    break;
                case Constant.VIEW_BORROW_HISTORY_BOOK:
                    viewBorrowHistory();
                    break;
                default:
                    System.out.println("⽆效的操作。");
            }
        }
    }
}