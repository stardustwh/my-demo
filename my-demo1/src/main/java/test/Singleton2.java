package test;

/**
 * 懒汉式双重加锁版本
 * 比单纯给方法加synchronized关键字减少了时间浪费
 */
public class Singleton2 {

    private volatile static Singleton2 uniqueInstence;

    private Singleton2 (){}

    //没有加入synchronized关键字的懒汉式单例是线程不安全的
    public static Singleton2 getInstence(){
        if(uniqueInstence == null){
            synchronized (Singleton2.class){
                if(uniqueInstence == null){
                    uniqueInstence = new Singleton2();
                }
            }
        }

        return uniqueInstence;
    }
}
