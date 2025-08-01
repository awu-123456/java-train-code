import user.AdminUser;
import user.NormalUser;
import user.ProxyUser;
import user.User;
import user.factory.AdminUserFactory;
import user.factory.IUserFactory;
import user.factory.NormalUserFactory;

import java.util.Scanner;

public class LibrarySystem {
    public static void main(String[] args) {

        //工厂模式
        IUserFactory adminUserFactor = new AdminUserFactory();
        User adminUser = adminUserFactor.createUser("刘备",1);

        IUserFactory normalUserFactor = new NormalUserFactory();
        User normalUser1 = normalUserFactor.createUser("张飞",2);
        User normalUser2 = normalUserFactor.createUser("关羽",3);

        //代理模式
        ProxyUser proxyUserAdmin = new ProxyUser(adminUser);
        ProxyUser proxyUserNormal1 = new ProxyUser(normalUser1);
        ProxyUser proxyUserNormal2 = new ProxyUser(normalUser2);

        LibrarySystem librarySystem = new LibrarySystem();

        ProxyUser currentUser = librarySystem.selectProxyRole(proxyUserAdmin,proxyUserNormal1,proxyUserNormal2);

        while(true) {
            int choice = currentUser.getRealUser().display();

            currentUser.handleOperation(choice);
        }
    }

    public ProxyUser selectProxyRole(ProxyUser proxyUserAdmin,ProxyUser proxyUserNormal1,ProxyUser proxyUserNormal2) {
        System.out.println("选择角色进行登入：");
        System.out.println("1.管理员\n2.普通用户（张飞）\n3.普通用户（关羽）\n4.退出系统");
        ProxyUser currentUser = null;
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch(choice) {
            case 1:
                currentUser = proxyUserAdmin;
                break;
            case 2:
                currentUser = proxyUserNormal1;
                break;
            case 3:
                currentUser = proxyUserNormal2;
                break;
            case 4:
                System.exit(0);
                System.out.println("系统已退出..");
                break;
            default:
                break;
        }
        return currentUser;
    }

}
