package user;

public abstract class User {
    protected String name; //用户名
    protected int userID;  //用户ID
    protected String role; //用户角色

    //构造函数
    public User(String name, int userID, String role) {
        this.name = name;
        this.userID = userID;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public int getUserID() {
        return userID;
    }

    public String getRole() {
        return role;
    }

    public abstract int display();

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", userID=" + userID +
                ", role='" + role + '\'' +
                '}';
    }

}
