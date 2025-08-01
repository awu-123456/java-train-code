class SingletonLazy {
    private volatile static SingletonLazy instance = null;
    public static Object locker = new Object();
    public static SingletonLazy getInstance() {
        if(instance == null) {
            synchronized (locker) {
                if(instance == null) {
                    instance = new SingletonLazy();
                }
            }
        }
        return instance;
    };
    private SingletonLazy() {
    }
}
public class Demo2 {
}
