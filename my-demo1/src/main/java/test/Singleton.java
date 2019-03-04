package test;

//饿汉式单例模式（线程安全）
public class Singleton {

    private static Singleton uniqueInstence = new Singleton();
    //构造方法私有化
    private Singleton(){}

    public static Singleton getInstence(){
        return uniqueInstence;
    }
}
